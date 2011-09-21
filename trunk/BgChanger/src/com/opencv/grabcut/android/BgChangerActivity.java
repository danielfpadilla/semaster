package com.opencv.grabcut.android;

import java.io.File;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ViewSwitcher.ViewFactory;

public class BgChangerActivity extends Activity implements ViewFactory {
	public static final String SETTINGS = "Pano_Settings";
	private static final String TAG = "PanoForAndroid";

	// persistent settings key's
	private final String SETTINGS_SAVE_PATH = "path";
	private final String SETTINGS_IMAGE_PREFIX = "image";
	private final String SETTINGS_OUTPUT_IMAGE = "output";
	private final String SETTINGS_WARP_TYPE = "warp";
	private final String SETTINGS_MATCH_CONF = "match_conf";
	private final String SETTINGS_CONF_THRESH = "conf_thresh";
	private final String SETTINGS_SHOW_TIP = "show_tip";

	// default settings
	private String mDefaultPath;
	private String mDefaultImagePrefix;
	private String mDefaultOutputName = "result.jpg";
	private String mDefaultWarpType = "spherical";
	private String mDefaultMatchConf = "0.5";
	private String mDefaultConfThresh = "0.8";
	private boolean mDefaultShowTip = true;

	// possible dialogs to open
	public static final int DIALOG_RESULTS = 0;
	public static final int DIALOG_STITCHING = 1;
	public static final int DIALOG_FEATURE_COMPARISON = 2;
	public static final int DIALOG_FEATURE_ALPHA = 3;
	public static final int DIALOG_SUCCESS = 4;
	public static final int DIALOG_ERROR = 5;

	// runtime setting
	private SharedPreferences mSettings;
	private String mDirPath;
	private String mImagePrefix;
	private String mOutputImage;
	private String mWarpType;
	private String mMatchConf;
	private String mConfThresh;
	private String mSubDir = null;
	private boolean mShowTip;

	private String mType = ".jpg";
	public static final String MIME_TYPE = "image/jpg";
	private int mCurrentImage = 1;

	private ImageSwitcher mImageSwitcher;
	private PanoAdapter mPanoAdapter;
	private List<File> mDirectories;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		// Initialize Dynamic Defaults
		mDefaultPath = Environment.getExternalStorageDirectory().toString()
				+ "/" + getResources().getString(R.string.default_folder) + "/";
		mDefaultImagePrefix = getResources().getString(R.string.default_prefix);

		// Initialize Our Settings
		loadSettings(SETTINGS);

		setContentView(R.layout.main);

		// Initialize the gallery view
		mPanoAdapter = new PanoAdapter(this);
		mImageSwitcher = (ImageSwitcher) findViewById(R.id.main_switcher);
		mImageSwitcher.setFactory(this);

