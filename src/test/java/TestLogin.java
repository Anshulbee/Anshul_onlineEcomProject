import io.restassured.path.json.JsonPath;
import org.example.scr.LoginAPI;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import javax.json.JsonObject;
import java.io.IOException;

public class TestLogin {

    @Test
    public static void loginSuccess() throws IOException {
        LoginAPI login = new LoginAPI();
        System.out.println("TEST:: "+login.getResponse());
        String response = login.getResponse().asString();
        JsonPath jp = new JsonPath(response);
        String token = jp.get("token");
        String user = jp.get("userId");

        System.out.println(token);
        System.out.println(user);
    }
}
