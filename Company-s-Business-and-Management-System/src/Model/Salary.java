/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;



/**
 *
 * @author anhng
 */
public class Salary {
    private int Salary_ID;
    private int Employee_ID;
    private int TotalSalary;
    private String SalaryTime;
    private String Name;

    public Salary() {
    }

    public Salary(int Employee_ID, int TotalSalary, String SalaryTime, String Name) {
        this.Employee_ID = Employee_ID;
        this.TotalSalary = TotalSalary;
        this.SalaryTime = SalaryTime;
        this.Name = Name;
    }

    
    
    public Salary(int Salary_ID, int Employee_ID, int TotalSalary, String SalaryTime, String Name) {
        this.Salary_ID = Salary_ID;
        this.Employee_ID = Employee_ID;
        this.TotalSalary = TotalSalary;
        this.SalaryTime = SalaryTime;
        this.Name = Name;
    }

    public int getSalary_ID() {
        return Salary_ID;
    }

    public void setSalary_ID(int Salary_ID) {
        this.Salary_ID = Salary_ID;
    }

    public int getEmployee_ID() {
        return Employee_ID;
    }

    public void setEmployee_ID(int Employee_ID) {
        this.Employee_ID = Employee_ID;
    }

    public int getTotalSalary() {
        return TotalSalary;
    }

    public void setTotalSalary(int TotalSalary) {
        this.TotalSalary = TotalSalary;
    }

    public String getSalaryTime() {
        return SalaryTime;
    }

    public void setSalaryTime(String SalaryTime) {
        this.SalaryTime = SalaryTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
   
    
}
