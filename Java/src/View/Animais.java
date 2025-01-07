package View;

import Utils.AnimalRelatorioDTO;
import Utils.AnimalModel;
import Utils.ClienteModel;
import Utils.FuncionarioModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Utils.HttpConnection;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Component;
import java.awt.Dimension;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
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
public class Animais extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaFuncionarios
     */
    private void listarAnimais() {
        // Instância a classe de conexão
        HttpConnection httpConnection = new HttpConnection();

        // Chama o método para listar os animais
        List<AnimalModel> animais = httpConnection.listarAnimais();

        // Obtem o modelo da tabela
        DefaultTableModel Tabela = (DefaultTableModel) jTAnimais.getModel();

        // Limpa a tabela antes de adicionar os novos dados
        Tabela.setRowCount(0);
        
        // Itera sobre a lista de animais e adiciona os dados na tabela
        for (AnimalModel animal : animais) {
            // Transforma "_" em espaço e coloca tudo minúsculo
            String especie = animal.getEspecie().toLowerCase();
            String raca = animal.getRaca().toLowerCase().replace("_", " ");
            String sexo = animal.getSexo().toLowerCase();
            String idade = animal.getIdade().toLowerCase().replace("_", " ");
            String cor = animal.getCor().toLowerCase();

            // Coloca a inicial maiúscula
            especie = Character.toUpperCase(especie.charAt(0)) + especie.substring(1);
            raca = Character.toUpperCase(raca.charAt(0)) + raca.substring(1);
            sexo = Character.toUpperCase(sexo.charAt(0)) + sexo.substring(1);   
            idade = Character.toUpperCase(idade.charAt(0)) + idade.substring(1);   
            cor = Character.toUpperCase(cor.charAt(0)) + cor.substring(1);   

            // Configurações de formato para usar a vírgula como separador decimal
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
            symbols.setDecimalSeparator(',');

            // Formato com três casas decimais
            DecimalFormat df = new DecimalFormat("#,##0.000", symbols);

            // Exibindo o valor formatado
            String pesoFormatado = df.format(animal.getPeso()) + "kg";
            
            String nomeCliente;
            // Verifica se o cliente é nulo antes de acessar o nome
            if (animal.getCliente() != null && animal.getCliente().getNome() != null) {
                nomeCliente = animal.getCliente().getNome();
            } else {
                nomeCliente = "NÃO VINCULADO";
            }
                
            // Usa animal.getCliente().getNome() para obter o nome do cliente ou "NÃO VINCULADO"
            Object[] dados = {
                nomeCliente,
                animal.getNome(),
                especie,
                raca,
                sexo,
                idade,
                cor,
                pesoFormatado,
                animal.getIdAnimal()
            };

            // Adiciona a linha na tabela
            Tabela.addRow(dados);
        }
    }
    
    private String emailFuncionario;
    private String funcao;
    private JDesktopPane dashboard;
    private String nomeFuncionario;
    public Animais(JDesktopPane dashboard, String nomeFuncionario, String emailFuncionario, String funcao) {
        initComponents();
        this.emailFuncionario = emailFuncionario;
        
        this.funcao = funcao;
        
        this.dashboard = dashboard;
        
        this.nomeFuncionario = nomeFuncionario;
        
        if (funcao.equals("FUNCIONARIO")){
            jPanel9.setVisible(false);
        }
        
        FlatLaf.registerCustomDefaultsSource("tableview");
        FlatMacDarkLaf.setup();
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Atualiza os dados da tabela periodicamente
                listarAnimais();
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
        jPanel9 = new javax.swing.JPanel();
        jBGerarRelatorio = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTPesquisar = new javax.swing.JTextField();
        jLPesquisar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBAdd = new javax.swing.JButton();
        jBVisualizar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAnimais = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCEspecie = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jCRaca = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCSexo = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jCCor = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jCIdade = new javax.swing.JComboBox<>();
        jBLimparFiltros = new javax.swing.JButton();
        jLFundo = new javax.swing.JLabel();

        setBorder(null);
        setTitle("Animais");
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

        jPanel9.setBackground(new java.awt.Color(238, 238, 238));
        jPanel9.setForeground(new java.awt.Color(233, 233, 233));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel9.add(jBGerarRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 620, 170, 60));

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

        jBAdd.setBackground(new java.awt.Color(24, 24, 24));
        jBAdd.setForeground(new java.awt.Color(204, 204, 204));
        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/AddIcon.png"))); // NOI18N
        jBAdd.setText("Cadastrar");
        jBAdd.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(59, 59, 59)));
        jBAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBAddMouseExited(evt);
            }
        });
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });
        jPanel1.add(jBAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 110, 30));

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
        jPanel1.add(jBVisualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 110, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 720, 60));

        jPanel4.setBackground(new java.awt.Color(238, 238, 238));
        jPanel4.setForeground(new java.awt.Color(233, 233, 233));

        jTAnimais.setShowHorizontalLines(true);
        jTAnimais.setShowVerticalLines(false);
        jTAnimais.setGridColor(new java.awt.Color(51,51,51));
        jTAnimais.setBackground(new java.awt.Color(238, 238, 238));
        jTAnimais.setIntercellSpacing(new Dimension(0, 10));
        jTAnimais.setRowHeight(30);
        jTAnimais.setForeground(new java.awt.Color(51,51,51));
        jTAnimais.setSelectionBackground(new java.awt.Color(24,24,24));
        jTAnimais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Animal", "Espécie", "Raça", "Sexo", "Idade", "Cor", "Peso", "Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTAnimais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTAnimais.setSelectionBackground(new java.awt.Color(102,102,102));   // Fundo quando selecionado

        JTableHeader header = jTAnimais.getTableHeader();
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
        jTAnimais.setSelectionForeground(new java.awt.Color(204,204,204));
        jTAnimais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAnimaisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTAnimais);
        if (jTAnimais.getColumnModel().getColumnCount() > 0) {
            jTAnimais.getColumnModel().getColumn(0).setPreferredWidth(120);
            jTAnimais.getColumnModel().getColumn(1).setPreferredWidth(70);
            jTAnimais.getColumnModel().getColumn(2).setPreferredWidth(45);
            jTAnimais.getColumnModel().getColumn(3).setPreferredWidth(85);
            jTAnimais.getColumnModel().getColumn(4).setPreferredWidth(40);
            jTAnimais.getColumnModel().getColumn(5).setPreferredWidth(100);
            jTAnimais.getColumnModel().getColumn(6).setPreferredWidth(50);
            jTAnimais.getColumnModel().getColumn(7).setPreferredWidth(45);
            jTAnimais.getColumnModel().getColumn(8).setPreferredWidth(20);
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

        jPanel5.setBackground(new java.awt.Color(238, 238, 238));
        jPanel5.setForeground(new java.awt.Color(233, 233, 233));

        jPanel7.setBackground(new java.awt.Color(24, 24, 24));

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Espécie");

        jCEspecie.setBackground(new java.awt.Color(24, 24, 24));
        jCEspecie.setForeground(new java.awt.Color(204, 204, 204));
        jCEspecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gato", "Cachorro" }));
        jCEspecie.setBorder(null);
        jCEspecie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCEspecie.setOpaque(true);
        jCEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCEspecieActionPerformed(evt);
            }
        });
        jPanel1.add(jCEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, -1, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCEspecie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(24, 24, 24));

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Raça");

        jCRaca.setBackground(new java.awt.Color(24, 24, 24));
        jCRaca.setForeground(new java.awt.Color(204, 204, 204));
        jCRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Siames", "Persa", "American", "Main Conn" }));
        jCRaca.setBorder(null);
        jCRaca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCRaca.setOpaque(true);
        jCRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCRacaActionPerformed(evt);
            }
        });
        jPanel1.add(jCEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, -1, 30));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCRaca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(24, 24, 24));

        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Sexo");

        jCSexo.setBackground(new java.awt.Color(24, 24, 24));
        jCSexo.setForeground(new java.awt.Color(204, 204, 204));
        jCSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Macho", "Femea" }));
        jCSexo.setBorder(null);
        jCSexo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCSexo.setOpaque(true);
        jCSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCSexoActionPerformed(evt);
            }
        });
        jPanel1.add(jCEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, -1, 30));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(24, 24, 24));

        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Cor");

        jCCor.setBackground(new java.awt.Color(24, 24, 24));
        jCCor.setForeground(new java.awt.Color(204, 204, 204));
        jCCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Preto", "Branco", "Marrom", "Cinza", "Laranja", "Mesclado" }));
        jCCor.setBorder(null);
        jCCor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCCor.setOpaque(true);
        jCCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCorActionPerformed(evt);
            }
        });
        jPanel1.add(jCEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, -1, 30));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCCor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCCor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(24, 24, 24));

        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Idade");

        jCIdade.setBackground(new java.awt.Color(24, 24, 24));
        jCIdade.setForeground(new java.awt.Color(204, 204, 204));
        jCIdade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Zero a tres meses", "Tres a seis meses", "Seis a um ano", "Mais de um ano" }));
        jCIdade.setBorder(null);
        jCIdade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCIdade.setOpaque(true);
        jCIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCIdadeActionPerformed(evt);
            }
        });
        jPanel1.add(jCEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, -1, 30));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jCIdade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBLimparFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBLimparFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 170, 490));

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
        DefaultTableModel modelo = (DefaultTableModel) jTAnimais.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(modelo);
        jTAnimais.setRowSorter(obj);

        // Adiciona a flag (?i) para fazer a pesquisa ignorar maiúsculas e minúsculas
        obj.setRowFilter(RowFilter.regexFilter("(?i)" + textoFiltro));
    }
    
    private void jTPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyReleased
        filtrarTabela(jTPesquisar.getText());
    }//GEN-LAST:event_jTPesquisarKeyReleased

    private void jTAnimaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAnimaisMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAnimaisMouseClicked

    private void jTPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPesquisarActionPerformed

    private void jCEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCEspecieActionPerformed
        // TODO add your handling code here:
        if(jCEspecie.getSelectedItem().toString().equals("Gato")){
            jCRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Siames", "Persa", "American", "Main conn" }));
        }
        if(jCEspecie.getSelectedItem().toString().equals("Cachorro")){
            jCRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pug", "Buldogue", "Salsicha", "Pastor alemao", "Poodle", 
                                                                                    "Rottweiler", "Labrador", "Pinscher", "Golden retriever", 
                                                                                    "Pittbull", "Bull terrir"}));
        }
        
        filtrarTabela(jCEspecie.getSelectedItem().toString());
    }//GEN-LAST:event_jCEspecieActionPerformed

    private void jCRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCRacaActionPerformed
        // TODO add your handling code here:
        filtrarTabela(jCRaca.getSelectedItem().toString());
    }//GEN-LAST:event_jCRacaActionPerformed

    private void jCSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCSexoActionPerformed
        // TODO add your handling code here:
        filtrarTabela(jCSexo.getSelectedItem().toString());
    }//GEN-LAST:event_jCSexoActionPerformed

    private void jCCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCorActionPerformed
        // TODO add your handling code here:
        filtrarTabela(jCCor.getSelectedItem().toString());
    }//GEN-LAST:event_jCCorActionPerformed

    private void jCIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCIdadeActionPerformed
        // TODO add your handling code here:
        filtrarTabela(jCIdade.getSelectedItem().toString());
    }//GEN-LAST:event_jCIdadeActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        // TODO add your handling code here:
        CadastrarAnimal cadastrarAnimal = new CadastrarAnimal(dashboard);
        dashboard.add(cadastrarAnimal);
        cadastrarAnimal.setVisible(true);
        cadastrarAnimal.setBounds(250, 30, 910, 624);
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAddMouseExited
        // TODO add your handling code here:
        jBAdd.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBAddMouseExited

    private void jBAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAddMouseEntered
        // TODO add your handling code here:
        jBAdd.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBAddMouseEntered

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
        int[] selectedRows = jTAnimais.getSelectedRows();

        if(selectedRows.length == 0){
            JOptionPane.showMessageDialog(null, "ERRO: selecione um animal.");
        }else if(selectedRows.length > 1){
            JOptionPane.showMessageDialog(null, "ERRO: selecione somente um animal.");
        }else{
            // Instância o AnimalModel
            AnimalModel animalDTO = new AnimalModel();
            
            // Seta o id do animal no animalDTO
            animalDTO.setIdAnimal(Integer.parseInt(String.valueOf(jTAnimais.getValueAt(jTAnimais.getSelectedRow(), 8))));
            
            // Exibi a tela VisualizarAnimal passando o id do animal
            VisualizarAnimal visualizarAnimal = new VisualizarAnimal(dashboard, animalDTO.getIdAnimal(), this.emailFuncionario, this.funcao);
            dashboard.add(visualizarAnimal);
            visualizarAnimal.setVisible(true);
            visualizarAnimal.setBounds(250, 30, 910, 624);
        }
    }//GEN-LAST:event_jBVisualizarActionPerformed

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
        // Cria o DTO para o relatório de animais
        AnimalRelatorioDTO relatorioDTO = new AnimalRelatorioDTO();

        // Lista para armazenar os animais
        List<AnimalModel> animais = new ArrayList<>();

        // Obtém o modelo da tabela
        DefaultTableModel tableModel = (DefaultTableModel) jTAnimais.getModel();  // Assumindo que a tabela de animais é jTAnimais

        // Itera sobre as linhas da tabela para criar os objetos AnimalModel
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            AnimalModel animal = new AnimalModel();

            // Configura o cliente na AnimalModel
            ClienteModel cliente = new ClienteModel();
            cliente.setNome((String) tableModel.getValueAt(i, 0)); // Nome do cliente
            animal.setCliente(cliente); // Associa o ClienteModel ao AnimalModel

            // Configura o nome do animal
            animal.setNome((String) tableModel.getValueAt(i, 1)); // Nome do animal

            // Configura a espécie do animal
            animal.setEspecie((String) tableModel.getValueAt(i, 2).toString().toUpperCase()); // Espécie

            // Configura a raça do animal
            animal.setRaca((String) tableModel.getValueAt(i, 3).toString().toUpperCase()); // Raça

            // Configura o sexo do animal
            animal.setSexo((String) tableModel.getValueAt(i, 4).toString().toUpperCase()); // Sexo

            // Configura a idade do animal
            animal.setIdade((String) tableModel.getValueAt(i, 5).toString().toUpperCase()); // Idade

            // Configura a cor do animal
            animal.setCor((String) tableModel.getValueAt(i, 6).toString().toUpperCase()); // Cor

            // Obtenha o valor da célula que contém o peso
            String pesoString = tableModel.getValueAt(i, 7).toString();

            // Remova a unidade de medida "kg" (se presente)
            pesoString = pesoString.replace("kg", "").trim();

            // Substitua a vírgula por ponto, se necessário
            pesoString = pesoString.replace(",", ".");

            // Converta para double
            try {
                double peso = Double.parseDouble(pesoString);
                animal.setPeso(peso); // Peso
            } catch (NumberFormatException e) {
                // Trate o erro, caso o valor não seja um número válido
                e.printStackTrace();
                // Pode exibir uma mensagem de erro para o usuário, por exemplo
            }

            // Configura o ID do animal
            animal.setIdAnimal((int) tableModel.getValueAt(i, 8)); // ID do animal

            // Adiciona o animal à lista
            animais.add(animal);
        }

        // Adiciona os animais à lista do relatório
        relatorioDTO.setAnimais(animais);

        // Configura o nome do administrador no FuncionarioModel
        FuncionarioModel administrador = new FuncionarioModel();
        administrador.setNome_funcionario(this.nomeFuncionario); // Substitua pelo nome real do administrador
        relatorioDTO.setFuncionario(administrador);

        // Chama o método para gerar o relatório
        HttpConnection httpConnection = new HttpConnection();

        // Aqui você vai enviar o JSON dinâmico
        AnimalRelatorioDTO response = httpConnection.gerarRelatorioAnimais(relatorioDTO);

        if (response.getRelatorio() != null) {
            // Define o nome padrão do arquivo
            String nomePadraoArquivo = "RelatorioAnimais.pdf";

            // Salva o relatório no sistema
            salvarRelatorio(response.getRelatorio(), nomePadraoArquivo);
        } else {
            JOptionPane.showMessageDialog(null, "ERRO: falha ao tentar gerar o relatório de animais.");
        }
    }//GEN-LAST:event_jBGerarRelatorioActionPerformed

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
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBGerarRelatorio;
    private javax.swing.JButton jBLimparFiltros;
    private javax.swing.JButton jBVisualizar;
    private javax.swing.JComboBox<String> jCCor;
    private javax.swing.JComboBox<String> jCEspecie;
    private javax.swing.JComboBox<String> jCIdade;
    private javax.swing.JComboBox<String> jCRaca;
    private javax.swing.JComboBox<String> jCSexo;
    private javax.swing.JLabel jLFundo;
    private javax.swing.JLabel jLPesquisar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAnimais;
    private javax.swing.JTextField jTCorrigirField;
    private javax.swing.JTextField jTPesquisar;
    // End of variables declaration//GEN-END:variables
}
