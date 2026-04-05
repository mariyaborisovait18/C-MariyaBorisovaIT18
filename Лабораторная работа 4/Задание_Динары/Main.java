import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/* FixME: запрещены комментарии, должны использоваться Javadoc */
/* FixME: используется 4 пробела вместо 2 - исправлено средой разработки)
 
 */

/**
 * Главный класс программы, содержащий демонстрацию выполнения заданий 1.2–5.5.
 * Включает создание объектов Person, Name, City и Fraction,
 * а также демонстрацию их методов и взаимодействия.
 */

public class Main {
  /**
   * Точка входа в программу. Последовательно выполняет задания:
   * <ul>
   *     <li>1.2 — создание объектов Person</li>
   *     <li>1.3 — создание объектов Name</li>
   *     <li>2.2 — повторный вывод Person</li>
   *     <li>3.3 — построение схемы городов</li>
   *     <li>4.8 — демонстрация конструктора City с Map</li>
   *     <li>5.5 — работа с дробями Fraction</li>
   * </ul>
   *
   * @param args аргументы командной строки (не используются)
   */
  public static void main(String[] args) {
    /**
     * Задание 1.2: создание объектов Person.
     */
    System.out.println("Задание 1.2: ");
    Person cleopatraPerson = new Person("Клеопатра", 152);
    Person pushkinPerson = new Person("Пушкин", 167);
    Person vladimirPerson = new Person("Владимир", 189);
    
    System.out.println(cleopatraPerson);
    System.out.println(pushkinPerson);
    System.out.println(vladimirPerson);
    
    /**
     * Задание 1.3: создание объектов Name.
     */
    System.out.println();
    System.out.println("Задание 1.3: ");
    Name cleopatraName = new Name("Клеопатра");
    Name pushkinName = new Name("Пушкин", "Александр", "Сергеевич");
    Name vladimirName = new Name("Маяковский", "Владимир");
    
    System.out.println(cleopatraName);
    System.out.println(pushkinName);
    System.out.println(vladimirName);
    
    /* FixME: данное задание не требует вывода объектов с ростом */
//        Name cleopatraName = new Name("Клеопатра");
//        Name pushkinName = new Name("Пушкин", "Александр", "Сергеевич");
//        Name vladimirName = new Name("Маяковский", "Владимир");
//
//        Person cleopatraPerson = new Person(cleopatraName, 152);
//        Person pushkinPerson = new Person(pushkinName, 167);
//        Person vladimirPerson = new Person(vladimirName, 189);
    
    /**
     * Задание 2.2: повторный вывод Person.
     */
    System.out.println();
    System.out.println("Задание 2.2: ");
    
    System.out.println(cleopatraPerson);
    System.out.println(pushkinPerson);
    System.out.println(vladimirPerson);
    
    /**
     * Задание 3.3: создание схемы городов и связей.
     */
    System.out.println();
    System.out.println("Задание 3.3,");
    
    City A = new City("A");
    City B = new City("B");
    City C = new City("C");
    City D = new City("D");
    City E = new City("E");
    City F = new City("F");
    
    /* FixME: некорректное составление связей */
//      A.addPath(B, 5);
//      B.addPath(A, 5);
//
//      B.addPath(C, 3);
//      C.addPath(B, 3);
//
//      C.addPath(D, 4);
//      D.addPath(C, 4);
    
    A.addPath(B, 5);
    A.addPath(F, 1);
    
    F.addPath(B, 2);
    F.addPath(D, 2);
    F.addPath(E, 6);
    
    B.addPath(C, 1);
    
    D.addPath(C, 2);
    
    /* FixME: задание требует прямой вывод схемы */
//        Map<City, Integer> pathsForD = new HashMap<>();
//        pathsForD.put(A, 6);
//        pathsForD.put(E, 2);
//
//        pathsForD.put(C, 4);
//
//        D = new City("D", pathsForD);
//
//        Map<City, Integer> pathsForE = new HashMap<>();
//        pathsForE.put(F, 2);
//        pathsForE.put(D, 2);
//
//        E = new City("E", pathsForE);
//
//        Map<City, Integer> pathsForF = new HashMap<>();
//        pathsForF.put(E, 2);
//        pathsForF.put(B, 1);
//
//        F = new City("F", pathsForF);
//
//        Map<City, Integer> pathsForA = new HashMap<>();
//        pathsForA.put(B, 5);
//        pathsForA.put(F, 1);
//        pathsForA.put(D, 6);
//
//        A = new City("A", pathsForA);
    
    System.out.println("\nГорода:");
    City[] cities = {A, B, C, D, E, F};
    for (City city : cities) {
      System.out.println(city);
    }
    
    /**
     * Задание 4.8: демонстрация конструктора City(String, Map).
     */
    /* FixME:  задания должны быть разделены логикой */
    System.out.println();
    System.out.println("Задание 4.8:");
    
    Map<City, Integer> pathsForX = new HashMap<>();
    pathsForX.put(A, 10);
    pathsForX.put(C, 3);
    
    City X = new City("X", pathsForX);
    System.out.println(X);
    
    /**
     * Задание 5.5: работа с дробями Fraction.
     */
    System.out.println();
    System.out.println("Задание 5.5: ");
    
    Scanner scanner = new Scanner(System.in);
    
    Fraction f1 = new Fraction(scanner);
    System.out.println("Вы создали дробь f1: " + f1);
    
    Fraction f2 = new Fraction(scanner);
    System.out.println("Вы создали дробь f2: " + f2);
    
    Fraction f3 = new Fraction(scanner);
    System.out.println("Вы создали дробь f3: " + f3);
    
    System.out.println(f1 + " + " + f2 + " = " + f1.sum(f2));
    System.out.println(f1 + " - " + f2 + " = " + f1.minus(f2));
    System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
    System.out.println(f1 + " / " + f2 + " = " + f1.div(f2));
    
    Fraction result = f1.sum(f2).div(f3).minus(5);
    System.out.println("Результат выражения: f1.sum(f2).div(f3).minus(5) = (" + f1 + " + " + f2 + ") / " + f3 + " - 5 = " + result);
  }
}