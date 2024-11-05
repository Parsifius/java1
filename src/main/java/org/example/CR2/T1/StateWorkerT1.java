package org.example.CR2.T1;

import java.util.Date;

public class StateWorkerT1 extends WorkerT1{
    //Дополнительное поле Месячная зарплата
    double monthRate;
    //Поле даты начала работы в компании
    Date dateStart;

    public StateWorkerT1(String name, String surname, String profession, double balance, double monthRate, Date dateStart) {
        super(name, surname, profession, balance);
        this.monthRate = monthRate;
        this.dateStart = dateStart;
    }

    public StateWorkerT1() {
        super();
        this.monthRate = 0;
        this.dateStart = new Date();
    }

    //Начисление зарплаты
    public void salary(){
        balance += monthRate;
    }

    //Начисление зарплаты с премией и штрафами
    public void salary(double bonus, double penalty) {
        balance += monthRate + bonus - penalty;
    }

    @Override
    public String getInfo(){
        return super.getInfo()+", зарплата за месяц: " + monthRate + "\n" + "Дата начала работы: " + dateStart;
    }
}
