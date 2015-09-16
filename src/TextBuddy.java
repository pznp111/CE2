/*CS2103T CE1 TextBuddy 
 * Lin Xinlin
 * A0108355H
 * 
 * file will be saved to disk after each exit operation
 * 
 * program will catch a few errors including:
 * 1. invalid commands
 * 2. file name not specified
 * 3. wrong format of commands such as not a number after the "delete" commands
 * 4. trying to delete a item that has not been created yet
 * 
 * here is the default input:
   add little brown fox
   display
   add jumped over the moon
   display
   delete 2
   display
   clear
   display
   exit
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TextBuddy {
	static String inputfile;
	private static ArrayList<String> list = new ArrayList<String>();
	private static Scanner sc = new Scanner(System.in);
	private static final String ERROR_FILE_NAME_NOT_SPECIFIED = "Error, file name not specified";
	private static final String ADD_MESSAGE = "added to %s: \"%s\"";
	private static final String DELETE_MESSAGE = "deleted from %s: \"%s\"";
	private static final String CLEAR_MESSAGE = "all content deleted from %s";
	private static final String EMPTY_MESSAGE = "%s is empty";
	private static final String WELCOME_MESSAGE = "Welcome to TextBuddy. %s is ready for use";
	private static final String FORMAT_ERROR = "Invalid Command Format ";
	private static final String DELETE_ERROR_MESSAGE = "The item you are trying to delete does not exist";
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		loadinput(args);
	
	}
	
	private static void executeKeyinOrder() throws IOException{
		showToUser(String.format(WELCOME_MESSAGE, inputfile));
		while(true) {
			System.out.print("command: ");
			String userCommand = sc.nextLine();
			showToUser(userCommand);
			String feedback = executeCommand(userCommand);
			showToUser(feedback);
		}
		
		
	}
	
	/*
	 * ====================================================================
	 * this function try to load input from a file first, if user does not load
	 * input from a file, it will proceed to normal input panel 
	 * ====================================================================
	 */
	private static void loadinput(String[] args) throws IOException {
		
		if(args.length == 0){
			
			showToUser(ERROR_FILE_NAME_NOT_SPECIFIED);
			System.exit(0);
			
		}else{
			
			inputfile = args[0];
			executeKeyinOrder();
			
		}
	}
	

	private static void showToUser(String text) {
		System.out.println(text);
	}

	/*
	 * ====================================================================
	 * this function execute the commands  
	 * ====================================================================
	 */
	private static String executeCommand(String userCommand) throws IOException {
		String command=getCommand(userCommand);
		String info=getInfo(userCommand);
		
		if(command.equals("add")){
			
			return executeAdd(info);
			
		}else if(command.equals("display")){
			
			 executeDisplay(info);
			
		}else if(command.equals("delete")){
			
			return executeDelete(info);
			
		}else if(command.equals("clear")){
			
			return executeClear();
			
		}else if(command.equals("exit")){
			
			executeExit();
			
		}
		else{
			
			return(FORMAT_ERROR);
			
		}
		
		return "";
	}

	

	private static void executeExit() throws IOException  {
	
		
		    PrintWriter writer = new PrintWriter(inputfile, "UTF-8");
		    for(int i=0; i<list.size(); i++ ){
		    	
		    	writer.write(list.get(i));
		    	writer.write(System.getProperty("line.separator"));
		    	
		    }
		    
			writer.close();		
		    System.exit(0);
	}

	static String executeClear() {
		
		list.clear();
		return String.format(CLEAR_MESSAGE, inputfile);
		
	}

	static String executeDelete(String info)  {
		
		String returnInfo="";
		
		if(isNumeric(info)){
			
			int num=Integer.parseInt(info);
			if(num>list.size()){
				
			returnInfo=DELETE_ERROR_MESSAGE;
				
			}else{
			
			list.remove(num-1);
			returnInfo = String.format(DELETE_MESSAGE, inputfile,info);
			
			}
			
		}else{
			
			returnInfo = FORMAT_ERROR;
			
		}
		
		return returnInfo;
		
	}

	static String executeAdd(String info) {

		
		list.add(info);
		String returnInfo=String.format(ADD_MESSAGE, inputfile,info);
		return returnInfo;
		
	}

	static boolean executeDisplay(String info) {

		boolean valid = false;
		if(list.size()==0){
			
			showToUser(String.format(EMPTY_MESSAGE, inputfile));
			
		}
		
		for(int i=0; i < list.size(); i++){
			
			showToUser(i+1 + ". "+list.get(i));
			
		}
		
		return valid;
			
	}

	/*
	 * ====================================================================
	 * this function is able to get the first word from a String 
	 * ====================================================================
	 */
	private static String getCommand(String userCommand) {

		String arr[] = userCommand.split(" ");
		return arr[0];
		
	}
	
	/*
	 * ====================================================================
	 * this function remove the first word from a String
	 * ====================================================================
	 */
	private static String getInfo(String userCommand) {

		int i=userCommand.indexOf(" ");
		String info=userCommand.substring(i+1,userCommand.length());
		return info;
		
	}

	
	/*
	 * ====================================================================
	 * to check whether a string is a number or not 
	 * ====================================================================
	 */
	private static boolean isNumeric(String str) {  
		
	  try {  
		  
	    double d = Double.parseDouble(str);  
	    
	  }  
	  catch(NumberFormatException nfe) {  
		  
	    return false;  
	    
	  }  
	  return true;  
	}
	
	
}