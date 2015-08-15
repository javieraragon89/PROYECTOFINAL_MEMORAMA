package memorama;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Ernesto
 */
public class memorama extends javax.swing.JFrame {

    private ImageIcon imgs[];
    private JButton btns[][];
    private int ma[][];
    private int mr[][];
    private boolean uno;
    private JButton tmp;
    private int p1,p2;

    public memorama() {
        initComponents();
        imgs = new ImageIcon[11];
        imgs[0] = new ImageIcon(getClass().getResource("/memorama/1.png"));
        imgs[1] = new ImageIcon(getClass().getResource("/memorama/2.png"));
        imgs[2] = new ImageIcon(getClass().getResource("/memorama/3.png"));
        imgs[3] = new ImageIcon(getClass().getResource("/memorama/4.png"));
        imgs[4] = new ImageIcon(getClass().getResource("/memorama/5.png"));
        imgs[5] = new ImageIcon(getClass().getResource("/memorama/6.png"));
        imgs[6] = new ImageIcon(getClass().getResource("/memorama/7.png"));
        imgs[7] = new ImageIcon(getClass().getResource("/memorama/8.png"));
        imgs[8] = new ImageIcon(getClass().getResource("/memorama/0.png"));

        btns = new JButton[4][4];
        btns[0][0] = bt1;
        btns[0][1] = bt2;
        btns[0][2] = bt3;
        btns[0][3] = bt4;


        btns[1][0] = bt6;
        btns[1][1] = bt7;
        btns[1][2] = bt8;
        btns[1][3] = bt9;


        btns[2][0] = bt11;
        btns[2][1] = bt12;
        btns[2][2] = bt13;
        btns[2][3] = bt14;


        btns[3][0] = bt16;
        btns[3][1] = bt17;
        btns[3][2] = bt18;
        btns[3][3] = bt19;


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                btns[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        voltear(e);
                    }
                });
            }
        }
        iniciar();
    }

    private void iniciar(){
        ma = new int[4][4];
        mr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ma[i][j] = -1;
                mr[i][j] = 0;
                btns[i][j].setEnabled(true);
                btns[i][j].setIcon(imgs[8]);
            }
        }

        for (int i = 0; i < 8; i++) {
            boolean existe = true;
            while(existe){
                int x = (int)Math.floor(Math.random()*(0-(3+1))+(3+1));
                int y = (int)Math.floor(Math.random()*(0-(3+1))+(3+1));
                if(ma[x][y] == -1){
                    ma[x][y] = i;
                    existe = false;
                }
            }
            existe = true;
            while(existe){
                int x = (int)Math.floor(Math.random()*(0-(3+1))+(3+1));
                int y = (int)Math.floor(Math.random()*(0-(3+1))+(3+1));
                if(ma[x][y] == -1){
                    ma[x][y] = i;
                    existe = false;
                }
            }
        }

        uno = false;
    }

    private void voltear(ActionEvent e) {
        JButton bt = (JButton)e.getSource();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(bt == btns[i][j]){
                    if(mr[i][j] == 1){
                        return;
                    }


                    if(uno){
                        if(tmp == bt)return;
                        if(ma[i][j] == ma[p1][p2]){
                            mr[i][j] = 1;
                            mr[p1][p2] = 1;
                            bt.setIcon(imgs[ma[i][j]]);
                            bt.setEnabled(false);
                            tmp.setEnabled(false);
                            for (int k = 0; k < 4; k++) {
                                for (int l = 0; l < 4; l++) {
                                    if(mr[k][l] == 0){
                                        uno = false;
                                        return;
                                    }
                                }
                            }
                            JOptionPane.showMessageDialog(this, "FELICIDADES!!");
                            iniciar();
                        }else{
                            ImageIcon im = imgs[ma[i][j]];
                            Thread hilo = new Thread(){
                                @Override
                                public synchronized void run(){
                                    try {
                                        bt.setIcon(im);
                                        sleep(300);
                                        bt.setIcon(imgs[8]);
                                        tmp.setIcon(imgs[8]);
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            };
                            hilo.start();
                            jPanel1.setEnabled(false);
                        }
                        uno = false;
                    }else{
                        tmp = bt;
                        p1 = i;
                        p2 = j;
                        uno = true;
                        bt.setIcon(imgs[ma[i][j]]);
                    }
                    break;
                }
            }
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

        jPanel1 = new javax.swing.JPanel();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        bt7 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        bt11 = new javax.swing.JButton();
        bt12 = new javax.swing.JButton();
        bt13 = new javax.swing.JButton();
        bt14 = new javax.swing.JButton();
        bt16 = new javax.swing.JButton();
        bt17 = new javax.swing.JButton();
        bt18 = new javax.swing.JButton();
        bt19 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MEMORAMA");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });

        bt2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        bt19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memorama/0.png")));

        jButton1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jButton1.setText("Reiniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt11, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt14, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bt16, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt17, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt18, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt19, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jButton1)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt4)
                    .addComponent(bt3)
                    .addComponent(bt2)
                    .addComponent(bt1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt6)
                    .addComponent(bt7)
                    .addComponent(bt8)
                    .addComponent(bt9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bt11)
                    .addComponent(bt12)
                    .addComponent(bt13)
                    .addComponent(bt14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt16)
                    .addComponent(bt17)
                    .addComponent(bt18)
                    .addComponent(bt19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        iniciar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt1ActionPerformed

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
            java.util.logging.Logger.getLogger(memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(memorama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new memorama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt11;
    private javax.swing.JButton bt12;
    private javax.swing.JButton bt13;
    private javax.swing.JButton bt14;
    private javax.swing.JButton bt16;
    private javax.swing.JButton bt17;
    private javax.swing.JButton bt18;
    private javax.swing.JButton bt19;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt6;
    private javax.swing.JButton bt7;
    private javax.swing.JButton bt8;
    private javax.swing.JButton bt9;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
