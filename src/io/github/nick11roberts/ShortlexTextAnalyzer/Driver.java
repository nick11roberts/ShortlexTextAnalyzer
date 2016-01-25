package io.github.nick11roberts.ShortlexTextAnalyzer;

import java.util.Arrays;

public class Driver {
	
	public static void main(String[] args) {
		
		Analyzer analyzer = new Analyzer();
		int[] list = {1, 10, 8, 2, 11, 6, 3, 5, 7, 9, 4};
		
		System.out.println(
				analyzer.generateReport(
						"The quick brown fox jumped over the lazy brown dog’s back"));

		
	}

}
