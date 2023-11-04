# Project: WeatherApi
This is a simple application for retrieving weather information based on a city name using the OpenWeatherMap API.
## How the Task Was Solved
The task of this project was to create a program that can fetch and display weather data for a specified city. Here's how the task was solved:
1. **Obtaining an API Key**: First, you need to obtain an API key from OpenWeatherMap. This key is used to make API requests and access weather data.
2. **User Input Handling**: The program uses a `Scanner` to collect the name of the city from the user. To improve user input handling, we added a check to ensure the input is not empty and to trim any leading or trailing whitespace.
3. **Making API Requests**: The program constructs a URL for the OpenWeatherMap API by encoding the city name and appending the API key. It then makes a GET request to the API using `HttpURLConnection`.
4. **Processing JSON Response**: After receiving the JSON response from the API, the program uses the `org.json` library to parse and extract the weather data, including temperature and description.
5. **Displaying Weather Information**: Finally, the program displays the temperature in Celsius and a description of the weather for the specified city.
## Main Methods
- `main(String[] args)`: The main method of the project. It runs the application, collects user input, and retrieves and displays weather data.
## Used Libraries
- `org.json.JSONObject`: Used for parsing and extracting information from the JSON response obtained from the OpenWeatherMap API.
## Important Variables
- `apiKey`: Your OpenWeatherMap API key, required for making API requests.
## Instance Usage
1. Run the application.
2. Enter the name of a city (e.g., "London") and press "Enter."
3. The application will fetch and display the current weather information for the specified city, including the temperature and weather description.
