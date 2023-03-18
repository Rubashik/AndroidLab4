package com.example.lab4;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class PhoneActivity extends Activity implements View.OnClickListener {
    Button btnNum;
    EditText editNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone);

        btnNum = (Button) findViewById(R.id.btnNum);
        editNum = (EditText) findViewById(R.id.editNum);
        btnNum.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL,
                Uri.parse("tel:"+editNum.getText().toString()));
        startActivity(intent);
    }
}
