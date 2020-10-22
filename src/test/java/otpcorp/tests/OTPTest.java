package otpcorp.tests;

import org.testng.annotations.Test;

public class OTPTest extends BaseTest {

    @Test
    public void start() {

        otpSteps
                .checkListAccounts()
                .checkAccount()
        ;
    }
}

