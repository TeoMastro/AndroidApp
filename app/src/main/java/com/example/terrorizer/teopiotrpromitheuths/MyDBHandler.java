package com.example.terrorizer.teopiotrpromitheuths;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    private static final String[]  COLUMNS = {T_PELATIS_ID,T_PELATIS_NAME,T_PELATIS_ADDRESS,T_PELATIS_PHONE,T_PELATIS_AFM,T_PELATIS_JOB,T_PELATIS_DOI,T_PELATIS_TK};
    //initialize the database
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_CUSTOMER = "CREATE TABLE " + TABLE_CUSTOMER + " (" + T_PELATIS_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + T_PELATIS_NAME + " TEXT, " + T_PELATIS_ADDRESS + " TEXT, " + T_PELATIS_PHONE +
                " TEXT, " + T_PELATIS_AFM + " TEXT, " + T_PELATIS_JOB + " TEXT, " + T_PELATIS_DOI + " TEXT, " + T_PELATIS_TK + " TEXT )";
        db.execSQL(CREATE_TABLE_CUSTOMER);

        String CREATE_TABLE_ITEMS = "CREATE TABLE Items ( itemID INTEGER PRIMARY KEY AUTOINCREMENT , itemPrice TEXT, itemVaros TEXT, itemKib TEXT)";
        db.execSQL(CREATE_TABLE_ITEMS);
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
            String result_1 = cursor.getString(1);
            result += result_1 + " ,";
        }
        cursor.close();
        db.close();
        return result;
    }


    public Customer loadCustomer(int id) {
         String query = "Select * FROM Customer WHERE pelatisID = '" + id +"'";
         SQLiteDatabase db = this.getWritableDatabase();
         Cursor cursor = db.rawQuery(query, null);
         Customer customer = new Customer();
        if( cursor != null && cursor.moveToFirst() ) {
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
            db.close();
           return customer;
     } else {
            db.close();
           return customer = null;
        }

    }

    public void addCustomer(Customer customer) {
        ContentValues values = new ContentValues();

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

    public boolean updateCustomer(int ID, String name, String add, String phone, String afm, String job, String doi, String tk) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(T_PELATIS_ID, ID);
        args.put(T_PELATIS_NAME, name);
        args.put(T_PELATIS_ADDRESS, add);
        args.put(T_PELATIS_PHONE, phone);
        args.put(T_PELATIS_AFM, afm);
        args.put(T_PELATIS_JOB, job);
        args.put(T_PELATIS_DOI, doi);
        args.put(T_PELATIS_TK, tk);
        return db.update(TABLE_CUSTOMER, args, T_PELATIS_ID + " = " + ID, null) > 0;
    }


}