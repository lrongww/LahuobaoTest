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
	//代开网页
	public void getUrl(String url)throws Exception
	{
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(5000);
	}
	//退出浏览器
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
	//获取页面元素文本
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
		//单击某个元素
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
		//清除文本框内容
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
		//向文本框输入内容
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
		//判断str1和str2是否相等
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
		//模拟鼠标悬停
		public void mouseHover()
		{
			WebElement user = driver.findElement(By.id("nowrap"));
			Actions action= new Actions(driver);
			action.moveToElement(user).perform();
		}
		//判断某页面元素是否存在
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
		//处理下拉框
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
		//选择收发货地址
		public void selectAdress(String location,String provinceid,String cityid ,String districtid)throws Exception
		{//该方法的算法有点混乱，id实际上没有找到规律，之后还需优化
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
		//车主、货主选择运单管理的不同状态
		public void clickWaybillStates(String status,String states)throws Exception
		{
			if(status.equals("我要当车主"))
			{
				this.mouseHover();
				this.clickItem("xpath", "//*[@id='toBeDriver']/dl/dd[8]/a");//我要当车主
				this.clickItem("id", "navTagShippingMag");//点击运单管理
				this.clickItem("text", states);//点击状态
				this.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//选择一条待评价的记录
				if(states.equals("待申请收货")||states.equals("待生成运单"))
				{
					this.clickItem("xpath", ".//*[@id='frmApplyforreceipt']/input[2]");//点击申请收货按钮
					this.clickItem("xpath", "html/body/div[2]/div/div[2]/div[1]/div[2]/div/button");//点击上传回单
					this.inputValue("xpath", ".//*[@id='frmBackImg']/div[1]/div[1]/div/input", "E:\\BugCupture\\123.png");
					this.inputValue("xpath", ".//*[@id='frmBackImg']/div[1]/div[2]/div/input", "E:\\BugCupture\\11.png");
					this.inputValue("xpath", ".//*[@id='frmBackImg']/div[1]/div[3]/div/input", "E:\\BugCupture\\dd.png");
					this.clickItem("id", "lyEditbtnok");
				}
				else if(states.equals("待评价"))
				{
					this.clickItem("xpath", "/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/div/form/input[3]");//点击评价车主按钮
					this.clickItem("xpath", "/html/body/div[2]/form/div/div[3]/div[2]/div[1]/ul/li[5]/img");//5颗星
					this.inputValue("xpath", "/html/body/div[2]/form/div/div[3]/div[2]/div[2]/textarea", "货主非常好");
					this.clickItem("xpath", "/html/body/div[2]/form/div/div[3]/div[4]/input");//点击提交按钮
				}
			}
			
			
			if(status.equals("我要当货主"))
			{
				this.mouseHover();
				this.clickItem("xpath", ".//*[@id='toBeCarowner']/dl/dd[10]/a ");//我要当货主
				this.clickItem("id", "navTagShippingMag");//点击运单管理
				this.clickItem("text", states);//点击状态
				this.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//选择一条待评价的记录
				if(states.equals("待生成运单"))
				{
					 //运单默认，不填写
					  this.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//选择第一条待生成运单记录
					  this.clickItem("xpath", "html/body/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/button");//点击生成运单按钮
					  this.clickItem("xpath", ".//*[@id='divWaybillButtonGroup1']/div/input");//点击下一页
					  this.clickItem("xpath", ".//*[@id='divWaybillButtonGroup2']/div/button");//点击确认按钮  
				}
				
				else if(states.equals("待收货")||states.equals("待申请收货"))//确认收货并付款
				{
					this.clickItem("id", "policy");//勾选同意协议
					this.clickItem("xpath", "/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/form/div/input[2]");//确认收货并付款
					this.clearvalue("xpath", "/html/body/div[2]/div[4]/table/tbody/tr/td/div/form/div[1]/div/input");
					this.inputValue("xpath", "/html/body/div[2]/div[4]/table/tbody/tr/td/div/form/div[1]/div/input", "111111");//输入支付密码
					this.clickItem("xpath", "/html/body/div[2]/div[4]/table/tbody/tr/td/div/form/div[2]/div/input");//确定
				}
				else if(states.equals("待评价"))
				{
					
					this.clickItem("xpath", "/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/div/form/input[3]");//点击评价车主按钮
					this.clickItem("xpath", "/html/body/div[2]/form/div/div[3]/div[2]/div[1]/ul/li[5]/img");//5颗星
					this.inputValue("xpath", "/html/body/div[2]/form/div/div[3]/div[2]/div[2]/textarea", "车主非常好");
					this.clickItem("xpath", "/html/body/div[2]/form/div/div[3]/div[4]/input");//点击提交按钮
				}
				
			}
		}
		//退出登录
		public void logout()throws Exception
		{
			this.clickItem("text", "退出");
		}
}
