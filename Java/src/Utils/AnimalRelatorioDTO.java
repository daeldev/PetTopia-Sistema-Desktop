/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

/**
 *
 * @author Oliveira
 */
import java.util.List;

import java.util.List;

public class AnimalRelatorioDTO {
    private List<AnimalModel> animais;
    private FuncionarioModel funcionario;
    private byte[] relatorio;  // Campo para armazenar o conteúdo do relatório em formato binário

    // Getters e Setters
    public List<AnimalModel> getAnimais() {
        return animais;
    }

    public void setAnimais(List<AnimalModel> animais) {
        this.animais = animais;
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