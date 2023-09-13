import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatesTest {

    @Test
    public void testRemoveDuplicates() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        List<Integer> uniqueNumbers = RemoveDuplicates.removeDuplicates(numbers);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

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
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> uniqueNumbers = RemoveDuplicates.removeDuplicates(numbers);

        assertEquals(numbers, uniqueNumbers);
    }
}
