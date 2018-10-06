package dictionary3;

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
	//Đọc từ file này ghi vào file khác
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
	//Thêm dữ liệu vào file
	void addFile(){
		try{
			FileWriter writer=new FileWriter("dictionaries.txt",true);//Ghi tiep vao cuoi file
			String s;
			Scanner input=new Scanner(System.in);
			s=input.nextLine();
			writer.write(s+"\n");
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//Xóa dữ liệu trong file
	void deleteFile(String s){
		ReadAndWrite();
		ArrayList<String> list=new ArrayList<String>();
		TextFile(list);
		int i;
		for(i=0;i<list.size();i++) {
			if (list.get(i).equals(s)) {
				list.remove(i);
				list.remove(i);
				break;
			}
		}
		try{
			FileWriter writer=new FileWriter("dictionaries.txt");
			for(i=0;i<list.size();i=i+2){
				writer.write(list.get(i)+"	"+list.get(i+1)+"\n");
			}
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		//Ghi lại vào file Dictionary.txt
		ReadAndWrite();
	}
}

