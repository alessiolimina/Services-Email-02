package it.develhope.services.Services.Email2.api.controllers;

import it.develhope.services.Services.Email2.email.services.EmailService;
import it.develhope.services.Services.Email2.api.entities.NotificationDTO;
import it.develhope.services.Services.Email2.students.entities.Student;
import it.develhope.services.Services.Email2.students.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NotificationController {

    @Autowired
    StudentService studentService;

    @Autowired
    EmailService emailService;

    @PostMapping("/notification")
    public ResponseEntity sendNotification(@RequestBody NotificationDTO notificationDTO) {
        try {
            Student studentToSendNotification = studentService.getStudentbyId(notificationDTO.getContactId());
            if (studentToSendNotification == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student not found");
            } else {
                emailService.sendTo(studentToSendNotification.getEmail(), notificationDTO.getTitle(), notificationDTO.getText());
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        } catch (Exception e) {
            System.err.println("Error in notification controller " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
