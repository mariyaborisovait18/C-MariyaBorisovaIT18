/* FixME: запрещены комментарии, должны использоваться Javadoc */
/* FixME: используется 4 пробела вместо 2 - исправлено средой разработки)*/

import java.util.HashMap;
import java.util.Map;

/**
 * Класс City представляет город и набор путей (дорог) до других городов.
 * Каждый путь содержит стоимость (вес), например расстояние или время.
 * <p>
 * Используется в заданиях 3.3 и 4.8 для демонстрации графовой структуры.
 */
public class City {
  
  private String name;
  private Map<City, Integer> paths;
  
  /**
   * Создаёт город с указанным именем и пустым набором путей.
   *
   * @param name имя города
   */
  public City(String name) {
    this.name = name;
    this.paths = new HashMap<>();
  }
  
  /**
   * Создаёт город с указанным именем и набором путей.
   * Map копируется, чтобы защитить внутреннее состояние объекта.
   *
   * @param name  имя города
   * @param paths карта путей (город → стоимость)
   */
  public City(String name, Map<City, Integer> paths) {
    this.name = name;
    this.paths = new HashMap<>(paths);
  }
  
  /**
   * Добавляет путь от текущего города к другому городу.
   *
   * @param city город назначения
   * @param cost стоимость пути
   */
  public void addPath(City city, int cost) {
    paths.put(city, cost);
  }
  
  /**
   * Возвращает имя города.
   *
   * @return имя города
   */
  public String getName() {
    return name;
  }

    /* FixME: Некорректное представление
        (нет корректного доступа к map,
        нет конкатенации строк,
        нарушение вида Google Style Java) */
//    @Override
//    public String toString() {
//        String result = name + ":\n";
//        for (City city : paths.keySet()) {
//            result += "  " + city.getName() + ": " + paths.get(city) + "\n";
//        }
//        return result;
//    }
  
  /**
   * Возвращает строковое представление города и всех его путей.
   * Формат:
   * <pre>
   * A:
   *   B: 5
   *   F: 1
   * </pre>
   *
   * @return строка с перечислением всех путей
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(name + ":\n");
    for (Map.Entry<City, Integer> entry : paths.entrySet()) {
      result.append("  ")
          .append(entry.getKey().getName())
          .append(": ")
          .append(entry.getValue())
          .append("\n");
    }
    return result.toString();
  }
}
