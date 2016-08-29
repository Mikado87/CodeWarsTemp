import java.util.ArrayList; 

public class Robot {
	
	static ArrayList robotsWords = new ArrayList();
		public void learnWord(String word){
			
			if (word.matches("^[a-zA-Z ]+")){
				
				if(this.isWordKnows(word.toLowerCase().trim())){
					System.out.println("I already know the word " + word);
				}else{
					robotsWords.add(word.toLowerCase().trim());
					System.out.println("Thank you for teaching me " + word);
				}
			}else {
				System.out.println("I do not understand the input");
				
			}
		}
		
		public boolean isWordKnows (String word){
			Boolean answer=false;
			if (robotsWords.size() != 0){
				for (int i=0; i<robotsWords.size(); i++){
					if (word.toLowerCase().trim().equals((String) robotsWords.get(i))){
						answer=true;
					}
				}
			}
			return answer;
		}
}

