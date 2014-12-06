package com.example.superselfie.camera;

/**
 * Created by shaohuanli on 7/12/14.
 */
import android.hardware.Camera;
import android.view.View;
import android.widget.Toast;
import com.example.superselfie.MainActivity;

/**
 * Created by yangsong on 6/12/14.
 */
public class CameraLogic {
    private MainActivity act = null;
    private Camera cameraObject;

    private CameraPreview cameraPreview;

    private boolean canTakePic = true;
    private View preview;

    public CameraLogic(MainActivity _act, PictureDataListener pictureDataListener){
        this.act = _act;
        this.picktureTakenListener = pictureDataListener;

        cameraObject = getCameraInstance();
        cameraPreview = new CameraPreview(act, cameraObject);
    }


    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (canTakePic && cameraObject != null) {
                canTakePic = false;
                cameraObject.takePicture(null, null, pictureCallback);
            } else {
                Toast.makeText(act, "Please wait for camera to get ready", Toast.LENGTH_SHORT);
            }
        }
    };

    public static Camera getCameraInstance(){
        Camera object = null;
        try {
            object = Camera.open();
        }
        catch (Exception e){
            System.out.println("Got Exception when opening camera");
        }
        return object;
    }

    public View getPreview() {
        return cameraPreview;
    }

    public static interface PictureDataListener {
        void onData(byte[] data);
    }
    public PictureDataListener picktureTakenListener;

    private Camera.PictureCallback pictureCallback = new Camera.PictureCallback() {


        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            picktureTakenListener.onData(data);

            startPreview(camera);

//            File picFile = new File("/sdcard/DCIM/hackathon.jpg");
//
//            if(picFile == null){
//                System.out.println("Err.. fail to open media file.");
//                return;
//            }
//
//            try{
//                FileOutputStream fos = new FileOutputStream(picFile);
//                fos.write(data);
//                fos.close();
//            } catch (FileNotFoundException e){
//                System.err.println("File Not Found.");
//            } catch (IOException e){
//                System.err.println("Error accessing file.");
//            }
        }
    };

    private void startPreview(Camera camera) {
        camera.startPreview();
        canTakePic = true;
    }
}
