package com.tactfactory.appconception.server.controler;

public class UserControler {

	public UserControler(){
	}
	
	private void command1(String action){
		System.out.println(action);
	}
	
	private void command2(String action){
		System.out.println(action);
	}

	public String Action(String action) {
		String response = "test";
		
		switch (action) {
		case "command1":
			this.command1("action1");
			break;
		case "command2":
			this.command2("action2");
			break;
		default:
			break;
		}
		
		return response;
	}
}
