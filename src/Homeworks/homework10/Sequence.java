package Homeworks.homework10;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
    public static int[] filter(int[] array, funk.ByCondition condition) {
        List<Integer> result = new ArrayList<>();
        for (int number : array) {
            if (condition.isOk(number)) {
                result.add(number);
            }
        }

        int[] filtered = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            filtered[i] = result.get(i);
        }

        return filtered;
    }
}

