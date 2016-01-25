package io.github.nick11roberts.ShortlexTextAnalyzer;

public class Driver {
	
	public static void main(String[] args) {
		
		Analyzer analyzer = new Analyzer();
		
		System.out.println(
				analyzer.generateReport(
						"The quick brown fox jumped over the lazy brown dog’s back"));

		
	}

}
