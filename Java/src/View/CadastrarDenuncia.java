package View;
import Utils.ClienteModel;
import Utils.DenunciaModel;
import Utils.EnderecoModel;
import Utils.HttpConnection;
import Utils.Validador;
import java.awt.Cursor;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class CadastrarDenuncia extends javax.swing.JInternalFrame {

    private final JDesktopPane dashboard;
    private ClienteModel clienteDTO;
    public CadastrarDenuncia(JDesktopPane dashboard) {
        initComponents();
        this.dashboard = dashboard;
        // Inicializa o clienteDTO no construtor
        clienteDTO = new ClienteModel();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCUf = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTCidade = new javax.swing.JTextField();
        jTCep = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLErroLogradouro = new javax.swing.JLabel();
        jLErroCep = new javax.swing.JLabel();
        jLErroBairro = new javax.swing.JLabel();
        jLErroDataNascimento5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCTipoDenuncia = new javax.swing.JComboBox<>();
        jTLogradouro = new javax.swing.JTextField();
        jTBairro = new javax.swing.JTextField();
        jLErroCidade = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jTNomeCliente = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLErroCliente = new javax.swing.JLabel();
        jBProcurar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTComplemento = new javax.swing.JTextField();
        jLErroComplemento = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTNumero = new javax.swing.JTextField();
        jLErroNumero = new javax.swing.JLabel();
        jLClienteNaoCadastrado = new javax.swing.JLabel();
        jLInfo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setTitle("Cadastrar Denúncia");
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
        jBCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jPanel1.add(jBCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 650, 360, 40));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(243, 243, 243));
        jLabel1.setText("Denúncia");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(243, 243, 243));
        jLabel2.setText("Preencha os dados do pedido de denúncia");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLComputador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/MegafoneIcon.png"))); // NOI18N
        jPanel3.add(jLComputador, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 40, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 880, 90));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Descrição");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Tipo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 590, -1, 30));

        jCUf.setBackground(new java.awt.Color(51, 51, 51));
        jCUf.setForeground(new java.awt.Color(243, 243, 243));
        jCUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RJ", "SP", "ES" }));
        jCUf.setBorder(null);
        jCUf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCUf.setEnabled(false);
        jCUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCUfActionPerformed(evt);
            }
        });
        jPanel1.add(jCUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 590, 60, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Bairro");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Cidade");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Logradouro");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jTCidade.setBackground(new java.awt.Color(246, 242, 242));
        jTCidade.setForeground(new java.awt.Color(51, 51, 51));
        jTCidade.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTCidade.setEnabled(false);
        jTCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTCidadeMousePressed(evt);
            }
        });
        jTCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCidadeActionPerformed(evt);
            }
        });
        jPanel1.add(jTCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 330, 30));

        jTCep.setBackground(new java.awt.Color(246, 242, 242));
        jTCep.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jTCep.setForeground(new java.awt.Color(51, 51, 51));
        try {
            jTCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTCep.setToolTipText("");
        jTCep.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTCep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTCepMousePressed(evt);
            }
        });
        jTCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCepActionPerformed(evt);
            }
        });
        jTCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCepKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCepKeyTyped(evt);
            }
        });
        jPanel1.add(jTCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 330, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("CEP");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLErroLogradouro.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 260, 20));

        jLErroCep.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 180, 20));

        jLErroBairro.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 180, 20));

        jLErroDataNascimento5.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroDataNascimento5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 180, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("UF");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, -1, 30));

        jCTipoDenuncia.setBackground(new java.awt.Color(51, 51, 51));
        jCTipoDenuncia.setForeground(new java.awt.Color(243, 243, 243));
        jCTipoDenuncia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Violencia", "Perdido", "Abandonado" }));
        jCTipoDenuncia.setBorder(null);
        jCTipoDenuncia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCTipoDenuncia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTipoDenunciaActionPerformed(evt);
            }
        });
        jPanel1.add(jCTipoDenuncia, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 590, 130, 30));

        jTLogradouro.setBackground(new java.awt.Color(246, 242, 242));
        jTLogradouro.setForeground(new java.awt.Color(51, 51, 51));
        jTLogradouro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTLogradouro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTLogradouro.setEnabled(false);
        jTLogradouro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTLogradouroMousePressed(evt);
            }
        });
        jTLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTLogradouroActionPerformed(evt);
            }
        });
        jPanel1.add(jTLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 330, 30));

        jTBairro.setBackground(new java.awt.Color(246, 242, 242));
        jTBairro.setForeground(new java.awt.Color(51, 51, 51));
        jTBairro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTBairro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTBairro.setEnabled(false);
        jTBairro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTBairroMousePressed(evt);
            }
        });
        jTBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBairroActionPerformed(evt);
            }
        });
        jPanel1.add(jTBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 330, 30));

        jLErroCidade.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 180, 20));

        jTADescricao.setColumns(20);
        jTADescricao.setForeground(new java.awt.Color(243, 243, 243));
        jTADescricao.setRows(5);
        jTADescricao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTADescricao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTADescricao.setLineWrap(true); // Ativa a quebra de linha
        jTADescricao.setWrapStyleWord(true); // Quebra a linha em palavras inteiras
        jScrollPane1.setViewportView(jTADescricao);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 360, 190));

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
        jPanel1.add(jTNomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 220, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Cliente");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 20));

        jLErroCliente.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 180, 20));

        jBProcurar.setBackground(new java.awt.Color(0, 0, 0));
        jBProcurar.setForeground(new java.awt.Color(243, 243, 243));
        jBProcurar.setText("Procurar");
        jBProcurar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jPanel1.add(jBProcurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 100, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Complemento");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, -1));

        jTComplemento.setBackground(new java.awt.Color(246, 242, 242));
        jTComplemento.setForeground(new java.awt.Color(51, 51, 51));
        jTComplemento.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTComplemento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTComplemento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTComplementoMousePressed(evt);
            }
        });
        jTComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTComplementoActionPerformed(evt);
            }
        });
        jPanel1.add(jTComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 330, 30));

        jLErroComplemento.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 180, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Número");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        jTNumero.setBackground(new java.awt.Color(246, 242, 242));
        jTNumero.setForeground(new java.awt.Color(51, 51, 51));
        jTNumero.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 51, 51)));
        jTNumero.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTNumero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTNumeroMousePressed(evt);
            }
        });
        jTNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNumeroActionPerformed(evt);
            }
        });
        jPanel1.add(jTNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 330, 30));

        jLErroNumero.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 180, 20));

        jLClienteNaoCadastrado.setBackground(new java.awt.Color(0, 0, 0));
        jLClienteNaoCadastrado.setForeground(new java.awt.Color(0, 0, 0));
        jLClienteNaoCadastrado.setText("Cliente não cadastrado?");
        jLClienteNaoCadastrado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jLInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/InfoIcon.png"))); // NOI18N
        jLInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLInfoMouseEntered(evt);
            }
        });
        jPanel1.add(jLInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 860, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        Validador validador = new Validador();
        boolean isValid = true; // Inicialmente, assume-se que os dados são válidos
        
        if (jTNomeCliente.getText().isEmpty()) {
            jLErroCliente.setText("Selecione um cliente.");  
            isValid = false; // Falha na validação, marca como inválido
        } else {
            jLErroCliente.setText("");  
        }
        
        if (!validador.validarCep(jTCep.getText())) {
            jLErroCep.setText("CEP inválido.");  
            isValid = false; // Falha na validação, marca como inválido
        } else {
            jLErroCep.setText("");  
        }
 
        if(!jTComplemento.getText().isEmpty()){
            if (!validador.validarComplemento(jTComplemento.getText())) {
                jLErroComplemento.setText("Complemento inválido.");  
                isValid = false; // Falha na validação, marca como inválido
            } else {
                jLErroComplemento.setText("");  
            }
        }
        
        if(!jTNumero.getText().isEmpty()){
            if (!validador.validarNumeroCasa(jTNumero.getText())) {
                jLErroNumero.setText("Numero inválido.");  
                isValid = false; // Falha na validação, marca como inválido
            } else {
                jLErroNumero.setText("");  
            }
        }
        
        if (jTADescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ERRO: insira uma descrição para a denúncia.");
            isValid = false; // Falha na validação, marca como inválido
        }

        if (isValid) {
            String cep = jTCep.getText();
            String logradouro = jTLogradouro.getText();
            String bairro = jTBairro.getText();
            String cidade = jTCidade.getText();
            String uf = jCUf.getSelectedItem().toString();
            String complemento = jTComplemento.getText();
            String numero = jTNumero.getText();
            String descricao = jTADescricao.getText();
            String tipoDenuncia = jCTipoDenuncia.getSelectedItem().toString().toUpperCase();
           
            
            // Instancia a classe EnderecoModel
            EnderecoModel enderecoDTO = new EnderecoModel();
            
            // Seta os dados fornecidos para o EnderecoModel
            enderecoDTO.setCep(cep);
            enderecoDTO.setLogradouro(logradouro);
            enderecoDTO.setBairro(bairro);
            enderecoDTO.setLocalidade(cidade);
            enderecoDTO.setUf(uf);
            enderecoDTO.setComplemento(complemento);
            enderecoDTO.setNumero(numero);
            
            // Instancia a classe DenunciaModel
            DenunciaModel denunciaDTO = new DenunciaModel();
            
            // Seta os dados fornecidos para o AnimalModel
            denunciaDTO.setCliente(this.clienteDTO);
            denunciaDTO.setDescricao(descricao);
            denunciaDTO.setTipoDenucias(tipoDenuncia);
            denunciaDTO.setEndereco(enderecoDTO);

            // Instância a classe HttpConnection
            HttpConnection httpConnection = new HttpConnection();

            // Executa o insert dos dados setados na classe denunciaDTO ao banco de dados através do HttpConnection
            DenunciaModel response = httpConnection.cadastrarDenuncia(denunciaDTO);

            // Verifica se o cadastro foi efetuado com sucesso.
            if (response != null) {
                JOptionPane.showMessageDialog(null, "Denúncia cadastrada com sucesso.");
                dispose(); // Fecha a janela
            } else {
                System.out.println("response: " + response);
                JOptionPane.showMessageDialog(null, "ERRO: erro ao tentar cadastrar o pedido de denúncia.");
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

    private void jCUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCUfActionPerformed

    private void jTCidadeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCidadeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCidadeMousePressed

    private void jTCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCidadeActionPerformed

    private void jTCepMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCepMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCepMousePressed

    private void jCTipoDenunciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTipoDenunciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCTipoDenunciaActionPerformed

    private void jTLogradouroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTLogradouroMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTLogradouroMousePressed

    private void jTLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTLogradouroActionPerformed

    private void jTBairroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBairroMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBairroMousePressed

    private void jTBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTBairroActionPerformed

    private void jTNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeClienteActionPerformed

    private void jTNomeClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNomeClienteMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNomeClienteMousePressed

    private void jTCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCepActionPerformed

    }//GEN-LAST:event_jTCepActionPerformed

    private void jTCepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCepKeyReleased
        // Obtém o texto do campo CEP
        String cep = jTCep.getText().trim();

        // Verifica se o CEP está no formato correto (comprimento igual a 9)
        if (cep.length() == 9) {
            jPanel1.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            jTCep.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            HttpConnection httpConnection = new HttpConnection();
            String jsonResponse = httpConnection.buscarEnderecoPorCep(cep);

            if (jsonResponse != null) {
                try {
                    // Adicione esta linha para verificar a resposta
                    System.out.println("Resposta da API: " + jsonResponse);

                    // Cria o JSONObject a partir da resposta
                    JSONObject jsonObject = new JSONObject(jsonResponse);

                    // Verifica se a resposta contém um campo "erro"
                    if (jsonObject.has("erro")) {
                        JOptionPane.showMessageDialog(null, "ERRO: CEP inválido ou não encontrado.");
                        jPanel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        jTCep.setCursor(new Cursor(Cursor.TEXT_CURSOR));
                    } else {
                        // Preenche os campos com os dados retornados
                        jPanel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        jTCep.setCursor(new Cursor(Cursor.TEXT_CURSOR));
                        jTLogradouro.setText(jsonObject.getString("logradouro"));
                        jTBairro.setText(jsonObject.getString("bairro"));
                        jTCidade.setText(jsonObject.getString("localidade"));
                        jCUf.setSelectedItem(jsonObject.getString("uf"));
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao processar a resposta da API: " + e.getMessage());
                    jPanel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    jTCep.setCursor(new Cursor(Cursor.TEXT_CURSOR));
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERRO: CEP inválido ou não encontrado.");
                jPanel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                jTCep.setCursor(new Cursor(Cursor.TEXT_CURSOR));
            }
        } else {
            // Opcional: Limpar os campos quando o CEP não está no formato correto
            jPanel1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            jTCep.setCursor(new Cursor(Cursor.TEXT_CURSOR));
            jTLogradouro.setText("");
            jTBairro.setText("");
            jTCidade.setText("");
            jCUf.setSelectedItem("");
        }
    }//GEN-LAST:event_jTCepKeyReleased

    private void jTCepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCepKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCepKeyTyped

    private void jBProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcurarActionPerformed
        // Abre a tela para procurar cliente e passa o clienteDTO atual
        ProcurarCliente selecionarCliente = new ProcurarCliente(this.clienteDTO); 
        this.dashboard.add(selecionarCliente);
        selecionarCliente.setVisible(true);
        selecionarCliente.setBounds(350, 70, 720, 584);

        final CadastrarDenuncia dashboard = this;

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

    private void jTComplementoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTComplementoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTComplementoMousePressed

    private void jTComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTComplementoActionPerformed

    private void jTNumeroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNumeroMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNumeroMousePressed

    private void jTNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNumeroActionPerformed

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

    private void jLInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLInfoMouseClicked
        // TODO add your handling code here:
       // Exibe uma caixa de diálogo com a explicação sobre o cadastro de denúncia
        String mensagem = "No cadastro de denúncia, é importante fornecer a descrição detalhada do animal para ajudar na identificação e no acompanhamento da denúncia.\n\n"
                + "O complemento e o número do endereço não são obrigatórios, mas a descrição é essencial para entender melhor a situação.";

        // Mostra a caixa de mensagem com as informações detalhadas
        JOptionPane.showMessageDialog(null, mensagem, "Informações sobre Cadastro de Denúncia", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLInfoMouseClicked

    private void jLInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLInfoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLInfoMouseEntered

    private void jBProcurarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBProcurarMouseEntered
        // TODO add your handling code here:
        jBProcurar.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBProcurarMouseEntered

    private void jBProcurarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBProcurarMouseExited
        // TODO add your handling code here:
        jBProcurar.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBProcurarMouseExited

    private void jBCadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCadastrarMouseExited
        // TODO add your handling code here:
        jBCadastrar.setBackground(new java.awt.Color(24,24,24));      
    }//GEN-LAST:event_jBCadastrarMouseExited

    private void jBCadastrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBCadastrarMouseEntered
        // TODO add your handling code here:
        jBCadastrar.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBCadastrarMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CorrigeBug;
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JButton jBProcurar;
    private javax.swing.JComboBox<String> jCTipoDenuncia;
    private javax.swing.JComboBox<String> jCUf;
    private javax.swing.JLabel jLClienteNaoCadastrado;
    private javax.swing.JLabel jLComputador;
    private javax.swing.JLabel jLErroBairro;
    private javax.swing.JLabel jLErroCep;
    private javax.swing.JLabel jLErroCidade;
    private javax.swing.JLabel jLErroCliente;
    private javax.swing.JLabel jLErroComplemento;
    private javax.swing.JLabel jLErroDataNascimento5;
    private javax.swing.JLabel jLErroLogradouro;
    private javax.swing.JLabel jLErroNumero;
    private javax.swing.JLabel jLFuncionario;
    private javax.swing.JLabel jLInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextField jTBairro;
    private javax.swing.JFormattedTextField jTCep;
    private javax.swing.JTextField jTCidade;
    private javax.swing.JTextField jTComplemento;
    private javax.swing.JTextField jTLogradouro;
    private javax.swing.JTextField jTNomeCliente;
    private javax.swing.JTextField jTNumero;
    // End of variables declaration//GEN-END:variables
}
