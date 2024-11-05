package org.example.CR2.T5;

public class TopManagerT5 extends EmployeeT5{

    public TopManagerT5(String lastName, String firstName, String middleName, double fixedSalary, double profit, CompanyT5 companyT5) {
        super(lastName, firstName, middleName, fixedSalary, profit, companyT5);
    }

    public double getSalary() {
        if (companyT5.getIncome() > 10000000)
            return fixedSalary * 2.5;
        else
            return fixedSalary;
    }

    public String getInfo() {
        return "Топ-менеджер: " + lastName + " " + firstName + " " + middleName + " " + fixedSalary;
    }
}
