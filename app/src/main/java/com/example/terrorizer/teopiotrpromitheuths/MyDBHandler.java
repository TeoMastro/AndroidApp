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

    public String loadAllItems() {
        String result = "";
        String query = "Select * FROM Items";
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
         String query = "Select * FROM Customer WHERE pelatisName = '" + pname +"'";
         SQLiteDatabase db = this.getWritableDatabase();
         Cursor cursor = db.rawQuery(query, null);
         Customer customer = new Customer();
        if( cursor != null && cursor.moveToFirst() ) {
                    cursor.moveToFirst();
                  customer.setPelatisID(Integer.parseInt(cursor.getString(0)));
                  customer.setPelatisName(cursor.getString(1));
                  customer.setPelatisAddress(cursor.getString(2));
                  customer.setPelatisJob(cursor.getString(3));
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
    // public void addItem(Items item) {
    //ContentValues values = new ContentValues();

    // values.put("itemName", item.getItemName());
    // values.put("itemPrice", item.getItemPrice());
    //  values.put("itemVaros", item.getItemVaros());
    //  values.put("itemKib", item.getItemKib());

    // SQLiteDatabase db = this.getWritableDatabase();
    //  db.insert("Items", null, values);
    // db.close();
    //}

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