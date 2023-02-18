#ifndef PROJ02_PERSON_H
#define PROJ02_PERSON_H
#include <iostream>
#include <string>
using namespace std;

class Person {
protected:
    string name;
    int age;
public:
    Person();
    ~Person();
    virtual void printName();
    //Setters
    void setName(string n);
    void setAge(int a);
    //Getters
    string getName();
    int getAge();
};
#endif //PROJ02_PERSON_H
