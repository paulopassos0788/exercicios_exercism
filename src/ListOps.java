import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

class ListOps {
        public static void main(String[] args) {
            List<Integer> list1 = Arrays.asList(1, 2, 3);
            List<Integer> list2 = Arrays.asList(4, 5);

            // Usando append
            List<Integer> appended = ListOps.append(list1, list2);
            System.out.println("Append: " + appended); // [1, 2, 3, 4, 5]

            // Usando concat
            List<List<Integer>> lists = Arrays.asList(list1, list2);
            List<Integer> concatenated = ListOps.concat(lists);
            System.out.println("Concat: " + concatenated); // [1, 2, 3, 4, 5]

            // Usando filter
            List<Integer> filtered = ListOps.filter(appended, x -> x > 3);
            System.out.println("Filter: " + filtered); // [4, 5]

            // Usando size
            int size = ListOps.size(appended);
            System.out.println("Size: " + size); // 5

            // Usando map
            List<String> mapped = ListOps.map(appended, Object::toString);
            System.out.println("Map: " + mapped); // ["1", "2", "3", "4", "5"]

            // Usando reverse
            List<Integer> reversed = ListOps.reverse(appended);
            System.out.println("Reverse: " + reversed); // [5, 4, 3, 2, 1]

            // Usando foldLeft
            int sum = ListOps.foldLeft(appended, 0, Integer::sum);
            System.out.println("Fold Left (Sum): " + sum); // 15

            // Usando foldRight
            String concatenatedString = ListOps.foldRight(mapped, "", (s, acc) -> acc + s + "-");
            System.out.println("Fold Right (Concatenation): " + concatenatedString); // "1-2-3-4-5-"
        }


    static <T> List<T> append(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<>(list1);
        result.addAll(list2);
        return result;
    }

    static <T> List<T> concat(List<List<T>> listOfLists) {
        List<T> result = new ArrayList<>();
        for (List<T> list : listOfLists) {
            result.addAll(list);
        }
        return result;
    }

    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    static <T> int size(List<T> list) {
        return list.size();
    }

    static <T, U> List<U> map(List<T> list, Function<T, U> transform) {
        List<U> result = new ArrayList<>();
        for (T item : list) {
            result.add(transform.apply(item));
        }
        return result;
    }

    static <T> List<T> reverse(List<T> list) {
        List<T> result = new ArrayList<>(list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

    static <T, U> U foldLeft(List<T> list, U initial, BiFunction<U, T, U> f) {
        U accumulator = initial;
        for (T item : list) {
            accumulator = f.apply(accumulator, item);
        }
        return accumulator;
    }

    static <T, U> U foldRight(List<T> list, U initial, BiFunction<T, U, U> f) {
        U accumulator = initial;
        for (int i = list.size() - 1; i >= 0; i--) {
            accumulator = f.apply(list.get(i), accumulator);
        }
        return accumulator;
    }

    private ListOps() {
        // No instances.
    }
}
