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
import android.widget.ImageView;

public class FuaaaActivity extends Activity implements View.OnClickListener, Runnable {
	private Button btnFua;
	private int sonido;
	private int img;
	private ImageView imageView;
	private MediaPlayer mp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		sonido = R.raw.fua3;
		btnFua = (Button) findViewById(R.id.button1);
		imageView = (ImageView) findViewById(R.id.ImageView1);
		btnFua.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		imageView.setImageResource(img);
		imageView.setVisibility(ImageView.VISIBLE);
		new Thread(this).start();
	}

	@Override
	public void run() {
		mp = MediaPlayer.create(FuaaaActivity.this, sonido);
		mp.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.principal_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean returnSt = false;
		try {
			item.setChecked(true);
			switch (item.getItemId()) {
			case R.id.MnuOpc11:
				sonido = R.raw.fua3;
				img = R.drawable.bubble_fua;
				returnSt = true;
				break;
			case R.id.MnuOpc12:
				sonido = R.raw.fua1;
				img = R.drawable.bubble_puedo;
				returnSt = true;
				break;
			case R.id.MnuOpc13:
				sonido = R.raw.fua2;
				img = R.drawable.bubble_caracter;
				returnSt = true;
				break;
			case R.id.MnuOpc14:
				sonido = R.raw.fua4;
				img = R.drawable.bubble_fuafua;
				returnSt = true;
				break;
			case R.id.MnuOpc15:
				sonido = R.raw.fua5;
				img = R.drawable.bubble_fuaaa;
				returnSt = true;
				break;
			case R.id.MnuOpc2:
				startActivity(new Intent(Intent.ACTION_VIEW,
						Uri.parse("vnd.youtube://JVept9huYIY")));
				returnSt = true;
				break;
			case R.id.MnuOpc3:
				share();
				returnSt = true;
				break;
			default:
				return super.onOptionsItemSelected(item);
			}
		} catch (Exception e) {
		}
		return returnSt;
	}

	public void share() {
		String subject = "WOW!!!";
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		intent.putExtra(Intent.EXTRA_TEXT,
				"Estoy lanzando un FUAAA!!! de una aplicacion #android hecha por @REDDEMENTES [ruta]");
		startActivity(Intent.createChooser(intent, getString(R.string.share)));
	}
}