package test.java.tests;

import core.BaseTest;
import org.junit.Test;
import page.AccountsPage;
import page.MenuPage;

import java.util.Random;

import static utils.Utils.assertEquals;

public class AccountsTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    AccountsPage accountsPage = new AccountsPage();
    Random random = new Random();
    int rand = random.nextInt();

    @Test
    public void insertAccountTest(){
        menuPage.accessScreenInsertAccount();
        accountsPage.setNome("Conta para movimentacoes "+rand);
        accountsPage.clickButtonSave();
        assertEquals("Conta adicionada com sucesso!", accountsPage.getSuccessMessage());
    }

    @Test
    public void changeAccountAccountTest(){
        menuPage.accessScreenListAccount();
        accountsPage.clickChangeAccount("Conta para alterar");
        accountsPage.setNome("Conta alterada");
        accountsPage.clickButtonSave();
        assertEquals("Conta alterada com sucesso!", accountsPage.getSuccessMessage());
    }

    @Test
    public void insertAccountSameNameTest(){
        menuPage.accessScreenInsertAccount();
        accountsPage.setNome("Conta mesmo nome");
        accountsPage.clickButtonSave();
        assertEquals("Já existe uma conta com esse nome!", accountsPage.getErrorMessage());
    }
}
