package pm.dom4j_read;
import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 读取xml文件内容
 节点
 标签
 属性
 文本
 */
public class Demo2 {
	/**
	 * 遍历节点
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception{
		//1.读取xml文档，返回Document对象
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/contact.xml"));
		
		//2.nodeIterator() 获取当前节点下的所以子节点对象
		Iterator<Node> it = doc.nodeIterator();
		while(it.hasNext()){//判断是否有下一个元素
			Node node = it.next();//取出元素
			String name = node.getName();//得到节点的名称
			System.out.println(name);
			//继续获取其下面的子节点
			//只有标签节点才有子节点
			//判断当前节点是否是标签节点
			if(node instanceof Element){
				Element element = (Element) node;
				Iterator<Node> it2 = element.nodeIterator();
				while(it2.hasNext()){
					Node node2 = it2.next();
					String name2 = node2.getName();
					System.out.println(name2);
				}
			}
		}
	}
		
	/**
	 * 
	 * 遍历文档中的所有节点
	 */
	@Test
	public void test2() throws Exception{
		//1.读取xml文档，返回Document对象
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/contact.xml"));
		
		//2.得到跟标签
		Element rootElement = doc.getRootElement();
		getChildNodes(rootElement);
	}
	
	private void getChildNodes(Element elem){
		System.out.println(elem.getName());
		//得到子节点
		Iterator<Node> it = elem.nodeIterator();
		while(it.hasNext()){
			Node node = it.next();
			if(node instanceof Element){
				Element element = (Element)node;
				//递归
				getChildNodes(element);
			}
		}
	}
	
	/**
	 * 获取标签节点
	 */
	@Test
	public void test3()throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("./src/contact.xml"));
		
		//2.得到根标签
		Element rootElement = document.getRootElement();
		System.out.println(rootElement.getName());
		
		//3.得到当前标签下指定名称的第一个子标签
		Element contactElement = rootElement.element("contact");
		System.out.println(contactElement.getName());
		
		//4.得到当前标签下指定名称的所有子标签
		Iterator<Element> it = rootElement.elementIterator("contact");
		while(it.hasNext()){
			Element element = it.next();
			System.out.println(element.getName());
		}
		
		//5.得到当前标签下的所有子标签
		List<Element> list = rootElement.elements();
		//遍历List的方法
		//传统for循环，增强for循环，迭代器
		/*for(int i= 0;i<list.size();i++){
			Element elm = list.get(i);
			System.out.println(elm.getName());
		}*/
		/*for(Element elm : list){
			System.out.println(elm.getName());
		}*/
		Iterator<Element> iterator = list.iterator();   //ctrl+2 松开+L
		while(iterator.hasNext()){
			Element element =  iterator.next();
			System.out.println(element.getName());
		}
	}
		
	/**
	 * 获取属性
	 */
	@Test
	public void test4()throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("./src/contact.xml"));
		
		//获取属性所在的标签对象，然后才能获得属性
		//1.得到标签对象
		Element element = document.getRootElement().element("contact");
		
		//2.得到属性
		//得到指定名称的属性值
		String idValue = element.attributeValue("id");
		System.out.println(idValue);
		
		//得到属性对象
		Attribute attribute = element.attribute("id");
		System.out.println("属性名；"+attribute.getName()+";"+"属性值；"+attribute.getValue());
		
		//得到所有的属性对象
		List<Attribute> list = element.attributes();
		for (Attribute attribute2 : list) {
			System.out.println("属性名；"+attribute2.getName()+";"+"属性值；"+attribute2.getValue());
		}
		
	}
	
	/**
	 *获取文本
	 */
	@Test
	public void test5()throws Exception{

		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("./src/contact.xml"));
		
		//1.获取文本，先获得标签，再获得标签上的文本
		Element element = document.getRootElement().element("contact").element("name");
		//得到文本
		System.out.println(element.getText());
		
		//2.得到指定子标签的文本内容
		System.out.println(document.getRootElement().element("contact").elementText("name"));
	}
		
}
