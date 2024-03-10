package com.multiMedia.payload;

public class FileResponce {
	String fileName;
	String message;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public FileResponce(String fileName, String message) {
		super();
		this.fileName = fileName;
		this.message = message;
	}
	
}
