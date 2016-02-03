package demo;

import java.util.EmptyStackException;
import java.util.Stack;

public class DemoReadingBraces {

	public static void main(String[] args) {
		
		String code = "public class MainDemo{ "
				+ "public static void main(String[] args) { "
				+ "Collection<E>`+ String s; "
				+ "class Brand { "
				+ "void say(){ "
				+ "System.out.println(\"Hi\");"
				+ "} "
				+ "}"
				+ "Brand c = new Brand(){"
				+ "void say(){"
				+ "System.out.println(\"bye\");"
				+ "}"
				+ "};"
				+ "c.say();"
				+ "}"
				+ "}";
		
		Stack<Character> braces = new Stack<>();
		for (int i = 0; i < code.length(); i++) {
			if (code.charAt(i) == '{') {
				if (braces.size() > 0 && braces.peek() == '{') {
					System.out.println();
					for (int j = 0; j < braces.size(); j++) {
						System.out.print("\t");
					}
				}
				braces.push(code.charAt(i));
				System.out.print("{ ... ");
			}
			if (code.charAt(i) == '}') {
				
				if (braces.size()<=0) {
					System.out.println("The first brace is a closing one, so there is a missing opening one before that!");
					return;
				}
				braces.pop();
				System.out.println();
				for (int j = 0; j < braces.size(); j++) {
					System.out.print("\t");
				}
				System.out.println("}");
				
				/* Using try catch, although it is a RuntimeException
				try {
					braces.pop();
					System.out.println();
					for (int j = 0; j < braces.size(); j++) {
						System.out.print("\t");
					}
					System.out.println("}");
				} catch (EmptyStackException e) {
					System.out.println("The first brace is a closing one, so there is a missing opening one before that!");
					return;
				}
				*/
			}
		}
		System.out.println((braces.size() > 0)? "Not all braces are closed!" : "All braces are closed");
	}
}
