package org.example.CR2.T5;

public class OperatorT5 extends EmployeeT5{
    //Поля фамилия, Имя, Отчество
    public String lastName, firstName, middleName;
    //Поле фиксированная часть зарплаты
    public double fixedSalary;

    public OperatorT5(String lastName, String firstName, String middleName, double fixedSalary) {
        super(lastName, firstName, middleName, fixedSalary);
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
