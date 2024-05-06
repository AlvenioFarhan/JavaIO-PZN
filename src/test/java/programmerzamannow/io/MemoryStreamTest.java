package programmerzamannow.io;

import org.junit.jupiter.api.Test;

import java.io.StringWriter;

public class MemoryStreamTest {
    @Test
    void memoryStream() {
        StringWriter writer = new StringWriter();
        for (int index = 0; index < 10; index++) {
            writer.write("Hello World\n");
        }

        String content = writer.getBuffer().toString();
        System.out.println(content);
    }
}
