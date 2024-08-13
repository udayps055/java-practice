import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = List.of(15, -2, 2, -8, 1, 7, 10, 23);
        int n = list.size(), c = 0;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + list.get(i);
        }
        for (int i = 1; i < n + 1; i++) {
            if (map.containsKey(pre[i])) {
                c = Math.max(c, i - map.get(pre[i]));
            } else {
                map.put(pre[i], i);
            }
        }
        printArray(pre);
        printArray(map);
        printArray(c);
    }

    public static void printArray(Object input) {
        if (input instanceof List<?>) {
            ((List<?>) input).forEach(val -> System.out.print(val + " "));
        } else if (input instanceof int[]) {
            Arrays.stream((int[]) input).forEach(val -> System.out.print(val + " "));
        } else if (input instanceof String[]) {
            Arrays.stream((String[]) input).forEach(val -> System.out.print(val + " "));
        } else if (input instanceof Map<?, ?>) {
            ((Map<?, ?>) input).entrySet().stream().forEach(val -> System.out.println("k" + ": " + val.getKey() + " " + "v" + ": " + val.getValue()));
        } else {
            System.out.println(input);
        }
        System.out.println("\n");
    }
}