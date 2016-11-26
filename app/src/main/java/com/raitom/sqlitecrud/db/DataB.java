package com.raitom.sqlitecrud.db;



/**
 * Created by raitom on 29/10/16.
 */

public class DataB {

    //COLUMNS CLIENTES
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

  //COLUMNS PRESTAMOS
  static final String IDPRESTAMOS= ID;
    static final String MONTO= "monto";
    static final String INTERES= "apellido";
    static final String PLAZOMESES= "plazo_meses";
    static final String FECHACOMEINZO= "fecha_comienzo";


    //COLUMNS PAGOS
    static final String IDPAGOS= IDPRESTAMOS;
    static final String CANTIDAD= "cantidad";
    static final String FECHAPAGO= "fecha_pago";
    static final String FECHAVENCIMIENTO= "fecha_vencimiento";



    static final String DB_NAME="b_DB";
    static final int DB_VERSION='1';
    static final String TB_NAME="b_TB";
    static final String TB_PRESTAMO="b_PRESTAMO";
    static final String TB_PAGOS="b_PAGOS";

    //CREATE TABLE CLIENTES
    static final String CREATE_TB=  "CREATE TABLE b_TB(ID INTEGER  PRIMARY KEY  AUTOINCREMENT, nombre TEXT NOT NULL,"
            + "apellido TEXT NOT NULL,dni TEXT NOT NULL,direccion TEXT NOT NULL,telefono TEXT NOT NULL,dirtrabajo TEXT NOT NULL,ocupacion TEXT NOT NULL);";

    //CREATE TABLE PRESTAMOS

    static final String CREATE_PRESTAMO=  "CREATE TABLE b_TB(ID INTEGER  PRIMARY KEY  AUTOINCREMENT, nombre TEXT NOT NULL,"
            + "apellido TEXT NOT NULL,dni TEXT NOT NULL,direccion TEXT NOT NULL,telefono TEXT NOT NULL,dirtrabajo TEXT NOT NULL,ocupacion TEXT NOT NULL);";


    static final String CREATE_PAGOS=  "CREATE TABLE b_TB(ID INTEGER  PRIMARY KEY  AUTOINCREMENT, nombre TEXT NOT NULL,"
            + "apellido TEXT NOT NULL,dni TEXT NOT NULL,direccion TEXT NOT NULL,telefono TEXT NOT NULL,dirtrabajo TEXT NOT NULL,ocupacion TEXT NOT NULL);";


    //CREATE TABLE PAGOS







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
