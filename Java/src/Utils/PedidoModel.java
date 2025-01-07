/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;

/**
 *
 * @author Oliveira
 */

public class PedidoModel {
    
    private int idPedido;
    private String statusPedido;
    private byte[] comprovante; // O PDF em formato de byte[]
    private ClienteModel cliente;
    private AnimalModel animal;
    private String codigoComprovante;  
    private String tipo;
    private LocalDate dataPedido;
    private boolean valido;

    public byte[] getComprovante() {
        return comprovante;
    }

    public void setComprovante(byte[] comprovante) {
        this.comprovante = comprovante;
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

    public String getCodigoComprovante() {
        return codigoComprovante;
    }

    public void setCodigoComprovante(String codigoComprovante) {
        this.codigoComprovante = codigoComprovante;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }
    
    @JsonIgnore
    public String getMes() {
        if (dataPedido != null) {
            return dataPedido.getMonth().toString(); // Retorna o nome do mês (ex: "JANUARY")
        }
        return null;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
}
