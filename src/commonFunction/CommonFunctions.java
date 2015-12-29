package commonFunction;

import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CommonFunctions {
	public WebDriver driver= MyWebDriver.getInstance().driver;
	
	public CommonFunctions()
	{
		
	}
	//������ҳ
	public void getUrl(String url)throws Exception
	{
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(5000);
	}
	//�˳������
	public void tearDown()
	{
		try
		{
			driver.quit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//��ȡҳ��Ԫ���ı�
		public String getText(String type,String location)
		{
		WebElement elem =null;
		if(type.equals("xpath"))
			elem =driver.findElement(By.xpath(location));
		
		if(type.equals("name"))
			elem =driver.findElement(By.name(location));
		
		if(type.equals("id"))
			elem =driver.findElement(By.id(location));
		
		if(type.equals("classname"))
			elem =driver.findElement(By.className(location));
		
		if(type.equals("css"))
			elem =driver.findElement(By.cssSelector(location));
		
		return elem.getText();
		}
		//����ĳ��Ԫ��
		public void clickItem(String type,String location)throws Exception
		{
			WebElement elem = null;
			if(type.equals("xpath"))
				elem =driver.findElement(By.xpath(location));
			
			if(type.equals("name"))
				elem =driver.findElement(By.name(location));
			
			if(type.equals("id"))
				elem =driver.findElement(By.id(location));
			
			if(type.equals("classname"))
				elem =driver.findElement(By.className(location));
			
			if(type.equals("text"))
				elem =driver.findElement(By.linkText(location));
			elem.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			
		}
		//����ı�������
		public void clearvalue(String type,String location)
		{
			WebElement elem=null;
			if(type.equals("xpath"))
				elem =driver.findElement(By.xpath(location));
			
			if(type.equals("name"))
				elem =driver.findElement(By.name(location));
			
			if(type.equals("id"))
				elem =driver.findElement(By.id(location));
			
			if(type.equals("classname"))
				elem =driver.findElement(By.className(location));
			
			if(type.equals("css"))
				elem =driver.findElement(By.cssSelector(location));
			elem.clear();	
		}
		//���ı�����������
		public void inputValue(String type,String location,String text)
		{
		WebElement elem =null;
		if(type.equals("xpath"))
			elem =driver.findElement(By.xpath(location));
		
		if(type.equals("name"))
			elem =driver.findElement(By.name(location));
		
		if(type.equals("id"))
			elem =driver.findElement(By.id(location));
		
		if(type.equals("classname"))
		{
			elem =driver.findElement(By.className(location));
		}
		if(type.equals("css"))
		{
			elem =driver.findElement(By.cssSelector(location));
		}
		 elem.sendKeys(text);
		}
		//�ж�str1��str2�Ƿ����
		public void  ckeckequal(String str1,String str2)
		{
			Assert.assertEquals(str1,str2);
			
		}
		public void login(String name, String psd)throws Exception
		{
			this.clickItem("xpath", "/html/body/div[1]/div[2]/div/div/ul/li[1]/a");
			this.inputValue("name", "userName", name);
			this.inputValue("name", "password", psd);
			this.clickItem("xpath", ".//*[@id='loginForm']/div[1]/div[3]/input");
			Thread.sleep(3000);
		}
		//ģ�������ͣ
		public void mouseHover()
		{
			WebElement user = driver.findElement(By.id("nowrap"));
			Actions action= new Actions(driver);
			action.moveToElement(user).perform();
		}
		//�ж�ĳҳ��Ԫ���Ƿ����
		public boolean doesWebElementExist(String type,String location)
		{
			try{
				WebElement elem = null;
				if(type.equals("xpath"))
					elem =driver.findElement(By.xpath(location));
				
				if(type.equals("name"))
					elem =driver.findElement(By.name(location));
				
				if(type.equals("id"))
					elem =driver.findElement(By.id(location));
				
				if(type.equals("classname"))
					elem =driver.findElement(By.className(location));
				
				if(type.equals("text"))
					elem =driver.findElement(By.linkText(location));
				return true;
			}catch(NoSuchElementException e)
			{
				return false;
			}
		}
		//����������
		public void handlePullDown(String type,String location,int index)
		{
			WebElement elem = null;
			if(type.equals("xpath"))
				elem =driver.findElement(By.xpath(location));
			
			if(type.equals("name"))
				elem =driver.findElement(By.name(location));
			
			if(type.equals("id"))
				elem =driver.findElement(By.id(location));
			
			if(type.equals("classname"))
				elem =driver.findElement(By.className(location));
			
			if(type.equals("text"))
				elem =driver.findElement(By.linkText(location));
			Select select = new Select(elem);
			select.selectByIndex(index);
		}
		//ѡ���շ�����ַ
		public void selectAdress(String location,String provinceid,String cityid ,String districtid)throws Exception
		{//�÷������㷨�е���ң�idʵ����û���ҵ����ɣ�֮�����Ż�
			this.clearvalue("id", location);
			this.clickItem("id", location);
			this.clickItem("xpath", "html/body/div[5]/div[1]/ul/li[2]/a");
			int pid = Integer.parseInt(provinceid);
			int cider = Integer.parseInt(cityid)%pid;
			//int dider = Integer.parseInt(districtid)%Integer.parseInt(cityid);
			if(pid>340000)
			{
				this.clickItem("xpath", "/html/body/div[5]/div[2]/div[2]/div[3]/a");
				if(pid>520000)
				{
					this.clickItem("xpath", "/html/body/div[5]/div[2]/div[2]/div[3]/a");
				}
			}
			this.clickItem("id", provinceid);
			if(cider>1400)
			{
				this.clickItem("xpath", "/html/body/div[5]/div[2]/div[2]/div[3]/a");
			}
			this.clickItem("id", cityid);
			this.clickItem("id", districtid);
			Thread.sleep(1000);
			
		}
		//����������ѡ���˵�����Ĳ�ͬ״̬
		public void clickWaybillStates(String status,String states)throws Exception
		{
			if(status.equals("��Ҫ������"))
			{
				this.mouseHover();
				this.clickItem("xpath", "//*[@id='toBeDriver']/dl/dd[8]/a");//��Ҫ������
				this.clickItem("id", "navTagShippingMag");//����˵�����
				this.clickItem("text", states);//���״̬
				this.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//ѡ��һ�������۵ļ�¼
				if(states.equals("�������ջ�")||states.equals("�������˵�"))
				{
					this.clickItem("xpath", ".//*[@id='frmApplyforreceipt']/input[2]");//��������ջ���ť
					this.clickItem("xpath", "html/body/div[2]/div/div[2]/div[1]/div[2]/div/button");//����ϴ��ص�
					this.inputValue("xpath", ".//*[@id='frmBackImg']/div[1]/div[1]/div/input", "E:\\BugCupture\\123.png");
					this.inputValue("xpath", ".//*[@id='frmBackImg']/div[1]/div[2]/div/input", "E:\\BugCupture\\11.png");
					this.inputValue("xpath", ".//*[@id='frmBackImg']/div[1]/div[3]/div/input", "E:\\BugCupture\\dd.png");
					this.clickItem("id", "lyEditbtnok");
				}
				else if(states.equals("������"))
				{
					this.clickItem("xpath", "/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/div/form/input[3]");//������۳�����ť
					this.clickItem("xpath", "/html/body/div[2]/form/div/div[3]/div[2]/div[1]/ul/li[5]/img");//5����
					this.inputValue("xpath", "/html/body/div[2]/form/div/div[3]/div[2]/div[2]/textarea", "�����ǳ���");
					this.clickItem("xpath", "/html/body/div[2]/form/div/div[3]/div[4]/input");//����ύ��ť
				}
			}
			
			
			if(status.equals("��Ҫ������"))
			{
				this.mouseHover();
				this.clickItem("xpath", ".//*[@id='toBeCarowner']/dl/dd[10]/a ");//��Ҫ������
				this.clickItem("id", "navTagShippingMag");//����˵�����
				this.clickItem("text", states);//���״̬
				this.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//ѡ��һ�������۵ļ�¼
				if(states.equals("�������˵�"))
				{
					 //�˵�Ĭ�ϣ�����д
					  this.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//ѡ���һ���������˵���¼
					  this.clickItem("xpath", "html/body/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/button");//��������˵���ť
					  this.clickItem("xpath", ".//*[@id='divWaybillButtonGroup1']/div/input");//�����һҳ
					  this.clickItem("xpath", ".//*[@id='divWaybillButtonGroup2']/div/button");//���ȷ�ϰ�ť  
				}
				
				else if(states.equals("���ջ�")||states.equals("�������ջ�"))//ȷ���ջ�������
				{
					this.clickItem("id", "policy");//��ѡͬ��Э��
					this.clickItem("xpath", "/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/form/div/input[2]");//ȷ���ջ�������
					this.clearvalue("xpath", "/html/body/div[2]/div[4]/table/tbody/tr/td/div/form/div[1]/div/input");
					this.inputValue("xpath", "/html/body/div[2]/div[4]/table/tbody/tr/td/div/form/div[1]/div/input", "111111");//����֧������
					this.clickItem("xpath", "/html/body/div[2]/div[4]/table/tbody/tr/td/div/form/div[2]/div/input");//ȷ��
				}
				else if(states.equals("������"))
				{
					
					this.clickItem("xpath", "/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/div/form/input[3]");//������۳�����ť
					this.clickItem("xpath", "/html/body/div[2]/form/div/div[3]/div[2]/div[1]/ul/li[5]/img");//5����
					this.inputValue("xpath", "/html/body/div[2]/form/div/div[3]/div[2]/div[2]/textarea", "�����ǳ���");
					this.clickItem("xpath", "/html/body/div[2]/form/div/div[3]/div[4]/input");//����ύ��ť
				}
				
			}
		}
		//�˳���¼
		public void logout()throws Exception
		{
			this.clickItem("text", "�˳�");
		}
}
