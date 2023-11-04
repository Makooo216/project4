package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class WeatherApi {
    public static void main(String[] args) {
        String apiKey = "96d8b8e2a97c2c685f1408383700a3ae";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of city: ");
        String city = scanner.nextLine();
        try {
            String encodedCity = URLEncoder.encode(city, StandardCharsets.UTF_8.toString());
            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + encodedCity + "&appid=" + apiKey;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();
            String jsonResponse = response.toString();
            System.out.println(jsonResponse);
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONObject main = jsonObject.getJSONObject("main");
            double temperatureKelvin = main.getDouble("temp");
            double temperatureCelsius = temperatureKelvin - 273.15;
            String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
            System.out.println("Temperature: " + temperatureCelsius + "°C");
            System.out.println("Description: " + description);
            System.out.println("Thank u!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


