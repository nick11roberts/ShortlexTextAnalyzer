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
	
	// Message 
	private String generateReportTestMessage = "Test case: ";
	
	private Analyzer analyzer = new Analyzer();
	private String[] testCases = {"", "the"};
	private String[] testCasesOut = {"the SD", "the"};

	@Test
	public void testGenerateReport() {
		
		int testCasesLength = testCases.length;
		for(int i = 0; i < testCasesLength; i++) {
			
			assertEquals(generateReportTestMessage + i, testCasesOut[i], 
					analyzer.generateReport(testCases[i]));
			
		}
	}

}
