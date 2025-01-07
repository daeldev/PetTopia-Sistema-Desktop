/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.awt.image.BufferedImage;

/**
 *
 * @author Oliveira
 */
public class DashboardGraficoDTO {
    private BufferedImage graficoDenuncia;
    private BufferedImage graficoDinheiro;
    private BufferedImage graficoDoacaoAdocao;

    public BufferedImage getGraficoDenuncia() {
        return graficoDenuncia;
    }

    public void setGraficoDenuncia(BufferedImage graficoDenuncia) {
        this.graficoDenuncia = graficoDenuncia;
    }

    public BufferedImage getGraficoDinheiro() {
        return graficoDinheiro;
    }

    public void setGraficoDinheiro(BufferedImage graficoDinheiro) {
        this.graficoDinheiro = graficoDinheiro;
    }

    public BufferedImage getGraficoDoacaoAdocao() {
        return graficoDoacaoAdocao;
    }

    public void setGraficoDoacaoAdocao(BufferedImage graficoDoacaoAdocao) {
        this.graficoDoacaoAdocao = graficoDoacaoAdocao;
    }
}

