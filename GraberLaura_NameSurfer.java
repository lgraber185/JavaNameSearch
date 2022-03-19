/** Laura Graber */

/** MSI-503 */

/** Final Project */

//***********************************************
// GraberLaura_NameSurfer
//
// Requests user input, reads name_data.txt,
// calls NameRecord to create NameRecord object,
// and displays results
//***********************************************
import java.util.Scanner; // program uses class Scanner to read inputs
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class GraberLaura_NameSurfer
{
public static void main(String[] args) throws Exception
	{	

      //read all name values into an array
      Boolean nameValue = false;
      Scanner nameDataList = new Scanner(new BufferedReader(new FileReader("name_data.txt")));
      int rows = 4428;
      int columns = 12;
      String[][] nameArray = new String[rows][columns];

         for (int i=0; i < nameArray.length; i++) 
         { 
            String line = nameDataList.nextLine();//.trim().split("|");
            String[] splitLine = line.split(",");
            for (int j=0; j < splitLine.length; j++) 
            { //line.length
               nameArray[i][j] = splitLine[j];
            }          
         } 
      int inputSelection = -1;
      while (nameValue == false || inputSelection != 5)
      {
         System.out.println("\n\n1: Find the best year for a name");
         System.out.println("2: Find the best rank for a name");
         System.out.println("3: Plot the popularity of a name");
         System.out.println("4: Clear the plot");
         System.out.println("5: Quit");
         Scanner input = new Scanner( System.in );
         inputSelection = input.nextInt();
         if(inputSelection >=1 && inputSelection <= 3)
         {
            System.out.println("Enter Name: ");
            Scanner input2 = new Scanner( System.in );
            String nameVal = input2.nextLine();
            nameValue = checkArrayForName(nameArray, nameVal);
            if(nameValue == false)
            {
               System.out.println("This name is not in the list. Please select another name.");
            }
            else
            {
               GraberLaura_NameRecord nameRcd = new GraberLaura_NameRecord();
               int[] nameRankVals = new int[11];
               
               int nameRcdIndex = checkArrayIndex(nameArray, nameVal);
               for(int k = 1; k< 12; k++) //start at the second item
               {
                  nameRankVals[k-1] = Integer.parseInt(nameArray[nameRcdIndex][k]); //makes a 1D array of values for just that name
               }

               if(inputSelection == 1)
               {
                  nameRcd.NameRecord(nameVal); //sets name value in object
                  int bestYearVal = nameRcd.bestYear(nameRankVals);
                  System.out.println("Best year for "+ nameVal + " is "+bestYearVal);

               }
               if(inputSelection == 2)
               {
                  nameRcd.NameRecord(nameVal); //sets name value in object
                  int bestYearVal = nameRcd.bestYear(nameRankVals);
                  int nameRank = nameRcd.getRank(bestYearVal, nameRankVals);
                  System.out.println("Best rank for "+ nameVal + " is "+nameRank);

               }
               if(inputSelection == 3)
               {
                  nameRcd.Draw(nameRankVals);      
               }

            }
         }
         if(inputSelection == 4)
         {
            StdDraw.clear();
         }
         

      }

      if(inputSelection == 5)
      {
         System.exit(200);
      }

    }

    public static Boolean checkArrayForName(String nameDataList[][], String Name)
    {
      Boolean test = false;
      for(int i = 0; i < 4428; i++){
             if(nameDataList[i][0].equals(Name))
             {
                test = true;
             }
     }

      return test;
    }

    public static Integer checkArrayIndex(String nameDataList[][], String Name)
    {
      int i = -1;//placeholder
      for(i = 0; i < 4428; i++){
             if(nameDataList[i][0].equals(Name))
             {
                return i;
             }
     }
     return i;
    }

}