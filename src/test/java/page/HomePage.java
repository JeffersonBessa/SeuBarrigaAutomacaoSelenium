package page;

import core.BasePage;

public class HomePage extends BasePage {

    public String getAccountBalance(String name) {
        return getCell("Conta", name, "Saldo", "tabelaSaldo").getText();
    }
}
