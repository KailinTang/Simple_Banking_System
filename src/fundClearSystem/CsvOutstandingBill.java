package fundClearSystem;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CsvOutstandingBill {
	public ArrayList<Bill> readCsv() {
		ArrayList<Bill> csvList = new ArrayList<Bill>();
		try {
		String csvFilePath = "./bankdata/CsvOut.csv";  
		
		CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("SJIS")); 
		reader.readHeaders();
		while(reader.readRecord()){ 
			Bill bill = new Bill();
			bill.accNo= Integer.parseInt(reader.get("accNo"));	
			bill.amount=Integer.parseInt(reader.get("amount"));
			csvList.add(bill);  
			}              
			reader.close();
			for(int row=0;row<csvList.size();row++){           
				Bill  cell = csvList.get(row);
					System.out.println(cell);  			
			}
		
		}catch(Exception ex){  
			System.out.println(ex);  
		}
		
		return csvList;
		
	}
	public void writeCsv(ArrayList<Bill> billList){  
		try {  
		String csvFilePath = "./bankdata/CsvOut.csv";  
		CsvWriter wr =new CsvWriter(csvFilePath,',',Charset.forName("SJIS")); 
		String[] header={"accNo","amount"};
		wr.writeRecord(header);
        for(int i = 0; i < billList.size(); i++)  
        {  
        Bill bill=new Bill();	
        bill=billList.get(i);
        String[] contents = {bill.accNo+"",bill.amount+"",};                      
        wr.writeRecord(contents);	
        } 			
		wr.close();  
		} catch (IOException e) {  
		e.printStackTrace();  
		}  
	}
}
