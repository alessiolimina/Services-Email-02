package it.develhope.services.Services.Email2.students.services;

import it.develhope.services.Services.Email2.students.entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    static List<Student> students = Arrays.asList(
      new Student("1","Alessio","Limina","alessio.limina90@gmail.com"),
            new Student("2","Reginald","Dwight","reginald.dwight@gmail.com"),
            new Student("3","Gordon","Sumner","gordon.sumner@gmail.com"),
            new Student("4","Mick","Hucknall","mick.hucknall@gmail.com")
    );

    public Student getStudentbyId(String id){
        Optional<Student> studentInList = students.stream().filter(student -> student.getId().equals(id)).findAny();
        if(studentInList.isPresent()){
            return studentInList.get();
        } else return null;

    }
}
