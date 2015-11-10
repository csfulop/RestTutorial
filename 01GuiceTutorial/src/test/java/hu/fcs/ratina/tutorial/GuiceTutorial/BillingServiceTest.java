
package hu.fcs.ratina.tutorial.GuiceTutorial;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class BillingServiceTest {

    private CreditCardProcessor processorMock = mock(CreditCardProcessor.class);
    private TransactionLog transactionLogMock = mock(TransactionLog.class);
    private BillingService billingService;

    @Before
    public void setUp() {
        billingService = new BillingService(processorMock, transactionLogMock);
    }

    @Test
    public void testSuccessfulOrder() {
        // given
        PizzaOrder order = new PizzaOrder(10);
        CreditCard creditCard = new CreditCard();
        when(processorMock.charge(any(CreditCard.class), anyInt())).thenReturn(new ChargeResult(true, "Success"));

        // when
        Receipt receipt = billingService.chargeOrder(order, creditCard);

        // then
        assertThat(receipt.getAmount(), is(10));
    }
}
