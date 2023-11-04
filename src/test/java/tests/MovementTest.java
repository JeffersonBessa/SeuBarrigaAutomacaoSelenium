package test.java.tests;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.MenuPage;
import page.MovementPage;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static utils.DateUtils.*;
import static utils.DateUtils.getFormattedDate;
import static utils.Utils.assertEquals;
import static utils.Utils.assertTrue;

public class MovementTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private MovementPage movementPage = new MovementPage();

    @Test
    public void insertMovementTest(){
        menuPage.accessScreenInsertMovimentation();
        movementPage.setMovementDate(getFormattedDate(new Date()));
        movementPage.setPaymentDate(getFormattedDate(new Date()));
        movementPage.setDescription("Movimentação do Teste");
        movementPage.setInterested("Interessado Qualquer");
        movementPage.setValue("500");
        movementPage.setAccount("Conta para movimentacoes");
        movementPage.setPaidStatus();
        movementPage.saveMovement();
        assertEquals("Movimentação adicionada com sucesso!", movementPage.getSuccessMessage());
    }

    @Test
    public void mandatoryFieldsMovementTest(){
        menuPage.accessScreenInsertMovimentation();
        movementPage.saveMovement();
        List<String> erros = movementPage.getErrors();
        Assert.assertTrue(erros.containsAll(Arrays.asList(
            "Data da Movimentação é obrigatório", "Data do pagamento é obrigatório",
            "Descrição é obrigatório", "Interessado é obrigatório",
            "Valor é obrigatório", "Valor deve ser um número")));
        Assert.assertEquals(6, erros.size());
    }

    @Test
    public void InsertFutureMovementTest(){
        menuPage.accessScreenInsertMovimentation();
        Date futureDate = getDateWithDifferenceOfDays(5);

        movementPage.setMovementDate(getFormattedDate(futureDate));
        movementPage.setPaymentDate(getFormattedDate(futureDate));
        movementPage.setDescription("Movimentação do Teste");
        movementPage.setInterested("Interessado Qualquer");
        movementPage.setValue("500");
        movementPage.setAccount("Conta para movimentacoes");
        movementPage.setPaidStatus();
        movementPage.saveMovement();

        List<String> erros = movementPage.getErrors();
        assertTrue("Validando Data Movimentação Futura:", erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
        Assert.assertEquals(1, erros.size());
    }
}
