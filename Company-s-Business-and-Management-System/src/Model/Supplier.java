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
public class Supplier {
    private String suppName;

    public Supplier() {
    }

    public Supplier(String suppName) {
        this.suppName = suppName;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    @Override
    public String toString() {
        return suppName ;
    }
    
}
