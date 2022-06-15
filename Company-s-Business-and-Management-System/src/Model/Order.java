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
public class Order {
    private int 	Order_ID;
    private String      	OrderDate;
    private int         Customer_ID;
    private int Item_ID;
    private int Number;
    private String order_DH;

    public Order() {
    }


    public Order(int Order_ID, String OrderDate, int Customer_ID, int Item_ID, int Number, String order_DH) {
        this.Order_ID = Order_ID;
        this.OrderDate = OrderDate;
        this.Customer_ID = Customer_ID;
        this.Item_ID = Item_ID;
        this.Number = Number;
        this.order_DH = order_DH;
    }

    public Order(String OrderDate, int Customer_ID, int Item_ID, int Number, String order_DH) {
        this.OrderDate = OrderDate;
        this.Customer_ID = Customer_ID;
        this.Item_ID = Item_ID;
        this.Number = Number;
        this.order_DH = order_DH;
    }

    public int getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(int Order_ID) {
        this.Order_ID = Order_ID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int Customer_ID) {
        this.Customer_ID = Customer_ID;
    }

    public int getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(int Item_ID) {
        this.Item_ID = Item_ID;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getOrder_DH() {
        return order_DH;
    }

    public void setOrder_DH(String order_DH) {
        this.order_DH = order_DH;
    }
    
    
    
}
