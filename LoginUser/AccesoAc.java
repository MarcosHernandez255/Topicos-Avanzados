
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AccesoAc extends JFrame {
    public AccesoAc() {
        setTitle("Nueva ventana");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        Lamina miLamina = new Lamina();
        
        add(miLamina);
    }
}
class Lamina extends JPanel{
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        g.drawString("BIENVENIDO",200,100);
    }
}
