package commonFunction;

import java.io.File;
import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;

//该类提供DataProvider
public class DataProvide {
public Document doc;

public void init(String filename) throws Exception
{
	File inputXml = new File(new File(filename).getAbsolutePath());
	//documentBuider为抽象不能直接实例化（将XML转换为DOM文件）
	DocumentBuilderFactory dbf = null;
	DocumentBuilder db = null;
	try{
		dbf = DocumentBuilderFactory.newInstance();
		db=dbf.newDocumentBuilder();
		doc = (Document)db.parse(inputXml);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}

  @DataProvider(name = "Test_xml_dataprovider")
  public Object[][] providerMethod(Method method) {
    return new Object[][] { new Object[]{doc}};
  }
}
