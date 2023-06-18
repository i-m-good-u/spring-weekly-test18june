package org.Guddu;

import org.example.MailHandler;
import org.example.MailMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
public class CarController {
    @Autowired
    @Qualifier("blue")
    Car c;

    @GetMapping("color")

    public String getCarColor()
    {
        MailHandler mail = new MailHandler();
        String s = c.getColor();
        MailMetaData.MessageBody=s+" email came from GetMapping color";
        MailMetaData.MessageSubject=" weekly test ";
        mail.sendMail();
        System.out.println("mail has been sent");


        return s;
    }
}
