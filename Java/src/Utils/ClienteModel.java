/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Oliveira
 */
public class ClienteModel {
    private int idCliente;
    private String cpf;
    private String nome;
    private String email;
    private String password_Cliente;
    private String telefone;
    private String generoCliente;
    @JsonFormat(pattern = "yyyy-MM-dd") // Certifique-se de que está aqui
    private LocalDate data_nascimento;
    private LocalDate data_Cadastro;
    private String resetToken;
    private LocalDateTime resetTokenExpiration;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_Cliente() {
        return password_Cliente;
    }

    public void setPassword_Cliente(String password_Cliente) {
        this.password_Cliente = password_Cliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGeneroCliente() {
        return generoCliente;
    }

    public void setGeneroCliente(String generoCliente) {
        this.generoCliente = generoCliente;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
            this.data_nascimento = data_nascimento;
    }

    public LocalDate getData_Cadastro() {
        return data_Cadastro;
    }

    public void setData_Cadastro(LocalDate data_Cadastro) {
        this.data_Cadastro = data_Cadastro;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public LocalDateTime getResetTokenExpiration() {
        return resetTokenExpiration;
    }

    public void setResetTokenExpiration(LocalDateTime resetTokenExpiration) {
        this.resetTokenExpiration = resetTokenExpiration;
    }
}
