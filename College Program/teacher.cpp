#include "teacher.h"

//Constructor
Teacher::Teacher() {}
//Destructor
Teacher::~Teacher() {}

void Teacher::setSalary(int s) {
    salary = s;
}

void Teacher::addCourse(Course &x) {
    coursesTeaching.push_back(x);
}

void Teacher::removeCourse(Course &x) {
    for (int i = 0; i < coursesTeaching.size(); i++) {
        if (coursesTeaching[i].getCourseName() == x.getCourseName()) {
            coursesTeaching.erase(coursesTeaching.begin() + i);
        }
    }
}

int Teacher::getSalary() {
    return salary;
}

void Teacher::printName() {
    cout << "This is teacher " << name << endl;
}

void Teacher::printCoursesTeaching() {
    cout << "Courses Teaching: " << endl;
    cout << "---------------------------------" << endl;
    for(int i = 0; i < coursesTeaching.size(); i++) {
        cout << coursesTeaching[i].getCourseNum() << " - " << coursesTeaching[i].getCourseName() << endl;
    }
    cout << endl;
}


