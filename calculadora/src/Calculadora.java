import java.awt.event.ActionListener;
import org.nfunk.jep.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Calculadora implements ActionListener {
    private JTextField campoEntrada;
    private JTextField campoResultado;
    private JEP jep;

    public Calculadora() {
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(2, 2));

        campoEntrada = new JTextField();
        campoResultado = new JTextField();
        campoResultado.setEditable(false);

        JButton botaoCalcular = new JButton("Calcular");
        botaoCalcular.addActionListener(this);

        painel.add(new JLabel("Expressão: "));
        painel.add(campoEntrada);
        painel.add(new JLabel("Resultado: "));
        painel.add(campoResultado);

        frame.getContentPane().add(painel, BorderLayout.CENTER);
        frame.getContentPane().add(botaoCalcular, BorderLayout.SOUTH);

        frame.setVisible(true);

        // criar objeto JEP
        jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
    }

    public void actionPerformed(ActionEvent e) {
        String expressao = campoEntrada.getText();

        // avaliar expressão com JEP
        jep.parseExpression(expressao);
        if (jep.hasError()) {
            campoResultado.setText("Erro ao avaliar expressão: " + jep.getErrorInfo());
        } else {
            Object resultado = jep.getValue();
            campoResultado.setText(resultado.toString());
        }
    }
}
