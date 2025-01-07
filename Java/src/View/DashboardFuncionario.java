package View;

import Utils.HttpConnection;
import Utils.SessionManager;
import java.util.Map;
import java.util.TimerTask;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Aluno.Tarde
 */
public class DashboardFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form TelaAtendenteNova
     */
    
    private Timer sessionChecker;
    private SessionManager sessionManager;
    
    public DashboardFuncionario() {
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
                // Atualiza as estatisticas periodicamente
                EstatisticasEmAndamento();
            }
        }, 0, 5000); // Atualiza a cada 5000 ms (5 segundos)
    }
    
    public void EstatisticasEmAndamento(){
        HttpConnection httpConnection = new HttpConnection();
        Map<String, Long> estatisticas = httpConnection.obterEstatisticasEmAndamento();
        jLDenuciasAndamento.setText(estatisticas.get("denunciasEmAndamento").toString());
        jLDoacoesAndamento.setText(estatisticas.get("doacoesEmAndamento").toString());
        jLAdocoesAndamento.setText(estatisticas.get("adocoesEmAndamento").toString());
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
    private String funcao;
    private String emailFuncionario;
    private String nomeFuncionario;
    public void dadosFuncionario(String nomeFuncionario, String emailFuncionario, String funcao){
        this.emailFuncionario = emailFuncionario;
        this.funcao = funcao;
        this.nomeFuncionario = nomeFuncionario;
        jLNome.setText(nomeFuncionario);
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

        DashboardFuncionario = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLNome = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLAdocoesAndamento = new javax.swing.JLabel();
        jLGrafico = new javax.swing.JLabel();
        jLVisualizarAdocoes = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLDoacoesAndamento = new javax.swing.JLabel();
        jLGrafico1 = new javax.swing.JLabel();
        jLVisualizarDoacoes = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLDenuciasAndamento = new javax.swing.JLabel();
        jLGrafico2 = new javax.swing.JLabel();
        jLVisualizarDenuncias = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jBHome = new javax.swing.JButton();
        jBAdocoes = new javax.swing.JButton();
        jBDenuncias = new javax.swing.JButton();
        jBDoacoes = new javax.swing.JButton();
        jBAnimais = new javax.swing.JButton();
        jBClientes = new javax.swing.JButton();
        jBLogout = new javax.swing.JButton();
        jLFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Seja bem-vindo");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 120, -1));

        jLNome.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLNome.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jLNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 560, 30));

        jPanel5.setBackground(new java.awt.Color(24, 24, 24));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(246, 242, 242));
        jLabel7.setText("Adoções em andamento");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, 20));

        jLAdocoesAndamento.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLAdocoesAndamento.setForeground(new java.awt.Color(246, 242, 242));
        jPanel5.add(jLAdocoesAndamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 20));

        jLGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/AdocaoIcon.png"))); // NOI18N
        jPanel5.add(jLGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 56, -1, -1));

        jLVisualizarAdocoes.setBackground(new java.awt.Color(0, 0, 0));
        jLVisualizarAdocoes.setForeground(new java.awt.Color(246, 242, 242));
        jLVisualizarAdocoes.setText("Visualizar");
        jLVisualizarAdocoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLVisualizarAdocoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLVisualizarAdocoesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLVisualizarAdocoesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLVisualizarAdocoesMouseExited(evt);
            }
        });
        jPanel5.add(jLVisualizarAdocoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 60, 20));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 160, 300, 160));

        jPanel4.setBackground(new java.awt.Color(24, 24, 24));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(246, 242, 242));
        jLabel5.setText("Doações em andamento");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 190, 20));

        jLDoacoesAndamento.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLDoacoesAndamento.setForeground(new java.awt.Color(246, 242, 242));
        jPanel4.add(jLDoacoesAndamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 20));

        jLGrafico1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/DoacaoIcon.png"))); // NOI18N
        jPanel4.add(jLGrafico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 56, -1, -1));

        jLVisualizarDoacoes.setBackground(new java.awt.Color(0, 0, 0));
        jLVisualizarDoacoes.setForeground(new java.awt.Color(246, 242, 242));
        jLVisualizarDoacoes.setText("Visualizar");
        jLVisualizarDoacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLVisualizarDoacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLVisualizarDoacoesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLVisualizarDoacoesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLVisualizarDoacoesMouseExited(evt);
            }
        });
        jPanel4.add(jLVisualizarDoacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 60, 20));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 300, 160));

        jPanel3.setBackground(new java.awt.Color(24, 24, 24));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(246, 242, 242));
        jLabel3.setText("Denúncias pendentes");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 180, 20));

        jLDenuciasAndamento.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLDenuciasAndamento.setForeground(new java.awt.Color(246, 242, 242));
        jPanel3.add(jLDenuciasAndamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 20));

        jLGrafico2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/MegafoneIcon.png"))); // NOI18N
        jPanel3.add(jLGrafico2, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 56, -1, -1));

        jLVisualizarDenuncias.setBackground(new java.awt.Color(0, 0, 0));
        jLVisualizarDenuncias.setForeground(new java.awt.Color(246, 242, 242));
        jLVisualizarDenuncias.setText("Visualizar");
        jLVisualizarDenuncias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLVisualizarDenuncias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLVisualizarDenunciasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLVisualizarDenunciasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLVisualizarDenunciasMouseExited(evt);
            }
        });
        jPanel3.add(jLVisualizarDenuncias, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 60, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 300, 160));

        jPanel2.setBackground(new java.awt.Color(24, 24, 24));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/PetTopiaLogo.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 130));

        jBHome.setBackground(new java.awt.Color(24, 24, 24));
        jBHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBHome.setForeground(new java.awt.Color(246, 242, 242));
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
        jPanel2.add(jBHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 160, 320, 50));

        jBAdocoes.setBackground(new java.awt.Color(24, 24, 24));
        jBAdocoes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBAdocoes.setForeground(new java.awt.Color(246, 242, 242));
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
        jPanel2.add(jBAdocoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 510, 300, 50));

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
        jPanel2.add(jBDenuncias, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 370, 290, 50));

        jBDoacoes.setBackground(new java.awt.Color(24, 24, 24));
        jBDoacoes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBDoacoes.setForeground(new java.awt.Color(246, 242, 242));
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
        jPanel2.add(jBDoacoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 440, 300, 50));

        jBAnimais.setBackground(new java.awt.Color(24, 24, 24));
        jBAnimais.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBAnimais.setForeground(new java.awt.Color(246, 242, 242));
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
        jPanel2.add(jBAnimais, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 300, 300, 50));

        jBClientes.setBackground(new java.awt.Color(24, 24, 24));
        jBClientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jBClientes.setForeground(new java.awt.Color(246, 242, 242));
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
        jPanel2.add(jBClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 230, 300, 50));

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
        jPanel2.add(jBLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 650, 310, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 730));

        jLFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FundoDashboard.png"))); // NOI18N
        jPanel1.add(jLFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 700));

        DashboardFuncionario.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DashboardFuncionarioLayout = new javax.swing.GroupLayout(DashboardFuncionario);
        DashboardFuncionario.setLayout(DashboardFuncionarioLayout);
        DashboardFuncionarioLayout.setHorizontalGroup(
            DashboardFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DashboardFuncionarioLayout.setVerticalGroup(
            DashboardFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardFuncionario)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardFuncionario)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        Adocoes adocoes = new Adocoes(DashboardFuncionario, this.nomeFuncionario, this.emailFuncionario, this.funcao);
        telaAtual = adocoes; // Atualiza a referência para a nova tela
        DashboardFuncionario.add(adocoes); // Adiciona a nova tela ao DesktopPane
        adocoes.setVisible(true); // Torna a nova tela visível
        adocoes.setBounds(230, -30, 1170, 1024); // Define o tamanho e a posição
    }//GEN-LAST:event_jBAdocoesActionPerformed

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

        Denuncias denuncias = new Denuncias(DashboardFuncionario, this.nomeFuncionario, this.emailFuncionario, this.funcao);  // Passa o WorkspaceFuncionario
        telaAtual = denuncias; // Atualiza a referência para a nova tela
        DashboardFuncionario.add(denuncias);
        denuncias.setVisible(true);
        denuncias.setBounds(230, -30, 1170, 1024);
    }//GEN-LAST:event_jBDenunciasActionPerformed

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
        Doacoes doacoes = new Doacoes(DashboardFuncionario, null,this.emailFuncionario, this.funcao);
        telaAtual = doacoes; // Atualiza a referência para a nova tela
        DashboardFuncionario.add(doacoes); // Adiciona a nova tela ao DesktopPane
        doacoes.setVisible(true); // Torna a nova tela visível
        doacoes.setBounds(230, -30, 1170, 1024); // Define o tamanho e a posição
    }//GEN-LAST:event_jBDoacoesActionPerformed

    private void jBAnimaisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAnimaisMouseEntered
        // TODO add your handling code here:
        jBAnimais.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_jBAnimaisMouseEntered

    private void jBAnimaisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBAnimaisMouseExited
        // TODO add your handling code here:
        jBAnimais.setBackground(new java.awt.Color(24,24,24));
    }//GEN-LAST:event_jBAnimaisMouseExited

    private void jBAnimaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnimaisActionPerformed
         // Verifica se uma tela está aberta
        verificarTelaAberta();
        
        Animais animais1 = new Animais(DashboardFuncionario, this.nomeFuncionario, this.emailFuncionario, this.funcao);
        telaAtual = animais1; // Atualiza a referência para a nova tela
        DashboardFuncionario.add(animais1);
        animais1.setVisible(true);
        animais1.setBounds(230, -30, 1170, 1024);
    }//GEN-LAST:event_jBAnimaisActionPerformed

    private void jBClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBClientesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jBClientesMouseEntered

    private void jBClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBClientesMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jBClientesMouseExited

    private void jBClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClientesActionPerformed
        // TODO add your handling code here:
        verificarTelaAberta();
        
        Clientes clientes = new Clientes(DashboardFuncionario, this.nomeFuncionario, this.emailFuncionario, this.funcao);
        telaAtual = clientes; // Atualiza a referência para a nova tela
        DashboardFuncionario.add(clientes);
        clientes.setVisible(true);
        clientes.setBounds(230, -30, 1170, 1024);
    }//GEN-LAST:event_jBClientesActionPerformed

    private void jLVisualizarDenunciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVisualizarDenunciasMouseClicked
        // TODO add your handling code here:
        Denuncias denuncias = new Denuncias(DashboardFuncionario, this.nomeFuncionario, this.emailFuncionario, this.funcao);  // Passa o WorkspaceFuncionario
        telaAtual = denuncias; // Atualiza a referência para a nova tela
        DashboardFuncionario.add(denuncias);
        denuncias.setVisible(true);
        denuncias.setBounds(230, -30, 1170, 1024);
    }//GEN-LAST:event_jLVisualizarDenunciasMouseClicked

    private void jLVisualizarDenunciasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVisualizarDenunciasMouseEntered
        // TODO add your handling code here:
        jLVisualizarDenuncias.setForeground(new java.awt.Color(91,192,222));
    }//GEN-LAST:event_jLVisualizarDenunciasMouseEntered

    private void jLVisualizarDenunciasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVisualizarDenunciasMouseExited
        // TODO add your handling code here:
        jLVisualizarDenuncias.setForeground(new java.awt.Color(246,242,242));
    }//GEN-LAST:event_jLVisualizarDenunciasMouseExited

    private void jLVisualizarDoacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVisualizarDoacoesMouseClicked
        // TODO add your handling code here:
        Doacoes doacoes = new Doacoes(DashboardFuncionario, null, this.emailFuncionario, this.funcao);  // Passa o WorkspaceFuncionario
        telaAtual = doacoes; // Atualiza a referência para a nova tela
        DashboardFuncionario.add(doacoes);
        doacoes.setVisible(true);
        doacoes.setBounds(230, -30, 1170, 1024);
    }//GEN-LAST:event_jLVisualizarDoacoesMouseClicked

    private void jLVisualizarDoacoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVisualizarDoacoesMouseEntered
        // TODO add your handling code here:
        jLVisualizarDoacoes.setForeground(new java.awt.Color(91,192,222));
    }//GEN-LAST:event_jLVisualizarDoacoesMouseEntered

    private void jLVisualizarDoacoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVisualizarDoacoesMouseExited
        // TODO add your handling code here:
        jLVisualizarDoacoes.setForeground(new java.awt.Color(246,242,242));
    }//GEN-LAST:event_jLVisualizarDoacoesMouseExited

    private void jLVisualizarAdocoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVisualizarAdocoesMouseClicked
        // TODO add your handling code here:
        Adocoes adocoes = new Adocoes(DashboardFuncionario, this.nomeFuncionario, this.emailFuncionario, this.funcao);  // Passa o WorkspaceFuncionario
        telaAtual = adocoes; // Atualiza a referência para a nova tela
        DashboardFuncionario.add(adocoes);
        adocoes.setVisible(true);
        adocoes.setBounds(230, -30, 1170, 1024);
    }//GEN-LAST:event_jLVisualizarAdocoesMouseClicked

    private void jLVisualizarAdocoesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVisualizarAdocoesMouseEntered
        // TODO add your handling code here:
        jLVisualizarAdocoes.setForeground(new java.awt.Color(91,192,222));
    }//GEN-LAST:event_jLVisualizarAdocoesMouseEntered

    private void jLVisualizarAdocoesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVisualizarAdocoesMouseExited
        // TODO add your handling code here:
        jLVisualizarAdocoes.setForeground(new java.awt.Color(246,242,242));
    }//GEN-LAST:event_jLVisualizarAdocoesMouseExited

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
            java.util.logging.Logger.getLogger(DashboardFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new DashboardFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane DashboardFuncionario;
    private javax.swing.JButton jBAdocoes;
    private javax.swing.JButton jBAnimais;
    private javax.swing.JButton jBClientes;
    private javax.swing.JButton jBDenuncias;
    private javax.swing.JButton jBDoacoes;
    private javax.swing.JButton jBHome;
    private javax.swing.JButton jBLogout;
    private javax.swing.JLabel jLAdocoesAndamento;
    private javax.swing.JLabel jLDenuciasAndamento;
    private javax.swing.JLabel jLDoacoesAndamento;
    private javax.swing.JLabel jLFundo;
    private javax.swing.JLabel jLGrafico;
    private javax.swing.JLabel jLGrafico1;
    private javax.swing.JLabel jLGrafico2;
    private javax.swing.JLabel jLNome;
    private javax.swing.JLabel jLVisualizarAdocoes;
    private javax.swing.JLabel jLVisualizarDenuncias;
    private javax.swing.JLabel jLVisualizarDoacoes;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
