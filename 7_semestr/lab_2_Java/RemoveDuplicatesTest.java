import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatesTest {

    @Test
    public void testRemoveDuplicates() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);
        numbers.add(5);

        List<Integer> uniqueNumbers = RemoveDuplicates.removeDuplicates(numbers);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        assertEquals(expected, uniqueNumbers);
    }

    @Test
    public void testRemoveDuplicatesEmptyList() {
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> uniqueNumbers = RemoveDuplicates.removeDuplicates(emptyList);

        assertTrue(uniqueNumbers.isEmpty());
    }

    @Test
    public void testRemoveDuplicatesNoDuplicates() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        List<Integer> uniqueNumbers = RemoveDuplicates.removeDuplicates(numbers);

        assertEquals(numbers, uniqueNumbers);
    }
}
