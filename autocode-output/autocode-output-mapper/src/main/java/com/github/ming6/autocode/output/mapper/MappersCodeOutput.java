package com.github.ming6.autocode.output.mapper;

import java.util.List;

import com.github.ming6.autocode.core.CodeOutput;

public class MappersCodeOutput implements CodeOutput<List<Mapper>> {

	private String dirPath;
	
	@Override
	public void write(List<Mapper> mappers) {
		MapperCodeOutput output = new MapperCodeOutput();
		output.setDirPath(dirPath);
		for(Mapper mapper : mappers){
			output.write(mapper);
		}
	}

	public String getDirPath() {
		return dirPath;
	}
	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}
}