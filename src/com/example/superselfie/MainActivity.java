package com.example.superselfie;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.superselfie.camera.CameraLogic;

public class MainActivity extends Activity {
    private ImageView pic;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button) findViewById(R.id.btn_custom_view);

        btn.setOnClickListener(new OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Toast.makeText(MainActivity.this, "onClick", Toast.LENGTH_LONG).show();
                                       startYotaService(BackScreenActivity.class);
                                   }
                               }
        );

        // pic = (ImageView)findViewById(R.id.imagePreview);
        CameraLogic cameraLogic = new CameraLogic(this, new CameraLogic.PictureDataListener() {

            @Override
            public void onData(byte[] data) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                pic.setImageBitmap(bitmap);
            }
        });

        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(cameraLogic.getPreview());

        System.out.println("Created");

        // Button captureButton = (Button) findViewById(R.id.button_capture);
        // captureButton.setOnClickListener(cameraLogic.onClickListener);
    }

    private void startYotaService(Class clazz) {
        startService(new Intent(this, clazz));
    }
}
