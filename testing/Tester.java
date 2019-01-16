package testing;

import java.util.*;

import org.javatuples.Pair;

import threeThirteen.*;
import threeThirteen.String; //Use 313 String - not the java "" String

/**
 * @author Caelum Sloan
*/
public class Tester 
{
	@SuppressWarnings("serial")
    public static void main(java.lang.String[] args) throws DFAPropertyInvariantException
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
		
		
		//Street light example
		State redLight = new State("q_r");
		State yellowLight = new State("q_y");
		State greenLight = new State("q_g");
		
		Set<State> Q = new HashSet<>(Arrays.asList(redLight, yellowLight, greenLight)); 
		
		Alphabet streetLightSigma = new Alphabet(tick);
		
        Map<Pair<State,Symbol>, State> lowerCaseDelta = new HashMap<Pair<State,Symbol>, State>() {
        {
	        put(Pair.with(redLight, tick), greenLight);
	        put(Pair.with(greenLight, tick), yellowLight);
	        put(Pair.with(yellowLight, tick), redLight);
	    }};;
	    
	    State startState = redLight;
		
	    Set<State> F = new HashSet<>(Arrays.asList(greenLight)); 
	    
	     DFA trafficLight = new DFA(Q, streetLightSigma, lowerCaseDelta, startState, F);
		
		String string1 = new String(tick);
		String string2 = new String(tick, tick);
		String string3 = new String(tick, tick, tick);
		
		System.out.println("The traffic light accept string1: " + trafficLight.Accepts(string1));
		System.out.println("The traffic light accept string2: " + trafficLight.Accepts(string2));
		System.out.println("The traffic light accept string3: " + trafficLight.Accepts(string3));
		
		System.out.println("\n\n");
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
