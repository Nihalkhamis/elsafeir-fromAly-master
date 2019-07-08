package com.mbsoft.elsafeir;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mbsoft.elsafeir.Utils.Constants;

public class LoginActivity extends AppCompatActivity {

    EditText login_username ,login_password;
    TextView forget_password ,create_account, english, arabic;
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Edit text identifier
        login_username=findViewById(R.id.login_username);
        login_password=findViewById(R.id.login_password);

        forget_password=findViewById(R.id.forget_password);
        create_account=findViewById(R.id.create_account);

        english=findViewById(R.id.english);
        arabic=findViewById(R.id.arabic);

        login_button=findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            }
        });

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                english.setBackground(ContextCompat.getDrawable(LoginActivity.this, R.drawable.purple_left_border));
                arabic.setBackground(ContextCompat.getDrawable(LoginActivity.this, R.drawable.white_right_border));
                english.setTextColor(getResources().getColor(R.color.white));
                arabic.setTextColor(getResources().getColor(R.color.black));
                Constants.languageChange("en",LoginActivity.this);




            }
        });

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arabic.setBackground(ContextCompat.getDrawable(LoginActivity.this, R.drawable.purple_right_border));
                english.setBackground(ContextCompat.getDrawable(LoginActivity.this, R.drawable.white_left_border));
                english.setTextColor(getResources().getColor(R.color.black));
                arabic.setTextColor(getResources().getColor(R.color.white));
                Constants.languageChange("ar",LoginActivity.this);

            }
        });



    }

}
