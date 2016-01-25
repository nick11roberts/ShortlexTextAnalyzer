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
	public String generateReport(String inputData) {
		
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
		
		// TODO remove this
		System.out.println(Arrays.toString(sortedWords));
		
		// Assume sorted, compare each element to neighbor, beginning 
		// with index 1, to ascertain equality and thus contribute to 
		// a word count
		int sortedWordsLength = sortedWords.length;
		int numberOfUniqueWords = 0;
		wordCount = new int[sortedWordsLength];
		for(int i = 1; i < sortedWordsLength; i++) {
			
			// Equality comparison with the last word
			if(sortedWords[i-1].equals(sortedWords[i])) {
				
				++wordCount[numberOfUniqueWords];
				
			} else {
				
				++numberOfUniqueWords;
				
			}
			
		}
		
		// Correct for off-by-one error for each element up to 
		// numberOfUniqueWords inclusively
		for(int i = 0; i <= numberOfUniqueWords; i++) {
			
			++wordCount[i];
			
		}
		
		// TODO remove this
		System.out.println(Arrays.toString(wordCount));
		
		return report;
		
	}
	
	/**
	 * 
	 * 
	 * @param inputArray
	 * @return
	 */
	public String[] mergeSort(String[] inputArray) {
		
		// Get the size of the array
		int arrayLength = inputArray.length;
		if(arrayLength < 2) {
			return inputArray;
		}
		
		// Find the 'middle' index and split the array
		int midIndex = arrayLength / 2; 
		String[] leftSide = Arrays.copyOfRange(inputArray, 0, midIndex);
		String[] rightSide = Arrays.copyOfRange(inputArray, midIndex, arrayLength);
		
		this.mergeSort(leftSide);
		this.mergeSort(rightSide);
		this.merge(leftSide, rightSide, inputArray);
		
		return inputArray;
		
	}
	
	/**
	 * 
	 * 
	 * @param leftSide
	 * @param rightSide
	 * @param input
	 * @return
	 */
	private String[] merge(String[] leftSide, 
			String[] rightSide, String[] mergedArray) {
		
		// Calculate the sizes of each side 
		int leftSize = leftSide.length;
		int rightSize = rightSide.length;
		
		int i = 0, j = 0, k = 0;
		
		// Weave the elements in a sorted manner while there are still elements in
		// both lists
		while (i < leftSize && j < rightSize) {
            if (this.greaterThan(leftSide[i], rightSide[j])) {	
            	mergedArray[k++] = rightSide[j++];
            } else {
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
	 * 
	 * 
	 * @param firstString
	 * @param secondString
	 * @return
	 */
	public boolean greaterThan(String firstString, String secondString){
		
		// boolean to eventually be returned, assume false
		boolean iGreaterThan = false;
		
		// First compare String length, hence SHORTlex order
		if(firstString.length() > secondString.length()) {
			
			iGreaterThan = true;
			
		} else if(firstString.length() < secondString.length()) {
			
			iGreaterThan = false; 
			
		} else {
			
			// Must be of equal length, check ASCII characters
			// Thus choice of firstString was arbitrary
			int stringSize = firstString.length();
			
			// Check each individual ASCII character code
			for(int i = 0; i < stringSize; i++) {
				
				// If the two differ, then set isLessThan to either true or false
				if((int)firstString.charAt(i) 
						> (int)secondString.charAt(i)){
					
					iGreaterThan = true;
					break;
					
				} else if((int)firstString.charAt(i) 
						< (int)secondString.charAt(i)) {
					
					iGreaterThan = false;
					break;
					
				}
				
			}
			
		}
		
		return iGreaterThan;
		
	}

}
