package org.example.CR2.T1;

public class PercentWorkerT1 extends WorkerT1{
    //Дополнительное поле процент
    double percent;

    public PercentWorkerT1(String name, String surname, String profession, double balance, double percent) {
        super(name, surname, profession, balance);
        this.balance = balance;
        this.percent = percent;
    }

    //Метод начисления зарплаты в зависимости от дохода компании
    @Override
    public void salary(double income) {
        super.salary(income*percent/100);
    }

    @Override
    public String getInfo(){
        return super.getInfo() + "Процент: " + percent;
    }
}
