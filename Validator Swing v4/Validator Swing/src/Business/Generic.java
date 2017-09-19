package Business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Generic {

	public static String printHelp () throws FileNotFoundException{
		FileReader arqR = new FileReader(new File("WhiteListData/help.txt")); 
		BufferedReader lerArq = new BufferedReader(arqR);
		String helpText = "";
			try {
				while(true){
					String line=lerArq.readLine();
					//System.out.println(line);
					if(line==null)
						return helpText;
					else
						helpText = helpText + "\n" + line;
						//System.out.println(helpText);
				}
			} catch (IOException e) { 
				System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage()); 
			}
			return helpText;
	}
}
