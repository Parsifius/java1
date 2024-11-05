package org.example.CR2.T5;

public class ManagerT5 extends EmployeeT5{



    public ManagerT5(String lastName, String firstName, String middleName, double fixedSalary, double profit, CompanyT5 companyT5) {
        super(lastName, firstName, middleName, fixedSalary, profit, companyT5);
    }

    public double getSalary() {
        return fixedSalary + 0.05 * profit;
    }

    @Override
    public String getInfo() {
        return "Фамилия: " + lastName + "\n" +
                "Имя: " + firstName + "\n" +
                "Отчество: " + middleName + "\n" +
                "Зарплата: " + fixedSalary + "\n";
    }
}
