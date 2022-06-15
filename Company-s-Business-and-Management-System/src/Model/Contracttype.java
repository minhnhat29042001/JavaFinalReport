/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.raven.datechooser.SelectedDate;

/**
 *
 * @author Admin
 */
public class Contracttype {
    private int Contracttypeid;
    private String ContracttypeName;
    private String ContractStartDate;
    private String ContractEndDate;
    private int StaffID;
    private String QuitJobDate;

    public Contracttype(int contrId, String cm, SelectedDate startdate, String enddate, int stfId, String quit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getContracttypeid() {
        return Contracttypeid;
    }

    public void setContracttypeid(int Contracttypeid) {
        this.Contracttypeid = Contracttypeid;
    }

    public String getContracttypeName() {
        return ContracttypeName;
    }

    public void setContracttypeName(String ContracttypeName) {
        this.ContracttypeName = ContracttypeName;
    }

    public String getContractStartDate() {
        return ContractStartDate;
    }

    public void setContractStartDate(String ContractStartDate) {
        this.ContractStartDate = ContractStartDate;
    }

    public String getContractEndDate() {
        return ContractEndDate;
    }

    public void setContractEndDate(String ContractEndDate) {
        this.ContractEndDate = ContractEndDate;
    }

    public int getStaffID() {
        return StaffID;
    }

    public void setStaffID(int StaffID) {
        this.StaffID = StaffID;
    }

    public String getQuitJobDate() {
        return QuitJobDate;
    }

    public void setQuitJobDate(String QuitJobDate) {
        this.QuitJobDate = QuitJobDate;
    }

    public Contracttype(int Contracttypeid, String ContracttypeName, String ContractStartDate, String ContractEndDate, int StaffID, String QuitJobDate) {
        this.Contracttypeid = Contracttypeid;
        this.ContracttypeName = ContracttypeName;
        this.ContractStartDate = ContractStartDate;
        this.ContractEndDate = ContractEndDate;
        this.StaffID = StaffID;
        this.QuitJobDate = QuitJobDate;
    }

    public Contracttype() {
    }

    public Contracttype(String ContracttypeName, String ContractStartDate, String ContractEndDate, int StaffID, String QuitJobDate) {
        this.ContracttypeName = ContracttypeName;
        this.ContractStartDate = ContractStartDate;
        this.ContractEndDate = ContractEndDate;
        this.StaffID = StaffID;
        this.QuitJobDate = QuitJobDate;
    }

    
    
    
}
