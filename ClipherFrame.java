import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClipherFrame extends JFrame {

    private final JTextArea area1;
    private final JButton BottonEncriptar;
    private final JButton BottonDesencriptar;
    private final JTextArea area2;

    public static void main(String[] args) {
        ClipherFrame Ventana = new ClipherFrame();
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ventana.setVisible(true);

        Toolkit miVentana = Toolkit.getDefaultToolkit();
        Dimension tamañoPantalla = miVentana.getScreenSize();

        int alturaPantalla = tamañoPantalla.height;
        int anchoPantalla = tamañoPantalla.width;

        Ventana.setSize(anchoPantalla / 2, alturaPantalla / 2);
        Ventana.setLocation(anchoPantalla / 4, alturaPantalla / 4);

        Ventana.setResizable(false);


    }

    public ClipherFrame() {
        super("Clipher Demo");
        setLayout(new FlowLayout());

        area1 = new JTextArea(10, 15);
        add(area1);

        BottonEncriptar = new JButton("Encriptar");
        add(BottonEncriptar);

        BottonDesencriptar = new JButton("Desencriptar");
        add(BottonDesencriptar);

        area2 = new JTextArea(10, 15);
        area2.setEditable(false);
        add(area2);
        BottonEncriptar.addActionListener(new HandlerEncriptar());
        BottonDesencriptar.addActionListener(new HandlerDesencriptar());
    }

    private class HandlerEncriptar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            String command = event.getActionCommand();
            String input = area1.getText();
            if (command.equals("Encriptar")) {
                String output = encrypt(input);
                area2.setText(output);
            } 
        }

        private String encrypt(String input) {
            char[] chars = input.toCharArray();
            int length = chars.length;

            for (int i = 0; i < length; i++) {
                char c = chars[i];
                if (Character.isLetter(c)) {
                    char shifted = (char) (c + 3);
                    if ((Character.isUpperCase(c) && shifted > 'Z') || (Character.isLowerCase(c) && shifted > 'z')) {
                        shifted -= 26;
                    }
                    chars[i] = shifted;
                } else if (c == 'a' || c == 'A') {
                    chars[i] = 'd';
                } else if (c == 'y' || c == 'Y') {
                    chars[i] = '|';
                }
            }

            for (int i = 0; i < length / 2; i++) {
                char temp = chars[i];
                chars[i] = chars[length - 1 - i];
                chars[length - 1 - i] = temp;
            }

            int mid = length / 2;
            for (int i = mid; i < length - 1; i++) {
                chars[i] = chars[i + 1];
            }
            chars[length - 1] = chars[mid - 1];
            return new String(chars);
        }
    }

    private class HandlerDesencriptar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            String input = area1.getText();
            if (command.equals("Desencriptar")) {
                String output = decrypt(input);
                area2.setText(output);
            }
        }
        private String decrypt(String input) {
            char[] chars = input.toCharArray();
            int length = chars.length;

            // Mover los caracteres de la mitad para atrÃ¡s una posiciÃ³n a
            int mid = length / 2;
            for (int i = mid; i < length - 1; i++) {
                chars[i] = chars[i + 1];
            }

            chars[length - 1] = chars[mid - 1];

            String modified = new String(chars);

            return (modified);
        }
    }
}

