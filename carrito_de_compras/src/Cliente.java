import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.*;
public class Cliente extends javax.swing.JFrame {
    ArrayList<Producto> ps = new ArrayList<Producto>();
    ArrayList<Producto> carrito = new ArrayList<Producto>();
    DefaultListModel listModel = new DefaultListModel();
    //Socket cl;
    static int x=0;
    /**
     * Creates new form Cliente
     */
    public Cliente() {
        initComponents();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Servidor/lista"));
            ps = (ArrayList)ois.readObject();
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        recibirDatos();
        recibirImagenes();
        iniciarCompras();
         
    }
    public void iniciarCompras(){
        if(ps.get(x).categoria.equals("Abarrotes")){
            String path = "C:\\Users\\GraciasPorElIntenet\\Desktop\\Carrito_Compras\\Cliente\\images\\"+ps.get(x).nombre+".jpg";
            System.out.println("/Cliente/images/"+ps.get(x).nombre);
            jLabel1.setIcon(new javax.swing.ImageIcon(path));
            jLabel2.setText(ps.get(x).precio+"");
            jLabel6.setText(""+ps.get(x).existencias);
            
        }
        else{
            x++;
            iniciarCompras();
        }
        
    }
    public void recibirImagenes(){
        try{
            for(int i =0; i<ps.size(); i++){
                int pto = 8001;
                String host = "127.0.0.1";
                Socket cl = new Socket(host, pto);
                DataInputStream dis = new DataInputStream(cl.getInputStream());
                long recibidos = 0;
                long tam = dis.readLong();
                System.out.println("tamaño: "+tam);
                String nombre = dis.readUTF();
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("Cliente/images/"+nombre));
                while(recibidos < tam){
                    byte []b = new byte[20000];
                    int m = dis.read(b);
                    recibidos = recibidos + m;
                    dos.write(b, 0, m);
                    //System.out.println("one");
                }
                dos.close();
                dis.close();
                System.out.println("imagen recibida");
                
            }
            //dis.close();
            System.out.println("Archivos Recibidos");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void recibirDatos(){
        try{
            int pto = 9000;
            String host = "127.0.0.1";
            Socket cl = new Socket(host, pto);
            ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
            //ois.close();
            ps = (ArrayList)ois.readObject();
            for(int i=0;i<ps.size(); i++){
                System.out.println("Elementi: "+ps.get(i).nombre);
            }
            ois.close();
            cl.close();
            }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abarrotes", "Ropa", "Electronica" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Agregar al Carrito");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Finalizar Compra");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel2.setText("jLabel2");

        jButton3.setText(">");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("<");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("$");

        jButton5.setText("Quitar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setText("Bienvenido");

        jLabel5.setText("Existencias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addGap(0, 24, Short.MAX_VALUE)))
                                .addGap(75, 75, 75))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(24, 24, 24)
                        .addComponent(jButton3)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(7, 7, 7)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        while(true){
            x--;
            if(x<=0){
                System.out.println("hace 0");
                x = ps.size()-1;
            }
            if(ps.get(x).categoria.equals(jComboBox1.getSelectedItem().toString())){
                System.out.println("entra");
                break;
            }
            
        }
        System.out.println("valor x: "+x);
        String path = "C:\\Users\\GraciasPorElIntenet\\Desktop\\Carrito_Compras\\Cliente\\images\\"+ps.get(x).nombre+".jpg";
        System.out.println("/Cliente/images/"+ps.get(x).nombre);
        jLabel1.setIcon(new javax.swing.ImageIcon(path));
        jLabel2.setText(ps.get(x).precio+"");
        jLabel6.setText(""+ps.get(x).existencias);    
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        for(int i=0; i<ps.size(); i++){
            if(ps.get(i).categoria.equals(jComboBox1.getSelectedItem())){
                /*String path = "/Cliente/images/"+ps.get(i).nombre+".jpg";
                URL url = this.getClass().getResource(path);
                ImageIcon icon = new ImageIcon(url);
                jLabel1.setIcon(icon);
                jLabel2.setText(ps.get(i).precio+"");*/
                String path = "C:\\Users\\GraciasPorElIntenet\\Desktop\\Carrito_Compras\\Cliente\\images\\"+ps.get(x).nombre+".jpg";
                System.out.println("/Cliente/images/"+ps.get(i).nombre);
                jLabel1.setIcon(new javax.swing.ImageIcon(path));
                jLabel2.setText(ps.get(i).precio+"");
                jLabel6.setText(ps.get(i).existencias+"");
                x = i;
                return;
            }
            else
                continue;
        }
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       while(true){
            x++;
            if(x>=ps.size()){
                System.out.println("hace 0");
                x = 0;
            }
            if(ps.get(x).categoria.equals(jComboBox1.getSelectedItem().toString())){
                System.out.println("entra");
                break;
            }
            
        }
        System.out.println("valor x: "+x);
        String path = "C:\\Users\\GraciasPorElIntenet\\Desktop\\Carrito_Compras\\Cliente\\images\\"+ps.get(x).nombre+".jpg";
        System.out.println("/Cliente/images/"+ps.get(x).nombre);
        jLabel1.setIcon(new javax.swing.ImageIcon(path));
        jLabel2.setText(ps.get(x).precio+"");
        jLabel6.setText(""+ps.get(x).existencias);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        carrito.add(ps.get(x));
        ps.get(x).existencias--;
        listModel.addElement(ps.get(x).nombre);
        jList1.setModel(listModel);
        JOptionPane.showMessageDialog(null, "Agregado al carrito");
        jLabel6.setText(""+ps.get(x).existencias);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String ret = listModel.getElementAt(jList1.getSelectedIndex()).toString();
        listModel.removeElementAt(jList1.getSelectedIndex());
        jList1.setModel(listModel);
        System.out.println(ret+"tam "+listModel.size());
        for(int i=0; i<ps.size(); i++){
            if(ps.get(i).nombre.equals(ret)){
                ps.get(i).existencias++;
                if(i==x){
                    jLabel6.setText(""+ps.get(x).existencias);
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            int pto=9000;
            String host = "127.0.0.1";
            Socket cl = new Socket(host, pto);
            ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
            oos.writeObject(carrito);
            oos.flush();
            oos.writeObject(ps);
            oos.flush();
            Ticket ticket = (Ticket)ois.readObject();
            JOptionPane.showMessageDialog(null, ticket.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1AncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}