package br.santosfyuri;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

public class ScheduleDAO implements DataAccessObject {

    private String fileName;
    private List<Contact> contacts;

    public List<Contact> getContacts() {
        return this.contacts;
    }

    private void loadFile() {
        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);

        xstream.alias("contacts", List.class);
        xstream.alias("contact", Contact.class);

        this.contacts = (List<Contact>) xstream.fromXML(this.getClass().getResource("/" + this.fileName));

    }

    private void saveFile() {

        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);

        xstream.alias("contacts", List.class);
        xstream.alias("contact", Contact.class);

        OutputStream out;
        System.out.println("Updating XML file...");

        try {
            out = new FileOutputStream(this.fileName);
            xstream.toXML(this.contacts, out);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error trying to save contact to file: " + e.getMessage());
        }

    }

    @Override
    public void insert(Contact contact) {
        this.contacts.add(contact);
        saveFile();
    }

    @Override
    public Contact get(int code) {
        Optional<Contact> contact = this.contacts.stream()
                .filter(c -> c.getCode().equals(code)).findFirst();
        return contact.orElse(null);
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
        loadFile();
    }
}
