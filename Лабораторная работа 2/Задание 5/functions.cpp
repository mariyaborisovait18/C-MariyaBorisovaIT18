#include "functions.h"

// Дружественный интерфейс — перегрузка оператора вывода (Чтобы не писать лишний код) 
std::ostream& operator<<(std::ostream& os, const std::deque<int>& d) {
  for (std::deque<int>::const_iterator it = d.begin(); it != d.end(); ++it) {
    os << *it << " ";
  }
  return os;
}

/* MyFIX:
1) Исправлено расположение фигурных скобок.
2) Добавлена стандартная библиотека standard - std.
FixME: Нет выполнения условия задания:
1) Не используется конструктор контейнера с итераторами.
2) Не используется итератор для доступа к элементам.
3) Нет демонстрации работы с диапазоном итераторов.
4) Нет константного значения у неизменяемых переменных.
/* 
void FuncInsert(deque<int>& D)
{
  size_t N = D.size();

  // Вычисляем индекс среднего элемента
  size_t MiddleIndex = N / 2;

  // Получаем пять средних элементов
  deque<int> MiddleElements;
  for (size_t i = MiddleIndex - 2; i <= MiddleIndex + 2; ++i)
  {
    MiddleElements.push_back(D[i]);
  }

  // Вставляем пять средних элементов в начало дека
  D.insert(D.begin(), MiddleElements.begin(), MiddleElements.end());
}
*/

// Вставка пяти средних элементов
void InsertMiddleFive(std::deque<int>& d) {
  const size_t size = d.size();
  const size_t middle_index = size / 2;

  std::deque<int> middle_elements(
    d.begin() + (middle_index - 2),
    d.begin() + (middle_index + 3));

  d.insert(d.begin(), middle_elements.begin(), middle_elements.end());
}


/*MyFIX:
1) Исправлено расположение фигурных скобок.
2) Добавлена стандартная библиотека standard - std.*/
// Ввод с клавиатуры
std::deque<int> FuncKeyboard() {
  int count;
  std::cout << "Введите количество целых чисел (нечетное и >= 5): ";
  std::cin >> count;

  while (count < 5 || count % 2 == 0) {
    std::cout << "Количество должно быть нечетным и >= 5. Повторите ввод: ";
    std::cin >> count;
  }

  std::deque<int> d;
  std::cout << "Введите " << count << " целых чисел:\n";

  for (int i = 0; i < count; ++i) {
    int number;
    std::cin >> number;
    d.push_back(number);
  }

  return d;
}

/*MyFIX:
1) Исправлено расположение фигурных скобок.
2) Добавлена стандартная библиотека standard - std.*/
// Генерация случайных чисел
std::deque<int> FuncRandom(int count) {
  std::deque<int> d;

  /*FixME: Использование 0 предполагает разные виды значений (0 - число (которое иногда превращается в указатель)).
  srand(static_cast<unsigned>(time(0))); */
  std::srand(static_cast<unsigned>(std::time(nullptr)));

  for (int i = 0; i < count; ++i) {
    d.push_back(std::rand() % 100);
  }

  return d;
}

/*MyFIX:
1) Исправлено расположение фигурных скобок.
2) Добавлена стандартная библиотека standard - std.
3) Реализована верная логика последовательности выполнения кода.*/
// Чтение из файла
std::deque<int> FuncFile() {
  std::deque<int> d;
  std::ifstream infile("a.txt");

  if (!infile.is_open()) {
    throw std::runtime_error("Не удалось открыть файл.");
  }

  int number;
  while (infile >> number) {
    d.push_back(number);
  }

  if (d.size() < 5 || d.size() % 2 == 0) {
    throw std::invalid_argument(
      "Количество чисел в файле должно быть нечетным и >= 5.");
  }

  return d;
}