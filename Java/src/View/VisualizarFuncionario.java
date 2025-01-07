package View;
import Utils.FuncionarioModel;
import Utils.HttpConnection;
import Utils.Validador;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;



public class VisualizarFuncionario extends javax.swing.JInternalFrame {

    private int idFuncionario;
    private String emailFuncionario;
    
    public VisualizarFuncionario(int idFuncionario, String emailFuncionario) {
        initComponents();
        this.idFuncionario = idFuncionario;
        this.emailFuncionario = emailFuncionario;
        jLCancelarEdicao.setVisible(false);
        System.out.println(this.emailFuncionario);

        // Chama o método para buscar os dados do cliente assim que a tela for criada
        buscarFuncionario();
        
        // Define a operação padrão de fechamento
        setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);

        // Adiciona um listener para o evento de fechamento
        addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent evt) {
                confirmarFechamento(evt);
            }
        });
    }
    
    private void confirmarFechamento(InternalFrameEvent evt) {
        // Verifica se o botão está em modo de edição
        if (jBEditar.getText().equals("Confirmar")) {
            // Define as opções de botão personalizadas
            Object[] options = {"Sim", "Não"};

            // Exibe uma mensagem de confirmação com os botões personalizados
            int resposta = JOptionPane.showOptionDialog(
                this,
                "Você tem certeza que deseja descartar as alterações?",
                "Descartar Alterações",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null, // ícone personalizado, null usa o padrão
                options, // array de botões personalizados
                options[0] // botão padrão
            );

            // Se o usuário escolher "Não", cancela o fechamento
            if (resposta == JOptionPane.CLOSED_OPTION || resposta == 1) {
                return; // Não precisamos fazer nada; o frame não fechará
            }
        }
        // Se "Sim" ou se não estava editando, o frame fechará normalmente
        dispose(); // Ou você pode usar setVisible(false) se preferir
    }
    
    private void buscarFuncionario() {
        // Instância a classe de conexão
        HttpConnection httpConnection = new HttpConnection();

        try {
            // Chama o método para buscar o funcionário pelo ID
            FuncionarioModel funcionarioDTO = httpConnection.buscarFuncionario(this.idFuncionario);

            // Verifica se o funcionário foi encontrado
            if (funcionarioDTO != null) {
                // Exibe o cliente buscado
                jTNome.setText(funcionarioDTO.getNome_funcionario());
                jTCpf.setText(funcionarioDTO.getCpf_funcionario().replaceAll("(\\d{3})(\\.\\d{3}\\.\\d{3}-)(\\d{2})", "***$2**"));
                jTEmail.setText(funcionarioDTO.getEmail());
                jCTipo.setSelectedItem(funcionarioDTO.getTipoFuncionario().substring(0, 1).toUpperCase() + funcionarioDTO.getTipoFuncionario().substring(1).toLowerCase());
            } else {
                // Se o funcionário não foi encontrado, exibe uma mensagem
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
            }
        } catch (Exception e) {
            // Tratamento de possíveis erros ao buscar o funcionário
            JOptionPane.showMessageDialog(null, "Erro ao buscar o funcionário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void desativarEdicao(){
        jTNome.setEnabled(false);
        jTEmail.setEnabled(false);
        jTSenha.setEnabled(false);
        jTConfirmarSenha.setEnabled(false);
        jCTipo.setEnabled(false);
        jBEditar.setText("Editar");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLFuncionario = new javax.swing.JLabel();
        CorrigeBug = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jTSenha = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTConfirmarSenha = new javax.swing.JPasswordField();
        jCTipo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jTEmail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLComputador = new javax.swing.JLabel();
        jLErroConfirmarSenha = new javax.swing.JLabel();
        jLErroNome = new javax.swing.JLabel();
        jLErroCpf = new javax.swing.JLabel();
        jLErroEmail = new javax.swing.JLabel();
        jLErroSenha = new javax.swing.JLabel();
        jBEditar = new javax.swing.JButton();
        jLCancelarEdicao = new javax.swing.JLabel();
        jTCpf = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setTitle("Visualizar Funcionário");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(246, 242, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FuncionarioIcon.png"))); // NOI18N
        jPanel1.add(jLFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        CorrigeBug.setFont(new java.awt.Font("Segoe UI", 0, 3)); // NOI18N
        CorrigeBug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CorrigeBugActionPerformed(evt);
            }
        });
        jPanel1.add(CorrigeBug, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 10, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Nome");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Senha");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("CPF");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jTNome.setBackground(new java.awt.Color(246, 242, 242));
        jTNome.setForeground(new java.awt.Color(51, 51, 51));
        jTNome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTNome.setEnabled(false);
        jTNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTNomeFocusGained(evt);
            }
        });
        jTNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTNomeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTNomeMousePressed(evt);
            }
        });
        jTNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomeActionPerformed(evt);
            }
        });
        jTNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTNomeKeyTyped(evt);
            }
        });
        jPanel1.add(jTNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 330, 30));

        jTSenha.setBackground(new java.awt.Color(246, 242, 242));
        jTSenha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTSenha.setForeground(new java.awt.Color(51, 51, 51));
        jTSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTSenha.setEchoChar('\u25cf');
        jTSenha.setEnabled(false);
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
        jPanel1.add(jTSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 331, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("E-mail");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Tipo");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, -1, 30));

        jTConfirmarSenha.setBackground(new java.awt.Color(246, 242, 242));
        jTConfirmarSenha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTConfirmarSenha.setForeground(new java.awt.Color(51, 51, 51));
        jTConfirmarSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTConfirmarSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTConfirmarSenha.setEchoChar('\u25cf');
        jTConfirmarSenha.setEnabled(false);
        jTConfirmarSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTConfirmarSenhaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTConfirmarSenhaMousePressed(evt);
            }
        });
        jTConfirmarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTConfirmarSenhaActionPerformed(evt);
            }
        });
        jTConfirmarSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTConfirmarSenhaKeyTyped(evt);
            }
        });
        jPanel1.add(jTConfirmarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 331, 30));

        jCTipo.setBackground(new java.awt.Color(0, 0, 0));
        jCTipo.setForeground(new java.awt.Color(243, 243, 243));
        jCTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionario", "Administrador" }));
        jCTipo.setBorder(null);
        jCTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCTipo.setEnabled(false);
        jCTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTipoActionPerformed(evt);
            }
        });
        jPanel1.add(jCTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, -1, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Confirmar senha");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        jTEmail.setBackground(new java.awt.Color(246, 242, 242));
        jTEmail.setForeground(new java.awt.Color(51, 51, 51));
        jTEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTEmail.setEnabled(false);
        jTEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEmailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTEmailMouseEntered(evt);
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTEmailKeyTyped(evt);
            }
        });
        jPanel1.add(jTEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 330, 30));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(243, 243, 243));
        jLabel1.setText("Funcionário");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(243, 243, 243));
        jLabel2.setText("Confira os dados do Funcionário");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLComputador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/PessoasIcon.png"))); // NOI18N
        jPanel3.add(jLComputador, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 90));

        jLErroConfirmarSenha.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroConfirmarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 180, 20));

        jLErroNome.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 180, 20));

        jLErroCpf.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 180, 20));

        jLErroEmail.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 180, 20));

        jLErroSenha.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 180, 20));

        jBEditar.setBackground(new java.awt.Color(0, 0, 0));
        jBEditar.setForeground(new java.awt.Color(243, 243, 243));
        jBEditar.setText("Editar");
        jBEditar.setBorder(null);
        jBEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBEditar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jBEditarFocusGained(evt);
            }
        });
        jBEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBEditarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBEditarMouseReleased(evt);
            }
        });
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });
        jPanel1.add(jBEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 330, 40));

        jLCancelarEdicao.setBackground(new java.awt.Color(0, 0, 0));
        jLCancelarEdicao.setForeground(new java.awt.Color(0, 0, 0));
        jLCancelarEdicao.setText("Cancelar edição?");
        jLCancelarEdicao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLCancelarEdicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCancelarEdicaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLCancelarEdicaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLCancelarEdicaoMouseExited(evt);
            }
        });
        jPanel1.add(jLCancelarEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, 120, 20));

        jTCpf.setBackground(new java.awt.Color(246, 242, 242));
        jTCpf.setForeground(new java.awt.Color(51, 51, 51));
        jTCpf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTCpf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTCpf.setEnabled(false);
        jTCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTCpfMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTCpfMousePressed(evt);
            }
        });
        jTCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCpfActionPerformed(evt);
            }
        });
        jPanel1.add(jTCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 330, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void JTnomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTnomeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTnomeMousePressed

    private void JTnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTnomeActionPerformed

    private void CorrigeBugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorrigeBugActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorrigeBugActionPerformed

    private void JTcpfMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTcpfMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTcpfMousePressed

    private void jTNomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNomeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeMousePressed

    private void jTNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeActionPerformed

    private void jTSenhaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTSenhaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSenhaMousePressed

    private void jTSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSenhaActionPerformed

    private void jTConfirmarSenhaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTConfirmarSenhaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTConfirmarSenhaMousePressed

    private void jTConfirmarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTConfirmarSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTConfirmarSenhaActionPerformed

    private void jCTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTipoActionPerformed

    private void jTEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEmailMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEmailMousePressed

    private void jTEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEmailActionPerformed

    private void jTNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNomeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeKeyTyped

    private void jTEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEmailKeyTyped
        // TODO add your handling code here:
//        Validador validador = new Validador();
//        if (!validador.validarEmail(jTEmail.getText())){
//            jLErroEmail.setText("E-mail inválido.");  
//            this.isValid = false;
//        }else{
//            jLErroEmail.setText("");  
//            this.isValid = true;
//        }
    }//GEN-LAST:event_jTEmailKeyTyped

    private void jTSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSenhaKeyTyped
        // TODO add your handling code here:
