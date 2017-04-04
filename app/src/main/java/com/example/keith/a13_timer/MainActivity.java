package com.example.keith.a13_timer;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final long TWO_SECONDS = 5000;
    private static final int MY_PERSONAL_CODE = 42;
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmMgr = (AlarmManager)getSystemService(this.ALARM_SERVICE);

    }

    public void startTimer(View view) {
        Intent myIntent = new Intent(this,AlarmAct.class);
        alarmIntent = PendingIntent.getActivity(getApplicationContext(), MY_PERSONAL_CODE, myIntent,PendingIntent.FLAG_ONE_SHOT);

        alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime()+ TWO_SECONDS,alarmIntent);

    }

    public void stopTimer(View view) {
        if (alarmMgr != null)
            alarmMgr.cancel(alarmIntent);
    }
}
