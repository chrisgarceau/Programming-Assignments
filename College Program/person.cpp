#include "person.h"

//Constructor
Person::Person() {}

//Destructor
Person::~Person() = default;

//printName method
void Person::printName() {
    cout << "This is " << name;
}

//Setters
void Person::setName(string n) {
    name = n;
}

void Person::setAge(int a) {
    age = a;
}

//Getters
string Person::getName() {
    return name;
}

int Person::getAge() {
    return age;
}