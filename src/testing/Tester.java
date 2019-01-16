package testing;

import threeThirteen.*;
import threeThirteen.String; //Use 313 String - not the java "" String

/**
 * @author Caelum Sloan
*/
public class Tester 
{
	public static void main(java.lang.String[] args)
	{
		Symbol tick = new Symbol("tick");
		
		String w = new String(tick, tick, tick);
		String testString2 = new String(new Symbol[]{tick, tick, tick, tick});
		String lambda = new String();
		
		Alphabet sigma = new Alphabet(tick);
		//We cannot return sigma* since physics does not generally support infinite sets :/
		//If we could we would deem it a language and specifically a language over sigma
		Alphabet emptyAlpha = new Alphabet();
		
		Language L = new Language(w, testString2 /*, lambda*/);
		Language emptyLanguage = new Language();
		
		// Decision Problem: Does some string w element of some sigma* belong to a given language L where L is over sigma.
		
		//Tests
		System.out.println("symbol tick is in sigma: " + sigma.includes(tick));
		System.out.println("string w over sigma: " + sigma.stringOver(w));
		System.out.println("string testString2 over sigma: " + sigma.stringOver(testString2));
		System.out.println("empty string lambda over sigma: " + sigma.stringOver(lambda));
		System.out.println("language L over sigma: " + sigma.languageOver(L));
		System.out.println("empty language over sigma: " + sigma.languageOver(emptyLanguage));

		System.out.println("\n\n");
		
		System.out.println("symbol tick is in emptyAlpha: " + emptyAlpha.includes(tick));
		System.out.println("string w over emptyAlpha: " + emptyAlpha.stringOver(w));
		System.out.println("string testString2 over emptyAlpha: " + emptyAlpha.stringOver(testString2));
		System.out.println("empty string lambda over emptyAlpha: " + emptyAlpha.stringOver(lambda));
		System.out.println("language L over emptyAlpha: " + emptyAlpha.languageOver(L));
		System.out.println("empty language over emptyAlpha: " + emptyAlpha.languageOver(emptyLanguage));
		
		System.out.println("\n\n");
		
		System.out.println("string w belong to L: " + L.includes(w));
		System.out.println("string testString2 belong to L: " + L.includes(testString2));
		System.out.println("empty string lambda belong to L: " + L.includes(lambda));
		
		System.out.println("\n\n");
		
		System.out.println("string w belong to emptyLanguage: " + emptyLanguage.includes(w));
		System.out.println("string testString2 belong to emptyLanguage: " + emptyLanguage.includes(testString2));
		System.out.println("empty string lambda belong to emptyLanguage: " + emptyLanguage.includes(lambda));
	}
}
