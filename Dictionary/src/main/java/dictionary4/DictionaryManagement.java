package dictionary4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
	Dictionary a=new Dictionary();
	int n;
	//Hàm nhập liệu
	public void insertFromCommandline(){
		Scanner input=new Scanner(System.in);
		System.out.print("Số lượng từ vựng: ");
		n=input.nextInt();
		String s=input.nextLine();
		a.word=new Word[n];
		int i;
		System.out.println("Nhập danh sách từ: ");
		for(i=0;i<n;i++){
			a.word[i]=new Word();
			System.out.print("Từ mới: ");
			a.word[i].word_target=input.nextLine();
			System.out.print("Nghĩa: ");
			a.word[i].word_explain=input.nextLine();
		}
	}
	//Hàm nhập dữ liệu từ tệp
	public void insertFromFile(){
		FileText file=new FileText();
		//file.WriteAFile("dictionaries.txt","activity	hoạt động\nactor	diễn viên\nagree	đồng ý\n" +
		//		"air	không khí\nbaby	em bé\nbicycle	xe đạp\nbay	vịnh\nbig	to, lớn\ncave	hang động\ncoffee	cà phê");
		//file.sortFile("dictionaries");
		file.ReadAndWrite();
		ArrayList<String> list=new ArrayList<String>();
		file.TextFile(list,"Dictionary.txt");
		int m=list.size();
		n=m/2;
		a.word=new Word[n];
		int i,j;
		i=0;
		for(j=0;j<=m-2;j=j+2){
			a.word[i]=new Word();
			a.word[i].word_target=list.get(j);
			a.word[i].word_explain=list.get(j+1);
			i++;
		}
	}
	//Tra cứu từ điển
	public void dictionaryLookup(){
		System.out.print("Từ bạn muốn tra: ");
		Scanner input=new Scanner(System.in);
		String s=input.nextLine();
		int t=0;
		int i;
		for(i=0;i<n;i++){
			if(a.word[i].word_target.equals(s)){
				System.out.println("Nghĩa của từ: "+a.word[i].word_explain);
				break;
			}
			else t++;
		}
		if(t==n) System.out.println("Xin lỗi!!! Từ này không có trong từ điển");
		System.out.print("Bạn có muốn tiếp tục không? [Y/N]: ");
		String k=input.nextLine();
		while(k.equals("Y")){
			System.out.print("Từ bạn muốn tra: ");
			s=input.nextLine();
			t=0;
			for(i=0;i<n;i++){
				if(a.word[i].word_target.equals(s)) System.out.println("Nghĩa của từ: "+a.word[i].word_explain);
				else t++;
			}
			if(t==n) System.out.println("Xin lỗi!!! Từ này không có trong từ điển");
			System.out.print("Bạn có muốn tiếp tục không? [Y/N]: ");
			k=input.nextLine();
		}
		if(k.equals("N")) System.out.println("BYE!!!");
	}
	//
	public String dictionaryLookup(String s){
		FileText file=new FileText();
		ArrayList<String> temp=new ArrayList<String>();
		file.TextFile(temp,"Dictionary.txt");
		int i;
		int t=0;
		for(i=0;i<temp.size();i+=2){
			if(temp.get(i).equals(s)){
				return temp.get(i+1);
			}
			else t++;
		}
		if(t==temp.size()/2) return "Từ này không có trong từ điển";
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
			FileWriter writer=new FileWriter("CopyDictionary.txt");
			File file=new File("dictionaries.txt");
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
	//Hàm tìm kiếm
	public void Search(String s){
		FileText file=new FileText();
		ArrayList<String> temp=new ArrayList<String>();
		file.TextFile(temp,"Dictionary.txt");
		int j;
		int t=0;
		for(j=0;j<temp.size();j=j+2){
			String k=temp.get(j);
			if(k.startsWith(s))  System.out.println(temp.get(j));
			else{
				t++;
			}
		}
		if(t==temp.size()/2) System.out.println("Không tìm thấy.");
	}
	//
	public String search(String s){
		FileText file=new FileText();
		ArrayList<String> temp=new ArrayList<String>();
		file.TextFile(temp,"Dictionary.txt");
		int j;
		String p=new String("");
		for(j=0;j<temp.size();j=j+2){
			String k=temp.get(j);
			if(k.startsWith(s))  p+="+"+temp.get(j)+"\n";
		}
		return p;
	}
	//Hàm trung gian
	public void show(){
		int i;
		System.out.println("No		|English	|Vietnamese");
		for(i=0;i<n;i++){
			System.out.println((i+1)+"		|"+a.word[i].word_target+"		|"+a.word[i].word_explain);
		}
	}
}