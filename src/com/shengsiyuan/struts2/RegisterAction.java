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
	 *  执行流程：
		1） 首先进行类型转换
		2） 然后进行输入校验（ 执行 validate 方法）
		3） 如果在上述过程中出现了任何错误，都不会再去执行 execute方法，
		会转向 struts.xml 中该 action 的名为 input 的 result 
		所对应的页面。
	 * */
	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}
	/*
	 * 当在 Action 中指定了自定义的 execute 方法时，
	 * 首先会执行自定义的 execute 方法所对应的输入校验方法，
	 * 然后再去执行 validate 方法，
	 * 执行完毕后如果出现了任何错误都不会再去执行自定义的execute 方法，
	 * 流程转向了 input 这个名字所对应的页面上。
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
	 * Struts2 框架校验执行的先后顺序：
	 * 1)首先执行校验框架（ xml 文件）
	 * 2)执行自定义方法的校验方法（ validateMyExecute）
	 * 3)执行 validate 方法（这个方法必然会执行）
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
			//c1.before(c2)表示出生日期在毕业日期之前
			if(!c1.before(c2))
			{
				this.addActionError("birthday should be before graduation");
			}
		}
		/*
		 * ActionSupport 类的 addActionError()方法的实现： 首先创建一个
		 * ArrayList 对象，然后将错误消息添加到该 ArrayList 对象中。当调用
		 *  getActionErrors()方法返回 Action 级别的错误信息列表时，
		 *  返回的实际上是集合的一个副本而不是集合本身，
		 *  因此对集合副本调用 clear()方法清除的依旧是副本中的元素而非原集合中的元素，
		 *  此时原集合中的内容没有收到任何的影响。 
		 *  换句话说， Action级别的错误信息列表对开发者来说是只读的。
		 * */
		
		/*
		 * Field Error 级别的错误信息底层是用 LinkedHashMap 实现的，
		 * 该Map 的 key 是 String 类型， value 是 List<String>类型，
		 * 这就表示一个 Field Name 可以对应多条错误信息，这些错误信息都放置在List<String>集合当中
		 * */
		//this.getFieldErrors().clear();
		//this.getActionErrors().clear();
		
		//清楚FieldError和ActionError错误信息
//		this.clearActionErrors();
//		this.clearFieldErrors();
		
		System.out.println("invoked!!!");
		}
}
