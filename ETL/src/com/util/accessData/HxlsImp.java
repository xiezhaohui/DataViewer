package com.util.accessData;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.HxlsAbstract;


public class HxlsImp extends HxlsAbstract{
	
	private ArrayList<String> dataList = new ArrayList<String>();
	private ArrayList<String> tableHeadList = new ArrayList<String>();
	

	public HxlsImp(String filename) throws IOException,
			FileNotFoundException, SQLException {
		super(filename);
	}

	@Override
	public void optRows(int sheetIndex,int curRow, List<String> rowlist) throws SQLException {
		//��ͷ 
		if(curRow == 0){
			tableHeadList.clear();
		    for (int i = 0 ;i< rowlist.size();i++){
		    	
			    System.out.print("'"+rowlist.get(i)+"',");
			    tableHeadList.add(rowlist.get(i));
		    }
		}
		else {
			dataList.clear();
		    for (int i = 0 ;i< rowlist.size();i++){
		    	
			    System.out.print("'"+rowlist.get(i)+"',");
			    dataList.add(rowlist.get(i));
		    }
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		HxlsImp xls2csv;
		try {
			xls2csv = new HxlsImp("dd.xls");
			xls2csv.process();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
