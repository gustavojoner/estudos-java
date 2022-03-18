import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExemploCursos {

    private String nome;
    private int alunos;

    public ExemploCursos(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }

	public static void main(String[] args) {
		List<ExemploCursos> cursos = new ArrayList<ExemploCursos>();
		cursos.add(new ExemploCursos("Python", 45));
		cursos.add(new ExemploCursos("Java 8", 113));
		cursos.add(new ExemploCursos("JavaScript", 150));
		cursos.add(new ExemploCursos("C", 55));
		
		cursos.sort(Comparator.comparing(ExemploCursos::getAlunos));
		
		cursos.stream()
		.filter(c -> c.getAlunos() >= 100)
		.forEach(c -> System.out.println(c.getNome()));
	}
}

