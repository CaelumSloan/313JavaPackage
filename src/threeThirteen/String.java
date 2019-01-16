package threeThirteen;

import java.util.*;

/** Finite sequence of symbols from some alphabet.
 * @author Caelum Sloan
 * @version 1.0
*/
public class String 
{
	//Properties
	private List<Symbol> value = new ArrayList<Symbol>();
	
	//Constructors
	public String() {}
	
	public String(List<Symbol> value) 
	{
		this.value = value;
	}
	public String(Symbol... symbols) 
	{
	    for (Symbol s : symbols) 
	      value.add(s);
	}

	//Getter Setters
	public List<Symbol> value() 
	{
		ArrayList<Symbol> copy = new ArrayList<>();
		for(Symbol s : value) 
		{
			copy.add(s);
		}
		return copy;
	}
	
	//Functions
   /**
    * Method for testing if a symbol is present in this string.
    * @param symbolToTest  The symbol to test
    */
	public boolean includes(Symbol symbolToTest) 
	{
		return value().contains(symbolToTest);
	}
	
   /**
    * The number of symbols in this string.
    * @return a number bigger than or equal to zero.
    */
	public int length() 
	{
		return value().size();
	}
	
    @Override
    public boolean equals(Object o) 
    { 
        if (o == this)
            return true; 

        if (!(o instanceof String))
            return false;
          
        String s = (String) o; 
        
        List<Symbol> thisval = value();
        List<Symbol> sval = s.value();
        
        if (thisval.size() != sval.size())
        	return false;
        
		for(int i = 0; i < thisval.size(); i++)
		{
			if (!thisval.get(i).equals(sval.get(i)))
					return false;
		}
        
        return true;
	} 
}
