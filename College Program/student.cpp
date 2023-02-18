#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include "student.h"

Student::Student() {}

Student::~Student() = default;

void Student::setID(string id) {
    student_num = id;
}

string Student::getID() {
    return student_num;
}

void Student::printCourses() {
    cout << "Courses: " << endl;
    cout << "---------------------------------" << endl;
    for(auto & i : coursesTaking) {
        cout << i.getCourseNum() << " - " << i.getCourseName() << endl;
    }
    cout << endl;
}

void Student::addCourse(Course &x) {
    coursesTaking.push_back(x);
}

void Student::deleteCourse(Course &x) {
    for (int i = 0; i < coursesTaking.size(); i++) {
        if (coursesTaking[i].getCourseName() == x.getCourseName()) {
            coursesTaking.erase(coursesTaking.begin() + i);
        }
    }
}

//Overridden printName
void Student::printName() {
    cout << "This is student " << name << endl;
}

