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
			this.filename="��ҵ����-����ǿ��һ.pdf";
			//����gbk�����ַ����õ��ֽ����飬Ȼ������iso8859_1�����ֽ�����õ�һ���µ��ַ���
			this.filename=new String(this.filename.getBytes("gbk"),"iso8859_1");
			
			return ServletActionContext.getServletContext().getResourceAsStream("/upload/��ҵ����-����ǿ��һ.pdf");
		}else{
			this.filename="��ҵ���׫д��٣�Ӳ���ࣩ.pdf";
			this.filename=new String(this.filename.getBytes("gbk"),"iso8859_1");
			return ServletActionContext.getServletContext().getResourceAsStream("/upload/��ҵ���׫д��٣�Ӳ���ࣩ.pdf");
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
