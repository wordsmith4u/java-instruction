package gerlach.business.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gerlach.business.Grade;

class GradeTest {

	@Test
	void testLetterGradeA() {
		Grade gradeA = new Grade(88, null);

		assertEquals("A", gradeA.getLetter());

	}

	@Test
	void testLetterGradeF() {
		Grade gradeF = new Grade(50, null);

		assertEquals("F", gradeF.getLetter());

	}
}
