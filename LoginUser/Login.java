import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class Login extends JFrame{
    
    private String usuariore;
    private String contrasenare;
    private static final String ABECEDARIO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String CIFRADO = "DEFGHIJKLMNOPQRSTUVWXYZABC";
    private final JLabel texto;
    private final JTextArea usuario;
    private final JPasswordField contrasena;
    private final JButton acceder;
    private final JButton registrar;
    
    
    public static void main(String[] args) {
        
        Login Ventana = new Login();
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ventana.setVisible(true);

        Toolkit miVentana = Toolkit.getDefaultToolkit();
        Dimension tamañPantalla = miVentana.getScreenSize();

        int alturaPantalla = tamañPantalla.height;
        int anchoPantalla = tamañPantalla.width;

        Ventana.setSize(anchoPantalla / 2, alturaPantalla / 2);
        Ventana.setLocation(anchoPantalla / 4, alturaPantalla / 4);

        Ventana.setResizable(false);
    }
    
        public Login (){
        super("Login Demo");
        setLayout(new FlowLayout());

        texto = new JLabel ("Ingresa tu usuario y contraseña");
        add(texto);
        
        usuario = new JTextArea(1, 20);
        add(usuario);

        contrasena = new JPasswordField(20);
        add(contrasena);
        
        acceder = new JButton("Acceder");
        add(acceder);

        registrar = new JButton("Registrar");
        add(registrar);
        
        acceder.addActionListener(new HandlerAcceder());
        registrar.addActionListener(new HandlerRegistrar());
        }  
    
    private class HandlerRegistrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
        
        boolean registroCompletado = false;
         usuariore = usuario.getText();
        
        // Pedir la contraseña dos veces para confirmarla
        do {
            contrasenare = contrasena.getText();
            String confirmacion = contrasena.getText();
            if (contrasenare.equals(confirmacion)) {
                registroCompletado = true;
            } else {
                JOptionPane.showMessageDialog(null,"Las contraseñas no coinciden. Intente nuevamente.");
            }
            }while (!registroCompletado);
       
        String contrasenaenc = Encriptador.encriptar(contrasenare);
            
           try {
            FileWriter archivo = new FileWriter("usuarios.txt");
            archivo.write(usuariore + " "+ contrasenaenc);
            archivo.close();
            JOptionPane.showMessageDialog(null, "Los datos del usuario se han "
                    + "registrado correctamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al guardar"
                    + " los datos del usuario en el archivo");
            e.printStackTrace();
        }
        
    }
    
}
        
    private class HandlerAcceder implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
          String us = usuario.getText();
          String con = contrasena.getText();
          
          if (us.equals(usuariore) && con.equals(contrasenare)) {
            JOptionPane.showMessageDialog(null,"¡Bienvenido " +usuariore + "!");
        } else {
            JOptionPane.showMessageDialog(null,"El usuario y/o contraseña son incorrectos.");
        }
          
        }
        
    }
    
}


