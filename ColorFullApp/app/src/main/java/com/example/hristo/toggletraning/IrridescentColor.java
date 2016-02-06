package com.example.hristo.toggletraning;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;


public class IrridescentColor extends ActionBarActivity {
    boolean c1b = false;
    boolean c2b = false;
    boolean c3b = false;
    Random rnd = new Random();
    int c1 = 30;
    int c2 = 25;
    int c3 = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_irridescent_color);
        ToggleButton tgb = (ToggleButton) findViewById(R.id.tgButton2);
        RelativeLayout r = (RelativeLayout)findViewById(R.id.rel2);
        r.setBackgroundColor(Color.GRAY);
        tgb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            CountDownTimer timer;
            Random r = new Random();

            TextView txt1;//Color to text (HEX and RGB) on the screen
            String txt;//First text
            String sub;//Substring of txt
            RelativeLayout rl = (RelativeLayout)findViewById(R.id.rel2);
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    timer = new CountDownTimer(10000,40) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                            c1b = isBetween(c1,c1b);
                            c2b = isBetween(c2,c2b);
                            c3b = isBetween(c3,c3b);

                            c1 = iteration(c1b,c1);
                            c2 = iteration(c2b,c2);
                            c3 = iteration(c3b,c3);


                            int color = Color.argb(255, c1, c2, c3);//Color to int
                            rl.setBackgroundColor(color);//Setting layout background color
                        }

                        @Override
                        public void onFinish() {

                            timer.start();
                        }
                    }.start();
                }
                else {
                    timer.cancel();
                    rl.setBackgroundColor(Color.GRAY);
                }
            }
        });
    }
    int iteration(boolean b, int c)//if the color gets to 255 return with decrementing and opposite
    {

        if(b)
            c-=rnd.nextInt(20);
        if(!b)
            c+=rnd.nextInt(20);
        return c;
    }
    boolean isBetween(int c,boolean is_between)//Check if color is bigger than 255 or smaller than 0
    {

        if(c >=235)
        {
            c=250;
            is_between=true;
        }
        if(c<=150)
        {
            c=150+rnd.nextInt(11);
            is_between = false;
        }
        return is_between;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_irridescent_color, menu);
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
