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
		  //��������Դ
		 // init("src/TestData/LoginTest.xml"); 
	 }
	 @Test
	 public void testQuotedPrice()throws Exception//˾������
	 {
		 comfun.mouseHover();
		 comfun.clickItem("xpath", "//*[@id='toBeDriver']/dl/dd[8]/a");//��Ҫ������
		 
		 comfun.clickItem("xpath", "/html/body/div[2]/div[2]/form[2]/div/input");
		 
		 comfun.clickItem("xpath", "/html/body/div[2]/div[2]/table/tbody/tr[1]");
		 
		 comfun.clickItem("xpath", "html/body/div[2]/div[1]/div[2]/div[4]/div/input");
		
		 comfun.clickItem("id", "lyBuyNowbtnok");
	 }
	 //����ȷ�ϳɽ�
	 @Test
	 public void testCargoOwnerComfirm()throws Exception
	 {
		 //�л�Ϊ�������
		 comfun.mouseHover();
		 comfun.clickItem("xpath", ".//*[@id='toBeCarowner']/dl/dd[10]/a ");//��Ҫ������
		//����ҵķ���
		 comfun.clickItem("id", "navTagQuoteMag");
		 //���һ���ҷ����Ļ�Դ�鿴����
		 comfun.clickItem("xpath", "/html/body/div[2]/div[2]/div/table/tbody/tr[1]");
		 //ȷ�ϳɽ�
		 comfun.clickItem("xpath", "/html/body/div[2]/div[1]/div[4]/table/tbody/tr/td[6]/div/form[2]/input[1]");
		 Thread.sleep(5000);
		 //����������˵�
		 comfun.clickItem("text", "�������˵�");
		 
	 }
	 
}
