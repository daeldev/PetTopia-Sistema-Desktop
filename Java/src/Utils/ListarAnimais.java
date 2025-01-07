/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oliveira
 */
public class ListarAnimais {
    // Método para listar os animais com o filtro desejado
    public void listarAnimais(DefaultTableModel tabela, String filtro) {
        // Instância a classe de conexão
        HttpConnection httpConnection = new HttpConnection();

        // Chama o método para listar todos os animais
        List<AnimalModel> animais = httpConnection.listarAnimais();

        // Limpa a tabela antes de adicionar os novos dados
        tabela.setRowCount(0);

        // Itera sobre a lista de animais e adiciona os dados na tabela
        for (AnimalModel animal : animais) {
            // Transforma "_" em espaço e coloca tudo minúsculo
            String especie = animal.getEspecie().toLowerCase();
            String raca = animal.getRaca().toLowerCase().replace("_", " ");
            String sexo = animal.getSexo().toLowerCase();
            String idade = animal.getIdade().toLowerCase().replace("_", " ");
            String cor = animal.getCor().toLowerCase();

            // Coloca a inicial maiúscula
            especie = Character.toUpperCase(especie.charAt(0)) + especie.substring(1);
            raca = Character.toUpperCase(raca.charAt(0)) + raca.substring(1);
            sexo = Character.toUpperCase(sexo.charAt(0)) + sexo.substring(1);
            idade = Character.toUpperCase(idade.charAt(0)) + idade.substring(1);
            cor = Character.toUpperCase(cor.charAt(0)) + cor.substring(1);

            // Configurações de formato para usar a vírgula como separador decimal
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
            symbols.setDecimalSeparator(',');

            // Formato com três casas decimais
            DecimalFormat df = new DecimalFormat("#,##0.000", symbols);

            // Exibindo o valor formatado
            String pesoFormatado = df.format(animal.getPeso()) + "kg";

            // Obtém o nome do cliente ou "NÃO VINCULADO"
            String nomeCliente = (animal.getCliente() == null || animal.getCliente().getNome() == null) ? "NÃO VINCULADO" : animal.getCliente().getNome();

            // Se o filtro for "sem_cliente", filtra apenas os animais sem cliente
            if ("sem_cliente".equals(filtro) && !nomeCliente.equals("NÃO VINCULADO")) {
                continue;  // Ignora esse animal
            }

            // Se o filtro for de um cliente específico, filtra apenas os animais desse cliente
            if (filtro != null && !filtro.isEmpty() && !nomeCliente.equals(filtro)) {
                continue;  // Ignora esse animal
            }

            // Adiciona os dados na tabela
            Object[] dados = {
                nomeCliente,
                animal.getNome(),
                especie,
                raca,
                sexo,
                idade,
                cor,
                pesoFormatado,
                animal.getIdAnimal()
            };
            tabela.addRow(dados);
        }
    }
}
