package test.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepSelenideTest {
    private static final String REPOSITORY = "VOPdg/MyHomework_6";

    @Test
    @Epic("Курсы по Qa")
    @Owner("Veronika Pdg")
    @DisplayName("Проверка названия Issues в репо/ метод 1")
    @Feature("Проверка названия")
    @Story("Тест с лямбда шагами")
    @Description("Тест проверяет название Issues в репо")
    public void lambdaTestNameCheck() {

        step("Открываем гитхаб", () -> {
            open("https://github.com/");
        });
        step("Ищем репо " + REPOSITORY, () -> {
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репо " + REPOSITORY, () -> {
            $(By.linkText("VOPdg/MyHomework_6")).click();
        });
        step(" Проверяем название Issues в репозитории " + REPOSITORY, () -> {
            $("#issues-tab").shouldHave(text("Issues"));
        });
    }

    @Test
    @Epic("Курсы по Qa")
    @Owner("Veronika Pdg")
    @DisplayName("Проверка названия Issues в репо/метод 2")
    @Feature("Проверка названия")
    @Story("Тест с аннотейдит степами")
     @Description("Тест проверяет название Issues в репо")
    public void annotatedStepsTest() {
        WebStepSelenideTest steps = new WebStepSelenideTest();
        steps.openMainPage();
        steps.searchRepo(REPOSITORY);
        steps.openRepoPage(REPOSITORY);
        steps.checkIssuesName("Issues");

    }
}
