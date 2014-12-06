package com.example.superselfie.camera;

/**
 * Created by shaohuanli on 7/12/14.
 */
import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder surfaceHolder;
    private Camera camera;

    public CameraPreview(Context context, Camera camera) {
        super(context);
        this.camera = camera;
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
        System.out.println("Surface Changed.");

        if (surfaceHolder.getSurface() == null){
            // preview surface does not exist
            return;
        }

        // stop preview before making changes
//        try {
//            camera.stopPreview();
//        } catch (Exception e){
//            System.out.println("Preview stopped, because of excaption");
//            e.printStackTrace();
//        }
//
//        // set preview size and make any resize, rotate or
//        // reformatting changes here

        // start preview with new settings
        try {
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();

            System.out.println("Preview restarted");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try   {
            camera.setPreviewDisplay(holder);
            camera.startPreview();
            System.out.println("Surface Created, in normal");
            System.err.println("Surface Created, in bugging");
        } catch (IOException e) {
            System.err.println("Exception happened when init surface");
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {
        System.out.println("Surface Destroyed.");
    }

}
