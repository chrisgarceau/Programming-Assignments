#ifndef PROJ02_STUDENT_H
#define PROJ02_STUDENT_H
#include <iostream>
#include <string>
#include <vector>
#include "person.h"
#include "course.h"

using namespace std;

class Student : public Person {
private:
    string student_num;
    vector<Course> coursesTaking;
public:
    Student();
    ~Student();
    void setID(string);
    string getID();
    void printCourses();
    void addCourse(Course &x);
    void deleteCourse(Course &x);

    friend bool operator==(Student &s1, Student &s2) {
        if (s1.coursesTaking.size() != s2.coursesTaking.size()) {
            return false;
        }
        else {
            vector<string> s1CourseNames;
            vector<string> s2CourseNames;

            for (auto & i : s1.coursesTaking) {
                s1CourseNames.push_back(i.getCourseName());
            }
            for (auto & i : s2.coursesTaking) {
                s2CourseNames.push_back(i.getCourseName());
            }

            sort(s1CourseNames.begin(), s1CourseNames.end());
            sort(s2CourseNames.begin(), s2CourseNames.end());

            if (s1CourseNames == s2CourseNames) {
                return true;
            }
        }
        return false;
    }
    //Overridden printName
    void printName() override;
};
#endif //PROJ02_STUDENT_H
