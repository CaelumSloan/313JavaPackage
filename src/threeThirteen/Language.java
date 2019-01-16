package threeThirteen;

import java.util.*;

/** A set of strings over some Alphabet.
 * @author Caelum Sloan
 * @version 1.0
*/
public class Language 
{
		//Properties
		private Set<String> strings = new HashSet<String>();
		
		//Constructors
		public Language() {}
		
		public Language(Set<String> strings) 
		{
			this.strings = strings;
		}
		
		public Language(String... strings) 
		{
		    for (String s : strings) 
		    	this.strings.add(s);
		}

		//Getter Setters
		public Set<String> strings() 
		{
			return strings;
		}
		
		//Functions
	   /**
	    * Method for testing if a string is present in this language.
	    * @param stringToTest  The string to test
	    */
		public boolean includes(String stringToTest) 
		{
			return strings.contains(stringToTest);
		}
		
	    public boolean equals(Object o) 
	    { 
	        if (o == this)
	            return true; 

	        if (!(o instanceof Language))
	            return false;
	          
	        Language a = (Language) o; 
	        
	        Set<String> thisval = strings();
	        Set<String> aval = a.strings();
	        
	        if (thisval.size() != aval.size())
	        	return false;
	        
	        for(String string : thisval) 
	        {
	        	if (!aval.contains(string))
	        		return false;
	        }
	        for(String string : aval) 
	        {
	        	if (!thisval.contains(string))
	        		return false;
	        }
	        
	        return true;
		}
}
