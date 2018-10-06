package dictionary2;

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
}
