package com.raitom.sqlitecrud.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by raitom on 29/10/16.
 */

public class DBAdapter {


    Context c;
    SQLiteDatabase db;
    DBHelper helper;
    public DBAdapter(Context ctx)
    {
        this.c=ctx;
        helper=new DBHelper(c);
    }

    //OPEN DataB
    public DBAdapter openDB()
    {
        try
        {
            db=helper.getWritableDatabase();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return this;
    }
    //CLOSE
    public void close()
    {
        try
        {
            helper.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //INSERT DATA TO DataB
    public long add( String nombre,String apellido,String dni,String direccion,String telefono,String dirTrabajo,String ocupacion)
    {
        try
        {
            ContentValues cv=new ContentValues();
            cv.put(DataB.NOMBRE,nombre);
            cv.put(DataB.APELLIDO,apellido);
            cv.put(DataB.DNI,dni);
            cv.put(DataB.DIRECCION,direccion);
            cv.put(DataB.TELEFONO,telefono);
            cv.put(DataB.DIRTRABAJO,dirTrabajo);
            cv.put(DataB.OCUPACION,ocupacion);

            return db.insert(DataB.TB_NAME, DataB.ID,cv);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    //  mostrar todas las personas
    public Cursor getAllPersonas()
    {
        String[] columns={DataB.ID,DataB.NOMBRE,DataB.APELLIDO,DataB.DNI,DataB.DIRECCION,DataB.TELEFONO,DataB.DIRTRABAJO,DataB.OCUPACION};
        return db.query(DataB.TB_NAME,columns,null,null,null,null,null);
    }
    //UPDATE
    public long UPDATE(int id,String nombre,String apellido,String dni,String direccion,String telefono,String dirTrabajo,String ocupacion)
    {
        try
        {
            ContentValues cv=new ContentValues();
            cv.put(DataB.NOMBRE,nombre);
            cv.put(DataB.APELLIDO,apellido);
            cv.put(DataB.DNI,dni);
            cv.put(DataB.DIRECCION,direccion);
            cv.put(DataB.TELEFONO,telefono);
            cv.put(DataB.DIRTRABAJO,dirTrabajo);
            cv.put(DataB.OCUPACION,ocupacion);
            return db.update(DataB.TB_NAME,cv,DataB.ID+" =?",new String[]{String.valueOf(id)});
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    //DELETE
    public long Delete(int id)
    {
        try
        {
            return db.delete(DataB.TB_NAME,DataB.ID+" =?",new String[]{String.valueOf(id)});
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }


}
