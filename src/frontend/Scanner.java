package frontend;

import static frontend.Source.EOF;



import backend.*;
import intermediate.*;
import frontend.*;

public class Scanner {

	private Source source; // source
	private Token currentToken; // current token

	/**
	 * This is the constructor for the scanner
	 * 
	 * @param bSource
	 *            the source to use
	 */
	public Scanner(Source bSource) {
		source = bSource;
	}

	/**
	 * This returns the current character that the scanner is on (through use of
	 * the source class's method)
	 * 
	 * @return the current character the scanner is on
	 * @throws Exception
	 */
	public char currentChar() throws Exception {
		return source.currentChar();
	}

	/**
	 * This gets the next token from the parser
	 * 
	 * @return the next token in the sequence/file
	 * @throws Exception
	 */
	public Token nextToken() throws Exception {
		currentToken = extractToken();
		return currentToken;
	}

	/**
	 * This extracts the token from parser
	 * 
	 * @return the constructed token
	 * @throws Exception
	 */
	protected Token extractToken() throws Exception {
		skipWhiteSpace();

		Token token;
		char currentChar = currentChar();

		// Construct the next token. The current character determines the
		// token type.
		if (currentChar == EOF) 
		{
			token = new EofToken(source);
		} 
		else if (Character.isLetter(currentChar)) 
		{
			token = new PascalWordToken(source);
		} 
		else if (Character.isDigit(currentChar)) 
		{
			token = new PascalNumberToken(source);
		} 
		else if (currentChar == '\'') 
		{
			token = new PascalStringToken(source);
		} 
		else if (PascalTokenType.SPECIAL_SYMBOLS.containsKey(Character.toString(currentChar))) 
		{
			token = new PascalSpecialSymbolToken(source);
		}
		else 
		{
			token = new PascalErrorToken(source, INVALID_CHARACTER, Character.toString(currentChar));
			nextChar(); // consume character
		}

		return token;
	}

	/**
	 * Skip whitespace characters by consuming them. A comment is whitespace.
	 * 
	 * @throws Exception
	 *             if an error occurred.
	 */
	private void skipWhiteSpace() throws Exception {
		char currentChar = currentChar();

		while (Character.isWhitespace(currentChar) || (currentChar == '{')) {

			// Start of a comment?
			if (currentChar == '{') {
				do {
					currentChar = nextChar(); // consume comment characters
				} while ((currentChar != '}') && (currentChar != EOF));

				// Found closing '}'?
				if (currentChar == '}') {
					currentChar = nextChar(); // consume the '}'
				}
			}

			// Not a comment.
			else {
				currentChar = nextChar(); // consume whitespace character
			}
		}
	}

}
