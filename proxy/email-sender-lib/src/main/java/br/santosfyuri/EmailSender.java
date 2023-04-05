package br.santosfyuri;

public interface EmailSender {

    void send();
    boolean getEmailSendingStatus();
    int getEmailSendingCount();
}
