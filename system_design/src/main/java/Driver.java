import java.util.*;

public class Driver {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 3);

        // Sorting in ascending order
        Collections.sort(numbers);
        System.out.println(numbers); // Output: [1, 2, 3, 5, 9]

        // let's write my own comparator
        Comparator<Integer> ahmerKaComparator = new Comparator<>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                if(num1.equals(num2)) return 0;
                if(num1.intValue() > num2.intValue()) return -1;
                else return 1;
            }
        };

        Collections.sort(numbers, ahmerKaComparator); // in case of an [] use --> Arrays.sort(numbers)
        System.out.println(numbers); // Output: [9, 5, 3, 2, 1]
    }
}