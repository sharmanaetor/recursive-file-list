package com.test.documentmanager;

import java.util.List;

public class Dir {
	
	private String entryName;
	private String entryPath;
	private List<Dir> dir;
	
	public Dir() {
		
	}
	
	public Dir(String entryName, String entryPath) {
		this.entryName = entryName;
		this.entryPath = entryPath;
	}
	
	public String getEntryName() {
		return entryName;
	}
	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}
	public String getEntryPath() {
		return entryPath;
	}
	public void setEntryPath(String entryPath) {
		this.entryPath = entryPath;
	}

	public List<Dir> getDir() {
		return dir;
	}

	public void setDir(List<Dir> dir) {
		this.dir = dir;
	}
	
}
