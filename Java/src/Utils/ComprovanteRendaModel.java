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
public class ComprovanteRendaModel {
    private int idDocumento;
    private byte[] arquivo;
    private ClienteModel cliente;
    private AnimalModel animal;
    private String status;
    private LocalDate tempoExclusao;

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public AnimalModel getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalModel animal) {
        this.animal = animal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getTempoExclusao() {
        return tempoExclusao;
    }

    public void setTempoExclusao(LocalDate tempoExclusao) {
        this.tempoExclusao = tempoExclusao;
    }
}
