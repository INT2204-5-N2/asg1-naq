package dictionary4;

import java.util.Scanner;

public class DictionaryCommandline {
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
