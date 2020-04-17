package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.readexcel.ApachePOIExcelRead;

public class ExcelReadding {
	
	ApachePOIExcelRead read = new ApachePOIExcelRead();
	@Test
	public void viewOrderDetails() throws Exception
	{
		System.out.println("satya");
		
		String[][] maininputValues =  read.getExcelContent("C:\\Users\\AmbavarapuSatyabrahm\\Desktop\\CloudTraining\\maininput.xlsx");
		
		System.out.println(maininputValues[1][0]);
		System.out.println(maininputValues[1][1]);
		
		String macroInput = maininputValues[1][0];
		String autoInput =  maininputValues[1][1];
		String[] accountNumber = null;
		String[] branch = null;
		String[] testcase = null;
		
		String[][] macroInputvalues = read.getExcelContent(macroInput);
		int cellcount = 0;
		//System.out.println(macroInputvalues.length);
		for(int j = 0 ; j< 3;j++)
		{  
			
			for(int i = 1; i< macroInputvalues.length;i++)
			{
				if(j==0)
				{
					
					String accountNumbe = macroInputvalues[i][j];
					System.out.println(accountNumbe);
					//accountNumber[cellcount] = accountNumbe;
					
					
				}
				
				/*if(j==1)
				{
					int cellcount1 = 0;
					String branchv = macroInputvalues[i][j];
					branch[cellcount1] = branchv;
					cellcount1++;
				}
				if(j==2)
				{
					int cellcount2 = 0;
					String testcasev = macroInputvalues[i][j];
					testcase[cellcount2] = testcasev;
					cellcount2++;
				}
				*/
				
			}
			//System.out.println(accountNumber);
		}
		
	}
}


