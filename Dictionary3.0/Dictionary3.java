import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class Dictionary3{
	public static void main(String[] args){
		DictionaryCommandline b=new DictionaryCommandline();
		DictionaryManagement c=new DictionaryManagement();
		Scanner input=new Scanner(System.in);
		String userName=new String("nguyenanhquan");
		String pass=new String("21111999");
		//b.dictionaryBasic();
		b.dictionaryAdvanced();
		System.out.print("Ban co muon chinh sua tu dien khong? [Y/N]: ");
		String s=input.nextLine();
		if(s.equals("Y")){
			System.out.print("USER NAME: ");
			String k=input.nextLine();
			System.out.print("PASSWORD: ");
			String l=input.nextLine();
			if(k.equals(userName)&&l.equals(pass)){
				System.out.println("Ban muon: ");
				System.out.println("1. Them du lieu.");
				System.out.println("2. Xoa du lieu.");
				System.out.println("3. Ghi tu dien ra file");
				System.out.print("Lua chon cua ban: ");
				int n=input.nextInt();
				String d=input.nextLine();
				switch(n){
					case 1:{
						c.addDictionary();
						break;
					}
					case 2:{
						c.deleteDictionary();
						break;
					}
					case 3:{
						c.dictionaryExportToFile();
						break;
					}
					default:{
						System.out.println("Khong co lua chon do.");
						break;
					}
				}
			}
			else{
				System.out.println("Ban nhap sai tai khoan");
			}
			System.out.print("Ban co muon tiep tuc chinh sua tu dien? [Y/N]: ");
			String h=input.nextLine();
			while(h.equals("Y")){
				System.out.print("USER NAME: ");
				k=input.nextLine();
				System.out.print("PASSWORD: ");
				l=input.nextLine();
				if(k.equals(userName)&&l.equals(pass)){
					System.out.println("Ban muon: ");
					System.out.println("1. Them du lieu.");
					System.out.println("2. Xoa du lieu.");
					System.out.println("3. Ghi tu dien ra file");
					System.out.print("Lua chon cua ban: ");
					int n=input.nextInt();
					String e=input.nextLine();
					switch(n){
						case 1:{
							c.addDictionary();
							break;
						}
						case 2:{
							c.deleteDictionary();
							break;
						}
						case 3:{
							c.dictionaryExportToFile();
							break;
						}
						default:{
							System.out.println("Khong co lua chon do.");
							break;
						}
					}
				}
				else{
					System.out.println("Ban nhap sai tai khoan");
				}
				System.out.print("Ban co muon tiep tuc chinh sua tu dien? [Y/N]: ");
				h=input.nextLine();
			}
		}
		else System.out.println("Ket Thuc!!!");
		b.dictionarySearcher();
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
		//file.WriteAFile();
		file.ReadAndWrite();//update file Dictionary.txt
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
	//Thêm dữ liệu vào từ điển
	public void addDictionary(){
		FileText file=new FileText();
		System.out.println("Ban muon them du lieu: ");
		file.addFile();
	}
	//Xoa du lieu ra khoi tu dien
	public void deleteDictionary(){
		String s;
		Scanner input=new Scanner(System.in);
		System.out.println("Ban muon xoa tu nao: ");
		s=input.nextLine();
		FileText file=new FileText();
		file.deleteFile(s);
	}
	//Xuat du lieu tu dien hien tai ra file
	public void dictionaryExportToFile(){
		try{
			FileWriter writer=new FileWriter("CopyDictionary.txt");
			File file=new File("dictionaries.txt");
			Scanner sc=new Scanner(file);
			String line=null;
			while(sc.hasNextLine()){
				line=sc.nextLine();
				writer.write(line);
			}
			writer.close();
			sc.close();
		}catch(IOException e){
			e.printStackTrace();
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
	//Hàm tìm kiếm 
	public void Search(String s){
		int j;
		int t=0;
		for(j=0;j<n;j++){
			if(a.word[j].word_target.startsWith(s))  System.out.println(a.word[j].word_target+"	"+a.word[j].word_explain);
			else{
				t++;
			}
		}
		if(t==n) System.out.println("Khong tim thay.");
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
	public void dictionarySearcher(){
		Scanner input=new Scanner(System.in);
		System.out.println("Moi ban nhap tu can tim: ");
		String s=input.nextLine();
		b.Search(s);
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
	//Them du lieu vao file
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
	//Xoa du lieu trong file
	void deleteFile(String s){
		ReadAndWrite();
		ArrayList<String> list=new ArrayList<String>();
		TextFile(list);
		int i;
		for(i=0;i<list.size();i++){
			if(list.get(i).equals(s)){
				list.remove(i);//Sau khi xoa phan tu i ra khoi danh sach thi phan tu i+1 tro thanh phan tu i
				list.remove(i);
				break;
			}
		}
		//Sau khi xoa xong trong ArrayList thi ghi lai vao file dictionaries.txt
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
		//Ghi lai vao file Dictionary.txt
		ReadAndWrite();
	}
}
