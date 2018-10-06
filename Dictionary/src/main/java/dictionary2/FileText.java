package dictionary2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileText {
	//Tạo file dictionaries
	void WriteAFile(){
		try{
			FileWriter writer=new FileWriter("dictionaries.txt");
			writer.write("dog	chó\ncat	mèo\nfish	cá\nbird	chim\ntiger	hổ\n");
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	//Đọc từ file này vào file khác
	void ReadAndWrite(){
		try{
			FileWriter writer=new FileWriter("Dictionary.txt");
			File file=new File("dictionaries.txt");
			Scanner sc=new Scanner(file);
			String line=null;
			while(sc.hasNextLine()){
				line=sc.nextLine();
				String[] results=line.split("	");
				for(String temp:results){
					writer.write(temp+"\n");
				}
			}
			writer.close();
			sc.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//Ghi file vào danh sách mảng
	void TextFile(ArrayList<String> list){
		//ArrayList<String> list=new ArrayList<String>();
		try{
			File file=new File("Dictionary.txt");
			Scanner sc=new Scanner(file);
			while(sc.hasNextLine()){
				String line=sc.nextLine();
				list.add(line);
			}
			sc.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

