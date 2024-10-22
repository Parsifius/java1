package org.example.CR2.T1;

public class HourWorkerT1 extends WorkerT1 {
    //Поля имя, фамилия, профессия
    String name, surname, profession;
    //Поля количество денег, почасовая ставка
    double balance, hourRate;

    //Конструктор без параметров
    public HourWorkerT1() {
        super();
        this.hourRate = 0;
    }

    //Конструктор со всеми параметрами
    public HourWorkerT1(String name, String surname, String profession, double balance, double rate) {
        super(name, surname, profession, balance);
        this.hourRate = 0;
    }

    //Метод начисления зарплаты в зависимости от количества часов
    public void salary(int hour){
        super.salary(this.hourRate*hour);
    }

    @Override
    public String getInfo(){
        return super.getInfo()+", зарплата за час: " + this.hourRate + "\n";
    }

}
