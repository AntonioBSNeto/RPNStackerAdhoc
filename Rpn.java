import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


public class Rpn {

	public static void main(String[] args) {

		File inputFile = new File("Calc1.stk");
		Scanner reader = null;
		Stack<String> rpnStack = new Stack<String>();
		
		try {
			reader = new Scanner(inputFile);
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				int fstTerm, sndTerm;
        TokenType op;
				if (line.matches("[0-9]+")) {
          System.out.println(new Token(TokenType.NUM, line)); 
          rpnStack.push(line);
				}else {
          if (!rpnStack.isEmpty()){
            sndTerm = Integer.parseInt(rpnStack.pop());
          }else {
            rpnStack.push("Error: Unexpected charecter: "+ line);
            break;
          }
          if (!rpnStack.isEmpty()){
            fstTerm = Integer.parseInt(rpnStack.pop());
          }else {
            rpnStack.push("Error: Unexpected charecter: "+ line);
            break;
          }
					if(line.equals("+")) {
            rpnStack.push(fstTerm+sndTerm+"");
            op = TokenType.PLUS;
					} else if (line.equals("-")) {
            op = TokenType.MINUS;
						rpnStack.push(fstTerm-sndTerm+"");
					} else if (line.equals("*")) {
            op = TokenType.STAR;
						rpnStack.push(fstTerm*sndTerm+"");
					} else if (line.equals("/")) {
            op = TokenType.SLASH;
						rpnStack.push(((int)fstTerm/sndTerm)+"");
					} else {
            rpnStack.push("Error: Unexpected charecter: "+ line);
            break;
          }
          System.out.println(new Token(op, line)); 
				}		
			}

		} catch (IOException e) {
			/* DO NOTHING */
		} finally {
			if (reader != null) {
				reader.close();
			}
			System.out.println(rpnStack.pop());
		}
		
	}
}
