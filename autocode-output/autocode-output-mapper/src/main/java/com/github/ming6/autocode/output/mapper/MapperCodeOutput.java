package com.github.ming6.autocode.output.mapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.github.ming6.autocode.core.CodeOutput;
import com.github.ming6.autocode.utils.TemplateUtil;

public class MapperCodeOutput implements CodeOutput<Mapper> {
	
	private String dirPath;
	
	@Override
	public void write(Mapper mapper) {
		TemplateUtil.render(dirPath, mapper.getSimpleModelName() + ".xml", "mapper.vm", "mapper", mapper);
	}

	public String getDirPath() {
		return dirPath;
	}
	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}
}