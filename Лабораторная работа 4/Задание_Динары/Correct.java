/* FixME: используется 4 пробела вместо 2 - исправлено средой разработки)*/
/* FixME: наличие Javadoc обязательно*/

import java.util.Scanner;

/**
 * Утилитарный класс Correct содержит методы для безопасного ввода данных.
 * Предоставляет:
 * <ul>
 *     <li>валидацию целочисленного ввода</li>
 *     <li>валидацию строкового ввода</li>
 * </ul>
 * Методы работают в цикле до тех пор, пока пользователь не введёт корректное значение.
 */
public class Correct {
  /**
   * Валидирует ввод целого числа.
   * Метод использует nextLine(), чтобы избежать конфликтов между nextInt() и nextLine().
   * В случае ошибки выводит сообщение и запрашивает ввод повторно.
   *
   * @param scanner объект Scanner для чтения пользовательского ввода
   * @return корректное целое число
   */
  public static int validateIntInput(Scanner scanner) {
    while (true) {
      String input = scanner.nextLine().trim();
      /* FixME: некорректная обработка исключений */
      try {
        return Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("Некорректный ввод. Пожалуйста, попробуйте еще раз.");
      }
    }
  }
  
  /**
   * Валидирует ввод строки.
   * Метод не принимает пустые строки или строки, состоящие только из пробелов.
   *
   * @param scanner объект Scanner для чтения пользовательского ввода
   * @return непустая строка
   */
  public static String validateStringInput(Scanner scanner) {
    while (true) {
      String input = scanner.nextLine().trim();
      if (!input.isEmpty()) {
        return input;
      } else {
        System.out.println("Некорректный ввод. Пожалуйста, введите непустую строку.");
      }
    }
  }
}

