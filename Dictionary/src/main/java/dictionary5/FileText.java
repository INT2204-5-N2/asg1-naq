package dictionary5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileText {
	//Tạo file dictionaries
	void WriteAFile(String s,String k){
		try{
			FileWriter writer=new FileWriter(s);
			writer.write(k);
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	//Đọc từ file này ghi vào file khác
	void ReadAndWrite(String s,String k){
		try{
			FileWriter writer=new FileWriter(s);
			File file=new File(k);
			Scanner sc=new Scanner(file);
			String line=new String("");
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
	void TextFile(ArrayList<String> list,String s){
		//ArrayList<String> list=new ArrayList<String>();
		try{
			File file=new File(s);
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
	void ToFile(ArrayList<String> list,String s){
		try{
			FileWriter writer=new FileWriter(s);
			for(int i=0;i<list.size();i++){
				writer.write(list.get(i)+"\n");
			}
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	void updateEnglish(){
		ArrayList<String> list=new ArrayList<String>();
		ArrayList<String> temp=new ArrayList<String>();
		TextFile(list,"C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\Dictionary.txt");
		for(int i=0;i<list.size();i=i+2){
			temp.add(list.get(i));
		}
		ToFile(temp,"C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\English.txt");
	}
	//Thêm dữ liệu vào file
	void addFile(){
		try{
			FileWriter writer=new FileWriter("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\dictionaries.txt",true);//Ghi tiep vao cuoi file
			String s;
			Scanner input=new Scanner(System.in);
			s=input.nextLine();
			writer.write(s+"\n");
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		//Thêm hàm sắp xếp
		sortFile("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\dictionaries.txt");
	}
	void addFile(String s){
		try{
			FileWriter writer=new FileWriter("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\dictionaries.txt",true);//Ghi tiếp vào cuối file
			writer.write(s);
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		//Thêm hàm sắp xếp
		sortFile("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\dictionaries.txt");
	}
	//Xóa dữ liệu trong file
	void deleteFile(String s){
		//ReadAndWrite();
		ArrayList<String> list=new ArrayList<String>();
		TextFile(list,"C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\Dictionary.txt");
		int i;
		for(i=0;i<list.size();i=i+2) {
			if (list.get(i).equals(s)) {
				list.remove(i);
				list.remove(i);
				break;
			}
		}
		try{
			FileWriter writer=new FileWriter("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\dictionaries.txt");
			for(i=0;i<list.size();i=i+2){
				writer.write(list.get(i)+"	"+list.get(i+1)+"\n");
			}
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		ReadAndWrite("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\Dictionary.txt","C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\dictionaries.txt");
		updateEnglish();
	}
	//Hàm sắp xếp một file
	public void sortFile(String s){
		ArrayList<String> list=new ArrayList<String>();
		TextFile(list,"C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\dictionaries.txt");
		Collections.sort(list);
		try{
			FileWriter writer=new FileWriter("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\dictionaries.txt");
			for(int i=0;i<list.size();i=i+1){
				writer.write(list.get(i)+"\n");
			}
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		//Ghi lại vào file Dictionary.txt
		ReadAndWrite("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\Dictionary.txt","C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\dictionaries.txt");
		updateEnglish();
	}
}

