import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("Alura online");
		palavras.add("Casa do código");
		palavras.add("Caelum");

//		palavras.sort((s1, s2) -> {
//			if (s1.length() < s2.length())
//				return -1;
//			if (s2.length() > s2.length())
//				return 1;
//			return 0;
//		});

		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		System.out.println(palavras);

		palavras.forEach(s -> System.out.println(s));
	}

}
