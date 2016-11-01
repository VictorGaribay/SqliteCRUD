package com.raitom.sqlitecrud;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.raitom.sqlitecrud.adapter.MyAdapter;
import com.raitom.sqlitecrud.db.DBAdapter;
import com.raitom.sqlitecrud.model.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nameTxt,apellidotxt,dnitxt,direcciontxt,telefonotxt,dirtrabajotxt,ocupaciontxt;
    RecyclerView rv;
    MyAdapter adapter;
    ArrayList<Persona> personas=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        //recycler
        rv= (RecyclerView) findViewById(R.id.myRecycler);
        //SET ITS PROPS
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        //ADAPTER
        adapter=new MyAdapter(this,personas);
        retrieve();
    }
    private void showDialog()
    {
        Dialog d=new Dialog(this);
        //NO TITLE
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //layout of dialog
        d.setContentView(R.layout.custom);
        nameTxt= (EditText) d.findViewById(R.id.nameEditTxt);
        apellidotxt= (EditText) d.findViewById(R.id.apellidoET);
        dnitxt= (EditText) d.findViewById(R.id.dniET);
        direcciontxt= (EditText) d.findViewById(R.id.direccionET);
        telefonotxt= (EditText) d.findViewById(R.id.telefonoET);
        dirtrabajotxt = (EditText) d.findViewById(R.id.dirtrabajoET);
        ocupaciontxt= (EditText) d.findViewById(R.id.ocupacionET);

        Button savebtn= (Button) d.findViewById(R.id.saveBtn);
        final Button retrieveBtn= (Button) d.findViewById(R.id.retrieveBtn);
        //ONCLICK LISTENERS
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(nameTxt.getText().toString(),apellidotxt.getText().toString(),dnitxt.getText().toString(),
                        direcciontxt.getText().toString(),telefonotxt.getText().toString(), dirtrabajotxt.getText().toString()
                ,ocupaciontxt.getText().toString());
            }
        });
        retrieveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retrieveBtn= new Intent(MainActivity.this, MainActivity.class);
                startActivity(retrieveBtn);
                retrieve();
            }
        });
        //SHOW DIALOG
        d.show();
    }
    //SAVE
    private void save(String nombre,String apellido,String dni,String direccion,String telefono,String direccionTrabajo,String ocupacion)
    {
        DBAdapter db=new DBAdapter(this);
        //OPEN
        db.openDB();
        //INSERT
        long result=db.add(nombre,apellido,dni,direccion,telefono,direccionTrabajo,ocupacion);
        if(result>0)
        {
            nameTxt.setText("");
            apellidotxt.setText("");
            dnitxt.setText("");
            direcciontxt.setText("");
            telefonotxt.setText("");
            dirtrabajotxt.setText("");
            ocupaciontxt.setText("");

        }else
        {
            Snackbar.make(nameTxt,"Unable To Insert",Snackbar.LENGTH_SHORT).show();
        }
        //CLOSE
        db.close();
        //refresh
        retrieve();
    }
    //RETRIEVE
    private void retrieve()
    {
        DBAdapter db=new DBAdapter(this);
        //OPEN
        db.openDB();
        personas.clear();
        //SELECT
        Cursor c=db.getAllPersonas();
        //LOOP THRU THE DATA ADDING TO ARRAYLIST
        while (c.moveToNext())
        {
            int id=c.getInt(0);
            String nombre= c.getString(1);
            String apellido=c.getString(2);
            String dni=c.getString(3);
            String direccion=c.getString(4);
            String telefono=c.getString(5);
            String dirtrabajo=c.getString(6);
            String ocupacion=c.getString(7);
            //CREATE personas
            Persona p=new Persona(id,nombre,apellido,dni,direccion,telefono,dirtrabajo,ocupacion);
            //ADD TO Persona
            personas.add(p);
        }
        //SET ADAPTER TO RV
        if(!(personas.size()<1))
        {
            rv.setAdapter(adapter);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        retrieve();
    }
}
