
public class TesteSacaNegativo {
	public static void main(String[] args) {
		Conta gus = new Conta();
		gus.deposita(100);
		System.out.println(gus.saca(120));
		
		System.out.println(gus.getSaldo());
	}
}
