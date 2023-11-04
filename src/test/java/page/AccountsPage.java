package page;

import core.BasePage;
import org.openqa.selenium.By;

public class AccountsPage extends BasePage {

    public void setNome(String nome) {
        write("nome", nome);
    }

    public void clickButtonSave(){
        clickButtonByText("Salvar");
    }

    public String getSuccessMessage(){
        return getText(By.xpath("//div[@class='alert alert-success']"));
    }

    public String getErrorMessage(){
        return getText(By.xpath("//div[@class='alert alert-danger']"));
    }

    public void clickChangeAccount(String string) {
        getCell("Conta", string, "Ações", "tabelaContas")
            .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }

    public void clickRemoveAccount(String string) {
        getCell("Conta", string, "Ações", "tabelaContas")
            .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }
}
