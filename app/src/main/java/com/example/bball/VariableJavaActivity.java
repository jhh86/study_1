package com.example.bball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.ClientInfoStatus;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class VariableJavaActivity extends AppCompatActivity {

    int clickCount = 0;
    long startTime = System.currentTimeMillis();
    TextView startTimeLable;
    TextView clickCountLable;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_variable);

        startTimeLable = findViewById(R.id.startTimeLabel);
        clickCountLable = findViewById(R.id.clickCountLable);

        button = findViewById(R.id.button);

        String timeText = new SimpleDateFormat("HH:mm:ss", Locale.KOREA).format(startTime);

        startTimeLable.setText("Activity 시작시간 : " + timeText);
        clickCountLable.setText("click 횟수 : " + clickCount) ;

        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                clickCount = clickCount + 1;

                clickCountLable.setText("click 횟수 : " + clickCount);
            }

        });

    }
}
