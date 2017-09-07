/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int320.ec.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 *
 * @author INT320
 */
public class TestKey {

    public static final void main(String args[]) {
        
        List<Course> courses = new LinkedList();
        courses.add(new Course("Data Structure", 3));
        courses.add(new Course("Software Process", 3));
        courses.add(new Course("Database Management", 3));
        
        Map<Student, List<Course>> courseList = new HashMap();
//        Map<Student, List<Course>> courseList = new TreeMap(); //Must be Comparable Key
        courseList.put(new Student(1001, "Somchai", 2.9), courses);
        courseList.put(new Student(1002, "Somsri", 2.1), courses);
        courseList.put(new Student(1003, "Somkid", 3.95), courses);
        
        Student std = new Student(1003,"Somkid", 3.95);
        System.out.println(courseList.get(std));
    }
}

class Course {

    String title;
    int credit;

    public Course(String title, int credit) {
        this.title = title;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" + "title=" + title + ", credit=" + credit + '}';
    }
    
    
}

class Student implements Comparable<Student>{

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", gpa=" + gpa + '}';
    }
    
    
}
