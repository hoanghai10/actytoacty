package com.example.activityjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    private EditText edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        edt2 = findViewById(R.id.edtMainMailUpDate);
        Button btn = findViewById(R.id.btnMainBack);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strMailData = edt2.getText().toString().trim();
                backActivity(strMailData);
            }
        });

        String strMailData = getIntent().getStringExtra("Name");
        edt2.setText(strMailData);
    }
    private void backActivity(String strMailData) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("Name",strMailData);
        setResult(RESULT_OK,intent);
        finish();
    }
}