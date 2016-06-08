package com.github.ming6.autocode.output.mapper;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.ming6.autocode.utils.TemplateUtil;

public class MapperCodeOutputTest {
	
	private void renderTemplate(String tplName, Mapper mapper){
		StringWriter writer = new StringWriter();
		TemplateUtil.render(writer, tplName, "mapper", mapper);
		System.out.println(writer);
	}
	
	@Test
	public void testTemplateResultMap(){
		Mapper mapper = new Mapper();
		mapper.setTableName("`A");
		mapper.setModelName("cn.bidlink.nbl.A");
		mapper.setSimpleModelName("A");
		List<Mapping> mappings = new ArrayList<>();
		mappings.add(new Mapping("a", "A", "date"));
		mappings.add(new Mapping("b", "B"));
		mapper.setMappings(mappings);
		renderTemplate("mapper-update.vm", mapper);
	}
	
	@Test
	public void testTemplateInsert(){
		Mapper mapper = new Mapper();
		List<Mapping> mappings = new ArrayList<>();
		mappings.add(new Mapping("a", "A", "date"));
		mappings.add(new Mapping("b", "B"));
		mapper.setMappings(mappings);
		renderTemplate("mapper-insert.vm", mapper);
	}
	
	@Test
	public void testTemplateSqlUpdate(){
		Mapper mapper = new Mapper();
		List<Mapping> mappings = new ArrayList<>();
		mappings.add(new Mapping("a", "A", "date"));
		mappings.add(new Mapping("b", "B"));
		mapper.setMappings(mappings);
		renderTemplate("mapper-sql-update.vm", mapper);
	}
	
	@Test
	public void testTemplateUpdate(){
		Mapper mapper = new Mapper();
		mapper.setTableName("`A");
		List<Mapping> mappings = new ArrayList<>();
		mappings.add(new Mapping("a", "A", "date"));
		mappings.add(new Mapping("b", "B"));
		mapper.setMappings(mappings);
		renderTemplate("mapper-update.vm", mapper);
	}
	
	@Test
	public void testTemplateDelete(){
		Mapper mapper = new Mapper();
		mapper.setTableName("`A");
		List<Mapping> mappings = new ArrayList<>();
		mappings.add(new Mapping("a", "A", "date"));
		mappings.add(new Mapping("b", "B"));
		mapper.setMappings(mappings);
		renderTemplate("mapper-delete.vm", mapper);
	}
	
	@Test
	public void testTemplateDeleteBatch(){
		Mapper mapper = new Mapper();
		mapper.setTableName("`A");
		List<Mapping> mappings = new ArrayList<>();
		mappings.add(new Mapping("a", "A", "date"));
		mappings.add(new Mapping("b", "B"));
		mapper.setMappings(mappings);
		renderTemplate("mapper-deleteBatch.vm", mapper);
	}
	
	@Test
	public void testTemplateSqlColumns(){
		Mapper mapper = new Mapper();
		List<Mapping> mappings = new ArrayList<>();
		mappings.add(new Mapping("a", "A", "date"));
		mappings.add(new Mapping("b", "B"));
		mapper.setMappings(mappings);
		renderTemplate("mapper-sql-columns.vm", mapper);
	}
	
	@Test
	public void testTemplateGetById(){
		Mapper mapper = new Mapper();
		mapper.setTableName("`A");
		mapper.setSimpleModelName("A");
		List<Mapping> mappings = new ArrayList<>();
		mappings.add(new Mapping("a", "A", "date"));
		mappings.add(new Mapping("b", "B"));
		mapper.setMappings(mappings);
		renderTemplate("mapper-getById.vm", mapper);
	}
	
	@Test
	public void testTemplateSqlFindPageWhere(){
		Mapper mapper = new Mapper();
		List<Mapping> mappings = new ArrayList<>();
		mappings.add(new Mapping("a", "A", "date"));
		mappings.add(new Mapping("b", "B"));
		mapper.setMappings(mappings);
		renderTemplate("mapper-sql-findPageWhere.vm", mapper);
	}
	
	@Test
	public void testTemplateFindPageCount(){
		Mapper mapper = new Mapper();
		mapper.setTableName("`A");
		List<Mapping> mappings = new ArrayList<>();
		mappings.add(new Mapping("a", "A", "date"));
		mappings.add(new Mapping("b", "B"));
		mapper.setMappings(mappings);
		renderTemplate("mapper-findPageCount.vm", mapper);
	}
	
	@Test
	public void testTemplateFindPage(){
		Mapper mapper = new Mapper();
		mapper.setTableName("`A");
		mapper.setSimpleModelName("A");
		List<Mapping> mappings = new ArrayList<>();
		mappings.add(new Mapping("a", "A", "date"));
		mappings.add(new Mapping("b", "B"));
		mapper.setMappings(mappings);
		renderTemplate("mapper-findPage.vm", mapper);
	}
	
	@Test
	public void testTemplateMapper(){
		Mapper mapper = new Mapper();
		mapper.setTableName("`A");
		mapper.setModelName("cn.bidlink.nbl.A");
		mapper.setSimpleModelName("A");
		List<Mapping> mappings = new ArrayList<>();
		mappings.add(new Mapping("a", "A", "date"));
		mappings.add(new Mapping("b", "B"));
		mapper.setMappings(mappings);
		renderTemplate("mapper.vm", mapper);
	}
}