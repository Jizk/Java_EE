package pm.dom4j_read;


import java.io.File;

import javax.management.RuntimeErrorException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Demo1 {
	public static void main(String[] args) {
		try {
			// 1.创建一个xml解析器对象
			SAXReader reader = new SAXReader();
			//2.读取xml文档，返回Document对象
			Document doc = reader.read(new File("./src/contact.xml"));
			System.out.println(doc);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
}
