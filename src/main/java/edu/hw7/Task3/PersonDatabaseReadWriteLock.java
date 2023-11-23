package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PersonDatabaseReadWriteLock implements IPersonDatabase {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    public List<Person> database = new ArrayList<>();

    @Override
    public void add(Person person) {
        readWriteLock.writeLock().lock();
        try {
            database.add(person);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        readWriteLock.writeLock().lock();
        try {
            database.removeIf(obj -> obj.id() == id);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        readWriteLock.readLock().lock();
        try {
            return database.stream().filter(obj -> obj.name().equals(name)).toList();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        readWriteLock.readLock().lock();
        try {
            return database.stream().filter(obj -> obj.address().equals(address)).toList();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        readWriteLock.readLock().lock();
        try {
            return database.stream().filter(obj -> obj.phoneNumber().equals(phone)).toList();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
