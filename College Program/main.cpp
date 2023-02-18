#include <iostream>
#include "person.h"
#include "student.h"
#include "teacher.h"
#include "course.h"
using namespace std;

int main() {
   //Five Course objects
   Course a, b, c, d, e;
   a.setCourseNum("458");
   a.setCourseName("Cybersecurity Systems");
   a.setCourseDescription("");

   b.setCourseNum("490");
   b.setCourseName("Complex Analysis");
   b.setCourseDescription("");

   c.setCourseNum("305");
   c.setCourseName("Electronic Systems I");
   c.setCourseDescription("");

   d.setCourseNum("304");
   d.setCourseName("Signals & Systems II");
   d.setCourseDescription("");

   e.setCourseNum("410");
   e.setCourseName("Capstone Design I");
   e.setCourseDescription("");

   //3 Person objects
   Person p1, p2, p3;
   p1.setName("Jason");
   p1.setAge(21);

   p2.setName("Frank");
   p2.setAge(22);

   p3.setName("Yi Wang");
   p3.setAge(30);

   //3 Student Objects
   Student s1, s2, s3;
   s1.setName("Jason");
   s1.setAge(21);

   s2.setName("Frank");
   s2.setAge(22);

   s3.setName("John");
   s3.setAge(19);

   //3 Teacher objects
   Teacher t1, t2, t3;
    t1.setName("Dr. Wang");
    t1.setAge(33);

    t2.setName("Dr. Ozturk");
    t2.setAge(70);

    t3.setName("Dr. Gerhardt");
    t3.setAge(38);

    //Adding courses that students are taking
    s1.addCourse(a);
    s1.addCourse(b);
    s1.addCourse(c);

    s2.addCourse(b);
    s2.addCourse(c);
    s2.addCourse(e);
    s2.addCourse(d);
    s2.addCourse(a);

    s3.addCourse(a);
    s3.addCourse(b);
    s3.addCourse(c);

    //adding courses that teachers are teaching
    t1.addCourse(a);
    t1.addCourse(e);

    t2.addCourse(c);
    t2.addCourse(d);

    t3.addCourse(b);

    //Student deletes course
    s2.deleteCourse(e);

    //Comparing students course lists
    //Ex. 1
    if ((s1 == s3)) {
        cout << "Students are taking the same courses." << endl;
    }
    else {
        cout << "Students are not taking the same courses." << endl;
    }
    //Ex. 2
    if ((s2 == s3)) {
        cout << "Students are taking the same courses." << endl;
    }
    else {
        cout << "Students are not taking the same courses." << endl;
    }
    cout << endl;

    //Student names and courses
    s1.printName();
    s1.printCourses();

    s2.printName();
    s2.printCourses();

    s3.printName();
    s3.printCourses();

    //Teacher names and courses
    t1.printName();
    t1.printCoursesTeaching();

    t2.printName();
    t2.printCoursesTeaching();

    t3.printName();
    t3.printCoursesTeaching();
}
