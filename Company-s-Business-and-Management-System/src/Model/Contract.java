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
public class Contract {

   private String ContractName;
   private int BasicSalary;
    private String ContractTime;
    public Contract() {
    }

    public Contract( String ContractName, int BasicSalary, String ContractTime) {

        this.ContractName = ContractName;
        this.BasicSalary = BasicSalary;
        this.ContractTime = ContractTime;
    }

    public Contract(int BasicSalary, String ContractTime) {
        this.BasicSalary = BasicSalary;
        this.ContractTime = ContractTime;
    }

  

    public String getContractName() {
        return ContractName;
    }

    public void setContractName(String ContractName) {
        this.ContractName = ContractName;
    }

    public int getBasicSalary() {
        return BasicSalary;
    }

    public void setBasicSalary(int BasicSalary) {
        this.BasicSalary = BasicSalary;
    }

    public String getContractTime() {
        return ContractTime;
    }

    public void setContractTime(String ContractTime) {
        this.ContractTime = ContractTime;
    }

    @Override
    public String toString() {
        return ContractName ;
    }
  
}
