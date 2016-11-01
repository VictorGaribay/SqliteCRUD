package com.raitom.sqlitecrud;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.raitom.sqlitecrud.db.DBAdapter;

public class DetailActivity extends AppCompatActivity {

    ImageView img;
    EditText nameTxt,apellidotxt,dnitxt,direcciontxt,telefonotxt,dirtrabajotxt,ocupaciontxt;
    Button updateBtn,deleteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fab=new Intent(DetailActivity.this,MainActivity.class);
                startActivity(fab);
            }
        });
        //RECEIVE DATA FROM MAIN ACTIVITY
        Intent i=getIntent();
        final String name=i.getExtras().getString("NOMBRE");
        final String apellido=i.getExtras().getString("APELLIDO");
        final String dni=i.getExtras().getString("DNI");
        final String direccion=i.getExtras().getString("DIRECCION");
        final String telefono=i.getExtras().getString("TELEFONO");
        final String dir_trabajo=i.getExtras().getString("DIRTRABAJO");
        final String ocupacion=i.getExtras().getString("OCUPACION");
        final int id=i.getExtras().getInt("ID");
        updateBtn= (Button) findViewById(R.id.updateBtn);
        deleteBtn= (Button) findViewById(R.id.deleteBtn);

        nameTxt= (EditText) findViewById(R.id.nameEditTxt);
        apellidotxt= (EditText) findViewById(R.id.apellidoET);
        dnitxt= (EditText) findViewById(R.id.dniET);
        direcciontxt= (EditText) findViewById(R.id.direccionET);
        telefonotxt= (EditText) findViewById(R.id.telefonoET);
        dirtrabajotxt = (EditText) findViewById(R.id.dirtrabajoET);
        ocupaciontxt= (EditText) findViewById(R.id.ocupacionET);

        //ASSIGN DATA TO THOSE VIEWS
        nameTxt.setText(name);
        apellidotxt.setText(apellido);
        dnitxt.setText(dni);
        direcciontxt.setText(direccion);
        telefonotxt.setText(telefono);
        dirtrabajotxt.setText(dir_trabajo);
        ocupaciontxt.setText(ocupacion);
        //update
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update(id,nameTxt.getText().toString(),apellidotxt.getText().toString(),
                        dnitxt.getText().toString(),direcciontxt.getText().toString(),
                        telefonotxt.getText().toString(),dirtrabajotxt.getText().toString(),
                        ocupaciontxt.getText().toString());
            }
        });
        //DELETE
        //update
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(id);
            }
        });
    }
    private void update(int id,String newnombre,String newapellido,String newdni,String newdireccion,String newtelefono,String newdireccionTrabajo,String newocupacion)
    {
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        long result=db.UPDATE(id,newnombre,newapellido,newdni,newdireccion,newtelefono,newdireccionTrabajo,newocupacion);
        if(result>0)
        {
            nameTxt.setText(newnombre);
            apellidotxt.setText(newapellido);
            dnitxt.setText(newdni);
            direcciontxt.setText(newdireccion);
            telefonotxt.setText(newtelefono);
            dirtrabajotxt.setText(newdireccionTrabajo);
            ocupaciontxt.setText(newocupacion);
            Snackbar.make(nameTxt,"Registro actualizado",Snackbar.LENGTH_SHORT).show();
        }else
        {
            Snackbar.make(nameTxt,"Registro no actulaizado",Snackbar.LENGTH_SHORT).show();
        }
        db.close();
    }
    //DELETE
    private void delete(int id)
    {
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        long result=db.Delete(id);
        if(result>0)
        {
            this.finish();
        }else
        {
            Snackbar.make(nameTxt,"Registro eliminado",Snackbar.LENGTH_SHORT).show();
        }
        db.close();
    }
}
