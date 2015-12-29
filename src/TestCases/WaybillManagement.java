package TestCases;

import org.testng.annotations.Test;

import commonFunction.CommonFunctions;

public class WaybillManagement {
	public CommonFunctions comfun = new CommonFunctions();
  @Test
  public void GenerateWaybill()throws Exception //���������˵�
  {
	  //�˵�Ĭ�ϣ�����д
	  comfun.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//ѡ���һ���������˵���¼
	  comfun.clickItem("xpath", "html/body/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/button");//��������˵���ť
	  comfun.clickItem("xpath", ".//*[@id='divWaybillButtonGroup1']/div/input");//�����һҳ
	  comfun.clickItem("xpath", ".//*[@id='divWaybillButtonGroup2']/div/button");//���ȷ�ϰ�ť  
  }
  
  @Test
  public void ApplyTakeOver() throws Exception//���������ջ�
  {
	  //�л�Ϊ�������
	  comfun.mouseHover();
	  comfun.clickItem("xpath", "//*[@id='toBeDriver']/dl/dd[8]/a");//��Ҫ������
	  comfun.clickItem("id", "navTagShippingMag");//����˵�����
	  comfun.clickItem("text", "�������ջ�");//����������ջ�
	  comfun.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//ѡ��һ���������ջ��ļ�¼
	  comfun.clickItem("xpath", ".//*[@id='frmApplyforreceipt']/input[2]");//��������ջ���ť
	  comfun.clickItem("xpath", "html/body/div[2]/div/div[2]/div[1]/div[2]/div/button");//����ϴ��ص�
	  comfun.inputValue("xpath", ".//*[@id='frmBackImg']/div[1]/div[1]/div/input", "E:\\BugCupture\\123.png");
	  comfun.inputValue("xpath", ".//*[@id='frmBackImg']/div[1]/div[2]/div/input", "E:\\BugCupture\\11.png");
	  comfun.inputValue("xpath", ".//*[@id='frmBackImg']/div[1]/div[3]/div/input", "E:\\BugCupture\\dd.png");
	  comfun.clickItem("id", "lyEditbtnok");
	
  }
  @Test
  public void ModifyFreight() throws Exception//�����޸��˷�
  {
	//�л�Ϊ�������
	  comfun.mouseHover();
	  comfun.clickItem("xpath", ".//*[@id='toBeCarowner']/dl/dd[10]/a ");//��Ҫ������
	  comfun.clickItem("id", "navTagShippingMag");//����˵�����
	  comfun.clickItem("text", "���ջ�");//������ջ�
	  comfun.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//ѡ��һ�����ջ��ļ�¼
	  comfun.clickItem("xpath", "/html/body/div[2]/div[1]/div[2]/div[1]/div[2]/div/button");//����޸��˷Ѱ�ť
	  comfun.clickItem("xpath", "/html/body/div[2]/div[3]/table/tbody/tr/td/div/form/div[1]/input[2]");//��������˷ѵ�ѡ��
	  comfun.inputValue("id", "iptClaimFee","100");//���ӵ��˷�
	  comfun.inputValue("id", "iptClaimNote","��������");//���ӵ��˷�ԭ��
	  comfun.clickItem("xpath", ".//*[@id='frmAppliyClaimsFee']/div[2]/div/input");//���ȷ����ť
  }
  @Test
  public void ComfirmFreight() throws Exception//����ȷ���޸��˷�
  {
	//�л�Ϊ�������
	  comfun.mouseHover();
	  comfun.clickItem("xpath", "//*[@id='toBeDriver']/dl/dd[8]/a");//��Ҫ������
	  comfun.clickItem("id", "navTagShippingMag");//����˵�����
	  comfun.clickItem("text", "���ջ�");//������ջ�
	  comfun.clickItem("xpath", ".//*[@id='lineSearchInfoTable']/tbody/tr[1]");//ѡ��һ�����ջ��ļ�¼
	  comfun.clickItem("xpath", "/html/body/div[2]/div/div[2]/div[1]/div[2]/div[1]/form/input[2]");//���ȷ���޸İ�ť
  }
  @Test
  public void PayAndEvalate()throws Exception
  {
	  comfun.clickWaybillStates("��Ҫ������", "���ջ�");//�л�Ϊ������������ջ�
	  comfun.clickWaybillStates("��Ҫ������", "������");
	 // comfun.clickWaybillStates("��Ҫ������", "������");
  }
  
  
  
}
