package com.reddementes.fua;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class FuaaaActivity extends Activity {
	private Button btnFua;
	private String srcAudio = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		btnFua = (Button) findViewById(R.id.button1);
		btnFua.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Thread x = new Thread(new Runnable() {
					@Override
					public void run() {
						MediaPlayer mp = MediaPlayer.create(FuaaaActivity.this,
								R.raw.fua1);
						mp.start();
						while (mp.isPlaying()) {
						}
					}
				});
				x.start();
				// btnFua.setImageResource(R.drawable.boton);
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.principal_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean returnSt=false;
		try {
			switch (item.getItemId()) {
			case R.id.MnuOpc11:
				srcAudio = "Fua";
				returnSt = true;
				break;
			case R.id.MnuOpc12:
				srcAudio = "Fua2";
				returnSt = true;
				break;
			case R.id.MnuOpc13:
				srcAudio = "Fua3";
				returnSt = true;
				break;
			case R.id.MnuOpc2:
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("vnd.youtube://JVept9huYIY")));
				returnSt = true;
				break;
			case R.id.MnuOpc3:
				srcAudio = "Compartir";
				returnSt = true;
				break;
			default:
				return super.onOptionsItemSelected(item);
			}
		} catch (Exception e) {
			
		}
		return returnSt;

	}

	private void goVideo() {
		Intent intent = new Intent(Intent.ACTION_VIEW,
				Uri.parse("vnd.youtube://JVept9huYIY"));
		startActivity(intent);
	}
}