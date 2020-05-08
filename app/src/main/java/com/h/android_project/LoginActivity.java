package com.h.android_project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends Activity {

    EditText et_username, et_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        transparentActionBar();

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = et_username.getText().toString().trim();
                final String password = et_password.getText().toString().trim();
                if (!username.equals("") && !password.equals("")) {
                    if (!username.equals("admin") && !password.equals("admin")) {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                        builder.setTitle("Error !");
                        builder.setMessage("Kullanıcı adı veya şifre yanlış! Lütfen tekrar deneyiniz.");
                        builder.setNegativeButton("Tamam", null);
                        builder.show();
                    } else {
                        Intent startActivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(startActivityIntent);
                    }
                } else {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("Error !");
                    builder.setMessage("Kullanıcı adı veya şifre alanı boş geçilemez !");
                    builder.setNegativeButton("Tamam", null);
                    builder.show();
                }
            }
        });
    }

    public void transparentActionBar() {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
    }
}
