package View;
import Utils.AnimalModel;
import Utils.ClienteModel;
import Utils.ComprovanteRendaModel;
import Utils.HttpConnection;
import Utils.Validador;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class AnalisarPedidoAdocao extends javax.swing.JInternalFrame {
    private final JDesktopPane dashboard;
    private int idComprovante;
    private ClienteModel clienteDTO;
    private AnimalModel animalDTO;
    private byte[] comprovante;
    private final String emailFuncionario;
    private final String funcao;
    
    public AnalisarPedidoAdocao(JDesktopPane dashboard, int idComprovante, String emailFuncionario, String funcao) {
        initComponents();
        this.idComprovante = idComprovante;
        
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
                buscarComprovante();
            }
        }, 0, 5000); // Atualiza a cada 5000 ms (5 segundos)   
    }
    
    private void buscarComprovante() {
        // Instância a classe de conexão
        HttpConnection httpConnection = new HttpConnection();

        try {
            // Chama o método para buscar o cliente pelo ID
            ComprovanteRendaModel comprovanteRendaModel = httpConnection.buscarComprovante(this.idComprovante);
            
            
            // Verifica se o cliente foi encontrado
            if (comprovanteRendaModel != null) {
                // Exibe o cliente buscado
                jTNomeCliente.setText(comprovanteRendaModel.getCliente().getNome());
                this.clienteDTO = comprovanteRendaModel.getCliente();
                jTNomeAnimal.setText(comprovanteRendaModel.getAnimal().getNome());
                this.animalDTO = comprovanteRendaModel.getAnimal();
                this.comprovante = comprovanteRendaModel.getArquivo();       
                
                jCStatus.setSelectedItem(comprovanteRendaModel.getStatus().substring(0, 1).toUpperCase() + comprovanteRendaModel.getStatus().substring(1).toLowerCase());   
                if(comprovanteRendaModel.getStatus().equals("CANCELADO")){
                    jBNegar.setEnabled(false);
                    jBAceitar.setEnabled(true);
                }
                
                if(comprovanteRendaModel.getStatus().equals("CONCLUIDO")){
                    jBAceitar.setEnabled(false);
                    jBNegar.setEnabled(false);
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
        jBDownload = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLAnimal = new javax.swing.JLabel();
        jBAceitar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jCStatus = new javax.swing.JComboBox<>();
        jBNegar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setTitle("Analisar Pedido de Adoção");
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
        jPanel1.add(jBDownload, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 100, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Comprovante de renda:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, 40));

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

        jBAceitar.setBackground(new java.awt.Color(0, 0, 0));
        jBAceitar.setForeground(new java.awt.Color(243, 243, 243));
        jBAceitar.setText("Aceitar");
        jBAceitar.setBorder(null);
        jBAceitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBAceitar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jBAceitarFocusGained(evt);
            }
        });
        jBAceitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBAceitarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBAceitarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBAceitarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBAceitarMouseReleased(evt);
            }
        });
        jBAceitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceitarActionPerformed(evt);
            }
        });
        jPanel1.add(jBAceitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 110, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Status");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, 30));

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
        jPanel1.add(jCStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 110, 30));

        jBNegar.setBackground(new java.awt.Color(0, 0, 0));
        jBNegar.setForeground(new java.awt.Color(243, 243, 243));
        jBNegar.setText("Negar");
        jBNegar.setBorder(null);
        jBNegar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBNegar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jBNegarFocusGained(evt);
            }
        });
        jBNegar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBNegarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBNegarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBNegarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBNegarMouseReleased(evt);
            }
        });
        jBNegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNegarActionPerformed(evt);
            }
        });
        jPanel1.add(jBNegar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 700, 440));

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

            final AnalisarPedidoAdocao dashboard = this;

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
            visualizarAnimal.setBounds(400, 0, 910, 633);
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

    private void jBDownloadComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jBDownloadComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jBDownloadComponentMoved

    private void jBDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDownloadActionPerformed
        // TODO add your handling code here:
        if (this.comprovante != null){
            String nomeArquivo = "comprovante_renda_" + System.currentTimeMillis() + ".pdf"; // Gera um nome único para o arquivo
            salvarComprovante(this.comprovante, nomeArquivo); // Chama o método para salvar o PDF
        }else{
            JOptionPane.showMessageDialog(null, "ERRO: falha ao tentar baixar o comprovante de adoção.");
        }
    }//GEN-LAST:event_jBDownloadActionPerformed

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

    private void jBAceitarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBAceitarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jBAceitarFocusGained

    private void jBAceitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAceitarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBAceitarMouseClicked

    private void jBAceitarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAceitarMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jBAceitarMouseReleased

    private void jBAceitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceitarActionPerformed
        int confirmacao = JOptionPane.showConfirmDialog(
            null,
            "Tem certeza de que deseja aceitar o pedido de adoção? Ação irreversível.",
            "Aceitar Pedido",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        // Se o administrador confirmar (clicar em 'Sim')
        if (confirmacao == JOptionPane.YES_OPTION) {
            // Solicitar a senha ao administrador usando JPasswordField
            JPasswordField passwordField = new JPasswordField();
            int option = JOptionPane.showConfirmDialog(null, passwordField, "Senha administrador:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (option == JOptionPane.OK_OPTION) {
                // Obtenha a senha digitada
                String senhaAdm = new String(passwordField.getPassword());

                // Valida o administrador com a senha fornecida
                Validador validador = new Validador();
                boolean autenticar = validador.validarFuncionario(this.emailFuncionario, senhaAdm);
                
                if (autenticar) {
                    HttpConnection httpConnection = new HttpConnection();
                    boolean response = httpConnection.validarComprovanteRenda(this.idComprovante);

                    if (response) {
                        JOptionPane.showMessageDialog(null, "Pedido aceito com sucesso.");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "ERRO: erro ao tentar aceitar o pedido de adoção.");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "ERRO: senha incorreta.");
                }
            }
        }
    }//GEN-LAST:event_jBAceitarActionPerformed

    private void jBNegarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jBNegarFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jBNegarFocusGained

    private void jBNegarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBNegarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBNegarMouseClicked

    private void jBNegarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBNegarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jBNegarMouseReleased

    private void jBNegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNegarActionPerformed
        // TODO add your handling code here:
        int confirmacao = JOptionPane.showConfirmDialog(
            null,
            "Tem certeza de que deseja negar o pedido de adoção?",
            "Negar Pedido",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            // Solicitar a senha ao administrador usando JPasswordField
            JPasswordField passwordField = new JPasswordField();
            int option = JOptionPane.showConfirmDialog(null, passwordField, "Senha administrador:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (option == JOptionPane.OK_OPTION) {
                // Obtenha a senha digitada
                String senhaAdm = new String(passwordField.getPassword());

                // Valida o administrador com a senha fornecida
                Validador validador = new Validador();
                boolean autenticar = validador.validarFuncionario(this.emailFuncionario, senhaAdm);
                
                if (autenticar) {
                    HttpConnection httpConnection = new HttpConnection();
                    boolean response = httpConnection.negarComprovanteRenda(this.idComprovante);

                    if (response) {
                        JOptionPane.showMessageDialog(null, "Pedido negado com sucesso.");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "ERRO: erro ao tentar negar o pedido de adoção.");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "ERRO: senha incorreta.");
                }
            }
        }
    }//GEN-LAST:event_jBNegarActionPerformed

    private void jCStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCStatusActionPerformed

    private void jBNegarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBNegarMouseEntered
        // TODO add your handling code here:
        jBNegar.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBNegarMouseEntered

    private void jBNegarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBNegarMouseExited
        // TODO add your handling code here:
        jBNegar.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBNegarMouseExited

    private void jBAceitarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAceitarMouseEntered
        // TODO add your handling code here:
        jBAceitar.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBAceitarMouseEntered

    private void jBAceitarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAceitarMouseExited
        // TODO add your handling code here:
        jBAceitar.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBAceitarMouseExited

    private void jBDownloadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBDownloadMouseEntered
        // TODO add your handling code here:
        jBDownload.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBDownloadMouseEntered

    private void jBDownloadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBDownloadMouseExited
        // TODO add your handling code here:
        jBDownload.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBDownloadMouseExited

    private void jBProcurarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcurarClienteActionPerformed
        // Abre a tela para procurar cliente e passa o clienteDTO atual
        ProcurarCliente selecionarCliente = new ProcurarCliente(this.clienteDTO);
        dashboard.add(selecionarCliente);
        selecionarCliente.setVisible(true);
        selecionarCliente.setBounds(400, 0, 720, 584);

        final AnalisarPedidoAdocao dashboard = this;

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CorrigeBug;
    private javax.swing.JButton jBAceitar;
    private javax.swing.JButton jBDownload;
    private javax.swing.JButton jBNegar;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTNomeAnimal;
    private javax.swing.JTextField jTNomeCliente;
    // End of variables declaration//GEN-END:variables
}
