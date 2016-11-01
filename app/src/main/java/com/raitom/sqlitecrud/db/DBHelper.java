package com.raitom.sqlitecrud.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by raitom on 29/10/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, DataB.DB_NAME, null, DataB.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try
        {
            db.execSQL(DataB.CREATE_TB);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS"+DataB.DB_NAME);
        onCreate(db);

    }
}
