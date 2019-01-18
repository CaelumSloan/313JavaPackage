package testing;

import java.util.*;
import org.javatuples.Pair;
import threeThirteen.*;

public class TrafficLightExampleClean 
{
    @SuppressWarnings("serial")
	public static void main(java.lang.String[] args) throws DFAPropertyInvariantException
	{	
		State redLight = new State("q_r");
		State yellowLight = new State("q_y");
		State greenLight = new State("q_g");
		Symbol tick = new Symbol("tick");
		
		Set<State> Q = new HashSet<>(Arrays.asList(redLight, yellowLight, greenLight)); //Set of states used by DFA
		Alphabet sigma = new Alphabet(tick);
		
	    Map<Pair<State,Symbol>, State> transitionFunction = new HashMap<Pair<State,Symbol>, State>() { //Transition Function
	    {
	        put(Pair.with(redLight, tick), greenLight);
	        put(Pair.with(greenLight, tick), yellowLight);
	        put(Pair.with(yellowLight, tick), redLight);
	    }};;
	    
	    State q0 = redLight; //Start State
		
	    Set<State> F = new HashSet<>(Arrays.asList(greenLight)); //Set of accept states
	    
	    DFA trafficLight = new DFA(Q, sigma, transitionFunction, q0, F);
	    
	    //The language of this DFA would be given by L = {w in sigma* | |w| % 3 = 1}
	}
}