		Gallery gallery = (Gallery) findViewById(R.id.main_gallery);
		gallery.setAdapter(mPanoAdapter);
		gallery.setOnItemClickListener(mPanoAdapter);
	}

	/**
	 * Initializes all the settings
	 */
	private boolean loadSettings(String arg) {
		mSettings = getSharedPreferences(arg, Context.MODE_PRIVATE);
		mDirPath = mSettings.getString(SETTINGS_SAVE_PATH, mDefaultPath);
		mImagePrefix = mSettings.getString(SETTINGS_IMAGE_PREFIX,
				mDefaultImagePrefix);
		mOutputImage = mSettings.getString(SETTINGS_OUTPUT_IMAGE,
				mDefaultOutputName);
		mWarpType = mSettings.getString(SETTINGS_WARP_TYPE, mDefaultWarpType);
		mMatchConf = mSettings
				.getString(SETTINGS_MATCH_CONF, mDefaultMatchConf);
		mConfThresh = mSettings.getString(SETTINGS_CONF_THRESH,
				mDefaultConfThresh);
		mShowTip = mSettings.getBoolean(SETTINGS_SHOW_TIP, mDefaultShowTip);
		return true;
	}

	/**
	 * Generates a new folder name, creates the folder, and returns the name
	 */
	private void createNewPano() {
		createNewPano(true);
	}

	private void createNewPano(boolean capture) {
		// generate the default folder name
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
		StringBuilder b = new StringBuilder(df.format(new Date()));

		mSubDir = b.toString() + "/";
		mCurrentImage = 1;

		if (capture) {
			if (mShowTip)
				showDialog(DIALOG_FEATURE_COMPARISON);
			else
				capturePhoto();
		}
	}

	private Intent createCaptureIntent() {
		Log.d(TAG, "New Intent Current Image: " + mCurrentImage);
		if (mSubDir == null)
			createNewPano(false);
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE, Uri
				.fromFile(new File(mDirPath + mSubDir + mImagePrefix
						+ mCurrentImage + mType)), getApplicationContext(),
				BgCamera.class);
		intent.putExtra(BgCamera.EXTRA_DIR_PATH, mDirPath + mSubDir);
		intent.putExtra(BgCamera.EXTRA_FILE_NAME, mImagePrefix + mCurrentImage
				+ mType);
		return intent;
	}

	private void capturePhoto() {
		startActivityForResult(createCaptureIntent(),
				BgCamera.INTENT_TAKE_PICTURE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.layout.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.menu_advanced:
			// Show advanced editor
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == BgCamera.INTENT_TAKE_PICTURE) {
			if (resultCode == RESULT_OK) {
				Log.d(TAG, "Result Ok Current Image: " + mCurrentImage);
				showDialog(DIALOG_RESULTS);
			} else
				return;
		}
	}

	static Bitmap matToBitmap(Mat mat) {
		Bitmap bmap = Bitmap.createBitmap(mat.cols(), mat.rows(),
				Bitmap.Config.ARGB_8888);
		ByteBuffer buffer = ByteBuffer.allocate(4 * bmap.getWidth()
				* bmap.getHeight());
		// opencv.copyMatToBuffer(buffer, mat);
		bmap.copyPixelsFromBuffer(buffer);
		return bmap;
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog;
		AlertDialog.Builder builder;
		switch (id) {
		case DIALOG_FEATURE_COMPARISON:
			Dialog tip = new Dialog(this);
			tip.setContentView(R.layout.tip);
			tip.setTitle(R.string.dialog_tip);
			tip.setCancelable(true);

			dialog = tip;
			break;
		case DIALOG_RESULTS:
			Log.d(TAG, "Dialog Current Image: " + mCurrentImage);
			Dialog progress = new Dialog(this);
			progress.setContentView(R.layout.result);
			progress.setTitle(R.string.dialog_results_title);
			progress.setCancelable(false);

			dialog = progress;
			break;
		case DIALOG_STITCHING:
			ProgressDialog stitching = ProgressDialog.show(
					BgChangerActivity.this, "", getResources().getString(
							R.string.dialog_stitching), true);
			stitching.setCancelable(false);
			dialog = stitching;
			break;
		case DIALOG_ERROR:
			builder = new AlertDialog.Builder(this);
			builder.setMessage(R.string.dialog_error).setCancelable(false)
					.setNegativeButton(R.string.exit,
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
										int which) {
									BgChangerActivity.this.finish();
								}
							});
			dialog = builder.create();
			break;

		default:
			dialog = null;
			break;
		}
		return dialog;
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		switch (id) {
		case DIALOG_RESULTS:
			Log.d(TAG, "Preparing Thumbnail");

			Mat mIntermediate = new Mat();
			Mat mYuv = new Mat();

			Log.d(TAG, "opening [" + mDirPath + mSubDir + mImagePrefix
					+ mCurrentImage + mType + "]");
			mIntermediate = Highgui.imread(mDirPath + mSubDir + mImagePrefix
					+ mCurrentImage + mType);

			Log.d(TAG, "Rotating");
			Core.transpose(mIntermediate, mYuv);
			Core.flip(mYuv, mIntermediate, 1);

			Log.d(TAG, "Resizing");

			Imgproc.resize(mIntermediate, mYuv, new Size(), 0.25, 0.25,
					Imgproc.INTER_AREA);

			/** Currently Broken in OpenCV **/
			/*
			 * Bitmap jpg = Bitmap.createBitmap(mIntermediate.cols(),
			 * mIntermediate.rows(), Bitmap.Config.ARGB_8888);
			 * android.MatToBitmap(mIntermediate, jpg);
			 */
			/** So we resort to this method **/
			Highgui.imwrite(mDirPath + mSubDir + mImagePrefix + mCurrentImage
					+ ".png", mYuv);
			Bitmap jpg = BitmapFactory.decodeFile(mDirPath + mSubDir
					+ mImagePrefix + mCurrentImage + ".png");
			/** **/

			ImageView image = (ImageView) dialog.findViewById(R.id.image);
			image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
			image.setAdjustViewBounds(true);
			image.setPadding(2, 2, 2, 2);
			image.setImageBitmap(jpg);

			Button applyGrabcut = (Button) dialog
					.findViewById(R.id.apply_grabcut);
			applyGrabcut.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					mCurrentImage++;
					modifyImage();

					Intent myIntent = new Intent(BgChangerActivity.this,
							Grabcut.class);
					BgChangerActivity.this.startActivity(myIntent);
				}

				private void modifyImage() {
					Mat mIntermediate = new Mat();
					Mat mYuv = new Mat();

					mIntermediate = Highgui.imread("/mnt/sdcard/gcut.jpg");
					// rotate
					Core.transpose(mIntermediate, mYuv);
					Core.flip(mYuv, mIntermediate, 1);

					// resize
					Imgproc.resize(mIntermediate, mYuv, new Size(), 0.25, 0.25,
							Imgproc.INTER_AREA);

					Highgui.imwrite("/mnt/sdcard/gcut.png", mYuv);
				}
			});
			Button retake = (Button) dialog.findViewById(R.id.retake);

			retake.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					capturePhoto();
				}
			});

			Log.d(TAG, "completed");

			break;
		case DIALOG_SUCCESS:
			final File img = new File(mDirPath + mSubDir + mOutputImage);
			Bitmap result = BitmapFactory.decodeFile(img.getPath());

			ImageView png = (ImageView) dialog.findViewById(R.id.image);
			png.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
			png.setAdjustViewBounds(true);
			png.setPadding(3, 3, 3, 3);
			png.setImageBitmap(result);

			mPanoAdapter.notifyDataSetChanged();

		case DIALOG_FEATURE_COMPARISON:
			CheckBox box = (CheckBox) dialog.findViewById(R.id.show_tip);
			box.setChecked(mShowTip);
			box.setOnClickListener(new OnClickListener() {

				// @Override
				public void onClick(View v) {
					mShowTip = ((CheckBox) v).isChecked();
					SharedPreferences settings = getSharedPreferences(SETTINGS,
							0);
					SharedPreferences.Editor editor = settings.edit();
					editor.putBoolean(SETTINGS_SHOW_TIP, mShowTip);
					editor.commit();
				}
			});

			Button cont = (Button) dialog.findViewById(R.id.tip_continue);
			cont.setOnClickListener(new OnClickListener() {

				// @Override
				public void onClick(View v) {
					capturePhoto();
				}
			});
			break;

		}
	}

	public class PanoAdapter extends BaseAdapter implements OnItemClickListener {
		private Context mContext;
		private int itemBackground;
		private int mGalleryImage;

		PanoAdapter(Context c) {
			mContext = c;

			TypedArray typeArray = obtainStyledAttributes(R.styleable.main_gallery);
			itemBackground = typeArray.getResourceId(
					R.styleable.main_gallery_android_galleryItemBackground, 0);
			typeArray.recycle();
			updateFolders();
		}

	//	@Override
		public int getCount() {
			return mDirectories.size() + 1;
		}

		//@Override
		public Object getItem(int arg0) {
			return arg0;
		}

		//@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		//@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView panos = new ImageView(mContext);
			Bitmap result = null;
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inSampleSize = 8;
			// initialize our new pano image view
			if (position == 0) {
				result = BitmapFactory.decodeResource(getResources(),
						R.drawable.ic_add, options);
			}
			// otherwise initialize the sorted panorama's
			else {
				File f = getDirImage(position - 1);
				if (f != null) {
					result = BitmapFactory.decodeFile(f.getPath(), options);
				}
			}
			panos.setImageBitmap(result);
			panos.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
			panos.setLayoutParams(new Gallery.LayoutParams(150, 150));
			panos.setBackgroundResource(itemBackground);
			return panos;
		}

	//	@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			mGalleryImage = position;
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inSampleSize = 1;
			if (position == 0) {

				createNewPano();
			} else {

				mCurrentImage = getDirCount(position - 1);
				File f = getDirImage(position - 1);
				if (f != null) {
					mSubDir = f.getParentFile().getName() + "/";
					mImageSwitcher.setImageDrawable(new BitmapDrawable(
							BitmapFactory.decodeFile(getDirImage(position - 1)
									.getAbsolutePath(), options)));
				}
			}
		}
	}

	private void updateFolders() {
		File storage = new File(mDirPath);
		File[] contents = storage.listFiles();
		mDirectories = new ArrayList<File>();

		for (int i = 0; i < contents.length; i++) {
			if (contents[i].isDirectory()) {
				mDirectories.add(contents[i]);
			}
		}
	}

	private int getDirCount(int index) {
		File[] contents = mDirectories.get(index).listFiles();
		int hasResult = -1;
		int hasFirst = -1;
		int size = 0;
		for (int i = 0; i < contents.length; i++) {
			if (contents[i].isFile()) {
				if (contents[i].getName().contains("png"))
					size++;
				if (contents[i].getName().equals(mOutputImage))
					hasResult = i;
				else if (contents[i].getName()
						.equals(mImagePrefix + 1 + ".png"))
					hasFirst = i;
			}
		}
		if ((hasResult < 0) && (hasFirst < 0)) {
			return 0;
		}

		if (hasResult >= 0)
			return (size - 1);
		else
			return size;
	}

	private File getDirImage(int index) {
		File[] contents = mDirectories.get(index).listFiles();
		int hasResult = -1;
		int hasFirst = -1;
		for (int i = 0; i < contents.length; i++) {
			if (contents[i].isFile()) {
				if (contents[i].getName().equals(mOutputImage))
					hasResult = i;
				else if (contents[i].getName()
						.equals(mImagePrefix + 1 + ".png"))
					hasFirst = i;
			}
		}
		if ((hasResult < 0) && (hasFirst < 0)) {
			return null;
		}

		if (hasResult >= 0)
			return contents[hasResult];
		else
			return contents[hasFirst];
	}

	//@Override
	public View makeView() {
		ImageView imageView = new ImageView(this);
		imageView.setBackgroundColor(0xFF000000);
		imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		return imageView;
	}

}
