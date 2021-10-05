package baseball.view;

public class BaseBallView {

    public void printMessageNoLine(String message) {
        System.out.print(message);
    }

    public void printMessage(String message) {
        System.out.print(message);
        this.printNewline();
    }

    private void printNewline() {
        System.out.print(System.lineSeparator());
    }
}
