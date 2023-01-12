import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class OperationsOnFinances {
    public static void main(String[] args) throws Exception {
        String fileName="/Users/israelwazir/Desktop/Side Projects/Finance/Finance/finance_money.csv";
        System.out.println("A summary for your finances: \n");
        readFromFile(fileName);
        getTotalAndAverage(fileName);


    }

        public static ArrayList readFromFile (String file) throws Exception {
            ArrayList<String> arraySpent= new ArrayList<>();
            ArrayList<String> arrayEarned= new ArrayList<>();
            ArrayList<String> arrayMonth= new ArrayList<>();


            String filePath =file;
            File files = new File(filePath);
            // System.out.println(file.exists());
            Scanner read = new Scanner(files);
            String line = "";


            while (read.hasNext()) {
                line = read.nextLine();
                String[] spent = line.split(",");
                String[] earned = line.split(",");
                String[] month= line.split(",");

                arraySpent.add(spent[2]);
                arrayEarned.add(earned[3]);
                arrayMonth.add(month[0]);



            }

            arraySpent.addAll(arrayEarned);

            return arraySpent;

        }



        public static int getTotalAndAverage( String file)throws Exception {
            ArrayList<String> array = readFromFile(file);
            int total = 0;
            int numberEarned = 0;
            int totalEarned = 0;
            int number = 0;


            for (int i = 1; i < array.size() && !(array.get(i).equals("Received")); i++) {
                number = Integer.parseInt(array.get(i));
                total += number;
            }
            System.out.println("Total money spent: "+ total);
            int size= (array.size()-2)/2; //subtracting 2 because we have two titles "received" and "spent", diving by two because we have two columns
            double average=total/size;
            System.out.println("Average money spent: "+ average);


            for (int i = 0; i < array.size() && !(array.get(i).equals("Spent")); i++) {
                numberEarned = Integer.parseInt(array.get(i));
                totalEarned += numberEarned;
            }
            average=totalEarned/size;
            System.out.println("Total money earned: " + totalEarned);
            System.out.println("Average money earned: "+ average);

            return total;
        }

}


