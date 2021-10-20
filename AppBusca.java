import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*Grupo:
Andressa Pacheco Ribeiro RA: 21457347
Leonardo de Oliveira Oi RA: 21481427
Nicholas Silva Santos RA: 21391541
*/

public class AppBusca {

    public static void main(String[] args) {

        String[][] dadosClientes = new String[5824][6];
        int count = 0;

        try {
            File file = new File("arquivoDados.csv");

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String linha = scanner.nextLine();
    
                dadosClientes[count] = linha.split(",");

                count++;

            }

            scanner.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        BuscarCliente busca = new BuscarCliente(dadosClientes);

        String nomePesquisa = "";
        Scanner sc = new Scanner(System.in);

        while (nomePesquisa.equals("exit") == false) {
            System.out.println();
            System.out.println("Olá, digite o nome completo do(a) cliente para buscar dados\n");
            System.out.println("Para sair digite 'exit'\n");
            nomePesquisa = sc.nextLine();
            System.out.println();

            if (nomePesquisa.equals("exit") == false) {

                int resultado = busca.pesquisaBinaria(nomePesquisa);

                if (resultado == -1) {
                    System.out.println("Cliente não encontrado");
                    System.out.println("Comparações: " + busca.getComparacoes());
                } else {
                    System.out.println("Nome encontrado na posição [" + resultado + "] do vetor" );
                    System.out.println();
                    
                    System.out.println("Nome: " + dadosClientes[resultado][0] + "\n" +
                    "Sexo: " + dadosClientes[resultado][1] + "\n" +
                    "Endereço: " + dadosClientes[resultado][2] + "\n" +
                    "Cidade: " + dadosClientes[resultado][3] + "\n" +
                    "E-mail: " + dadosClientes[resultado][4] + "\n" +
                    "Telefone: " + dadosClientes[resultado][5] + "\n" +
                    "Idade: " + dadosClientes[resultado][6] + "\n");
                    System.out.println("Comparações: " + busca.getComparacoes());
                }
            }
        }

    }

}