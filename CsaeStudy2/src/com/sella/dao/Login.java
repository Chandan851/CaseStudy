package com.sella.dao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
public void AnyKeyToContinue(){
	System.out.println("");
	try{
		System.in.read();
	}
	catch(Exception e){
		System.out.println("");

	}
}
public void login(String pass){
	Scanner s=new Scanner(System.in);
	
	if(pass.equals("deccan")){
		System.out.println("login sussesfull");
		AnyKeyToContinue();
	}else
		System.out.println("Access aborted");
	
		
	}
}
