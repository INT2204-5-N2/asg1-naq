import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class Dictionary2{
	public static void main(String[] args){
		DictionaryCommandline b=new DictionaryCommandline();
		//b.dictionaryBasic();
		b.dictionaryAdvanced();
	}
}
class Word{
	String word_target;//Từ mới
	String word_explain;//Giải nghĩa
}
class Dictionary{
	Word[] word;
}
class DictionaryManagement{
	Dictionary a=new Dictionary();
	int n;
	//Hàm nhập liệu
	public void insertFromCommandline(){
		Scanner input=new Scanner(System.in);
		System.out.print("So luong tu vung: ");
		n=input.nextInt();
		String s=input.nextLine();
		a.word=new Word[n];
		int i;
		System.out.println("Nhap danh sach tu: ");
		for(i=0;i<n;i++){
			a.word[i]=new Word();
			System.out.print("Tu moi: ");
			a.word[i].word_target=input.nextLine();
			System.out.print("Nghia: ");
			a.word[i].word_explain=input.nextLine();
		}
	}
	//Hàm nhập dữ liệu từ tệp
	public void insertFromFile(){
		FileText file=new FileText();
		file.WriteAFile();
		file.ReadAndWrite();
		ArrayList<String> list=new ArrayList<String>();
		file.TextFile(list);
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
		System.out.print("Tu ban muon tra la: ");
		Scanner input=new Scanner(System.in);
		String s=input.nextLine();
		int t=0;
		int i;
		for(i=0;i<n;i++){
			if(a.word[i].word_target.equals(s)){
				System.out.println("Nghia cua tu nay la: "+a.word[i].word_explain);
				break;
			}
			else t++;
		}
		if(t==n) System.out.println("Xin Loi!!! Tu nay khong co trong tu dien");
		System.out.print("Ban co muon tiep tuc khong? [Y/N]: ");
		String k=input.nextLine();
		while(k.equals("Y")){
			System.out.print("Tu ban muon tra la: ");
			s=input.nextLine();
			t=0;
			for(i=0;i<n;i++){
				if(a.word[i].word_target.equals(s)) System.out.println("Nghia cua tu nay la: "+a.word[i].word_explain);
				else t++;
			}
			if(t==n) System.out.println("Xin Loi!!! Tu nay khong co trong tu dien");
			System.out.print("Ban co muon tiep tuc khong? [Y/N]: ");
			k=input.nextLine();
		}
		if(k.equals("N")) System.out.println("BYE!!!");
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
class DictionaryCommandline{
	DictionaryManagement b=new DictionaryManagement();
	//Hiển thị danh sách từ
	public void showAllWords(){
		b.show();
	}
	public void dictionaryBasic(){
		b.insertFromCommandline();
		showAllWords();
	}
	public void dictionaryAdvanced(){
		b.insertFromFile();
		showAllWords();
		b.dictionaryLookup();
	}
}
class FileText{
	//Tao file dictionaries
	void WriteAFile(){
		try{
			FileWriter writer=new FileWriter("dictionaries.txt");
			writer.write("Dog	Cho\nCat	Meo\nFish	Ca\nBird	Chim\n");
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	//Doc tu file nay roi ghi vao file khac
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
	//Ghi file vao danh sach mang
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
