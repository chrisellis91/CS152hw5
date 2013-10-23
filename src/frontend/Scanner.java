package frontend;

import static frontend.Source.EOF;

import backend.*;
import intermediate.*;
import frontend.*;


public class Scanner 
{

	private Source source;     // source
    private Token currentToken;  // current token
	
	
    
    
    public Scanner(Source bSource)
    {
        source = bSource;
    }
    
    
    
    public char currentChar() throws Exception
    {
       return source.currentChar();
    }
    
    
    
	public Token nextToken() throws Exception
	{
	    currentToken = extractToken();
	    return currentToken;
	}
	
	
	
	
	 private Token extractToken() throws Exception
	 {
		  Token token;
		  char currentChar = currentChar();

	      // Construct the next token.  The current character determines the
		  // token type.
		  if (currentChar == Source.EOF) 
		  {
		  // token = new EofToken(source);
		  }
		  else 
		  {
	      //token = new Token(source);
		  }

		  token=null;
		  return token;
	 }
	
	
	
	
}
