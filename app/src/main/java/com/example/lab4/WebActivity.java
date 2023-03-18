package com.example.lab4;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class WebActivity extends Activity implements View.OnClickListener {
    Button btnWeb;
    EditText editUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);

        btnWeb = (Button) findViewById(R.id.btnWeb);
        editUrl = (EditText) findViewById(R.id.editUrl);
        btnWeb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://"+editUrl.getText().toString()));
        startActivity(intent);
    }
}