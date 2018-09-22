import java.util.Scanner;
public class Dictionary1{
	public static void main(String[] args){
		DictionaryCommandline b=new DictionaryCommandline();
		b.dictionaryBasic();
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
	//Hàm trung gian
	public void show(){
		int i;
		System.out.println("No     |English        |Vietnamese");
		for(i=0;i<n;i++){
			System.out.println((i+1)+"      |"+a.word[i].word_target+"          |"+a.word[i].word_explain);
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
}