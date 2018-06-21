package com.example.terrorizer.teopiotrpromitheuths;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "stockmanagement.db";
    public static final String TABLE_CUSTOMER = "Customer";
    public static final String T_PELATIS_ID = "pelatisID";
    public static final String T_PELATIS_NAME = "pelatisName";
    public static final String T_PELATIS_ADDRESS = "pelatisAddress";
    public static final String T_PELATIS_PHONE = "pelatisPhone";
    public static final String T_PELATIS_AFM = "pelatisAFM";
    public static final String T_PELATIS_JOB = "pelatisJob";
    public static final String T_PELATIS_DOI = "pelatisDOI";
    public static final String T_PELATIS_TK = "pelatisTK";
    //initialize the database
    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_CUSTOMER = "CREATE TABLE " + TABLE_CUSTOMER + "(" + T_PELATIS_ID +
                "INTEGER PRIMARYKEY," + T_PELATIS_NAME + "TEXT," + T_PELATIS_ADDRESS + "TEXT," + T_PELATIS_PHONE +
                "TEXT," + T_PELATIS_AFM + "TEXT," + T_PELATIS_JOB + "TEXT," + T_PELATIS_DOI + "TEXT," + T_PELATIS_TK + "TEXT )";
        db.execSQL(CREATE_TABLE_CUSTOMER);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);

        onCreate(db);
    }

    public String loadAllCustomer() {
        String result = "";
        String query = "Select * FROM " + TABLE_CUSTOMER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

    public Customer loadCustomer(String pname) {
        String result = "";
        String query = "Select * FROM" + TABLE_CUSTOMER + "WHERE" + T_PELATIS_ID + "= '" + pname + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Customer customer = new Customer();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            customer.setPelatisID(Integer.parseInt(cursor.getString(0)));
            customer.setPelatisName(cursor.getString(1));
            customer.setPelatisAddress(cursor.getString(2));
            customer.setPelatisPhone(cursor.getString(3));
            customer.setPelatisAFM(cursor.getString(4));
            customer.setPelatisJob(cursor.getString(5));
            customer.setPelatisDOI(cursor.getString(6));
            customer.setPelatisTK(cursor.getString(7));
            cursor.close();
        } else {
            customer = null;
        }
        db.close();
        return customer;
    }

    public void addCustomer(Customer customer) {
        ContentValues values = new ContentValues();
        values.put(T_PELATIS_ID, customer.getPelatisID());
        values.put(T_PELATIS_NAME, customer.getPelatisName());
        values.put(T_PELATIS_ADDRESS, customer.getPelatisAddress());
        values.put(T_PELATIS_PHONE, customer.getPelatisPhone());
        values.put(T_PELATIS_AFM, customer.getPelatisAFM());
        values.put(T_PELATIS_JOB, customer.getPelatisJob());
        values.put(T_PELATIS_DOI, customer.getPelatisDOI());
        values.put(T_PELATIS_TK, customer.getPelatisTK());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_CUSTOMER, null, values);
        db.close();
    }

    public boolean deleteCustomer(int ID) {
        boolean result = false;
        String query = "Select * FROM" + TABLE_CUSTOMER + "WHERE" + T_PELATIS_ID + "= '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Customer customer = new Customer();
        if (cursor.moveToFirst()) {
            customer.setPelatisID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_CUSTOMER, T_PELATIS_ID + "=?",
                    new String[] {
                String.valueOf(customer.getPelatisID())
            });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }


}
