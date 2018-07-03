package com.example.terrorizer.teopiotrpromitheuths;

public class Orders {
    // fields
    private int OrderID;
    private int pelatisID;
    private int itemID;
    private int qty;
    private String date;

    // constructors
    public Orders() {}
    public Orders(int pelatisid, int itemid, int qty, String date) {
        super();
        this.pelatisID = pelatisid;
        this.itemID = itemid;
        this.qty = qty;
        this.date = date;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getPelatisID() {
        return pelatisID;
    }

    public void setPelatisID(int pelatisID) {
        this.pelatisID = pelatisID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
