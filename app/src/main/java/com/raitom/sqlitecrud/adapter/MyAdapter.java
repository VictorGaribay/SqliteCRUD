package com.raitom.sqlitecrud.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raitom.sqlitecrud.DetailActivity;
import com.raitom.sqlitecrud.ItemClickListener;
import com.raitom.sqlitecrud.MyHolder;
import com.raitom.sqlitecrud.R;
import com.raitom.sqlitecrud.model.Persona;

import java.util.ArrayList;

/**
 * Created by raitom on 29/10/16.
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {


    Context c;
    ArrayList<Persona> personas;
    public MyAdapter(Context ctx, ArrayList<Persona> personas)
    {
        //ASSIGN THEM LOCALLY
        this.c=ctx;
        this.personas=personas;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //VIEW OBJ FROM XML
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,null);
        //holder
        MyHolder holder=new MyHolder(v);
        return holder;
    }
    //BIND DATA TO VIEWS
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.nameTxt.setText(personas.get(position).getNombre());
        holder.apellidotxt.setText(personas.get(position).getApellidos());
        holder.dnitxt.setText(personas.get(position).getDni());
        holder.direcciontxt.setText(personas.get(position).getDireccion());
        holder.telefonotxt.setText(personas.get(position).getTelefono());
        holder.dirTrabajotxt.setText(personas.get(position).getDirTrabajo());
        holder.ocupaciontxt.setText(personas.get(position).getOcupacion());

        //HANDLE ITEMCLICKS
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                //OPEN DETAIL ACTIVITY
                //PASS DATA
                //CREATE INTENT
                Intent i=new Intent(c,DetailActivity.class);
                //LOAD DATA
                i.putExtra("NOMBRE",personas.get(pos).getNombre());
                i.putExtra("APELLIDO",personas.get(pos).getApellidos());
                i.putExtra("DNI",personas.get(pos).getDni());
                i.putExtra("DIRECCION",personas.get(pos).getDireccion());
                i.putExtra("TELEFONO",personas.get(pos).getTelefono());
                i.putExtra("DIRTRABAJO",personas.get(pos).getDirTrabajo());
                i.putExtra("OCUPACION",personas.get(pos).getOcupacion());
                i.putExtra("ID",personas.get(pos).getId());
                //START ACTIVITY
                c.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return personas.size();
    }
}
