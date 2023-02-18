#include "course.h"

//Constructor
Course::Course() {}
//Destructor
Course::~Course() = default;
//Setters
void Course::setCourseNum(string cnum) {
    courseNum = cnum;
}

void Course::setCourseName(string cname) {
    courseName = cname;
}

void Course::setCourseDescription(string cdscrpt) {
    courseDescription = cdscrpt;
}

//Getters
string Course::getCourseNum() {
    return courseNum;
}

string Course::getCourseName() {
    return courseName;
}

string Course::getCourseDescription() {
    return courseDescription;
}
