package ru.zmo00.javaded;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerApplicationTest {

    @Nested
    public class IsLeapYearTest {

        @ParameterizedTest
        @ValueSource(ints = {1, 13, 551, 1002, 2010, 2023, 2025})
        public void isLeapYear_whenNotDividedFour_thenFalse(int year) {
            assertFalse(IntegerApplication.isLeapYear(year));
        }

        @ParameterizedTest
        @ValueSource(ints = {100, 200, 500, 600, 1700, 1800, 1900, 2100})
        public void isLeapYear_whenIsCenturyAndNotDividedFour_thenFalse(int year) {
            assertFalse(IntegerApplication.isLeapYear(year));
        }

        @ParameterizedTest
        @ValueSource(ints = {400, 800, 1600, 2000})
        public void isLeapYear_whenIsCenturyAndNotDividedFour_thenTrue(int year) {
            assertTrue(IntegerApplication.isLeapYear(year));
        }

        @ParameterizedTest
        @ValueSource(ints = {4, 16, 624, 1812, 2024})
        public void isLeapYear_whenDividedFour_thenTrue(int year) {
            assertTrue(IntegerApplication.isLeapYear(year));
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // Первая дверь на этаже
            "3, 13, 5, 1",
            "4, 9, 3, 1",
            "5, 1, 1, 1",

            // Средняя дверь на этаже
            "3, 14, 5, 2",
            "4, 11, 3, 3",
            "5, 4, 1, 4",

            // Последняя дверь на этаже
            "3, 15, 5, 3",
            "4, 12, 3, 4",
            "5, 5, 1, 5",

            // Всего одна квартира
            "1, 1, 1, 1"
    })
    public void floorAndFlatCalculate_shouldCorrectOutput(String values) {
        int[] params = Arrays.stream(values.split(", "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int flatOnFloorCount = params[0];
        int flatNumber = params[1];
        int[] result = {params[2], params[3]};

        assertArrayEquals(result, IntegerApplication.floorAndFlatCalculate(flatOnFloorCount, flatNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2500, 0, 1, 0, 1",
            "8500, 1, 1, 1, 1",
            "63000, 12, 1, 1, 0",
            "74500, 14, 2, 0, 1"
    })
    public void withdrawCash_shouldCorrectOutput(String values) {
        int[] params = Arrays.stream(values.split(", "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int sum = params[0];
        int[] result = {params[1], params[2], params[3], params[4]};

        assertArrayEquals(result, IntegerApplication.withdrawCash(sum));
    }
}