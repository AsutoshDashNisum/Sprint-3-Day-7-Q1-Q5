package com.example.calculator;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LifecycleTestQ2 {

    @BeforeAll
    void beforeAllTests() {
        System.out.println("@BeforeAll - Run once before all tests");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("@BeforeEach - Run before each test");
    }

    @Test
    void testOne() {
        System.out.println("@Test - Executing testOne");
    }

    @Test
    void testTwo() {
        System.out.println(" @Test - Executing testTwo");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("@AfterEach - Run after each test");
    }

    @AfterAll
    void afterAllTests() {
        System.out.println("@AfterAll - Run once after all tests");
    }
}
