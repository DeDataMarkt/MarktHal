package Data;

import java.io.*;
import java.util.ArrayList;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;



public class PieChart {
	
	static ArrayList<String> CSV = new ArrayList<String>();

	public static void MakeChart() throws Exception {
			read();
			
	      DefaultPieDataset dataset = new DefaultPieDataset( );

	      double value = Double.parseDouble(CSV.get(3));
	      dataset.setValue(CSV.get(2) + ":" +  CSV.get(3), new Double( value ) );
	      value = Double.parseDouble(CSV.get(5));
	      dataset.setValue(CSV.get(4) + ":" +  CSV.get(5), new Double( value ) );
	      value = Double.parseDouble(CSV.get(7));
	      dataset.setValue(CSV.get(6) + ":" +  CSV.get(7), new Double( value ) );
	      value = Double.parseDouble(CSV.get(9));
	      dataset.setValue(CSV.get(8) + ":" +  CSV.get(9), new Double( value ) );
	      value = Double.parseDouble(CSV.get(11));
	      dataset.setValue(CSV.get(10) + ":" +  CSV.get(11), new Double( value ) );
	      value = Double.parseDouble(CSV.get(13));
	      dataset.setValue(CSV.get(12) + ":" +  CSV.get(13), new Double( value ) );
	      value = Double.parseDouble(CSV.get(15));
	      dataset.setValue(CSV.get(14) + ":" +  CSV.get(15), new Double( value ) );
	      value = Double.parseDouble(CSV.get(17));
	      dataset.setValue(CSV.get(16) + ":" + CSV.get(17), new Double( value ) ); 

	      JFreeChart chart = ChartFactory.createPieChart(
	         "Amount of tweets", // chart title
	         dataset, // data
	         true, // include legend
	         true,
	         false);
	         
	      int width = 640; /* Width of the image */
	      int height = 480; /* Height of the image */ 
	      File pieChart = new File( "C:/Users/Oscar Veldman/workspace/MarktHalTwitter/Country.jpeg" ); 
	      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
	   }
	
		public static void read(){
			
			try{
				
				 BufferedReader CSVFile = 
					      new BufferedReader(new FileReader("C:/Users/Oscar Veldman/workspace/MarktHalTwitter/MH_country.csv"));

					  String dataRow = CSVFile.readLine(); 
					  while (dataRow != null){
					   String[] dataArray = dataRow.split(",");
					   for (String item:dataArray) { 
					      CSV.add(item);
					   } 
					   dataRow = CSVFile.readLine();
					  }

					  CSVFile.close();

				
			}catch(Exception e){
				
				  System.out.println("Systeem: Er is een fout opgetreden!");
				
			}
			
		}
	
	
}
