package test.java.suites;

import core.DriverFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import page.LoginPage;
import test.java.tests.AccountsTest;
import test.java.tests.BalanceTest;
import test.java.tests.MovementTest;
import test.java.tests.RemoveAccountMovementTest;
import test.java.tests.SummaryTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    AccountsTest.class,
    MovementTest.class,
    RemoveAccountMovementTest.class,
    BalanceTest.class,
    SummaryTest.class
})

public class GeneralTestSuite {

    public static final String EMAIL = "reazeco@hotmail.com";
    public static final String PASSWORD = "1234567";
    private static LoginPage loginPage = new LoginPage();

    @BeforeClass
    public static void reset(){
        loginPage.accessInitialScreen();
        loginPage.setEmail(EMAIL);
        loginPage.setSenha(PASSWORD);
        loginPage.signIn();
        loginPage.resetTestMass();
    }

    @AfterClass
    public static void finishTests(){
        DriverFactory.killDriver();
    }
}
