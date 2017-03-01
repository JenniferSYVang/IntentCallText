package jvang.cs.cis3334.intentcalltext;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button callContact1btn;
    Button textContact1btn;
    TextView tvContact1NameNum;
    Spinner textOptions;
    Button callContact2btn;
    Button textContact2btn;
    TextView tvContact2NameNum;
    Spinner textOptions2;
    Button callContact3btn;
    Button textContact3btn;
    TextView tvContact3NameNum;
    Spinner textOptions3;
    String[] contactNames;
    String[] phoneNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactNames = getResources().getStringArray(R.array.contact_names);
        phoneNumbers = getResources().getStringArray(R.array.phone_numbers);

        tvContact1NameNum = (TextView) findViewById(R.id.textViewContact1);
        tvContact1NameNum.setText(contactNames[0] + " :     " + phoneNumbers[0]);
        textOptions = (Spinner) findViewById(R.id.spinnerText1);

        tvContact2NameNum = (TextView) findViewById(R.id.textViewContact2);
        tvContact2NameNum.setText(contactNames[1] + " :     " + phoneNumbers[1]);
        textOptions2 = (Spinner) findViewById(R.id.spinnerText2);

        tvContact3NameNum = (TextView) findViewById(R.id.textViewContact3);
        tvContact3NameNum.setText(contactNames[2] + " :     " + phoneNumbers[2]);
        textOptions3 = (Spinner) findViewById(R.id.spinnerText3);

        setupButtonClickEvents();
    }

    private void setupButtonClickEvents() {
        callContact1btn = (Button) findViewById(R.id.buttonCall1);
        callContact1btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phoneNumbers[0]));
                if (callIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(callIntent);
                }
            }
        });

        textContact1btn = (Button) findViewById(R.id.buttonText1);
        textContact1btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:" + phoneNumbers[0]));
                sendIntent.putExtra("sms_body", textOptions.getSelectedItem().toString());
                startActivity(sendIntent);
            }
        });

        callContact2btn = (Button) findViewById(R.id.buttonCall2);
        callContact2btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent call2Intent = new Intent(Intent.ACTION_DIAL);
                call2Intent.setData(Uri.parse("tel:" + phoneNumbers[1]));
                if (call2Intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(call2Intent);
                }
            }
        });

        textContact2btn = (Button) findViewById(R.id.buttonText2);
        textContact2btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent send2Intent = new Intent(Intent.ACTION_VIEW);
                send2Intent.setData(Uri.parse("sms:" + phoneNumbers[1]));
                send2Intent.putExtra("sms_body", textOptions2.getSelectedItem().toString());
                startActivity(send2Intent);
            }
        });

        callContact3btn = (Button) findViewById(R.id.buttonCall3);
        callContact3btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent call3Intent = new Intent(Intent.ACTION_DIAL);
                call3Intent.setData(Uri.parse("tel:" + phoneNumbers[2]));
                if (call3Intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(call3Intent);
                }
            }
        });

        textContact3btn = (Button) findViewById(R.id.buttonText3);
        textContact3btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:" + phoneNumbers[2]));
                sendIntent.putExtra("sms_body", textOptions3.getSelectedItem().toString());
                startActivity(sendIntent);
            }
        });
    }

}
