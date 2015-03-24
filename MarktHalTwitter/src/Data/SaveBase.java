package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class SaveBase {
	static boolean go = true;
	
	public static void saveMedia(String media, String Name, String Text, int retweet, String place, long twitid){
		   try
		    {

			   
		      // create a mysql database connection
			   
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://localhost/marktmedia";
		      

		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
		     
		      // create a sql date object so we can use it in our INSERT statement
		      Calendar calendar = Calendar.getInstance();
		      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		      String NoName = searchbase.searchName(Name);
		      if(Name != NoName){
		    	  System.out.println(NoName);
		      // the mysql insert statement
		      String query = " insert into user (iduser, username, twitter, gender, age, FK_country)"
		        + " values (?, ?, ?, ?, ?, ?)";
		 
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, Name);
		      preparedStmt.setString (2, Name);
		      if(media == "twitter"){
		      preparedStmt.setBoolean (3, true);
		      }else{
		      preparedStmt.setBoolean (3, false);
		      }
		      preparedStmt.setString (4, "m");
		      preparedStmt.setInt (5, 18);
		      preparedStmt.setString (6, place);
		 
		      // execute the preparedstatement
		      preparedStmt.execute();
		      }
		      
		      if(go == true){
		      // the mysql insert statement
		      String query = " insert into user_comment (comment, retweet, positive, FK_iduser, FK_iddate)"
		        + " values (?, ?, ?, ?, ?)";
		 
		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		      preparedStmt.setString (1, Text);
		      preparedStmt.setInt (2, retweet);
		      preparedStmt.setBoolean (3, false);
		      preparedStmt.setString (4, Name);
		      preparedStmt.setInt (5, 240315);
		 
		      // execute the preparedstatement
		      preparedStmt.execute();
		      }
		      
		      conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		    }
		   
		}
	
	public static void saveFollowers(int Followers){
		
		   try
		    {

			   
		      // create a mysql database connection
			   
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://localhost/marktmedia";
		      

		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
		     
		      // create a sql date object so we can use it in our INSERT statement
		      Calendar calendar = Calendar.getInstance();
		      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		      
		      if(go == true){
			      // the mysql insert statement
			      String query = " insert into followers (followerstotaal, twitter)"
			        + " values (?, ?)";
			 
			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setInt (1, Followers);
			      preparedStmt.setBoolean (2, true);

			      // execute the preparedstatement
			      preparedStmt.execute();
			      }
		      
		      if(go == true){
			      // the mysql insert statement
			      String query = " insert into followers_datetoday (FK_idfollowers, FK_iddate)"
			        + " values (?, ?)";
			 
			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setInt (1, 1);
			      preparedStmt.setInt (2, 240315);
			 
			      // execute the preparedstatement
			      preparedStmt.execute();
			      }
		      
		      conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		    }
		
	}
	
}
