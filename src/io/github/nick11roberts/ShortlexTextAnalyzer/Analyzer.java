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
	
	// For special cases
	private String emptyString = "";
	private String spaceString = " ";
	private String trivialOutputData = "";
	
	/**
	 * Generates a report comprising of a shortlex sorted list 
	 * with each item prepended with an occurrence count.  
	 * 
	 * @param inputData the data to be analyzed
	 * @return the formatted analytics String
	 */
	public String generateReport(String inputData) {
		
		// First handle special cases
		if(inputData.equals(emptyString) || inputData.equals(spaceString)) {
			
			return trivialOutputData;
			
		}
		
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
		
		// Assume sorted, compare each element to neighbor, beginning 
		// with index 1, to ascertain equality and thus contribute to 
		// a word count
		int sortedWordsLength = sortedWords.length;
		int k = sortedWordsLength - 1;
		int numberOfUniqueWords = sortedWordsLength;
		int runWordIndex = 0;
		boolean startRun = false;
		wordCount = new int[sortedWordsLength];
		for(int i = 0; i < sortedWordsLength; i++) {
			
			wordCount[i] = 1;
			
		}
		for(int i = 1; i < sortedWordsLength; i++) {
			
			if(sortedWords[i - 1].equals(sortedWords[i])){
				
				// Check if we have begun a run of equal Strings
				if(!startRun) {
					
					// Save the index, but only this time
					startRun = true;
					runWordIndex = i - 1;
					
				}
				
				// Update the appropriate index
				wordCount[runWordIndex]++;
				
				// We no longer have this many unique elements, 
				// update accordingly
				wordCount[k] = 0;
				k--;
				numberOfUniqueWords--;
				
			} else {
				
				// We have not started a run
				startRun = false;
				
			}
			
		}
		
		// Generate a report string by combining the two arrays and 
		// removing duplicates
		int j = 0;
		for(int i = 1; i < sortedWordsLength; i++) {
			
			// Check if the two are different
			if(!sortedWords[i - 1].equals(sortedWords[i])) {
				
				// Construct a formatted report
				report += "\n   " + wordCount[j++] + " " 
						+ sortedWords[i - 1] + "\n";
				
			}
			
		}
		
		// Add the last element if the list isn't empty
		if(numberOfUniqueWords != 0) {

			// Assumed format of the report entries
			report += "\n   " + wordCount[numberOfUniqueWords - 1] + " " 
					+ sortedWords[sortedWordsLength - 1] + "\n";
			
		}
		
		return report;
		
	}
	
	/**
	 * Efficiently sorts a String[] in shortlex order
	 * 
	 * @param toBeSorted the String[] that is to be sorted
	 * @return the sorted array
	 */
	private String[] mergeSort(String[] toBeSorted) {
		
		// Get the size of the array
		int arrayLength = toBeSorted.length;
		if(arrayLength < 2) {
			return toBeSorted;
		}
		
		// Find the 'middle' index and split the array
		int midIndex = arrayLength / 2; 
		String[] leftSide = Arrays.copyOfRange(toBeSorted, 0, midIndex);
		String[] rightSide = Arrays.copyOfRange(toBeSorted, midIndex, arrayLength);
		
		this.mergeSort(leftSide);
		this.mergeSort(rightSide);
		this.merge(leftSide, rightSide, toBeSorted);
		
		return toBeSorted;
		
	}
	
	/**
	 * Merges two sorted arrays into a larger sorted array
	 * 
	 * @param leftSide the first smaller sorted array
	 * @param rightSide the second smaller sorted array
	 * @param mergedArray the final sorted array to be constructed
	 * @return the final sorted array
	 */
	private String[] merge(String[] leftSide, 
			String[] rightSide, String[] mergedArray) {
		
		// Calculate the sizes of each side 
		int leftSize = leftSide.length;
		int rightSize = rightSide.length;
		
		// Counters for left, right, and merged respectively
		int i = 0;
		int j = 0;
		int k = 0;
		
		// Weave the elements in a sorted manner while there are still 
		// elements in both lists
		while (i < leftSize && j < rightSize) {
			
			// Comparison to determine which one should be added to merged
            if (this.greaterThan(leftSide[i], rightSide[j])) {	
            	
            	// Take the smaller one
            	mergedArray[k++] = rightSide[j++];
            	
            } else {
            	
            	// Take the smaller or equal one
            	mergedArray[k++] = leftSide[i++];
            	
            }
            
        }
		
		// Complete the rest of both leftSide and rightSide
        while (i < leftSize) {
        	mergedArray[k++] = leftSide[i++];
        } 
        
        while (j < rightSize) {
        	mergedArray[k++] = rightSide[j++];
        }
		
		return mergedArray;
		
	}

	/**
	 * ASCII shortlex comparison for two String objects 
	 * 
	 * @param firstString the first operand to be compared
	 * @param secondString the second operand to be compared
	 * @return true iff firstString is greater than secondString 
	 * in ASCII shortlex order
	 */
	private boolean greaterThan(String firstString, String secondString){
		
		// boolean to eventually be returned, assume false
		boolean isGreaterThan = false;
		
		// First compare String length, hence SHORTlex order
		if(firstString.length() > secondString.length()) {
			
			isGreaterThan = true;
			
		} else if(firstString.length() < secondString.length()) {
			
			isGreaterThan = false; 
			
		} else {
			
			// Must be of equal length, check ASCII characters
			// Thus choice of firstString was arbitrary
			int stringSize = firstString.length();
			
			// Check each individual ASCII character code
			for(int i = 0; i < stringSize; i++) {
				
				// If the two differ, then set isLessThan to either true or false
				if((int)firstString.charAt(i) 
						> (int)secondString.charAt(i)){
					
					isGreaterThan = true;
					break;
					
				} else if((int)firstString.charAt(i) 
						< (int)secondString.charAt(i)) {
					
					isGreaterThan = false;
					break;
					
				}
				
			}
			
		}
		
		return isGreaterThan;
		
	}

}
