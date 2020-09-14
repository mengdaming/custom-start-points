import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private static String toMultilineString(String[] lines) {
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line).append(System.lineSeparator());
        }
        return builder.toString();
    }

    @Before
    public void setUpOutStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreOutStream() {
        System.setOut(originalOut);
    }

    @Test
    public void print_owing_has_expected_format() {
        Customer janeDoe = new Customer("Jane Doe");
        janeDoe.order("Anything", 1.0);
        janeDoe.order("Anything else", 2.0);
        janeDoe.printOwing(1.0);

        String[] expectedLines = {
                "*************************",
                "***** Customer Owes *****",
                "*************************",
                "name: Jane Doe",
                "amount: 4.2"};
        String expected = toMultilineString(expectedLines);

        assertEquals(expected, outContent.toString());
    }
}
