/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author anhng
 */
public class SalaryMa {
    private int Salary_ID;
    private int Employee_ID;
    private String BonusLevel;
    private int Overtime;
    private int OvertimePay;
    private int TotalOVT;
    private int TotalSalary;
    private String SalaryTime;

    public SalaryMa() {
    }

    public SalaryMa(int Salary_ID, int Employee_ID, String BonusLevel, int Overtime, int OvertimePay, int TotalOVT, int TotalSalary, String SalaryTime) {
        this.Salary_ID = Salary_ID;
        this.Employee_ID = Employee_ID;
        this.BonusLevel = BonusLevel;
        this.Overtime = Overtime;
        this.OvertimePay = OvertimePay;
        this.TotalOVT = TotalOVT;
        this.TotalSalary = TotalSalary;
        this.SalaryTime = SalaryTime;
    }

    public SalaryMa(int Employee_ID, String BonusLevel, int Overtime, int OvertimePay, int TotalOVT, int TotalSalary, String SalaryTime) {
        this.Employee_ID = Employee_ID;
        this.BonusLevel = BonusLevel;
        this.Overtime = Overtime;
        this.OvertimePay = OvertimePay;
        this.TotalOVT = TotalOVT;
        this.TotalSalary = TotalSalary;
        this.SalaryTime = SalaryTime;
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

    public String getBonusLevel() {
        return BonusLevel;
    }

    public void setBonusLevel(String BonusLevel) {
        this.BonusLevel = BonusLevel;
    }

    public int getOvertime() {
        return Overtime;
    }

    public void setOvertime(int Overtime) {
        this.Overtime = Overtime;
    }

    public int getOvertimePay() {
        return OvertimePay;
    }

    public void setOvertimePay(int OvertimePay) {
        this.OvertimePay = OvertimePay;
    }

    public int getTotalOVT() {
        return TotalOVT;
    }

    public void setTotalOVT(int TotalOVT) {
        this.TotalOVT = TotalOVT;
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

    
}
