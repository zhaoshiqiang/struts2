package com.shengsiyuan.struts2;

import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
private String username;
	
	private String password;
	
	private String repassword;
	
	private int age;
	
	private Date birthday;
	
	private Date graduation;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRepassword()
	{
		return repassword;
	}

	public void setRepassword(String repassword)
	{
		this.repassword = repassword;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	
	public Date getGraduation()
	{
		return graduation;
	}

	public void setGraduation(Date graduation)
	{
		this.graduation = graduation;
	}
	
	/*
	 *  ִ�����̣�
		1�� ���Ƚ�������ת��
		2�� Ȼ���������У�飨 ִ�� validate ������
		3�� ��������������г������κδ��󣬶�������ȥִ�� execute������
		��ת�� struts.xml �и� action ����Ϊ input �� result 
		����Ӧ��ҳ�档
	 * */
	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}
	/*
	 * ���� Action ��ָ�����Զ���� execute ����ʱ��
	 * ���Ȼ�ִ���Զ���� execute ��������Ӧ������У�鷽����
	 * Ȼ����ȥִ�� validate ������
	 * ִ����Ϻ�����������κδ��󶼲�����ȥִ���Զ����execute ������
	 * ����ת���� input �����������Ӧ��ҳ���ϡ�
	 * */
	public String myExecute() throws Exception
	{
		System.out.println("myExecute invoked");
		return SUCCESS;
	}
	
	public void validateMyExecute()
	{
		System.out.println("validateMyExecute invoked!");
	}
	
//	@Override
//	public void validate() {
//			// TODO Auto-generated method stub
//		System.out.println("validate invoked!");
//	}
	/*
	 * Struts2 ���У��ִ�е��Ⱥ�˳��
	 * 1)����ִ��У���ܣ� xml �ļ���
	 * 2)ִ���Զ��巽����У�鷽���� validateMyExecute��
	 * 3)ִ�� validate ���������������Ȼ��ִ�У�
	 * */
	@Override
		public void validate() {
			// TODO Auto-generated method stub
		if(null == username || username.length() < 4 || username.length() > 6)
		{
			this.addActionError("username invalid");
			
			this.addFieldError("username", "username invalid in field");
		}
		
		if(null == password || password.length() < 4 || password.length() > 6)
		{
			this.addActionError("password invalid");
		}
		else if(null == repassword || repassword.length() < 4 || repassword.length() > 6)
		{
			this.addActionError("repassword invalid");
		}
		else if(!password.equals(repassword))
		{
			this.addActionError("the passwords not the same");
		}
		
		if(age < 10 || age > 50)
		{
			this.addActionError("age invalid");
		}
		
		if(null == birthday)
		{
			this.addActionError("birthday invalid");
		}
		
		if(null == graduation)
		{
			this.addActionError("graduation invalid");
		}
		
		if(null != birthday && null != graduation)
		{
			Calendar c1 = Calendar.getInstance();
			c1.setTime(birthday);
			
			Calendar c2 = Calendar.getInstance();
			c2.setTime(graduation);
			//c1.before(c2)��ʾ���������ڱ�ҵ����֮ǰ
			if(!c1.before(c2))
			{
				this.addActionError("birthday should be before graduation");
			}
		}
		/*
		 * ActionSupport ��� addActionError()������ʵ�֣� ���ȴ���һ��
		 * ArrayList ����Ȼ�󽫴�����Ϣ��ӵ��� ArrayList �����С�������
		 *  getActionErrors()�������� Action ����Ĵ�����Ϣ�б�ʱ��
		 *  ���ص�ʵ�����Ǽ��ϵ�һ�����������Ǽ��ϱ���
		 *  ��˶Լ��ϸ������� clear()��������������Ǹ����е�Ԫ�ض���ԭ�����е�Ԫ�أ�
		 *  ��ʱԭ�����е�����û���յ��κε�Ӱ�졣 
		 *  ���仰˵�� Action����Ĵ�����Ϣ�б�Կ�������˵��ֻ���ġ�
		 * */
		
		/*
		 * Field Error ����Ĵ�����Ϣ�ײ����� LinkedHashMap ʵ�ֵģ�
		 * ��Map �� key �� String ���ͣ� value �� List<String>���ͣ�
		 * ��ͱ�ʾһ�� Field Name ���Զ�Ӧ����������Ϣ����Щ������Ϣ��������List<String>���ϵ���
		 * */
		//this.getFieldErrors().clear();
		//this.getActionErrors().clear();
		
		//���FieldError��ActionError������Ϣ
//		this.clearActionErrors();
//		this.clearFieldErrors();
		
		System.out.println("invoked!!!");
		}
}
