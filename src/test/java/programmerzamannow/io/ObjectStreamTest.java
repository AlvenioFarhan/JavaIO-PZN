package programmerzamannow.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectStreamTest {
    @Test
    void savePerson() {
        Person person = new Person();
        person.setId("001");
        person.setName("Alvenio");

        Path path = Path.of("alvenio.person");

        try (OutputStream stream = Files.newOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream)) {

            objectOutputStream.writeObject(person);
            objectOutputStream.flush();

        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void getPerson() {
        Path path = Path.of("alvenio.person");

        try(InputStream stream = Files.newInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(stream)){

            Person person = (Person) objectInputStream.readObject();

            Assertions.assertEquals("001",person.getId());
            Assertions.assertEquals("Alvenio",person.getName());

        }catch (Exception exception){
            Assertions.fail(exception);
        }
    }
}
