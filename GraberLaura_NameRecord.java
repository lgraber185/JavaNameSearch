/** Laura Graber */

/** MSI-503 */

/** Final Project */

//***********************************************
// GraberLaura_NameRecord
//
// Creates Name_Record class to create a NameRecord
// object, sets and gets name record, returns
// attributes such as name rank and most 
// popular year
//***********************************************

import java.util.Arrays;
import java.util.Random;
import java.awt.Color;




public class GraberLaura_NameRecord // to create NameRecord object
{
	public int yearVals[] = {1900, 1910, 1920, 1930, 1940, 1950, 1960, 1970, 1980, 1990, 2000, 2010};
	public String nameVal;
	public int nameRanks[];
	public int bestYear;
	public int nameRank;
	public int nameRankVal;

	public void NameRecord(String nameVal) // sets name value
	{
		this.nameVal = nameVal;	
	}
	public String getName()
	{
		return this.nameVal;		
	}
	public int getRank(int yearVal, int nameRanks[])
	{
		for(int i = 0; i<yearVals.length; i++)
		{
			if(yearVals[i] == yearVal)
			{
				nameRankVal = nameRanks[i];
			}
			
		}
		this.nameRank = nameRankVal;
		return this.nameRank;
	}
	public int bestYear(int nameRanks[])
	{
		//pull from array
		int min = -1; // placeholder
		int indexOfMin = -1; // placeholder
		//first get array maximum
		for (int i = 0; i< nameRanks.length; i++) //first use for loop to get max value
		{
			if(nameRanks[i] > min)
			{
				min = nameRanks[i];
			}

		}
		//then use array maximum to get minimum nonzero value
		for (int i = 0; i< nameRanks.length; i++)
			{
				if(nameRanks[i] > 0 && nameRanks[i] < min)
				{
					min = nameRanks[i];
					indexOfMin = i;					
				}
			}
		
		this.bestYear = yearVals[indexOfMin]; //using this index, return the best year
		
		return this.bestYear;
	}
	public void Draw(int nameRanks[]) {

		Random rand = new Random(); //instance of random class
      	int upperbound = 11;
		int int_random = rand.nextInt(upperbound);
 

		StdDraw.setXscale(1900, 2010);//sets year range as x-axis
		StdDraw.setYscale(1100, 0); //sets graph so that more popular name ranks will display higher
		StdDraw.setPenRadius(.025);
		Color[] drawColors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
			Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW}; //make array of colors
		Color drawColor = drawColors[int_random]; //select random color by selecting random array element
		StdDraw.setPenColor(drawColor);
		for(int i = 0; i < 11; i++) //plot points
		{
			if(nameRanks[i] == 0)
			{
				StdDraw.point(yearVals[i], 1100); //put at bottom of chart if name rank is 0 (meaning not in top 1100)
			}
			else
			{
				StdDraw.point(yearVals[i], nameRanks[i]);
			}
			
		}

		

	}
	public void clearPlot()
	{
		StdDraw.setXscale(1900, 2010);//sets year range as x-axis
		StdDraw.setYscale(1100, 0); //sets graph so that more popular name ranks will display higher
		StdDraw.setPenRadius(.025);
		StdDraw.point(2000, 1100);
		StdDraw.clear();
	}

}