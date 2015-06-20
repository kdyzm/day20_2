package com.kdyzm.ObserverModel;
//老师的程序
public class TestObersver {
	public static void main(String[] args) {
		Person1 person = new Person1();//声明被观察者
		System.err.println("pp:"+person);
		person.addPersonListener(new PersonListenerx() {
			public void running(PersonEvsdfent pe) {
				System.err.println("你正在跑....."+pe.getSource());
				throw new RuntimeException("他跑了。。。");
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
		System.err.println("我正在跑步......");
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
