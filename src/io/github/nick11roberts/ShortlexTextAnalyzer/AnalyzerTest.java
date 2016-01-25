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
