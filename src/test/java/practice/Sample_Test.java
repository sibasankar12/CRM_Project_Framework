package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.generic.ExcelUtility;

public class Sample_Test {

	@Test(dataProvider="dp_addtoCartAndBill")
	public  void addtoCartAndBill(String pName,String qty) 
	{
		System.out.println("exedute" +pName+"and add to cart and bill");

	}
@DataProvider
public Object[][] dp_addtoCartAndBill() throws Throwable
{
  
	ExcelUtility elib=new ExcelUtility();
	int rowcount = elib.getRowCount("MobileData");
	System.out.println(rowcount);
	Object[][] objArr=new Object[rowcount][2];
	
	for(int i=0;i<rowcount;i++)
	{
		 objArr[i][0]=elib.getDataFromExcel("MobileData", i, 0);
		 objArr[i][1]=elib.getDataFromExcel("MobileData", i, 1);
	}
   
  return objArr;


}
}