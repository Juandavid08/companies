import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculadora extends JFrame implements ActionListener {

    private JTextField textField;
    private double num1 = 0, num2 = 0, resultado =0;
    private String operador = "";
    
    public calculadora() {
        setTitle("Calculadora");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        String[] botones = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "3", "2", "1", "+",
            ".", "0", "raiz", "-",
            "CC", "=", "",""
        };

        for (String texto : botones) {
            if (!texto.equals("")){
                JButton btn = new JButton(texto);
                btn.setFont(new Font("Arial", Font.BOLD, 22));
                btn.addActionListener(this);
                panel.add(btn);
            } else {
                panel.add(new JLabel());
            }
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
     public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();

        try {
            if (input.matches("[0-9.]")) {
                textField.setText(textField.getText() + input);
            } else if (input.matches("[+\\-*/]")) {
                num1 = Double.parseDouble(textField.getText());
                operador = input;
                textField.setText("");
            } else if (input.equals("raiz")) {
                num1 = Double.parseDouble(textField.getText());
                if (num1 < 0) {
                    JOptionPane.showMessageDialog(this, "Error: Raíz de número negativo");
                } else {
                    resultado = Math.sqrt(num1);
                    textField.setText(String.valueOf(resultado));
                }
            } else if (input.equals("=")) {
                num2 = Double.parseDouble(textField.getText());
                switch (operador) {
                    case "+":
                        resultado = num1 + num2;
                        break;
                    case "-":
                        resultado = num1 - num2;
                        break;
                    case "*":
                        resultado = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            JOptionPane.showMessageDialog(this, "Error: División por cero");
                            return;
                        }
                        resultado = num1 / num2;
                        break;
                }
                textField.setText(String.valueOf(resultado));
            } else if (input.equals("CC")) {
                textField.setText("");
                num1 = num2 = resultado = 0;
                operador = "";
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada inválida");
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(calculadora::new);
    }
}
