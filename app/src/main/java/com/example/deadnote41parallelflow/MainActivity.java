package com.example.deadnote41parallelflow;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private  String TAG = "Happy LOG - ";
    EditText editTextActivitiesMain;
    Button buttonOpenActivitiesMain;
    public static final String KEY_MESSAGE = "messageKey_1";
    public static final String KEY_MESSAGE2 = "messageKey_2";
    public static final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /*
        final Intent intentLaunch = new Intent(MainActivity.this, SecondActivity.class);

        editTextActivitiesMain = findViewById(R.id.activity_main__first_edit_text);
        buttonOpenActivitiesMain = findViewById(R.id.activity_main__button_open);
        buttonOpenActivitiesMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageActivitiesMain = "Hello there, " + editTextActivitiesMain.getText();
                Message messageObj = new Message();
                messageObj.setSmsMessage(messageActivitiesMain);
                // запихиваем сообщение в Bundle
                intentLaunch.putExtra(KEY_MESSAGE, messageObj);
              //   startActivity(intentLaunch);
                startActivityForResult(intentLaunch, REQUEST_CODE);
            }
        });

        Intent getAnswerSecondActivity = getIntent();
        Bundle extraz = getAnswerSecondActivity.getExtras();
        if (extraz != null){
            String answerMessage = extraz.getString(KEY_MESSAGE);
        editTextActivitiesMain.setText(answerMessage);

        }
*/

        Log.d(TAG, MimeTypeMap.getSingleton().getMimeTypeFromExtension("txt"));
        Log.d(TAG, MimeTypeMap.getSingleton().getMimeTypeFromExtension("jpg"));
        Log.d(TAG, MimeTypeMap.getSingleton().getMimeTypeFromExtension("bmp"));
        Log.d(TAG, MimeTypeMap.getSingleton().getMimeTypeFromExtension("tif"));
        Log.d(TAG, MimeTypeMap.getSingleton().getMimeTypeFromExtension("mp3"));
        Log.d(TAG, MimeTypeMap.getSingleton().getMimeTypeFromExtension("webp"));
        Log.d(TAG, MimeTypeMap.getSingleton().getMimeTypeFromExtension("svg"));


        editTextActivitiesMain = findViewById(R.id.activity_main__first_edit_text);
        buttonOpenActivitiesMain = findViewById(R.id.activity_main__button_open);
        buttonOpenActivitiesMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "subject");
                i.putExtra(Intent.EXTRA_TEXT, "text text text ");
              //  i.setData(Uri.parse("mailto:"));
                startActivity(i);
            }

        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK)
        if (requestCode == REQUEST_CODE){
            String answerMessageAOR = data.getExtras().getString(KEY_MESSAGE);
            editTextActivitiesMain.setText(" " + answerMessageAOR);
        }
    }
}