package com.kdyzm.ObserverModel;
//���Թ۲���ģʽ
public class Main {
	public static void main(String args[])
	{
		Person p=new Person();
		p.addPersonListener(new PersonListener(){
			@Override
			public void doListen(PersonEvent e) {
				System.out.println("�������������ܲ���");
				throw new RuntimeException("�������ܲ�������");
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
		//��ɴ��ݼ������Ĺ��̡�
		this.listener=listener;
	}
	public void run()
	{
		//��������ֻҪ�ж�����������Ҳ����һ��
		if(listener!=null)//������Ӽ������Ļ�ҲҪ�ܹ��������ܲ���
		{
			listener.doListen(new PersonEvent(this));
		}
		System.out.println("�������ܲ���");
	}
}