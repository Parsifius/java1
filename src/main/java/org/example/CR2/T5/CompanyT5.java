package org.example.CR2.T5;

/*1. Создайте класс компания Company, содержащей сотрудников и реализующей методы:
•	найм одного сотрудника — hire(),
•	найм списка сотрудников – hireAll(),
•	увольнение сотрудника – fire(),
•	получение значения дохода компании – getIncome().
*/

import java.util.*;

public class CompanyT5 {
    //Поле список сотрудников, содержащее 3 класса сотрудников: OperatorT5, ManagerT5, TopManagerT5
    public List<EmployeeT5> employees;

    //Конструктор класса CompanyT5
    public CompanyT5(List<EmployeeT5> employees) {
        this.employees = employees;
    }

    public CompanyT5(){
        this.employees = new ArrayList();
    }

    //Метод найм одного сотрудника
    public void hire(EmployeeT5 employee) {
        this.employees.add(employee);
    }

    //Метод найм списка сотрудников
    public void hireAll(List<EmployeeT5> newEmployees) {
        this.employees.addAll(newEmployees);
    }

    //Метод увольнения сотрудника
    public void fire(EmployeeT5 employee) {
        if (employee == null) {
            System.out.println("Сотрудник не найден");
        }
        else {
            employees.remove(employee);
        }
    }

    //Метод получения значения дохода компании
    public double getIncome() {
        double res = 0;
        for (EmployeeT5 employeeT5 : employees)
            res += employeeT5.profit;
        return res;
    }

    // Метод, возвращающий список сотрудников, отсортированный по возрастанию дохода
    public List<EmployeeT5> getLowestSalaryStaff() {
        List<EmployeeT5> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees, new Comparator<EmployeeT5>() {
            @Override
            public int compare(EmployeeT5 o1, EmployeeT5 o2) {
                if (o1.profit < o2.profit)
                    return -1;
                if (o1.profit > o2.profit)
                    return 1;
                return 0;
            }
        });
        return sortedEmployees;
    }

    // Метод, возвращающий список сотрудников, отсортированный по возрастанию дохода
    public List<EmployeeT5> getTopSalaryStaff() {
        List<EmployeeT5> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees, new Comparator<EmployeeT5>() {
            @Override
            public int compare(EmployeeT5 o1, EmployeeT5 o2) {
                if (o1.profit > o2.profit)
                    return -1;
                if (o1.profit < o2.profit)
                    return 1;
                return 0;
            }
        });
        return sortedEmployees;
    }

}
