package com.example.lockscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

ToggleButton btnToggleLock;
Button btnMisc;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnMisc = (Button) findViewById(R.id.button1);
    btnToggleLock = (ToggleButton) findViewById(R.id.toggleButton1);


    btnToggleLock.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

            if (btnToggleLock.isChecked())
                MainActivity.this.startService(new Intent(
                        MainActivity.this, UpdateService.class));
            else 
                MainActivity.this.stopService(new Intent(MainActivity.this,
                        UpdateService.class));

            
        }
    });

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
 }
}
