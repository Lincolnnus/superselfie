package com.example.superselfie;

import android.view.View;
import android.widget.Toast;
import com.yotadevices.sdk.BSActivity;

/**
 * Created by shaohuanli on 6/12/14.
 */
public class BackScreenActivity extends BSActivity {

    protected void onBSCreate() {
        Toast.makeText(this, "onBSCreate", Toast.LENGTH_LONG).show();
        System.out.print("BS created");
        super.onBSCreate();
        View v = getBSDrawer().getBSLayoutInflater().inflate(R.layout.selfie_view, null);
        setBSContentView(v);
    }
}
