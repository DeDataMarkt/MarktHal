package Data;

import twitter4j.TwitterException;
import facebook4j.Account;
import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;

public class FacebookApi {
	
	static int x = 0;
	
	public static void postLine(String what, int follow) throws FacebookException, TwitterException{
	Facebook facebook = new FacebookFactory().getInstance();
	
    ResponseList<Post> feeds = facebook.getFeed(what,
            new Reading().limit(25));

        // For all 25 feeds...
        for (int i = 0; i < feeds.size(); i++) {
        	x = x+1;
            // Get post.
            Post post = feeds.get(i);
            // Get (string) message.
            String message = post.getMessage();
                            // Print out the message.
            String name = post.getFrom().getName();
            System.out.println(x + " " + name + "&&" + message);

            if(follow == 1){
	        String nick = name;
	        String txt = message;
	        String media = "facebook";
	        Base.saveMedia(media, nick, txt);
            }
        	}
	    Driver.choice();

}
}