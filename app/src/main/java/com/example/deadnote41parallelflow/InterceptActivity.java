package com.example.deadnote41parallelflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class InterceptActivity extends AppCompatActivity {

    EditText editTextActivitiesIntercept;
    Button buttonAnswerActivitiesIntercept;
    ImageView imageIntercept;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intercept);

        editTextActivitiesIntercept = findViewById(R.id.activity_intercept__first_edit_text);
        buttonAnswerActivitiesIntercept = findViewById(R.id.activity_intercept__button_answer);
        imageIntercept = findViewById(R.id.activity_intercept__image_view);

        Intent intentInterceptorActivities = getIntent();
        String action = intentInterceptorActivities.getAction();
        String type = intentInterceptorActivities.getType();

        Bundle extrasMainActivity = intentInterceptorActivities.getExtras();

        if (action.equals(Intent.ACTION_SEND)){
            if (type.startsWith("image/")){
                imageIntercept.setImageURI(extrasMainActivity.getParcelable(Intent.EXTRA_STREAM));
            } else if (type.startsWith("text/")){
                String subjectFromMain = extrasMainActivity.getString(Intent.EXTRA_SUBJECT);
                String textFromMain = extrasMainActivity.getString(Intent.EXTRA_TEXT);

                editTextActivitiesIntercept.setText(String.format("%s %s", subjectFromMain, textFromMain));

            }
        }


    }
}