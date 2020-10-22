package otpcorp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountPage extends BasePage {

    public AccountPage() {
        super();
    }

    public void checkAccount() {

        WebElement accountNoLabel = defineElement("ua.com.cs.ifobs.mobile.android.otpcorp:id/accountNoLabel");
        touchElement(accountNoLabel);

        WebElement changeName = defineElement("ua.com.cs.ifobs.mobile.android.otpcorp:id/account_detail_change_name");
        touchElement(changeName);

        WebElement inputDialogText = defineElement("ua.com.cs.ifobs.mobile.android.otpcorp:id/inputDialogText");
        inputDialogText.click();
        inputDialogText.sendKeys("test");

        WebElement dialogOk = defineElement("ua.com.cs.ifobs.mobile.android.otpcorp:id/dialogOk");
        touchElement(dialogOk);

        WebElement dialogText = defineElement("ua.com.cs.ifobs.mobile.android.otpcorp:id/dialogText");
        assertThat(dialogText.getText()).as("not right").isEqualTo("The application is running in the demo mode. Functionality is limited.");
        touchElement(dialogOk);

        List<WebElement> captionLabels = driver.findElements(By.id("ua.com.cs.ifobs.mobile.android.otpcorp:id/captionLabel"));

        while (!captionLabels.stream().map(e -> e.getText()).collect(Collectors.toList()).contains("Account details")) {
            swipe(900, 100);
            captionLabels = driver.findElements(By.id("ua.com.cs.ifobs.mobile.android.otpcorp:id/captionLabel"));
        }

        captionLabels = driver.findElements(By.id("ua.com.cs.ifobs.mobile.android.otpcorp:id/captionLabel"));
        List<WebElement> valueLabels = driver.findElements(By.id("ua.com.cs.ifobs.mobile.android.otpcorp:id/valueLabel"));

        for (int i = 0; i < captionLabels.size(); i++) {
            if (captionLabels.get(i).getText().equals("Account details")) {
                assertThat(valueLabels.get(i + 1).getText()).as("Wrong accountDetails text").contains("Payment account");
            }
        }
    }
}


