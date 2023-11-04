package page;

import core.BasePage;
import org.openqa.selenium.By;

public class SummaryPage extends BasePage {

    public void removeMovement(){
        clickButton(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
    }

    public String getSuccessMessage(){
        return getText(By.xpath("//div[@class='alert alert-success']"));
    }

    public void selectYear(String year) {
        selectCombo("ano", year);
    }

    public void search(){
        clickButton(By.xpath("//input[@value='Buscar']"));
    }
}
