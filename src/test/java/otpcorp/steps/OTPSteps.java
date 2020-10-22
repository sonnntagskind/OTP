package otpcorp.steps;

import otpcorp.pages.AccountPage;
import otpcorp.pages.MainPage;

public class OTPSteps {
    private MainPage mainPage = new MainPage();
    private AccountPage accountPage = new AccountPage();

    public OTPSteps checkListAccounts() {
        mainPage.checkListAccounts();
        return this;
    }

    public OTPSteps checkAccount() {
        accountPage.checkAccount();
        return this;
    }
}
