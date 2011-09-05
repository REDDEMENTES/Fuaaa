package com.reddementes.fua;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FuaaaActivity extends Activity {
    private ImageButton btnFua;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btnFua = (ImageButton) findViewById(R.id.button1);
		btnFua.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				btnFua.setImageResource(R.drawable.pusheado);
				new Thread(new Runnable() {
					@Override
					public void run() {
						MediaPlayer mp = MediaPlayer.create(FuaaaActivity.this, R.raw.fua1);
						mp.start();
						while (mp.isPlaying()) {
						}
						btnFua.setImageResource(R.drawable.boton);
					}
				}).start();
			}
		});
	}
}