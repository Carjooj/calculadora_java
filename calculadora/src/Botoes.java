import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.nfunk.jep.*;

public class Botoes extends Interface implements ActionListener {

    String[] sinais = {"+", "-", "*", "/"};

    int i = 1;
    JEP jep = new JEP();
    String getdisplay;




    String textoBotao(ActionEvent e) {
        String texto = "";
        Object source = e.getSource();
        if (source instanceof JButton botao) {
            texto = botao.getText();
        }
        return texto;
    }

    Botoes() {
        jep.addStandardFunctions();
        jep.addStandardConstants();
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
        powButton.addActionListener(this);
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
        String subGetDisplay;
        if (display.getText().equals(a0Button.getText()) || display.getText().equals("Erro")) {
            if (textoBotao(e).equals(a1Button.getText())) {
                display.setText(textoBotao(e));

            } else if (textoBotao(e).equals(a2Button.getText())) {
                display.setText(textoBotao(e));

            } else if (textoBotao(e).equals(a3Button.getText())) {
                display.setText(textoBotao(e));

            } else if (textoBotao(e).equals(a4Button.getText())) {
                display.setText(textoBotao(e));

            } else if (textoBotao(e).equals(a5Button.getText())) {
                display.setText(textoBotao(e));

            } else if (textoBotao(e).equals(a6Button.getText())) {
                display.setText(textoBotao(e));

            } else if (textoBotao(e).equals(a7Button.getText())) {
                display.setText(textoBotao(e));

            } else if (textoBotao(e).equals(a8Button.getText())) {
                display.setText(textoBotao(e));

            } else if (textoBotao(e).equals(a9Button.getText())) {
                display.setText(textoBotao(e));

            } else if (textoBotao(e).equals(raizButton.getText())) {
                display.setText("√");

            } else if (textoBotao(e).equals(virgulaButton.getText())) {
                display.setText("0,");
            } else {
                display.setText("0");
            }

        } else {
            display.setText(display.getText() + textoBotao(e));
            if (textoBotao(e).equals(sinalButton.getText())) {
                String sinal = "-";
                getdisplay = display.getText().replace(sinalButton.getText(), "");
                subGetDisplay = sinal + getdisplay.substring(getdisplay.length() - 1);
                getdisplay = getdisplay.substring(0, getdisplay.length() - 1);
                getdisplay += subGetDisplay;
                display.setText(getdisplay);
            }
            if (textoBotao(e).equals(a1xButton.getText())) {
                getdisplay = display.getText().replace(a1xButton.getText(), "");
                subGetDisplay = "1/" + getdisplay.substring(getdisplay.length() - 1);
                getdisplay = getdisplay.substring(0, getdisplay.length() - 1);
                getdisplay += subGetDisplay;
                display.setText(getdisplay);
            }
            if (textoBotao(e).equals(powButton.getText())) {
                getdisplay = display.getText().replace(powButton.getText(), "²");
                display.setText(getdisplay);
            }
            if (textoBotao(e).equals(raizButton.getText())) {
                getdisplay = display.getText().replace(raizButton.getText(), "√");
                display.setText(getdisplay);


            }
            if (textoBotao(e).equals(cButton.getText())) {
                display.setText("0");
            }
            if (textoBotao(e).equals(DelButton.getText())) {
                display.setText(display.getText().replace(DelButton.getText(), ""));
                i = 1;
                if (display.getText().equals("sqrt()")) {
                    display.setText("0");
                }
                if (display.getText().isEmpty()) {
                    i = 0;
                    display.setText("0");
                }
                display.setText(display.getText().substring(0, display.getText().length() - i));
            }
            if (textoBotao(e).equals(igualButton.getText())) {
                getdisplay = display.getText();
                getdisplay = getdisplay.replace(menosButton.getText(), "-");
                getdisplay = getdisplay.replace(multiButton.getText(), "*");
                getdisplay = getdisplay.replace(divButton.getText(), "/");
                getdisplay = getdisplay.replace(virgulaButton.getText(), ".");
                getdisplay = getdisplay.replace(porcentagemButton.getText(), "/100");

                if (getdisplay.contains("²")) {
                    while (getdisplay.contains("²")) {
                        getdisplay = getdisplay.replaceFirst("²", "^2");
                    }
                }
                if (getdisplay.contains("√")) {
                    while (getdisplay.contains("√")) {
                        int indexRad = getdisplay.indexOf("√"); // acha o index de onde está o sinal da raiz
                        subGetDisplay = getdisplay.substring(indexRad);
                        for (int j = 0; j < 4; ) {
                            try {
                                subGetDisplay = subGetDisplay.substring(0, subGetDisplay.indexOf(sinais[j]));
                            } catch (StringIndexOutOfBoundsException e1) {
                                j++;
                            }
                        }
                        getdisplay = getdisplay.replaceFirst(subGetDisplay, "sqrt(" + subGetDisplay + ")");
                        getdisplay = getdisplay.replaceFirst("√", "");
                    }

                }
                getdisplay = getdisplay.replace(igualButton.getText(), "");
                System.out.println(getdisplay);
                jep.parseExpression(getdisplay);
                if (jep.hasError()) {
                    display.setText("Erro");
                    System.out.println(jep.getErrorInfo());

                } else {
                    System.out.println(jep.getValue());
                    double resultado = jep.getValue();
                    String strResul = Double.toString(resultado);
                    strResul = strResul.replace(".", virgulaButton.getText());
                    display.setText(strResul);
                }
            }

        }
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
