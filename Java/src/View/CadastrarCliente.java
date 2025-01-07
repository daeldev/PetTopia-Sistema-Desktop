package View;
import Utils.ClienteModel;
import Utils.HttpConnection;
import Utils.Validador;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;



public class CadastrarCliente extends javax.swing.JInternalFrame {

    private final JDesktopPane dashboardFuncionario;
    public CadastrarCliente(JDesktopPane dashboardFuncionario) {
        initComponents();
        this.dashboardFuncionario = dashboardFuncionario;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLFuncionario = new javax.swing.JLabel();
        CorrigeBug = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jBCadastrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLComputador = new javax.swing.JLabel();
        jTCpf = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCGenero = new javax.swing.JComboBox<>();
        jTEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTTelefone = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jTDataNascimento = new javax.swing.JFormattedTextField();
        jLErroNome = new javax.swing.JLabel();
        jLErroCpf = new javax.swing.JLabel();
        jLErroDataNascimento = new javax.swing.JLabel();
        jLErroTelefone = new javax.swing.JLabel();
        jLErroEmail = new javax.swing.JLabel();
        jLInfo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setTitle("Cadastrar Cliente");
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
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 20));

        jBCadastrar.setBackground(new java.awt.Color(0, 0, 0));
        jBCadastrar.setForeground(new java.awt.Color(243, 243, 243));
        jBCadastrar.setText("Cadastrar");
        jBCadastrar.setBorder(null);
        jBCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBCadastrar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jBCadastrarFocusGained(evt);
            }
        });
        jBCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBCadastrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBCadastrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBCadastrarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBCadastrarMouseReleased(evt);
            }
        });
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(jBCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 330, 40));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(243, 243, 243));
        jLabel1.setText("Cliente");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(243, 243, 243));
        jLabel2.setText("Preencha os dados do cliente");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLComputador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/PessoasIcon.png"))); // NOI18N
        jPanel3.add(jLComputador, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 90));

        jTCpf.setBackground(new java.awt.Color(246, 242, 242));
        jTCpf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTCpf.setForeground(new java.awt.Color(51, 51, 51));
        try {
            jTCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTCpf.setToolTipText("");
        jTCpf.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTCpfMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTCpfMousePressed(evt);
            }
        });
        jPanel1.add(jTCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 330, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("CPF");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jTNome.setBackground(new java.awt.Color(246, 242, 242));
        jTNome.setForeground(new java.awt.Color(51, 51, 51));
        jTNome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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
        jPanel1.add(jTNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 330, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("E-mail");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Gênero");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, -1, 30));

        jCGenero.setBackground(new java.awt.Color(0, 0, 0));
        jCGenero.setForeground(new java.awt.Color(243, 243, 243));
        jCGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outros" }));
        jCGenero.setBorder(null);
        jCGenero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCGeneroActionPerformed(evt);
            }
        });
        jPanel1.add(jCGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, -1, 30));

        jTEmail.setBackground(new java.awt.Color(246, 242, 242));
        jTEmail.setForeground(new java.awt.Color(51, 51, 51));
        jTEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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
        jPanel1.add(jTEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 330, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Data de nascimento");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jTTelefone.setBackground(new java.awt.Color(246, 242, 242));
        jTTelefone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTTelefone.setForeground(new java.awt.Color(51, 51, 51));
        try {
            jTTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTTelefone.setToolTipText("");
        jTTelefone.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTelefoneMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTTelefoneMousePressed(evt);
            }
        });
        jPanel1.add(jTTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 330, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Telefone");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        jTDataNascimento.setBackground(new java.awt.Color(246, 242, 242));
        jTDataNascimento.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTDataNascimento.setForeground(new java.awt.Color(51, 51, 51));
        try {
            jTDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTDataNascimento.setText("2 /  /    ");
        jTDataNascimento.setToolTipText("");
        jTDataNascimento.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTDataNascimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDataNascimentoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTDataNascimentoMousePressed(evt);
            }
        });
        jPanel1.add(jTDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 330, 30));

        jLErroNome.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 180, 20));

        jLErroCpf.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 180, 20));

        jLErroDataNascimento.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 240, 20));

        jLErroTelefone.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 180, 20));

        jLErroEmail.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 180, 20));

        jLInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/InfoIcon.png"))); // NOI18N
        jLInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLInfoMouseEntered(evt);
            }
        });
        jPanel1.add(jLInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 110, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        Validador validador = new Validador();
        boolean isValid = true; // Inicialmente, assume-se que os dados são válidos

        // Validação do nome
        if (!validador.validarNome(jTNome.getText())) {
            jLErroNome.setText("Nome inválido.");  
            isValid = false; // Falha na validação, marca como inválido
        } else {
            jLErroNome.setText("");  
        }

        // Validação do CPF
        if (!validador.validarCpf(jTCpf.getText())) {
            jLErroCpf.setText("CPF inválido.");  
            isValid = false;
        } else {
            jLErroCpf.setText("");
        }
        
        // Validação da data de nascimento
        if (!validador.validarDataNascimento(jTDataNascimento.getText())) {
            jLErroDataNascimento.setText("Data de nascimento inválida.");  
            isValid = false;
        } else {
            jLErroDataNascimento.setText("");
        }
        
        // Validação do telefone
        if (!validador.validarTelefone(jTTelefone.getText())) {
            jLErroTelefone.setText("Telefone inválido.");  
            isValid = false;
        } else {
            jLErroTelefone.setText("");
        }

        // Validação do email
        if (!jTEmail.getText().isEmpty()){
            if (!validador.validarEmail(jTEmail.getText())) {
                jLErroEmail.setText("E-mail inválido.");  
                isValid = false;
            } else {
                jLErroEmail.setText("");
            }
        }
        
        if (isValid) {
            String nome = jTNome.getText();
            String cpf = jTCpf.getText();
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(jTDataNascimento.getText().trim(), formatter);
            
            String genero = jCGenero.getSelectedItem().toString().toUpperCase();
            String telefone = jTTelefone.getText();
            String email = jTEmail.getText();
            
            // Instancia a classe ClienteModel de DTO
            ClienteModel clienteDTO = new ClienteModel();
            
            // Seta os dados fornecidos para o ClienteModel
            clienteDTO.setNome(nome);
            clienteDTO.setCpf(cpf);
            clienteDTO.setData_nascimento(data);         
            clienteDTO.setGeneroCliente(genero);
            clienteDTO.setTelefone(telefone);
            clienteDTO.setEmail(email);

            // Instância a classe HttpConnection
            HttpConnection httpConnection = new HttpConnection();

            // Executa o insert dos dados setados na classe clienteDTO ao banco de dados através do clienteDAO
            ClienteModel response = httpConnection.cadastrarCliente(clienteDTO);

            // Verifica se o cadastro foi efetuado com sucesso.
            if (response != null) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");
                dispose(); // Fecha a janela
            } else {
                System.out.println("response: " + response);
                JOptionPane.showMessageDialog(null, "ERRO: falha ao tentar cadastrar o cliente.");
            }
        }
    }//GEN-LAST:event_jBCadastrarActionPerformed

    private void JTnomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTnomeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTnomeMousePressed

    private void JTnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTnomeActionPerformed

    private void jBCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCadastrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCadastrarMouseClicked

    private void jBCadastrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCadastrarMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jBCadastrarMouseReleased

    private void CorrigeBugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorrigeBugActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorrigeBugActionPerformed

    private void jBCadastrarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBCadastrarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCadastrarFocusGained

    private void JTcpfMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTcpfMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTcpfMousePressed

    private void jTCpfMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCpfMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCpfMousePressed

    private void jTNomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNomeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeMousePressed

    private void jTNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeActionPerformed

    private void jTEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEmailMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEmailMousePressed

    private void jTEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEmailActionPerformed

    private void jTTelefoneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTelefoneMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTelefoneMousePressed

    private void jCGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCGeneroActionPerformed

    private void jTDataNascimentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDataNascimentoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDataNascimentoMousePressed

    private void jTNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNomeMouseClicked
        // TODO add your handling code here:
        jLErroNome.setText("");
    }//GEN-LAST:event_jTNomeMouseClicked

    private void jTCpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCpfMouseClicked
        // TODO add your handling code here:
        jLErroCpf.setText("");
    }//GEN-LAST:event_jTCpfMouseClicked

    private void jTDataNascimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDataNascimentoMouseClicked
        // TODO add your handling code here:
        jLErroDataNascimento.setText("");
    }//GEN-LAST:event_jTDataNascimentoMouseClicked

    private void jTTelefoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTelefoneMouseClicked
        // TODO add your handling code here:
        jLErroTelefone.setText("");
    }//GEN-LAST:event_jTTelefoneMouseClicked

    private void jTEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEmailMouseClicked
        // TODO add your handling code here:
        jLErroEmail.setText("");
    }//GEN-LAST:event_jTEmailMouseClicked

    private void jLInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLInfoMouseClicked
        // TODO add your handling code here:
        // Exibe uma caixa de diálogo com a explicação sobre o cadastro de cliente
        String mensagem = "O cadastro de cliente é necessário para registrar informações de contato e acompanhar os pedidos de denúncias, doações e adoções.\n\n"
                + "O e-mail é opcional, mas, se fornecido, será utilizado para enviar atualizações sobre o status desses pedidos.";

        // Mostra a caixa de mensagem com as informações detalhadas
        JOptionPane.showMessageDialog(null, mensagem, "Informações sobre Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLInfoMouseClicked

    private void jLInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLInfoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLInfoMouseEntered

    private void jBCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCadastrarMouseEntered
        // TODO add your handling code here:
        jBCadastrar.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBCadastrarMouseEntered

    private void jBCadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCadastrarMouseExited
        // TODO add your handling code here:
        jBCadastrar.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBCadastrarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CorrigeBug;
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JComboBox<String> jCGenero;
    private javax.swing.JLabel jLComputador;
    private javax.swing.JLabel jLErroCpf;
    private javax.swing.JLabel jLErroDataNascimento;
    private javax.swing.JLabel jLErroEmail;
    private javax.swing.JLabel jLErroNome;
    private javax.swing.JLabel jLErroTelefone;
    private javax.swing.JLabel jLFuncionario;
    private javax.swing.JLabel jLInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JFormattedTextField jTCpf;
    private javax.swing.JFormattedTextField jTDataNascimento;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTNome;
    private javax.swing.JFormattedTextField jTTelefone;
    // End of variables declaration//GEN-END:variables
}
