package dictionary1;

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
	//Hàm trung gian
	public void show(){
		int i;
		System.out.println("No		|English	|Vietnamese");
		for(i=0;i<n;i++){
			System.out.println((i+1)+"		|"+a.word[i].word_target+"		|"+a.word[i].word_explain);
		}
	}
}
