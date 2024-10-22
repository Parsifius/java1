package org.example.CR2.T5;

public class ManagerT5 extends EmployeeT5{
    //Поля фамилия, Имя, Отчество
    String lastName, firstName, middleName;
    //Поле фиксированная часть зарплаты, вклад
    double fixedSalary, impact;

    public ManagerT5(String lastName, String firstName, String middleName, double fixedSalary) {
        super(lastName, firstName, middleName, fixedSalary);
    }

    public double getSalary() {
        return fixedSalary + 0.05 * impact;
    }

    @Override
    public String getInfo() {
        return "Фамилия: " + lastName + "\n" +
                "Имя: " + firstName + "\n" +
                "Отчество: " + middleName + "\n" +
                "Зарплата: " + fixedSalary + "\n";
    }
}
