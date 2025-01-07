package View;
import Utils.AnimalModel;
import Utils.ClienteModel;
import Utils.HttpConnection;
import Utils.Validador;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;



public class VisualizarAnimal extends javax.swing.JInternalFrame {
    private final int idAnimal;
    private final String emailFuncionario;
    private final String funcao;
    private final JDesktopPane dashboard;
    private ClienteModel clienteDTO;
    private byte[] fotoAnimal;
    
    public VisualizarAnimal(JDesktopPane dashboard, int idAnimal, String emailFuncionario, String funcao) {
        initComponents();
        this.idAnimal = idAnimal;
        this.emailFuncionario = emailFuncionario;
        this.funcao = funcao;
        this.dashboard = dashboard;
        if (clienteDTO != null){
            // Inicializa o clienteDTO no construtor
            clienteDTO = new ClienteModel();
        }
        
        jLCancelarEdicao.setVisible(false);     

        // Chama o método para buscar os dados do cliente assim que a tela for criada
        buscarAnimal();
        
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
    
    private void buscarAnimal() {
        // Instância a classe de conexão
        HttpConnection httpConnection = new HttpConnection();

        try {
            // Chama o método para buscar o animal pelo ID
            AnimalModel animalDTO = httpConnection.buscarAnimal(this.idAnimal);
            // Verifica se o animal foi encontrado
            if (animalDTO != null) {
                // Exibe o animal buscado
                jTNomeAnimal.setText(animalDTO.getNome());
                
                if (animalDTO.getCliente() != null){
                    jTNomeCliente.setText(String.valueOf(animalDTO.getCliente().getNome()));
                    this.clienteDTO = animalDTO.getCliente();
                }else{
                    jTNomeCliente.setText("NÃO VINCULADO");
                }
                
                // Obtendo o valor do peso do DTO (assumindo que animalDTO.getPeso() retorna um Double)
                double peso = animalDTO.getPeso();

                // Define o valor numérico no JSpinner
                jSPeso.setValue(peso);

                // Configura o editor do JSpinner para formatar o valor com três casas decimais e vírgula como separador decimal
                JSpinner.NumberEditor editor = new JSpinner.NumberEditor(jSPeso, "#,##0.000");
                DecimalFormat df = editor.getFormat();

                // Define a vírgula como separador decimal
                DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
                symbols.setDecimalSeparator(',');
                df.setDecimalFormatSymbols(symbols);

                // Define o editor formatado no JSpinner
                jSPeso.setEditor(editor);
                
                // Altera o "_" para " "
                String especieSemUnderscore = animalDTO.getEspecie().replace("_", " ");
                String idadeSemUnderscore = animalDTO.getIdade().replace("_", " ");
                
                // Exibe com apenas a primeira letra maiúscula
                jCEspecie.setSelectedItem(Character.toUpperCase(especieSemUnderscore.charAt(0)) + especieSemUnderscore.substring(1).toLowerCase());
                jCIdade.setSelectedItem(Character.toUpperCase(idadeSemUnderscore.charAt(0)) + idadeSemUnderscore.substring(1).toLowerCase());
                jCRaca.setSelectedItem(Character.toUpperCase(animalDTO.getRaca().charAt(0)) + animalDTO.getRaca().substring(1).toLowerCase());
                jCSexo.setSelectedItem(Character.toUpperCase(animalDTO.getSexo().charAt(0)) + animalDTO.getSexo().substring(1).toLowerCase());
                jCCor.setSelectedItem(Character.toUpperCase(animalDTO.getCor().charAt(0)) + animalDTO.getCor().substring(1).toLowerCase());
                jTADescricao.setText(animalDTO.getDescricao());
                
                // Armazena a foto diretamente como byte[]
                if (animalDTO.getFotoAnimal() != null) {
                    this.fotoAnimal = animalDTO.getFotoAnimal();
                }
            } else {
                // Se o animal não foi encontrado, exibe uma mensagem
                JOptionPane.showMessageDialog(null, "Animal não encontrado.");
            }
        } catch (Exception e) {
            // Tratamento de possíveis erros ao buscar o animal
            JOptionPane.showMessageDialog(null, "buscarAnimal: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para converter byte[] para File
    public File convertByteArrayToFile(byte[] byteArray, String fileName) throws IOException {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(byteArray);
        }
        return file;
    }
    
    private void desativarEdicao(){
        jTNomeAnimal.setEnabled(false);
        jSPeso.setEnabled(false);
        jCEspecie.setEnabled(false);
        jCSexo.setEnabled(false);
        jCRaca.setEnabled(false);
        jCIdade.setEnabled(false);
        jCCor.setEnabled(false);
        jTADescricao.setEnabled(false);
        jBUpload.setEnabled(false);
        jBEditar.setText("Editar");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLFuncionario = new javax.swing.JLabel();
        CorrigeBug = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLComputador = new javax.swing.JLabel();
        jTNomeCliente = new javax.swing.JTextField();
        jLInfoVincularAnimal = new javax.swing.JLabel();
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
        jLErroPeso = new javax.swing.JLabel();
        jLVisualizarFotoAnimal = new javax.swing.JLabel();
        jLErroNome = new javax.swing.JLabel();
        jBEditar = new javax.swing.JButton();
        jLCancelarEdicao = new javax.swing.JLabel();
        // Código gerado pelo NetBeans
        jSPeso = new javax.swing.JSpinner();
        jLClienteNaoCadastrado = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setTitle("Visualizar Animal");
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
        jLabel6.setText("Peso");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, 30));

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
        jLabel2.setText("Confira os dados do animal");
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

        jLInfoVincularAnimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/InfoIcon.png"))); // NOI18N
        jLInfoVincularAnimal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLInfoVincularAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLInfoVincularAnimalMouseEntered(evt);
            }
        });
        jPanel1.add(jLInfoVincularAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Descrição");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, -1));

        jTADescricao.setColumns(20);
        jTADescricao.setForeground(new java.awt.Color(243, 243, 243));
        jTADescricao.setRows(5);
        jTADescricao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTADescricao.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTADescricao.setEnabled(false);
        jTADescricao.setLineWrap(true); // Ativa a quebra de linha
        jTADescricao.setWrapStyleWord(true); // Quebra a linha em palavras inteiras
        jScrollPane1.setViewportView(jTADescricao);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 360, 220));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Sexo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, 30));

        jCSexo.setBackground(new java.awt.Color(51, 51, 51));
        jCSexo.setForeground(new java.awt.Color(243, 243, 243));
        jCSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Macho", "Femea" }));
        jCSexo.setBorder(null);
        jCSexo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCSexo.setEnabled(false);
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
        jCEspecie.setEnabled(false);
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
        jCRaca.setEnabled(false);
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
        jCIdade.setEnabled(false);
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
        jCCor.setEnabled(false);
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
        jBUpload.setEnabled(false);
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
        jTNomeAnimal.setEnabled(false);
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
        jBProcurar.setEnabled(false);
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
        jPanel1.add(jLErroPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 160, 20));

        jLVisualizarFotoAnimal.setForeground(new java.awt.Color(0, 0, 0));
        jLVisualizarFotoAnimal.setText("Visualizar foto");
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
        jPanel1.add(jLVisualizarFotoAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 480, 90, 20));

        jLErroNome.setForeground(new java.awt.Color(255, 110, 110));
        jPanel1.add(jLErroNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 180, 20));

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
        jPanel1.add(jBEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 540, 360, 40));

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
        jPanel1.add(jLCancelarEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 580, 110, 20));

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
            Double valor = (Double) jSPeso.getValue();
            if (valor < 0.0 || valor > 100.0) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um valor entre 0.0 e 100.0.");
                jSPeso.setValue(0.0); // Reseta para o valor inicial ou um valor padrão
            }
        });
        jSPeso.setBorder(null);
        jSPeso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSPeso.setEnabled(false);
        jPanel1.add(jSPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 130, 30));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 910, 620));

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
            jCRaca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Siames", "Persa", "American", "Main Conn" }));
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
        jLErroPeso.setText("");
    }//GEN-LAST:event_jTNomeAnimalAnimalMouseClicked

    private void jBProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcurarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBProcurarActionPerformed

    private void jLInfoVincularAnimalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLInfoVincularAnimalMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLInfoVincularAnimalMouseEntered

    private void jLErroPesoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroPesoMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLErroPesoMouseEntered

    private void jLErroPesoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroPesoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroPesoMouseExited

    private void jLErroPesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLErroPesoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLErroPesoMouseClicked

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
            JOptionPane.showMessageDialog(null, "ERRO: foto não encontrada.");
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
            
            if (this.funcao.equals("ADMINISTRADOR")) {
                jCEspecie.setEnabled(true);
                jCSexo.setEnabled(true);
                jCRaca.setEnabled(true);
                jCCor.setEnabled(true);
            }
            
            jSPeso.setEnabled(true);
            jCIdade.setEnabled(true);
            jTADescricao.setEnabled(true);
            jBUpload.setEnabled(true);
            jBEditar.setText("Confirmar");
            jLCancelarEdicao.setVisible(true);
        } else if (jBEditar.getText().equals("Confirmar")) {
            Validador validador = new Validador();
            boolean isValid = true; // Inicialmente, assume-se que os dados são válidos

            // Validação do nome
            if (!validador.validarNome(jTNomeAnimal.getText())) {
                jLErroNome.setText("Nome inválido.");  
                isValid = false; // Falha na validação, marca como inválido
            } else {
                jLErroNome.setText("");  
            }

            // Validação do peso
            String peso = jSPeso.getValue().toString(); // Obtendo o valor do JSpinner como String
            if (!validador.validarPeso(peso)) {
                jLErroPeso.setText("Preencha o peso novamente");
                isValid = false; // Falha na validação, marca como inválido
            } else {
                jLErroPeso.setText("");  
            }

            if (isValid) {
                // Solicitar a senha ao administrador usando JPasswordField
                JPasswordField passwordField = new JPasswordField();
                int option = JOptionPane.showConfirmDialog(null, passwordField, "Senha funcionário:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (option == JOptionPane.OK_OPTION) {
                    // Obtenha a senha digitada
                    String senhaFuncionario = new String(passwordField.getPassword());

                    // Valida o administrador com a senha fornecida
                    boolean autenticar = validador.validarFuncionario(this.emailFuncionario, senhaFuncionario);
                    
                    if (autenticar) {
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
                        animalDTO.setCliente(this.clienteDTO);
                        animalDTO.setPeso(Double.valueOf(peso));
                        animalDTO.setEspecie(especie);
                        animalDTO.setRaca(raca);
                        animalDTO.setSexo(sexo); 
                        animalDTO.setIdade(idade);
                        animalDTO.setCor(cor);
                        animalDTO.setDescricao(descricao);   

                        // Define a foto já como byte[] sem precisar de conversão adicional
                        if (fotoAnimal != null) {
                            animalDTO.setFotoAnimal(fotoAnimal); // Foto já está em byte[]
                        }

                        // Instância a classe HttpConnection
                        HttpConnection httpConnection = new HttpConnection();

                        // Executa o insert dos dados setados na classe clienteDTO ao banco de dados através do clienteDAO
                        AnimalModel response = httpConnection.editarAnimal(this.idAnimal, animalDTO);

                        // Verifica se o cadastro foi efetuado com sucesso.
                        if (response != null) {
                            // Se a edição for concedida, exibi um feedback, desativa os campos e altera "Confirmar" para "Editar"
                            JOptionPane.showMessageDialog(null, "Animal editado com sucesso.");
                            desativarEdicao();
                        } else {
                            JOptionPane.showMessageDialog(null, "ERRO: falha ao tentar editar o animal.");
                            System.out.println("response: " + response);
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
        buscarAnimal();
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

    private void jLClienteNaoCadastradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLClienteNaoCadastradoMouseClicked
        // TODO add your handling code here:
        if (this.clienteDTO != null){
            VisualizarCliente visualizarCliente = new VisualizarCliente(this.clienteDTO.getIdCliente(), this.emailFuncionario, this.funcao);
            dashboard.add(visualizarCliente);
            visualizarCliente.setVisible(true);
            visualizarCliente.setBounds(350, 70, 810, 514);
        }else{
            JOptionPane.showMessageDialog(null, "ERRO: Cliente não vinculado.");
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
    private javax.swing.JButton jBProcurar;
    private javax.swing.JButton jBUpload;
    private javax.swing.JComboBox<String> jCCor;
    private javax.swing.JComboBox<String> jCEspecie;
    private javax.swing.JComboBox<String> jCIdade;
    private javax.swing.JComboBox<String> jCRaca;
    private javax.swing.JComboBox<String> jCSexo;
    private javax.swing.JLabel jLCancelarEdicao;
    private javax.swing.JLabel jLClienteNaoCadastrado;
    private javax.swing.JLabel jLComputador;
    private javax.swing.JLabel jLErroNome;
    private javax.swing.JLabel jLErroPeso;
    private javax.swing.JLabel jLFuncionario;
    private javax.swing.JLabel jLInfoVincularAnimal;
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
