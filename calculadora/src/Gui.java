import javax.swing.*;
import java.awt.*;

public class Gui {
    void janela() {
        JFrame frame01 = new JFrame();
        JPanel panel01 = new JPanel(new GridLayout(6, 4, 5, 5));

        for (int i = 1; i < 25; i++) {

            JButton botao01 = new JButton("teste");

            panel01.add(botao01);
        }
        frame01.add(panel01);
        frame01.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame01.setSize(500,500);
        frame01.setVisible(true);
    }

}
