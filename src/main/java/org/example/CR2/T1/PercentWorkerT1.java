package org.example.CR2.T1;

public class PercentWorkerT1 extends WorkerT1{
    //Поля имя, фамилия, профессия
    String name, surname, profession;
    //Поле количество денег, процент
    double balance, percent;

    public PercentWorkerT1(String name, String surname, String profession, double balance, double percent) {
        super(name, surname, profession, balance);
        this.balance = balance;
        this.percent = percent;
    }

    //Метод начисления зарплаты в зависимости от дохода компании
    public void salary(double income) {
        super.salary(income*percent/100);
    }

    @Override
    public String getInfo(){
        return super.getInfo() + "Процент: " + percent;
    }
}
