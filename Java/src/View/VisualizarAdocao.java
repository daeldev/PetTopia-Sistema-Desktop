package View;
import Utils.AnimalModel;
import Utils.ClienteModel;
import Utils.HttpConnection;
import Utils.PedidoModel;
import Utils.Validador;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class VisualizarAdocao extends javax.swing.JInternalFrame {
    private final JDesktopPane dashboard;
    private int idPedido;
    private ClienteModel clienteDTO;
    private AnimalModel animalDTO;
    private final String emailFuncionario;
    private final String funcao;
    private byte[] comprovante;
    
    public VisualizarAdocao(JDesktopPane dashboard, int idPedido, String emailFuncionario, String funcao) {
        initComponents();
        this.idPedido = idPedido;
        this.dashboard = dashboard;
        // Inicializa o clienteDTO no construtor
        clienteDTO = new ClienteModel();
        animalDTO = new AnimalModel();
        
        this.emailFuncionario = emailFuncionario;
        
        this.funcao = funcao;
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Atualiza os dados da tabela periodicamente
                buscarPedido();
            }
        }, 0, 5000); // Atualiza a cada 5000 ms (5 segundos)   
    }
    
    private void buscarPedido() {
        // Instância a classe de conexão
        HttpConnection httpConnection = new HttpConnection();

        try {
            // Chama o método para buscar o cliente pelo ID
            PedidoModel servicoModel = httpConnection.buscarPedido(this.idPedido);
            
            
            // Verifica se o cliente foi encontrado
            if (servicoModel != null) {
                // Exibe o cliente buscado
                jTNomeCliente.setText(servicoModel.getCliente().getNome());
                this.clienteDTO = servicoModel.getCliente();
                jTNomeAnimal.setText(servicoModel.getAnimal().getNome());
                this.animalDTO = servicoModel.getAnimal();
                this.comprovante = servicoModel.getComprovante();
                
                // Formatar o LocalDate para o formato brasileiro sem barras
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                String dataBrasileira = servicoModel.getDataPedido().format(formatter);
                jTDataPedido.setText(dataBrasileira);

                jCStatus.setSelectedItem(servicoModel.getStatusPedido().substring(0, 1).toUpperCase() + servicoModel.getStatusPedido().substring(1).toLowerCase());
                if(servicoModel.getStatusPedido().equals("CONCLUIDO")){
                    jBConfirmarEntrega.setEnabled(false);
                }
            } else {
                // Se o cliente não foi encontrado, exibe uma mensagem
                JOptionPane.showMessageDialog(null, "Pedido não encontrado.");
            }
        } catch (Exception e) {
            // Tratamento de possíveis erros ao buscar o cliente
            JOptionPane.showMessageDialog(null, "Erro ao buscar o Pedido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLFuncionario = new javax.swing.JLabel();
        CorrigeBug = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLComputador = new javax.swing.JLabel();
        jTNomeCliente = new javax.swing.JTextField();
        jBProcurarCliente = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLClienteNaoCadastrado = new javax.swing.JLabel();
        jLCliente = new javax.swing.JLabel();
        jTNomeAnimal = new javax.swing.JTextField();
        jBProcurarAnimal = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLAnimalNaoCadastrado = new javax.swing.JLabel();
        jLAnimal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTDataPedido = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jCStatus = new javax.swing.JComboBox<>();
        jBConfirmarEntrega = new javax.swing.JButton();
        jBDownload = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setTitle("Visualizar Pedido de Adoção");
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
        jLabel2.setText("Confira o pedido de adoção");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLComputador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/DoacaoIcon.png"))); // NOI18N
        jPanel3.add(jLComputador, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 40, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 760, 90));

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
        jBProcurarCliente.setEnabled(false);
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
        jLClienteNaoCadastrado.setText("Visualizar cliente");
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

        jLCliente.setForeground(new java.awt.Color(255, 110, 110));
        jLCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLClienteMouseExited(evt);
            }
        });
        jPanel1.add(jLCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 180, 20));

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
        jBProcurarAnimal.setEnabled(false);
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
        jLAnimalNaoCadastrado.setText("Visualizar animal");
        jLAnimalNaoCadastrado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        jLAnimal.setForeground(new java.awt.Color(255, 110, 110));
        jLAnimal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLAnimalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLAnimalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLAnimalMouseExited(evt);
            }
        });
        jPanel1.add(jLAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 180, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Data do pedido");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, -1));

        jTDataPedido.setBackground(new java.awt.Color(246, 242, 242));
        jTDataPedido.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTDataPedido.setForeground(new java.awt.Color(51, 51, 51));
        try {
            jTDataPedido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTDataPedido.setText("2 /  /    ");
        jTDataPedido.setToolTipText("");
        jTDataPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTDataPedido.setEnabled(false);
        jTDataPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDataPedidoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTDataPedidoMousePressed(evt);
            }
        });
        jPanel1.add(jTDataPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 240, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Status");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, 30));

        jCStatus.setBackground(new java.awt.Color(51, 51, 51));
        jCStatus.setForeground(new java.awt.Color(243, 243, 243));
        jCStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendente", "Andamento", "Concluido", "Cancelado" }));
        jCStatus.setBorder(null);
        jCStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCStatus.setEnabled(false);
        jCStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCStatusActionPerformed(evt);
            }
        });
        jPanel1.add(jCStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 110, 30));

        jBConfirmarEntrega.setBackground(new java.awt.Color(0, 0, 0));
        jBConfirmarEntrega.setForeground(new java.awt.Color(243, 243, 243));
        jBConfirmarEntrega.setText("Confirmar retirada");
        jBConfirmarEntrega.setBorder(null);
        jBConfirmarEntrega.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBConfirmarEntrega.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jBConfirmarEntregaFocusGained(evt);
            }
        });
        jBConfirmarEntrega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBConfirmarEntregaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBConfirmarEntregaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBConfirmarEntregaMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBConfirmarEntregaMouseReleased(evt);
            }
        });
        jBConfirmarEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConfirmarEntregaActionPerformed(evt);
            }
        });
        jPanel1.add(jBConfirmarEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 240, 40));

        jBDownload.setBackground(new java.awt.Color(0, 0, 0));
        jBDownload.setForeground(new java.awt.Color(243, 243, 243));
        jBDownload.setText("Download");
        jBDownload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBDownload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBDownloadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBDownloadMouseExited(evt);
            }
        });
        jBDownload.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jBDownloadComponentMoved(evt);
            }
        });
        jBDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDownloadActionPerformed(evt);
            }
        });
        jPanel1.add(jBDownload, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 100, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Comprovante");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 700, 450));

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
                JOptionPane.showMessageDialog(null, "ERRO: falha ao tentar salvar o comprovante: " + e.getMessage());
            }
        }
    }
    
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
        selecionarCliente.setBounds(400, 0, 720, 584);

        final VisualizarAdocao dashboard = this;

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
        if (jLClienteNaoCadastrado.getText().equals("Visualizar cliente")){
            VisualizarCliente visualizarCliente = new VisualizarCliente(this.clienteDTO.getIdCliente(), this.emailFuncionario, this.funcao);
            dashboard.add(visualizarCliente);
            visualizarCliente.setVisible(true);
            visualizarCliente.setBounds(400, 0, 810, 514);
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
        if (this.clienteDTO.getIdCliente() == 0) { 
            JOptionPane.showMessageDialog(null, "ERRO: selecione um cliente antes de procurar um animal.");
            return;
        } else {
            ProcurarAnimal procurarAnimal = new ProcurarAnimal(this.clienteDTO, this.animalDTO, dashboard, this.emailFuncionario, this.funcao);
            dashboard.add(procurarAnimal);
            procurarAnimal.setVisible(true);
            procurarAnimal.setBounds(400, 0, 720, 584);

            final VisualizarAdocao dashboard = this;

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
                        jLAnimalNaoCadastrado.setText("Animal não cadastrado?");
                    }
                }
            });
        }
    }//GEN-LAST:event_jBProcurarAnimalActionPerformed

    private void jLAnimalNaoCadastradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAnimalNaoCadastradoMouseClicked
        // TODO add your handling code here:
        if (jLAnimalNaoCadastrado.getText().equals("Visualizar animal")){
            VisualizarAnimal visualizarAnimal = new VisualizarAnimal(dashboard, this.animalDTO.getIdAnimal(), this.emailFuncionario, this.funcao);
            dashboard.add(visualizarAnimal);
            visualizarAnimal.setVisible(true);
            visualizarAnimal.setBounds(250, 30, 910, 633);
        }
    }//GEN-LAST:event_jLAnimalNaoCadastradoMouseClicked

    private void jLAnimalNaoCadastradoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAnimalNaoCadastradoMouseEntered
        // TODO add your handling code here:
        jLAnimalNaoCadastrado.setForeground(new java.awt.Color(91,192,222));
    }//GEN-LAST:event_jLAnimalNaoCadastradoMouseEntered

    private void jLAnimalNaoCadastradoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAnimalNaoCadastradoMouseExited
        // TODO add your handling code here:
        jLAnimalNaoCadastrado.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLAnimalNaoCadastradoMouseExited

    private void jLClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLClienteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLClienteMouseEntered

    private void jLClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLClienteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLClienteMouseExited

    private void jLClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLClienteMouseClicked

    private void jLAnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAnimalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLAnimalMouseClicked

    private void jLAnimalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAnimalMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLAnimalMouseEntered

    private void jLAnimalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAnimalMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLAnimalMouseExited

    private void jTDataPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDataPedidoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDataPedidoMouseClicked

    private void jTDataPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDataPedidoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDataPedidoMousePressed

    private void jCStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCStatusActionPerformed

    private void jBConfirmarEntregaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBConfirmarEntregaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jBConfirmarEntregaFocusGained

    private void jBConfirmarEntregaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBConfirmarEntregaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBConfirmarEntregaMouseClicked

    private void jBConfirmarEntregaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBConfirmarEntregaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jBConfirmarEntregaMouseReleased

    private void jBConfirmarEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConfirmarEntregaActionPerformed
        // TODO add your handling code here:
        // Pergunta de confirmação ao funcionário
        int resposta = JOptionPane.showConfirmDialog(null, 
                    "Tem certeza de que deseja concluir este pedido de adoção?", 
                    "Confirmar Conclusão", JOptionPane.YES_NO_OPTION);

        // Se o funcionário clicar em "Sim" (JOptionPane.YES_OPTION)
        if (resposta == JOptionPane.YES_OPTION) {
            // Solicitar a senha ao administrador usando JPasswordField
            JPasswordField passwordField = new JPasswordField();
            int option = JOptionPane.showConfirmDialog(null, passwordField, "Senha funcionário:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (option == JOptionPane.OK_OPTION) {
                // Obtenha a senha digitada
                String senhaAdm = new String(passwordField.getPassword());

                // Valida o administrador com a senha fornecida
                Validador validador = new Validador();
                boolean autenticar = validador.validarFuncionario(this.emailFuncionario, senhaAdm);

                if (autenticar) {
                    HttpConnection httpConnection = new HttpConnection();
                    boolean response = httpConnection.concluirPedidoAdocao(this.idPedido);

                    if (response) {
                        JOptionPane.showMessageDialog(null, "Pedido concluído com sucesso.");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "ERRO: falha ao tentar confirmar a retirada.");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "ERRO: senha incorreta.");
                }
            }
        }
    }//GEN-LAST:event_jBConfirmarEntregaActionPerformed

    private void jBDownloadComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jBDownloadComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jBDownloadComponentMoved

    private void jBDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDownloadActionPerformed
        // TODO add your handling code here:
        String nomeArquivo = "comprovante_adocao_" + System.currentTimeMillis() + ".pdf"; // Gera um nome único para o arquivo
        salvarComprovante(this.comprovante, nomeArquivo); // Chama o método para salvar o PDF
    }//GEN-LAST:event_jBDownloadActionPerformed

    private void jBConfirmarEntregaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBConfirmarEntregaMouseEntered
        // TODO add your handling code here:
        jBConfirmarEntrega.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBConfirmarEntregaMouseEntered

    private void jBConfirmarEntregaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBConfirmarEntregaMouseExited
        // TODO add your handling code here:
        jBConfirmarEntrega.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBConfirmarEntregaMouseExited

    private void jBDownloadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBDownloadMouseEntered
        // TODO add your handling code here:
        jBDownload.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBDownloadMouseEntered

    private void jBDownloadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBDownloadMouseExited
        // TODO add your handling code here:
        jBDownload.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBDownloadMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CorrigeBug;
    private javax.swing.JButton jBConfirmarEntrega;
    private javax.swing.JButton jBDownload;
    private javax.swing.JButton jBProcurarAnimal;
    private javax.swing.JButton jBProcurarCliente;
    private javax.swing.JComboBox<String> jCStatus;
    private javax.swing.JLabel jLAnimal;
    private javax.swing.JLabel jLAnimalNaoCadastrado;
    private javax.swing.JLabel jLCliente;
    private javax.swing.JLabel jLClienteNaoCadastrado;
    private javax.swing.JLabel jLComputador;
    private javax.swing.JLabel jLFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JFormattedTextField jTDataPedido;
    private javax.swing.JTextField jTNomeAnimal;
    private javax.swing.JTextField jTNomeCliente;
    // End of variables declaration//GEN-END:variables
}
