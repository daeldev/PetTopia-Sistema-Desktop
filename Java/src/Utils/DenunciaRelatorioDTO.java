/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.List;

/**
 *
 * @author Oliveira
 */
public class DenunciaRelatorioDTO {
    private List<DenunciaModel> denuncias;
    private FuncionarioModel funcionario;
    private byte[] relatorio;

    // Getters e Setters
    public List<DenunciaModel> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<DenunciaModel> denuncias) {
        this.denuncias = denuncias;
    }

    public FuncionarioModel getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioModel funcionario) {
        this.funcionario = funcionario;
    }

    public byte[] getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(byte[] relatorio) {
        this.relatorio = relatorio;
    }
}
