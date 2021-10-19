import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*Grupo:
Andressa Pacheco Ribeiro RA: 21457347
Leonardo de Oliveira Oi RA: 21481427
Nicholas Silva Santos RA: 21391541
*/

public class AppBusca {
    
    public static void main(String[] args)  {

        String filepath = "ArquivoDados.csv";
        System.out.println("Digite o nome completo, para buscar dados do(a) cliente:\n");
       
          Scanner scanner = new Scanner(System.in);          
          String searchTerm = scanner.nextLine(); 
    
          readFile(searchTerm,filepath);
       
          while(!searchTerm.equals("exit")){
            System.out.println("Digite novamento o nome completo do(a) cliente:\n");
            searchTerm = scanner.nextLine();

            readFile(searchTerm,filepath);
          }
    }

    public static void readFile( String searchTerm, String filepath ){

        boolean found = false;
        String nome = ""; String sexo = ""; String  endereço = "";
        String cidade = ""; String email = "";
        String telefone = ""; String idade = ""; 

      
        try {
              Scanner scanner = new Scanner(new File(filepath));
              scanner.useDelimiter("[,\n]");

              while (scanner.hasNext() && !found ) {

                  nome = scanner.next();
                  sexo = scanner.next();
                  endereço = scanner.next();
                  cidade = scanner.next();
                  email = scanner.next();
                  telefone  = scanner.next();
                  idade = scanner.next();

                    if (nome.equals(searchTerm)) {
                        found = true;
                    }
              }
                
              if (found) {
                  
                  System.out.println("Nome: " + nome + "\n"
                  + "Genêro: " + sexo  + "\n"  
                  + "Endereço: " + endereço + "\n"
                  + "E-mail: " + email +  "\n"
                  + "Telefone: " + telefone   + "\n" 
                  + "Idade: " +  idade + "\n" );
              }                       
              else {                      
                  System.out.print("Usuario não encontrado!\n");
              }   
          } 
        catch (IOException ex)
         {
            System.out.println(ex.getMessage());
        }
      }
}
     