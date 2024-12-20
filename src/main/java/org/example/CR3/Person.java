package org.example.CR3;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Pattern;

public class Person {

    //Поля класса
    //Поле имя
    private String name;
    //Поле дата рождения
    private Date birthDate;
    //Поле электронная почта
    private String email;

    //Геттеры и сеттеры
    //Геттер электронной почты
    public String getEmail() {
        return email;
    }
    //Сеттер электронной почты с проверкой на валидность устанавливаемого поля
    public void setEmail(String email) throws IOException {
        this.email = email;
        validateEmail();
    }
    //Геттер даты рождения
    public Date getBirthDate() {
        return birthDate;
    }
    //Сеттер даты рождения
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    //Геттер имени
    public String getName() {
        return name;
    }
    //Сеттер имени с проверкой на валидность устанавливаемого поля
    public void setName(String name) throws IOException{
        this.name = name;
        validateName();
    }

    //Метод получения текущего возраста
    public Integer getAge() {
        if ((new Date().getMonth() < this.birthDate.getMonth())||(new Date().getMonth() == this.birthDate.getMonth() && new Date().getDate() <= this.birthDate.getDate()))
            return new Date().getYear() - this.birthDate.getYear() - 1 + 1900;
        return new Date().getYear() - this.birthDate.getYear() + 1900;
    }

    //Методы валидации полей класса
    //Валидация имени
    public void validateName() throws IOException {
        if (!Pattern.matches("^[A-ZА-Я][a-zA-Zа-яА-Я\\-]+$", this.name))
            throw new IllegalArgumentException("Некорректный формат имени");
    }
    //Валидация почты
    public void validateEmail() throws IOException {
        if (!Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", this.email))
            throw new IllegalArgumentException("Некорректный формат почты");
    }

    //Конструкторы класса
    //Конструктор по умолчанию
    public Person() {}
    //Конструктор с параметрами, реализующий проверки валидности устанавливаемых полей
    public Person(String name, Date birthDate, String email) throws IOException{
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        validateEmail();
        validateName();
    }
}
