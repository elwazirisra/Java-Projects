package LA2Q2;

import java.util.Arrays;
import java.util.List;

public class StudentGrade implements Comparable<StudentGrade>{
    private String firstName;//private field for first name of student
    private String lastname;//private field for last name of student
    private Integer grade;//private field for grade of student, I made it an Integer wrapper class because I do not want to have to override the compareTo method

    public StudentGrade(String firstName,String lastName, Integer grade ){//constructor will 3 parameters
    this.firstName=firstName;
    this.lastname=lastName;
    this.grade=grade;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }//setting the last name however we will not use it in this lab

    public String getLastname() {
        return lastname;
    }//getting the last name

    public void setGrade(Integer grade) {
        this.grade = grade;
    } //setting the grade of the student

    public Integer getGrade() {
        return grade;
    }//getting the grade of the student

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }//setting the first name however we will not use it in this lab

    public String getFirstName() {
        return firstName;
    }//getting the fist name if the student

    public int compareTo(StudentGrade G){//this compare to method will compare the scores of the students only

        return this.grade.compareTo(G.grade);//we return the scores  or grades in ascending order
    }

    public String toString(){
       return
        String.format("\b\b\b%8s %8s  :\t %d\n",getFirstName(),getLastname(),getGrade());
    }



}
