package com.example.admin.dta_android_tp8;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numero = (EditText) findViewById(R.id.eT_phone_number);
        final EditText message_text = (EditText) findViewById(R.id.eT_message_content);

        Button bouton_send = (Button) findViewById(R.id.button);

        bouton_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Code to send the sms directly from the app MUST HAVE PERMISSION ENABLED
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(numero.getText().toString(), null, message_text.getText().toString(), null, null);
                
                // Code to call the sms application of the phone
                /*String uri = "smsto:" + numero.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(uri));
                intent.putExtra("sms_body", message_text.getText().toString());
                startActivity(intent);*/
            }

        });

    }
}
