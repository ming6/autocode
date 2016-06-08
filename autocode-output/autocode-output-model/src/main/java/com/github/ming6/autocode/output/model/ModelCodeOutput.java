package com.github.ming6.autocode.output.model;

import com.github.ming6.autocode.core.CodeOutput;
import com.github.ming6.autocode.utils.TemplateUtil;

public class ModelCodeOutput implements CodeOutput<Model> {

	private String dirPath;
	
	@Override
	public void write(Model model) {
		TemplateUtil.render(dirPath, model.getName() + ".java", "model.vm", "model", model);
	}

	public String getDirPath() {
		return dirPath;
	}
	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}
}