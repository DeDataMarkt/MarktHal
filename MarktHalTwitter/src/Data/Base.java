package Data;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class Base {
	public static void saveMedia(String media, String Name, String Text){
	   try
	    {

		   
	      // create a mysql database connection
		   
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/twitteruse";
	      

	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
	     
	      // create a sql date object so we can use it in our INSERT statement
	      Calendar calendar = Calendar.getInstance();
	      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	 
	      // the mysql insert statement
	      if(media.equals("twitter")){
	      String query = " insert into record (user, text)"
	        + " values (?, ?)";
	 
	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, Name);
	      preparedStmt.setString (2, Text);

	 
	      // execute the preparedstatement
	      preparedStmt.execute();
	      }
	      
	      if(media.equals("facebook")){
	      String query = " insert into facebook (fauser, fatext)"
	        + " values (?, ?)";
	 
	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, Name);
	      preparedStmt.setString (2, Text);

	 
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
	

	
	public static void takeDatabasestw(){
		
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/twitteruse";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
	       
	      // our SQL SELECT query.
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM record";
	 
	      // create the java statement
	      Statement st = conn.createStatement();
	       
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	       
	      // iterate through the java resultset
	      while (rs.next())
	      {
	        int idrec = rs.getInt("idrec");
	        String user = rs.getString("user");
	        String text = rs.getString("text");

	         
	        // print the results
	        System.out.format("%s, %s, %s,\n", idrec, "@" + user + ":", text);
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }	
	}
	
	public static void takeDatabasesfa(){
		
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/twitteruse";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
	       
	      // our SQL SELECT query.
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM facebook";
	 
	      // create the java statement
	      Statement st = conn.createStatement();
	       
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	       
	      // iterate through the java resultset
	      while (rs.next())
	      {
	        int idrec = rs.getInt("idface");
	        String user = rs.getString("fauser");
	        String text = rs.getString("fatext");

	         
	        // print the results
	        System.out.format("%s, %s, %s,\n", idrec, "@" + user + ":", text);
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }	
	}
	
	public static void DeleteTw(int DeleteID){
		
	    try
	    {
	      // create the mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost/twitteruse";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
	       
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "delete from record where idrec = ?";
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      if(DeleteID >= 1){
	      preparedStmt.setInt(1, DeleteID);
	      }
	 
	      // execute the preparedstatement
	      preparedStmt.execute();
	       
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	 
		
		
	}
}

