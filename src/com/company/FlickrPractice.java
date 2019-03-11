package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FlickrPractice {
    static String key = "a42638a45cccd2bdee90c1f631cd7ba6";

    private void getFlickrPhotos(){
        try {
            URL url = new URL("https://api.flickr.com/services/rest/?method=flickr.galleries.getPhotos&api_key="+key+"&gallery_id=66911286-72157647277042064&format=json&nojsoncallback=1");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK){
                return;
            }

            InputStream i = httpURLConnection.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(i, "UTF-8"));

            int code = 0;
            while ((code = bufferedReader.read()) != -1){
                System.out.print((char) code);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
