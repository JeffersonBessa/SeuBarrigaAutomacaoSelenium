package test.java.tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.MenuPage;
import page.SummaryPage;
import java.util.List;
import static core.DriverFactory.getDriver;
import static utils.Utils.assertEquals;

public class SummaryTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SummaryPage summaryPage = new SummaryPage();

    @Test
    public void removeMovementTest(){
        menuPage.accessScreenSummary();
        summaryPage.removeMovement();
        assertEquals("Movimentação removida com sucesso!", summaryPage.getSuccessMessage());
    }

    @Test
    public void monthlySummaryTest(){
        menuPage.accessScreenSummary();
        assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
        summaryPage.selectYear("2016");
        summaryPage.search();

        List<WebElement> elementsFound =
            getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
        Assert.assertEquals(0, elementsFound.size());
    }
}
