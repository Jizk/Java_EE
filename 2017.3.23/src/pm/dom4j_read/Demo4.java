package pm.dom4j_read;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 把xml的文件信息封装到对象中
 * @author JiZhongkai
 *
 */
public class Demo4 {
	public static void main(String[] args) throws Exception{
		List<Contact> list =  new ArrayList<Contact>();
		SAXReader reader =  new SAXReader();
		Document document = reader.read(new File("./src/contact.xml"));
		
		Iterator<Element> iterator = document.getRootElement().elementIterator("contact");
		while(iterator.hasNext()){
			Element element =  iterator.next();
			//创建Contact
			Contact contact =  new Contact();
			contact.setId(element.attributeValue("id"));
			contact.setName(element.elementText("name"));
			contact.setAge(element.elementText("age"));
			contact.setPhone(element.elementText("phone"));
			contact.setEmail(element.elementText("email"));
			contact.setQq(element.elementText("qq"));
			list.add(contact);
			
		}
		for (Contact contact : list) {
			System.out.println(contact);
		}
	}
}
