/*
 * MainActivity.java
 * Creation at : 17 oct. 2013 23:38:46
*/
package org.roundpicker.roundpickerapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/**
 * @author Valentin BASTIEN
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
