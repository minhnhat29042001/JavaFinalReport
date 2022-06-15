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
public class RoleManagement {
    private int ID;
    private String StaffName;
    private String Role;
    private String StartDate;
    private String EndDate;

    RoleManagement() {
      
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStaffName() {
        return StaffName;
    }

    public void setStaffName(String StaffName) {
        this.StaffName = StaffName;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public RoleManagement(int ID, String StaffName, String Role, String StartDate, String EndDate) {
        this.ID = ID;
        this.StaffName = StaffName;
        this.Role = Role;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
    }
}
