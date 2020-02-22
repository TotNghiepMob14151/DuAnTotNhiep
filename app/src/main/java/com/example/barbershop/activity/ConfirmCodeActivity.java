package com.example.barbershop.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chaos.view.PinView;
import com.example.authenticationsms.R;



public class ConfirmCodeActivity extends BaseActivity {
    private TextView tvPhoneNumber;
    private PinView pvCode;
    private Button btnContinue;
    private TextView tvResendCode;
    String codeSent = "123456";
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_code);
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber);
        pvCode = findViewById(R.id.pvCode);
        btnContinue = findViewById(R.id.btnContinue);


        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Key");
        String phoneNumber = bundle.getString("phoneNumber");
        phone = phoneNumber;
        tvPhoneNumber.setText(phoneNumber);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifySignInCode(codeSent);
            }
        });

    }

    private void verifySignInCode(String codeSent) {
        String code = pvCode.getText().toString();
        if (code.isEmpty()) {
            showMessegeWarning("Vui lòng nhập mã code");
        } else {
        }
        //codeSent laf cai code da gui
        //dung de so sanh voi ca code nhap vao
    }



    private void saveUsername(String phoneNumber) {
        SharedPreferences sharedPreferences = getSharedPreferences("USER", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("NAME", phoneNumber);
        edit.apply();
    }
}
