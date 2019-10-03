package com.example.worldclockassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private Button rightbutt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DateFormat df = new SimpleDateFormat("hh:mm a");

        TimeZone sydtime = TimeZone.getTimeZone("Australia/Sydney");
        TextView timeSydney = findViewById(R.id.editText1);
        Calendar sydcal = Calendar.getInstance(sydtime);
        df.setCalendar(sydcal);
        df.setTimeZone(sydtime);
        String sx = df.format(sydcal.getTime());
        timeSydney.setText(sx);

        //No Beijing specific java timezoneid
        TimeZone bjtime = TimeZone.getTimeZone("Asia/Shanghai");
        TextView timeBeijing = findViewById(R.id.editText2);
        Calendar bjcal = Calendar.getInstance(bjtime);
        df.setCalendar(bjcal);
        df.setTimeZone(bjtime);
        String bx = df.format(bjcal.getTime());
        timeBeijing.setText(bx);

        TimeZone mctime = TimeZone.getTimeZone("Europe/Moscow");
        TextView timeMoscow = findViewById(R.id.editText3);
        Calendar mccal = Calendar.getInstance(mctime);
        df.setCalendar(mccal);
        df.setTimeZone(mctime);
        String mx = df.format(mccal.getTime());
        timeMoscow.setText(mx);

        TimeZone lontime = TimeZone.getTimeZone("Europe/London");
        TextView timeLondon = findViewById(R.id.editText4);
        Calendar loncal = Calendar.getInstance(lontime);
        df.setCalendar(loncal);
        df.setTimeZone(lontime);
        String lx = df.format(loncal.getTime());
        timeLondon.setText(lx);

        TimeZone nytime = TimeZone.getTimeZone("America/New_York");
        TextView timeNewyork = findViewById(R.id.editText5);
        Calendar nycal = Calendar.getInstance(nytime);
        df.setCalendar(nycal);
        df.setTimeZone(nytime);
        String nx = df.format(nycal.getTime());
        timeNewyork.setText(nx);

        //Cant find greenwich tzid
        TimeZone gretime = TimeZone.getTimeZone("Atlantic/Reykjavik");
        TextView timeGreenwich = findViewById(R.id.editText6);
        Calendar grecal = Calendar.getInstance(gretime);
        df.setCalendar(grecal);
        df.setTimeZone(gretime);
        String gx = df.format(grecal.getTime());
        timeGreenwich.setText(gx);


        /*TextView timeBeijing = findViewById(R.id.editText2);
        timeBeijing.setText(tzone(8));

        TextView timeMoscow = findViewById(R.id.editText3);
        timeMoscow.setText(tzone(3));

        TextView timeLondon = findViewById(R.id.editText4);
        timeLondon.setText(tzone(1));

        TextView timeNewyork = findViewById(R.id.editText5);
        timeNewyork.setText(tzone(-4));

        TextView timeGreenwich = findViewById(R.id.editText6);
        timeGreenwich.setText(tzone(0));
        */
        rightbutt = findViewById(R.id.buttonright);
        rightbutt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switchToOverlay24();
            }
        });

    }


    private void switchToOverlay24(){
        Intent intent = new Intent(MainActivity.this, OverlayActivity.class);
        startActivity(intent);

    }
    /*
    public static String tzone(int num){

        //Get GMT time + timezone differential
        TimeZone timezone = TimeZone.getTimeZone("GMT"+num);

        Calendar cal = Calendar.getInstance(timezone);
        //setting time format for 12hr clock
        DateFormat df = new SimpleDateFormat("hh:mm a");
        df.setCalendar(cal);
        df.setTimeZone(timezone);
        //outputs time in string format by parsing the time through dateformat
        String x = df.format(cal.getTime());
        return x;

        /*
        DateFormat df = new SimpleDateFormat("hh:mm a");
        df.setTimeZone(timezone);
        Calendar c = Calendar.getInstance();
        df.setCalendar(c);
        int min = c.get(Calendar.MINUTE);
        int hour=c.get(Calendar.HOUR);
        String test = String.valueOf(hour)+num+":"+String.valueOf(min);

        return test;

    }*/


}

