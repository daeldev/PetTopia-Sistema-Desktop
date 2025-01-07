package View;
import Utils.ClienteModel;
import Utils.HttpConnection;
import Utils.Validador;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class VisualizarCliente extends javax.swing.JInternalFrame {
    private final int idCliente;
    private final String emailFuncionario;
    private final String funcao;
    
    public VisualizarCliente(int idCliente, String emailFuncionario, String funcao) {
        initComponents();
        this.idCliente = idCliente;
        this.emailFuncionario = emailFuncionario;
        this.funcao = funcao;
        jLCancelarEdicao.setVisible(false);

        // Chama o método para buscar os dados do cliente assim que a tela for criada
        buscarCliente();
        
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

    private void buscarCliente() {
        // Instância a classe de conexão
        HttpConnection httpConnection = new HttpConnection();

        try {
            // Chama o método para buscar o cliente pelo ID
            ClienteModel clienteDTO = httpConnection.buscarCliente(this.idCliente);

            // Verifica se o cliente foi encontrado
            if (clienteDTO != null) {
                // Exibe o cliente buscado
                jTNome.setText(clienteDTO.getNome());
                jTCpf.setText(clienteDTO.getCpf().replaceAll("(\\d{3})(\\.\\d{3}\\.\\d{3}-)(\\d{2})", "***$2**"));
                
                // Formatar o LocalDate para o formato brasileiro sem barras
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                String dataBrasileira = clienteDTO.getData_nascimento().format(formatter);
                jTDataNascimento.setText(dataBrasileira);

                jCGenero.setSelectedItem(clienteDTO.getGeneroCliente().substring(0, 1).toUpperCase() + clienteDTO.getGeneroCliente().substring(1).toLowerCase());
                jTTelefone.setText(clienteDTO.getTelefone());
                jTEmail.setText(clienteDTO.getEmail());
            } else {
                // Se o cliente não foi encontrado, exibe uma mensagem
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            }
        } catch (Exception e) {
            // Tratamento de possíveis erros ao buscar o cliente
            JOptionPane.showMessageDialog(null, "Erro ao buscar o cliente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLFuncionario = new javax.swing.JLabel();
        CorrigeBug = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jBEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLComputador = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLCancelarEdicao = new javax.swing.JLabel();
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
        jTCpf = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setTitle("Visualizar Cliente");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(246, 242, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FuncionarioIcon.png"))); // NOI18N
        jPanel1.add(jLFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

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
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 20));

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
        jPanel1.add(jBEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 330, 40));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(243, 243, 243));
        jLabel1.setText("Cliente");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        jLComputador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/PessoasIcon.png"))); // NOI18N
        jPanel3.add(jLComputador, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(243, 243, 243));
        jLabel2.setText("Confira os dados do cliente");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 810, 90));

        jLCancelarEdicao.setBackground(new java.awt.Color(0, 0, 0));
        jLCancelarEdicao.setForeground(new java.awt.Color(0, 0, 0));
        jLCancelarEdicao.setText(" ");
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
        jPanel1.add(jLCancelarEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 90, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("CPF");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jTNome.setBackground(new java.awt.Color(246, 242, 242));
        jTNome.setForeground(new java.awt.Color(51, 51, 51));
        jTNome.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTNome.setEnabled(false);
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
        jPanel1.add(jTNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 330, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("E-mail");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Gênero");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, 30));

        jCGenero.setBackground(new java.awt.Color(0, 0, 0));
        jCGenero.setForeground(new java.awt.Color(243, 243, 243));
        jCGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outros" }));
        jCGenero.setBorder(null);
        jCGenero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCGenero.setEnabled(false);
        jCGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCGeneroActionPerformed(evt);
            }
        });
        jPanel1.add(jCGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, -1, 30));

        jTEmail.setBackground(new java.awt.Color(246, 242, 242));
        jTEmail.setForeground(new java.awt.Color(51, 51, 51));
        jTEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTEmail.setEnabled(false);
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
        jPanel1.add(jTEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 330, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Data de nascimento");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

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
        jTTelefone.setEnabled(false);
        jTTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTelefoneMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTTelefoneMousePressed(evt);
            }
        });
        jPanel1.add(jTTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 330, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Telefone");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

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
        jTDataNascimento.setEnabled(false);
        jTDataNascimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDataNascimentoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTDataNascimentoMousePressed(evt);
            }
        });
        jPanel1.add(jTDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 330, 30));

        jLErroNome.setForeground(new java.awt.Color(255, 110, 110));
        jLErroNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLErroNomeMouseEntered(evt);
            }
        });
        jPanel1.add(jLErroNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 180, 20));

        jLErroCpf.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 180, 20));

        jLErroDataNascimento.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 180, 20));

        jLErroTelefone.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 180, 20));

        jLErroEmail.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 180, 20));

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
        jPanel1.add(jTCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 330, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 810, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void desativarEdicao(){
        jTNome.setEnabled(false);
        jTDataNascimento.setEnabled(false);
        jTTelefone.setEnabled(false);
        jCGenero.setEnabled(false);
        jTEmail.setEnabled(false);
        jBEditar.setText("Editar");
    }
    
    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        if (jBEditar.getText().equals("Editar")) {
            // Se o texto for "Editar", habilita o JTextField e muda o texto do botão para "Confirmar"
            
            if (this.funcao.equals("ADMINISTRADOR")) {
                jTNome.setEnabled(true);
                jTDataNascimento.setEnabled(true);
            }
            
            jTTelefone.setEnabled(true);
            jCGenero.setEnabled(true);
            jTEmail.setEnabled(true);
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

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate dataConvertida = LocalDate.parse(jTDataNascimento.getText(), formatter);

                        String genero = jCGenero.getSelectedItem().toString().toUpperCase();
                        String telefone = jTTelefone.getText();
                        String email = jTEmail.getText();

                        // Instancia a classe ClienteModel de DTO
                        ClienteModel clienteDTO = new ClienteModel();

                        // Seta os dados fornecidos para o ClienteModel
                        clienteDTO.setNome(nome);
                        clienteDTO.setCpf(cpf);
                        clienteDTO.setData_nascimento(dataConvertida);         
                        clienteDTO.setGeneroCliente(genero);
                        clienteDTO.setTelefone(telefone);
                        clienteDTO.setEmail(email);

                        // Instância a classe HttpConnection
                        HttpConnection httpConnection = new HttpConnection();

                        // Executa o insert dos dados setados na classe clienteDTO ao banco de dados através do clienteDAO
                        ClienteModel response = httpConnection.editarCliente(this.idCliente, clienteDTO);

                        // Verifica se a edição foi efetuada com sucesso.
                        if (response != null) {
                            // Se a edição for concedida, exibi um feedback, desativa os campos e altera "Confirmar" para "Editar"
                            JOptionPane.showMessageDialog(null, "Cliente editado com sucesso.");
                            desativarEdicao();
                        } else {
                            System.out.println("response: " + response);
                            JOptionPane.showMessageDialog(null, "ERRO: falha ao tentar editar o cliente.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ERRO: senha incorreta.");
                    }
                }
            }
        }
    }//GEN-LAST:event_jBEditarActionPerformed

    private void JTnomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTnomeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTnomeMousePressed

    private void JTnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTnomeActionPerformed

    private void jBEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEditarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBEditarMouseClicked

    private void jBEditarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEditarMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jBEditarMouseReleased

    private void CorrigeBugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CorrigeBugActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CorrigeBugActionPerformed

    private void jBEditarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBEditarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jBEditarFocusGained

    private void JTcpfMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTcpfMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTcpfMousePressed

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

    private void jTCpfMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCpfMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCpfMousePressed

    private void jTCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCpfActionPerformed

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

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosed

    private void jLCancelarEdicaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCancelarEdicaoMouseClicked
        // TODO add your handling code here:
        desativarEdicao();
        buscarCliente();
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

    private void jLErroNomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroNomeMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLErroNomeMouseEntered

    private void jBEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEditarMouseEntered
        // TODO add your handling code here:
        jBEditar.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBEditarMouseEntered

    private void jBEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEditarMouseExited
        // TODO add your handling code here:
        jBEditar.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBEditarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CorrigeBug;
    private javax.swing.JButton jBEditar;
    private javax.swing.JComboBox<String> jCGenero;
    private javax.swing.JLabel jLCancelarEdicao;
    private javax.swing.JLabel jLComputador;
    private javax.swing.JLabel jLErroCpf;
    private javax.swing.JLabel jLErroDataNascimento;
    private javax.swing.JLabel jLErroEmail;
    private javax.swing.JLabel jLErroNome;
    private javax.swing.JLabel jLErroTelefone;
    private javax.swing.JLabel jLFuncionario;
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
    private javax.swing.JTextField jTCpf;
    private javax.swing.JFormattedTextField jTDataNascimento;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTNome;
    private javax.swing.JFormattedTextField jTTelefone;
    // End of variables declaration//GEN-END:variables
}

