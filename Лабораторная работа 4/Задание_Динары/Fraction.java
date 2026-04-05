/* FixME: запрещены комментарии, должны использоваться Javadoc */
/* FixME: используется 4 пробела вместо 2 - исправлено средой разработки)*/

import java.util.Scanner;

/**
 * Класс дроби с поддержкой операций +, -, *, / с дробями и целыми числами.
 * Все операции возвращают НОВЫЕ объекты Fraction.
 */
public class Fraction {
  private int numerator;
  private int denominator;
  
  /**
   * Создание дроби по числителю и знаменателю.
   */
  public Fraction(int numerator, int denominator) {
    if (denominator == 0) {
      /* FixME: просто сообщение о не допустимости */
      throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
    }
    this.numerator = numerator;
    this.denominator = denominator;
    simplify();
  }
  
  /**
   * Создание дроби через Scanner.
   */
  public Fraction(Scanner scanner) {
    inputFraction(scanner);
    simplify();
  }
  
  /**
   * Ввод дроби с проверкой.
   */
  private void inputFraction(Scanner scanner) {
    while (true) {
      System.out.print("Введите числитель: ");
      numerator = Correct.validateIntInput(scanner);
      
      System.out.print("Введите знаменатель: ");
      denominator = Correct.validateIntInput(scanner);
      
      if (denominator == 0) {
        System.out.println("Знаменатель не может быть равен нулю. Попробуйте снова.");
      } else {
        break;
      }
    }
  }
  
  /**
   * Упрощение дроби.
   */
  private void simplify() {
    /* FixME: некорректная обработка чисел */
    int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
    
    numerator /= gcd;
    denominator /= gcd;
    
    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }
  }
  
  /**
   * НОД (алгоритм Евклида).
   */
  private int gcd(int a, int b) {
    /* FixME: не каноничный способ записи */
    return (b == 0) ? a : gcd(b, a % b);
  }
  
  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }
  
  public Fraction sum(Fraction other) {
    int newNum = numerator * other.denominator + other.numerator * denominator;
    int newDen = denominator * other.denominator;
    return new Fraction(newNum, newDen);
  }
  
  public Fraction minus(Fraction other) {
    int newNum = numerator * other.denominator - other.numerator * denominator;
    int newDen = denominator * other.denominator;
    return new Fraction(newNum, newDen);
  }
  
  public Fraction multiply(Fraction other) {
    int newNum = numerator * other.numerator;
    int newDen = denominator * other.denominator;
    return new Fraction(newNum, newDen);
  }
  
  public Fraction div(Fraction other) {
    if (other.numerator == 0) {
      /* FixME: просто сообщение о не допустимости  */
      throw new IllegalArgumentException("Деление на ноль невозможно");
    }
    int newNumerator = numerator * other.denominator;
    int newDenominator = denominator * other.numerator;
    return new Fraction(newNumerator, newDenominator);
  }
  
  /* FixME: this не требуется */
  public Fraction sum(int value) {
    return sum(new Fraction(value, 1));
  }
  
  /* FixME: this не требуется */
  public Fraction minus(int value) {
    return minus(new Fraction(value, 1));
  }
  
  /* FixME: this не требуется */
  public Fraction multiply(int value) {
    return new Fraction(numerator * value, denominator);
  }
  
  public Fraction div(int value) {
    if (value == 0) {
      /* FixME: просто сообщение о не допустимости */
      throw new IllegalArgumentException("Деление на ноль невозможно");
    }
    return new Fraction(numerator, denominator * value);
  }
}
