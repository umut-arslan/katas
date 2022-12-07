package com.technologyconversations.java8exercises.streams;

import com.technologyconversations.java8exercises.streams.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.technologyconversations.java8exercises.streams.Joining.namesToString;
import static com.technologyconversations.java8exercises.streams.util.TestData.*;
import static org.assertj.core.api.Assertions.assertThat;

class JoiningTest {

    @Test
    void toStringShouldReturnPeopleNamesSeparatedByComma() {
        List<Person> collection = List.of(SARA, VIKTOR, EVA);

        final var result = namesToString(collection);

        assertThat(result).isEqualTo("Names: Sara, Viktor, Eva.");
    }

}
