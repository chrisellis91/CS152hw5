package frontend;


import java.util.HashSet;


import backend.*;
import intermediate.*;
import frontend.*;

/**
 * This is a class that represents the token type, much of this
 * code was reused from Ronald Mak's 153 class with modifications
 * by team CCT
 */
public class Token
{
	
	
	
	
	/**
	 * Holds all of the reserved words for scheme, as well
	 * as some basic getter methods/set methods
	 */
	public enum TokenType 
	{
		// Special symbols.
	    PLUS("+"), MINUS("-"), STAR("*"), SLASH("/"), COLON_EQUALS(":="),
	    DOT("."), COMMA(","), SEMICOLON(";"), COLON(":"), QUOTE("'"),
	    EQUALS("="), NOT_EQUALS("<>"), LESS_THAN("<"), LESS_EQUALS("<="),
	    GREATER_EQUALS(">="), GREATER_THAN(">"), LEFT_PAREN("("), RIGHT_PAREN(")"),
	    LEFT_BRACKET("["), RIGHT_BRACKET("]"), LEFT_BRACE("{"), RIGHT_BRACE("}"),
	    UP_ARROW("^"), DOT_DOT("..");
	    
	    
	    private static final int FIRST_SYMBOL_INDEX = PLUS.ordinal();  //Start of special symbols
	    private static final int LAST_SYMBOL_INDEX  = DOT_DOT.ordinal(); //End of special symbols
	   
	    private String text;  // token text
	    public static HashSet<String> SPECIAL_SYMBOLS = new HashSet<String>(); //List containing special symbols
	    
	    
	    /**
	     * A constructor that makes a new token with it's text as it's symbol
	     * @param myName the text to be used as a symbol
	     */
	    TokenType(String myName)
	    {
	        this.text = this.toString().toLowerCase();
	    }
	    
	    /**
	     * This is a getter method that returns the text of the token/symbol
	     * @return the text/name/symbol for the token
	     */
	    public String GetText()
	    {
	        return text;
	    }
	    
	    /**
	     * This puts all of the special symbols into their list
	     */
	    static 
	    {
	        TokenType values[] = TokenType.values();
	        for (int i = FIRST_SYMBOL_INDEX; i <= LAST_SYMBOL_INDEX; ++i) 
	        {
	        	SPECIAL_SYMBOLS.add(values[i].GetText().toLowerCase());
	        }
	    }
	        	    
	}
	
	
	    protected TokenType type;  // language-specific token type
	    protected String text;     // token text
	    protected Object value;    // token value
	    protected Source source;   // source
	    protected int lineNum;     // line number of the token's source line
	    protected int position;    // position of the first token character

	    /**
	     * Constructor.
	     * @param source the source from where to fetch the token's characters.
	     * @throws Exception if an error occurred.
	     */
	    public Token(Source source)
	        throws Exception
	    {
	        this.source = source;
	        this.lineNum = source.getLineNum();
	        this.position = source.getPosition();

	        extract();
	    }

	    /**
	     * Getter
	     * @return the token type
	     */
	    public TokenType getType()
	    {
	        return type;
	    }

	    /**
	     * Getter.
	     * @return the token text.
	     */
	    public String getText()
	    {
	        return text;
	    }

	    /**
	     * Getter.
	     * @return the token value.
	     */
	    public Object getValue()
	    {
	        return value;
	    }

	    /**
	     * Getter.
	     * @return the source line number.
	     */
	    public int getLineNumber()
	    {
	        return lineNum;
	    }

	    /**
	     * Getter.
	     * @return the position.
	     */
	    public int getPosition()
	    {
	        return position;
	    }

	    /**
	     * Default method to extract only one-character tokens from the source.
	     * Subclasses can override this method to construct language-specific
	     * tokens.  After extracting the token, the current source line position
	     * will be one beyond the last token character.
	     * @throws Exception if an error occurred.
	     */
	    protected void extract()
	        throws Exception
	    {
	        text = Character.toString(currentChar());
	        value = null;

	        nextChar();  // consume current character
	    }

	    /**
	     * Call the source's currentChar() method.
	     * @return the current character from the source.
	     * @throws Exception if an error occurred.
	     */
	    protected char currentChar()
	        throws Exception
	    {
	        return source.currentChar();
	    }

	    /**
	     * Call the source's nextChar() method.
	     * @return the next character from the source after moving forward.
	     * @throws Exception if an error occurred.
	     */
	    protected char nextChar()
	        throws Exception
	    {
	        return source.nextChar();
	    }

	    /**
	     * Call the source's peekChar() method.
	     * @return the next character from the source without moving forward.
	     * @throws Exception if an error occurred.
	     */
	    protected char peekChar()
	        throws Exception
	    {
	        return source.peekChar();
	    }

	

}
