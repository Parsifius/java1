package org.example.CR2.extra1;
/*Класс RationalFraction - рациональная дробь. Атрибуты - два целых числа (числитель и знаменатель). Методы:
•	RationalFraction() - конструктор для дроби, равной нулю;
•	RationalFraction(int, int) - конструктор дроби со значениями числителя и знаменателя; в конструкторах устраняйте дублирование кода;
•	void reduce() - сокращение дроби;
•	RationalFraction add(RationalFraction) - сложение дроби с другой дробью, результат возвращается как новый объект (не забудьте сократить)
•	void add2(RationalFraction) - сложение дроби с другой дробью, результат сохраняется в том, у кого был вызван этот метод (не забудьте сократить);
•	RationalFraction sub(RationalFraction) - вычитание из дроби другой дроби, результат возвращается как новый объект (не забудьте сократить);
•	void sub2(RationalFraction) - вычитание из дроби другой дроби, результат сохраняется в том, у кого был вызван этот метод (не забудьте сократить);
•	RationalFraction mult(RationalFraction) - умножение дроби на другую дробь, результат возвращается как новый объект (сократить)
•	void mult2(RationalFraction) - умножение дроби на другую дробь, результат сохраняется;
•	RationalFraction div(RationalFraction) - деление дроби на другую дробь, результат возвращается как новый объект (сократить)
•	void div2(RationalFraction) - деление дроби на другую дробь, результат сохраняется; больше не буду писать "возвращается" или "сохраняется", думаю, уже и так понятно.
•	String toString() - строковое представление дроби (например, -2/3);
•	double value() - десятичное значение дроби;
•	boolean equals(RationalFraction) - сравнить дробь с другой дробью
•	(не забывайте, что 2/4 и 1/2 - одна и та же дробь)
•	int numberPart() - целая часть дроби;
*/

//От себя еще добавил сортировки дробей

public class RationalFraction implements Comparable <RationalFraction> {
    //Поля числитель и знаменатель
    Integer numerator, denominator;

    //Вспомогательный метод НОД
    private Integer gcd(Integer a, Integer b)
    {
        return a == 0 ? b : gcd(b % a, a);
    }

    //Конструктор по умолчаниию (дробь ноль первых)
    public RationalFraction()
    {
        this(0,1 );
    }

    //Конструктор
    //Обрабатываем исключение нулевого знаменателя в конструкторе
    public RationalFraction(Integer numerator, Integer denominator) throws ArithmeticException
    {
        this.numerator = numerator;
        this.denominator = denominator;
        if (denominator == 0)
            throw new ArithmeticException("Нельзя разделить на ноль");
        if (denominator < 0)
            throw new ArithmeticException("Знаменателем не может быть отрицательное число");
    }

    //Метод сокращения дроби
    public void reduce()
    {
        Integer gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    //Метод сложения двух дробей с возвратом результата
    public RationalFraction add(RationalFraction other)
    {
        Integer newDenominator = this.denominator * other.denominator / gcd(this.denominator, other.denominator);
        Integer newNumerator = this.numerator * (newDenominator / this.denominator) + other.numerator * (newDenominator / other.denominator);
        RationalFraction result = new RationalFraction(newNumerator, newDenominator);
        result.reduce();
        return result;
    }

    //Метод прибавления дроби к текущей
    public void add2(RationalFraction other)
    {
        RationalFraction result = add(other);
        this.numerator = result.numerator;
        this.denominator = result.denominator;
        this.reduce();
    }

    //Метод вычитания двух дробей с возвратом результата
    public RationalFraction sub(RationalFraction other)
    {
        RationalFraction result = add(new RationalFraction(-other.numerator, other.denominator));
        result.reduce();
        return result;
    }

    //Метод вычитания дроби из текущей
    public void sub2(RationalFraction other)
    {
        RationalFraction result = sub(other);
        this.numerator = result.numerator;
        this.denominator = result.denominator;
        this.reduce();
    }

    //Метод умножения двух дробей с возвратом результата
    public RationalFraction mult(RationalFraction other)
    {
        RationalFraction result = new RationalFraction(this.numerator * other.numerator, this.denominator * other.denominator);
        result.reduce();
        return result;
    }

    //Метод умножения текущей дроби на другую
    public void mult2(RationalFraction other)
    {
        RationalFraction result = mult(other);
        this.numerator = result.numerator;
        this.denominator = result.denominator;
        this.reduce();
    }

    //Метод деления двух дробей с возвратом результата с обработкой исключения деления на ноль (за счет реализации логики через конструктор)
    public RationalFraction div(RationalFraction other)
    {
        RationalFraction result = mult(new RationalFraction(other.denominator, other.numerator));
        result.reduce();
        return result;
    }

    //Метод деления текущей дроби на другую с обработкой исключения деления на ноль (за счет реализации логики через метод деления, который реализован через конструктор)
    public void div2(RationalFraction other)
    {
        RationalFraction result = div(other);
        this.numerator = result.numerator;
        this.denominator = result.denominator;
        this.reduce();
    }

    //Метод строкового представления дроби (переопредеяет toString object'a)
    @Override
    public String toString()
    {
        return numerator + "/" + denominator;
    }

    //Метод вычисления значения дроби (в числах с плавающей точкой)
    public double value()
    {
        return (double) this.numerator / (double) this.denominator;
    }

    //Метод проверки на равенство текущей дроби другой
    boolean equals(RationalFraction other)
    {
        this.reduce();
        other.reduce();
        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    //Метод получения целой части дроби (важно: [-6,5] = -7)
    int numberPart()
    {
        return (int) Math.floor(this.value());
    }

    //Метод получения дробной части дроби (важно: [-6,5] = 0.5)
    double fractionalPart()
    {
        return this.value() - this.numberPart();
    }

    //ДОПОЛНИТЕЛЬНО ОТ СЕБЯ: Метод сравнения двух дробей с возвратом результата для возможности сортировки
    @Override
    public int compareTo(RationalFraction rationalFraction) {
        if (this.value() < rationalFraction.value())
            return -1;
        if (this.value() > rationalFraction.value())
            return 1;
        return 0;
    }
}
