package com.raitom.sqlitecrud.db;



/**
 * Created by raitom on 29/10/16.
 */

public class DataB {

    //COLUMNS
    static final String ID= "id";
    static final String NOMBRE= "nombre";
    static final String APELLIDO= "apellido";
    static final String DNI= "dni";
    static final String DIRECCION= "direccion";
    static final String TELEFONO= "telefono";
    static final String DIRTRABAJO = "dirtrabajo";
    static final String OCUPACION= "ocupacion";
  /*  static final String ROW_ID="id";
    static final String NAME = "name";
    static final String POSITION = "position";*/
    //DataB PROPERTIES
    static final String DB_NAME="b_DB";
    static final String TB_NAME="b_TB";
    static final int DB_VERSION='1';
    //CREATE TABLE
    static final String CREATE_TB=  "CREATE TABLE b_TB(ID INTEGER  PRIMARY KEY  AUTOINCREMENT, nombre TEXT NOT NULL,"
            + "apellido TEXT NOT NULL,dni TEXT NOT NULL,direccion TEXT NOT NULL,telefono TEXT NOT NULL,dirtrabajo TEXT NOT NULL,ocupacion TEXT NOT NULL);";



         /*   "create table " + TB_NAME + " ("
            + ID + " integer PRIMARY KEY AUTOINCREMENT, "
            + NOMBRE + " text NOT NULL, "
            + APELLIDO + " text not NULL, "
            + DNI + " text not NULL, "
            + DIRECCION + " text not NULL, "
            + TELEFONO + " text not NULL, "
            + DIRTRABAJO + " text not NULL, "
            + OCUPACION + " text not NULL"
            + ");";*/



}
