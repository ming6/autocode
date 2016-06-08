package com.github.ming6.autocode.output.model;

import java.util.List;

import com.github.ming6.autocode.core.CodeOutput;

public class ModelsCodeOutput implements CodeOutput<List<Model>> {

	private String dirPath;
	
	@Override
	public void write(List<Model> models) {
		ModelCodeOutput output = new ModelCodeOutput();
		output.setDirPath(dirPath);
		for(Model model : models){
			output.write(model);
		}
	}

	public String getDirPath() {
		return dirPath;
	}
	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}
}