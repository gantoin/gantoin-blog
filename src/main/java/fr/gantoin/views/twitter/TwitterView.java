package fr.gantoin.views.twitter;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.vaadin.addon.twitter.Tweet;

import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsBearer;
import com.twitter.clientlib.api.TwitterApi;
import com.twitter.clientlib.model.Get2UsersIdTweetsResponse;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import fr.gantoin.views.MainLayout;

@PageTitle("Twitter")
@Route(value = "twitter", layout = MainLayout.class)
public class TwitterView extends HorizontalLayout {
    public TwitterView(@Autowired Environment env) throws ApiException {
        TwitterApi apiInstance = new TwitterApi(new TwitterCredentialsBearer(env.getProperty("TWITTER_BEARER_TOKEN")));
        String authorId = "1450558865972633608"; // my twitter id
        Get2UsersIdTweetsResponse gant0in = apiInstance.tweets().usersIdTweets(authorId).execute();
        Objects.requireNonNull(gant0in.getData()).forEach(tweet -> {
            Tweet tweetCard = new Tweet(tweet.getId());
            tweetCard.setSizeFull();
            add(tweetCard);
        });
    }
}
