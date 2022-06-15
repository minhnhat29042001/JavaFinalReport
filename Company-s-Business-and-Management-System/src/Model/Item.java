/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class Item {
    private int Item_ID;
    private String Item_Name;
    private String Item_Unit;
    private String Item_Type;
    private String Item_Suplier;
    private int price;
    private String Item_Date;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Item(int price) {
        this.price = price;
    }


    public int getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(int Item_ID) {
        this.Item_ID = Item_ID;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String Item_Name) {
        this.Item_Name = Item_Name;
    }

    public String getItem_Unit() {
        return Item_Unit;
    }

    public void setItem_Unit(String Item_Unit) {
        this.Item_Unit = Item_Unit;
    }

    public String getItem_Type() {
        return Item_Type;
    }

    public void setItem_Type(String Item_Type) {
        this.Item_Type = Item_Type;
    }

    public String getItem_Suplier() {
        return Item_Suplier;
    }

    public void setItem_Suplier(String Item_Suplier) {
        this.Item_Suplier = Item_Suplier;
    }

    public String getItem_Date() {
        return Item_Date;
    }

    public void setItem_Date(String Item_Date) {
        this.Item_Date = Item_Date;
    }

    public Item(int Item_ID, String Item_Name, String Item_Unit, String Item_Type, String Item_Suplier, int price, String Item_Date) {
        this.Item_ID = Item_ID;
        this.Item_Name = Item_Name;
        this.Item_Unit = Item_Unit;
        this.Item_Type = Item_Type;
        this.Item_Suplier = Item_Suplier;
        this.price = price;
        this.Item_Date = Item_Date;
    }

    public Item() {
    }

    
}
