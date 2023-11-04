package core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import page.LoginPage;
import java.io.File;
import java.io.IOException;

import static core.DriverFactory.getDriver;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    private static LoginPage loginPage = new LoginPage();

    @Before
    public void initTests() {
        loginPage.accessInitialScreen();
        loginPage.setEmail("reazeco@hotmail.com");
        loginPage.setSenha("1234567");
        loginPage.signIn();
        loginPage.resetTestMass();
    }

    @After
    public void endTests() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File arquivo = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                                             File.separator + testName.getMethodName() + ".jpg"));

        if(core.Properties.CLOSE_BROWSER) {
            core.DriverFactory.killDriver();
        }
    }
}
