package com.kdyzm.ObserverModel;
//��ʦ�ĳ���
public class TestObersver {
	public static void main(String[] args) {
		Person1 person = new Person1();//�������۲���
		System.err.println("pp:"+person);
		person.addPersonListener(new PersonListenerx() {
			public void running(PersonEvsdfent pe) {
				System.err.println("��������....."+pe.getSource());
				throw new RuntimeException("�����ˡ�����");
			}
		});
		person.run();
	}
}
class Person1{
	private PersonListenerx pl;
	public void addPersonListener(PersonListenerx pl){
		this.pl = pl;
	}
	public void run(){
		if(pl!=null){
			pl.running(new PersonEvsdfent(this));
		}
		System.err.println("�������ܲ�......");
	}
}
interface PersonListenerx{
	void running(PersonEvsdfent pe);
}
class PersonEvsdfent{
	private Object src;
	public PersonEvsdfent(Object obj) {
		this.src=obj;
	}
	public Object getSource(){
		return src;
	}
}
