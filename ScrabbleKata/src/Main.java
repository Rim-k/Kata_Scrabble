import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main (String[] args) {

		Scrabble Scrabble = new Scrabble("", "src\\ListeMots.txt");
		boolean stop = false;
		
		while (stop == false) {
			System.out.println("Please Enter 7 random letters or less :_\n");

			//  open up standard input
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String letters = "";

			try {
				letters = br.readLine();
				if (letters.length() > 7) {
					System.out.println("the number of letters is greater than 7 !");
					continue;
				}
				System.out.print("Longest words for \"" + letters +"\": " );
				long startTime = System.nanoTime();
				System.out.println(Scrabble.getLongestWords(letters));
				long endTime = System.nanoTime();
				System.out.println("Execution time: "+(endTime - startTime)/1000000 + " ms\n");
			} catch (IOException ioe) {
				System.out.println("IO error trying to read letters!");
				System.exit(1);
			}
		}
	}

}
