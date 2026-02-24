
/*FIX_ME:
1)// для многострочных комментариев.
2)Длина строки более 80-ти символов.
*/
//Археолог нашел N артефактов.Известны веса(сi) и ценности(di) артефактов.Нужно
//выбрать такое подмножество найденных вещей, чтобы суммарный их вес не превысил Z кг, а их
//общая ценность оказалась максимальной.Известно, что решение единственно.Укажите 
//порядковые номера вещей, которые нужно взять.Исходный данные находятся в текстовом файле, в
//первой строке указаны N и Z, а во второй строке значения весов(в кг), в третьей - ценность
//находок.Вывести так же суммарный вес и общую ценность результата.

/*Археолог нашел N артефактов. Известны веса(сi) и ценности(di) артефактов.
Нужно выбрать такое подмножество найденных вещей, чтобы суммарный их вес не
превысил Z кг, а их общая ценность оказалась максимальной. Известно, что
решение единственно. Укажите порядковые номера вещей, которые нужно взять.
Исходный данные находятся в текстовом файле, впервой строке указаны N и Z,
а во второй строке значения весов(в кг), в третьей - ценность
находок. Вывести так же суммарный вес и общую ценность результата.*/

#include <iostream>
#include <vector>
/*
FIX_ME:
1) Нет ввода данных из файла, что не соответствует условию задачи.*/
#include <fstream>

/*
FIX_ME:
1) Отступы: 4 пробела.
2) Пробелы: Лишние пробелы в циклах.
Весь код исправлен на отступы в 2 пробела и корректно расставлены пробелы.
*/

/*FIX_ME:
1) Вид названия класса: insert_sort.
2) Название переменных не информативно.*/
//void insert_sort(std::vector<int>& w, std::vector<int>& p) {
void InsertSort(std::vector<int>& weights, std::vector<int>& profits) {

  /*FIX_ME:
  1) weights.size() — это size_t,но переменная цикла типа int.
  2) Постфиксный инкремент.*/
  //for (int i = 1; i < w.size(); i++) {
  for (int i = 1; i < static_cast<int>(weights.size()); ++i) {

    /*FIX_ME:
    1) Длинное имя для индекса цикла.*/
    //int temp = i;
    int j = i;

    /*FIX_ME:
    1) temp - 1 вычисляется дважды.*/
    //while (temp - 1 >= 0 && w[temp] < w[temp - 1]) {
    while (j > 0 && weights[j] < weights[j - 1]) {
      //std::swap(w[temp], w[temp - 1]);
      //std::swap(p[temp], p[temp - 1]);
      std::swap(weights[j], weights[j - 1]);
      std::swap(profits[j], profits[j - 1]);

      /*FIX_ME:
      1) Постфиксный декремент.*/
      //temp--;
      --j;
    }
  }
}

bool ValidateInputFile(const std::string& filename) {
  std::ifstream fin(filename);
  if (!fin.is_open()) {
    std::cout << "Ошибка: не удалось открыть файл\n";
    return false;
  }

  int N = 0, Z = 0;
  if (!(fin >> N >> Z) || N <= 0 || Z < 0) {
    std::cout << "Ошибка: первая строка должна содержать два корректных числа (N > 0, Z >= 0)\n";
    return false;
  }

  std::vector<int> weights(N), values(N);

  for (int i = 0; i < N; ++i) {
    if (!(fin >> weights[i]) || weights[i] < 0) {
      std::cout << "Ошибка: во второй строке должно быть " << N
        << " неотрицательных чисел (веса)\n";
      return false;
    }
  }

  for (int i = 0; i < N; ++i) {
    if (!(fin >> values[i]) || values[i] < 0) {
      std::cout << "Ошибка: в третьей строке должно быть " << N
        << " неотрицательных чисел (ценности)\n";
      return false;
    }
  }

  // Проверка на лишние данные
  std::string extra;
  if (fin >> extra) {
    std::cout << "Ошибка: файл содержит лишние данные после третьей строки\n";
    return false;
  }

  return true;
}

/*FIX_ME:
1) По заданию должно быть чтение данных из файла.*/
// Функция ввода данных из файла 
bool ReadInputFromFile(const std::string& filename,
  int& item_count,
  int& capacity,
  std::vector<int>& weights,
  std::vector<int>& values)
{
  std::ifstream fin(filename);
  if (!fin.is_open()) {
    std::cout << "Ошибка: не удалось открыть файл\n";
    return false;
  }

  fin >> item_count >> capacity;

  weights.resize(item_count);
  values.resize(item_count);

  for (int i = 0; i < item_count; ++i)
    fin >> weights[i];

  for (int i = 0; i < item_count; ++i)
    fin >> values[i];

return true;
}

