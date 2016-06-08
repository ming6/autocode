package com.github.ming6.autocode.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class TemplateUtil {
	
	public static final void render(Writer writer, String tplName, String name, Object value){
		VelocityEngine engine = new VelocityEngine();
		engine.setProperty("resource.loader", "class");
		engine.setProperty("class.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		engine.init();
		Template template = engine.getTemplate(tplName, "UTF-8");
		VelocityContext context = new VelocityContext();
		context.put(name, value);
		template.merge(context, writer);
	}
	
	public static final void render(File file, String tplName, String name, Object value){
		FileWriter writer = null;
		try {
			if(!file.exists()){
				file.createNewFile();
			}
			writer = new FileWriter(file);
			render(writer, tplName, name, value);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static final void render(String filePath, String tplName, String name, Object value){
		render(new File(filePath), tplName, name, value);
	}
	
	public static final void render(String dirPath, String fileName, String tplName, String name, Object value){
		File dir = new File(dirPath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		render(dirPath + "/" + fileName, tplName, name, value);
	}
}