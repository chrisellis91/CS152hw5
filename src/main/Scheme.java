package main;


import java.io.BufferedReader;
import java.io.FileReader;


import frontend.*;
import intermediate.*;
import backend.*;


public class Scheme
{
   static Parser parser;
   static Source source;
   static IntermediateCode iCode;
   static SymbolTable symbolTable;
   static Backend backend;
   
   
   public static void main(String args[]) throws Exception
   {
	   source = new Source(new BufferedReader(new FileReader(args[0])));
	  
	   
	   
	   try
	   {
	   source = new Source(new BufferedReader(new FileReader(args[0])));
	   System.out.println(args[0] + " has been read succesfully");
	   
	   
	   Scanner scanner = new Scanner(source);
	   parser=new Parser(scanner);
	   
	
	   
	   }
	   catch (ArrayIndexOutOfBoundsException iob)
	   {
		   System.err.println("You forgot to include a path to the source file as an arguement");
	   }
	   catch (Exception e)
	   {
		   System.err.println("The source file could not be read at: "+ args[0]);
	   }
	   
	   
	 
	   
	   
	   
	   while (source.peekChar()!=source.EOF )
	   {
		   System.out.print(source.nextChar());
	   }
	   
	   
	   
   }
	
	
	
	
	
	
}
