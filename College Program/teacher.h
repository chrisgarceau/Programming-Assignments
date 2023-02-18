#ifndef PROJ02_TEACHER_H
#define PROJ02_TEACHER_H
#include "person.h"
#include "course.h"
#include <vector>
using namespace std;

class Teacher : public Person {
private:
    int salary;
    vector<Course> coursesTeaching;
public:
    Teacher();
    ~Teacher();
    //Setters
    void setSalary(int s);
    void addCourse(Course &x);
    void removeCourse(Course &x);
    void printCoursesTeaching();
    //Getters
    int getSalary();
    //Overridden printName
    void printName() override;
};
#endif //PROJ02_TEACHER_H
