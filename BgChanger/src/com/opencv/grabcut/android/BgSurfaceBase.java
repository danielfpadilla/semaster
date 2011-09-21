package com.opencv.grabcut.android;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class BgSurfaceBase extends SurfaceView implements SurfaceHolder.Callback, Runnable, OnClickListener {
    private static final String TAG = "PanoSurfaceBase";

    private Camera              mCamera;
    private SurfaceHolder       mHolder;
    private int                 mFrameWidth;
    private int                 mFrameHeight;
    private byte[]              mFrame;
    private boolean             mThreadRun;
    private boolean             mCapturing;
    private BgCamera          mPanoClass;

    public BgSurfaceBase(Context context, BgCamera cls) {
        super(context);
        mPanoClass = cls;
        
        mHolder = getHolder();
        mHolder.addCallback(this);
        Log.i(TAG, "Instantiated new " + this.getClass());
    }

    public int getFrameWidth() {
        return mFrameWidth;
    }

    public int getFrameHeight() {
        return mFrameHeight;
    }

    public void surfaceChanged(SurfaceHolder _holder, int format, int width, int height) {
        Log.i(TAG, "surfaceChanged");
        if (mCamera != null) {
            Camera.Parameters params = mCamera.getParameters();
            List<Camera.Size> sizes = params.getSupportedPreviewSizes();
            mFrameWidth = width;
            mFrameHeight = height;

            // selecting optimal camera preview size
            {
                double minDiff = Double.MAX_VALUE;
                for (Camera.Size size : sizes) {
                    if (Math.abs(size.height - height) < minDiff) {
                        mFrameWidth = size.width;
                        mFrameHeight = size.height;
                        minDiff = Math.abs(size.height - height);
                    }
                }
            }
            params.setPreviewSize(getFrameWidth(), getFrameHeight());
            mCamera.setParameters(params);
            mCamera.startPreview();
        }
    }

    public void surfaceCreated(SurfaceHolder holder) {
        Log.i(TAG, "surfaceCreated");
        this.setOnClickListener(this);
        mCapturing = false;
        mCamera = Camera.open();
        mCamera.setPreviewCallback(new PreviewCallback() {
            public void onPreviewFrame(byte[] data, Camera camera) {
                synchronized (BgSurfaceBase.this) {
                    mFrame = data;
                    BgSurfaceBase.this.notify();
                }
            }
        });
        (new Thread(this)).start();
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.i(TAG, "surfaceDestroyed");
        mThreadRun = false;
        if (mCamera != null) {
            synchronized (this) {
                mCamera.stopPreview();
                mCamera.setPreviewCallback(null);
                mCamera.release();
                mCamera = null;
            }
        }
    }

    protected abstract Bitmap processFrame(byte[] data);

    public void run() {
        mThreadRun = true;
        Log.i(TAG, "Starting processing thread");
        while (mThreadRun) {
            Bitmap bmp = null;

            synchronized (this) {
                try {
                    this.wait();
                    bmp = processFrame(mFrame);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (bmp != null) {
                Canvas canvas = mHolder.lockCanvas();
                if (canvas != null) {
                    canvas.drawBitmap(bmp, (canvas.getWidth() - getFrameWidth()) / 2, (canvas.getHeight() - getFrameHeight()) / 2, null);
                    mHolder.unlockCanvasAndPost(canvas);
                }
                bmp.recycle();
            }
        }
    }
    Camera.ShutterCallback sC = new Camera.ShutterCallback() {

        public void onShutter() {
            // TODO Auto-generated method stub
            Log.d(TAG, "Shutter");
        }
    };

    Camera.PictureCallback rC = new Camera.PictureCallback() {

        public void onPictureTaken(byte[] data, Camera camera) {
            // TODO Auto-generated method stub
            Log.d(TAG, "Raw Callback");
        }
    };

    Camera.PictureCallback jpegCallback = new Camera.PictureCallback() {

        public void onPictureTaken(byte[] data, Camera camera) {
            Log.d(TAG, "JPG Callback");
            mPanoClass.new SavePhotoTask().execute(data);
        }
    };

    public void onClick(View v) {
        Log.d(TAG, "On Screen Click");
        if ((mCamera != null) && (!mCapturing)) {
            mCapturing = true;
            mCamera.stopPreview();
            mCamera.setPreviewCallback(null);
            try {
                mCamera.setPreviewDisplay(null);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            mCamera.startPreview();
            Log.d(TAG, "We have A Camera");
            mCamera.takePicture(sC, null, jpegCallback);
        }
    }
}
