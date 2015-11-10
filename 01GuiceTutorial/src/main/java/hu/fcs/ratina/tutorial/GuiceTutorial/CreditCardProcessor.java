
package hu.fcs.ratina.tutorial.GuiceTutorial;

public interface CreditCardProcessor {

    ChargeResult charge(CreditCard creditCard, int amount);

}
