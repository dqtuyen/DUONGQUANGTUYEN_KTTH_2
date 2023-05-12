package com.example.duongquangtuyen_ktth_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup group;
    EditText edtVND, edtNT;
    Button btnCL, btnVNDTONT, btnNTTOVND;

    int result = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        int id = group.getCheckedRadioButtonId();
        RadioButton rb = findViewById(id);
        String type = "";
        type = rb.getText().toString();


        switch (type){
            case "USD":
                result = 22280;
                break;
            case "EUR":
                result = 24280;
                break;
            case "JPY":
                result = 204;
                break;
        }
        btnVNDTONT.setOnClickListener(vnd -> {
            if (edtVND.getText().toString() != ""){
                int vnd1 = Integer.parseInt(edtVND.getText().toString().trim());
                edtNT.setText((vnd1/(float)result) + "");
            }
        });

        btnNTTOVND.setOnClickListener(nt -> {
            if (edtNT.getText().toString() != ""){
                int nt1 = Integer.parseInt(edtNT.getText().toString().trim());
                edtVND.setText((result*nt1) + "");
            }
        });
        btnCL.setOnClickListener(clear -> {
            edtVND.setText("");
            edtNT.setText("");
        });

    }
    private void init(){
        group = findViewById(R.id.group);
        edtNT = findViewById(R.id.edtNT);
        edtVND = findViewById(R.id.edtVND);
        btnCL = findViewById(R.id.btnCL);
        btnNTTOVND = findViewById(R.id.btnNTTOVND);
        btnVNDTONT = findViewById(R.id.btnVNDTONT);
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit?");
        b.setIcon(android.R.drawable.ic_dialog_alert);
        b.setPositiveButton("Yes", new DialogInterface. OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                finish();
            }});
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        b.create().show();

    }
}