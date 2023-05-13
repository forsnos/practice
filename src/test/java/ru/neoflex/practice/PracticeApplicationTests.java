package ru.neoflex.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PracticeApplicationTests {
	@InjectMocks
	private CalcController calcController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddition() {
		int a = 2;
		int b = 2;
		long expectedResult = 4;
		long actualResult = calcController.Addition(a, b);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void testSubtract() {
		int a = 12;
		int b = 2;
		long expectedResult = 10;
		long actualResult = calcController.Subtraction(a, b);
		assertEquals(expectedResult, actualResult);
	}
}
