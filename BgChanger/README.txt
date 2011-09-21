# Run 
sh project-create.sh

# Download OpenCV-2.3.1
wget http://downloads.sourceforge.net/project/opencvlibrary/opencv-android/2.3/OpenCV-2.3.1-beta1-android-bin.tar.bz2

# extract OpenCV-2.3.1 to the parent folder of this checkout, ie
# ls
#     OpenCV-2.3.1
#     pano-for-android

# You can modity default.properties to point to a different (needs to be
# relative) path if you need.

export OPENCV_PACKAGE_DIR=/absolute/path/to/OpenCV-2.3.1

# Run
ndk-build

# this is necessary to remove duplicates being generated causing compiler error
rm libs/armeabi-v7a/libnative_camera_r2.*

# Compile and install
# ant / ant compile / ant debug / ant debug install


# If you want to use Eclipse please follow this guide
# http://opencv.willowgarage.com/wiki/AndroidPrebuiltOpenCV231
