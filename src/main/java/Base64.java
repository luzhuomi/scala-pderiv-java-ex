import java.io.BufferedReader;
import java.io.FileReader;
import com.github.luzhuomi.regex.*;
import java.util.List;

public class Base64
{
	private static final String REGEX = "^\\s*(?:(?:[a-zA-Z0-9+/]\\s*){4})*(?:(?:[a-zA-Z0-9+/]\\s*){2}\\s*[a-zA-Z0-9+/=]\\s*=)?\\s*$";
	public static void main(String[] args) 
	{
		CompiledPattern4J p = new CompiledPattern4J(REGEX);
		try (BufferedReader br = new BufferedReader(new FileReader("/tmp/base64.txt"))) 
		{
			String line;
			while ((line = br.readLine()) != null) 
			{
				if (p.isSucc())  // check whether compilation is successful
				{
					List<String> env = p.exec(line);
					System.out.println(env);
				} else 
				{
					System.out.println("not matched.");
				}
			}
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}