/*FIX_ME:
1) По заданию мы должны знать суммарный вес и номера вещей.*/
// Функция для последующего чтения суммарного веса и номеров вещей
std::vector<int> RestoreItems(const std::vector<std::vector<int>>& dp,
                              const std::vector<int>& weights,
                              const std::vector<int>& values,
                              int capacity,
                              int item_count)
{
  std::vector<int> chosen;
  int w = capacity;

  for (int i = item_count; i > 0; --i) {
    if (dp[i][w] != dp[i - 1][w]) {
      // предмет взят
      chosen.push_back(i);
      w -= weights[i - 1];
    }
  }

  std::reverse(chosen.begin(), chosen.end());
  return chosen;
}


/*FIX_ME:
1) Вид названия функции: backpack.
2) Название переменных не информативно.
3) Строка более 80-ти символов.
4) Функция не имеет права менять переменные.
5) По заданию нужно вернуть всю таблицу, а не одно число */
//int backpack(int W, std::vector<int>& wt, std::vector<int>& val, int n) {
std::vector<std::vector<int>> BackpackDP(int capacity,
                                        const std::vector<int>& weights,
                                        const std::vector<int>& values,
                                        int item_count)
{
  /*FIX_ME:
  1) Строка более 80-ти символов.
  2) Название переменных не информативно.*/
  //std::vector<std::vector<int>> dp(n + 1, std::vector<int>(W + 1));
  std::vector<std::vector<int>> dp(item_count + 1, 
    std::vector<int>(capacity + 1, 0));

  /*FIX_ME:
  1) Постфиксные инкременты.
  2) Блок if и else без {} (фигурных скобок).
  3) Комментарии в строке кода, а не над ней.
  4) Размер строки более 80-ти символов
  5) Не выполняется условие задачи, возвращала только максимальную ценность.*/
  /*for (int i = 0; i <= n; i++) {
      for (int w = 0; w <= W; w++) {
          if (i == 0 || w == 0)
              dp[i][w] = 0; // нет предметов или вес рюкзака равен 0
          else if (wt[i - 1] <= w)
              // Выбор между включением и исключением текущего предмета
              dp[i][w] = std::max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
          else
              // Текущий предмет не вмещается в рюкзак
              dp[i][w] = dp[i - 1][w];
      }
  }
    return dp[n][W];*/
  for (int i = 1; i <= item_count; ++i) {
    for (int w = 0; w <= capacity; ++w) {
      // i = 0 уже заполнено нулями, поэтому начинаем с 1
      if (weights[i - 1] <= w) 
      { dp[i][w] = std::max(
        values[i - 1] + dp[i - 1][w - weights[i - 1]], 
        dp[i - 1][w]); 
      } else { 
        dp[i][w] = dp[i - 1][w];
      }
    }
  }
  return dp;
}

/*FIX_ME:
1) Начинающая скобка ({) в новой строке.*/
/*int main()
{*/
int main() {
  /*FIX_ME:
  1) Нет std перед setlocale.*/
  //setlocale(LC_ALL, "ru");
  std::setlocale(LC_ALL, "ru");

  /*FIX_ME:
  1) Название переменных не информативно.
  2) Переменные несут разный смысл, но пишутся в одной строке*/
  //int n, W;
  int item_count = 0;
  int capacity = 0;

  /*FIX_ME:
  1) По условию задания сказано что исходные данные находятся в файле, то есть ввод в ручную не предусмотрен.
  2) Постфиксный инкремент.
  3) Нет логического деления блоков кода.
  4) Вид названия функции: insert_sort.
  5) Нет вывода данных по условию задачи*/

  /*do {
    std::cout << "Введите объем рюкзака >= 0: ";
    std::cin >> capacity;
  } while (capacity <= 0);

  do {
    std::cout << "Введите количество артефактов >= 0: ";
    std::cin >> item_count;
  } while (item_count <= 0);

  std::cout << "Поочередно вводите параметры артефактов\n";

  std::vector<int> profits(item_count);
  std::vector<int> weights(item_count);

  for (int i = 0; i < n; i++) {
      std::cout << std::endl << "Вес " << i + 1 << ": ";
      std::cin >> weight[i];
      std::cout << std::endl << "стоимость " << i + 1 << ": ";
      std::cin >> profit[i];
  }
  
  insert_sort(weight, profit);

  std::cout << "Максимальная возможная стоимость вещей, вместимых в рюкзак: " << backpack(W, weight, profit, n) << std::endl;

  std::cout << "Максимальная возможная стоимость вещей, "
    "вместимых в рюкзак: "
    << Backpack << std::endl;*/

  std::vector<int> weights, values;

  if (!ValidateInputFile("input.txt")) {
    return 1;
  }

  if (!ReadInputFromFile("input.txt", item_count, capacity, weights, values)) {
    return 1;
  }

  auto dp = BackpackDP(capacity, weights, values, item_count);
  auto chosen = RestoreItems(dp, weights, values, capacity, item_count);

  int total_weight = 0;
  int total_value = dp[item_count][capacity];

  std::cout << "Выбранные предметы: ";
  for (int id : chosen) {
    std::cout << id << " ";
    total_weight += weights[id - 1];
  }

  std::cout << "\nСуммарный вес: " << total_weight;
  std::cout << "\nСуммарная ценность: " << total_value << "\n";

  return 0;
}