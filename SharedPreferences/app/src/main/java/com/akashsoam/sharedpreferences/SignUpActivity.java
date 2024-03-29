package com.akashsoam.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.akashsoam.sharedpreferences.DbUtils.LocalDB;
import com.akashsoam.sharedpreferences.DbUtils.User;

public class SignUpActivity extends AppCompatActivity {
    private EditText edUsername;
    private EditText edPassword;
    private EditText edConfirmPassowrd;
    private Button btnCreateUser;

    private final String CREDENTIAL_SHARED_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edUsername = findViewById(R.id.ed_username);
        edPassword = findViewById(R.id.ed_password);
        edConfirmPassowrd = findViewById(R.id.ed_confirm_pwd);
        btnCreateUser = findViewById(R.id.btn_create_user);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strPassword = edPassword.getText().toString();
                String strConfirmPassword = edConfirmPassowrd.getText().toString();
                String strUsername = edUsername.getText().toString();

                if (strPassword != null && strConfirmPassword != null && strPassword.equalsIgnoreCase(strConfirmPassword)) {
//                    ****************SHARED PREFERENCES**************************

//                    SharedPreferences credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = credentials.edit();
//                    editor.putString("Password", strPassword);
//                    editor.putString("Username", strUsername);
//                    editor.commit();

//                    USING SQLITE ROOM DB

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User user = new User();
                            user.setPassword(strPassword);
                            user.setUsername(strUsername);
                            LocalDB dbInstance = RoomImplementation.getInstance().getDbInstance();
                            dbInstance.userDao().createUser(user);
                        }
                    }).start();

                    SignUpActivity.this.finish();
                }
            }
        });
    }
}
