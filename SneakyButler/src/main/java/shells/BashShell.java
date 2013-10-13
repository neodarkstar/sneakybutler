package shells;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class BashShell implements Shell{

	@Override
	public String executeCommand(String command) {
		
		Runtime runtime = Runtime.getRuntime();
		String output = "";
		
		try {
			Process process = runtime.exec(command);
			process.waitFor();
			
			InputStreamReader reader = new InputStreamReader(process.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			while(bufferedReader.ready()){
				output += bufferedReader.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
	}
	
	

}
