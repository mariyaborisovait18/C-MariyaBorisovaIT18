#include "Stack.h"

Node::Node(int value) : data(value), next(nullptr) {}

Stack::Stack() : top_(nullptr) {}

// Добавляет элемент в стек.
void Stack::push(int value) {
  /*FixME: Название локальной переменной newNode не соответствует стилю Google C++ Style Guide.
  Node* newNode = new Node(value);*/
  Node* new_node = new Node(value);
  new_node->next = top_;
  top_ = new_node;
  std::cout << "Элемент " << value << " добавлен в стек.\n";
}

// Удаляет элемент с вершины стека.
void Stack::pop() {
  if (top_ == nullptr) {
    std::cout << "Стек пуст! Невозможно удалить элемент.\n";
    return;
  }
  Node* temp = top_;
  top_ = top_->next;
  std::cout << "Элемент " << temp->data << " удален из стека.\n";
  delete temp;
}

/*FixME: Метод не изменяет объект.
void print() {*/
//Выводит элементы стека.
void Stack::print() const {
  if (top_ == nullptr) {
    std::cout << "Стек пуст!\n";
    return;
  }
  /*FixME: Неправильная логическая последовательность элементов.
  Node* current = top;
  cout << "Элементы стека: "; */
  std::cout << "Элементы стека: ";
  Node* current = top_;
  while (current != nullptr) {
    std::cout << current->data << " ";
    current = current->next;
  }
  std::cout << "\n";
}

/*FixME: Метод не изменяет объект.
Имя метода и так однозначно (не нужно использовать get/set в таком случае)
Node* getTop() {*/
// Возвращает указатель на вершину.
Node* Stack::top() const {
  return top_;
}

/*FixME: Имя метода и так однозначно.
void clearStack() {*/
// Полностью очищает стек.
void Stack::clear() {
  while (top_ != nullptr) {
    Node* temp = top_;
    top_ = top_->next;
    delete temp;
  }
  std::cout << "Стек очищен.\n";
}

// Добавляет элемент и выводит адрес новой вершины.
void addElementAndPrintAddress(Stack& stack, int value) {
  stack.push(value);
  std::cout << "Адрес новой вершины стека: " << stack.top() << "\n";
}
