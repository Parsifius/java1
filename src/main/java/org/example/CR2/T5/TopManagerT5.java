package org.example.CR2.T5;

public class TopManagerT5 extends EmployeeT5{
    //Поля фамилия, Имя, Отчество
    String lastName, firstName, middleName;
    //Поле фиксированная часть зарплаты, заработная плата его компании
    double fixedSalary, companyMonth;


    public TopManagerT5(String lastName, String firstName, String middleName, double fixedSalary) {
        super(lastName, firstName, middleName, fixedSalary);
    }

    public double getSalary() {
        if (companyMonth > 10000000)
            return fixedSalary * 2.5;
        else
            return fixedSalary;
    }


    public String getInfo() {
        return "Топ-менеджер: " + lastName + " " + firstName + " " + middleName + " " + fixedSalary;
    }
}
