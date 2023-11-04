package page;

import core.BasePage;

public class MenuPage extends BasePage {

    public void accessHomeScreen(){
        clickLink("Home");
    }

    public void accessScreenInsertAccount(){
        clickLink("Contas");
        clickLink("Adicionar");
    }

    public void accessScreenListAccount(){
        clickLink("Contas");
        clickLink("Listar");
    }

    public void accessScreenInsertMovimentation(){
        clickLink("Criar Movimentação");
    }

    public void accessScreenSummary(){
        clickLink("Resumo Mensal");
    }
}
