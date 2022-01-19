package com.example.deadnote41parallelflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        // достаём интент
        Intent intentSecondActivities = getIntent();
        Bundle extrasMainActivity = intentSecondActivities.getExtras();


        buttonAnswerActivitiesSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLaunchSecond = new Intent(SecondActivity.this, MainActivity.class);
                String messageActivitiesSecond = "Hello again, " + editTextActivitiesSecond.getText();
                // запихиваем сообщение в Bundle
                intentLaunchSecond.putExtra(MainActivity.KEY_MESSAGE, messageActivitiesSecond);
                startActivity(intentLaunchSecond);
            }
        });

        if (extrasMainActivity != null) { //если бандл не пустой
            String messageExtras = extrasMainActivity.getString(MainActivity.KEY_MESSAGE);
            editTextActivitiesSecond.setText(messageExtras);

        } else {
            editTextActivitiesSecond.setText("Error");
        }
    }
}