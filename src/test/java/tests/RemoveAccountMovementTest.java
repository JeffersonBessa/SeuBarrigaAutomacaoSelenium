package test.java.tests;

import core.BaseTest;
import org.junit.Test;
import page.AccountsPage;
import page.MenuPage;

import static utils.Utils.assertEquals;

public class RemoveAccountMovementTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    AccountsPage accountsPage = new AccountsPage();

    @Test
    public void removeAccountWithAssociatedMovementTest() {
        menuPage.accessScreenListAccount();
        accountsPage.clickRemoveAccount("Conta com movimentacao");
        assertEquals("Conta em uso na movimentações", accountsPage.getErrorMessage());
    }
}
