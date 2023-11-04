package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;
import static core.DriverFactory.getDriver;

public class BasePage {

    /********* TextField e TextArea ************/

    public void write(By by, String texto){
        getDriver().findElement(by).clear();
        getDriver().findElement(by).sendKeys(texto);
    }

    public void write(String id_campo, String texto){
        write(By.id(id_campo), texto);
    }

    public String getFieldValue(String id_campo) {
        return getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    /********* Radio e Check ************/

    public void clickRadio(By by) {
        getDriver().findElement(by).click();
    }

    public void clickRadio(String id) {
        clickRadio(By.id(id));
    }

    public boolean isRadioMarked(String id){
        return getDriver().findElement(By.id(id)).isSelected();
    }

    public void clickCheck(String id) {
        getDriver().findElement(By.id(id)).click();
    }

    public boolean isCheckMarked(String id){
        return getDriver().findElement(By.id(id)).isSelected();
    }

    /********* Combo ************/

    public void selectCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public void deselectCombo(String id, String valor) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    public String getComboValue(String id) {
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> getComboValues(String id) {
        WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for(WebElement opcao: allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public int getComboAmountOptions(String id){
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public boolean verifyComboOption(String id, String opcao){
        WebElement element = getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for(WebElement option: options) {
            if(option.getText().equals(opcao)){
                return true;
            }
        }
        return false;
    }

    public void selectComboPrime(String radical, String valor) {
        clickRadio(By.xpath("//*[@id='"+radical+"_input']/../..//span"));
        clickRadio(By.xpath("//*[@id='"+radical+"_items']//li[.='"+valor+"']"));
    }

    /********* Botao ************/

    public void clickButton(By by) {
        getDriver().findElement(by).click();
    }
    public void clickButton(String id) {
        clickButton(By.id(id));
    }

    public void clickButtonByText(String texto){
        clickButton(By.xpath("//button[.='"+texto+"']"));
    }

    public String getElementValue(String id) {
        return getDriver().findElement(By.id(id)).getAttribute("value");
    }

    /********* Link ************/

    public void clickLink(String link) {
        getDriver().findElement(By.linkText(link)).click();
    }

    /********* Texts ************/

    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    public String getText(String id) {
        return getText(By.id(id));
    }

    /********* Alerts ************/

    public String alertGetText(){
        Alert alert = getDriver().switchTo().alert();
        return alert.getText();
    }

    public String alertGetTextAndAccept(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;
    }

    public String alertGetTextAndDismiss(){
        Alert alert = getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;

    }

    public void alertWrite(String valor) {
        Alert alert = getDriver().switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }

    /********* Frames and Windows ************/

    public void enterInFrame(String id) {
        getDriver().switchTo().frame(id);
    }

    public void goOutFrame(){
        getDriver().switchTo().defaultContent();
    }

    public void switchWindow(String id) {
        getDriver().switchTo().window(id);
    }

    /************** JS *********************/

    public Object executeJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, param);
    }

    /************** Table *********************/

    public WebElement getCell(String colunaBusca, String valor, String colunaBotao, String idTabela){
        //procurar coluna do registro
        WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
        int idColuna = getCollumnIndex(colunaBusca, tabela);

        //encontrar a linha do registro
        int idLinha = getLineIndex(valor, tabela, idColuna);

        //procurar coluna do botao
        int idColunaBotao = getCollumnIndex(colunaBotao, tabela);

        //clicar no botao da celula encontrada
        WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
        return celula;
    }

    public void clickTableButton(String colunaBusca, String valor, String colunaBotao, String idTabela){
        WebElement celula = getCell(colunaBusca, valor, colunaBotao, idTabela);
        celula.findElement(By.xpath(".//input")).click();

    }

    protected int getLineIndex(String valor, WebElement tabela, int idColuna) {
        List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
        int idLinha = -1;
        for(int i = 0; i < linhas.size(); i++) {
            if(linhas.get(i).getText().equals(valor)) {
                idLinha = i+1;
                break;
            }
        }
        return idLinha;
    }

    protected int getCollumnIndex(String coluna, WebElement tabela) {
        List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
        int idColuna = -1;
        for(int i = 0; i < colunas.size(); i++) {
            if(colunas.get(i).getText().equals(coluna)) {
                idColuna = i+1;
                break;
            }
        }
        return idColuna;
    }

}
