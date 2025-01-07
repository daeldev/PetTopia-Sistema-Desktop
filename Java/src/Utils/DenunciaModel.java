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
public class DenunciaModel {
    private int idDenuncia;
    private String tipoDenucias;
    private String descricao;
    private LocalDate dataDenuncia;
    private String statusGeral;
    private ClienteModel cliente;
    private EnderecoModel endereco;

    public int getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(int idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public String getTipoDenucias() {
        return tipoDenucias;
    }

    public void setTipoDenucias(String tipoDenucias) {
        this.tipoDenucias = tipoDenucias;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataDenuncia() {
        return dataDenuncia;
    }

    public void setDataDenuncia(LocalDate dataDenuncia) {
        this.dataDenuncia = dataDenuncia;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public String getStatusGeral() {
        return statusGeral;
    }

    public void setStatusGeral(String statusGeral) {
        this.statusGeral = statusGeral;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }
}
