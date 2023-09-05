import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);
        numbers.add(5);

        List<Integer> uniqueNumbers = removeDuplicates(numbers);

        System.out.println("Original List: " + numbers);
        System.out.println("List with Duplicates Removed: " + uniqueNumbers);
    }

    public static <T> List<T> removeDuplicates(List<Integer> list) {
        HashSet<T> uniqueSet = new HashSet<>();
        List<T> result = new ArrayList<>();

        for (Integer item : list) {
            if (uniqueSet.add((T) item)) {
                // If the item is added to the set, it's not a duplicate
                result.add((T) item);
            }
        }

        return result;
    }
}


