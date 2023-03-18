package com.example.lab4;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class MapActivity extends Activity implements View.OnClickListener {
    Button btnMap;
    EditText editCoord;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        btnMap = (Button) findViewById(R.id.btnMap);
        editCoord = (EditText) findViewById(R.id.editCoord);
        btnMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:"+editCoord.getText().toString()));
        startActivity(intent);
    }
}
