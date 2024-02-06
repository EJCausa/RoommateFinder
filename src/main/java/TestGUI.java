import javax.swing.*;

public class TestGUI {

    private JPanel rootPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TestGUI");
        frame.setContentPane(new TestGUI().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
