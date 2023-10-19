package Utilities;

import com.github.javafaker.Faker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class Utilities {

    //public String LastName = faker.name().lastName();
    public String LastName = "Nihal";
    public String EMAIL = LastName + "@test.com";
    //public Password pass = Password.createPassword(PasswordType.ALL);
    //public String PASSWORD = pass.generate();
    public String PASSWORD = "a";
    //Random variables generating with Faker API
    Faker faker = new Faker();
    public String FirstName = faker.name().firstName();
    public String CompanyName = faker.company().name();
    public String Address = faker.address().fullAddress();
    public String State = faker.address().stateAbbr();
    public String Zip = faker.address().zipCodeByState(State);
    public String City = faker.address().cityName();
    public String MobileNumber = faker.phoneNumber().cellPhone();

    @DataProvider(name = "users")
    public String[] readJson() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".\\resources\\userCredentials.json");

        Object obj = jsonParser.parse(reader);
        JSONObject credentialsJsonObj = (JSONObject) obj;
        JSONArray credentialsJsonArray = (JSONArray) credentialsJsonObj.get("userlogins");

        String[] arr = new String[credentialsJsonArray.size()];
        for (int i = 0; i < credentialsJsonArray.size(); i++) {

            JSONObject users = (JSONObject) credentialsJsonArray.get(i);

            String userName = (String) users.get("name");
            String userEmail = (String) users.get("email");
            String userPassword = (String) users.get("password");

            arr[i] = userName + "," + userEmail + "," + userPassword;

        }
        return arr;

    }
}
