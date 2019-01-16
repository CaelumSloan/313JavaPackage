package threeThirteen;

import java.util.*;

import org.javatuples.Pair;

/** A DFA is a 5-tuple
 * @author Caelum Sloan
 * @version 1.0
*/
public class DFA 
{
    //Properties
	private Alphabet sigma;
	
	//The transition function
	private Map<Pair<State, Symbol>, State> delta;
	 //The start state
	private State q_0;
	//The set of accepting states
	private Set<State> F;
	
	//Constructors
	/**
	 * @throws DFAPropertyInvariantException 
	    * A DFA has important class invariants. If the parameters given are unsatisfactory this constructor will throw an error.
	    * @param Q  Finite set of states. Do not use symbols used in sigma.
	    * @param sigma  An alphabet. Do not use symbols used in Q.
	    * @param delta  The transition function such that the domain is Q X sigma and the range co-domain is Q.
	    * @param q_0  The starting state. Ensure q0 is an element of Q.
	    * @param F  Set of accept states. Ensure F is a subset of Q.
	    */
	public DFA(Set<State> Q, Alphabet sigma, Map<Pair<State, Symbol>, State> delta, State q_0,  Set<State> F) throws DFAPropertyInvariantException 
	{
		if(QSigmaOverlap(Q, sigma) || !deltaDomainRangeCheckProper(Q, sigma, delta) || !Q.contains(q_0) || !FsubsetQCheck(Q, F))
			throw new DFAPropertyInvariantException();
		
		this.sigma = sigma;
		this.delta = delta;
		this.q_0 = q_0;
		this.F = F;
	}
	
	
	//Functions
	private static boolean QSigmaOverlap(Set<State> Q, Alphabet sigma) 
	{
        for(Symbol symbol : Q) 
        {
        	if (sigma.symbols().contains(symbol))
        		return true;
        }
        for(Symbol symbol : sigma.symbols()) 
        {
        	if (Q.contains(symbol))
        		return true;
        }
        
        return false;
	}
	
	private static boolean deltaDomainRangeCheckProper(Set<State> Q, Alphabet sigma, Map<Pair<State, Symbol>, State> delta) 
	{
		return deltaDomainCheckProper(Q,  sigma, delta.keySet()) && deltaRangeCheckProper(Q, delta.values());
	}
	private static boolean deltaDomainCheckProper(Set<State> Q, Alphabet sigma, Set<Pair<State, Symbol>> domain) 
	{
	    for(Pair<State,Symbol> pair : domain) 
	    {
	           if (!Q.contains( pair.getValue0()) || !sigma.includes(pair.getValue1()))
	                return false;
	    }

        return true;
	}
	private static boolean deltaRangeCheckProper(Set<State> Q, Collection<State>  range) 
	{
	       for(State state : range) 
	       { 
	           if (!Q.contains(state))
                return false;
           }

        return true;
	}
	
	private static boolean FsubsetQCheck(Set<State> Q, Set<State> F ) 
	{
        for(Symbol symbol : F) 
        {
            if (!Q.contains(symbol))
                return false;
        }
        return true;
	}
	
   /**
    * @throws IllegalArgumentException
    * Inputs the symbols into the DFA and returns whether the resulting state is an accepting state.
    * @param string  A sequence of inputs to feed into the DFA. The string should be over the DFA's alphabet.
    */
	public boolean Accepts(String string) 
	{
	    if(!sigma.stringOver(string))
	        throw new IllegalArgumentException("string must be over the DFA's alphabet!");
	    State currentState = q_0;
	    for(Symbol symbol : string.value()) 
	    {
	       if(delta.containsKey(Pair.with(currentState, symbol))) 
	       {
	           currentState = delta.get(Pair.with(currentState, symbol));
	       }
	    }
	    return F.contains(currentState);
	}
}
