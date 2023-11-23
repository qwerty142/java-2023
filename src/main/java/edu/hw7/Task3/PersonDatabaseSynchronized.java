package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.List;

public class PersonDatabaseSynchronized implements IPersonDatabase {
    public List<Person> database = new ArrayList<>();

    @Override
    public synchronized void add(Person person) {
            database.add(person);
    }

    @Override
    public synchronized void delete(int id) {
        database.removeIf(obj -> obj.id() == id);
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return database.stream().filter(obj -> obj.name().equals(name)).toList();
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return database.stream().filter(obj -> obj.address().equals(address)).toList();
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return database.stream().filter(obj -> obj.phoneNumber().equals(phone)).toList();
    }
}
