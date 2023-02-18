#ifndef PROJ02_COURSE_H
#define PROJ02_COURSE_H
#include <string>
using namespace std;

class Course {
private:
    string courseNum;
    string courseName;
    string courseDescription;
public:
    Course();
    ~Course();
    //Setters
    void setCourseNum(string cnum);
    void setCourseName(string cname);
    void setCourseDescription(string cdscrpt);
    //Getters
    string getCourseNum();
    string getCourseName();
    string getCourseDescription();
};
#endif //PROJ02_COURSE_H
