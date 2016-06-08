package com.github.ming6.autocode.output.model;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.github.ming6.autocode.utils.TemplateUtil;

public class ModelCodeOutputTest {
	
	private void renderTemplate(String tplName, Model model){
		StringWriter writer = new StringWriter();
		TemplateUtil.render(writer, tplName, "model", model);
		System.out.println(writer.toString());
	}
	
	@Test
	public void testTemplateFields(){
		Model model = new Model();
		List<Field> fields = new ArrayList<>();
		fields.add(new Field("a", "String", "a"));
		fields.add(new Field("b", "java.util.Date", "b"));
		model.setFields(fields);
		renderTemplate("fields.vm", model);
	}
	
	@Test
	public void testTemplateMethods(){
		Model model = new Model();
		List<Field> fields = new ArrayList<>();
		fields.add(new Field("a", "String", "a"));
		fields.add(new Field("b", "java.util.Date", "b"));
		model.setFields(fields);
		renderTemplate("methods.vm", model);
	}
	
	@Test
	public void testTemplateModel(){
		Model model = new Model();
		model.setName("A");
		model.setNote("A");
		model.setVersion("0.0.1-SNAPSHOT");
		model.setAuthor("<a href=\"jiamingliu@ebnew.com\">jiamingliu</a>");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.setDate(format.format(new Date()));
		model.setPackageName("cn.bidlink.nbl");
		List<Field> fields = new ArrayList<>();
		fields.add(new Field("a", "String", "a"));
		fields.add(new Field("b", "java.util.Date", "b"));
		model.setFields(fields);
		model.setDeclarations(new String[]{
				"Copyright (c) 2001-2016 Bidlink(Beijing) E-Biz Tech Co.,Ltd.",
				"All rights reserved.",
				"必联（北京）电子商务科技有限公司 版权所有"
			});
		renderTemplate("model.vm", model);
	}
}