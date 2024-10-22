package org.example.CR2.T5;

/*1. Создайте класс компания Company, содержащей сотрудников и реализующей методы:
•	найм одного сотрудника — hire(),
•	найм списка сотрудников – hireAll(),
•	увольнение сотрудника – fire(),
•	получение значения дохода компании – getIncome().
*/

public class CompanyT5 {
    //Поле список сотрудников, содержащее 3 класса сотрудников: OperatorT5, ManagerT5, TopManagerT5
    public EmployeeT5[] employees;
    public double monthIncome;

    //Конструктор класса CompanyT5
    public CompanyT5(EmployeeT5[] employees, double monthIncome) {
        this.employees = employees;
        this.monthIncome = monthIncome;
    }

    public CompanyT5(){
        CompanyT5 newCompany = new CompanyT5(new EmployeeT5[0], 0);
        this.employees = newCompany.employees.clone();
        this.monthIncome = newCompany.monthIncome;
    }

    //Метод найм одного сотрудника
    public void hire(EmployeeT5 employee) {
        EmployeeT5[] newEmployees = new EmployeeT5[employees.length + 1];
        for (int i = 0; i < employees.length; i++) {
            newEmployees[i] = employees[i];
        }
        newEmployees[employees.length] = employee;
        this.employees = newEmployees;
    }

    //Метод найм списка сотрудников
    public void hireAll(EmployeeT5[] employees) {
        EmployeeT5[] newEmployees = new EmployeeT5[this.employees.length + employees.length];
        for (int i = 0; i < this.employees.length; i++) {
            newEmployees[i] = this.employees[i];
        }
        for (int i = 0; i < employees.length; i++) {
            newEmployees[this.employees.length + i] = employees[i];
        }
        this.employees = newEmployees;
    }

    //Метод увольнения сотрудника
    public void fire(EmployeeT5 employee) {
        if (employee == null) {
            System.out.println("Сотрудник не найден");
        }
        else {
            EmployeeT5[] newEmployees = new EmployeeT5[employees.length - 1];
            int index = 0;
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != employee) {
                    newEmployees[index] = employees[i];
                    index++;
                }
            }
        }
    }

    //Метод получения значения дохода компании
    public double getIncome() {
        return monthIncome;
    }

    //Метод, возвращающий список сотрудников, отсортированный по возрастанию дохода
    public EmployeeT5[] getSortedEmployees() {
        EmployeeT5[] sortedEmployees = new EmployeeT5[employees.length];
        for (int i = 0; i < employees.length; i++) {
            sortedEmployees[i] = employees[i];
        }
        for (int i = 0; i < sortedEmployees.length; i++) {
            for (int j = i + 1; j < sortedEmployees.length; j++) {
                if (sortedEmployees[i].getSalary() > sortedEmployees[j].getSalary()) {
                    EmployeeT5 temp = sortedEmployees[i];
                    sortedEmployees[i] = sortedEmployees[j];
                    sortedEmployees[j] = temp;
                }
            }
        }
        return sortedEmployees;
    }

    //Список сотрудников, отсортированный по возрастанию дохода
    public EmployeeT5[] getLowestSalaryStaff(int length){
        EmployeeT5[] getLowestSalary = new EmployeeT5[length];
        EmployeeT5[] employees = getSortedEmployees();
        for (int i = 0; i < length; i++) {
            getLowestSalary[i] = employees[i];
        }
        return getLowestSalary;
    }

    //Список сотрудников, отсортированный по убыванию дохода
    public EmployeeT5[] getTopSalaryStaff(int length){
        EmployeeT5[] getTopSalary = new EmployeeT5[length];
        EmployeeT5[] employees = getSortedEmployees();
        for (int i = 0; i < length; i++) {
            getTopSalary[i] = employees[employees.length - 1 - i];
        }
        return getTopSalary;
    }

}
