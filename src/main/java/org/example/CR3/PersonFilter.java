package org.example.CR3;

//Определение функционального интерфейса для фильтрации персон
//Содержит сигнатуру единственного нестатичного недефолтного метода
//Принимает на вход персону и определеяет, удовлетворяет ли она какому-то условию/условиям
@FunctionalInterface
public interface PersonFilter {
    Boolean filter(Person user);
}