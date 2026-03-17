#ifndef STACK_H_
#define STACK_H_

#include <iostream>

class Node {
public:
  int data;
  Node* next;

  //FixME: Без explicit может создать неявные преобразования, которые могут привести к ошибкам
  /* Node(int value) : data(value), next(nullptr) {}*/
  explicit Node(int value);
};

class Stack {
  /*FixME: Методы private не находятся после методов public и protected.
  Приватные методы перенесены за методы public
  private:
  Node* top;*/
public:
  /*FixME: Приватные поля класса не заканчиваются нижним подчёркиванием "_".
  Stack() : top(nullptr) {} */
  Stack();
  void push(int value);
  void pop();
  void print() const;
  Node* top() const;
  void clear();
  friend void addElementAndPrintAddress(Stack& stack, int value);

private:
  Node* top_;
};

void addElementAndPrintAddress(Stack& stack, int value);
#endif