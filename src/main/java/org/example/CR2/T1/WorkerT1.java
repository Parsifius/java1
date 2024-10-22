package org.example.CR2.T1;

/*Создать базовый класс – работник, и производные классы –
служащий с почасовой оплатой, служащий в штате и служащий с процентной ставкой.
Определить функцию начисления зарплаты */

public class WorkerT1 {
    //Поля имя, фамилия, профессия
    String name, surname, profession;
    //Поле количество денег
    double balance;

    //Конструктор без параметров
    public WorkerT1() {
        this.name = "Имя не указано";
        this.surname = "Фамилия не указана";
        this.profession = "Профессия не указана";
        this.balance = 0;
    }

    //Конструктор с параметрами имя, фамилия, профессия
    public WorkerT1(String name, String surname, String profession) {
        WorkerT1 worker = new WorkerT1(name, surname, profession, 0);
        this.name = worker.name;
        this.surname = worker.surname;
        this.profession = worker.profession;
        this.balance = worker.balance;
    }

    //Конструктор с параметрами имя, фамилия, профессия, баланс
    public WorkerT1(String name, String surname, String profession, double balance) {
        this.name = name;
        this.surname = surname;
        this.profession = profession;
        this.balance = balance;
    }

    //Метод начисления зарплаты
    public void salary(double salary){
        balance += salary;
    }

    //Информация о сотруднике
    public String getInfo(){
        return "Имя: " + name + "\nФамилия: " + surname + "\nПрофессия: " + profession + "\nБаланс: " + balance + "\n";
    }
}
