package br.santosfyuri;

import java.util.ArrayList;
import java.util.List;

public class EmailSenderService implements EmailSender {

    private List<Contact> emails;
    private boolean status;
    private int count;

    public EmailSenderService(List<Contact> emails) {
        this.emails = emails;
    }

    private void setStatus(boolean status) {
        this.status = status;
    }

    public List<Contact> getEmails() {
        return this.emails;
    }

    public void addEmail(Contact contact) {
        if (this.emails == null) {
            this.emails = new ArrayList<>();
        }
        this.emails.add(contact);
    }

    @Override
    public void send() {
        setStatus(false);
        this.count = 0;
        try {
            for (Contact contact : this.emails) {
                System.out.println("===================================");
                System.out.println("To: " + contact.getEmail());
                System.out.println("Title: Proxy Design Pattern ");
                System.out.println("Subject: Dear " + contact.getName() + ", Do you know Proxy Design Pattern?");
                this.count++;
            }
            setStatus(true);
        } catch (Exception e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }

    @Override
    public boolean getEmailSendingStatus() {
        return this.status;
    }

    @Override
    public int getEmailSendingCount() {
        return this.count;
    }
}
