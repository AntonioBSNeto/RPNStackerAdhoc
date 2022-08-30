import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Stack;

public class Rpn {

	String path = this.getClass().getClassLoader().getResource("").getPath();

	public static void main(String[] args) {

		Path path = FileSystems.getDefault().getPath("");
		String directoryName = path.toAbsolutePath().toString();
		System.out.println(directoryName);
		File inputFile = new File("Calc1.stk");
		System.out.println();
		Scanner reader = null;
		Stack<String> rpnStack = new Stack<String>();
		
		try {
			reader = new Scanner(inputFile);
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				System.out.println(line);
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

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (reader != null) {
				reader.close();
			}
			System.out.println(rpnStack.pop());
		}
		
	}
}
