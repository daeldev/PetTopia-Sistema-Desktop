    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package Utils;

import java.time.LocalDate;
    
    public class FuncionarioModel {
        private int id_funcionario;
        private String nome_funcionario;
        private String cpf_funcionario;
        private String email;
        private String passwordFuncionario;
        private LocalDate data_emissao;
        private String tipoFuncionario;
        
        public int getId_funcionario() {
            return id_funcionario;
        }

        public void setId_funcionario(int id_funcionario) {
            this.id_funcionario = id_funcionario;
        }

        public String getNome_funcionario() {
            return nome_funcionario;
        }

        public void setNome_funcionario(String nome_funcionario) { 
                this.nome_funcionario = nome_funcionario;
        }

        public String getCpf_funcionario() {
             return cpf_funcionario;
        }

        public void setCpf_funcionario(String cpf_funcionario) {
                this.cpf_funcionario = cpf_funcionario;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPasswordFuncionario() {
            return passwordFuncionario;
        }

        public void setPasswordFuncionario(String passwordFuncionario) {
                this.passwordFuncionario = passwordFuncionario;
        }

        public LocalDate getData_emissao() {
            return data_emissao;
        }

        public void setData_emissao(LocalDate data_emissao) {
            this.data_emissao = data_emissao;
        }

        public String getTipoFuncionario() {
            return tipoFuncionario;
        }

        public void setTipoFuncionario(String tipoFuncionario) {
            this.tipoFuncionario = tipoFuncionario;
        }
    }
