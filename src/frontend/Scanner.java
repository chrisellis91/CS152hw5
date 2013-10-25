package frontend;

import static frontend.Source.EOF;



import backend.*;
import intermediate.*;
import frontend.*;

public class Scanner
{
	Source source;
	Token token;
	

	public Scanner (Source sourceToUse)
	{
		source=sourceToUse;
	}
	
	
	public Token nextToken()
	{
		
		return token;
	}

}
