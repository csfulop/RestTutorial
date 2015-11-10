
package hu.fcs.ratina.tutorial.GuiceTutorial;

public class ChargeResult {

    private boolean result;
    private String message;

    public ChargeResult(boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public boolean wasSuccessful() {
        return result;
    }

    public String getDeclineMessage() {
        return message;
    }

}
