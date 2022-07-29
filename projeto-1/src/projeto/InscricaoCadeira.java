package projeto;

public class InscricaoCadeira
{
    //Atributos
    private String nomeAluno;
    private int numeroMatricula;
    private String nomeCadeira;
    private String diaCadeira;
 
    
    
    //Construtor
    public InscricaoCadeira(String nA, int nM, String nC, String dC) {
        nomeAluno = nA;
        numeroMatricula = nM;
        nomeCadeira = nC;
        diaCadeira = dC;
    }
    
    public String getNomeAluno() {
        return nomeAluno;
    }
    
    public int getNumeroMatricula(){
        return numeroMatricula;
    }
    
    public String getNomeCadeira(){
        return nomeCadeira;
    }
    
    public String getDiaCadeira(){
        return diaCadeira;
    }
    
    //utiliza o método set para mudar o dia da cadeira caso necessário
    public void setDiaCadeira(String diaCadeira){
        this.diaCadeira=diaCadeira;
    }
    
    //metodo que exibe dados da inscrição do aluno na cadeira
    public void exibeDados(){
    
        System.out.println ("Nome do Aluno: " + nomeAluno );
        System.out.println ("\nNumero de Matrícula: " + numeroMatricula);
        System.out.println ("\nCadeira: " + nomeCadeira);
        System.out.println ("\nDia da Aula: " + diaCadeira);
    }
    

}
