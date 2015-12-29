package TestCases;

import org.testng.annotations.Test;

import commonFunction.CommonFunctions;

public class WaybillManagement {
	public CommonFunctions comfun = new CommonFunctions();
  @Test
  public void GenerateWaybill()throws Exception //货主生成运单
  {
	  //运单默认，不填写
	  comfun.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//选择第一条待生成运单记录
	  comfun.clickItem("xpath", "html/body/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/button");//点击生成运单按钮
	  comfun.clickItem("xpath", ".//*[@id='divWaybillButtonGroup1']/div/input");//点击下一页
	  comfun.clickItem("xpath", ".//*[@id='divWaybillButtonGroup2']/div/button");//点击确认按钮  
  }
  
  @Test
  public void ApplyTakeOver() throws Exception//车主申请收货
  {
	  //切换为车主身份
	  comfun.mouseHover();
	  comfun.clickItem("xpath", "//*[@id='toBeDriver']/dl/dd[8]/a");//我要当车主
	  comfun.clickItem("id", "navTagShippingMag");//点击运单管理
	  comfun.clickItem("text", "待申请收货");//点击待申请收货
	  comfun.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//选择一条待申请收货的记录
	  comfun.clickItem("xpath", ".//*[@id='frmApplyforreceipt']/input[2]");//点击申请收货按钮
	  comfun.clickItem("xpath", "html/body/div[2]/div/div[2]/div[1]/div[2]/div/button");//点击上传回单
	  comfun.inputValue("xpath", ".//*[@id='frmBackImg']/div[1]/div[1]/div/input", "E:\\BugCupture\\123.png");
	  comfun.inputValue("xpath", ".//*[@id='frmBackImg']/div[1]/div[2]/div/input", "E:\\BugCupture\\11.png");
	  comfun.inputValue("xpath", ".//*[@id='frmBackImg']/div[1]/div[3]/div/input", "E:\\BugCupture\\dd.png");
	  comfun.clickItem("id", "lyEditbtnok");
	
  }
  @Test
  public void ModifyFreight() throws Exception//货主修改运费
  {
	//切换为货主身份
	  comfun.mouseHover();
	  comfun.clickItem("xpath", ".//*[@id='toBeCarowner']/dl/dd[10]/a ");//我要当货主
	  comfun.clickItem("id", "navTagShippingMag");//点击运单管理
	  comfun.clickItem("text", "待收货");//点击待收货
	  comfun.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//选择一条待收货的记录
	  comfun.clickItem("xpath", "/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/div/button");//点击修改运费按钮
	  comfun.clickItem("xpath", "/html/body/div[2]/div[3]/table/tbody/tr/td/div/form/div[1]/input[2]");//点击增加运费单选框
	  comfun.inputValue("id", "iptClaimFee","100");//增加的运费
	  comfun.inputValue("id", "iptClaimNote","货物增加");//增加的运费原因
	  comfun.clickItem("xpath", ".//*[@id='frmAppliyClaimsFee']/div[2]/div/input");//点击确定按钮
  }
  @Test
  public void ComfirmFreight() throws Exception//车主确认修改运费
  {
	//切换为车主身份
	  comfun.mouseHover();
	  comfun.clickItem("xpath", "//*[@id='toBeDriver']/dl/dd[8]/a");//我要当车主
	  comfun.clickItem("id", "navTagShippingMag");//点击运单管理
	  comfun.clickItem("text", "待收货");//点击待收货
	  comfun.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//选择一条待收货的记录
	  comfun.clickItem("xpath", "/html/body/div[2]/div/div[2]/div[1]/div[2]/div[1]/form/input[2]");//点击确认修改按钮
  }
  @Test
  public void PayAndEvalate()throws Exception
  {
	  comfun.clickWaybillStates("我要当货主", "待收货");//切换为货主，点击待收货
	  comfun.clickWaybillStates("我要当车主", "待评价");
	 // comfun.clickWaybillStates("我要当货主", "待评价");
  }
  
  
  
}
