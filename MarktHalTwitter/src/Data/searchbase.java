package Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


public class searchbase {

public static String find(String search){
	ArrayList<String> Name = new ArrayList<String>();
	String Noname = "";
    try
    {
      // create our mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/MarktMedia";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "1234");
       
      // our SQL SELECT query.
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM user";
 
      // create the java statement
      Statement st = conn.createStatement();
       
      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);
       
      // iterate through the java resultset
      while (rs.next())
      {
        String idrec = rs.getString("iduser");
        Name.add(idrec);

         
        // print the results
        
      }
      st.close();
      }
    catch (Exception e){
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
    
	for(int i = 0; i < Name.size(); i++){
		if(Name.get(i).equals(search)){
			Noname = search;
			//System.out.println(Noname);
		}
	}
	return Noname;
}
}