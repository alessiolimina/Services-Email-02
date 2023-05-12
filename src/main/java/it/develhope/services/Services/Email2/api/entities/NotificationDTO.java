package it.develhope.services.Services.Email2.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationDTO {

    private String contactId;
    private String title;
    private String text;

}
