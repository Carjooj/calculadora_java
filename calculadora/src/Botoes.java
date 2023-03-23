import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botoes extends Interface implements ActionListener {
    String strdisplay;
    int displayconvertido;

    String textoBotao(ActionEvent e){
        String texto = "";
        Object source = e.getSource();
        if (source instanceof JButton botao) {
            texto = botao.getText();
        }
        return texto;
    }

      Botoes() {
        MCButton.addActionListener(this);
        MRButton.addActionListener(this);
        MmButton.addActionListener(this);
        MnButton.addActionListener(this);
        MSButton.addActionListener(this);
        MDButton.addActionListener(this);
        porcentagemButton.addActionListener(this);
        CEButton.addActionListener(this);
        cButton.addActionListener(this);
        DelButton.addActionListener(this);
        a1xButton.addActionListener(this);
        sqrButton.addActionListener(this);
        raizButton.addActionListener(this);
        divButton.addActionListener(this);
        a7Button.addActionListener(this);
        a8Button.addActionListener(this);
        a9Button.addActionListener(this);
        multiButton.addActionListener(this);
        a4Button.addActionListener(this);
        a5Button.addActionListener(this);
        a6Button.addActionListener(this);
        menosButton.addActionListener(this);
        a1Button.addActionListener(this);
        a2Button.addActionListener(this);
        a3Button.addActionListener(this);
        maisButton.addActionListener(this);
        sinalButton.addActionListener(this);
        a0Button.addActionListener(this);
        virgulaButton.addActionListener(this);
        igualButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!display.getText().equals(a0Button.getText())) {
            display.setText(display.getText() + textoBotao(e));
            if (textoBotao(e).equals(cButton.getText())) {
                display.setText("0");
            }
            if (textoBotao(e).equals(igualButton.getText())) {


               /* int i = 0;
                strdisplay = display.getText();
                strdisplay = strdisplay.replace(igualButton.getText(), "");
                displayconvertido = Integer.parseInt(strdisplay);
                System.out.println(strdisplay);
                System.out.println(displayconvertido);
                i++;
                codigo necessário para retirar o caractere "=" para poder converter a string.
                Integer.parseInt não converte operadores (+, -. /, *) e realiza uma expressão
                */
            }
        }
        else {
            display.setText(textoBotao(e));
        }
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
