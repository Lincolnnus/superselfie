package com.example.superselfie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    @Override
    protected void onResume() {
        Intent i = new Intent(this, BackScreenActivity.class);
        startService(i);
        super.onResume();
    }
}
