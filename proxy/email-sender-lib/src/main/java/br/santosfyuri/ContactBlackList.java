package br.santosfyuri;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.util.List;

public class ContactBlackList {

    private List<Contact> emailsBlackList;

    private final static String BLACK_LIST_FILE_XML = "blacklist.xml";

    public ContactBlackList() {

        getBlackListFromXML();
    }

    public List<Contact> getEmailsBlackList() {
        return this.emailsBlackList;
    }

    @SuppressWarnings("unchecked")
    private void getBlackListFromXML() {
        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);

        xstream.alias("contacts", List.class);
        xstream.alias("contact", Contact.class);

        this.emailsBlackList = (List<Contact>) xstream.fromXML(this.getClass().getResource("/" + BLACK_LIST_FILE_XML));
    }

    public boolean getEmailBlackList(String email) {
        return this.emailsBlackList.stream()
                .anyMatch(e -> email.equals(e.getEmail()));
    }
}
