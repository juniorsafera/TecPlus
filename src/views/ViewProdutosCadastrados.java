/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import dao.ConnectionFactory;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author IdeaSofist
 */
public class ViewProdutosCadastrados extends javax.swing.JFrame {

    /**
     * Creates new form ViewProdutosCadastrados
     */
    public ViewProdutosCadastrados() {
        initComponents();
        listarProdutos();
        setaricon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bSair = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        tPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bSair.setOpaque(false);
        bSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSairMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bSairLayout = new javax.swing.GroupLayout(bSair);
        bSair.setLayout(bSairLayout);
        bSairLayout.setHorizontalGroup(
            bSairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        bSairLayout.setVerticalGroup(
            bSairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(bSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 505, 40, 40));

        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbProdutos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 90, 990, 390));

        tPesquisar.setBackground(new java.awt.Color(45, 45, 85));
        tPesquisar.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        tPesquisar.setBorder(null);
        tPesquisar.setOpaque(false);
        tPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tPesquisarKeyReleased(evt);
            }
        });
        getContentPane().add(tPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 270, 23));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TelaProdutosCadastrados.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSairMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bSairMouseClicked

    private void tPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tPesquisarKeyReleased
        // TODO add your handling code here:
        pesquisarProduto();
    }//GEN-LAST:event_tPesquisarKeyReleased

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
            java.util.logging.Logger.getLogger(ViewProdutosCadastrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProdutosCadastrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProdutosCadastrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProdutosCadastrados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewProdutosCadastrados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tPesquisar;
    private javax.swing.JTable tbProdutos;
    // End of variables declaration//GEN-END:variables



//INÍCIO Método para pesquisar Produto por codigo ou produto
    private void pesquisarProduto() {
        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT codigo_produto Código, "
                + "produto Produto,"
                + " estoque Estoque , "
                + "valor Valor_R$ from produtos  "
                + "WHERE  produto  LIKE ? OR codigo_produto LIKE ? ";

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, tPesquisar.getText() + "%");
            stmt.setString(2, tPesquisar.getText() + "%");
            rs = stmt.executeQuery();

            // Usar a biblioteca *rs2xml* para listar dados
            tbProdutos.setModel(DbUtils.resultSetToTableModel(rs));

            tbProdutos.setDefaultEditor(Object.class, null);

            tbProdutos.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbProdutos.getColumnModel().getColumn(1).setPreferredWidth(350);
            tbProdutos.getColumnModel().getColumn(2).setPreferredWidth(20);
            tbProdutos.getColumnModel().getColumn(3).setPreferredWidth(20);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    //FIM Método para pesquisar Produto por codigo ou produto
    
    
    
    // INÍCIO Método para listar produtos na tabela
    private void listarProdutos() {

        java.sql.Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT codigo_produto Código, produto Produto, estoque Estoque , valor Valor_R$ from produtos  ORDER BY produto";
        try {
            stmt = con.prepareStatement(sql);
            rs = rs = stmt.executeQuery();

            tbProdutos.setModel(DbUtils.resultSetToTableModel(rs));

            tbProdutos.setDefaultEditor(Object.class, null);

            tbProdutos.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbProdutos.getColumnModel().getColumn(1).setPreferredWidth(350);
            tbProdutos.getColumnModel().getColumn(2).setPreferredWidth(20);
            tbProdutos.getColumnModel().getColumn(3).setPreferredWidth(20);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    // FIM Método para listar produtos na tabela
    
    
    // INÍCIO Método para setar icon do jFrame
    private void setaricon() {

        //  ImageIcon frameIcon = new ImageIcon("icon.png");
        //this.setIconImage(frameIcon.getImage());
        URL url = this.getClass().getResource("icon.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
    }
    // FIM Método para setar icon do jFrame

}
