package com.caloriecounter.nicoleazachee.caloriecounter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by c_naazachee on 9/11/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    static final String dbName="demoDBs";
    static final String dataTable="dataTable";
    static final String colTitle ="title";
    static final String colDescription = "description";
    static final String colLabel = "label";
    static final String colImageUrl = "imageUrl";
    static final String colInstructionUrl = "instructionUrl";

    static final String viewEmps="ViewEmps";

    public DatabaseHelper(Context context) {
        super(context, null, null,33);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
