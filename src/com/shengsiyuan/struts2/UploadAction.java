package com.shengsiyuan.struts2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

	private String username;
	//file代表临时文件，就是文件缓存
	private File file;

	private String fileFileName;

	private String fileContentType;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("path: " + file.getAbsolutePath());
		
		System.out.println("file: " + file.getName());
		
		System.out.println("fileFileName: " + fileFileName);
		
		String path=ServletActionContext.getRequest().
			getSession().getServletContext().getRealPath("/upload");
		
		InputStream is=new FileInputStream(file);
		OutputStream os=new FileOutputStream(new File(path,fileFileName));
		
		byte[] buffer=new byte[400];
		int length=0;
		
		while(-1 != (length=is.read(buffer)))
		{
			os.write(buffer, 0, length);
		}
		is.close();
		os.close();
		
		return SUCCESS;
	}
}
