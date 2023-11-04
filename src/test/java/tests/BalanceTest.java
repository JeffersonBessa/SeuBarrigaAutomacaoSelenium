package test.java.tests;

import core.BaseTest;
import org.junit.Test;
import page.HomePage;
import page.MenuPage;
import static utils.Utils.assertEquals;

public class BalanceTest extends BaseTest {

    HomePage page = new HomePage();
    MenuPage menu = new MenuPage();

    @Test
    public void accountBalanceTest(){
        menu.accessHomeScreen();
        assertEquals("534.00", page.getAccountBalance("Conta para saldo"));
    }
}
