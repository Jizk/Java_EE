package pm.dom4j_read;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * 读取完整的xml文档的内容
 * @author JiZhongkai
 *
 */
public class Demo3 {
	@Test
	public void test() throws Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("./src/contact.xml"));
		//读取根标签
		Element element = document.getRootElement();
		StringBuffer sb = new StringBuffer();
		getChildNodes(element,sb);
		System.out.println(sb.toString());
	}
	/**
	 * 获取当前标签的子标签
	 */
	private void getChildNodes(Element elem,StringBuffer sb){
		//开始标签
		sb.append("<"+elem.getName());
		//得到标签的属性列表
		List<Attribute> list2 = elem.attributes();
		if(list2!=null){
			for (Attribute attribute : list2) {
				sb.append(" "+attribute.getName()+"=\""+attribute.getValue()+"\"");
			}
		}
		sb.append(">");
		//得到文本
		//sb.append(elem.getText());
		//得到所有的标签
		Iterator<Node> it = elem.nodeIterator();
		while(it.hasNext()){
			Node node = it.next();
			if(node instanceof Element){
				Element ele = (Element) node;
				getChildNodes(ele,sb);
			}
			if(node instanceof Text){
				Text text =  (Text) node;
				sb.append(text.getText());
			}
		}
		//结束标签
		sb.append("</"+elem.getName()+">");
	}
}
