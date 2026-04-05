/* FixME: используется 4 пробела вместо 2 - исправлено средой разработки)*/
/* FixME: наличие Javadoc обязательно*/

/**
 * Класс Name представляет имя человека в формате:
 * <ul>
 *     <li>фамилия</li>
 *     <li>имя</li>
 *     <li>отчество (опционально)</li>
 * </ul>
 * Поддерживает различные варианты создания объекта:
 * только имя, имя + фамилия, полное ФИО.
 */
public class Name {
  private String surname;
  private String personalName;
  private String patronymic;
  
  /**
   * Создаёт объект Name с фамилией, именем и отчеством.
   *
   * @param surname      фамилия
   * @param personalName имя
   * @param patronymic   отчество
   */
  public Name(String surname, String personalName, String patronymic) {
    this.surname = surname;
    this.personalName = personalName;
    this.patronymic = patronymic;
  }
  
  /**
   * Создаёт объект Name с фамилией и именем.
   * Отчество отсутствует.
   *
   * @param surname      фамилия
   * @param personalName имя
   */
  public Name(String surname, String personalName) {
    this.surname = surname;
    this.personalName = personalName;
    this.patronymic = null;
  }
  
  /**
   * Создаёт объект Name только с именем.
   * Фамилия и отчество отсутствуют.
   *
   * @param personalName имя
   */
  public Name(String personalName) {
    this.surname = null;
    this.personalName = personalName;
    this.patronymic = null;
  }
  
  /**
   * Возвращает фамилию.
   *
   * @return фамилия или null
   */
  public String getSurname() {
    return surname;
  }
  
  /**
   * Возвращает имя.
   *
   * @return имя
   */
  public String getPersonalName() {
    return personalName;
  }
  
  /**
   * Возвращает отчество.
   *
   * @return отчество или null
   */
  public String getPatronymic() {
    return patronymic;
  }
  
  /**
   * Устанавливает фамилию.
   *
   * @param surname новая фамилия
   */
  public void setSurname(String surname) {
    this.surname = surname;
  }
  
  /**
   * Устанавливает имя.
   *
   * @param personalName новое имя
   */
  public void setPersonalName(String personalName) {
    this.personalName = personalName;
  }
  
  /**
   * Устанавливает отчество.
   *
   * @param patronymic новое отчество
   */
  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }
  
  /* FixME: конструкторы должны следовать после полей */
//    public Name(String surname, String personalName, String patronymic) {
//        this.surname = surname;
//        this.personalName = personalName;
//        this.patronymic = patronymic;
//    }
//
//    public Name(String surname, String personalName) {
//        this.surname = surname;
//        this.personalName = personalName;
//        this.patronymic = null;
//    }
//
//    public Name(String personalName) {
//        this.surname = null;
//        this.personalName = personalName;
//        this.patronymic = null;
//    }
  
  /**
   * Возвращает строковое представление имени.
   * Формирует корректную строку, пропуская отсутствующие части.
   *
   * @return строка вида "Фамилия Имя Отчество"
   */
  @Override
  public String toString() {
    String result = "";
    if (surname != null && !surname.isEmpty()) {
      result += surname;
    }
    if (personalName != null && !personalName.isEmpty()) {
      if (!result.isEmpty()) result += " ";
      result += personalName;
    }
    if (patronymic != null && !patronymic.isEmpty()) {
      if (!result.isEmpty()) result += " ";
      result += patronymic;
    }
    return result;
  }
}
