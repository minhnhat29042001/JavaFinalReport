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
public class Role {

    private String rolename;
    private int allowance;
    private String AllowanceTime;

    public Role( String rolename, int allowance, String AllowanceTime) {

        this.rolename = rolename;
        this.allowance = allowance;
        this.AllowanceTime = AllowanceTime;
    }

    Role() {
    
    }


    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public String getAllowanceTime() {
        return AllowanceTime;
    }

    public void setAllowanceTime(String AllowanceTime) {
        this.AllowanceTime = AllowanceTime;
    }

    @Override
    public String toString() {
        return rolename ;
    }
}
