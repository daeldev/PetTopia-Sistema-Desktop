/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class HttpConnection {
    
    private final String apiUrl = "http://localhost:8081/api/";
    private final ObjectMapper mapper;
    
    public HttpConnection() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // Suporte para LocalDate e outras classes de data
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false); // Para formatar as datas em um formato legÃ­vel, como 'yyyy-MM-dd'
    }


    public FuncionarioModel login(FuncionarioModel funcionarioDTO) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "funcionario/LoginNormal");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String inputJson = mapper.writeValueAsString(funcionarioDTO);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(inputJson.getBytes());
                os.flush();
            }

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para FuncionarioModel
                    return mapper.readValue(response.toString(), FuncionarioModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public FuncionarioModel cadastrarFuncionario(FuncionarioModel funcionarioDTO) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "adm/cadastrar/funcionario");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String inputJson = mapper.writeValueAsString(funcionarioDTO);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(inputJson.getBytes());
                os.flush();
            }

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para FuncionarioModel
                    return mapper.readValue(response.toString(), FuncionarioModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public FuncionarioModel editarFuncionario(long id, FuncionarioModel funcionarioDTO) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "adm/atualizarFuncionario/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Serializa o clienteDTO para JSON
            String inputJson = mapper.writeValueAsString(funcionarioDTO);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(inputJson.getBytes());
                os.flush();
            }

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para ClienteModel
                    return mapper.readValue(response.toString(), FuncionarioModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public boolean deletarFuncionario(long id) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "adm/deletarFuncionario/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT || conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                }
                return true;
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
                return false;
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
            return false;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
    
    public FuncionarioModel buscarFuncionario(long id) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "adm/buscarFuncionario/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para ClienteModel
                    return mapper.readValue(response.toString(), FuncionarioModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public List<FuncionarioModel> listarFuncionarios() {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "adm/listar/funcionario");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para uma lista de FuncionarioModel
                    return Arrays.asList(mapper.readValue(response.toString(), FuncionarioModel[].class));
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return new ArrayList<>();  // Retorna uma lista vazia caso ocorra erro
    }
    
    public ClienteModel cadastrarCliente(ClienteModel clienteDTO) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "cliente/cadastrarJava");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Serializa o clienteDTO para JSON
            String inputJson = mapper.writeValueAsString(clienteDTO);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(inputJson.getBytes());
                os.flush();
            }

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para ClienteModel
                    return mapper.readValue(response.toString(), ClienteModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public ClienteModel buscarCliente(long id) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "funcionario/ClienteBuscar/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para ClienteModel
                    return mapper.readValue(response.toString(), ClienteModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public ClienteModel editarCliente(long id, ClienteModel clienteDTO) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "cliente/atualizar/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Serializa o clienteDTO para JSON
            String inputJson = mapper.writeValueAsString(clienteDTO);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(inputJson.getBytes());
                os.flush();
            }

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para ClienteModel
                    return mapper.readValue(response.toString(), ClienteModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public boolean deletarCliente(long id) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "cliente/deletarCliente/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT || conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                }
                return true;
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
                return false;
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
            return false;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
    
    public List<ClienteModel> listarClientes() {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "adm/listar/cliente");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para uma lista de FuncionarioModel
                    return Arrays.asList(mapper.readValue(response.toString(), ClienteModel[].class));
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return new ArrayList<>();  // Retorna uma lista vazia caso ocorra erro
    }
    
    public ConsultaModel cadastrarConsulta(ConsultaModel consultaDTO) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "cliente/agendarConsulta");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String inputJson = mapper.writeValueAsString(consultaDTO);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(inputJson.getBytes());
                os.flush();
            }

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para FuncionarioModel
                    return mapper.readValue(response.toString(), ConsultaModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public List<ConsultaModel> listarConsultas() {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "funcionario/ListarConsultas");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para uma lista de FuncionarioModel
                    return Arrays.asList(mapper.readValue(response.toString(), ConsultaModel[].class));
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return new ArrayList<>();  // Retorna uma lista vazia caso ocorra erro
    }
    
    public String buscarEnderecoPorCep(String cep) {
        String urlString = "https://viacep.com.br/ws/" + cep + "/json/";
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            
            if (con.getResponseCode() == 200) { // Sucesso
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString(); // Retorna a resposta JSON
            } else {
                System.out.println("Erro na requisição: " + con.getResponseCode());
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public DenunciaModel cadastrarDenuncia(DenunciaModel denunciaDTO) {
        HttpURLConnection conn = null;
        try {
            // URL do endpoint
            URL url = new URL(apiUrl + "cliente/RealizarDenuncia");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Converte o objeto DenunciaModel para JSON
            String inputJson = mapper.writeValueAsString(denunciaDTO);

            // Escreve o JSON no corpo da requisição
            try (OutputStream os = conn.getOutputStream()) {
                os.write(inputJson.getBytes());
                os.flush();
            }

            // Verifica o código de resposta
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para DenunciaModel
                    return mapper.readValue(response.toString(), DenunciaModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public DenunciaModel buscarDenuncia(long id) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "funcionario/Buscar/Denuncia/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para ClienteModel
                    return mapper.readValue(response.toString(), DenunciaModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public boolean editarDenuncia(long id, DenunciaModel denunciaDTO) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "cliente/AtualizarDenuncia/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Serializa o clienteDTO para JSON
            String inputJson = mapper.writeValueAsString(denunciaDTO);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(inputJson.getBytes());
                os.flush();
            }

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para ClienteModel
                    return true;
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return false;
    }
    
    public List<DenunciaModel> listarDenuncias() {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "funcionario/Listar/Denuncias");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para uma lista de DenunciaModel
                    return Arrays.asList(mapper.readValue(response.toString(), DenunciaModel[].class));
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return new ArrayList<>();  // Retorna uma lista vazia caso ocorra erro
    }
    
    // animais
    public AnimalModel cadastrarAnimal(AnimalModel animalDTO) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "funcionario/cadastrar/animal");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Converte o DTO para JSON (inclui ClienteModel agora)
            String inputJson = mapper.writeValueAsString(animalDTO);

            // Envio dos dados para o servidor
            try (OutputStream os = conn.getOutputStream()) {
                os.write(inputJson.getBytes());
                os.flush();
            }

            // Verifica se a resposta foi bem-sucedida (HTTP 200 OK)
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }

                    // Converte a resposta JSON para AnimalModel
                    return mapper.readValue(response.toString(), AnimalModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            // Log de erro com detalhes da exceção e do idCliente
            System.err.println("ERRO: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public AnimalModel buscarAnimal(long id) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "cliente/ListarAnimais/Modal/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para ClienteModel
                    return mapper.readValue(response.toString(), AnimalModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public AnimalModel editarAnimal(long id, AnimalModel animalDTO) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "cliente/atualizarAnimal/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Serializa o animalDTO para JSON
            String inputJson = mapper.writeValueAsString(animalDTO);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(inputJson.getBytes());
                os.flush();
            }

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para ClienteModel
                    return mapper.readValue(response.toString(), AnimalModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public List<AnimalModel> listarAnimaisPorCliente(int id) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "cliente/ListarAnimais/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para uma lista de DenunciaModel
                    return Arrays.asList(mapper.readValue(response.toString(), AnimalModel[].class));
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return new ArrayList<>();  // Retorna uma lista vazia caso ocorra erro
    }
    
    public List<AnimalModel> listarAnimaisAdocao() {
    HttpURLConnection conn = null;
    try {
        // Substitua com a URL correta do seu endpoint
        URL url = new URL(apiUrl + "funcionario/ListarAnimaisAdocao");
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");

        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                // Converte a resposta JSON para uma lista de AnimalModel
                return Arrays.asList(mapper.readValue(response.toString(), AnimalModel[].class));
            }
        } else {
            System.err.println("Erro na resposta: " + conn.getResponseCode());
        }
    } catch (Exception e) {
        System.err.println("ERRO: " + e);
    } finally {
        if (conn != null) {
            conn.disconnect();
        }
    }
    return new ArrayList<>();  // Retorna uma lista vazia caso ocorra erro
}
    
    public List<AnimalModel> listarAnimais() {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "funcionario/ListarAnimais");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para uma lista de FuncionarioModel
                    return Arrays.asList(mapper.readValue(response.toString(), AnimalModel[].class));
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return new ArrayList<>();  // Retorna uma lista vazia caso ocorra erro
    }
    
    public boolean deletarAnimal(long id) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "cliente/deletar/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT || conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                }
                return true;
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
                return false;
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
            return false;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
    
    public PedidoModel cadastrarPedidoDoacao(PedidoModel servicoModel) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "cliente/cadastrar/pedido/doacao");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Converte o id para JSON (inclui ClienteModel agora)
            String inputJson = mapper.writeValueAsString(servicoModel);

            // Envio dos dados para o servidor
            try (OutputStream os = conn.getOutputStream()) {
                os.write(inputJson.getBytes());
                os.flush();
            }

            // Verifica se a resposta foi bem-sucedida (HTTP 200 OK)
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }

                    // Converte a resposta JSON para AnimalModel
                    return mapper.readValue(response.toString(), PedidoModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            // Log de erro com detalhes da exceção e do idCliente
            System.err.println("ERRO: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;        
    }
    
    public ComprovanteRendaModel cadastrarPedidoAdocao(int idCliente, int idAnimal, byte[] fileBytes) {
        HttpURLConnection conn = null;
        try {
            // URL da API
            URL url = new URL(apiUrl + "cliente/enviarDocumentosTeste");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            // Converte byte[] para um File temporário
            File tempFile = new File("tempFile.pdf");
            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(fileBytes);
            }

            // Inicia a construção do corpo da requisição com multipart
            try (DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
                String boundary = "----WebKitFormBoundary7MA4YWxkTrZu0gW";
                String lineEnd = "\r\n";
                String twoHyphens = "--";

                // Envia parâmetros do cliente e do animal
                dos.writeBytes(twoHyphens + boundary + lineEnd);
                dos.writeBytes("Content-Disposition: form-data; name=\"idCliente\"" + lineEnd);
                dos.writeBytes("Content-Type: text/plain; charset=UTF-8" + lineEnd + lineEnd);
                dos.writeBytes(String.valueOf(idCliente) + lineEnd);

                dos.writeBytes(twoHyphens + boundary + lineEnd);
                dos.writeBytes("Content-Disposition: form-data; name=\"idAnimal\"" + lineEnd);
                dos.writeBytes("Content-Type: text/plain; charset=UTF-8" + lineEnd + lineEnd);
                dos.writeBytes(String.valueOf(idAnimal) + lineEnd);

                // Envia o arquivo (converting byte[] to FileBody)
                dos.writeBytes(twoHyphens + boundary + lineEnd);
                dos.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\"" + tempFile.getName() + "\"" + lineEnd);
                dos.writeBytes("Content-Type: application/octet-stream" + lineEnd + lineEnd);

                try (FileInputStream fis = new FileInputStream(tempFile)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        dos.write(buffer, 0, bytesRead);
                    }
                }

                dos.writeBytes(lineEnd);

                // Finaliza o envio dos dados
                dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

                // Obtém a resposta
                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }

                        // Aqui você deve mapear a resposta para a classe ComprovanteRendaModel
                        // Exemplo, se a resposta for um JSON, use uma biblioteca como Jackson ou Gson
                        // para desserializar a resposta em ComprovanteRendaModel
                        ObjectMapper mapper = new ObjectMapper();
                        return mapper.readValue(response.toString(), ComprovanteRendaModel.class);
                    }
                } else {
                    System.err.println("Erro na resposta: " + responseCode);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }

    public PedidoModel buscarPedido(long id) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "funcionario/buscarPedido/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para ServicoModel
                    return mapper.readValue(response.toString(), PedidoModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public List<PedidoModel> listarServicos() {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "funcionario/ListarServicos");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para uma lista de FuncionarioModel
                    return Arrays.asList(mapper.readValue(response.toString(), PedidoModel[].class));
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return new ArrayList<>();  // Retorna uma lista vazia caso ocorra erro
    }
    
    public boolean cancelarPedido(long idPedido) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "adm/cancelarPedido/" + idPedido);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true; // Retorna true se a resposta for 200 OK
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return false;
    }

    
    public boolean aceitarPedido(long idPedido) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "adm/aceitarPedido/" + idPedido);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");

            // Verifica se a resposta HTTP foi bem-sucedida
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return true;
            } else {
                System.err.println("Erro ao aceitar pedido: código de resposta HTTP " + responseCode);
            }
        } catch (Exception e) {
            System.err.println("Erro na conexão HTTP: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return false;
    }
    
    public boolean concluirPedido(long idPedido) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "funcionario/concluirPedido/" + idPedido);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return false;
    }
    
    public PedidoModel validarCodigoComprovante(String codigoComprovante) {
        HttpURLConnection conn = null;
        try {
            // URL do Spring Boot para a API
            URL url = new URL(apiUrl + "funcionario/validarCodigoComprovante/" + codigoComprovante); 
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Aqui não é necessário enviar o código como JSON no corpo, pois ele é passado pela URL
            // No caso, apenas a URL já está configurada para enviar o código como um parâmetro de caminho (Path Variable)

            // Verifica a resposta da requisição
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Lê a resposta do servidor
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }

                    // Converte a resposta JSON para o modelo ServicoModel usando ObjectMapper
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(response.toString(), PedidoModel.class);
                }
            } else {
                // Caso a resposta não seja OK, registra o erro
                System.err.println("Erro ao validar código: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log do erro para facilitar a identificação
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null; // Retorna null em caso de falha
    }
    
    public List<ComprovanteRendaModel> listarComprovantes() {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "cliente/ListarDocumentos");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para uma lista de FuncionarioModel
                    return Arrays.asList(mapper.readValue(response.toString(), ComprovanteRendaModel[].class));
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return new ArrayList<>();  // Retorna uma lista vazia caso ocorra erro
    }
    
    public ComprovanteRendaModel buscarComprovante(long id) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "adm/buscar/comprovante/" + id); // Corrigido
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Verifica se a resposta HTTP foi bem-sucedida
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    // Converte a resposta JSON para ServicoModel
                    return mapper.readValue(response.toString(), ComprovanteRendaModel.class);
                }
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
    
    public boolean validarComprovanteRenda(long idComprovante) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "adm/validarComprovante/" + idComprovante);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return false;
    }
    
    public boolean negarComprovanteRenda(long idComprovante) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl + "adm/negarComprovante/" + idComprovante);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("HttpConnection erro: " + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return false;
    }
    
    public boolean concluirPedidoAdocao(long idPedido) {
        HttpURLConnection conn = null;
        try {
            // URL do endpoint atualizado
            URL url = new URL(apiUrl + "funcionario/concluirPedidoAdocao/" + idPedido);

            // Abre a conexão HTTP
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Verifica se a resposta HTTP foi 200 (OK)
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            } else {
                System.err.println("Erro na resposta: " + conn.getResponseCode());
            }
        } catch (Exception e) {
            System.err.println("Erro na conexão HTTP: " + e.getMessage());
        } finally {
            // Garantir que a conexão seja fechada
            if (conn != null) {
                conn.disconnect();
            }
        }
        return false;
    }
    
    public DoacaoRelatorioDTO gerarRelatorioDoacoes(DoacaoRelatorioDTO relatorioDTO) {
        HttpURLConnection connection = null;

        try {
            // Cria o ObjectMapper e registra o módulo JSR310
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());  // Registra o módulo para suportar LocalDate
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);  // Desabilita o formato timestamp para datas

            // Configura a conexão
            URL url = new URL(apiUrl + "adm/gerarRelatorioDoacoes");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setDoOutput(true);

            // Converte o DTO para JSON
            String jsonInputString = objectMapper.writeValueAsString(relatorioDTO);

            // Envia o JSON
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Obtém a resposta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Processar a resposta do backend e retornar o DTO com o relatório
                InputStream responseStream = connection.getInputStream();
                return objectMapper.readValue(responseStream, DoacaoRelatorioDTO.class);
            } else {
                System.out.println("Erro na requisição: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    
    public AdocaoRelatorioDTO gerarRelatorioAdocoes(AdocaoRelatorioDTO relatorioDTO) {
        HttpURLConnection connection = null;

        try {
            // Cria o ObjectMapper e registra o módulo JSR310
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());  // Registra o módulo para suportar LocalDate
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);  // Desabilita o formato timestamp para datas

            // Configura a conexão
            URL url = new URL(apiUrl + "adm/gerarRelatorioAdocoes");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setDoOutput(true);

            // Converte o DTO para JSON
            String jsonInputString = objectMapper.writeValueAsString(relatorioDTO);

            // Envia o JSON
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Obtém a resposta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Processar a resposta do backend e retornar o DTO com o relatório
                InputStream responseStream = connection.getInputStream();
                return objectMapper.readValue(responseStream, AdocaoRelatorioDTO.class);
            } else {
                System.out.println("Erro na requisição: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    
    public DenunciaRelatorioDTO gerarRelatorioDenuncias(DenunciaRelatorioDTO relatorioDTO) {
        HttpURLConnection connection = null;

        try {
            // Cria o ObjectMapper e registra o módulo JSR310
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());  // Registra o módulo para suportar LocalDate
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);  // Desabilita o formato timestamp para datas

            // Configura a conexão
            URL url = new URL(apiUrl + "adm/gerarRelatorioDenuncias");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setDoOutput(true);

            // Converte o DTO para JSON
            String jsonInputString = objectMapper.writeValueAsString(relatorioDTO);

            // Envia o JSON
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Obtém a resposta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Processar a resposta do backend e retornar o DTO com o relatório
                InputStream responseStream = connection.getInputStream();
                return objectMapper.readValue(responseStream, DenunciaRelatorioDTO.class);
            } else {
                System.out.println("Erro na requisição: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    
    public AnimalRelatorioDTO gerarRelatorioAnimais(AnimalRelatorioDTO relatorioDTO) {
        HttpURLConnection connection = null;

        try {
            // Cria o ObjectMapper e registra o módulo JSR310
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());  // Registra o módulo para suportar LocalDate
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);  // Desabilita o formato timestamp para datas

            // Configura a conexão
            URL url = new URL(apiUrl + "adm/gerarRelatorioAnimais");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setDoOutput(true);

            // Converte o DTO para JSON
            String jsonInputString = objectMapper.writeValueAsString(relatorioDTO);

            // Envia o JSON
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Obtém a resposta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Processar a resposta do backend e retornar o DTO com o relatório
                InputStream responseStream = connection.getInputStream();
                return objectMapper.readValue(responseStream, AnimalRelatorioDTO.class);
            } else {
                System.out.println("Erro na requisição: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    
    public ClienteRelatorioDTO gerarRelatorioClientes(ClienteRelatorioDTO relatorioDTO) {
        HttpURLConnection connection = null;

        try {
            // Cria o ObjectMapper e registra o módulo JSR310
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());  // Registra o módulo para suportar LocalDate
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);  // Desabilita o formato timestamp para datas

            // Configura a conexão
            URL url = new URL(apiUrl + "adm/gerarRelatorioClientes");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setDoOutput(true);

            // Converte o DTO para JSON
            String jsonInputString = objectMapper.writeValueAsString(relatorioDTO);

            // Envia o JSON
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Obtém a resposta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Processar a resposta do backend e retornar o DTO com o relatório
                InputStream responseStream = connection.getInputStream();
                return objectMapper.readValue(responseStream, ClienteRelatorioDTO.class);
            } else {
                System.out.println("Erro na requisição: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    
    public FuncionarioRelatorioDTO gerarRelatorioFuncionarios(FuncionarioRelatorioDTO relatorioDTO) {
        HttpURLConnection connection = null;

        try {
            // Cria o ObjectMapper e registra o módulo JSR310
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());  // Registra o módulo para suportar LocalDate
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);  // Desabilita o formato timestamp para datas

            // Configura a conexão
            URL url = new URL(apiUrl + "adm/gerarRelatorioFuncionarios");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setDoOutput(true);

            // Converte o DTO para JSON
            String jsonInputString = objectMapper.writeValueAsString(relatorioDTO);

            // Envia o JSON
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Obtém a resposta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Processar a resposta do backend e retornar o DTO com o relatório
                InputStream responseStream = connection.getInputStream();
                return objectMapper.readValue(responseStream, FuncionarioRelatorioDTO.class);
            } else {
                System.out.println("Erro na requisição: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    
    public Map<String, byte[]> obterGraficos() {
        HttpURLConnection connection = null;
        Map<String, byte[]> graficosBytes = new HashMap<>();

        try {
            // Configura o ObjectMapper para processar JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Configura a URL do endpoint
            URL url = new URL(apiUrl + "adm/grafico"); // Substitua `apiUrl` pela URL base da API
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Obtém a resposta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lê a resposta JSON (com Base64 como valores)
                InputStream responseStream = connection.getInputStream();
                JavaType type = objectMapper.getTypeFactory().constructMapType(HashMap.class, String.class, String.class);
                Map<String, String> graficosBase64 = objectMapper.readValue(responseStream, type);

                // Converte as imagens Base64 para byte[] e coloca no mapa
                for (Map.Entry<String, String> entry : graficosBase64.entrySet()) {
                    byte[] imagemBytes = Base64.getDecoder().decode(entry.getValue());
                    graficosBytes.put(entry.getKey(), imagemBytes);
                }
            } else {
                System.out.println("Erro na requisição: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return graficosBytes;
    }
    
    public Map<String, Long> obterEstatisticasEmAndamento() {
        HttpURLConnection connection = null;
        Map<String, Long> estatisticas = new HashMap<>();

        try {
            // Configura o ObjectMapper para processar JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Configura a URL do endpoint
            URL url = new URL(apiUrl + "funcionario/EstatisticasEmAndamento"); // Substitua `apiUrl` pela URL base da API
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Obtém a resposta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lê a resposta JSON
                InputStream responseStream = connection.getInputStream();

                // Define o tipo do Map<String, Long> para deserializar a resposta
                JavaType type = objectMapper.getTypeFactory().constructMapType(HashMap.class, String.class, Long.class);

                // Converte a resposta JSON em um Map
                estatisticas = objectMapper.readValue(responseStream, type);

            } else {
                System.out.println("Erro na requisição: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return estatisticas;
    }
}   
    