package commonFunction;

import java.io.File;
import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;

//�����ṩDataProvider
public class DataProvide {
public Document doc;

public void init(String filename) throws Exception
{
	File inputXml = new File(new File(filename).getAbsolutePath());
	//documentBuiderΪ������ֱ��ʵ��������XMLת��ΪDOM�ļ���
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
