package com.example.superselfie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button) findViewById(R.id.btn_custom_view);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){;
        switch (v.getId()){
            case R.id.btn_custom_view:
                startYotaService(BackScreenActivity.class);
                break;
            default:
                break;
        }
    }
    private void startYotaService(Class clazz) {
        startService(new Intent(this, clazz));
    }
}
