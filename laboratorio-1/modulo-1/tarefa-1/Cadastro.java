
/**
 * Gustavo Joner
 */
public class Cadastro
{
    public static void main(String args[]){
        System.out.println("-== Cadastro de Atletas ==-");
        String nome = Teclado.leString("Nome: ");
        int ano = Teclado.leInt("Ano de Nascimento: ");
        char categoria = Teclado.leChar("Categoria: [M]irim, [J]únior, [A]dulto, [V]eterano ");
        char sexo = Teclado.leChar("Sexo [M/F]: ");
        double peso = Teclado.leDouble("Peso [Kg]: ");
        double altura = Teclado.leDouble("Altura [m]: ");
        System.out.println("-======== Endereço ========-");
        String cidade = Teclado.leString("Cidade: ");
        String bairro = Teclado.leString("Bairro: ");
        String rua = Teclado.leString("Rua: ");
        int numero = Teclado.leInt("Número: ");
        
        int idade = 2022 - ano;
        double imc = peso / altura * altura;
        
        System.out.println("-======= Cadastrado =======-");
        System.out.println("");
        System.out.println("-==========================-");
        System.out.println("Nome: " + nome);
        System.out.println("Categoria: " + categoria);
        System.out.println("Idade: " + idade);
        System.out.println("Sexo: " + sexo);
        System.out.println("IMC: " + imc);
        System.out.print("Endereço: ");
        System.out.print("Cidade " + cidade + ", " + bairro);
        System.out.println("");
        System.out.println("Rua " + rua + ", " + numero);
        System.out.println("-==========================-");
    }
}
