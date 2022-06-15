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
public class Customer {
    private int Customer_ID;
    private String CustomerName;
    private String CustomerAddress;
    private String 	CustomerPhone;

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int Customer_ID) {
        this.Customer_ID = Customer_ID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String CustomerAddress) {
        this.CustomerAddress = CustomerAddress;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public void setCustomerPhone(String CustomerPhone) {
        this.CustomerPhone = CustomerPhone;
    }

    public Customer(int Customer_ID, String CustomerName, String CustomerAddress, String CustomerPhone) {
        this.Customer_ID = Customer_ID;
        this.CustomerName = CustomerName;
        this.CustomerAddress = CustomerAddress;
        this.CustomerPhone = CustomerPhone;
    }

    public Customer() {
    }
}
