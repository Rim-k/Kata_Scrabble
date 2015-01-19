

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class Anagram
{
	private HashMap<String, TreeSet<String>> anagrams = new HashMap<String, TreeSet<String>>();

	public Anagram (String wordsListSource) {
		this.loadFile(wordsListSource);
	}

	private void loadFile(String filePath) {
		try {

			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null)
			{
				getListByKey(anagrams, getSortedWord(word)).add(word);
			}
			br.close();
		}
		catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());       
		}
	}

	//returns the list in the hashmap with the specified key or create a new if it doesn't exist
	private TreeSet<String> getListByKey(HashMap<String, TreeSet<String>> hashMap, String key) {

		if (!hashMap.containsKey(key)) {
			TreeSet<String> result = new TreeSet<String>();
			hashMap.put(key, result);
		}
		return hashMap.get(key);
	}

	public void findAnagrams(String input, String output){
		this.loadFile(input);
		this.saveResult(output);
	}

	public String getSortedWord(String word){
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars).toLowerCase();
	}

	public String listToString(TreeSet<String> list){
		String result = "";
		for (String s : list){
			result += s + " ";
		}
		//System.out.println(result);
		return result;
	}

	private void saveResult (String output){
		File file = new File(output);
		try {
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			for (String anagrams : getSortedList()){
				bw.write(anagrams);
				bw.newLine();
			}

			bw.close();

		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	private TreeSet<String> getSortedList(){
		TreeSet<String> result = new TreeSet<String>();
		for (TreeSet<String> list : anagrams.values()){
			result.add(listToString(list));
		}
		return result;
	}

	public TreeSet<String> getAnagrams(String word) {
		String key = getSortedWord(word);
		return this.anagrams.get(key);
	}

	public TreeSet<String> getKeysWithSizeLessThan(int maxSize) {
		
		TreeSet<String> matchingKeys = new TreeSet<String> (new MyComparator());
		
		for (String key : this.anagrams.keySet()){
			if (key.length() < maxSize) {
				matchingKeys.add(key);
			}
		}

		return matchingKeys;
	}

	class MyComparator implements Comparator<String> {

		@Override
		public int compare(String s1, String s2) {
			if (s2.length() < s1.length()) {
				return -1;
			}else {
				return 1;
			}
		}

	}

}

