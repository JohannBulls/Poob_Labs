package presentation;

import javax.swing.*;

public class MyButton extends JButton {
    private boolean isRed = true;

    public void setIsRed(boolean isRed) {
        this.isRed = isRed;
    }

    public boolean isRed() {
        return isRed;
    }
}
