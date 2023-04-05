package br.santosfyuri.proxy;

import br.santosfyuri.Contact;
import br.santosfyuri.ContactBlackList;
import br.santosfyuri.EmailSender;
import br.santosfyuri.EmailSenderService;

import java.util.ArrayList;
import java.util.List;

public class EmailSenderProxy implements EmailSender {

    private EmailSenderService emailSenderService;

    private ContactBlackList contactBlackList = new ContactBlackList();

    public EmailSenderProxy(List<Contact> emails) {
        this.emailSenderService = new EmailSenderService(emails);
    }

    public List<Contact> getBlackList() {
        return this.contactBlackList.getEmailsBlackList();
    }

    public boolean getEmailsBlackList(String email) {
        return this.contactBlackList.getEmailBlackList(email);
    }

    @Override
    public void send() {

        List<Contact> differences = new ArrayList<>(this.emailSenderService.getEmails());

        differences.removeAll(this.contactBlackList.getEmailsBlackList());

        this.emailSenderService.getEmails().clear();
        this.emailSenderService.getEmails().addAll(differences);

        this.emailSenderService.send();
    }

    @Override
    public boolean getEmailSendingStatus() {
        return this.emailSenderService.getEmailSendingStatus();
    }

    @Override
    public int getEmailSendingCount() {
        return this.emailSenderService.getEmailSendingCount();
    }
}
