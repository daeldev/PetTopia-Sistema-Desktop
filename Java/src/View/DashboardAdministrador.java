package View;

import Utils.HttpConnection;
import Utils.SessionManager;
import View.Login;
import View.DashboardAdministrador;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Aluno.Tarde
 */
public class DashboardAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form TelaAtendenteNova
     */
    
    
    private Timer sessionChecker;
    private SessionManager sessionManager;
    
    public DashboardAdministrador() {
        initComponents();
//        sessionManager = new SessionManager();
//
//        // Adiciona ouvintes de atividade global
//        sessionManager.addUserActivityListeners();
//
//        // Inicia monitoramento
//        startMonitoringSession();
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Atualiza os dados da tabela periodicamente
                atualizarGraficos();
            }
        }, 0, 5000); // Atualiza a cada 5000 ms (5 segundos)
    }

    private void atualizarGraficos() {
        try {
            // Conecta à API e obtém os gráficos em formato byte[]
            HttpConnection httpConnection = new HttpConnection();
            Map<String, byte[]> graficosBytes = httpConnection.obterGraficos();
            
//            if (graficosBytes != null){
                // Converte os byte[] em BufferedImage
                BufferedImage graficoDenuncia = decodificarImagemBytes(graficosBytes.get("grafico1"));
                BufferedImage graficoDinheiro = decodificarImagemBytes(graficosBytes.get("grafico2"));
                BufferedImage graficoDoacoes = decodificarImagemBytes(graficosBytes.get("grafico3"));

                // Exibe os gráficos nos JLabels
                SwingUtilities.invokeLater(() -> {
                    exibirGraficoNoLabel(graficoDenuncia, jLGraficoDenuncias, jPGraficoDenuncias);
                    exibirGraficoNoLabel(graficoDinheiro, jLGraficoDinheiro, jPGraficoDinheiro);
                    exibirGraficoNoLabel(graficoDoacoes, jLGraficoDoacoes, jPGraficoDoacoes);
                });
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BufferedImage decodificarImagemBytes(byte[] imagemBytes) throws IOException {
        try (InputStream inputStream = new ByteArrayInputStream(imagemBytes)) {
            return ImageIO.read(inputStream);
        }
    }

    private void exibirGraficoNoLabel(BufferedImage grafico, JLabel label, JPanel painel) {
        if (grafico != null) {
            // Obtém as dimensões originais do gráfico
            int larguraOriginal = grafico.getWidth();
            int alturaOriginal = grafico.getHeight();

            // Obtém as dimensões do painel onde o gráfico será exibido
            int larguraPainel = painel.getWidth();
            int alturaPainel = painel.getHeight();

            // Calcula a proporção da imagem (manter a proporção)
            double proporcaoLargura = (double) larguraPainel / larguraOriginal;
            double proporcaoAltura = (double) alturaPainel / alturaOriginal;

            // Usamos a menor proporção para garantir que a imagem caiba no painel sem ser cortada
            double proporcaoFinal = Math.min(proporcaoLargura, proporcaoAltura);

            // Calcula as novas dimensões mantendo a proporção original
            int novaLargura = (int) (larguraOriginal * proporcaoFinal);
            int novaAltura = (int) (alturaOriginal * proporcaoFinal);

            // Redimensiona a imagem proporcionalmente
            ImageIcon icon = new ImageIcon(grafico.getScaledInstance(novaLargura, novaAltura, BufferedImage.SCALE_SMOOTH));

            // Atualiza o JLabel com a imagem redimensionada
            label.setIcon(icon);
            label.revalidate();
            label.repaint();
        }
    }

    private void startMonitoringSession() {
        sessionChecker = new Timer(5000, e -> checkSession());
        sessionChecker.start();
    }

    private void checkSession() {
        if (!sessionManager.isSessionActive()) {
            fecharSessao();
        }
    }

    private void fecharSessao() {
        // Para o Timer para evitar verificações futuras
        if (sessionChecker != null) {
            sessionChecker.stop();
        }

        JOptionPane.showMessageDialog(null, "Sua sessão expirou. Realizando logout.");
        sessionManager.logout(); // Garante o encerramento da sessão

        // Transição para a tela de login
        Login logout = new Login();
        this.dispose();
        logout.setVisible(true);
    }
    
    private boolean telaAberta = false; // Controla se uma tela está aberta
    private JInternalFrame telaAtual = null; // Referência para a tela interna atual
    private String emailFuncionario;
    private String funcao;
    private String nomeFuncionario;
    public void dadosAdministrador(String nomeFuncionario, String emailFuncionario, String funcao){
        this.emailFuncionario = emailFuncionario;
        this.funcao = funcao;
        jLNome.setText(nomeFuncionario);
        this.nomeFuncionario = nomeFuncionario;
    }
    
    private void verificarTelaAberta(){
        if (telaAtual != null) {
            telaAtual.dispose(); // Fecha a tela atual, se estiver aberta
            telaAtual = null; // Reseta a referência para null
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DashboardAdministrador = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPGraficoDinheiro = new javax.swing.JPanel();
        jLGraficoDinheiro = new javax.swing.JLabel();
        jPGraficoDoacoes = new javax.swing.JPanel();
        jLGraficoDoacoes = new javax.swing.JLabel();
        jPGraficoDenuncias = new javax.swing.JPanel();
        jLGraficoDenuncias = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBLogout = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jBAnimais = new javax.swing.JButton();
        jBClientes = new javax.swing.JButton();
        jBDoacoes = new javax.swing.JButton();
        jBAdocoes = new javax.swing.JButton();
        jBFuncionarios = new javax.swing.JButton();
        jBHome = new javax.swing.JButton();
        jBDenuncias = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLNome = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(24, 24, 24));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 10, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Arrecadação de dinheiro mensalmente");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 290, -1));

        jPanel4.setBackground(new java.awt.Color(24, 24, 24));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 10, 20));

        jPanel3.setBackground(new java.awt.Color(24, 24, 24));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 10, 20));

        jPGraficoDinheiro.setBackground(new java.awt.Color(24, 24, 24));
        jPGraficoDinheiro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPGraficoDinheiro.add(jLGraficoDinheiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPGraficoDinheiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 320, 250));

        jPGraficoDoacoes.setBackground(new java.awt.Color(24, 24, 24));
        jPGraficoDoacoes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPGraficoDoacoes.add(jLGraficoDoacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPGraficoDoacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 660, 250));

        jPGraficoDenuncias.setBackground(new java.awt.Color(24, 24, 24));
        jPGraficoDenuncias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPGraficoDenuncias.add(jLGraficoDenuncias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPGraficoDenuncias, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 1000, 290));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Quantidade de denúncias concluídas");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 270, -1));

        jPanel2.setBackground(new java.awt.Color(24, 24, 24));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBLogout.setBackground(new java.awt.Color(24, 24, 24));
        jBLogout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBLogout.setForeground(new java.awt.Color(255, 255, 255));
        jBLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/SairIcon.png"))); // NOI18N
        jBLogout.setText("Logout");
        jBLogout.setBorder(null);
        jBLogout.setBorderPainted(false);
        jBLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBLogoutMouseExited(evt);
            }
        });
        jBLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLogoutActionPerformed(evt);
            }
        });
        jPanel2.add(jBLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 650, 320, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/PetTopiaLogo.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 130));

        jBAnimais.setBackground(new java.awt.Color(24, 24, 24));
        jBAnimais.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBAnimais.setForeground(new java.awt.Color(255, 255, 255));
        jBAnimais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/PataIcon.png"))); // NOI18N
        jBAnimais.setText("Animais");
        jBAnimais.setBorder(null);
        jBAnimais.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBAnimais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBAnimaisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBAnimaisMouseExited(evt);
            }
        });
        jBAnimais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnimaisActionPerformed(evt);
            }
        });
        jPanel2.add(jBAnimais, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 370, 320, 50));

        jBClientes.setBackground(new java.awt.Color(24, 24, 24));
        jBClientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBClientes.setForeground(new java.awt.Color(255, 255, 255));
        jBClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/PessoasIcon.png"))); // NOI18N
        jBClientes.setText("Clientes");
        jBClientes.setBorder(null);
        jBClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBClientesMouseExited(evt);
            }
        });
        jBClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClientesActionPerformed(evt);
            }
        });
        jPanel2.add(jBClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 300, 320, 50));

        jBDoacoes.setBackground(new java.awt.Color(24, 24, 24));
        jBDoacoes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBDoacoes.setForeground(new java.awt.Color(255, 255, 255));
        jBDoacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/DoacaoIcon.png"))); // NOI18N
        jBDoacoes.setText("Doações");
        jBDoacoes.setBorder(null);
        jBDoacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBDoacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBDoacoesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBDoacoesMouseExited(evt);
            }
        });
        jBDoacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDoacoesActionPerformed(evt);
            }
        });
        jPanel2.add(jBDoacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 510, 310, 50));

        jBAdocoes.setBackground(new java.awt.Color(24, 24, 24));
        jBAdocoes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBAdocoes.setForeground(new java.awt.Color(255, 255, 255));
        jBAdocoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/AdocaoIcon.png"))); // NOI18N
        jBAdocoes.setText("Adoções");
        jBAdocoes.setBorder(null);
        jBAdocoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBAdocoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBAdocoesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBAdocoesMouseExited(evt);
            }
        });
        jBAdocoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdocoesActionPerformed(evt);
            }
        });
        jPanel2.add(jBAdocoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 580, 310, 50));

        jBFuncionarios.setBackground(new java.awt.Color(24, 24, 24));
        jBFuncionarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBFuncionarios.setForeground(new java.awt.Color(255, 255, 255));
        jBFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/PessoasIcon.png"))); // NOI18N
        jBFuncionarios.setText("Funcionários");
        jBFuncionarios.setBorder(null);
        jBFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBFuncionariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBFuncionariosMouseExited(evt);
            }
        });
        jBFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFuncionariosActionPerformed(evt);
            }
        });
        jPanel2.add(jBFuncionarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 230, 280, 50));

        jBHome.setBackground(new java.awt.Color(24, 24, 24));
        jBHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBHome.setForeground(new java.awt.Color(255, 255, 255));
        jBHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/HomeIcon.png"))); // NOI18N
        jBHome.setText("Home");
        jBHome.setBorder(null);
        jBHome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBHomeMouseExited(evt);
            }
        });
        jBHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHomeActionPerformed(evt);
            }
        });
        jPanel2.add(jBHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 160, 340, 50));

        jBDenuncias.setBackground(new java.awt.Color(24, 24, 24));
        jBDenuncias.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBDenuncias.setForeground(new java.awt.Color(246, 242, 242));
        jBDenuncias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/MegafoneIcon.png"))); // NOI18N
        jBDenuncias.setText("Denúncias");
        jBDenuncias.setBorder(null);
        jBDenuncias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBDenuncias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBDenunciasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jBDenunciasMouseExited(evt);
            }
        });
        jBDenuncias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDenunciasActionPerformed(evt);
            }
        });
        jPanel2.add(jBDenuncias, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 440, 300, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 770));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Seja bem-vindo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 120, -1));

        jLNome.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLNome.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jLNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 560, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Quantidade de animais doados e adotados mensalmente");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 420, -1));

        jLFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FundoView.png"))); // NOI18N
        jLFundo.setPreferredSize(new java.awt.Dimension(1170, 1024));
        jPanel1.add(jLFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 1170, 1010));

        DashboardAdministrador.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DashboardAdministradorLayout = new javax.swing.GroupLayout(DashboardAdministrador);
        DashboardAdministrador.setLayout(DashboardAdministradorLayout);
        DashboardAdministradorLayout.setHorizontalGroup(
            DashboardAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DashboardAdministradorLayout.setVerticalGroup(
            DashboardAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardAdministrador)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardAdministrador)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLogoutMouseEntered
        // TODO add your handling code here:
        jBLogout.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBLogoutMouseEntered

    private void jBLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBLogoutMouseExited
        // TODO add your handling code here:
        jBLogout.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBLogoutMouseExited

    private void jBLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLogoutActionPerformed
        // TODO add your handling code here:
        int Option = JOptionPane.showConfirmDialog(null,"Você tem Certeza?","Atenção", JOptionPane.YES_NO_OPTION);
        if(Option == JOptionPane.YES_OPTION){
            Login Logout = new Login();
            this.dispose();
            Logout.setVisible(true);
        }
    }//GEN-LAST:event_jBLogoutActionPerformed

    private void jBAnimaisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAnimaisMouseEntered
        // TODO add your handling code here:
        jBAnimais.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBAnimaisMouseEntered

    private void jBAnimaisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAnimaisMouseExited
        // TODO add your handling code here:
        jBAnimais.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBAnimaisMouseExited

    private void jBAnimaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnimaisActionPerformed
        // TODO add your handling code here:
        verificarTelaAberta();
        
        Animais animais1 = new Animais(DashboardAdministrador, this.nomeFuncionario, this.emailFuncionario, this.funcao);
        telaAtual = animais1; // Atualiza a referência para a nova tela
        DashboardAdministrador.add(animais1);
        animais1.setVisible(true);
        animais1.setBounds(230, -30, 1170, 1024);
    }//GEN-LAST:event_jBAnimaisActionPerformed

    private void jBClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBClientesMouseEntered
        // TODO add your handling code here:
        jBClientes.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBClientesMouseEntered

    private void jBClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBClientesMouseExited
        // TODO add your handling code here:
        jBClientes.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBClientesMouseExited

    private void jBClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClientesActionPerformed
        // TODO add your handling code here:
        verificarTelaAberta();
        
        Clientes clientes = new Clientes(DashboardAdministrador, this.nomeFuncionario, this.emailFuncionario, this.funcao);
        telaAtual = clientes; // Atualiza a referência para a nova tela
        DashboardAdministrador.add(clientes);
        clientes.setVisible(true);
        clientes.setBounds(230, -30, 1170, 1024);
    }//GEN-LAST:event_jBClientesActionPerformed

    private void jBDoacoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBDoacoesMouseEntered
        // TODO add your handling code here:
        jBDoacoes.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBDoacoesMouseEntered

    private void jBDoacoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBDoacoesMouseExited
        // TODO add your handling code here:
        jBDoacoes.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBDoacoesMouseExited

    private void jBDoacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDoacoesActionPerformed
        // TODO add your handling code here:
        verificarTelaAberta();

        // Cria a nova tela de Doações
        Doacoes doacoes = new Doacoes(DashboardAdministrador, this.nomeFuncionario, this.emailFuncionario, this.funcao);
        telaAtual = doacoes; // Atualiza a referência para a nova tela
        DashboardAdministrador.add(doacoes); // Adiciona a nova tela ao DesktopPane
        doacoes.setVisible(true); // Torna a nova tela visível
        doacoes.setBounds(230, -30, 1170, 1024); // Define o tamanho e a posição
    }//GEN-LAST:event_jBDoacoesActionPerformed

    private void jBAdocoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAdocoesMouseEntered
        // TODO add your handling code here:
        jBAdocoes.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBAdocoesMouseEntered

    private void jBAdocoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAdocoesMouseExited
        // TODO add your handling code here:
        jBAdocoes.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBAdocoesMouseExited

    private void jBAdocoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdocoesActionPerformed
        // TODO add your handling code here:
        verificarTelaAberta();

        // Cria a nova tela de Doações
        Adocoes adocoes = new Adocoes(DashboardAdministrador, this.nomeFuncionario, this.emailFuncionario, this.funcao);
        telaAtual = adocoes; // Atualiza a referência para a nova tela
        DashboardAdministrador.add(adocoes); // Adiciona a nova tela ao DesktopPane
        adocoes.setVisible(true); // Torna a nova tela visível
        adocoes.setBounds(230, -30, 1170, 1024); // Define o tamanho e a posição
    }//GEN-LAST:event_jBAdocoesActionPerformed

    private void jBFuncionariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBFuncionariosMouseEntered
        // TODO add your handling code here:
        jBFuncionarios.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBFuncionariosMouseEntered

    private void jBFuncionariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBFuncionariosMouseExited
        // TODO add your handling code here:
        jBFuncionarios.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBFuncionariosMouseExited

    private void jBFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFuncionariosActionPerformed
        // TODO add your handling code here:
        verificarTelaAberta();

        // Cria a nova tela de Doações
        Funcionarios funcionarios = new Funcionarios(this.nomeFuncionario, this.emailFuncionario);
        telaAtual = funcionarios; // Atualiza a referência para a nova tela
        DashboardAdministrador.add(funcionarios); // Adiciona a nova tela ao DesktopPane
        funcionarios.setVisible(true); // Torna a nova tela visível
        funcionarios.setBounds(230, -30, 1170, 1024); // Define o tamanho e a posição
    }//GEN-LAST:event_jBFuncionariosActionPerformed

    private void jBHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBHomeMouseEntered
        // TODO add your handling code here:
        jBHome.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBHomeMouseEntered

    private void jBHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBHomeMouseExited
        // TODO add your handling code here:
        jBHome.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBHomeMouseExited

    private void jBHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHomeActionPerformed
        // Verifica se uma tela está aberta
        if (telaAtual != null){
            telaAtual.dispose();
        }
    }//GEN-LAST:event_jBHomeActionPerformed

    private void jBDenunciasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBDenunciasMouseEntered
        // TODO add your handling code here:
        jBDenuncias.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBDenunciasMouseEntered

    private void jBDenunciasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBDenunciasMouseExited
        // TODO add your handling code here:
        jBDenuncias.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBDenunciasMouseExited

    private void jBDenunciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDenunciasActionPerformed
        // TODO add your handling code here:
        verificarTelaAberta();

        Denuncias denuncias = new Denuncias(DashboardAdministrador, this.nomeFuncionario, this.emailFuncionario, this.funcao);  // Passa o WorkspaceFuncionario
        telaAtual = denuncias; // Atualiza a referência para a nova tela
        DashboardAdministrador.add(denuncias);
        denuncias.setVisible(true);
        denuncias.setBounds(230, -30, 1170, 1024);
    }//GEN-LAST:event_jBDenunciasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane DashboardAdministrador;
    private javax.swing.JButton jBAdocoes;
    private javax.swing.JButton jBAnimais;
    private javax.swing.JButton jBClientes;
    private javax.swing.JButton jBDenuncias;
    private javax.swing.JButton jBDoacoes;
    private javax.swing.JButton jBFuncionarios;
    private javax.swing.JButton jBHome;
    private javax.swing.JButton jBLogout;
    private javax.swing.JLabel jLFundo;
    private javax.swing.JLabel jLGraficoDenuncias;
    private javax.swing.JLabel jLGraficoDinheiro;
    private javax.swing.JLabel jLGraficoDoacoes;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPGraficoDenuncias;
    private javax.swing.JPanel jPGraficoDinheiro;
    private javax.swing.JPanel jPGraficoDoacoes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
