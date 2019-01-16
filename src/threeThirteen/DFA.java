package threeThirteen;

import java.util.*;

import org.javatuples.Pair;

/** A DFA is a 5-tuple
 * @author Caelum Sloan
 * @version 1.0
*/
public class DFA 
{
	//A finite set of states.
	private HashSet<State> Q;
	private Alphabet sigma;
	//Q intersect sigma must = the null set.
	
	private Dictionary<Pair<State, Symbol>, State> delta; //
	private State q0; //must be element of Q
	private HashSet<State> F; //must be subset of Q
	
	/**
	 * @throws DFAPropertyInvariantException 
	    * A DFA has important class invariants. If the parameters given are unsatisfactory this constructor will throw an error.
	    * @param Q  Finite set of states. Do not use symbols used in sigma.
	    * @param sigma  An alphabet. Do not use symbols used in Q.
	    * @param delta  The transition function such that the domain is Q X sigma and the range co-domain is Q.
	    * @param q0  The starting state. Ensure q0 is an element of Q.
	    * @param F  Set of accept states. Ensure F is a subset of Q.
	    */
	public DFA(HashSet<State> Q, Alphabet sigma, Dictionary<Pair<State, Symbol>, State> delta, State q0, HashSet<State> F) throws DFAPropertyInvariantException 
	{
		if(QSigmaOverlap(Q, sigma) || !deltaDomainRangeCheckProper(delta))
			throw new DFAPropertyInvariantException();
		
		this.Q = Q;
		this.sigma = sigma;
		this.delta = delta;
		this.q0 = q0;
		this.F = F;
	}
	
	private static boolean QSigmaOverlap(HashSet<State> Q, Alphabet sigma) 
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
	
	private static boolean deltaDomainRangeCheckProper(Dictionary<Pair<State, Symbol>, State> delta) 
	{
		return (!deltaDomainCheckProper(delta.keys()) || !deltaRangeCheckProper(delta.elements()));
	}
	
	private static boolean deltaDomainCheckProper(Enumeration domain) 
	{
		//TODO
	}
	private static boolean deltaRangeCheckProper(Enumeration range) 
	{
		//TODO
	}
}
