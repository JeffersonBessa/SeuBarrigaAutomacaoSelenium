package page;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import static core.DriverFactory.getDriver;

public class MovementPage extends BasePage {

    public void setMovementDate(String date) {
        write("data_transacao", date);
    }

    public void setPaymentDate(String date) {
        write("data_pagamento", date);
    }

    public void setDescription(String description) {
        write("descricao", description);
    }

    public void setInterested(String interested) {
        write("interessado", interested);
    }

    public void setValue(String value) {
        write("valor", value);
    }

    public void setAccount(String account) {
        selectCombo("conta", account);
    }

    public void setPaidStatus(){
        clickRadio("status_pago");
    }

    public void saveMovement(){
        clickButtonByText("Salvar");
    }

    public String getSuccessMessage(){
        return getText(By.xpath("//div[@class='alert alert-success']"));
    }

    public List<String> getErrors(){
        List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
        List<String> retorno = new ArrayList<String>();
        for(WebElement erro: erros) {
            retorno.add(erro.getText());
        }
        return retorno;
    }
}
