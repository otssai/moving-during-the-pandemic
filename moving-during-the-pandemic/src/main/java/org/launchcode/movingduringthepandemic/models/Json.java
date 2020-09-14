package org.launchcode.movingduringthepandemic.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Json {

    private static HttpURLConnection connection;
    private static BufferedReader reader;
    private static String line;
    private static StringBuffer responseContent = new StringBuffer();

    public Json() {
    }

    public static JSONArray getResponseContent() throws JSONException {

        try {
            URL url = new URL("https://api.covidtracking.com/v1/states/current.json");
            connection = (HttpURLConnection) url.openConnection();

            // request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
//            System.out.println(status);

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
//                System.out.println(responseContent.toString());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        JSONArray data = new JSONArray(responseContent.toString());
//        System.out.println(data);
        return data;
    }
}