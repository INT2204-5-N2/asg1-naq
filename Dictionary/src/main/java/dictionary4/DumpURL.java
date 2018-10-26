package dictionary4;

import java.io.*;
import java.net.*;
public class DumpURL{
	public static void main(String[] args){
		try{
			URL url=new URL("https://english4u.com.vn/Uploads/files/3000.pdf");
			URLConnection conn=url.openConnection();
			InputStream stream=conn.getInputStream();
			InputStreamReader ir=new InputStreamReader(stream);
			BufferedReader reader=new BufferedReader(ir);
			String line;
			while((line=reader.readLine())!=null){
				System.out.println(line);
			}
			reader.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

