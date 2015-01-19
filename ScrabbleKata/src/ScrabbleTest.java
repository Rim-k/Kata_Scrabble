import static org.junit.Assert.*;

import org.junit.Test;


public class ScrabbleTest {

	private Scrabble scrabble = new Scrabble("", "src\\ListeMots.txt");
	private String expectedResult;
	private String actualResults;
	
	@Test
	public void testWithMatinMustReturnFourResults() {
		 expectedResult = "[MAINT, MATIN, MINAT, MITAN]";
		 actualResults = scrabble.getLongestWords("matin").toString();
		
		 assertEquals(expectedResult, actualResults);
	}
	
	@Test
	public void testWithBonjourMustReturnBonjour() {
		 expectedResult = "[BONJOUR]";
		 actualResults = scrabble.getLongestWords("Bonjour").toString();
		
		 assertEquals(expectedResult, actualResults);
	}
	
	@Test
	public void testWithASharpMustReturnTwelveResults() {
		 expectedResult = "[ESTE, ETES, SATE, SUET, TEES, TEST, TETS, TUES, UTES, VETS, YETS, ZEST]";
		 actualResults = scrabble.getLongestWords("tes#").toString();
		
		 assertEquals(expectedResult, actualResults);
	}
	
	@Test
	public void testWithTwoSharpsMustReturnSixResults() {
		 expectedResult = "[FEUJ, JEUX, JUBE, JUDD, JUGE, JUIF]";
		 actualResults = scrabble.getLongestWords("j#u#").toString();
		
		 assertEquals(expectedResult, actualResults);
	}
	
	

}
