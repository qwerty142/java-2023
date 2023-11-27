package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockPersonDatabase implements IPersonDatabase {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    public Map<Integer, Person> data = new HashMap<>();
    public Map<String, List<Person>> dataByName = new HashMap<>();
    public Map<String, List<Person>> dataByAddress = new HashMap<>();
    public Map<String, List<Person>> dataByPhone = new HashMap<>();

    @Override
    public void add(Person person) {
        readWriteLock.writeLock().lock();
        try {
            data.put(person.id(), person);
            dataByName.computeIfAbsent(person.name(), l -> new ArrayList<>()).add(person);
            dataByAddress.computeIfAbsent(person.address(), l -> new ArrayList<>()).add(person);
            dataByPhone.computeIfAbsent(person.phoneNumber(), l -> new ArrayList<>()).add(person);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        readWriteLock.writeLock().lock();
        try {
            Person deleted = data.remove(id);
            dataByName.get(deleted.name()).remove(deleted);
            dataByAddress.get(deleted.address()).remove(deleted);
            dataByPhone.get(deleted.phoneNumber()).remove(deleted);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        readWriteLock.readLock().lock();
        try {
            return dataByName.getOrDefault(name, List.of());
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        readWriteLock.readLock().lock();
        try {
            return dataByAddress.getOrDefault(address, List.of());
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        readWriteLock.readLock().lock();
        try {
            return dataByPhone.getOrDefault(phone, List.of());
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
