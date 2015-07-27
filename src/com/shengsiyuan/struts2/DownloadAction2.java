package com.shengsiyuan.struts2;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction2 extends ActionSupport {
	
	private int number;
	
	private String filename;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public InputStream getDownloadFile()
	{
		try {
		if(1 == number)
		{
			this.filename="毕业论文-赵世强改一.pdf";
			//先用gbk编码字符串得到字节数组，然后再用iso8859_1解码字节数组得到一个新的字符串
			this.filename=new String(this.filename.getBytes("gbk"),"iso8859_1");
			
			return ServletActionContext.getServletContext().getResourceAsStream("/upload/毕业论文-赵世强改一.pdf");
		}else{
			this.filename="毕业设计撰写提纲（硬件类）.pdf";
			this.filename=new String(this.filename.getBytes("gbk"),"iso8859_1");
			return ServletActionContext.getServletContext().getResourceAsStream("/upload/毕业设计撰写提纲（硬件类）.pdf");
		}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
	
	
	
}
