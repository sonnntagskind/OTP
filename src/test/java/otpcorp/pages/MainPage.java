package otpcorp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertNotNull;

public class MainPage extends BasePage {

    public MainPage() {
        super();
    }

    private List<WebElement> webListCurrentAccounts;
    private List<WebElement> webListCardAccounts;
    private List<String> stringListAccounts;
    private String firstPlayer;
    private String lastPlayer;

    public void checkListAccounts() {

        WebElement demoButton = defineElement("ua.com.cs.ifobs.mobile.android.otpcorp:id/demoButton");
        touchElement(demoButton);

        WebElement dialogOk = defineElement("ua.com.cs.ifobs.mobile.android.otpcorp:id/dialogOk");
        touchElement(dialogOk);

        parseAccounts();
        checkNotNull(webListCurrentAccounts, webListCardAccounts);
        while (true) {
            parseAccounts();
            firstPlayer = stringListAccounts.get(0);
            lastPlayer = stringListAccounts.get(stringListAccounts.size() - 1);
            if (!firstPlayer.equals(lastPlayer)) {
                swipe(600, 100);
                parseAccounts();
                checkNotNull(webListCurrentAccounts, webListCardAccounts);
                String newfirstPlayer = stringListAccounts.get(0);
                if (firstPlayer.equals(newfirstPlayer)) {
                    break;
                }
            }
        }
    }

    private void parseAccounts() {
        webListCurrentAccounts = driver.findElements(By.id("ua.com.cs.ifobs.mobile.android.otpcorp:id/accountNoLabel"));
        webListCardAccounts = driver.findElements(By.id("ua.com.cs.ifobs.mobile.android.otpcorp:id/accountNo"));
        stringListAccounts = webListCurrentAccounts.stream().map(e -> e.getText()).collect(Collectors.toList());
        stringListAccounts.addAll(webListCardAccounts.stream().map(e -> e.getText()).collect(Collectors.toList()));
    }

    private void checkNotNull(List<WebElement> webListCurrentAccounts, List<WebElement> webListCardAccounts) {
        webListCurrentAccounts = driver.findElements(By.id("ua.com.cs.ifobs.mobile.android.otpcorp:id/accountNoLabel"));
        webListCardAccounts = driver.findElements(By.id("ua.com.cs.ifobs.mobile.android.otpcorp:id/accountNo"));
        for (WebElement e : webListCurrentAccounts) {
            check(e);
        }
        for (WebElement e : webListCardAccounts) {
            check(e);
        }
    }

    private void check(WebElement webElement) {
        assertNotNull(webElement.getText(), webElement + "yessss");
        System.out.println("checked: " + webElement.getText());
    }
}

