package com.example.superselfie;

/**
 * Created by shaohuanli on 7/12/14.
 */
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class Previewer extends Activity{
    int viewIds[] = new int[]{
            R.id.imageView1, R.id.imageView2, R.id.imageView3, R.id.imageView4,
            R.id.imageView5, R.id.imageView6, R.id.imageView7, R.id.imageView8,
            R.id.imageView9, R.id.imageView10, R.id.imageView11, R.id.imageView12,
            R.id.imageView13, R.id.imageView14, R.id.imageView15, R.id.imageView16,
    };
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_views);

        int imgVal = R.drawable.selie_300x400;

        setViews(imgVal, 10);
    }

    private void setViews(int imgVal, int skipId) {
        for(int i = 0 ; i < viewIds.length ; i++){
            if(i != skipId){
                setImageView(viewIds[i], imgVal);
            }
        }
    }

    private void setImageView(int viewId, int resId){
        ImageView iv = (ImageView) findViewById(viewId);
        iv.setImageResource(resId);
    }
}
