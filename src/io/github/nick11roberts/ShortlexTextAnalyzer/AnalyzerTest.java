package io.github.nick11roberts.ShortlexTextAnalyzer;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnalyzerTest {
	
	private String generateReportTestMessage = "Test case: ";
	
	private Analyzer analyzer = new Analyzer();
	private String[] testCases = {};
	private String[] testCasesOut = {};

	@Test
	public void testGenerateReport() {
		
		int testCasesLength = testCases.length;
		for(int i = 0; i < testCasesLength; i++) {
			
			assertEquals(generateReportTestMessage + i, testCasesOut[i], 
					analyzer.generateReport(testCases[i]));
			
		}
	}

}
