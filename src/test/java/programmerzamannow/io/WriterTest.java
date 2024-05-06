package programmerzamannow.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterTest {
    @Test
    void writer() {
        Path path = Path.of("writer.txt");
        try (Writer writer = Files.newBufferedWriter(path)) {
            for (int index = 0; index < 100; index++) {
                writer.write("Hello World\n");
                writer.flush();
            }
        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }
}
