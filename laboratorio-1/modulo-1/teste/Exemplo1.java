
/**
 * Gustavo Joner
 */
public class Exemplo1
{
   public static void main(String args[]){
       //Entrada de dados
       String nome; //declaracao de variavel
       nome = Teclado.leString("Digite seu nome: ");
       int idade = Teclado.leInt("Digite sua idade: ");
       
       //Saida de dados
       System.out.println("Nome: " + nome);
       System.out.print("Idade: " + idade);
    }
}