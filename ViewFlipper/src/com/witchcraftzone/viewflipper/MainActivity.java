package com.witchcraftzone.viewflipper;

import com.witchcraftzone.viewflipper.R.drawable;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;


public class MainActivity extends Activity implements OnClickListener {

	private Button mPlayButton, mStopButton;
	private ViewFlipper mViewFlipper;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mViewFlipper = (ViewFlipper) findViewById(R.id.view_flipper_component);
        mPlayButton = (Button) findViewById(R.id.play);
        mStopButton = (Button) findViewById(R.id.stop);
        
        mPlayButton.setOnClickListener(this);
        mStopButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.play:
			if(mViewFlipper.isFlipping()) {
				mViewFlipper.stopFlipping();
				mPlayButton.setBackgroundResource(drawable.ic_media_play);
			} else {
				mViewFlipper.startFlipping();
				mPlayButton.setBackgroundResource(drawable.ic_media_pause);
			}
			break;
		case R.id.stop:
			finish();
			break;
		default:
			break;
		}
		
	}
}
