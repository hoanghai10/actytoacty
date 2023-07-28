package com.example.activityjava;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 100;
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.edtMainMail);
        Button btn = findViewById(R.id.btnMainSave);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strMail = edt.getText().toString().trim();
                callActivity(strMail);
               }
            });
        }
    private void callActivity(String strMail) {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("Name",strMail);
        startActivityForResult(intent,MY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(MY_REQUEST_CODE == requestCode && RESULT_OK == requestCode){
            String strResult = data.getStringExtra("Name");
            edt.setText(strResult);
        }
    }
}
