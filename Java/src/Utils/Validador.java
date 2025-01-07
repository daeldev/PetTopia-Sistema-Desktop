/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Oliveira
 */
public class Validador {
    private final String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private final Pattern emailPattern = Pattern.compile(emailRegex);
  
    
    public boolean validarFuncionario(String email, String senha){ 
        FuncionarioModel funcionarioDTO = new FuncionarioModel();
        // Recupera o e-mail do administrador
        funcionarioDTO.setEmail(email);
        funcionarioDTO.setPasswordFuncionario(senha);
        
        HttpConnection autenciar = new HttpConnection();
        FuncionarioModel response = autenciar.login(funcionarioDTO);
        
        if(response != null){
            return true;
        }else{
            return false;
        }
    }
    
    // Validação do email
    public boolean validarEmail(String email) {
        return email != null && emailPattern.matcher(email).matches();
    }
    
    // Validação da senha (ao menos 1 dígito e sem espaços)
    public boolean validarSenha(String senha) {
        return senha != null && !senha.contains(" ") && senha.length() > 0;
    }
    
    // Método para validar nomes
    public boolean validarNome(String nome) {
        // Remover espaços em branco do início e fim
        nome = nome.trim();

        // Verificar se o nome é vazio ou contém caracteres inválidos (permitir letras e espaços)
        if (nome.isEmpty() || !nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
            return false;
        }
        return true;
    }
    
    public boolean validarCpf(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (como 111.111.111-11, 222.222.222-22, etc.)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Validação dos dígitos verificadores
        char dig10, dig11;
        int sm, i, r;
        int num[] = new int[11];
        for (i = 0; i < 11; i++) {
            num[i] = Character.getNumericValue(cpf.charAt(i));
        }

        sm = 0;
        for (i = 0; i < 9; i++) {
            sm += (10 - i) * num[i];
        }
        r = 11 - (sm % 11);
        dig10 = (r == 10 || r == 11) ? '0' : Character.forDigit(r, 10);
        if (dig10 != cpf.charAt(9)) {
            return false;
        }

        sm = 0;
        for (i = 0; i < 10; i++) {
            sm += (11 - i) * num[i];
        }
        r = 11 - (sm % 11);
        dig11 = (r == 10 || r == 11) ? '0' : Character.forDigit(r, 10);
        if (dig11 != cpf.charAt(10)) {
            return false;
        }

        return true; // CPF é válido
    }
    
    // Método para validar a data de nascimento no formato dd/MM/yyyy
    public boolean validarDataNascimento(String dataNascimento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Não permite datas inválidas, como 31/02/2023

        try {
            Date data = sdf.parse(dataNascimento); // Tenta fazer o parsing da data
            Date dataAtual = new Date(); // Data atual

            // Verifica se a data é futura
            if (data.after(dataAtual)) {
                return false; // Data de nascimento não pode ser no futuro
            }

            // Verifica se a pessoa é maior de 18 anos
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(data); // Define a data de nascimento
            calendar.add(Calendar.YEAR, 18); // Adiciona 18 anos
            Date dataLimite = calendar.getTime(); // Data limite de 18 anos

            return !dataLimite.after(dataAtual); // Retorna true se a data de nascimento for anterior à data limite

        } catch (ParseException e) {
            return false; // Formato de data inválido
        }
    }
    
    // Método para validar o telefone no formato (XX) XXXXX-XXXX
    public boolean validarTelefone(String telefone) {
        // Expressão regular para o formato (XX) XXXXX-XXXX
        String regex = "^\\(\\d{2}\\) \\d{5}-\\d{4}$";

        // Compilando a expressão regular
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefone);

        // Verifica se o telefone corresponde ao formato
        if (!matcher.matches()) {
            return false; // Não corresponde ao formato esperado
        }

        // Remove caracteres não numéricos para verificação adicional
        String numero = telefone.replaceAll("[^0-9]", "");

        // Verifica se todos os dígitos são iguais (ex: 00000-0000)
        if (numero.matches("(\\d)\\1{10}")) {
            return false; // Todos os dígitos são iguais
        }

        // Verifica se contém pelo menos um dígito diferente de zero
        for (char c : numero.toCharArray()) {
            if (c != '0') {
                return true; // Número válido
            }
        }

        return false; // Caso contrário, o número é inválido
    }
    
     // Método para validar o CEP no formato XXXXX-XXX
    public boolean validarCep(String cep) {
        // Regex para aceitar apenas o formato XXXXX-XXX
        String regex = "^[0-9]{5}-[0-9]{3}$";
        
        // Verifica se o CEP corresponde ao formato esperado
        return cep != null && cep.matches(regex);
    }
    
    public boolean validarComplemento(String complemento) {
        if (complemento == null || complemento.trim().isEmpty()) {
            return false; // Complemento não pode ser vazio
        }
        String regex = "^[a-zA-Z0-9\\s\\.\\-\\/]+$"; // Permite letras, números e alguns símbolos
        return complemento.matches(regex);
    }
    
    public boolean validarNumeroCasa(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            return false; // O número não pode ser vazio
        }
        // Permite dígitos, letras e alguns caracteres especiais como barra e hífen
        return numero.matches("^[0-9]+[a-zA-Z]?[\\-\\/]?[0-9]*$");
    }
    
    // Método para validar o peso
    public boolean validarPeso(String pesoStr) {
        // Verifica se o peso é nulo ou vazio
        if (pesoStr == null || pesoStr.isEmpty()) {
            return false; // Peso inválido se não foi preenchido
        }

        try {
            // Tenta converter o peso para double
            double peso = Double.parseDouble(pesoStr);

            // Verifica se o peso é menor ou igual a 0
            if (peso <= 0) {
                return false; // Peso inválido, pois deve ser maior que 0
            }

            // Verifica se o peso é maior que o peso máximo permitido
            if (peso > 150) {
                return false; // Peso inválido, pois excede o limite máximo
            }

            return true; // Peso válido
        } catch (NumberFormatException e) {
            // Se não puder converter para double, retorna false
            return false; // Peso inválido se não for um número
        }
    }
}
