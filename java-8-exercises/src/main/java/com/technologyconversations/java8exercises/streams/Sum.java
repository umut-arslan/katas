package com.technologyconversations.java8exercises.streams;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Sum {

    public static int calculate7(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }

    public static int calculate(List<Integer> numbers) { //people wurde in numbers geaendert

        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

}
