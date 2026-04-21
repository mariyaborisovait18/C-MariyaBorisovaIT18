package ru.borisova.main;

import ru.borisova.util.InputUtils;

/**
 * Task7 — демонстрация работы с пакетами и возведения в степень.
 */
public class Task7 {
  
  /**
   * Запускает выполнение задания 7.
   */
  public static void run() {
    System.out.println("=== Задание 7: Пакеты + Возведение в степень ===");
    
    // FIXME: По условию задания X и Y должны вводиться как строки, а не как числа.
        /*
        int x = InputUtils.readInt("Введите число X: ");
        int y = InputUtils.readInt("Введите число Y: ");

        double result = pow(x, y);

        System.out.println("Результат: " + x + "^" + y + " = " + result);
        */
    String x = InputUtils.readNonEmptyString("Введите число X: ");
    String y = InputUtils.readNonEmptyString("Введите число Y: ");
    
    double result = pow(x, y);
    
    printResult(x, y, result);
  }
  
  /**
   * Возводит число в степень, преобразуя строки в целые числа.
   *
   * @param x основание в виде строки
   * @param y показатель степени в виде строки
   * @return результат возведения в степень
   */
  private static double pow(String x, String y) {
    int a = Integer.parseInt(x);
    int b = Integer.parseInt(y);
    return Math.pow(a, b);
  }
  
  /**
   * Выводит результат возведения в степень.
   *
   * @param x основание
   * @param y показатель
   * @param result вычисленный результат
   */
  private static void printResult(String x, String y, double result) {
    System.out.println("Результат: " + x + "^" + y + " = " + result);
  }
}
