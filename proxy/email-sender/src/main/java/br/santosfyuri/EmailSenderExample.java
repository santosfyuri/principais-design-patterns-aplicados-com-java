package br.santosfyuri;

import br.santosfyuri.proxy.EmailSenderProxy;

import java.util.ArrayList;
import java.util.List;

public class EmailSenderExample {

    public static void main(String[] args) {


        List<Contact> contatos = new ArrayList<>() {{

            add(new Contact("Andre", "andre@email.com"));
            add(new Contact("Claiton", "mailton@email.com"));
            add(new Contact("Ricardo Matos", "ricardo@email.com"));
            add(new Contact("Luiz", "luiz@email.com"));
            add(new Contact("Ana Clara", "anaclara@email.com"));

        }};

        EmailSenderProxy emailSenderService = new EmailSenderProxy(contatos);
        boolean emailStatus = emailSenderService.getEmailsBlackList("luiz@email.com");

        System.out.println(emailStatus ? "This email is blacklisted" : "This email isn't blacklisted");
    }
}
