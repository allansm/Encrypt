package entity;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {
	private List<Character> keys;
	private List<Integer> values;
	public Alphabet(int key) {
		setKeys(key);
		setValues(key);
	}
	public Alphabet(String format) {
		custom(format);
	}
	public List<Character> getKeys() {
		return keys;
	}
	private void setKeys(int key) {
		this.keys = new ArrayList<>();
		char start = 'a';
		for(int i=1;i<=2;i++) {
			this.keys.add(start++);
		}
		for(int i=5;i<=10;i+=5) {
			this.keys.add(start++);
		}
		for(int i=20;i<=255;i+=key) {
			this.keys.add(start++);
		}
	}
	public List<Integer> getValues() {
		return values;
	}
	private void setValues(int key) {
		this.values = new ArrayList<>();
		for(int i=1;i<=2;i++) {
			this.values.add(i);
		}
		for(int i=5;i<=10;i+=5) {
			this.values.add(i);
		}
		for(int i=20;i<=255;i+=key) {
			this.values.add(i);
		}
	}
	//.a:1;.b:2;.c:4;.d:8;.e:16;.f:32;.g:64;.h:128;
	public void custom(String format) {
		List<String> list = TextFilter.findTxt(".", ";", format);
		List<Character> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		for(String s:list) {
			list2.add(TextFilter.findTxt(".",":", "."+s+";").get(0).charAt(0));
		}
		for(String s:list) {
			list3.add(Integer.parseInt(TextFilter.findTxt(":",";", "."+s+";").get(0)));
		}
		this.keys = list2;
		this.values = list3;
	}
}
