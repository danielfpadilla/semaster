package com.opencv.grabcut.android;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.SurfaceHolder;

class BgSurfaceView extends BgSurfaceBase {
    private Mat mYuv;
    private Mat mRgba;
    private Mat mGraySubmat;
    private Mat mIntermediateMat;
    private Mat mComparisonMat;

    public BgSurfaceView(Context context, BgCamera cls) {
        super(context, cls);
    }

    @Override
    public void surfaceChanged(SurfaceHolder _holder, int format, int width, int height) {
        super.surfaceChanged(_holder, format, width, height);

        synchronized (this) {
            // initialize Mats before usage
            mYuv = new Mat(getFrameHeight() + getFrameHeight() / 2, getFrameWidth(), CvType.CV_8UC1);
            mGraySubmat = mYuv.submat(0, getFrameHeight(), 0, getFrameWidth());

            mRgba = new Mat();
            mIntermediateMat = new Mat();
            mComparisonMat = new Mat();
        }
    }

    @Override
    protected Bitmap processFrame(byte[] data) {
        mYuv.put(0, 0, data);
        Imgproc.cvtColor(mYuv, mRgba, Imgproc.COLOR_YUV420i2RGB, 4);

        /*
            Imgproc.cvtColor(mYuv, mRgba, Imgproc.COLOR_YUV420i2RGB, 4);
            mComparisonMat = Highgui.imread("/mnt/sdcard/DCIM/Camera/IMG_20110727_173249.jpg");
            FindFeatures(mGraySubmat.getNativeObjAddr(), mRgba.getNativeObjAddr(), mComparisonMat.getNativeObjAddr());
        */

        Bitmap bmp = Bitmap.createBitmap(getFrameWidth(), getFrameHeight(), Bitmap.Config.ARGB_8888);

        if (Utils.matToBitmap(mRgba, bmp))
            return bmp;

        bmp.recycle();
        return null;
    }

    @Override
    public void run() {
        super.run();

        synchronized (this) {
            // Explicitly deallocate Mats
            if (mYuv != null)
                mYuv.release();
            if (mRgba != null)
                mRgba.release();
            if (mGraySubmat != null)
                mGraySubmat.release();
            if (mIntermediateMat != null)
                mIntermediateMat.release();
            if (mComparisonMat != null)
                mComparisonMat.release();

            mYuv = null;
            mRgba = null;
            mGraySubmat = null;
            mIntermediateMat = null;
            mComparisonMat = null;
        }
    }

    public native void FindFeatures(long matAddrGr, long matAddrRgba, long matComp);

    static {
        System.loadLibrary("feature_comparison");
    }
}
