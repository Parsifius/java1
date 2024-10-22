package org.example.CR2.T5;

import javax.swing.table.TableCellRenderer;

public abstract class EmployeeT5 {
    //Поля фамилия, Имя, Отчество
    String lastName, firstName, middleName;
    //Поле фиксированная часть зарплаты
    double fixedSalary;

    //Конструктор
    EmployeeT5(String lastName, String firstName, String middleName, double fixedSalary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.fixedSalary = fixedSalary;
    }

    //Метод получения информации о сотруднике
    public abstract String getInfo();

    public abstract double getSalary();
}
