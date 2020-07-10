package com.mygglo.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyMathTest {

    private int[] arrangeNumbers;

    @BeforeEach
    void setUp() {
        // Arrange
        System.out.println("Before");
        arrangeNumbers = new int[]{5, 2, 3};
    }

    @AfterEach
    void tearDown() {
        System.out.println("After");
        arrangeNumbers = null;
    }

    @Test
    public void sumMustBeEqualToSix() {
        System.out.println("== sumMustBeEqualToSix ===");
        //Arrange
        int[] numbers = new int[]{1, 2, 3};

        // Act
        MyMath myMath = new MyMath();
        int result = myMath.sum(numbers);

        //Assertion
         assertThat(result).isNotNull();
         assertThat(result).isEqualTo(6);
    }

    @Test
    public void sumMustBeGreaterThanFour() {
        System.out.println("== sumMustNotBeEqualToFour ===");
        // Act
        MyMath myMath = new MyMath();
        int result = myMath.sum(arrangeNumbers);

        //Assertion
        assertThat(result).isNotNull();
        assertThat(result).isGreaterThan(4);
    }

}
