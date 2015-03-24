package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class searchbase {
	static String NoName;
	public static String searchName(String Search){
			
		    try
		    {
		      // create our mysql database connection
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://localhost/MarktMedia";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
		       
		      // our SQL SELECT query.
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT iduser FROM user";
		 
		      // create the java statement
		      Statement st = conn.createStatement();
		       
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		       
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        String idrec = rs.getString("iduser");
		        if(idrec == Search){
		        	NoName = idrec;
		        	System.out.println(NoName);
		        	break;
		        	
		        }
		      }
		      st.close();

		      
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }	
		    return NoName;
	}
}
