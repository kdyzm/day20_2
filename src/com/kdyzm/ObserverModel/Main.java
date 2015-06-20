package com.kdyzm.ObserverModel;
//测试观察者模式
public class Main {
	public static void main(String args[])
	{
		Person p=new Person();
		p.addPersonListener(new PersonListener(){
			@Override
			public void doListen(PersonEvent e) {
				System.out.println("被监听到正在跑步！");
				throw new RuntimeException("他正在跑步！！！");
			}
		});
		p.run();
	}
}
interface PersonListener
{
	void doListen(PersonEvent e);
}
class PersonEvent
{
	Person p=null;
	public PersonEvent(Person p)
	{
		this.p=p;
	}
	public Person getSource()
	{
		return p;
	}
}

class Person
{
	PersonListener listener=null;
	public void addPersonListener(PersonListener listener)
	{
		//完成传递监听器的过程。
		this.listener=listener;
	}
	public void run()
	{
		//被监听者只要有动作，监听器也跟着一起动
		if(listener!=null)//如果不加监听器的话也要能够正常“跑步”
		{
			listener.doListen(new PersonEvent(this));
		}
		System.out.println("我正在跑步！");
	}
}