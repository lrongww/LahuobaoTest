package TestCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.w3c.dom.Document;

import commonFunction.CommonFunctions;
import commonFunction.DataProvide;
import commonFunction.DataReader;

public class QuotedPrice extends DataProvide {
	 public CommonFunctions comfun = new CommonFunctions();
	 public DataReader dr;
	 
	 @BeforeTest
	 public void Setup()throws Exception
	 {
		 
		 dr = new DataReader();
		  //设置数据源
		 // init("src/TestData/LoginTest.xml"); 
	 }
	 @Test
	 public void testQuotedPrice()throws Exception//司机报价
	 {
		 comfun.mouseHover();
		 comfun.clickItem("xpath", "//*[@id='toBeDriver']/dl/dd[8]/a");//我要当车主
		 
		 comfun.clickItem("xpath", "/html/body/div[2]/div[2]/form[2]/div/input");
		 
		 comfun.clickItem("xpath", "/html/body/div[2]/div[2]/table/tbody/tr[1]");
		 
		 comfun.clickItem("xpath", "html/body/div[2]/div[1]/div[2]/div[4]/div/input");
		
		 comfun.clickItem("id", "lyBuyNowbtnok");
	 }
	 //货主确认成交
	 @Test
	 public void testCargoOwnerComfirm()throws Exception
	 {
		 //切换为货主身份
		 comfun.mouseHover();
		 comfun.clickItem("xpath", ".//*[@id='toBeCarowner']/dl/dd[10]/a ");//我要当货主
		//点击我的发布
		 comfun.clickItem("id", "navTagQuoteMag");
		 //点击一条我发布的货源查看详情
		 comfun.clickItem("xpath", "/html/body/div[2]/div[2]/div/table/tbody/tr[1]");
		 //确认成交
		 comfun.clickItem("xpath", "/html/body/div[2]/div[1]/div[4]/table/tbody/tr/td[6]/div/form[2]/input[1]");
		 Thread.sleep(5000);
		 //点击待生成运单
		 comfun.clickItem("text", "待生成运单");
		 
	 }
	 
}
