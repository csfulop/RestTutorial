
package hu.fcs.ratina.tutorial.GuiceTutorial;

public class InMemoryCardProcessor implements CreditCardProcessor {

    public ChargeResult charge(CreditCard creditCard, int amount) {
        return new ChargeResult(true, "Success");
    }

}
