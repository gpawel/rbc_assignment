package org.pg.rbc.assignment.pages;

import org.pg.rbc.assignment.BaseUnitTest;
import org.testng.annotations.Test;

public class SignInTests extends BaseUnitTest {
    @Test
    public void testSignIn() {
        LoblawsPage loblawsPage = new LoblawsPage(driver);
        SignIn signInPage = loblawsPage.signIn();
        signInPage.login();
    }
}
