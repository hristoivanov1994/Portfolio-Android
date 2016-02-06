package com.example.hristo.toggletraning;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import java.util.Random;


public class DiscoMode extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_disco);
        final ToggleButton tgb = (ToggleButton) findViewById(R.id.tgButton);
        final  GradientDrawable drawable = new GradientDrawable();
        RelativeLayout r = (RelativeLayout)findViewById(R.id.rl);
        r.setBackgroundColor(Color.GRAY);
        tgb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            CountDownTimer timer;
            Random r = new Random();
            RelativeLayout rl = (RelativeLayout)findViewById(R.id.rl);
            @Override
            public void onCheckedChanged(final CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                 timer = new CountDownTimer(10000,100) {
                     @Override
                     public void onTick(long millisUntilFinished) {


                         drawable.setShape(GradientDrawable.OVAL);
                         drawable.setStroke(5, Color.argb(255,135,135,135));
                         drawable.setColor(Color.argb(255,r.nextInt(256),r.nextInt(256),r.nextInt(256)));
                         tgb.setBackgroundDrawable(drawable);
                         rl.setBackgroundColor(Color.argb(255,r.nextInt(256),r.nextInt(256),r.nextInt(256)));
                     }

                     @Override
                     public void onFinish() {

                        timer.start();
                     }
                 }.start();
                }
                else {
                    tgb.setBackgroundDrawable(getResources().getDrawable(R.drawable.offcirclebutton));
                    timer.cancel();
                    rl.setBackgroundColor(Color.GRAY);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
