import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

    // Count the number of names starting with letter "A" from list
    @Test
    public void regular() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekhya");
        names.add("Adam");
        names.add("Ram");

        int count = 0;

        // Iterate through the list and count the names starting with letter "A"
        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("A")) {
                count++;
            }
        }
        System.out.println(count);
    }

    // Uses the Stream API to count the number of names starting with the letter "A" and to print the names with a length greater than 4
    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekhya");
        names.add("Adam");
        names.add("Ram");

        // Count the number of names starting with letter "A" using stream and filter
        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);

        // Another way to count the number of names starting with letter "A" using stream and filter
        long d = Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Ram").filter(s -> {
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(d);

        // Print the names longer than 4 characters using stream and filter
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
    }

    // Uses the Stream API to filter, map, sort, and concatenate streams, and checks if the stream contains the name "Adam"
    @Test
    public void streamMap() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("man");
        names.add("Don");
        names.add("woman");

        // Filter and map the names ending with letter "m" to upper case using stream and map
        Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Ram").filter(s -> s.endsWith("m")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        System.out.println("*****************************************************************************************");

        // Filter, sort and map the names starting with letter "A" to upper case using stream and map
        List<String> names1 = Arrays.asList("Azbhijeet", "Don", "Alekhya", "Adam", "Ram");
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        // Concatenate two streams and check if any of the names match "Adam"
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
        System.out.println(flag);

        // Use TestNG Assert to check if the flag is true
        Assert.assertTrue(flag);

    }

    // Uses the Stream API to collect the elements of a stream into a list and manipulate the resulting list
    @Test
    public void streamCollect() {

        // Filter, map and collect the names ending with letter "m" to a new list using stream and collect
        List<String> ls = Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Ram").filter(s -> s.endsWith("m")).map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));
        List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);

        // Creates a new list of integers using the Stream API that filters out duplicates, sorts the remaining elements, and collects the resulting elements into a new list
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());

        // Prints out the third element of the list
        System.out.println(li.get(2));
    }
}
