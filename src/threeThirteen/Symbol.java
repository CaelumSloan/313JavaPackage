package threeThirteen;

/** Finite sequence of symbols from some alphabet.
 * @author Caelum Sloan
 * @version 1.0
*/
public class Symbol
{
	//Properties
	private java.lang.String value;
	
	//Constructors
	public Symbol(java.lang.String value) 
	{
		this.value = value;
	}

	//Getter Setters
	public java.lang.String value() 
	{
		return value;
	}
	
    @Override
    public boolean equals(Object o) 
    { 
        if (o == this)
            return true; 

        if (!(o instanceof Symbol))
            return false;
          
        Symbol s = (Symbol) o; 
          
        // Compare the data members and return accordingly  
        return value.equals(s.value());
	} 
}
