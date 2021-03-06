
import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author johannesriedmueller
 */
public class MiniExplorerGUI extends javax.swing.JFrame {

    private FileModel bl = new FileModel();

    public MiniExplorerGUI() {
        initComponents();
        liAll.setModel(bl);
        liAll.setCellRenderer(new FileListRenderer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        liAll = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        liAll.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        liAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onChangeDir(evt);
            }
        });
        jScrollPane1.setViewportView(liAll);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void onChangeDir(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onChangeDir
        if (evt.getClickCount() == 2) {
            String path = bl.getElementAt(liAll.getSelectedIndex()).getAbsolutePath();
            File currDirUpdate = new File(path);
            if (currDirUpdate.isFile()) {
                try{
                if(!Desktop.isDesktopSupported()){
                    
                }
                else{
                    Desktop desktop = Desktop.getDesktop();
                    if(currDirUpdate.exists()){
                        desktop.open(currDirUpdate);
                    }
                }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"File cannot be opened!");
                }
            } else {
                bl.deleteAll();
                bl.add(currDirUpdate.getAbsolutePath() + "/..");
                for (File file : currDirUpdate.listFiles()) {
                    bl.add(file.getAbsolutePath());
                }
            }
        }

    }//GEN-LAST:event_onChangeDir

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        File currDir = new File(".");
        bl.add(currDir.getAbsolutePath() + "/..");
        for (File file : currDir.listFiles()) {
            bl.add(file.getAbsolutePath());
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(MiniExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiniExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiniExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiniExplorerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniExplorerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<myFile> liAll;
    // End of variables declaration//GEN-END:variables
}
