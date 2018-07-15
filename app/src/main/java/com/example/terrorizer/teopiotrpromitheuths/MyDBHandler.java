package com.example.terrorizer.teopiotrpromitheuths;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    /*                 ---------Define Item Var---------------                 */
    public static final String TABLE_ITEMS = "Items";
    public static final String T_ITEM_ID = "itemID";
    public static final String T_ITEM_NAME = "itemName";
    public static final String T_ITEM_VAROS = "itemVaros";
    public static final String T_ITEM_TIMH = "itemTimh";
    public static final String T_ITEM_KIBOTIO = "itemKib";
    /*                 ---------Define ORDERS Var---------------                 */
    public static final String ORDERS_TABLE = "Orders";
    public static final String T_ORDER_ID = "orderID";
    public static final String T_ORDER_QTY = "qty";
    public static final String T_ORDER_ACTKIB = "itemActKib";
    public static final String T_ORDER_DATE = "orderDate";
    /*                 ---------Create Customer---------------                 */
    private static final String CREATE_TABLE_CUSTOMER = "CREATE TABLE if not exists " + TABLE_CUSTOMER + " (" + T_PELATIS_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT," + T_PELATIS_NAME + " TEXT, " + T_PELATIS_ADDRESS + " TEXT, " + T_PELATIS_PHONE +
            " TEXT, " + T_PELATIS_AFM + " TEXT, " + T_PELATIS_JOB + " TEXT, " + T_PELATIS_DOI + " TEXT, " + T_PELATIS_TK + " TEXT )";

    private static final String CREATE_TABLE_ITEMS = "CREATE TABLE if not exists " + TABLE_ITEMS + " (" + T_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + T_ITEM_NAME +
            " TEXT ," + T_ITEM_TIMH + " FLOAT , " + T_ITEM_VAROS + " TEXT , " + T_ITEM_KIBOTIO + " INTEGER )";

    private static final String CREATE_TABLE_ORDERS = "CREATE TABLE if not exists " + ORDERS_TABLE + " (" + T_ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + T_PELATIS_ID +
            " INTEGER ," + T_ITEM_ID + " INTEGER , " + T_ORDER_QTY + " INTEGER , " + T_ORDER_DATE + " TEXT , " + T_ORDER_ACTKIB + " INTEGER )";
    /*                 ----------Create Items---------------                 */
    //initialize the database
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CUSTOMER);
        db.execSQL(CREATE_TABLE_ITEMS);
        db.execSQL(CREATE_TABLE_ORDERS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + ORDERS_TABLE);

        onCreate(db);
    }

    public String loadAllCustomer() {
        String result = "";
        String query = "Select * FROM " + TABLE_CUSTOMER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String result_1 = cursor.getString(1);
            result += "("+id+") " + result_1 + " ,";
        }
        cursor.close();
        db.close();
        return result;
    }

    public String loadAllItems(){
        String result = "";
        String query = "Select * FROM " + TABLE_ITEMS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String result_1 = cursor.getString(1);
            result += "("+id+") " + result_1 + " ,";
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

    public Items loadItems(int id) {
        String query = "Select * FROM Items WHERE itemID = '" + id +"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Items items = new Items();
        if( cursor != null && cursor.moveToFirst() ) {
            cursor.moveToFirst();
            items.setItemID(Integer.parseInt(cursor.getString(0)));
            items.setItemName(cursor.getString(1));
            items.setItemPrice(cursor.getString(2));
            items.setItemVaros(cursor.getString(3));
            items.setItemKib(cursor.getString(4));
            cursor.close();
            db.close();
            return items;
        } else {
            db.close();
            return items = null;
        }

    }

    public Items[] loadItemsList(int id){
        String query = "Select * FROM Items WHERE itemID = '" + id +"'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        int cursize = cursor.getCount();
        Items[] itemArray = new Items[cursize];
        if( cursor != null && cursor.moveToFirst() ) {
            for ( int i=0; i<itemArray.length; i++) {
                itemArray[i] = new Items();
                cursor.moveToFirst();
                itemArray[i].setItemID(Integer.parseInt(cursor.getString(0)));
                itemArray[i].setItemName(cursor.getString(1));
                itemArray[i].setItemPrice(cursor.getString(2));
                itemArray[i].setItemVaros(cursor.getString(3));
                itemArray[i].setItemKib(cursor.getString(4));
                cursor.close();
                db.close();
            }
        } else {
            db.close();
        }
        return itemArray;
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

    public void addItem(Items item){
        ContentValues values = new ContentValues();

        values.put(T_ITEM_NAME, item.getItemName());
        values.put(T_ITEM_VAROS, item.getItemVaros());
        values.put(T_ITEM_TIMH, item.getItemPrice());
        values.put(T_ITEM_KIBOTIO, item.getItemKib());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_ITEMS, null, values);
        db.close();
    }

    public boolean deleteCustomer(int ID) {
        boolean result = false;
        String query = "Select * FROM " + TABLE_CUSTOMER + " WHERE " + T_PELATIS_ID + " = '" + String.valueOf(ID) + "'";
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

    public boolean deleteItem(int ID){
        boolean result = false;
        String query = "Select * FROM " + TABLE_ITEMS + " WHERE " + T_ITEM_ID + " = '" + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Items item = new Items();
        if (cursor.moveToFirst()) {
            item.setItemID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_ITEMS, T_ITEM_ID  + "=?",
                    new String[] {
                            String.valueOf(item.getItemID())
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

    public boolean updateItem(int ID, String name, String timh, String varos, String kibotio){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(T_ITEM_ID, ID);
        args.put(T_ITEM_NAME, name);
        args.put(T_ITEM_TIMH, timh);
        args.put(T_ITEM_VAROS, varos);
        args.put(T_ITEM_KIBOTIO, kibotio);
        return db.update(TABLE_ITEMS, args, T_ITEM_ID + " = " + ID, null) > 0;
    }

    public void addOrder(Orders order){
        ContentValues values = new ContentValues();

        values.put(T_PELATIS_ID, order.getPelatisID());
        values.put(T_ITEM_ID, order.getItemID());
        values.put(T_ORDER_QTY, order.getQty());
        values.put(T_ORDER_DATE, order.getDate());
        values.put(T_ORDER_ACTKIB, order.getItemActKib());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ORDERS_TABLE, null, values);
        db.close();
    }

    public String loadOrderByDate(String pdate) {
        String result = "";
        String query = "SELECT Customer.pelatisName,Items.itemName,Orders.qty,Orders.itemActKib,Items.itemTimh,Items.ItemKib" +
                " FROM (( Orders " +
                " INNER JOIN Items ON Items.itemID = Orders.itemID)" +
                " INNER JOIN Customer ON Customer.pelatisID = Orders.pelatisID)" +
                " WHERE Orders.orderDate = '" + pdate + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.getCount() >= 1) {
            while (cursor.moveToNext()) {
                String pName = cursor.getString(0);
                String iName = cursor.getString(1);
                int qty = Integer.parseInt(cursor.getString(2));
                int actkib = Integer.parseInt(cursor.getString(3));
                if(actkib==1) {
                    result += "(Όνομα πελάτη: " +  pName + ")" + System.getProperty("line.separator")
                            + ">Προϊόν: " + iName + System.getProperty("line.separator")
                            + "Ποσότητα: " + String.valueOf(qty) + " Κιβ." + System.getProperty("line.separator")+ " < /";
                }else{
                    result += "(Όνομα πελάτη: " +  pName + ")" + System.getProperty("line.separator")
                            + ">Προϊόν: " + iName + System.getProperty("line.separator")
                            + "Ποσότητα: " + String.valueOf(qty) + System.getProperty("line.separator") + " < /";
                }
            }
        }
        cursor.close();
        db.close();
        return result;
    }

    public String loadOrderByItem(int cid){
        String result = "";
        String query = "Select Customer.pelatisName, Orders.qty, Orders.orderDate, Orders.itemActKib FROM Orders INNER JOIN Customer ON " +
                "Customer.pelatisID = Orders.pelatisID WHERE Orders.itemID = " + cid + " LIMIT 20 ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            String qty = cursor.getString(1);
            String date = cursor.getString(2);
            int actkib = Integer.parseInt(cursor.getString(3));
            if(actkib==1) {
                result += name + " - " + qty + " Κιβ. - " + date + " /";
            }else{
                result += name + " - " + qty + " - " + date + " /";
            }
        }
        cursor.close();
        db.close();
        return result;
    }

    public String loadOrderByCustomer(int cid){
        String result = "";
        String query = "Select Items.itemName, Orders.qty, Orders.orderDate, Orders.itemActKib FROM Orders INNER JOIN Items ON " +
                "Items.itemID = Orders.itemID WHERE Orders.pelatisID = " + cid + " LIMIT 20 ";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            String qty = cursor.getString(1);
            String date = cursor.getString(2);
            int actkib = Integer.parseInt(cursor.getString(3));
            if(actkib==1) {
                result += name + " - " + qty + " Κιβ. - " + date + " /";
            }else{
                result += name + " - " + qty + " - " + date + " /";
            }
        }
        cursor.close();
        db.close();
        return result;
    }

    public String TodayOrders(){

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c);

        String query = "SELECT Customer.pelatisName,Items.itemName,Orders.qty,Orders.itemActKib,Items.itemTimh,Items.ItemKib" +
                " FROM (( Orders " +
                " INNER JOIN Items ON Items.itemID = Orders.itemID)" +
                " INNER JOIN Customer ON Customer.pelatisID = Orders.pelatisID)" +
                " WHERE Orders.orderDate = '" + formattedDate + "'";

        String result = "";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor != null) {
            while (cursor.moveToNext()) {
                String pName = cursor.getString(0);
                String iName = cursor.getString(1);
                int qty = Integer.parseInt(cursor.getString(2));
                int actkib = Integer.parseInt(cursor.getString(3));

                if(actkib==1) {
                    result += "(Όνομα πελάτη: " +  pName + ")" + System.getProperty("line.separator")
                            + ">Προϊόν: " + iName + System.getProperty("line.separator")
                            + "Ποσότητα: " + String.valueOf(qty) + " Κιβ." + System.getProperty("line.separator")+ " < /";
                }else{
                    result += "(Όνομα πελάτη: " +  pName + ")" + System.getProperty("line.separator")
                            + ">Προϊόν: " + iName + System.getProperty("line.separator")
                            + "Ποσότητα: " + String.valueOf(qty) + System.getProperty("line.separator") + " < /";
                }
            }
            cursor.close();
            db.close();
            return result;
        } else{
            result = null;
            return result;
        }
    }


}