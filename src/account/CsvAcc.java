package account;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CsvAcc {
	public ArrayList<BankAccount> readCsv() {
		//This function will read the data in the csv file to the system, which will return an arrayList
		ArrayList<BankAccount> csvList = new ArrayList<BankAccount>(); //Create a account list
		try {
			String csvFilePath = "./bankdata/CsvAcc.csv";  		
			CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("SJIS")); 
			reader.readHeaders();
			while(reader.readRecord()){ 	//Constantly read the content in csv file  
				BankAccount bankacc = new BankAccount();
				bankacc.accNo= Integer.parseInt(reader.get("accNo"));	
				bankacc.PIN=Integer.parseInt(reader.get("PIN"));		
				bankacc.balance=Double.parseDouble(reader.get("balance"));
				bankacc.odl=Double.parseDouble(reader.get("odl"));						
				bankacc.isSus=Boolean.parseBoolean(reader.get("isSus"));
				bankacc.isAct=Boolean.parseBoolean(reader.get("isAct"));
				bankacc.noticeN=Boolean.parseBoolean(reader.get("noticeN"));
				bankacc.accTyp=Integer.parseInt(reader.get("accTyp"));
				bankacc.ID=Integer.parseInt(reader.get("ID"));
			
				csvList.add(bankacc);	//Add the content of csv to our system
			}              
			reader.close();
			for(int row=0;row<csvList.size();row++){           
					BankAccount cell = csvList.get(row); 
					System.out.println(cell);  			
			}
		
		}catch(Exception ex){  
			System.out.println(ex);  
		}
		
		return csvList;
		
	}
	
	public void writeCsv(ArrayList<BankAccount> accList){ 
		//This function is used to write the data to out csv file
		try {  
			String csvFilePath = "./bankdata/CsvAcc.csv";  
			CsvWriter wr =new CsvWriter(csvFilePath,',',Charset.forName("SJIS")); 
			String[] header={"accNo","PIN","balance","odl","isSus","isAct","noticeN","accTyp","ID"};
			wr.writeRecord(header);		//Write the title to the first line
			for(int i = 0; i < accList.size(); i++){  
			BankAccount bankacc=new BankAccount();	
			bankacc=accList.get(i); 
			String[] contents = {bankacc.accNo+"",bankacc.PIN+"",bankacc.balance+"",bankacc.odl+"",bankacc.isSus+"",bankacc.isAct+"",bankacc.noticeN+"",bankacc.accTyp+"",bankacc.ID+""};                      
			wr.writeRecord(contents);	//Write data into the table
			}			
		wr.close();  
		} catch (IOException e) {  
		e.printStackTrace();  
		}  
	}

	
}
