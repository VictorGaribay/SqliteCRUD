package com.raitom.sqlitecrud.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.raitom.sqlitecrud.R;

public class Principal_Activity extends AppCompatActivity {
    private Button clientes;
    private Button prestamo;
    private Button pagos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_);

        clientes=(Button) findViewById(R.id.clientes);
        prestamo=(Button) findViewById(R.id.prestamo);
        pagos=(Button) findViewById(R.id.pagos);


        clientes.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {



                    Intent clientes = new Intent(Principal_Activity.this, MainActivity.class);
                    startActivity(clientes);

               }
        });


    }
}
