package com.example.terrorizer.teopiotrpromitheuths;

public class Items {
    private int itemID;
    private String itemName;
    private String itemPrice;
    private String itemVaros;
    private String itemKib;

    public Items() {}
    public Items(String name, String price, String varos, String kib){
        this.itemName = name;
        this.itemPrice = price;
        this.itemVaros = varos;
        this.itemKib = kib;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemVaros() {
        return itemVaros;
    }

    public void setItemVaros(String itemVaros) {
        this.itemVaros = itemVaros;
    }

    public String getItemKib() {
        return itemKib;
    }

    public void setItemKib(String itemKib) {
        this.itemKib = itemKib;
    }
}
