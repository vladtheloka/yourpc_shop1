package population_chart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		 Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population").get();
	     Elements rows = doc.select("table.wikitable > tbody");
		 List<Country> countries = new ArrayList<Country>();
		 int spacing = 0;
	     int coff = 0;
	     int N = Integer.parseInt(JOptionPane.showInputDialog("Enter number of countries:"));
	     final int spaces_beetween_nums = 3;
	       
	      for(Element row : rows) 
	      {
	    	  for(int i = 1; i <= N; i++)
	    	  {
	    		  String Name = row.getElementsByTag("tr").get(i).getElementsByTag("td").get(1).text().replaceAll("\\[.*?\\]", "");
	    		  int popul = Integer.parseInt(row.getElementsByTag("tr").get(i).getElementsByTag("td").get(2).text().replace(",", "").replaceAll("\\[.*?\\]", ""));
	    		  countries.add(new Country(Name, popul));
	    	  }
	      }
	      
	      Collections.shuffle(countries);
	      
	      String[] namearr = new String[countries.size()];
		  String[] popularr = new String[countries.size()];
		     
	      for (int i = 0; i < namearr.length; i++) 
	      {
	    	  namearr[i] = countries.get(i).getName();
	    	  popularr[i] = String.valueOf(countries.get(i).getPopulation());
	      }
	      
	      spacing  = Arrays.stream(namearr).map(row -> row.length()).max(Integer::compare).get() + 10;
	      for (int i = 0; i < namearr.length; i++) 
	      {
	    	  System.out.println(rightPadding(namearr[i], spacing + coff) + "*");
	       	  coff += popularr[i].length() + spaces_beetween_nums;
	       	  System.out.println();
	      }
	      System.out.printf("%" + spacing + "s", " ");
	      for (int i = 0; i < popularr.length; i++)
	      {
	    	  System.out.print(popularr[i] + "   ");
	      }
	}
	
	public static String rightPadding(String str, int num) 
	{
		return String.format("%1$-" + num + "s", str);
	}
}
