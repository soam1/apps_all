package com.akashsoam.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.akashsoam.sharedpreferences.DbUtils.LocalDB;
import com.akashsoam.sharedpreferences.DbUtils.User;

public class LoginActivity extends AppCompatActivity {
    private EditText edUsername;
    private EditText edPassword;
    private Button btnLogin;
    private Button btnSignUp;

    private final String CREDENTIAL_SHARED_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.ed_username);
        edPassword = findViewById(R.id.ed_password);
        btnLogin = findViewById(R.id.btn_login);
        btnSignUp = findViewById(R.id.btn_signup);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SHARED PREFS***********************************************
//                SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
//                String strUsername = credentials.getString("Username", null);
//                String strPassword = credentials.getString("Password", null);


//                String username_from_ed = edUsername.getText().toString();
//                String password_from_ed = edPassword.getText().toString();
//                if (strUsername != null && username_from_ed != null && strUsername.equalsIgnoreCase(username_from_ed)) {
//                    if (strPassword != null && password_from_ed != null && strPassword.equalsIgnoreCase(password_from_ed)) {
//                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
//                }

//                ROOM DB*********************************************

                String username_from_ed = edUsername.getText().toString();
                String password_from_ed = edPassword.getText().toString();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LocalDB dbInstance = RoomImplementation.getInstance().getDbInstance();
                        User user = dbInstance.userDao().getUserByUserName(username_from_ed);

                        if (user != null && user.getUsername() != null && user.getUsername() != null && user.getUsername().equalsIgnoreCase(username_from_ed)) {
                            if (user.getPassword() != null && user.getPassword() != null && user.getPassword().equalsIgnoreCase(password_from_ed)) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }
                }).start();


            }
        });
    }
}
