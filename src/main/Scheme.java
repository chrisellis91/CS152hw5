package main;


import java.io.BufferedReader;
import java.io.FileReader;

import frontend.*;
import intermediate.*;
import backend.*;


public class Scheme
{
   Parser parser;
  // Scanner scanner;
   static Source source;
   IntermediateCode iCode;
   SymbolTable symbolTable;
   Backend backend;
   
   
   public static void main(String args[]) throws Exception
   {
	   try
	   {
	   source = new Source(new BufferedReader(new FileReader(args[0])));
	   System.out.println(args[0] + " has been read succesfully");
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
