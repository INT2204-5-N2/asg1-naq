package dictionary5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
	//Tra cứu từ điển
	public String dictionaryLookup(String s){
		FileText file=new FileText();
		ArrayList<String> temp=new ArrayList<String>();
		file.TextFile(temp,"C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\Dictionary.txt");
		int i;
		int t=0;
		for(i=0;i<temp.size();i+=2){
			if(temp.get(i).equals(s)){
				return temp.get(i+1);
			}
			else t++;
		}
		if(t==temp.size()/2) return ". . .";
		else return "";
	}
	//Thêm dữ liệu vào từ điển
	public void addDictionary(){
		FileText file=new FileText();
		System.out.println("Bạn muốn thêm dữ liệu: ");
		file.addFile();
	}
	//Xóa dữ liệu ra khỏi từ điển
	public void deleteDictionary(){
		String s;
		Scanner input=new Scanner(System.in);
		System.out.println("Bạn muốn xóa từ nào: ");
		s=input.nextLine();
		FileText file=new FileText();
		file.deleteFile(s);
	}
	//Xuật dữ liệu từ điển ra file
	public void dictionaryExportToFile(){
		try{
			FileWriter writer=new FileWriter("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\CopyDictionary.txt");
			File file=new File("C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\dictionaries.txt");
			Scanner sc=new Scanner(file);
			String line=null;
			while(sc.hasNextLine()){
				line=sc.nextLine();
				writer.write(line+"\n");
			}
			writer.close();
			sc.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public String search(String s){
		FileText file=new FileText();
		ArrayList<String> temp=new ArrayList<String>();
		file.TextFile(temp,"C:\\Users\\Administrator\\IdeaProjects\\Dictionary\\src\\main\\resources\\English.txt");
		int j;
		String p=new String("");
		for(j=0;j<temp.size();j=j+1){
			String k=temp.get(j);
			if(k.startsWith(s))  p+="+"+temp.get(j)+"\n";
		}
		return p;
	}
}
