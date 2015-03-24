package Data;


import facebook4j.FacebookException;
import twitter4j.FilterQuery;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;


public class TwitterApi {

	  public static void timeline(String searchword, int ok) throws TwitterException, FacebookException{  
		    Twitter twitter = TwitterFactory.getSingleton();
		    Query query = new Query(searchword);
		   // query.setCount(99);
		    QueryResult result = twitter.search(query);
		    for (Status status : result.getTweets()) {
		    	String place = "niks";
		    	Long twitid = status.getUser().getId();
		    	if(status.getUser().getLang() != null || status.getUser().getLang() != "" || status.getUser().getLang() != " "){
		    		place = status.getUser().getLang();
		    	}
		    	int retweet = status.getRetweetCount();
		        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText() + " Land: " + place + " Retweet: " + retweet + " ID: " + twitid);
		        String nick = status.getUser().getScreenName();
		        String txt = status.getText();
		        String media = "twitter";
		        if(ok == 1){
		        SaveBase.saveMedia(media, nick, txt, retweet, place, twitid);
		        }
		    }    
	  }
	  
	  public static void getfollowers() throws TwitterException, FacebookException{  
		    Twitter twitter = TwitterFactory.getSingleton();
		    Query query = new Query("from:markthalrdam");
		    query.setCount(1);
		    QueryResult result = twitter.search(query);
		    for (Status status : result.getTweets()) {
		    	int Followers = status.getUser().getFollowersCount();
		    	 System.out.println("Aantal followers: " + Followers);
		    	 SaveBase.saveFollowers(Followers);
		    }
	  }
	  
/*	    public static void Streaming() throws TwitterException, FacebookException{
	    	

	        ConfigurationBuilder cb = new ConfigurationBuilder();
	        cb.setDebugEnabled(true);
	        cb.setOAuthConsumerKey("TMoLusb1KCZ2KNWHREQj1dN7s");
	        cb.setOAuthConsumerSecret("nVbHmDf1T1u7T8Wh8XVhffnlA8CbS4zsh8pa02qjHcHv3fLO4W");
	        cb.setOAuthAccessToken("356841347-O1uAf3mdaNQtTXbXDFecnERdoAtvZhXdbpUw5IRc");
	        cb.setOAuthAccessTokenSecret("9YHVKXTAoFjVS5vMfX4ZvlRUoVTDFgP7neDklWSTTNZ9e");

	    	
	        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
	        
	        StatusListener listener = new StatusListener() {
	            @Override
	            public void onStatus(Status status) {
	                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
	            }

	            @Override
	            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
	                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
	            }

	            @Override
	            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
	                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
	            }

	            @Override
	            public void onScrubGeo(long userId, long upToStatusId) {
	                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
	            }

	            @Override
	            public void onStallWarning(StallWarning warning) {
	                System.out.println("Got stall warning:" + warning);
	            }

	            @Override
	            public void onException(Exception ex) {
	                ex.printStackTrace();
	            }
	        };

	        FilterQuery fq = new FilterQuery();

	        String keywords[] = {"Ajax"};

	        fq.track(keywords);

	        twitterStream.addListener(listener);
	        twitterStream.filter(fq);
	    } */

	    	
	    }
	  