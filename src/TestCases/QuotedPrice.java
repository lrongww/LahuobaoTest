package TestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import commonFunction.CommonFunctions;
import commonFunction.DataProvide;
import commonFunction.DataReader;

public class QuotedPrice extends DataProvide {
	 public CommonFunctions comfun;
	 public DataReader dr;
	 @BeforeTest
	 public void Setup()throws Exception
	 {
		 
		 dr = new DataReader();
		  //ÉèÖÃÊý¾ÝÔ´
		  init("src/TestData/LoginTest.xml"); 
	 }
	 @Test(dataProvider="Test_xml_dataprovider")
	  public void testLogin(Document params)throws Exception
	  {
		 comfun = new CommonFunctions();
		 String url="http://v2.lahuobao.net";
		 comfun.getUrl(url); 
		//µÇÂ¼
		  comfun.login(dr.readNodeValue(params, "login", "usename"), dr.readNodeValue(params, "login", "password"));
		  String test = comfun.getText("id", "nowrap");
		  System.out.println(test);
		//¼ì²âµÇÂ¼
		  comfun.ckeckequal(comfun.getText("id", "nowrap"), dr.readNodeValue(params, "login", "value1"));

		 // comfun.ckeckequal(comfun.getText("id", dr.readNodeValue(params, "login", "ckeckpoint1")), dr.readNodeValue(params, "login", "value1"));
	  }
	 //(dataProvider = "Test_xml_dataprovider")
	 @Test
	 public void testQuotedPrice()throws Exception
	 {
		 comfun.mouseHover();
		 comfun.clickItem("xpath", "//*[@id='toBeDriver']/dl/dd[8]/a");
		 Thread.sleep(3000);
		 comfun.clickItem("xpath", "/html/body/div[2]/div[2]/form[2]/div/input");
		 Thread.sleep(5000);
		 comfun.clickItem("xpath", "/html/body/div[2]/div[2]/table/tbody/tr[1]");
		 Thread.sleep(1000);
		 comfun.clickItem("xpath", "html/body/div[2]/div[1]/div[2]/div[4]/div/input");
		 Thread.sleep(1000);
		 comfun.clickItem("id", "lyBuyNowbtnok");
		 
	 }
}
