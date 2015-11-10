
package hu.fcs.ratina.tutorial.GuiceTutorial;

public class Receipt {

    public static Receipt forSuccessfulCharge(int amount) {
        return new Receipt(amount);
    }

    public static Receipt forDeclinedCharge(String declineMessage) {
        return new Receipt(declineMessage);
    }

    public static Receipt forSystemFailure(String message) {
        return new Receipt(message);
    }

    private int amount;
    private String errorMessage;

    private Receipt(int amount) {
        this.amount = amount;
    }

    private Receipt(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getAmount() {
        return amount;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
