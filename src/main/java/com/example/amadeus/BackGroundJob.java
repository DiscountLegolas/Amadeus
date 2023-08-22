package com.example.amadeus;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

@Component
public class BackGroundJob {
    @Scheduled(cron = "0 0 0 ? * *")
    public void apirequest() throws IOException, ParseException {
        Request request = new Request
                .Builder()
                .url("https://swapi.dev/api/people/")
                .get()
                .build();

        OkHttpClient httpClient = new OkHttpClient();
        Response response = httpClient.newCall(request).execute();
        String jsonString = response.body().string(); //assign your JSON String here
        JSONParser parser=new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");
        Random rand = new Random();
        var a= (String)jsonArray.get(rand.nextInt(jsonArray.size()));
        System.out.println(a);

    }
}
