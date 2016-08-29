
public class RobotTest {

	public static void main(String[] args) {
		String s= null;
		s += 2;
		System.out.println(s);
		Robot vicky = new Robot(); 
		vicky.learnWord("Hello");
		vicky.learnWord("23Hello");
		vicky.learnWord("Goodbye");
		vicky.learnWord(" ");
		vicky.learnWord(" HeLLo");
		vicky.learnWord("hello");
		vicky.learnWord(" ");
		vicky.learnWord("HELLO");
		
		Robot nicky = new Robot();
		
		nicky.learnWord(" Hello");	
	}

}
