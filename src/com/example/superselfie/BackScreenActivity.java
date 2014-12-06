package com.example.superselfie;

import android.view.View;
import com.yotadevices.sdk.BSActivity;

/**
 * Created by shaohuanli on 6/12/14.
 */
public class BackScreenActivity extends BSActivity {

    protected void onBSCreate() {
        super.onBSCreate();
        View v = getBSDrawer().getBSLayoutInflater().inflate(R.layout.selfie_view, null);
        setBSContentView(v);
    }
}
