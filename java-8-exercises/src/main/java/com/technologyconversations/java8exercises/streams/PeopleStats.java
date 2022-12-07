package com.technologyconversations.java8exercises.streams;

import com.technologyconversations.java8exercises.streams.model.Person;
import com.technologyconversations.java8exercises.streams.model.Stats;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PeopleStats {

    public static Stats getStats7(List<Person> people) {
        long sum = 0;
        int min = people.get(0).age();
        int max = 0;
        for (Person person : people) {
            int age = person.age();
            sum += age;
            min = Math.min(min, age);
            max = Math.max(max, age);
        }
        return new Stats(people.size(), sum, min, max);
    }

    public static IntSummaryStatistics getStats(List<Person> people) {
        return people.stream().mapToInt(Person::age).summaryStatistics();

    }

}
