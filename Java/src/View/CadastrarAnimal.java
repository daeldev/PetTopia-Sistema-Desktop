package View;
import Utils.AnimalModel;
import Utils.ClienteModel;
import Utils.HttpConnection;
import Utils.Validador;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class CadastrarAnimal extends javax.swing.JInternalFrame {
    
    private JDesktopPane dashboard;
    private ClienteModel clienteDTO;
    private byte[] fotoAnimal;
    
    public CadastrarAnimal(JDesktopPane dashboard) {
        initComponents();
        jLVisualizarFotoAnimal.setVisible(false);
        this.dashboard = dashboard;
        // Inicializa o clienteDTO no construtor
        clienteDTO = new ClienteModel();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLFuncionario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBCadastrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLComputador = new javax.swing.JLabel();
        jTNomeCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jCSexo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jCEspecie = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jCRaca = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jCIdade = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jCCor = new javax.swing.JComboBox<>();
        jBUpload = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTNomeAnimal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jBProcurar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLVisualizarFotoAnimal = new javax.swing.JLabel();
        jLErroDescricao = new javax.swing.JLabel();
        jLClienteNaoCadastrado = new javax.swing.JLabel();
        // Código gerado pelo NetBeans
        jSPeso = new javax.swing.JSpinner();
        jLErroPeso = new javax.swing.JLabel();
        jLInfo = new javax.swing.JLabel();
        jLErroPeso1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setTitle("Cadastrar Animal");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(246, 242, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FuncionarioIcon.png"))); // NOI18N
        jPanel1.add(jLFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Peso");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, 30));

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
        jPanel1.add(jBCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, 360, 40));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(243, 243, 243));
        jLabel1.setText("Animal");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(243, 243, 243));
        jLabel2.setText("Preencha os dados do animal");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLComputador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/PataIcon.png"))); // NOI18N
        jPanel3.add(jLComputador, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 40, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 910, 90));

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
        jPanel1.add(jTNomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 290, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Descrição");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        jTADescricao.setColumns(20);
        jTADescricao.setForeground(new java.awt.Color(243, 243, 243));
        jTADescricao.setRows(5);
        jTADescricao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTADescricao.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTADescricao.setLineWrap(true); // Ativa a quebra de linha
        jTADescricao.setWrapStyleWord(true); // Quebra a linha em palavras inteiras
        jScrollPane1.setViewportView(jTADescricao);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 360, 230));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Sexo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, 30));

        jCSexo.setBackground(new java.awt.Color(51, 51, 51));
        jCSexo.setForeground(new java.awt.Color(243, 243, 243));
        jCSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Macho", "Femea" }));
        jCSexo.setBorder(null);
        jCSexo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCSexoActionPerformed(evt);
            }
        });
        jPanel1.add(jCSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 130, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Espécie");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, 30));

        jCEspecie.setBackground(new java.awt.Color(51, 51, 51));
        jCEspecie.setForeground(new java.awt.Color(243, 243, 243));
        jCEspecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gato", "Cachorro" }));
        jCEspecie.setBorder(null);
        jCEspecie.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCEspecieActionPerformed(evt);
            }
        });
        jPanel1.add(jCEspecie, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 110, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Raça");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, -1, 30));

        jCRaca.setBackground(new java.awt.Color(51, 51, 51));
        jCRaca.setForeground(new java.awt.Color(243, 243, 243));
        jCRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Siames", "Persa", "American", "Maine Coon" }));
        jCRaca.setBorder(null);
        jCRaca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCRacaActionPerformed(evt);
            }
        });
        jPanel1.add(jCRaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 110, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Cor");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, -1, 30));

        jCIdade.setBackground(new java.awt.Color(51, 51, 51));
        jCIdade.setForeground(new java.awt.Color(243, 243, 243));
        jCIdade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Zero a tres meses", "Tres a seis meses", "Seis a um ano", "Mais de um ano" }));
        jCIdade.setBorder(null);
        jCIdade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCIdadeActionPerformed(evt);
            }
        });
        jPanel1.add(jCIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 130, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Idade");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, 30));

        jCCor.setBackground(new java.awt.Color(51, 51, 51));
        jCCor.setForeground(new java.awt.Color(243, 243, 243));
        jCCor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Preto", "Branco", "Marrom", "Cinza", "Laranja", "Mesclado" }));
        jCCor.setBorder(null);
        jCCor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCorActionPerformed(evt);
            }
        });
        jPanel1.add(jCCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 110, 30));

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
        jPanel1.add(jBUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 100, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Foto");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, -1, 30));

        jTNomeAnimal.setBackground(new java.awt.Color(246, 242, 242));
        jTNomeAnimal.setForeground(new java.awt.Color(51, 51, 51));
        jTNomeAnimal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTNomeAnimal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTNomeAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTNomeAnimalAnimalMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTNomeAnimalAnimalMousePressed(evt);
            }
        });
        jTNomeAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomeAnimalAnimalActionPerformed(evt);
            }
        });
        jPanel1.add(jTNomeAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 400, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Animal");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, 20));

        jBProcurar.setBackground(new java.awt.Color(0, 0, 0));
        jBProcurar.setForeground(new java.awt.Color(243, 243, 243));
        jBProcurar.setText("Procurar");
        jBProcurar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBProcurar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBProcurarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBProcurarMouseExited(evt);
            }
        });
        jBProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProcurarActionPerformed(evt);
            }
        });
        jPanel1.add(jBProcurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 100, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Foto");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, -1, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Cliente");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 20));

        jLVisualizarFotoAnimal.setForeground(new java.awt.Color(0, 0, 0));
        jLVisualizarFotoAnimal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLVisualizarFotoAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLVisualizarFotoAnimalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLVisualizarFotoAnimalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLVisualizarFotoAnimalMouseExited(evt);
            }
        });
        jPanel1.add(jLVisualizarFotoAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 480, 110, 20));

        jLErroDescricao.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, 180, 20));

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

        // Inicializando o modelo do Spinner para aceitar Double
        SpinnerNumberModel model = new SpinnerNumberModel(0.0, 0.0, 100.0, 0.100); // valor inicial, mínimo, máximo, passo
        jSPeso.setModel(model);

        // Configurando o editor para exibir o valor com vírgula como separador decimal e 3 casas decimais
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(jSPeso, "0.000");
        DecimalFormat df = editor.getFormat();

        // Configurando o separador decimal para vírgula (padrão brasileiro)
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        df.setDecimalFormatSymbols(symbols);

        // Define o editor customizado no JSpinner
        jSPeso.setEditor(editor);

        // (Opcional) Adicionando um ChangeListener para validação
        jSPeso.addChangeListener(e -> {
            // Limita a 3 casas decimais ao alterar o valor
            Double valor = (Double) jSPeso.getValue();
            valor = Math.round(valor * 1000.0) / 1000.0;  // Arredonda para 3 casas decimais
            jSPeso.setValue(valor);  // Atualiza o valor com o arredondamento

            if (valor < 0.0 || valor > 100.0) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um valor entre 0.0 e 100.0.");
                jSPeso.setValue(0.0); // Reseta para o valor inicial ou um valor padrão
            }
        });
        jSPeso.setBorder(null);
        jSPeso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSPeso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSPesoMouseClicked(evt);
            }
        });
        jPanel1.add(jSPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 130, 30));

        jLErroPeso.setBackground(new java.awt.Color(0, 0, 0));
        jLErroPeso.setForeground(new java.awt.Color(255, 110, 110));
        jLErroPeso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLErroPesoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLErroPesoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLErroPesoMouseExited(evt);
            }
        });
        jPanel1.add(jLErroPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 160, 20));

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
        jPanel1.add(jLInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, -1, -1));

        jLErroPeso1.setBackground(new java.awt.Color(0, 0, 0));
        jLErroPeso1.setForeground(new java.awt.Color(255, 110, 110));
        jLErroPeso1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLErroPeso1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLErroPeso1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLErroPeso1MouseExited(evt);
            }
        });
        jPanel1.add(jLErroPeso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 160, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 910, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        Validador validador = new Validador();
        boolean isValid = true; // Inicialmente, assume-se que os dados são válidos

        // Validação do nome
        if (!validador.validarNome(jTNomeAnimal.getText())) {
            jLErroDescricao.setText("Nome inválido");  
            isValid = false; // Falha na validação, marca como inválido
        } else {
            jLErroDescricao.setText("");  
        }

        // Validação do peso
        String peso = jSPeso.getValue().toString(); // Obtendo o valor do JSpinner como String
        if (!validador.validarPeso(peso)) {
            jLErroPeso.setText("Preencha o peso novamente");
            isValid = false; // Falha na validação, marca como inválido
        } else {
            jLErroPeso.setText("");  
        }

        // Validação da descrição
        if (jTADescricao.getText().isEmpty()) {
            jLErroDescricao.setText("Preencha a descrição");
            isValid = false; // Falha na validação, marca como inválido
        } else {
            jLErroDescricao.setText("");  
        }
        
        // Validação da foto
        if (fotoAnimal == null) {
            JOptionPane.showMessageDialog(null, "ERRO: a foto do animal é obrigatória.");
            isValid = false;
        }
        
        if (isValid) {
            String nome = jTNomeAnimal.getText();
            String especie = jCEspecie.getSelectedItem().toString().toUpperCase();
            String raca = jCRaca.getSelectedItem().toString().toUpperCase().replace(" ", "_");
            String sexo = jCSexo.getSelectedItem().toString().toUpperCase();
            String idade = jCIdade.getSelectedItem().toString().toUpperCase().replace(" ", "_");
            String cor = jCCor.getSelectedItem().toString().toUpperCase();
            String descricao = jTADescricao.getText();

            // Instancia a classe AnimalModel de DTO
            AnimalModel animalDTO = new AnimalModel();

            // Seta os dados fornecidos para o AnimalModel
            animalDTO.setNome(nome);
            
            if (this.clienteDTO != null){
                animalDTO.setCliente(this.clienteDTO);
            }else{
                animalDTO.setAdocao(true);
            }
            
            animalDTO.setPeso(Double.valueOf(peso));
            animalDTO.setEspecie(especie);
            animalDTO.setRaca(raca);
            animalDTO.setSexo(sexo); 
            animalDTO.setIdade(idade);
            animalDTO.setCor(cor);
            animalDTO.setDescricao(descricao);   
            animalDTO.setAdocao(false);

            // Define a foto já como byte[] sem precisar de conversão adicional          
            animalDTO.setFotoAnimal(fotoAnimal); // Foto já está em byte[]

            // Instância a classe HttpConnection
            HttpConnection httpConnection = new HttpConnection();

            // Executa o insert dos dados setados na classe clienteDTO ao banco de dados através do clienteDAO
            AnimalModel response = httpConnection.cadastrarAnimal(animalDTO);

            // Verifica se o cadastro foi efetuado com sucesso.
            if (response != null) {
                JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso.");
                dispose(); // Fecha a janela
            } else {
                JOptionPane.showMessageDialog(null, "ERRO: falha ao tentar cadastrar o animal.");
                System.out.println("response: " + response);
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

    private void jCSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCSexoActionPerformed

    private void jCRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCRacaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jCRacaActionPerformed

    private void jCIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCIdadeActionPerformed

    private void jCEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCEspecieActionPerformed
        // TODO add your handling code here:
        if(jCEspecie.getSelectedItem().toString().equals("Gato")){
            jCRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Siames", "Persa", "American", "Maine Coon" }));
        }
        if(jCEspecie.getSelectedItem().toString().equals("Cachorro")){
            jCRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pug", "Buldogue", "Salsicha", "Pastor alemao", "Poodle",
                "Rottweiler", "Labrador", "Pinscher", "Golden Retriever",
                "Pittbull", "Bull Terrir"}));
        }
    }//GEN-LAST:event_jCEspecieActionPerformed

    private void jCCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCCorActionPerformed

    private void jTNomeAnimalAnimalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNomeAnimalAnimalMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeAnimalAnimalMousePressed

    private void jTNomeAnimalAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomeAnimalAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeAnimalAnimalActionPerformed
    
    private void selecionarFotoAnimal() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Escolher imagem");

        // Filtrando apenas arquivos de imagem
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".png")
                       || f.getName().toLowerCase().endsWith(".jpg")
                       || f.getName().toLowerCase().endsWith(".jpeg");
            }

            @Override
            public String getDescription() {
                return "Imagens (*.jpg, *.jpeg, *.png)";
            }
        });

        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Se o usuário selecionar uma imagem, lê o arquivo e o converte para byte[]
            File selectedFile = fileChooser.getSelectedFile();
            try {
                // Lê o arquivo como array de bytes
                this.fotoAnimal = Files.readAllBytes(selectedFile.toPath());

                // Atualiza o JLabel para mostrar que a imagem foi selecionada
                jLVisualizarFotoAnimal.setVisible(true);
                jLVisualizarFotoAnimal.setText("Visualizar foto");  // Nome clicável para visualizar a foto
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo de imagem.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void jBUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUploadActionPerformed
        // TODO add your handling code here:
        selecionarFotoAnimal();
    }//GEN-LAST:event_jBUploadActionPerformed

    private void jTNomeAnimalAnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNomeAnimalAnimalMouseClicked
        // TODO add your handling code here:
        jLErroDescricao.setText("");
    }//GEN-LAST:event_jTNomeAnimalAnimalMouseClicked

    private void jLClienteNaoCadastradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLClienteNaoCadastradoMouseClicked
        // TODO add your handling code here:
        CadastrarCliente adicionarCliente = new CadastrarCliente(dashboard);
        dashboard.add(adicionarCliente);
        adicionarCliente.setVisible(true);
        adicionarCliente.setBounds(400, 0, 810, 514);
    }//GEN-LAST:event_jLClienteNaoCadastradoMouseClicked

    private void jLClienteNaoCadastradoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLClienteNaoCadastradoMouseEntered
        // TODO add your handling code here:
        jLClienteNaoCadastrado.setForeground(new java.awt.Color(91,192,222));
    }//GEN-LAST:event_jLClienteNaoCadastradoMouseEntered

    private void jLClienteNaoCadastradoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLClienteNaoCadastradoMouseExited
        // TODO add your handling code here:
        jLClienteNaoCadastrado.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLClienteNaoCadastradoMouseExited

    private void jLVisualizarFotoAnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVisualizarFotoAnimalMouseClicked
        try {
            // Usa diretamente os bytes da imagem armazenados em fotoAnimal
            byte[] fotoBytes = this.fotoAnimal;

            // Cria a tela de visualização da imagem, passando os bytes diretamente
            VisualizarFotoAnimal visualizarFotoAnimal = new VisualizarFotoAnimal(fotoBytes);

            // Adiciona a tela de visualização ao painel principal (DashboardFuncionario)
            dashboard.add(visualizarFotoAnimal);
            visualizarFotoAnimal.setVisible(true);
            visualizarFotoAnimal.setBounds(400, 100, 406, 411);  // Tamanho da tela de visualização

        } catch (Exception e) {
            // Exibe uma mensagem de erro se houver falha ao exibir a imagem
            JOptionPane.showMessageDialog(null, "Erro ao exibir a imagem: " + e.getMessage());
        }
    }//GEN-LAST:event_jLVisualizarFotoAnimalMouseClicked

    private void jLVisualizarFotoAnimalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVisualizarFotoAnimalMouseEntered
        // TODO add your handling code here:
        jLVisualizarFotoAnimal.setForeground(new java.awt.Color(91,192,222));
    }//GEN-LAST:event_jLVisualizarFotoAnimalMouseEntered

    private void jLVisualizarFotoAnimalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVisualizarFotoAnimalMouseExited
        // TODO add your handling code here:
        jLVisualizarFotoAnimal.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jLVisualizarFotoAnimalMouseExited

    private void jBUploadComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jBUploadComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jBUploadComponentMoved

    private void jBProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcurarActionPerformed
        // Abre a tela para procurar cliente e passa o clienteDTO atual
        ProcurarCliente selecionarCliente = new ProcurarCliente(this.clienteDTO); 
        dashboard.add(selecionarCliente);
        selecionarCliente.setVisible(true);
        selecionarCliente.setBounds(350, 70, 720, 584);

        final CadastrarAnimal dashboard = this;

        selecionarCliente.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent e) {
                ClienteModel clienteSelecionado = selecionarCliente.getClienteSelecionado();

                // Verifica se um cliente foi selecionado (ID é diferente de 0)
                if (clienteSelecionado != null && clienteSelecionado.getIdCliente() != 0) {
                    dashboard.clienteDTO.setIdCliente(clienteSelecionado.getIdCliente());
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
    }//GEN-LAST:event_jBProcurarActionPerformed

    private void jLErroPesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroPesoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroPesoMouseClicked

    private void jLErroPesoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroPesoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroPesoMouseEntered

    private void jLErroPesoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroPesoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroPesoMouseExited

    private void jSPesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSPesoMouseClicked
        // TODO add your handling code here:
        jLErroPeso.setText("");
    }//GEN-LAST:event_jSPesoMouseClicked

    private void jLInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLInfoMouseClicked
        // TODO add your handling code here:
       // Exibe uma caixa de diálogo com a explicação sobre vinculação de cliente ao cadastrar um animal
        String mensagem = "Para cadastrar um animal, siga as seguintes orientações:\n\n"
                + "- Se o animal for destinado à doação, um cliente deve ser vinculado ao animal. Isso é necessário para o encaminhamento do pedido de doação.\n\n"
                + "- Se o animal for resgatado, ele NÃO precisa ser vinculado a um cliente nesse momento. O animal será preparado para adoção e será vinculado a um cliente somente quando alguém decidir adotá-lo.\n\n"
                + "A foto do animal é essencial para animais que serão disponibilizados para adoção, pois ela permite que os futuros adotantes vejam o estado do animal antes de decidirem adotá-lo. Para doação, a foto também ajuda no processo de decisão do cliente.";

        // Mostra a caixa de mensagem com as informações detalhadas
        JOptionPane.showMessageDialog(null, mensagem, "Informações sobre Cadastro de Animal", JOptionPane.INFORMATION_MESSAGE);
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

    private void jBUploadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBUploadMouseEntered
        // TODO add your handling code here:
        jBUpload.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBUploadMouseEntered

    private void jBUploadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBUploadMouseExited
        // TODO add your handling code here:
        jBUpload.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBUploadMouseExited

    private void jBProcurarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBProcurarMouseEntered
        // TODO add your handling code here:
        jBProcurar.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBProcurarMouseEntered

    private void jBProcurarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBProcurarMouseExited
        // TODO add your handling code here:
        jBProcurar.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBProcurarMouseExited

    private void jLErroPeso1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroPeso1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroPeso1MouseClicked

    private void jLErroPeso1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroPeso1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroPeso1MouseEntered

    private void jLErroPeso1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroPeso1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroPeso1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBProcurar;
    private javax.swing.JButton jBUpload;
    private javax.swing.JComboBox<String> jCCor;
    private javax.swing.JComboBox<String> jCEspecie;
    private javax.swing.JComboBox<String> jCIdade;
    private javax.swing.JComboBox<String> jCRaca;
    private javax.swing.JComboBox<String> jCSexo;
    private javax.swing.JLabel jLClienteNaoCadastrado;
    private javax.swing.JLabel jLComputador;
    private javax.swing.JLabel jLErroDescricao;
    private javax.swing.JLabel jLErroPeso;
    private javax.swing.JLabel jLErroPeso1;
    private javax.swing.JLabel jLFuncionario;
    private javax.swing.JLabel jLInfo;
    private javax.swing.JLabel jLVisualizarFotoAnimal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSPeso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextField jTNomeAnimal;
    private javax.swing.JTextField jTNomeCliente;
    // End of variables declaration//GEN-END:variables
}
