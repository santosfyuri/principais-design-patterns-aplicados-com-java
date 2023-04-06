package br.santosfyuri;

public class ScheduleExample {

    private final static String CONTACT_LIST_FILE_XML = "schedule.xml";
    public static void main(String[] args) {
        DataAccessObject scheduleDAO = new CacheScheduleDAO(new ScheduleDAO());
        scheduleDAO.setFileName(CONTACT_LIST_FILE_XML);

        Contact contact = new Contact(625, "Junior", "juniot@email.com");
        scheduleDAO.insert(contact);

        Contact contactFound = scheduleDAO.get(625);
        System.out.printf("Contact found: %s", contactFound.getName());
    }
}
