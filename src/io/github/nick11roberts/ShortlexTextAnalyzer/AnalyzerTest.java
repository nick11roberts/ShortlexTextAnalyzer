/**
 * 
 * @author Nicholas Roberts
 *
 */
package io.github.nick11roberts.ShortlexTextAnalyzer;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A test class for the Analyzer class. 
 */
public class AnalyzerTest {
	
	// Message for each case
	private String generateReportTestMessage = "Failure at test case #";
	
	// Instance variables for simulating usage
	private Analyzer analyzer = new Analyzer();
	private String[] testCases = {
			"",
			" ",
			"The quick brown fox jumped over the lazy brown dog’s back", 
			"and the", 
			"the the", 
			"and and and and and and",
			"Sick sick and more sick Bleh.",
			"the the the and and what what what what what what the and huh?",
			"a a a b b b c c c d e f g h h h i i i j j j " +
					"k l m n o p q r s t u v w w x x y z z z z", 
	};
	private String[] testCasesOut = {
			"",
			"",
			"\n   1 The\n\n   1 fox\n\n   1 the\n\n   1 back\n\n   " +
					"1 lazy\n\n   1 over\n\n   2 brown\n\n   1 dog’s\n\n   " +
					"1 quick\n\n   1 jumped\n", 
			"\n   1 and\n\n   1 the\n",
			"\n   2 the\n",
			"\n   6 and\n",
			"\n   1 and\n\n   1 Sick\n\n   1 more\n\n   2 sick\n\n   " +
					"1 Bleh.\n",
			"\n   3 and\n\n   4 the\n\n   1 huh?\n\n   6 what\n",
			"\n   3 a\n\n   3 b\n\n   3 c\n\n   1 d\n\n   " +
					"1 e\n\n   1 f\n\n   1 g\n\n   3 h\n\n   " +
					"3 i\n\n   3 j\n\n   1 k\n\n   1 l\n\n   " +
					"1 m\n\n   1 n\n\n   1 o\n\n   1 p\n\n   " +
					"1 q\n\n   1 r\n\n   1 s\n\n   1 t\n\n   " +
					"1 u\n\n   1 v\n\n   2 w\n\n   2 x\n\n   " +
					"1 y\n\n   4 z\n",
			
	};

	/**
	 * Tests the generateReport(String) method of the Analyzer class
	 */
	@Test
	public void testGenerateReport() {
		
		// Iterate through the test cases
		int testCasesLength = testCases.length;
		for(int i = 0; i < testCasesLength; i++) {
			
			// Test the case
			assertEquals(generateReportTestMessage + (i + 1), testCasesOut[i], 
					analyzer.generateReport(testCases[i]));
			
			
		}
		
	}

}
