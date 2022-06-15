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
public class Price {
    private int 	Item_ID;
    private int         Price;
    private String DatePrice;

    public int getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(int Item_ID) {
        this.Item_ID = Item_ID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getDatePrice() {
        return DatePrice;
    }

    public void setDatePrice(String DatePrice) {
        this.DatePrice = DatePrice;
    }

    public Price(int Item_ID, int Price, String DatePrice) {
        this.Item_ID = Item_ID;
        this.Price = Price;
        this.DatePrice = DatePrice;
    }

    public Price() {
    }
}
