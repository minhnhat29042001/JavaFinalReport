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
public class Receipt {
    private int Receipt_ID ;
    private String DateReceipt;
    private String DatePrintReceipt;
    private int Order_ID;
    private int Employee_ID;

    public Receipt(String DateReceipt, String DatePrintReceipt, int Order_ID, int Employee_ID) {
        this.DateReceipt = DateReceipt;
        this.DatePrintReceipt = DatePrintReceipt;
        this.Order_ID = Order_ID;
        this.Employee_ID = Employee_ID;
    }

    public int getReceipt_ID() {
        return Receipt_ID;
    }

    public void setReceipt_ID(int Receipt_ID) {
        this.Receipt_ID = Receipt_ID;
    }

    public String getDateReceipt() {
        return DateReceipt;
    }

    public void setDateReceipt(String DateReceipt) {
        this.DateReceipt = DateReceipt;
    }

    public String getDatePrintReceipt() {
        return DatePrintReceipt;
    }

    public void setDatePrintReceipt(String DatePrintReceipt) {
        this.DatePrintReceipt = DatePrintReceipt;
    }

    public int getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(int Order_ID) {
        this.Order_ID = Order_ID;
    }

    public int getEmployee_ID() {
        return Employee_ID;
    }

    public void setEmployee_ID(int Employee_ID) {
        this.Employee_ID = Employee_ID;
    }

    public Receipt(int Receipt_ID, String DateReceipt, String DatePrintReceipt, int Order_ID, int Employee_ID) {
        this.Receipt_ID = Receipt_ID;
        this.DateReceipt = DateReceipt;
        this.DatePrintReceipt = DatePrintReceipt;
        this.Order_ID = Order_ID;
        this.Employee_ID = Employee_ID;
    }

    public Receipt() {
    }
            
}
