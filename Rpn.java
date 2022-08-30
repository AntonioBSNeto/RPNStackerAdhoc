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
				if (line.matches("[0-9]+")) {
					rpnStack.push(line);
				}else {
					sndTerm = Integer.parseInt(rpnStack.pop());
					fstTerm = Integer.parseInt(rpnStack.pop());
					if(line.equals("+")) {
						rpnStack.push(fstTerm+sndTerm+"");
					} else if (line.equals("-")) {
						rpnStack.push(fstTerm-sndTerm+"");
					} else if (line.equals("*")) {
						rpnStack.push(fstTerm*sndTerm+"");
					} else {
						rpnStack.push(((int)fstTerm/sndTerm)+"");
					}
				}		
			}

		} catch (IOException e) {
			// 
		} finally {
			if (reader != null) {
				reader.close();
			}
			System.out.println(rpnStack.pop());
		}
		
	}
}
