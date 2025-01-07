package View;

import Utils.FuncionarioModel;
import Utils.HttpConnection;


public class Login extends javax.swing.JFrame {
    
    public Login() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLFuncionario = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLComputador = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jBEntrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTSenha = new javax.swing.JPasswordField();
        jTEmail = new javax.swing.JTextField();
        jCMostrarSenha = new javax.swing.JCheckBox();
        jLErroLogin = new javax.swing.JLabel();
        jLFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(243, 243, 243));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FuncionarioIcon.png"))); // NOI18N
        jPanel2.add(jLFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel1.setBackground(new java.awt.Color(229, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(243, 243, 243));
        jLabel1.setText("Bem-vindo!");

        jLComputador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/PessoasIcon.png"))); // NOI18N
        jLComputador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLComputadorMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(229, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(243, 243, 243));
        jLabel2.setText("Efetue o seu login");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jLComputador)
                .addGap(64, 64, 64))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLComputador)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 100));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Senha");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jBEntrar.setBackground(new java.awt.Color(0, 0, 0));
        jBEntrar.setForeground(new java.awt.Color(239, 239, 239));
        jBEntrar.setText("Entrar");
        jBEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntrarActionPerformed(evt);
            }
        });
        jPanel2.add(jBEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 330, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("E-mail");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jTSenha.setBackground(new java.awt.Color(246, 242, 242));
        jTSenha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTSenha.setForeground(new java.awt.Color(51, 51, 51));
        jTSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTSenha.setEchoChar('\u25cf');
        jTSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTSenhaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTSenhaMousePressed(evt);
            }
        });
        jTSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTSenhaActionPerformed(evt);
            }
        });
        jTSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTSenhaKeyTyped(evt);
            }
        });
        jPanel2.add(jTSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 331, 30));

        jTEmail.setBackground(new java.awt.Color(246, 242, 242));
        jTEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTEmail.setForeground(new java.awt.Color(51, 51, 51));
        jTEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEmailMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTEmailMousePressed(evt);
            }
        });
        jTEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEmailActionPerformed(evt);
            }
        });
        jTEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTEmailKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTEmailKeyTyped(evt);
            }
        });
        jPanel2.add(jTEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 334, 30));

        jCMostrarSenha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCMostrarSenha.setForeground(new java.awt.Color(51, 51, 51));
        jCMostrarSenha.setText("Mostrar senha");
        jCMostrarSenha.setBorder(null);
        jCMostrarSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCMostrarSenha.setFocusable(false);
        jCMostrarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCMostrarSenhaActionPerformed(evt);
            }
        });
        jPanel2.add(jCMostrarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLErroLogin.setForeground(new java.awt.Color(255, 110, 110));
        jPanel2.add(jLErroLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 260, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 400, 430));

        jLFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FundoLogin.png"))); // NOI18N
        jPanel1.add(jLFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTemailActionPerformed

    private void jBEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntrarActionPerformed
        String email = jTEmail.getText();
        String senha = new String(jTSenha.getPassword());

        // Cria um DTO para enviar as credenciais
        FuncionarioModel funcionarioDTO = new FuncionarioModel();
        funcionarioDTO.setEmail(email);
        funcionarioDTO.setPasswordFuncionario(senha);

        // Instancia o cliente de login
        HttpConnection httpConnection = new HttpConnection();

        // Chama o método de login
        FuncionarioModel response = httpConnection.login(funcionarioDTO);

        if (response != null) {

            // Verifica se o tipo de funcionário e exibi a workspace correspondente
            switch (response.getTipoFuncionario()) {
            case "ADMINISTRADOR":
                DashboardAdministrador dashboardAdministrador = new DashboardAdministrador();
                dashboardAdministrador.dadosAdministrador(response.getNome_funcionario(),response.getEmail(), response.getTipoFuncionario());
                dashboardAdministrador.setVisible(true);
                dispose();
                break;
            case "FUNCIONARIO":
                DashboardFuncionario dashboardFuncionario = new DashboardFuncionario();
                dashboardFuncionario.dadosFuncionario(response.getNome_funcionario(),response.getEmail(), response.getTipoFuncionario());
                dashboardFuncionario.setVisible(true);
                dispose();
                break;
            default:
                System.out.println("Tipo de funcionário desconhecido.");
                break;
            }
        } else {
            System.out.print("response " + response);
            jLErroLogin.setText("E-mail ou senha incorretos.");     
        }     
    }//GEN-LAST:event_jBEntrarActionPerformed
    
    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void jTpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTpasswordActionPerformed

    private void jTemailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTemailMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTemailMousePressed

    private void jTpasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTpasswordMousePressed
        // TODO add your handling code here:  
    }//GEN-LAST:event_jTpasswordMousePressed

    private void jCMostrarpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCMostrarpasswordActionPerformed
        // TODO add your handling code here:      
        
    }//GEN-LAST:event_jCMostrarpasswordActionPerformed

    private void jTSenhaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTSenhaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSenhaMousePressed

    private void jTSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSenhaActionPerformed

    private void jTEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEmailMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEmailMousePressed

    private void jTEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEmailActionPerformed

    private void jCMostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCMostrarSenhaActionPerformed
        // TODO add your handling code here:
        if (jCMostrarSenha.isSelected()){
            jTSenha.setEchoChar((char)0);
        }
        if (!jCMostrarSenha.isSelected()){
            jTSenha.setEchoChar('\u25cf');
        }
    }//GEN-LAST:event_jCMostrarSenhaActionPerformed

    private void jTEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEmailMouseClicked
        // TODO add your handling code here:
        jLErroLogin.setText("");
    }//GEN-LAST:event_jTEmailMouseClicked

    private void jTSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTSenhaMouseClicked
        // TODO add your handling code here:
        jLErroLogin.setText("");
    }//GEN-LAST:event_jTSenhaMouseClicked

    private void jTEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEmailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEmailKeyTyped

    private void jTEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEmailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEmailKeyReleased

    private void jTSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSenhaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSenhaKeyTyped

    private void jLComputadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLComputadorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLComputadorMouseClicked

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEntrar;
    private javax.swing.JCheckBox jCMostrarSenha;
    private javax.swing.JLabel jLComputador;
    private javax.swing.JLabel jLErroLogin;
    private javax.swing.JLabel jLFuncionario;
    private javax.swing.JLabel jLFundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JPasswordField jTSenha;
    // End of variables declaration//GEN-END:variables
}
