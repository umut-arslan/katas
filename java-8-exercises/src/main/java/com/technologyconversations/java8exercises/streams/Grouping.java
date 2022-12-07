package com.technologyconversations.java8exercises.streams;

import com.technologyconversations.java8exercises.streams.model.Person;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Grouping {

    public static Map<String, List<Person>> groupByNationality7(List<Person> people) {
        Map<String, List<Person>> map = new HashMap<>();
        for (Person person : people) {
            if (!map.containsKey(person.nationality())) {
                map.put(person.nationality(), new ArrayList<>());
            }
            map.get(person.nationality()).add(person);
        }
        return map;
    }

    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(Person::nationality));
    }

}
