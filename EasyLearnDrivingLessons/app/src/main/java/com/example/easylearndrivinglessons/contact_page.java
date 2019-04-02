package com.example.easylearndrivinglessons;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.view.MotionEvent;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class contact_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);

        EditText textArea = findViewById(R.id.EmailText);

        textArea.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_UP:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });

        Button startBtn = findViewById(R.id.SendEmailBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    protected void sendEmail() {
        Log.i("Send email", "");
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", " ", null));
        final EditText message = findViewById(R.id.EmailText);

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message.getText().toString());
        startActivity(Intent.createChooser(emailIntent, "Choose an Email Client:"));

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Done sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(contact_page.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

}
