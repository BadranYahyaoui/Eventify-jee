package tn.esprit.twin1.brogrammers.eventify.Eventify.util;


import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CognitiveServiceTextAnalytics {
	
	public static String GetSentimentAnalytics() {
		HttpClient httpclient = HttpClients.createDefault();

        try
        {
            URIBuilder builder = new URIBuilder("https://westus.api.cognitive.microsoft.com/text/analytics/v2.0/sentiment");

            //builder.setParameter("numberOfLanguagesToDetect", "1");

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", "application/json");
			request.setHeader("Ocp-Apim-Subscription-Key", "eba8e6cfda0f4b3e98bb85debb8072c9");

			// Request body
			StringEntity reqEntity = new StringEntity("{'documents':[{'language':'en','id':'1','text':'It was a terrible night'}]}");
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            
            if (entity != null) 
            {
                //System.out.println(EntityUtils.toString(entity));
                return EntityUtils.toString(entity);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() + "hereeeeeee ");
            return null;

        }
        return null;
	}
}