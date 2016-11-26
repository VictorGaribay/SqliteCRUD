package com.raitom.sqlitecrud.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.raitom.sqlitecrud.R;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        login=(Button) findViewById(R.id.btnLogin);




        login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String usuario=((EditText) findViewById(R.id.usuarioET)).getText().toString();
                String password=((EditText) findViewById(R.id.passwordET)).getText().toString();
                if (usuario.equals("victor")&&password.equals("234")) {
                    Intent login = new Intent(LoginActivity.this, Principal_Activity.class);
                    startActivity(login);

                }

                else{
                    Toast.makeText(getApplicationContext(), "USUARIO NO AUTORIZADO",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
