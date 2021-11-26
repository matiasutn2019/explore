package com.disney.explore.controller;

import com.disney.explore.domain.entity.User;
import com.disney.explore.domain.entity.Role;
import com.disney.explore.service.UserService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registrarUser(@RequestBody User user) throws IOException {
        userService.registrarUser(user);
        sendMail(user.getEmail());
        return ResponseEntity.ok().build();
    }

    public void sendMail(String email) throws IOException {
        Email from = new Email("matiasceviniydejesus@gmail.com");
        Email to = new Email(email);
        String subject = "Usuario registrado";
        Content content = new Content("text/plain", "Felicitaciones!!! Te registraste exitosamente!!!");
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sendGrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("/mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException e) {
            throw e;
        }
    }

    @PostMapping("/addroletouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/saverole")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/saverole").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
}
@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}