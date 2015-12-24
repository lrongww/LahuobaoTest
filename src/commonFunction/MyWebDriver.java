package commonFunction;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class MyWebDriver {
		public WebDriver driver= null;
		private MyWebDriver(){
			driver = new FirefoxDriver();
		}
		
		
		// µ¥ÀýÄ£Ê½
		private static MyWebDriver webDriver = null;
		public static MyWebDriver getInstance(){
			if(webDriver==null){
				webDriver = new MyWebDriver();
			}
			return webDriver;
		}


	}

