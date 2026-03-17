#ifndef FUNCTIONS_H
#define FUNCTIONS_H

#include <iostream>
#include <deque>
#include <fstream>
#include <cstdlib>
#include <ctime>
#include <iterator>

std::ostream& operator<<(std::ostream& os, const std::deque<int>& d);

void InsertMiddleFive(std::deque<int>& d);
std::deque<int> FuncKeyboard();
std::deque<int> FuncRandom(int count);
std::deque<int> FuncFile();

#endif