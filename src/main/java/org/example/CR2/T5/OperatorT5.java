package org.example.CR2.T5;

public class OperatorT5 extends EmployeeT5{

    public OperatorT5(String lastName, String firstName, String middleName, double fixedSalary, double profit, CompanyT5 companyT5) {
        super(lastName, firstName, middleName, fixedSalary, profit, companyT5);
    }

    public double getSalary() {
        return fixedSalary;
    }

    public String getInfo() {
        return "Фамилия: " + lastName + "\n" +
                "Имя: " + firstName + "\n" +
                "Отчество: " + middleName + "\n" +
                "Фиксированная часть зарплаты: " + fixedSalary + "\n" +
                "Зарплата за месяц: " + getSalary();
    }
}
