 /* FixME: запрещены комментарии, должны использоваться Javadoc */
 /* FixME: логика диктует постанову конструкторов перед методами класса */
 /* FixME: используется 4 пробела вместо 2 - исправлено средой разработки)*/
 
 /**
  * Класс Person представляет человека с именем (Name) и ростом.
  * Используется в заданиях 1.2, 1.3 и 2.2 для демонстрации работы с объектами.
  */
 public class Person {
   
   private Name name;
   private int height;
   
   /**
    * Конструктор для задания 1.2.
    * Создаёт объект Person по строковому имени и росту.
    *
    * @param name   строковое имя человека
    * @param height рост человека в сантиметрах
    */
   /* FixME: нет конструктора для реализации задания 1.2 */
   public Person(String name, int height) {
     this.name = new Name(name);
     this.height = height;
   }
   
   /**
    * Конструктор, принимающий объект Name и рост.
    *
    * @param name   объект Name (ФИО или его часть)
    * @param height рост человека в сантиметрах
    */
   public Person(Name name, int height) {
     this.name = name;
     this.height = height;
   }
   
   /**
    * Возвращает объект Name.
    *
    * @return имя человека
    */
   public Name getName() {
     return name;
   }
   
   /**
    * Возвращает рост человека.
    *
    * @return рост в сантиметрах
    */
   public int getHeight() {
     return height;
   }
   
   /**
    * Устанавливает новое имя.
    *
    * @param name объект Name
    */
   public void setName(Name name) {
     this.name = name;
   }
   
   /**
    * Устанавливает новый рост.
    *
    * @param height рост в сантиметрах
    */
   public void setHeight(int height) {
     this.height = height;
   }
   
   /* FixME: логика диктует постанову конструкторов перед методами класса */
//    public Person(String name, int height) {
//    public Person(Name name, int height) {
//        this.name = name;
//        this.height = height;
//    }
   
   /**
    * Возвращает строковое представление объекта Person.
    *
    * @return строка вида "Имя, рост: X"
    */
   @Override
   public String toString() {
     return name + ", рост: " + height;
   }
 }




