


	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;

	import org.json.simple.JSONObject;

	public class usecase1 
	{

		public static void main(String[] args)  
		{
			try {
			FileReader fr=new FileReader("Memory.txt");
			BufferedReader br=new BufferedReader(fr);
			float avg=0;
			float max=0;
			float total=0;
			int i=0;
			String line;
			
			
			JSONObject values=new JSONObject();
			JSONObject value=new JSONObject();
			JSONObject avgmemory=new JSONObject();
			JSONObject maxmemory=new JSONObject();
			JSONObject userName=new JSONObject();
			JSONObject file=new JSONObject();
			int count=0;
			while((line=br.readLine())!=null)
			{
				if(count%2!=0)
				{
					String splitvalues[]=line.split("\\s+");
					float fval=Float.parseFloat(splitvalues[2]);
					fval=fval/1024;
					if(max<fval)
					{
						max=fval;
					}
					total+=fval;
					String s=i+"s";
					values.put(s, (String.format("%.2f",fval)));
					
					i++;
				}
				count++;
				
			}
			avg=total/count;
			
			file.put("AverageMemory(MB)", (String.format("%.2f",avg)));
			
			file.put("value", values);
			
			file.put("MaxMemory(MB)", (String.format("%.2f",max)));
			
			file.put("Usecasename", "HomePage");
			System.out.println(file);
			FileWriter fil=new FileWriter("usecase_one_out.json");
			fil.write(file.toJSONString());
			fil.close();
			fr.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			

		}

	}

