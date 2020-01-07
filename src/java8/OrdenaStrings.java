package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = Arrays.asList("editora casa codigo", "alura online", "caelum");
		
		//ANTES DO JAVA 8
		// Comparator<String> compara = new ComparadorPorTamanho();

		// Collections.sort(palavras,compara);
		// palavras.sort(compara);

		// -----------------------

		//No java 8: 
		
		
//		palavras.sort(( s1,  s2) -> {
//				if (s1.length() < s2.length())
//					return -1;
//				if (s1.length() > s2.length())
//					return 1;
//
//				return 0;
//	
//		});

		//Conseguimos melhorar esse codigo de cima assim:
		
		palavras.sort(( s1,  s2) ->  Integer.compare(s1.length(), s2.length()));
		
		//A mesma forma de fazer isso, era assim tbm:
		
		palavras.sort((Comparator.comparing(s -> s.length() )));
		palavras.sort((Comparator.comparing(String::length )));
		
		//Essa sintaxe: String::length , é equivalente a isso: s -> s.length() 
		//--------------
		
		//ANTES DO JAVA 8 FAZENDO UM FOR:
		// for(String s : palavras) {

		// System.out.println(s);
		// }
		
		// -----------------------

		// Essa é a nova forma de iterar todos os elementos de uma coleção
//		Consumer<String> consumidor = new Consumer<String>() {
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//			}
//
//		};

//		palavras.forEach(new Consumer<String>() {
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//			}
//
//		});

//		palavras.forEach((String s) -> {
//				System.out.println(s);
//			}
//
//		);

		//No java 8: 
		palavras.forEach(s -> System.out.println(s)); // Lambda, o compilador ja sabe qual o tipo, etc

	}
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);
	}

}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;

		return 0;
	}

}