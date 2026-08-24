import java.io.*; 
import java.util.ArrayList;

public class GradeAnalyzer {
 
    public static void main(String[] args) {
        
        // Step 1: read scores from file  
        String filename = "scores.txt";
        String outputFile = "report.txt";

        ArrayList<Integer> scoresList = readScores(filename);
        double averageScore = calculateAverage(scoresList);

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        
        // Grade Bands
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for(int i : scoresList){

            if(i > highest)
            {
                highest = i;
            }
            if(i < lowest)
            {
                lowest = i;
            }

           if(i >= 90)
           {
            countA++;
           }
           else if (i >= 80)
            {
            countB++;
           }
           else if (i >= 70)
           {
            countC++;
           }
           else if (i >= 60)
            {
            countD++;
           }
           else
            {
            countF++;
           }
        }
        // Step 3: write and print report
        writeReport(scoresList, averageScore, highest, lowest, outputFile);

        System.out.println("Grade Analysis");
        System.out.println("Total Scores Graded: " + scoresList.size());
        System.out.println("Invalid lines Skipped: " + scoresList);
        System.out.println("Average score: " + averageScore);
        System.out.println("Highest score: " + highest);
        System.out.println("Lowest score: " + lowest);
        System.out.println(" ");
        System.out.println("Grade Distribution: ");
        System.out.println("A (90-100): " + countA);
        System.out.println("B (80-89): " + countB);
        System.out.println("C (70-79): " + countC);
        System.out.println("D (60-69): " + countD);
        System.out.println("F (below 60): " + countF);
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename)
    {
        ArrayList<Integer> scoresList = new ArrayList<>();
        String line;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            while ((line = reader.readLine()) != null) 
            {
                String scores = line.trim();
                
                if(scores.isEmpty())
                {
                    continue;
                }

                try
                {
                int n = Integer.parseInt(scores);
                scoresList.add(n);
                }
                catch (NumberFormatException e)
                {
                System.out.println("Skip this line: " + e.getMessage());
                }
            }        
        } 
        catch (IOException e) 
        {
            System.out.println("Could not read file: " + e.getMessage());
        }
            
        return scoresList;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) 
    {
        if (scores.isEmpty())
        {
        return 0.0;
        }
        
        double total = 0.0;
        for(int i : scores)
        {
            total += (double) i;
        }
        return total/scores.size();
    } 
    
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile)
    {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile)))
        {   
            writer.write(String.format("Total scores processed: "+ scores.size()));
            writer.write(String.format("Invalid lines skipped"));  
            
            writer.write(String.format("Average score: %.2f%n", avg)); 
            writer.write(String.format("Highest score: %d%n", high));
            writer.write(String.format("Lowest score: %d%n", low)); 
             
        }
        catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
}
