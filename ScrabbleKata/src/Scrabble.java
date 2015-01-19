import java.util.Iterator;
import java.util.TreeSet;


public class Scrabble {
	
	private Anagram dictionnary;
	
	public Scrabble (String lettersSource, String wordsListSource){
		this.dictionnary = new Anagram(wordsListSource);
	}
	
	public String getLongestWords(String letters) {
		
		int maxSize = letters.length();
		String lettersKey = dictionnary.getSortedWord(letters);
		
		TreeSet<String> longestWords = new TreeSet<String>();
		TreeSet<String> potentialKeys = this.dictionnary.getKeysWithSizeLessThan(maxSize+1);
		//System.out.println("potential keys: " + potentialKeys.toString());
		Iterator<String> potentialKeysIterator = potentialKeys.iterator();
					
		String currentKey;
		int longestWordLength = 0;
		
		while (potentialKeysIterator.hasNext()) {
			
			currentKey = potentialKeysIterator.next();
			//System.out.println(longestWordLength + "VS" + currentKey.length());
			if ( longestWordLength > currentKey.length() ) {
				break;
			}
						
			if (lettersKey.contains(currentKey) || currentKey.contains(lettersKey.replace("#", ""))) {
				longestWordLength = currentKey.length();
				longestWords.addAll(dictionnary.getAnagrams(currentKey));
			}
			
		}
		
		return longestWords.toString();
	}
	
}
