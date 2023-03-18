import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Botoes {
    Interface interface01;

    String textoBotao(ActionEvent e){
        String texto = "";
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton botao = (JButton) source;
            texto = botao.getText();
        }
        return texto;
    }
/*
    JFrame frame01 = new JFrame("Calculadora");

    JPanel panel01 = new JPanel();
    JPanel panel02 = new JPanel(new GridLayout(7, 4, 5, 5));

    JLabel label01 = new JLabel();
    JButton[] botoes;
    String strbotao[] = {"%", "CE", "C", "DEL", "1/x", "x²", "√x", "/", "7", "8", "9", "X", "4", "5", "6", "-", "1", "2", "3", "+", "±", "0", ",", "="};


    public Botoes() {
        label01.setBackground(Color.blue);
        frame01.getContentPane().add(label01, BorderLayout.CENTER);
        frame01.add(panel02);
        frame01.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame01.setSize(500,500);
        frame01.setVisible(true);
        botoes = new JButton[25];
        for (int i = 0; i < 24; i++) {
            botoes[i] = new JButton(strbotao[i]);
            botoes[i].setName("botao_" + i);
            panel02.add(botoes[i]);
        }

    }
    JButton getBotao(String nome){
        for (int i = 0; i < 25; i++) {
            if (botoes[i].getName().equals(nome)){
                return botoes[i];
            }
        }
        return null;
    }


*/
}
