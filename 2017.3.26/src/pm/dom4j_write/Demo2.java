package pm.dom4j_write;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/**
 * 修改xml内容
 * 增加：文档，标签，属性
 * 修改：属性值，文本
 * 删除：标签，属性
 * @author JiZhongkai
 *
 */
public class Demo2 {
	
	@Test
	public void test1()throws Exception{
		/**
		 * 1.创建文档
		 */
		Document doc = DocumentHelper.createDocument();
		/**
		 * 2.增加标签
		 */
		Element rootElement = doc.addElement("contactList");
		Element contactElement = rootElement.addElement("contact");
		contactElement.addElement("name");
		/**
		 * 3.增加属性
		 */
		contactElement.addAttribute("id", "001");

		FileOutputStream fileOutputStream = new FileOutputStream("E:/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(fileOutputStream,format);
		writer.write(doc);
		writer.close();
	}
	
	
	/**
	 * 修改属性值，文本
	 */
	@Test
	public void test2()throws Exception{
		Document doc =  new SAXReader().read(new File("./src/contact.xml"));
		/**
		 * 属性值 1、得到标签对象 2、得到属性对象 3、修改属性值
		 */
		/*Element contactElem = doc.getRootElement().element("contact");
		Attribute attribute = contactElem.attribute("id");
		attribute.setValue("003");*/
		/**
		 * 属性值 通过增加同名属性的方法，修改属性值
		 */
		Element contactElem = doc.getRootElement().element("contact");
		contactElem.addAttribute("id", "004");
		
		/**
		 * 文本 1.1、得到标签对象 2、修改文本
		 */
		Element nameElem = doc.getRootElement().element("contact").element("name");
		nameElem.setText("李四");
		
		
		FileOutputStream fileOutputStream = new FileOutputStream("E:/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(fileOutputStream,format);
		writer.write(doc);
		writer.close();
	}
	
	
	/**
	 * 删除标签，属性
	 * @throws Exception
	 */
	@Test
	public void test3()throws Exception{
		Document doc =  new SAXReader().read(new File("./src/contact.xml"));
		
		/**
		 * 删除 标签，1、得到标签对象 2、删除标签
		 */
		Element ageElement = doc.getRootElement().element("contact").element("age");
		ageElement.detach();
		
		
		/**
		 * 删除属性 1.得到属性对象 2.删除属性
		 */
		Element element  = (Element)doc.getRootElement().elements().get(1);
		Attribute attribute  = element.attribute("id");
		attribute.detach();
		
		FileOutputStream fileOutputStream = new FileOutputStream("E:/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(fileOutputStream,format);
		writer.write(doc);
		writer.close();
	}
	
}
