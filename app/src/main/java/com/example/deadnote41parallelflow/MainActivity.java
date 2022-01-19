package com.example.deadnote41parallelflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextActivitiesMain;
    Button buttonOpenActivitiesMain;
    public static final String KEY_MESSAGE = "messageKey_1";
    public static final String KEY_MESSAGE2 = "messageKey_2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intentLaunch = new Intent(MainActivity.this, SecondActivity.class);

        editTextActivitiesMain = findViewById(R.id.activity_main__first_edit_text);
        buttonOpenActivitiesMain = findViewById(R.id.activity_main__button_open);
        buttonOpenActivitiesMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageActivitiesMain = "Hello there, " + editTextActivitiesMain.getText();
                // запихиваем сообщение в Bundle
                intentLaunch.putExtra(KEY_MESSAGE, messageActivitiesMain);
                 startActivity(intentLaunch);
            }
        });

        Intent getAnswerSecondActivity = getIntent();
        Bundle extraz = getAnswerSecondActivity.getExtras();
        if (extraz != null){
            String answerMessage = extraz.getString(KEY_MESSAGE);
        editTextActivitiesMain.setText(answerMessage);
        }

    }
}