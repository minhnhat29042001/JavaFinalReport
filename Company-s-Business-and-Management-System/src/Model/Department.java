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
public class Department {

    public Department(String name, String telephone) {

        this.name = name;
        this.telephone = telephone;
    }

    public Department(String telephone) {
        this.telephone = telephone;
    }

    Department() {

    }

 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    private String name;

    @Override
    public String toString() {
        return  name ;
    }
    private String telephone;
}
