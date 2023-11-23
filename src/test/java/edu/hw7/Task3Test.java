package edu.hw7;

import edu.hw7.Task3.Person;
import edu.hw7.Task3.PersonDatabaseReadWriteLock;
import edu.hw7.Task3.PersonDatabaseSynchronized;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    public void ShouldReturnValueAfterAddOperationSynchronized() {
        PersonDatabaseSynchronized personDatabase = new PersonDatabaseSynchronized();
        AtomicReference<List<Person>> referenceForName = new AtomicReference<>(List.of());
        AtomicReference<List<Person>> referencePerson = new AtomicReference<>(List.of());
        AtomicReference<List<Person>> referenceForAddress = new AtomicReference<>(List.of());
        AtomicReference<List<Person>> referenceForPhone = new AtomicReference<>(List.of());

        Thread thread1 = new Thread(() -> {
            personDatabase.add(new Person(1, "name", "address", "phone"));
        });
        Thread thread2 = new Thread(() -> {
            referenceForName.set(personDatabase.findByName("name"));
        });
        Thread thread3 = new Thread(() -> {
            referenceForAddress.set(personDatabase.findByAddress("address"));
        });
        Thread thread4 = new Thread(() -> {
            referenceForPhone.set(personDatabase.findByPhone("phone"));
        });
        thread1.start();
        referencePerson.set(personDatabase.database);
        thread2.start();
        thread3.start();
        thread4.start();

        if(!referencePerson.get().isEmpty()) {
            assertThat(referencePerson.get()).isEqualTo(referenceForName.get());
            assertThat(referencePerson.get()).isEqualTo(referenceForAddress.get());
            assertThat(referencePerson.get()).isEqualTo(referenceForPhone.get());
        }
    }

    @Test
    public void ShouldReturnValueAfterAddOperationReadWriteLock() throws InterruptedException {
        PersonDatabaseReadWriteLock personDatabase = new PersonDatabaseReadWriteLock();
        Person p = new Person(1, "name", "address", "phone");
        List<Person> result = List.of(p);
        AtomicReference<List<Person>> referenceForName = new AtomicReference<>(List.of());
        AtomicReference<List<Person>> referenceForAddress = new AtomicReference<>(List.of());
        AtomicReference<List<Person>> referenceForPhone = new AtomicReference<>(List.of());

        Thread thread1 = new Thread(() -> {
            personDatabase.add(p);
        });
        Thread thread2 = new Thread(() -> {
            referenceForName.set(personDatabase.findByName("name"));
        });
        Thread thread3 = new Thread(() -> {
            referenceForAddress.set(personDatabase.findByAddress("address"));
        });
        Thread thread4 = new Thread(() -> {
            referenceForPhone.set(personDatabase.findByPhone("phone"));
        });
        thread1.start();
        // без join у гита тест падает, при этом у меня не падет
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
        thread4.join();

        assertThat(result).isEqualTo(referenceForName.get());
        assertThat(result).isEqualTo(referenceForAddress.get());
        assertThat(result).isEqualTo(referenceForPhone.get());

    }
}
