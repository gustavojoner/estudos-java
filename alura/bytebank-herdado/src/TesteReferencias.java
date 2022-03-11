
public class TesteReferencias {
	public static void main(String[] args) {
		
		Gerente g1 = new Gerente();
		g1.setSalario(5000);
		System.out.println(g1.getBonificacao());
		
		Designer d = new Designer();
		d.setSalario(2000);
		System.out.println(d.getBonificacao());
		
		EditorVideo ev = new EditorVideo();
		ev.setSalario(4000);
		System.out.println(ev.getBonificacao());
		
		ControleBonificacao controle = new ControleBonificacao();
		controle.registra(g1);
		controle.registra(d);
		controle.registra(ev);
		
		System.out.println(controle.getSoma());
		
	}

}
