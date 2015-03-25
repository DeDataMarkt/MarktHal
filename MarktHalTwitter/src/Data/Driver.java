package Data;

import java.util.Scanner;

import facebook4j.FacebookException;
import twitter4j.TwitterException;


public class Driver {
	
	private static Scanner user_input;

	public static void main(String[] args) throws TwitterException, FacebookException{
		System.out.println("Type 'help' voor een lijst commands.");
		user_input = new Scanner(System.in);
		choice();
	}
	
	public static void Input() throws TwitterException, FacebookException{
		System.out.println("Type hier:");
		String actualInput = user_input.nextLine();
		
		if(actualInput.equals("help"))
		{
			help();
		} else {if(actualInput.equals("search")){
			System.out.println("Type uw word dat u wilt zoeken");
			String Twittername = user_input.nextLine();
			TwitterApi.timeline(Twittername, 2);
			Input();
		} else {if(actualInput.equals("save")){
			System.out.println("Type uw word dat u wilt zoeken en opslaan.");
			String Twittername = user_input.nextLine();
			TwitterApi.Streaming(Twittername);
			Input();
		}else{if(actualInput.equals("search databases")){
			Base.takeDatabasestw();
			Input();
		}else{if(actualInput.equals("exit")){
			System.out.println("Het programma is afgesloten!");
			System.exit(0);
		}else{if(actualInput.equals("delete twitter")){
			System.out.println("Welke id wilt u verwijderen?");
			String DeleteFake = user_input.nextLine();
			int DeleteID = Integer.parseInt(DeleteFake);
			Base.DeleteTw(DeleteID);
			Input();
		}else{
			System.out.println("Verkeerde Command, type 'help' voor de Commands!");
			//TwitterApi.Streaming();
			//Input();
		}}}}}}

	}
	
	public static void inputfa() throws TwitterException, FacebookException{
		System.out.println("Type hier:");
		String actualInput = user_input.nextLine();
		
		if(actualInput.equals("help"))
		{
			help();
		} else {if(actualInput.equals("search")){
			System.out.println("Type uw word dat u wilt zoeken");
			String Facebookname = user_input.nextLine();
			FacebookApi.postLine(Facebookname, 2);
			inputfa();
		} else {if(actualInput.equals("save")){
			System.out.println("Type uw word dat u wilt zoeken en opslaan.");
			String Facebookname = user_input.nextLine();
			FacebookApi.postLine(Facebookname, 1);
			inputfa();
		}else{if(actualInput.equals("search databases")){
			Base.takeDatabasesfa();
			inputfa();
		}else{if(actualInput.equals("exit")){
			System.out.println("Het programma is afgesloten!");
			System.exit(0);
		}else{if(actualInput.equals("delete")){
			System.out.println("Werkt nog niet!");
			inputfa();
		}else{
			System.out.println("Verkeerde Command, type 'help' voor de Commands!");
			inputfa();
		}}}}}}
		
	}
	
	public static void help()throws TwitterException, FacebookException{
		System.out.println("search - Zoeken");
		System.out.println("save - De resultaten opslaan");
		System.out.println("search databases - Zoeken in de databases");
		System.out.println("exit - Om het programma af te sluiten");

		choice();
	}
	
	public static void choice() throws TwitterException, FacebookException{
	System.out.println("Kies uit 'twitter' of 'facebook'.");
	String choice = user_input.nextLine();
	if(choice.equals("twitter")){
		Input();
		//TwitterApi.getfollowers();
	}else{if(choice.equals("facebook")){
		inputfa();
	}else{
		System.out.println("Verkeerde Command, kies twitter of facebook");
		choice();
	}
	}
	}
	
}
