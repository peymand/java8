package com.peyman.optional;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalConceptTest {



    //isPresent() method to check if there is a value inside the Optional object.
    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }


    //We can also create an Optional object with the static method of()
    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "peyman";
        Optional<String> opt = Optional.of(name);
        assertTrue(opt.isPresent());
    }

    //the argument passed to the of() method can't be null. Otherwise, we'll get a NullPointerException:
    @Test
    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        String name = null;
        assertThrows(NullPointerException.class, () -> Optional.of(name));
    }


    //But, in case we expect some null values, we can use the ofNullable() method
    @Test
    public void givenNonNull_whenCreatesNullable_thenCorrect() {
        String name = "peyman";
        Optional<String> opt = Optional.ofNullable(name);
        assertTrue(opt.isPresent());
    }

    //if we pass in a null reference, it doesn't throw an exception but rather returns an empty Optional object
    @Test
    public void givenNull_whenCreatesNullable_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertFalse(opt.isPresent());
    }

    //Conditional Action With ifPresent()
    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("peyman");
        opt.ifPresent(name -> System.out.println(name.length()));
    }

    //Default Value With orElse()
    @Test
    public void whenOrElseWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("john");
        assertEquals("john", name);
    }

    //Default Value With orElseGet()
    @Test
    public void whenOrElseGetWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
        assertEquals("john", name);
    }

    //Difference Between orElse and orElseGet()
    @Test
    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String text = null;

        String defaultText = Optional.ofNullable(text).orElseGet(OptionalConcept::getMyDefault);
        assertEquals("Default Value", defaultText);

        defaultText = Optional.ofNullable(text).orElse(OptionalConcept.getMyDefault());
        assertEquals("Default Value", defaultText);
    }

    @Test
    public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
        String text = "Text present";

        System.out.println("Using orElseGet:");
        String defaultText
                = Optional.ofNullable(text).orElseGet(OptionalConcept::getMyDefault);
        assertEquals("Text present", defaultText);

        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(OptionalConcept.getMyDefault());
        assertEquals("Text present", defaultText);
    }


    // retrieving the wrapped value is the get() method
    @Test
    public void givenOptional_whenGetsValue_thenCorrect() {
        Optional<String> opt = Optional.of("peyman");
        String name = opt.get();
        assertEquals("peyman", name);
    }

    //get() can only return a value if the wrapped object is not null, otherwise, it throws a no such element exception:
    @Test
    public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
        Optional<String> opt = Optional.ofNullable(null);
        assertThrows(NoSuchElementException.class,()-> opt.get());
    }

    //Conditional Return With filter()
    @Test
    public void whenOptionalFilterWorks_thenCorrect() {
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        assertTrue(is2016);
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        assertFalse(is2017);
    }


    @Test
    public void whenFiltersWithoutOptional_thenCorrect() {
        assertTrue(OptionalConcept.priceIsInRange1(new Modem(10.0)));
        assertFalse(OptionalConcept.priceIsInRange1(new Modem(9.9)));
        assertFalse(OptionalConcept.priceIsInRange1(new Modem(null)));
        assertFalse(OptionalConcept.priceIsInRange1(new Modem(15.5)));
        assertFalse(OptionalConcept.priceIsInRange1(null));
    }


    @Test
    public void whenFiltersWithOptional_thenCorrect() {
        assertTrue(OptionalConcept.priceIsInRange2(new Modem(10.0)));
        assertFalse(OptionalConcept.priceIsInRange2(new Modem(9.9)));
        assertFalse(OptionalConcept.priceIsInRange2(new Modem(null)));
        assertFalse(OptionalConcept.priceIsInRange2(new Modem(15.5)));
        assertFalse(OptionalConcept.priceIsInRange2(null));
    }

    //Transforming Value With map()
    @Test
    public void givenOptional_whenMapWorks_thenCorrect() {
        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int size = listOptional
                .map(List::size)
                .orElse(0);
        assertEquals(6, size);
    }

    @Test
    public void givenOptional_whenMapWorks_thenCorrect2() {
        String name = "baeldung";
        Optional<String> nameOptional = Optional.of(name);

        int len = nameOptional
                .map(String::length)
                .orElse(0);
        assertEquals(8, len);
    }
    //We can chain map and filter together to do something more powerful.
    @Test
    public void givenOptional_whenMapWorksWithFilter_thenCorrect() {
        String password = " password ";
        Optional<String> passOpt = Optional.of(password);
        boolean correctPassword = passOpt.filter(
                pass -> pass.equals("password")).isPresent();
        assertFalse(correctPassword);

        correctPassword = passOpt
                .map(String::trim)
                .filter(pass -> pass.equals("password"))
                .isPresent();
        assertTrue(correctPassword);
    }

    //Transforming Value With flatMap()
    @Test
    public void givenOptional_whenFlatMapWorks_thenCorrect2() {
        Person person = new Person("john", 26);
        Optional<Person> personOptional = Optional.of(person);

        Optional<Optional<String>> nameOptionalWrapper
                = personOptional.map(Person::getName);
        Optional<String> nameOptional
                = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
        String name1 = nameOptional.orElse("");
        assertEquals("john", name1);

        String name = personOptional
                .flatMap(Person::getName)
                .orElse("");
        assertEquals("john", name);
    }

    //Chaining Optionals in Java 8


}