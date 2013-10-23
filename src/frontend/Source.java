package frontend;



import java.io.BufferedReader;
import java.io.IOException;




import backend.*;
import intermediate.*;
import frontend.*;


public class Source 
{

	    public static final char EOL = '\n';             // end-of-line character
	    public static final char EOF = (char) 0;        // end-of-file character

	    private BufferedReader reader;                // reader for the source program
	    private String line;                         // source line
	    private int lineNumber;                     // current source line number
	    private int currentPosition;               // current source line position

	    /**
	     * Constructor.
	     * @param reader the reader for the source program
	     * @throws IOException if an I/O error occurred
	     */
	    public Source(BufferedReader bReader) throws IOException
	    {
	        lineNumber = 0;
	        currentPosition = -2;  // set to -2 to read the first source line
	        reader = bReader;
	    }
	    
	    /**
	     * Getter.
	     * @return the current source line number.
	     */
	    public int getLineNum()
	    {
	        return lineNumber;
	    }

	    /**
	     * Getter.
	     * @return the position of the next source character in the
	     * current source line.
	     */
	    public int getPosition()
	    {
	        return currentPosition;
	    }

	    /**
	     * Return the source character at the current positiion.
	     * @return the source character at the current position.
	     * @throws Exception if an error occurred.
	     */
	    public char currentChar()
	        throws Exception
	    {
	        // First time?
	        if (currentPosition == -2) {
	            readLine();
	            return nextChar();
	        }

	        // At end of file?
	        else if (line == null) {
	            return EOF;
	        }

	        // At end of line?
	        else if ((currentPosition == -1) || (currentPosition == line.length())) {
	            return EOL;
	        }

	        // Need to read the next line?
	        else if (currentPosition > line.length()) {
	            readLine();
	            return nextChar();
	        }

	        // Return the character at the current position.
	        else {
	            return line.charAt(currentPosition);
	        }
	    }

	    /**
	     * Consume the current source character and return the next character.
	     * @return the next source character.
	     * @throws Exception if an error occurred.
	     */
	    public char nextChar() throws Exception
	    {
	        ++currentPosition;
	        return currentChar();
	    }

	    /**
	     * Return the source character following the current character without
	     * consuming the current character.
	     * @return the following character.
	     * @throws Exception if an error occurred.
	     */
	    public char peekChar() throws Exception
	    {
	        currentChar();
	        if (line == null)
	        {
	            return EOF;
	        }

	        int nextPos = currentPosition + 1;
	        return nextPos < line.length() ? line.charAt(nextPos) : EOL;
	    }

	    /**
	     * Read the next source line.
	     * @throws IOException if an I/O error occurred.
	     */
	    private void readLine() throws IOException
	    {
	        line = reader.readLine();  // null when at the end of the source
	        currentPosition = -1;

	        if (line != null) 
	        {
	            ++lineNumber;
	        }
	    }

	    /**
	     * Close the source.
	     * @throws Exception if an error occurred.
	     */
	    public void close() throws Exception
	    {
	        if (reader != null) 
	        {
	            try 
	            {
	                reader.close();
	            }
	            catch (IOException ex) 
	            {
	                ex.printStackTrace();
	                throw ex;
	            }
	        }
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

}
