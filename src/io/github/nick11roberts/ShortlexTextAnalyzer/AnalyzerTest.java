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
	private String generateReportTestMessage = "Test case: ";
	
	// Instance variables for simulating usage
	private Analyzer analyzer = new Analyzer();
	private String[] testCases = {};
	private String[] testCasesOut = {};

	/**
	 * Tests the generateReport(String) method of the Analyzer class
	 */
	@Test
	public void testGenerateReport() {
		
		// Iterate through the test cases
		int testCasesLength = testCases.length;
		for(int i = 0; i < testCasesLength; i++) {
			
			// Test the case
			assertEquals(generateReportTestMessage + i, testCasesOut[i], 
					analyzer.generateReport(testCases[i]));
			
			
		}
		
	}

}
