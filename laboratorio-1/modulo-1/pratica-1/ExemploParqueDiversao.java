
/**
 * Gustavo Joner
 */
public class ExemploParqueDiversao
{
    public static void main(String args[]){   
              
       //declarar e atribuir valor para a constante: IDADE_MINIMA para acesso ao brinquedo
       final int IDADE_MINIMA = 12;
       
       //declarar e atribuir valor as variáveis:
       // - seuNome, primeiraLetraNome, idade, valorBrinquedo
       String seuNome = "Maria"; //tipo de dado objeto para sequencia de caracteres
       char primeiraLetraNome = 'M'; //tipo de dado primitivo para caracter (apenas um)
       int idade = 15; //tipo de dado primitivo número inteiro
       double valorBrinquedo = 3.5; //tipo de dado primitivo número real  
    
       //imprimir as mensagens na tela
       System.out.print("Olá ");
       System.out.println(seuNome);
       System.out.printf("A primeira letra do seu nome é: %c. \n", primeiraLetraNome);
       System.out.printf("Sua idade é: %d.", idade);
       System.out.printf("A idade mínima para acessar este brinquedo é: %d. \n", IDADE_MINIMA);
       System.out.printf("O valor do brinquedo é: %4.2f.", valorBrinquedo);
    }
}
