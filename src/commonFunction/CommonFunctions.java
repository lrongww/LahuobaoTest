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
		//退出登录
		public void logout()throws Exception
		{
			this.clickItem("text", "退出");
		}
}