//        Validador validador = new Validador();
//        if (!validador.validarSenha(String.valueOf(jTSenha.getPassword()))){
//            jLErroSenha.setText("Senha inválida.");  
//            this.isValid = false;
//        }else{
//            jLErroSenha.setText("");  
//            this.isValid = true;
//        }
    }//GEN-LAST:event_jTSenhaKeyTyped

    private void jTConfirmarSenhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTConfirmarSenhaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTConfirmarSenhaKeyTyped

    private void jTNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNomeMouseClicked
        // TODO add your handling code here:
        jLErroNome.setText("");
    }//GEN-LAST:event_jTNomeMouseClicked

    private void jTEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEmailMouseClicked
        // TODO add your handling code here:
        jLErroEmail.setText("");
    }//GEN-LAST:event_jTEmailMouseClicked

    private void jTSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTSenhaMouseClicked
        // TODO add your handling code here:
        jLErroSenha.setText("");
    }//GEN-LAST:event_jTSenhaMouseClicked

    private void jTConfirmarSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTConfirmarSenhaMouseClicked
        // TODO add your handling code here:
        jLErroConfirmarSenha.setText("");
    }//GEN-LAST:event_jTConfirmarSenhaMouseClicked

    private void jTEmailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEmailMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEmailMouseEntered

    private void jTNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNomeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeFocusGained

    private void jBEditarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBEditarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jBEditarFocusGained

    private void jBEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEditarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBEditarMouseClicked

    private void jBEditarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEditarMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jBEditarMouseReleased

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        if (jBEditar.getText().equals("Editar")) {
            
            // Se o texto for "Editar", habilita o JTextField e muda o texto do botão para "Confirmar"
            jTNome.setEnabled(true);
            jTEmail.setEnabled(true);
            jTSenha.setEnabled(true);
            jTConfirmarSenha.setEnabled(true);
            jCTipo.setEnabled(true);
            jBEditar.setText("Confirmar");
            jLCancelarEdicao.setVisible(true);
        } else if (jBEditar.getText().equals("Confirmar")) {
            Validador validador = new Validador();
            boolean isValid = true; // Inicialmente, assume-se que os dados são válidos

            // Validação do nome
            if (!validador.validarNome(jTNome.getText())) {
                jLErroNome.setText("Nome inválido.");  
                isValid = false; // Falha na validação, marca como inválido
            } else {
                jLErroNome.setText("");  
            }

            // Validação do email
            if (!validador.validarEmail(jTEmail.getText())) {
                jLErroEmail.setText("E-mail inválido.");  
                isValid = false;
            } else {
                jLErroEmail.setText("");
            }

            if(!new String(jTSenha.getPassword()).isEmpty() || !new String(jTConfirmarSenha.getPassword()).isEmpty()){
                // Validação da senha
                if (!validador.validarSenha(new String(jTSenha.getPassword()))) {
                    jLErroSenha.setText("Senha inválida.");
                    isValid = false;
                } else {
                    jLErroSenha.setText("");
                }

                // Comparação de senhas
                if (!new String(jTSenha.getPassword()).equals(new String(jTConfirmarSenha.getPassword()))) {
                    jLErroConfirmarSenha.setText("As senhas devem ser iguais.");
                    isValid = false;
                } else {
                    jLErroConfirmarSenha.setText("");
                }
            }

            // Se todas as validações forem bem-sucedidas, prosseguir com o cadastro
            if (isValid) {
                // Solicitar a senha ao administrador usando JPasswordField
                JPasswordField passwordField = new JPasswordField();
                int option = JOptionPane.showConfirmDialog(null, passwordField, "Senha funcionário:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (option == JOptionPane.OK_OPTION) {
                    // Obtenha a senha digitada
                    String senhaAdm = new String(passwordField.getPassword());

                    // Valida o administrador com a senha fornecida
                    boolean autenticar = validador.validarFuncionario(this.emailFuncionario, senhaAdm);

                    if (autenticar) {
                        String nome = jTNome.getText();
                        String cpf = jTCpf.getText();
                        String email = jTEmail.getText();
                        String genero = jCTipo.getSelectedItem().toString().toUpperCase();
                        String senha = new String(jTSenha.getPassword());

                        // Intância a classe FuncionarioModel de DTO
                        FuncionarioModel funcionarioDTO = new FuncionarioModel();

                        // Seta os dados fornecidos para o FuncionarioModel
                        funcionarioDTO.setNome_funcionario(nome);
                        funcionarioDTO.setCpf_funcionario(cpf);
                        funcionarioDTO.setEmail(email);
                        funcionarioDTO.setTipoFuncionario(genero);
                        funcionarioDTO.setPasswordFuncionario(senha);

                        // Instância a classe ConexaoCi
                        HttpConnection httpConnection = new HttpConnection();

                        // Executa o insert dos dados setados na classe FuncionarioModel ao banco de dados
                        FuncionarioModel response = httpConnection.editarFuncionario(this.idFuncionario, funcionarioDTO);

                        // Verifica se o cadastro foi efetuado com sucesso.
                        if (response != null) {
                            // Se a edição for concedida, exibi um feedback, desativa os campos e altera "Confirmar" para "Editar"
                            JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso.");
                            dispose();
                        } else {
                            System.out.println("response: " + response);
                            JOptionPane.showMessageDialog(null, "ERRO: falha ao tentar editar o funcionário.");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "ERRO: senha incorreta.");
                    }       
                }
            }     
        }
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jLCancelarEdicaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCancelarEdicaoMouseClicked
        // TODO add your handling code here:
        desativarEdicao();
        buscarFuncionario();
        jLCancelarEdicao.setVisible(false);
    }//GEN-LAST:event_jLCancelarEdicaoMouseClicked

    private void jLCancelarEdicaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCancelarEdicaoMouseEntered
        // TODO add your handling code here:
        jLCancelarEdicao.setForeground(new java.awt.Color(255,110,110));
    }//GEN-LAST:event_jLCancelarEdicaoMouseEntered

    private void jLCancelarEdicaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCancelarEdicaoMouseExited
        // TODO add your handling code here:
        jLCancelarEdicao.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLCancelarEdicaoMouseExited

    private void jTCpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCpfMouseClicked
        // TODO add your handling code here:
        jLErroCpf.setText("");
    }//GEN-LAST:event_jTCpfMouseClicked

    private void jTCpfMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCpfMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCpfMousePressed

    private void jTCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCpfActionPerformed

    private void jBEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEditarMouseEntered
        // TODO add your handling code here:
        jBEditar.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBEditarMouseEntered

    private void jBEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEditarMouseExited
        // TODO add your handling code here:
        jBEditar.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBEditarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CorrigeBug;
    private javax.swing.JButton jBEditar;
    private javax.swing.JComboBox<String> jCTipo;
    private javax.swing.JLabel jLCancelarEdicao;
    private javax.swing.JLabel jLComputador;
    private javax.swing.JLabel jLErroConfirmarSenha;
    private javax.swing.JLabel jLErroCpf;
    private javax.swing.JLabel jLErroEmail;
    private javax.swing.JLabel jLErroNome;
    private javax.swing.JLabel jLErroSenha;
    private javax.swing.JLabel jLFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jTConfirmarSenha;
    private javax.swing.JTextField jTCpf;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTNome;
    private javax.swing.JPasswordField jTSenha;
    // End of variables declaration//GEN-END:variables
}
