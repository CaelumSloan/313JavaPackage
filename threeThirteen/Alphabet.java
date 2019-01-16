package threeThirteen;

import java.util.*;

import threeThirteen.String;

/** Finite set of symbols
 * @author Caelum Sloan
 * @version 1.0
*/
public class Alphabet 
{
	//Properties
	private Set<Symbol> symbols = new HashSet<Symbol>();
	
	//Constructors
	public Alphabet() {}
	
	public Alphabet(Set<Symbol> symbols) 
	{
		this.symbols = symbols;
	}
	
	public Alphabet(Symbol... symbols) 
	{
	    for (Symbol s : symbols) 
	    	this.symbols.add(s);
	}

	//Getter Setters
	public Set<Symbol> symbols() 
	{
		HashSet<Symbol> copy = new HashSet<Symbol>();
		for(Symbol s : symbols) 
		{
			copy.add(s);
		}
		return copy;
	}
	
	//Functions
	/**
    * Method for testing the relationship of a string to an alphabet.
    * @param stringToTest  The string to test, empty string is a string over every alphabet.
    * @return if all of the symbols in the string are symbols of this alphabet.
    */
	public boolean stringOver(String stringToTest)
	{
		//The empty string is a string over every alphabet.
		if (stringToTest.value().size()==0) 
			return true;
		
		//Ensure all symbols present in the string are subsequently present in this alphabet
		for(Symbol symbol : stringToTest.value())
		{
			if (!symbols().contains(symbol)) 
				return false;
		}
		
		return true;
	}
	
   /**
    * Method for testing the relationship of a language to an alphabet.
    * @param languageToTest  The language to test, the empty language is a language over every alphabet.
    * @return if all of the strings in the language are strings of this alphabet.
    */
	public boolean languageOver(Language languageToTest)
	{
		//The empty language is a language over every alphabet.
		if (languageToTest.strings().size() == 0) 
			return true;
		
		//Ensure all strings present are strings over this alphabet
		for(String string : languageToTest.strings())
		{
			if (!stringOver(string)) 
				return false;
		}
		
		return true;
	}
	
   /**
    * Method for testing if a symbol is present in this alphabet.
    * @param symbolToTest  The symbol to test
    */
	public boolean includes(Symbol symbolToTest) 
	{
		return symbols.contains(symbolToTest);
	}
	
    public boolean equals(Object o) 
    { 
        if (o == this)
            return true; 

        if (!(o instanceof Alphabet))
            return false;
          
        Alphabet a = (Alphabet) o; 
        
        Set<Symbol> thisval = symbols();
        Set<Symbol> aval = a.symbols();
        
        if (thisval.size() != aval.size())
        	return false;
        
        for(Symbol symbol : thisval) 
        {
        	if (!aval.contains(symbol))
        		return false;
        }
        for(Symbol symbol : aval) 
        {
        	if (!thisval.contains(symbol))
        		return false;
        }
        
        return true;
	}
}
