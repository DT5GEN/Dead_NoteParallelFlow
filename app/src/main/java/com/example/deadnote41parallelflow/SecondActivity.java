package com.example.deadnote41parallelflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText editTextActivitiesSecond;
    Button buttonAnswerActivitiesSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTextActivitiesSecond = findViewById(R.id.activity_second__first_edit_text);
        buttonAnswerActivitiesSecond = findViewById(R.id.activity_second__button_answer);

        Intent intentSecondActivities = getIntent();
        Bundle extrasMainActivity = intentSecondActivities.getExtras();

        if (extrasMainActivity != null) {
            String messageExtras = extrasMainActivity.getString(MainActivity.KEY_MESSAGE);
            editTextActivitiesSecond.setText(messageExtras);

        } else {
            editTextActivitiesSecond.setText("Error");
        }
    }
}