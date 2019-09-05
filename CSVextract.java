import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

public class CSVextract {
	public int row,column,datarow=row-1,datacolumn = column-1;
	public String[][] entry;
	public CSVextract(File file)
	{
		try {
			readCSV(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public String[][] getEntry()
	{
		return entry;
	}
	public double[][] getDataTable()
	{
		double dataTable[][] = new double[row][column];
		for(int i=1;i<row;i++)
		{
			for(int j=1;j<column;j++) 
			{
				dataTable[i][j] = Double.parseDouble(entry[i][j]);
			}
		}
		return dataTable;
	}
	
	public String[] getFields()
	{
		String field[] = new String[column-1];
		for(int i=1;i<row;i++)
		{
			field[i]= entry[0][i];
		}
		return field;
	}
	public String[] getKey()
	{
		String[] key = new String[row-1];
		for(int i=1;i<row;i++)
		{
			key[i] = entry[i][0];
		}
		return key;
	}
	public String[][] readCSV (File file) throws FileNotFoundException 
	{
		String entry[][] = new String[100][100];
		 row=0;column=0;int columnCount=0;
		/*Scanner reader;
		try 
		{
			reader = new Scanner(file);	
			Scanner sc2 = new Scanner(file);
			while (sc2.hasNextLine())
			{
				for (String item : sc2.next().split(","))
				{
					entry[row][column]=reader.next();
				    column++;
				    System.out.println(item);System.out.println(column+" "+row);
				}		
			}*/
			/////
			/*while(reader.hasNext())
			{
				reader.useDelimiter(",|\\r\\n");
				while(reader.hasNext()) 
				{
					try{
						
						if(Pattern.matches(Pattern.compile("\\r\\n"),reader.next()))
						{
							row++;System.out.println("br");
						}
						System.out.println(column+" "+row);						
					    entry[row][column]=reader.next();
					    column++;
					    
					}catch(NumberFormatException e) {}
				}				
			} 
			column ++;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				//System.out.print(entry[i][j]+" ");
			}
			System.out.println();
		}*/
		 
		 // 1st, config the CSV reader
	        CsvParserSettings settings = new CsvParserSettings();
	        settings.getFormat().setLineSeparator("\n");
	        settings.selectFields("Color1", "Color3", "Color2");
	        // 2nd, creates a CSV parser with the configs
	        CsvParser parser = new CsvParser(settings);
	        // 3rd, parses all rows of data in selected columns from the CSV file into a matrix
	        List<String[]> resolvedData = parser.parseAll(new FileReader(file));
	        // 3rd, process the matrix with business logic
	        for (String[] row : resolvedData)
	        {
	            StringBuilder strBuilder = new StringBuilder();
	            for (String col : row) 
	            {
	                strBuilder.append(col).append("\t");
	            }
	            System.out.println(strBuilder);
	        }
	   
		return entry;		
	}

}
