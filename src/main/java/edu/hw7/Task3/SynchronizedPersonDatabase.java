package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynchronizedPersonDatabase implements IPersonDatabase {
    public Map<Integer, Person> data = new HashMap<>();
    public Map<String, List<Person>> dataByName = new HashMap<>();
    public Map<String, List<Person>> dataByAddress = new HashMap<>();
    public Map<String, List<Person>> dataByPhone = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
            data.put(person.id(), person);
            dataByName.computeIfAbsent(person.name(), l -> new ArrayList<>()).add(person);
            dataByAddress.computeIfAbsent(person.address(), l -> new ArrayList<>()).add(person);
            dataByPhone.computeIfAbsent(person.phoneNumber(), l -> new ArrayList<>()).add(person);
    }

    @Override
    public synchronized void delete(int id) {
        Person deleted = data.remove(id);
        dataByName.get(deleted.name()).remove(deleted);
        dataByAddress.get(deleted.address()).remove(deleted);
        dataByPhone.get(deleted.phoneNumber()).remove(deleted);
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return dataByName.getOrDefault(name, List.of());
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return dataByAddress.getOrDefault(address, List.of());
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return dataByPhone.getOrDefault(phone, List.of());
    }
}
