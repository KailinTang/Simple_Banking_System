package credit;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CsvCre {
	public ArrayList<Credit> readCsv() {
		ArrayList<Credit> csvList = new ArrayList<Credit>();
		try {
		String csvFilePath = "./bankdata/CsvCre.csv";  
		
		CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("SJIS")); 
		reader.readHeaders();
		while(reader.readRecord()){  
			Credit credit = new Credit();
			credit.ID= Integer.parseInt(reader.get("ID"));
			credit.creStat=Boolean.parseBoolean(reader.get("creStat"));
			csvList.add(credit);  
			}              
			reader.close();
			for(int row=0;row<csvList.size();row++){           
				Credit  cell = csvList.get(row);   
					System.out.println(cell);  			
			}
		
		}catch(Exception ex){  
			System.out.println(ex);  
		}
		
		return csvList;
		
	}
	public void writeCsv(ArrayList<Credit> creditList){  
		try {  
		String csvFilePath = "./bankdata/CsvCre.csv";  
		CsvWriter wr =new CsvWriter(csvFilePath,',',Charset.forName("SJIS")); 
		String[] header={"ID","creStat"};
		wr.writeRecord(header);
        for(int i = 0; i < creditList.size(); i++)  
        {  
        Credit credit=new Credit();	
        credit=creditList.get(i);
        String[] contents = {credit.ID+"",credit.creStat+"",};                      
        wr.writeRecord(contents);	
        } 			
		wr.close();  
		} catch (IOException e) {  
		e.printStackTrace();  
		}  
	}
}
