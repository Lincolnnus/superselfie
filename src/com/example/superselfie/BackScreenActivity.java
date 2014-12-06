package com.example.superselfie;

import com.yotadevices.sdk.BSActivity;

/**
 * Created by shaohuanli on 6/12/14.
 */
public class BackScreenActivity extends BSActivity {

        @Override
        protected void onBSCreate() {
            super.onBSCreate();
            setBSContentView(R.layout.main);
        }
}
