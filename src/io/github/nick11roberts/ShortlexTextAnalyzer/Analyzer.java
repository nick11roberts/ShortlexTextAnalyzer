/**
 * 
 * @author Nicholas Roberts
 *
 */
package io.github.nick11roberts.ShortlexTextAnalyzer;

/**
 * Sorts text in shortlex order and displays a word count
 * for each word. 
 */
public class Analyzer {
	
	// Data to be analyzed
	private String inputData; 
	
	/**
	 * Generates a report comprising of a shortlex sorted list 
	 * with each item prepended with an occurrence count.  
	 * 
	 * @param inputData the String to be analyzed
	 * @return the formatted analytics String
	 */
	public String analyze(String inputData) {
		
		// String to eventually be returned
		String report = "";
		
		// Save this to retain stateliness of the calling object
		this.inputData = inputData; 
		
		//
		System.out.println(this.lessThan("sdf", ""));
		System.out.println("".equals(""));
		
		return report;
		
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
		
		// First compare String length
		if(firstString.length() < secondString.length()) {
			
			// Hence SHORTlex order
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
