/**
 * 
 * @author Nicholas Roberts
 *
 */
package io.github.nick11roberts.ShortlexTextAnalyzer;

import java.util.Arrays;

/**
 * Sorts text in shortlex order and displays a word count
 * for each word. 
 */
public class Analyzer {
	
	/**
	 * Generates a report comprising of a shortlex sorted list 
	 * with each item prepended with an occurrence count.  
	 * 
	 * @param inputData the data to be analyzed
	 * @return the formatted analytics String
	 */
	public String analyze(String inputData) {
		
		// String to eventually be returned
		String report = "";
		
		// Sorted array of words with possible repetitions
		String[] sortedWords;
		
		// Sorted array of wordcounts ordered by only the 
		// unique elements in sortedWords
		int[] wordCount;
		
		// Split inputData into an array of words, meaning everything that is
		// separated by " ", and perform mergesort on sortedWords using 
		// lessThan() comparison
		sortedWords = this.mergeSort(inputData.split(" "));
		
		System.out.println(Arrays.toString(sortedWords));
		
		// Assume sorted, compare each element to neighbor, beginning 
		// with index 1, to ascertain equality and thus contribute to 
		// a word count
		/*
		int sortedWordsLength = sortedWords.length;
		wordCount = new int[sortedWordsLength];
		for(int i = 1; i < sortedWordsLength; i++) {
			
			// Equality comparison with the last word
			if(sortedWords[i-1].equals(sortedWords[i])) {
				
				++wordCount[i-1];
				
			}
			
		}
		*/
		
		return report;
		
	}
	
	/**
	 * 
	 * 
	 * @param unsortedList
	 * @return
	 */
	private String[] mergeSort(String[] unsortedList) {
		
		// TODO implement mergeSort
		
		return unsortedList;
		
	}

	/**
	 * 
	 * 
	 * @param firstString
	 * @param secondString
	 * @return
	 */
	private boolean lessThan(String firstString, String secondString){
		
		// boolean to eventually be returned, assume false
		boolean isLessThan = false;
		
		// First compare String length, hence SHORTlex order
		if(firstString.length() < secondString.length()) {
			
			isLessThan = true;
			
		} else if(firstString.length() > secondString.length()) {
			
			isLessThan = false; 
			
		} else {
			
			// Must be of equal length, check ASCII characters
			// Thus choice of firstString was arbitrary
			int stringSize = firstString.length();
			
			// Check each individual ASCII character code
			for(int i = 0; i < stringSize; i++) {
				
				// If the two differ, then set isLessThan to either true or false
				if((int)firstString.charAt(i) 
						< (int)secondString.charAt(i)){
					
					isLessThan = true;
					
				} else if((int)firstString.charAt(i) 
						> (int)secondString.charAt(i)) {
					
					isLessThan = false;
					
				}
				
			}
			
		}
		
		return isLessThan;
		
	}

}
