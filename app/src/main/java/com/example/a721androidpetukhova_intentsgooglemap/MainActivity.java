package com.example.a721androidpetukhova_intentsgooglemap;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTxt;
    String editTxtS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxt = findViewById(R.id.editTxt);
        editTxtS = editTxt.getText().toString();
        btnListener();
    }


    private void btnListener() {

        findViewById(R.id.btnSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char[] chs = editTxt.getText().toString().toCharArray();
                for (char ch : chs) {
                    if (Character.isLetter(ch)) {
                        Uri.Builder builderAddress = new Uri.Builder();
                        builderAddress.scheme("geo")
                                .appendPath("0,0")
                                .appendQueryParameter("q", editTxt.getText().toString());
                        Uri addressUri = builderAddress.build();
                        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
                        startActivity(intent);
                    } else {
                        Uri geoLocation = Uri.parse("geo:0,0?").buildUpon()
                                .appendQueryParameter("q", editTxt.getText().toString()).build();
                        Intent intent = new Intent(Intent.ACTION_VIEW, geoLocation);
                        startActivity(intent);
                    }
                }

            }

        });
    }

}