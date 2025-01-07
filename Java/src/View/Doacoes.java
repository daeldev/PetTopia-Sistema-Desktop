package View;

import Utils.AnimalModel;
import Utils.ClienteModel;
import Utils.DoacaoRelatorioDTO;
import Utils.FuncionarioModel;
import javax.swing.table.DefaultTableModel;
import Utils.HttpConnection;
import Utils.PedidoModel;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Component;
import java.awt.Dimension;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

/**
 *
 * @author Oruam
 */
public class Doacoes extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaFuncionarios
     */
    private void listarDoacoes() {
        // Instância a classe de conexão
        HttpConnection httpConnection = new HttpConnection();

        // Chama o método para listar os funcionários cadastrados
        List<PedidoModel> servicos = httpConnection.listarServicos();

        // Obtem o modelo da tabela
        DefaultTableModel Tabela = (DefaultTableModel) jTDoacoes.getModel();

        // Limpa a tabela antes de adicionar os novos dados
        Tabela.setRowCount(0);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Itera sobre a lista de funcionários e adiciona os dados na tabela
        for (PedidoModel servico : servicos) {
            // Verifica se o tipo de serviço é doação
            if (servico.getTipo().equals("DOACAO")) {
                Object[] dados = {
                    servico.getCliente().getNome(),
                    servico.getAnimal().getNome(),   
                    servico.getStatusPedido().substring(0, 1).toUpperCase() + servico.getStatusPedido().substring(1).toLowerCase(),
                    servico.getCodigoComprovante(),
                    servico.getDataPedido().format(formatter),
                    servico.getIdPedido()
                };
                Tabela.addRow(dados);
            }
        }
    }
    
    private JDesktopPane dashboard;
    private final String emailFuncionario;
    private final String funcao;
    private String nomeFuncionario;
    public Doacoes(JDesktopPane dashboard, String nomeFuncionario, String emailFuncionario, String funcao) {
        initComponents();
        this.emailFuncionario = emailFuncionario;
        
        this.dashboard = dashboard;
        
        this.funcao = funcao;
        
        if (nomeFuncionario != null){
            this.nomeFuncionario = nomeFuncionario;
        }
        
        if (funcao.equals("FUNCIONARIO")){
            jPanel1.setVisible(false);
        }
        
        FlatLaf.registerCustomDefaultsSource("tableview");
        FlatMacDarkLaf.setup();
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Atualiza os dados da tabela periodicamente
                listarDoacoes();
            }
        }, 0, 5000); // Atualiza a cada 5000 ms (5 segundos)
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTCorrigirField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTPesquisar = new javax.swing.JTextField();
        jLPesquisar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBGerarRelatorio = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDoacoes = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jBVisualizar = new javax.swing.JButton();
        jBCadastrar1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCStatus = new javax.swing.JComboBox<>();
        jBLimparFiltros = new javax.swing.JButton();
        jLFundo = new javax.swing.JLabel();

        setBorder(null);
        setTitle("Doações");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setInheritsPopupMenu(true);
        setName("Tela Funcionário"); // NOI18N
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPanel2FocusLost(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel2KeyReleased(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTCorrigirField.setBackground(new java.awt.Color(255, 255, 255));
        jTCorrigirField.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jTCorrigirField, new org.netbeans.lib.awtextra.AbsoluteConstraints(-68, 0, -1, 20));

        jPanel3.setBackground(new java.awt.Color(24, 24, 24));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTPesquisar.setBackground(new java.awt.Color(24, 24, 24));
        jTPesquisar.setForeground(new java.awt.Color(204, 204, 204));
        jTPesquisar.setText("Pesquisar");
        jTPesquisar.setBorder(null);
        jTPesquisar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTPesquisarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTPesquisarFocusLost(evt);
            }
        });
        jTPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPesquisarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTPesquisarMouseExited(evt);
            }
        });
        jTPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPesquisarActionPerformed(evt);
            }
        });
        jTPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarKeyReleased(evt);
            }
        });
        jPanel3.add(jTPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 20));

        jLPesquisar.setBackground(new java.awt.Color(40, 40, 40));
        jLPesquisar.setForeground(new java.awt.Color(204, 204, 204));
        jLPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/PesquisarIcon.png"))); // NOI18N
        jPanel3.add(jLPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 30, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 270, 40));

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));
        jPanel1.setForeground(new java.awt.Color(233, 233, 233));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBGerarRelatorio.setBackground(new java.awt.Color(24, 24, 24));
        jBGerarRelatorio.setForeground(new java.awt.Color(204, 204, 204));
        jBGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/DownloadIcon.png"))); // NOI18N
        jBGerarRelatorio.setText("Gerar relatório");
        jBGerarRelatorio.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(59, 59, 59)));
        jBGerarRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBGerarRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBGerarRelatorioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBGerarRelatorioMouseExited(evt);
            }
        });
        jBGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGerarRelatorioActionPerformed(evt);
            }
        });
        jPanel1.add(jBGerarRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 620, 170, 60));

        jPanel4.setBackground(new java.awt.Color(238, 238, 238));
        jPanel4.setForeground(new java.awt.Color(233, 233, 233));

        jTDoacoes.setShowHorizontalLines(true);
        jTDoacoes.setShowVerticalLines(false);
        jTDoacoes.setGridColor(new java.awt.Color(51,51,51));
        jTDoacoes.setBackground(new java.awt.Color(238, 238, 238));
        jTDoacoes.setIntercellSpacing(new Dimension(0, 10));
        jTDoacoes.setRowHeight(30);
        jTDoacoes.setForeground(new java.awt.Color(51,51,51));
        jTDoacoes.setSelectionBackground(new java.awt.Color(24,24,24));
        jTDoacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Animal", "Status", "Comprovante", "Data", "Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTDoacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTDoacoes.setSelectionBackground(new java.awt.Color(102,102,102));   // Fundo quando selecionado

        JTableHeader header = jTDoacoes.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Definir a borda do cabeçalho
                if (column == 0) { // Para a primeira coluna (Nome)
                    label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, table.getGridColor())); // Linha horizontal embaixo e sem linha vertical
                }else if (column == 8) { // Para a ultima coluna (Data de emissão)
                    label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, table.getGridColor())); // Linha horizontal embaixo e sem linha vertical
                }else {
                    label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, table.getGridColor())); // Linha horizontal embaixo e linha vertical à esquerda
                }

                label.setHorizontalAlignment(SwingConstants.CENTER); // Centralizar o texto no cabeçalho
                return label;
            }
        });
        jTDoacoes.setSelectionForeground(new java.awt.Color(204,204,204));
        jTDoacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDoacoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTDoacoes);
        if (jTDoacoes.getColumnModel().getColumnCount() > 0) {
            jTDoacoes.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTDoacoes.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTDoacoes.getColumnModel().getColumn(4).setPreferredWidth(60);
            jTDoacoes.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, 490));

        jPanel6.setBackground(new java.awt.Color(238, 238, 238));
        jPanel6.setForeground(new java.awt.Color(233, 233, 233));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBVisualizar.setBackground(new java.awt.Color(24, 24, 24));
        jBVisualizar.setForeground(new java.awt.Color(204, 204, 204));
        jBVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/DetalhesIcon.png"))); // NOI18N
        jBVisualizar.setText("Visualizar");
        jBVisualizar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(59, 59, 59)));
        jBVisualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBVisualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBVisualizarMouseExited(evt);
            }
        });
        jBVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVisualizarActionPerformed(evt);
            }
        });
        jPanel6.add(jBVisualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 110, 30));

        jBCadastrar1.setBackground(new java.awt.Color(24, 24, 24));
        jBCadastrar1.setForeground(new java.awt.Color(204, 204, 204));
        jBCadastrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/AddIcon.png"))); // NOI18N
        jBCadastrar1.setText("Cadastrar");
        jBCadastrar1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(59, 59, 59)));
        jBCadastrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBCadastrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBCadastrar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBCadastrar1MouseExited(evt);
            }
        });
        jBCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrar1ActionPerformed(evt);
            }
        });
        jPanel6.add(jBCadastrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 110, 30));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 720, 60));

        jPanel5.setBackground(new java.awt.Color(238, 238, 238));
        jPanel5.setForeground(new java.awt.Color(233, 233, 233));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(24, 24, 24));

        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Status");

        jCStatus.setBackground(new java.awt.Color(24, 24, 24));
        jCStatus.setForeground(new java.awt.Color(204, 204, 204));
        jCStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Andamento", "Concluido", "Cancelado" }));
        jCStatus.setBorder(null);
        jCStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCStatus.setOpaque(true);
        jCStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCStatusActionPerformed(evt);
            }
        });
        jPanel1.add(jCStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, -1, 30));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCStatus, 0, 138, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, -1));

        jBLimparFiltros.setBackground(new java.awt.Color(24, 24, 24));
        jBLimparFiltros.setForeground(new java.awt.Color(204, 204, 204));
        jBLimparFiltros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/DeletarIcon.png"))); // NOI18N
        jBLimparFiltros.setText("Limpar filtros");
        jBLimparFiltros.setBorder(null);
        jBLimparFiltros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBLimparFiltros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBLimparFiltrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBLimparFiltrosMouseExited(evt);
            }
        });
        jBLimparFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparFiltrosActionPerformed(evt);
            }
        });
        jPanel5.add(jBLimparFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, 40));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 190, 160));

        jLFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FundoView.png"))); // NOI18N
        jLFundo.setPreferredSize(new java.awt.Dimension(1170, 1024));
        jPanel2.add(jLFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1170, 1010));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTnomeActionPerformed

    private void JCgeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCgeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCgeneroActionPerformed

    private void JCtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCtipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCtipoActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
  
    }//GEN-LAST:event_formKeyReleased

    private void jPanel2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel2KeyReleased

    private void jPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2FocusGained

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseReleased

    private void jTPesquisarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPesquisarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPesquisarMouseExited

    private void jTPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPesquisarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPesquisarMouseClicked

    private void jTPesquisarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTPesquisarFocusLost
        // TODO add your handling code here:
        if(jTPesquisar.getText().equals("")){

            jTPesquisar.setText("Pesquisar");
        }
    }//GEN-LAST:event_jTPesquisarFocusLost

    private void jTPesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTPesquisarFocusGained
        // TODO add your handling code here:
        if(jTPesquisar.getText().equals("Pesquisar")){
            jTPesquisar.setText("");
        }
    }//GEN-LAST:event_jTPesquisarFocusGained

    private void jPanel2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel2FocusLost
    
    private void filtrarTabela(String textoFiltro){
        DefaultTableModel modelo = (DefaultTableModel) jTDoacoes.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(modelo);
        jTDoacoes.setRowSorter(obj);

        // Adiciona a flag (?i) para fazer a pesquisa ignorar maiúsculas e minúsculas
        obj.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltro));
    }
    
    private void jTPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyReleased
        // TODO add your handling code here:
        filtrarTabela(jTPesquisar.getText());
    }//GEN-LAST:event_jTPesquisarKeyReleased

    private void jTDoacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDoacoesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDoacoesMouseClicked

    private void jTPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPesquisarActionPerformed

    private void jBGerarRelatorioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBGerarRelatorioMouseEntered
        // TODO add your handling code here:
        jBGerarRelatorio.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBGerarRelatorioMouseEntered

    private void jBGerarRelatorioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBGerarRelatorioMouseExited
        // TODO add your handling code here:
        jBGerarRelatorio.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBGerarRelatorioMouseExited
    
    private void salvarRelatorio(byte[] relatorio, String nomePadraoArquivo) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar Relatório");
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
                fos.write(relatorio);
                fos.flush();
                JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso em: " + caminhoArquivo);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao salvar o relatório: " + e.getMessage());
            }
        }
    }
    
    private void jBGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGerarRelatorioActionPerformed
        // Cria o DTO para o relatório
        DoacaoRelatorioDTO relatorioDTO = new DoacaoRelatorioDTO();

        // Lista para armazenar os pedidos da tabela
        List<PedidoModel> pedidos = new ArrayList<>();

        // Obtém o modelo da tabela
        DefaultTableModel tableModel = (DefaultTableModel) jTDoacoes.getModel();

        // Itera sobre as linhas da tabela para criar os objetos PedidoModel
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            PedidoModel pedido = new PedidoModel();

            // Configura o cliente no PedidoModel
            ClienteModel cliente = new ClienteModel();
            cliente.setNome((String) tableModel.getValueAt(i, 0)); // Nome do cliente
            pedido.setCliente(cliente); // Associa o ClienteModel ao PedidoModel

            // Configura o animal no PedidoModel
            AnimalModel animal = new AnimalModel();
            animal.setNome((String) tableModel.getValueAt(i, 1)); // Nome do animal
            pedido.setAnimal(animal); // Associa o AnimalModel ao PedidoModel

            // Configura o status do pedido
            String statusPedido = (String) tableModel.getValueAt(i, 2).toString().toUpperCase();
            pedido.setStatusPedido(statusPedido); // Status do pedido
            System.out.println(statusPedido);

            // Configura a data do pedido (convertendo de String para LocalDate)
            String dataString = (String) tableModel.getValueAt(i, 4); // Data do pedido como String
            LocalDate dataPedido = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            pedido.setDataPedido(dataPedido); // Define a data como LocalDate

            // Configura o ID do pedido
            pedido.setIdPedido((int) tableModel.getValueAt(i, 5)); // ID do pedido

            // Adiciona o pedido à lista
            pedidos.add(pedido);
        }

        // Adiciona os pedidos à lista do relatório
        relatorioDTO.setPedidos(pedidos);

        // Configura o nome do administrador no FuncionarioModel
        FuncionarioModel administrador = new FuncionarioModel();
        administrador.setNome_funcionario(this.nomeFuncionario); // Substitua pelo nome real do administrador
        relatorioDTO.setFuncionario(administrador);

        // Chama o método para gerar o relatório
        HttpConnection httpConnection = new HttpConnection();

        // Aqui você vai enviar o JSON dinâmico
        DoacaoRelatorioDTO response = httpConnection.gerarRelatorioDoacoes(relatorioDTO);

        if (response.getRelatorio() != null) {
            // Define o nome padrão do arquivo
            String nomePadraoArquivo = "RelatorioDoacoes.pdf";

            // Salva o relatório no sistema
            salvarRelatorio(response.getRelatorio(), nomePadraoArquivo);
        } else {
            JOptionPane.showMessageDialog(null, "ERRO: falha ao tentar gerar o relatório de doações.");
        }
    }//GEN-LAST:event_jBGerarRelatorioActionPerformed

    private void jBVisualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBVisualizarMouseEntered
        // TODO add your handling code here:
        jBVisualizar.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBVisualizarMouseEntered

    private void jBVisualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBVisualizarMouseExited
        // TODO add your handling code here:
        jBVisualizar.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBVisualizarMouseExited

    private void jBVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVisualizarActionPerformed
        // TODO add your handling code here:
        int[] selectedRows = jTDoacoes.getSelectedRows();

        if(selectedRows.length == 0){
            JOptionPane.showMessageDialog(null, "ERRO: selecione uma denúncia.");
        }else if(selectedRows.length > 1){
            JOptionPane.showMessageDialog(null, "ERRO: selecione somente uma denúncia.");
        }else{
            // Seta os dados fornecidos para o DenunciaModel
            PedidoModel servicoModel = new PedidoModel();
            servicoModel.setIdPedido(Integer.parseInt(jTDoacoes.getValueAt(jTDoacoes.getSelectedRow(), 5).toString()));
            
            VisualizarDoacao visualizarDoacao = new VisualizarDoacao(dashboard, servicoModel.getIdPedido(), this.emailFuncionario, this.funcao);
            dashboard.add(visualizarDoacao);
            visualizarDoacao.setVisible(true);
            visualizarDoacao.setBounds(400, 80, 701, 465);
        }
    }//GEN-LAST:event_jBVisualizarActionPerformed

    private void jBCadastrar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCadastrar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCadastrar1MouseEntered

    private void jBCadastrar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCadastrar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCadastrar1MouseExited

    private void jBCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrar1ActionPerformed
        // TODO add your handling code here:
        CadastrarDoacao cadastrarDoacaoAnimal = new CadastrarDoacao(dashboard, this.emailFuncionario, this.funcao);
        dashboard.add(cadastrarDoacaoAnimal);
        cadastrarDoacaoAnimal.setVisible(true);
        cadastrarDoacaoAnimal.setBounds(450, 80, 421, 526);
    }//GEN-LAST:event_jBCadastrar1ActionPerformed

    private void jCStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCStatusActionPerformed
        // TODO add your handling code here:
        filtrarTabela(jCStatus.getSelectedItem().toString());
    }//GEN-LAST:event_jCStatusActionPerformed

    private void jBLimparFiltrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLimparFiltrosMouseEntered
        // TODO add your handling code here:
        jBLimparFiltros.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBLimparFiltrosMouseEntered

    private void jBLimparFiltrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLimparFiltrosMouseExited
        // TODO add your handling code here:
        jBLimparFiltros.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBLimparFiltrosMouseExited

    private void jBLimparFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparFiltrosActionPerformed
        // TODO add your handling code here:
        filtrarTabela("");
    }//GEN-LAST:event_jBLimparFiltrosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrar1;
    private javax.swing.JButton jBGerarRelatorio;
    private javax.swing.JButton jBLimparFiltros;
    private javax.swing.JButton jBVisualizar;
    private javax.swing.JComboBox<String> jCStatus;
    private javax.swing.JLabel jLFundo;
    private javax.swing.JLabel jLPesquisar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTCorrigirField;
    private javax.swing.JTable jTDoacoes;
    private javax.swing.JTextField jTPesquisar;
    // End of variables declaration//GEN-END:variables
}
