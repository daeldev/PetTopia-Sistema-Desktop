package View;
import Utils.AnimalModel;
import Utils.ClienteModel;
import Utils.ComprovanteRendaModel;
import Utils.HttpConnection;
import Utils.Validador;
import java.awt.Cursor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CadastrarAdocao extends javax.swing.JInternalFrame {

    private final JDesktopPane dashboard;
    private ClienteModel clienteDTO;
    private AnimalModel animalDTO;
    private final String emailFuncionario;
    private final String funcao;
    private byte[] comprovanteRenda;  // Variável para armazenar o arquivo como byte[]
    
    public CadastrarAdocao(JDesktopPane dashboard, String emailFuncionario, String funcao) {
        initComponents();
        this.dashboard = dashboard;
        // Inicializa o clienteDTO no construtor
        clienteDTO = new ClienteModel();
        animalDTO = new AnimalModel();
        
        this.emailFuncionario = emailFuncionario;
        
        this.funcao = funcao;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLFuncionario = new javax.swing.JLabel();
        CorrigeBug = new javax.swing.JTextField();
        jBCadastrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLComputador = new javax.swing.JLabel();
        jTNomeCliente = new javax.swing.JTextField();
        jBProcurarCliente = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLClienteNaoCadastrado = new javax.swing.JLabel();
        jLErroCliente = new javax.swing.JLabel();
        jTNomeAnimal = new javax.swing.JTextField();
        jBProcurarAnimal = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLAnimalNaoCadastrado = new javax.swing.JLabel();
        jBUpload = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLErroAnimal = new javax.swing.JLabel();
        jLInfo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setTitle("Cadastrar Pedido de Adoção");
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

        jBCadastrar.setBackground(new java.awt.Color(0, 0, 0));
        jBCadastrar.setForeground(new java.awt.Color(243, 243, 243));
        jBCadastrar.setText("Confirmar");
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
        jPanel1.add(jBCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 340, 40));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(243, 243, 243));
        jLabel1.setText("Adoção");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(243, 243, 243));
        jLabel2.setText("Preencha os dados do pedido de adoção");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLComputador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/DoacaoIcon.png"))); // NOI18N
        jPanel3.add(jLComputador, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 40, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 420, 90));

        jTNomeCliente.setBackground(new java.awt.Color(246, 242, 242));
        jTNomeCliente.setForeground(new java.awt.Color(51, 51, 51));
        jTNomeCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTNomeCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTNomeCliente.setEnabled(false);
        jTNomeCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTNomeClienteMousePressed(evt);
            }
        });
        jTNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomeClienteActionPerformed(evt);
            }
        });
        jPanel1.add(jTNomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 230, 30));

        jBProcurarCliente.setBackground(new java.awt.Color(0, 0, 0));
        jBProcurarCliente.setForeground(new java.awt.Color(243, 243, 243));
        jBProcurarCliente.setText("Procurar");
        jBProcurarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBProcurarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBProcurarClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBProcurarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBProcurarClienteMouseExited(evt);
            }
        });
        jBProcurarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProcurarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(jBProcurarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 100, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Cliente");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 20));

        jLClienteNaoCadastrado.setBackground(new java.awt.Color(0, 0, 0));
        jLClienteNaoCadastrado.setForeground(new java.awt.Color(0, 0, 0));
        jLClienteNaoCadastrado.setText("Cliente não cadastrado?");
        jLClienteNaoCadastrado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLClienteNaoCadastrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLClienteNaoCadastradoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLClienteNaoCadastradoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLClienteNaoCadastradoMouseExited(evt);
            }
        });
        jPanel1.add(jLClienteNaoCadastrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 160, 20));

        jLErroCliente.setForeground(new java.awt.Color(255, 110, 110));
        jLErroCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLErroCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLErroClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLErroClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLErroClienteMouseExited(evt);
            }
        });
        jPanel1.add(jLErroCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 180, 20));

        jTNomeAnimal.setBackground(new java.awt.Color(246, 242, 242));
        jTNomeAnimal.setForeground(new java.awt.Color(51, 51, 51));
        jTNomeAnimal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTNomeAnimal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTNomeAnimal.setEnabled(false);
        jTNomeAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTNomeAnimalMousePressed(evt);
            }
        });
        jTNomeAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomeAnimalActionPerformed(evt);
            }
        });
        jPanel1.add(jTNomeAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 230, 30));

        jBProcurarAnimal.setBackground(new java.awt.Color(0, 0, 0));
        jBProcurarAnimal.setForeground(new java.awt.Color(243, 243, 243));
        jBProcurarAnimal.setText("Procurar");
        jBProcurarAnimal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBProcurarAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBProcurarAnimalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBProcurarAnimalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBProcurarAnimalMouseExited(evt);
            }
        });
        jBProcurarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProcurarAnimalActionPerformed(evt);
            }
        });
        jPanel1.add(jBProcurarAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 100, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Animal");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, 20));

        jLAnimalNaoCadastrado.setBackground(new java.awt.Color(0, 0, 0));
        jLAnimalNaoCadastrado.setForeground(new java.awt.Color(0, 0, 0));
        jLAnimalNaoCadastrado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLAnimalNaoCadastrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLAnimalNaoCadastradoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLAnimalNaoCadastradoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLAnimalNaoCadastradoMouseExited(evt);
            }
        });
        jPanel1.add(jLAnimalNaoCadastrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 160, 20));

        jBUpload.setBackground(new java.awt.Color(0, 0, 0));
        jBUpload.setForeground(new java.awt.Color(243, 243, 243));
        jBUpload.setText("Upload");
        jBUpload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBUpload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBUploadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBUploadMouseExited(evt);
            }
        });
        jBUpload.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jBUploadComponentMoved(evt);
            }
        });
        jBUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUploadActionPerformed(evt);
            }
        });
        jPanel1.add(jBUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 100, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Comprovantes de renda:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, 40));

        jLErroAnimal.setForeground(new java.awt.Color(255, 110, 110));
        jLErroAnimal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLErroAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLErroAnimalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLErroAnimalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLErroAnimalMouseExited(evt);
            }
        });
        jPanel1.add(jLErroAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 180, 20));

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
        jPanel1.add(jLInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 420, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarComprovante(byte[] comprovante, String nomePadraoArquivo) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Comprovante");
        fileChooser.setSelectedFile(new java.io.File(nomePadraoArquivo)); // Define o nome padrão do arquivo

        // Mostra o diálogo de salvar
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File arquivoSelecionado = fileChooser.getSelectedFile();
            String caminhoArquivo = arquivoSelecionado.getAbsolutePath();

            // Garante que o arquivo tenha a extensão .pdf
            if (!caminhoArquivo.toLowerCase().endsWith(".pdf")) {
                caminhoArquivo += ".pdf";
            }

            try (FileOutputStream fos = new FileOutputStream(caminhoArquivo)) {
                // Escreve o conteúdo do byte[] no arquivo
                fos.write(comprovante);
                fos.flush();
                JOptionPane.showMessageDialog(null, "Comprovante salvo com sucesso em: " + caminhoArquivo);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "ERRO ao salvar o comprovante: " + e.getMessage());
            }
        }
    }
    
    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        // Inicializa a validação
        Validador validador = new Validador();
        boolean isValid = true;

        // Alterando o cursor para aguardar (esperando o processo)
        jPanel1.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        jBUpload.setCursor(new Cursor(Cursor.WAIT_CURSOR));

        // Validação do campo de cliente
        if (jTNomeCliente.getText().isEmpty()) {
            jLErroCliente.setText("Selecione um cliente.");
            isValid = false;
        } else {
            jLErroCliente.setText("");  
        }

        // Validação do campo de animal
        if (jTNomeAnimal.getText().isEmpty()) {
            jLErroAnimal.setText("Selecione um animal.");
            isValid = false;
        } else {
            jLErroAnimal.setText("");  
        }

        // Validações adicionais: descrição e foto do animal
        if (this.animalDTO.getDescricao() == null || this.animalDTO.getDescricao().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERRO: O Animal selecionado deve conter uma descrição. Por favor, insira uma descrição ao animal.");
            isValid = false;
        }

        if (this.animalDTO.getFotoAnimal() == null) {
            JOptionPane.showMessageDialog(null, "ERRO: O Animal selecionado deve conter uma foto. Por favor, insira uma foto ao animal.");
            isValid = false;
        }
        
        if (this.comprovanteRenda == null) {
            JOptionPane.showMessageDialog(null, "ERRO: Insira um comprovante de renda do cliente.");
            isValid = false; // Falha na validação, marca como inválido
        }

        // Se os dados forem válidos, prossegue com o cadastro
        if (isValid) {
            try {
                // Instancia a classe HttpConnection
                HttpConnection httpConnection = new HttpConnection();
                
                int idCliente = this.clienteDTO.getIdCliente();
                int idAnimal = this.animalDTO.getIdAnimal();
                // Executa o cadastro através do método cadastrarPedidoAdocao
                ComprovanteRendaModel response = httpConnection.cadastrarPedidoAdocao(idCliente, idAnimal, this.comprovanteRenda);

                // Verifica se o cadastro foi efetuado com sucesso
                if (response != null) {
                    // A partir daqui, o cursor continua "carregando" até que o PDF seja gerado
                    // Habilita o botão de download após o sucesso do cadastro
                    jBUpload.setEnabled(true);  
                    jBUpload.setCursor(new Cursor(Cursor.HAND_CURSOR));  // Muda o cursor para indicar ação

                    // Exibe mensagem de sucesso
                    JOptionPane.showMessageDialog(null, "Pedido de adoção cadastrado com sucesso.");

                    // Salva o PDF do comprovante
                    String nomeArquivo = "comprovante_adocao_" + System.currentTimeMillis() + ".pdf";
                    salvarComprovante(response.getArquivo(), nomeArquivo); // Salva o comprovante no disco
                    
                    // Ao finalizar o processo, retorna o cursor ao normal
                    jPanel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Restaura o cursor
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "ERRO: erro ao tentar cadastrar o pedido de adoção.");
                    jPanel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Restaura o cursor em caso de erro
                }
            } catch (Exception e) {
                jPanel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Restaura o cursor em caso de erro
            }
        } else {
            // Se algum campo não foi validado, retorna ao cursor padrão
            jPanel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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

    private void jTNomeClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNomeClienteMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeClienteMousePressed

    private void jTNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeClienteActionPerformed

    private void jBProcurarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcurarClienteActionPerformed
        // Abre a tela para procurar cliente e passa o clienteDTO atual
        ProcurarCliente selecionarCliente = new ProcurarCliente(this.clienteDTO); 
        dashboard.add(selecionarCliente);
        selecionarCliente.setVisible(true);
        selecionarCliente.setBounds(350, 70, 720, 584);

        final CadastrarAdocao dashboard = this;

        selecionarCliente.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
                ClienteModel clienteSelecionado = selecionarCliente.getClienteSelecionado();

                // Verifica se um cliente foi selecionado (ID é diferente de 0)
                if (clienteSelecionado != null && clienteSelecionado.getIdCliente() != 0) {
                    dashboard.clienteDTO = clienteSelecionado;
                    jTNomeCliente.setText(clienteSelecionado.getNome());
                    jLClienteNaoCadastrado.setText("Visualizar cliente");
                } else {
                    // Mantém o texto original se nenhum cliente válido foi selecionado
                    if (dashboard.clienteDTO.getIdCliente() == 0) {
                        jLClienteNaoCadastrado.setText("Cliente não cadastrado?");
                    }
                }
            }
        });
    }//GEN-LAST:event_jBProcurarClienteActionPerformed

    private void jLClienteNaoCadastradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLClienteNaoCadastradoMouseClicked
        // TODO add your handling code here:
        if (jLClienteNaoCadastrado.getText().equals("Cliente não cadastrado?")){
            CadastrarCliente adicionarCliente = new CadastrarCliente(dashboard);
            dashboard.add(adicionarCliente);
            adicionarCliente.setVisible(true);
            adicionarCliente.setBounds(400, 0, 810, 514);
        }else if (jLClienteNaoCadastrado.getText().equals("Visualizar cliente")){
            VisualizarCliente visualizarCliente = new VisualizarCliente(this.clienteDTO.getIdCliente(), this.emailFuncionario, this.funcao);
            dashboard.add(visualizarCliente);
            visualizarCliente.setVisible(true);
            visualizarCliente.setBounds(350, 70, 810, 514);
        }
    }//GEN-LAST:event_jLClienteNaoCadastradoMouseClicked

    private void jLClienteNaoCadastradoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLClienteNaoCadastradoMouseEntered
        // TODO add your handling code here:
        jLClienteNaoCadastrado.setForeground(new java.awt.Color(91,192,222));
    }//GEN-LAST:event_jLClienteNaoCadastradoMouseEntered

    private void jLClienteNaoCadastradoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLClienteNaoCadastradoMouseExited
        // TODO add your handling code here:
        jLClienteNaoCadastrado.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLClienteNaoCadastradoMouseExited

    private void jTNomeAnimalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNomeAnimalMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeAnimalMousePressed

    private void jTNomeAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomeAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeAnimalActionPerformed

    private void jBProcurarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcurarAnimalActionPerformed
        ProcurarAnimal procurarAnimal = new ProcurarAnimal(null, this.animalDTO, dashboard, this.emailFuncionario, this.funcao);
        dashboard.add(procurarAnimal);
        procurarAnimal.setVisible(true);
        procurarAnimal.setBounds(350, 70, 720, 584);

        final CadastrarAdocao dashboard = this;

        procurarAnimal.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
                AnimalModel animalSelecionado = procurarAnimal.getAnimalSelecionado();

                // Verifica se um animal foi selecionado
                if (animalSelecionado != null && animalSelecionado.getIdAnimal() != 0) {
                    dashboard.animalDTO = animalSelecionado;
                    jTNomeAnimal.setText(animalSelecionado.getNome());
                    jLAnimalNaoCadastrado.setText("Visualizar animal");
                } else {
                    // Se nenhum animal foi selecionado, mantém o texto original
                    jLAnimalNaoCadastrado.setText("");
                }
            }
        });
        
    }//GEN-LAST:event_jBProcurarAnimalActionPerformed

    private void jLAnimalNaoCadastradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAnimalNaoCadastradoMouseClicked
        // TODO add your handling code here:
        VisualizarAnimal visualizarAnimal = new VisualizarAnimal(dashboard, this.animalDTO.getIdAnimal(), this.emailFuncionario, this.funcao);
        dashboard.add(visualizarAnimal);
        visualizarAnimal.setVisible(true);
        visualizarAnimal.setBounds(250, 30, 910, 633);
    }//GEN-LAST:event_jLAnimalNaoCadastradoMouseClicked

    private void jLAnimalNaoCadastradoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAnimalNaoCadastradoMouseEntered
        // TODO add your handling code here:
        jLAnimalNaoCadastrado.setForeground(new java.awt.Color(91,192,222));
    }//GEN-LAST:event_jLAnimalNaoCadastradoMouseEntered

    private void jLAnimalNaoCadastradoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAnimalNaoCadastradoMouseExited
        // TODO add your handling code here:
        jLAnimalNaoCadastrado.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLAnimalNaoCadastradoMouseExited

    private void jBUploadComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jBUploadComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jBUploadComponentMoved
    
    private void armazenarComprovante(File arquivo) {
    try {
        // Lê o conteúdo do arquivo e armazena em um array de bytes
        try (FileInputStream fis = new FileInputStream(arquivo)) {
            comprovanteRenda = new byte[(int) arquivo.length()];
            fis.read(comprovanteRenda);  // Armazena o conteúdo do arquivo no array de bytes
        }

        // Exibe uma mensagem de sucesso
        JOptionPane.showMessageDialog(null, "Comprovante armazenado com sucesso!");
    } catch (IOException e) {
        System.err.println("Falha ao armazenar o comprovante: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "ERRO: falha ao armazenar o comprovante.");
    }
}
    
    private void jBUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUploadActionPerformed
        // TODO add your handling code here:
        // Abre o JFileChooser para o usuário selecionar o arquivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione o Comprovante de Renda (PDF)");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));

        // Exibe a janela para seleção do arquivo
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            // O arquivo foi selecionado
            File arquivoSelecionado = fileChooser.getSelectedFile();

            if (arquivoSelecionado != null && arquivoSelecionado.exists()) {
                // Chama o método para armazenar o arquivo como byte[]
                armazenarComprovante(arquivoSelecionado);
            }
        }
    }//GEN-LAST:event_jBUploadActionPerformed

    private void jLErroClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroClienteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroClienteMouseEntered

    private void jLErroClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroClienteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroClienteMouseExited

    private void jLErroClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroClienteMouseClicked

    private void jLErroAnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroAnimalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroAnimalMouseClicked

    private void jLErroAnimalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroAnimalMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroAnimalMouseEntered

    private void jLErroAnimalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroAnimalMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroAnimalMouseExited

    private void jBProcurarAnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBProcurarAnimalMouseClicked
        // TODO add your handling code here:
        jLErroAnimal.setText("");
    }//GEN-LAST:event_jBProcurarAnimalMouseClicked

    private void jBProcurarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBProcurarClienteMouseClicked
        // TODO add your handling code here:
        jLErroCliente.setText("");
    }//GEN-LAST:event_jBProcurarClienteMouseClicked

    private void jLInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLInfoMouseClicked
        // TODO add your handling code here:
        // Exibe uma caixa de diálogo com a explicação completa sobre o processo de adoção
        String mensagem = "Para ADOÇÃO, o funcionário deve seguir os seguintes passos:\n\n"
                + "- Selecionar o cliente que deseja adotar o animal.\n"
                + "- Selecionar o animal que o cliente deseja adotar.\n"
                + "- Anexar um comprovante de renda do cliente para análise do administrador.\n\n"
                + "Lembre-se: o vínculo entre o animal e o cliente será realizado automaticamente após a confirmação da retirada do animal pelo funcionário.";

        // Mostra a caixa de mensagem com as informações detalhadas
        JOptionPane.showMessageDialog(null, mensagem, "Informações sobre o Processo de Adoção", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLInfoMouseClicked

    private void jLInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLInfoMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLInfoMouseEntered

    private void jBProcurarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBProcurarClienteMouseEntered
        // TODO add your handling code here:
        jBProcurarCliente.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBProcurarClienteMouseEntered

    private void jBProcurarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBProcurarClienteMouseExited
        // TODO add your handling code here:
        jBProcurarCliente.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBProcurarClienteMouseExited

    private void jBProcurarAnimalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBProcurarAnimalMouseEntered
        // TODO add your handling code here:
        jBProcurarAnimal.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBProcurarAnimalMouseEntered

    private void jBProcurarAnimalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBProcurarAnimalMouseExited
        // TODO add your handling code here:
        jBProcurarAnimal.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBProcurarAnimalMouseExited

    private void jBUploadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBUploadMouseEntered
        // TODO add your handling code here:
        jBUpload.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBUploadMouseEntered

    private void jBUploadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBUploadMouseExited
        // TODO add your handling code here:
        jBUpload.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBUploadMouseExited

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
    private javax.swing.JButton jBProcurarAnimal;
    private javax.swing.JButton jBProcurarCliente;
    private javax.swing.JButton jBUpload;
    private javax.swing.JLabel jLAnimalNaoCadastrado;
    private javax.swing.JLabel jLClienteNaoCadastrado;
    private javax.swing.JLabel jLComputador;
    private javax.swing.JLabel jLErroAnimal;
    private javax.swing.JLabel jLErroCliente;
    private javax.swing.JLabel jLFuncionario;
    private javax.swing.JLabel jLInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTNomeAnimal;
    private javax.swing.JTextField jTNomeCliente;
    // End of variables declaration//GEN-END:variables
}
