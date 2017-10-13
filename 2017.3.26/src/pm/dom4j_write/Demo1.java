package pm.dom4j_write;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 写出内容到xml文档
 * @author JiZhongkai
 *
 */
public class Demo1 {
	public static void main(String[] args) throws Exception{
		Document doc =  new SAXReader().read(new File("./src/contact.xml"));
		
		
		
		//指定文件的输出位置
		FileOutputStream fileOutputStream = new FileOutputStream("E:/contact.xml");
		
		//1.创建一个写出对象
		XMLWriter writer = new XMLWriter(fileOutputStream);
		
		//2.写出对象
		writer.write(doc);
		
		//3.关闭
		writer.close();
	}
}
