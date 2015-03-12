package Data;


import facebook4j.FacebookException;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


public class TwitterApi {

	  public static void timeline(String searchword, int ok) throws TwitterException, FacebookException{  
		    Twitter twitter = TwitterFactory.getSingleton();
		    Query query = new Query(searchword);
		    query.setCount(100);
		    QueryResult result = twitter.search(query);
		    for (Status status : result.getTweets()) {
		        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
		        if(ok == 1){
		        String nick = status.getUser().getScreenName();
		        String txt = status.getText();
		        String media = "twitter";
		        Base.saveMedia(media, nick, txt);
		        }
		    }
		    Driver.choice();
	  }
}