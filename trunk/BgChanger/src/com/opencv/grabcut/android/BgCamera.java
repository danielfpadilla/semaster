package com.opencv.grabcut.android;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class BgCamera extends Activity {
    private static final String TAG                   = "PanoCamera";
    public static final String  EXTRA_DIR_PATH        = "dirPath";
    public static final String  EXTRA_FILE_NAME       = "name";

    public static final int     INTENT_TAKE_PICTURE   = 0;

    private String              mDirPath;
    private String              mFileName;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(new BgSurfaceView(this, this));

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mDirPath = extras.getString(BgCamera.EXTRA_DIR_PATH);
            mFileName = extras.getString(BgCamera.EXTRA_FILE_NAME);
        }
        Log.d(TAG, mDirPath);
        Log.d(TAG, mFileName);
    }

    /**
     * Writes photo jpeg data to sdcard
     */
    class SavePhotoTask extends AsyncTask<byte[], Void, Void> {
        @Override
        protected Void doInBackground(byte[]... data) {
            /* file save format currently looks like photo-20110602133259329.jpg
             */
            for (int i = 0; i < data.length; i++) {
                File dir = new File(mDirPath);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File photo = new File(mDirPath, mFileName);

                if (photo.exists()) {
                    photo.delete();
                }
                Log.i(TAG, "File Output " + photo.getAbsolutePath());

                try {
                    FileOutputStream fos = new FileOutputStream(photo.getPath()); //
                    fos.write(data[0]);
                    fos.close();     
                    
                    fos = new FileOutputStream("/mnt/sdcard/gcut.jpg"); //photo.getPath()
                    fos.write(data[0]);
                    fos.close();       
                } catch (java.io.IOException e) {
                    Log.e(TAG, "unable to save image photo to sd card:" + e.getMessage());
                }
            }

            return null;
        }

        /**
         *
         */
        @Override
        protected void onPostExecute(Void v) {
            setResult(Activity.RESULT_OK, new Intent());
            finish();
        }
    }
}
