package customer;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CsvGuest {
	public ArrayList<Guest> readCsv() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d");
		ArrayList<Guest> csvList = new ArrayList<Guest>();  
		try {
		String csvFilePath = "./bankdata/CsvCli.csv";  
		
		CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("SJIS")); 
		reader.readHeaders();
		while(reader.readRecord()){   
			Guest guest = new Guest();
			guest.ID= Integer.parseInt(reader.get("ID"));
			guest.name=reader.get("name");	
			guest.addr=reader.get("addr");	
			guest.dob=dateFormat.parse(reader.get("dob"));	
			guest.creStat=Boolean.parseBoolean(reader.get("creStat"));
			csvList.add(guest);  
			}              
			reader.close();
			for(int row=0;row<csvList.size();row++){           
					Guest  cell = csvList.get(row);  
					System.out.println(cell);  			
			}
		
		}catch(Exception ex){  
			System.out.println(ex);  
		}
		
		return csvList;
		
	}
	public void writeCsv(ArrayList<Guest> guestList){  
		try {  
		String csvFilePath = "./bankdata/CsvCli.csv";  
		CsvWriter wr =new CsvWriter(csvFilePath,',',Charset.forName("SJIS")); 
		String[] header={"ID","name","addr","dob","creStat"};
		wr.writeRecord(header);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d");
		Calendar calendar = Calendar.getInstance(); 
        for(int i = 0; i < guestList.size(); i++)  
        {  
        Guest guest=new Guest();	
        guest=guestList.get(i);
        calendar.setTime(guest.dob); 
        String str = (dateFormat.format(calendar.getTime()));
        String[] contents = {guest.ID+"",guest.name,guest.addr,str,guest.creStat+""};                      
        wr.writeRecord(contents);	
        } 

			
		wr.close();  
		} catch (IOException e) {  
		e.printStackTrace();  
		}  
	}

}