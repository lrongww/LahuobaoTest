package TestCases;

import org.testng.annotations.Test;

import org.w3c.dom.Document;

import commonFunction.CommonFunctions;
import commonFunction.DataProvide;
import commonFunction.DataReader;



import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;

public class LoginTest extends DataProvide {
	 public CommonFunctions comfun = new CommonFunctions();
	 public DataReader dr;
	 
   
  @BeforeTest
  public void setup()throws Exception 
  {
	 String url="http://v2.lahuobao.net";
	 comfun.getUrl(url);
	 dr = new DataReader();
	  //设置数据源
	  init("src/TestData/LoginTest.xml");  
	
  }
  @Test(dataProvider="Test_xml_dataprovider")
  public void testLogin(Document params)throws Exception
  {
	
	//登录
	  comfun.login(dr.readNodeValue(params, "login", "usename"), dr.readNodeValue(params, "login", "password"));
	  String test = comfun.getText("id", "nowrap");
	  System.out.println(test);
	//检测登录
	  comfun.ckeckequal(comfun.getText("id", "nowrap"), dr.readNodeValue(params, "login", "value1"));
//	  Thread.sleep(3000);
//	  comfun.mouseHover();
//	  comfun.clickItem("xpath", ".//*[@id='toBeDriver']/dl/dd[8]/a ");  //我要当车主
	 // comfun.ckeckequal(comfun.getText("id", dr.readNodeValue(params, "login", "ckeckpoint1")), dr.readNodeValue(params, "login", "value1"));
  }
 @Test(dataProvider="Test_xml_dataprovider")
public void testReleaseSource(Document params)throws Exception
{     
	  comfun.clickItem("id", "navTagReleaseCargo");
	  Thread.sleep(3000);
	//判断页面元素“发布货源”是否存在
	  if(comfun.doesWebElementExist("id", "navTagReleaseCargo")==false)
	  {
		  System.out.println("切换");
		  comfun.mouseHover();
		  comfun.clickItem("xpath", ".//*[@id='toBeCarowner']/dl/dd[10]/a");  //我要当货主
	  }
	  System.out.println("不切换");
	  //填写发货地
	  comfun.clearvalue("id", "cargoFrom");
	  comfun.clickItem("id", "cargoFrom");
	  comfun.selectAdress("cargoFrom", "320000", "320100", "320102");
	  //填写收货地
	  comfun.selectAdress("cargoTo", "330000", "330100", "330102");
//	  comfun.clickItem("id", "cargoTo");
//	  comfun.clickItem("id", "440300");
//	  comfun.clickItem("id", "440305");
	  //填写品名
	  comfun.clearvalue("name", "cargoName");
	  comfun.inputValue("name", "cargoName", "白酒");
	  //重量
	  comfun.inputValue("id", "weight", dr.readNodeValue(params, "releasesource", "weight"));
	  //体积
	  comfun.inputValue("id", "volume", dr.readNodeValue(params, "releasesource", "volume"));
	  //选择付款类型
	  comfun.handlePullDown("id", "sl-payment-method", 4);
	  Thread.sleep(1000);
	  comfun.clickItem("id", "ckb_tran_management");
	  comfun.clickItem("id", "ckb_invoice");
	  Thread.sleep(2000);
	  //提交
	  comfun.clickItem("id", "submitCargoInfo");
	  Thread.sleep(5000);
}
 
 
//  @AfterTest
//  public void tearDown() 
//  {
//	  comfun.tearDown();
//  }

}
