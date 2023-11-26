import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class UI {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "firefox";
        Configuration.baseUrl = System.getProperty("base");
        Configuration.remote = System.getProperty("selenoid");
//        Configuration.baseUrl = "https://the-internet.herokuapp.com";
//        Configuration.remote = "http://95.216.214.178:8080/wd/hub";
    }

    @Test
    public void testLogin() {
        open("/login");
        SelenideElement usernameField = $("#username");
        SelenideElement passwordField = $("#password");
        SelenideElement loginButton = $("[type=\"submit\"]");

        usernameField.setValue("tomsmith");
        sleep(10000);
        passwordField.setValue("SuperSecretPassword!");
        loginButton.click();
        $("#flash").shouldBe(Condition.visible);
    }

    @Test
    public void testChecker() {
        open("/checkboxes");
        $("[type=\"checkbox\"]").click();
        sleep(10000);
        $x("//*[@type=\"checkbox\"][1]").shouldBe(Condition.checked);
        System.out.println("CHECKED WELL, SUCCESS!");
    }
}
