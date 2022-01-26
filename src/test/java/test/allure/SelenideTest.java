package test.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    @Epic("Курсы по Qa")
    @Owner("Veronika Pdg")
    @DisplayName("Проверка названия Issues в репо")
    @Feature("Проверка названия")
    @Story("Тест со слушателями")
    @Description("Тест проверяет название Issues в репо")
public void testNameCheck(){
        SelenideLogger.addListener("allure", new AllureSelenide()); //подключает слушателей
        open("https://github.com/");
        $(".header-search-input").sendKeys("VOPdg/MyHomework_6");
        $(".header-search-input").submit();
        $(By.linkText("VOPdg/MyHomework_6")).click();
        $("#issues-tab").shouldHave(text("Issues"));
    }
}
