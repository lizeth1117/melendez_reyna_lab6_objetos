
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author lizet
 */
public class iniciarsesion extends javax.swing.JFrame {
 String username, password,jugador1,jugador2;
 xo xo=new xo();

 
    /**
     * Creates new form iniciarsesion
     */
    public iniciarsesion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtuser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtpass = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario");

        jtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtuserActionPerformed(evt);
            }
        });

        jLabel2.setText("Clave");

        jtpass.setText("jPasswordField1");

        btnlogin.setText("Log in");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        jLabel3.setText("jugador 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtuser)
                                    .addComponent(jtpass, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtuserActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtuserActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
        username=jtuser.getText();
        password= jtpass.getText();
        inicializar();
       boolean encontrado=iniciosesion(username,password);
        if (encontrado){
         xo.setVisible(true);
        }
            
    }//GEN-LAST:event_btnloginActionPerformed


    jugador jugadores[]= new jugador[30];
    public static String[] usuarios = new String [20];
    public static String[] contras = new String [20];
    public static String[] nombres = new String [20];
    public static int[] puntos = new int [20];
     
    public void inicializar(){
        usuarios[0]="reyna";
        contras[0]="1234";
        nombres[0]="reyna";
        puntos[0]=0; 
        
        jugadores[0]=new jugador(usuarios[0],contras[0],nombres[0],puntos[0]);
        
    }
    
    public void registrarUsuario(String nombre, String username,String password,int puntos) {
  boolean existe = false;
    for (int i = 0; i < usuarios.length; i++) {
        if (usuarios[i].equals(username)) {
            existe = true;
            JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe.");
            break;
        }
        else  {
            // Agregar el nuevo jugador a la posición vacía
            usuarios[i] = username;
            contras[i]= password;
            nombres[i]=nombre ;
            
            jugadores[i]=new jugador(usuarios[i],contras[i],nombres[i],0);
            
            
         
            
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
    }
        }
    }
    
    public boolean iniciosesion(String username,String password){
    boolean encontrado = false;
    for (int i = 0; i < usuarios.length; i++) {
        if (usuarios[i].equals(username) && contras[i].equals(password)) {
            encontrado = true;
            break;
        }
    }
    if (encontrado) {
          JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!");
          jugador1=jtuser.getText();
          
    }
        
    else{
        JOptionPane.showMessageDialog(null,"el usuario no se encontro");
        encontrado=false;
    }
    return encontrado;
    }
    
    public static void main(String args[]) {
        
       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new iniciarsesion().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jtpass;
    private javax.swing.JTextField jtuser;
    // End of variables declaration//GEN-END:variables
}
