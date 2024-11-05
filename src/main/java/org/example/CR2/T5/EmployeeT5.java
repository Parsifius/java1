package org.example.CR2.T5;

public abstract class EmployeeT5 {
    //Поле компании
    CompanyT5 companyT5;
    //Поля фамилия, Имя, Отчество
    String lastName, firstName, middleName;
    //Поле фиксированная часть зарплаты, приносимый доход
    double fixedSalary, profit;

    //Конструктор
    EmployeeT5(String lastName, String firstName, String middleName, double fixedSalary, double profit, CompanyT5 companyT5) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.fixedSalary = fixedSalary;
        this.profit = profit;
        this.companyT5 = companyT5;
    }

    //Метод получения информации о сотруднике
    public abstract String getInfo();

    //Метод получения зарплаты
    public abstract double getSalary();
}
