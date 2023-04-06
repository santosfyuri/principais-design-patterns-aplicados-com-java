package br.santosfyuri;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CacheScheduleDAO implements DataAccessObject {

    private ScheduleDAO scheduleDAO;
    private Map<Integer, Contact> contactMap;

    public CacheScheduleDAO(ScheduleDAO scheduleDAO ) {
        this.scheduleDAO = scheduleDAO;
    }

    @Override
    public void insert(Contact contact) {
        this.scheduleDAO.insert(contact);
        this.contactMap.put(contact.getCode(), contact);
    }

    @Override
    public Contact get(int code) {
        return this.contactMap.get(code) != null
                ? this.contactMap.get(code)
                : null;
    }

    @Override
    public void setFileName(String fileName) {
        this.scheduleDAO.setFileName(fileName);

        this.contactMap = this.scheduleDAO.getContacts()
                .stream()
                .collect(Collectors.toMap(Contact::getCode, Function.identity())) ;
    }

}
