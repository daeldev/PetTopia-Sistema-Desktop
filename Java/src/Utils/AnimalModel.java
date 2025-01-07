/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.time.LocalDate;

/**
 *
 * @author Oliveira
 */
public class AnimalModel {
    private int idAnimal;
    private String nome;
    private String especie;
    private String raca;
    private String idade;
    private String descricao;
    private String cor;
    private String sexo;
    private double peso;
    private byte[] fotoAnimal;
    private boolean adocao;
    private ClienteModel cliente;  // Alterado para incluir ClienteModel

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public byte[] getFotoAnimal() {
        return fotoAnimal;
    }

    public void setFotoAnimal(byte[] fotoAnimal) {
        this.fotoAnimal = fotoAnimal;
    }

    public ClienteModel getCliente() {  // Novo método para acessar o cliente
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {  // Novo método para definir o cliente
        this.cliente = cliente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isAdocao() {
        return adocao;
    }

    public void setAdocao(boolean adocao) {
        this.adocao = adocao;
    }
}
