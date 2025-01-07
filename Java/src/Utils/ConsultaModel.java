/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Oliveira
 */
public class ConsultaModel {
    private int id_consulta;
    private LocalDate data_comeco;
    private LocalDate data_final;
    private String descricao;
    private String tipoConsultas;
    private String status_consulta;
    private ClienteModel cliente;
    private AnimalModel animal;

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public LocalDate getData_comeco() {
        return data_comeco;
    }

    public void setData_comeco(String data_comeco) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Converte a String para LocalDate
        LocalDate dataConvertida = LocalDate.parse(data_comeco, formatter);
        this.data_comeco = dataConvertida;
    }

    public LocalDate getData_final() {
        return data_final;
    }

    public void setData_final(String data_final) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Converte a String para LocalDate
        LocalDate dataConvertida = LocalDate.parse(data_final, formatter);
        this.data_comeco = dataConvertida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoConsultas() {
        return tipoConsultas;
    }

    public void setTipoConsultas(String tipoConsultas) {
        this.tipoConsultas = tipoConsultas;
    }

    public String getStatus_consulta() {
        return status_consulta;
    }

    public void setStatus_consulta(String status_consulta) {
        this.status_consulta = status_consulta;
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
}
