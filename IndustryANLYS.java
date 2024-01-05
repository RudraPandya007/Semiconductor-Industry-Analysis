import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

//@author Rudra Pandya
//To reach out to me on LinkedIn : Rudra Pandya, Rutgers University '27.
//directions on how to compile: javac IndustryANLYS.java -> java IndustryANLYS

/*
 * Description about my project : Deriving from the ideas of my previous Stock Management and Analysis 
 * Project, this project focuses on analyzing the stock prices of world's top semiconductor 
 * companies from their respective datasets found on NASDAQ. It is entirely constructed in Java by 
 * implementing the principles of Object-Oriented Design and Object-Oriented programming.
 */

/*
 * Github note : please do not copy this project and claim it as your own work. If you liked some ideas of my project,
 * please cite or give credit to me. 
 */

/*
World's leading semiconductor companies (ticker names) are : AMAT, AMD, ASML, ASX, INTC, MU, NVDA, QCOM, TSM 
According to the website (down below) :
https://www.investopedia.com/articles/markets/012216/worlds-top-10-semiconductor-companies-tsmintc.asp
*/

/*
 * Note about the .csv files: 
 * Credits to Jiun Yen from Kaggle for providing me NASDAQ folder with their respective companies' .csv files
 * date, volume, opening price, closing price, highest price, lowest price, adjusted closing price is the format of the file
 */

//creating a StockData class to match with the format of the file
class StockData{

    //private variables with respect to the .csv dataset information
    private String date;            
    private int volume;
    private double opening_price;
    private double closing_price;
    private double highest_price;
    private double lowest_price;
    private double adjusted_closing_price;

    //constructor method for the respective information for each line in the .csv file. 
    public StockData(String date, int volume, double opening_price, double closing_price, double highest_price, double lowest_price, double adjusted_closing_price){
        this.date = date;
        this.volume = volume;
        this.opening_price = opening_price;
        this.closing_price = closing_price;
        this.highest_price = highest_price;
        this.lowest_price = lowest_price;
        this.adjusted_closing_price = adjusted_closing_price;
    }

    //getter methods to retrieve infomation

    //retrieve date
    public String getDate(){
        return this.date;
    }

    //retrive volume
    public int getVolume(){
        return this.volume;
    }

    //retrieve opening price
    public double getOpeningPrice(){
        return this.opening_price;
    }
    //retrieve closing in price
    public double getClosingInPrice(){
        return this.closing_price;
    }
    //retrueve highest price
    public double getHighestPrice(){
        return this.highest_price;
    }

    //retrieve lowest price
    public double getLowestPrice(){
        return this.lowest_price;
    }

    //retrieve adjusted closing in price
    public double getAdjustedClosingInPrice(){
        return this.adjusted_closing_price;
    }
}

public class IndustryANLYS{

    //private method to check if the date format is correct to validate function execution. 
    private static boolean isValidDateInput(String input) {
        // Check if the input matches the expected date format
        return input.matches("\\d{4}-\\d{2}-\\d{2}");
    }
    //functions for StockData

    //test case 1
    //function 1: retrieving data from specific date
    //returning date, volume, opening price, closing-in price, highest price, lowest price, adjusted closing-in price. 
    //using an enhanced for loop
    public static void SpecificDateInfo(ArrayList <StockData> stockdatalist, String date){
        for (StockData stockinfo : stockdatalist){
            if (stockinfo.getDate().equals(date)){
                StdOut.println();
                StdOut.println("Date: " + stockinfo.getDate());
                StdOut.println("Volume: " + stockinfo.getVolume());
                StdOut.println("Opening Price: " + stockinfo.getOpeningPrice());
                StdOut.println("Closing-in Price: " + stockinfo.getHighestPrice());
                StdOut.println("Highest Price: " + stockinfo.getLowestPrice());
                StdOut.println("Lowest Price: " + stockinfo.getClosingInPrice());
                StdOut.println("Adjusted Closing-in Price: " + stockinfo.getClosingInPrice());
            }
        }
        StdOut.println();
        StdOut.println("--------------------------------------------------------------------------------");
        StdOut.println();
    }
    
    //test case 2
    //function 2: retrieving volume from specific date
    //using an enchanced for loop
    public static void SpecificVolume(ArrayList <StockData> stockdatalist, String date){
        for (StockData stockinfo : stockdatalist){
            if (stockinfo.getDate().equals(date)){
                StdOut.println();
                StdOut.println("Volume on the date " + date + " is " + stockinfo.getVolume());
            }
        }
        StdOut.println();
        StdOut.println("--------------------------------------------------------------------------------");
        StdOut.println();
    }
    
    //test case 3
    //function 3: retrieving profit from specific date
    //using an enhanced for loop
    public static void SpecificMaxProfit(ArrayList <StockData> stockdatalist, String date){
        double maxProfit = 0;
        for (StockData stockinfo : stockdatalist){
            if (stockinfo.getDate().equals(date)){
                maxProfit = stockinfo.getHighestPrice() - stockinfo.getLowestPrice();
                StdOut.println("Max profit (buy low -> sell high) on the date " + date + " is " + maxProfit);
            }
        }
        StdOut.println();
        StdOut.println("--------------------------------------------------------------------------------");
        StdOut.println();
    }

    //test case 4
    //function 4: retrieving profit from opening and closing-in prices. 
    //using an enhanced for loop
    public static void SpecificOpenAndCloseProfit(ArrayList <StockData> stockdatalist, String date){
        double OpenAndCloseProfit = 0;
        for (StockData stockinfo : stockdatalist){
            if (stockinfo.getDate().equals(date)){
                OpenAndCloseProfit = stockinfo.getAdjustedClosingInPrice() - stockinfo.getOpeningPrice();
                StdOut.println("The profit(+)/loss(-) from adjusted closing-in price and opening price on the date " + date + " is " + OpenAndCloseProfit);
            }
        }
        StdOut.println();
        StdOut.println("--------------------------------------------------------------------------------");
        StdOut.println();
    }

    //test case 5
    //function 5: retrieving difference between adjusted closing-in price and closing-in price
    //using an enhanced for loop
    public static void ClosingInDifference(ArrayList <StockData> stockdatalist, String date){
        double difference = 0;
        for (StockData stockinfo : stockdatalist){
            if (stockinfo.getDate().equals(date)){
                difference = stockinfo.getAdjustedClosingInPrice() - stockinfo.getClosingInPrice();
                StdOut.println("The difference between adjusted closing-in price and closing-in price on the date " + date + " is " + difference);
            }
        }
        StdOut.println();
        StdOut.println("--------------------------------------------------------------------------------");
        StdOut.println();
    }

    //test case 6
    //function 6 : retrieving volume difference from two dates
    public static void VolumeDifference(ArrayList <StockData> stockdatalist, String date1, String date2){
        int volumeDifference = 0;
        int volume1 = 0;
        int volume2 = 0;
        for (StockData stockinfo : stockdatalist){
            if (stockinfo.getDate().equals(date1)){
                volume1 = stockinfo.getVolume();
            }
        }
        for (StockData stockinfo : stockdatalist){
            if (stockinfo.getDate().equals(date2)){
                volume2 = stockinfo.getVolume();
            }
        }
        volumeDifference = volume2 - volume1;
        StdOut.println("The volume difference between " + date1 + " and " + date2 + " is " + volumeDifference);
        StdOut.println();
        StdOut.println("--------------------------------------------------------------------------------");
        StdOut.println();
    }
    public static void VolumeCountAvg(ArrayList <StockData> stockdatalist){
        int volume_count = 0;
        int denominator = 0;
        for (StockData stockinfo : stockdatalist){
            volume_count += stockinfo.getVolume();
            denominator++;
        }
        double average = (volume_count / denominator);
        StdOut.println("The total volume is " + volume_count);
        StdOut.println("The average volume is " + average);
        StdOut.println();
        StdOut.println("--------------------------------------------------------------------------------");
        StdOut.println();
    }

    //test case 7
    //function 7 : retrieving all time max profit
    //not just max profit, but also the recorded date of its occurence for time-frame analysis. 
    //Creating maxProfit arraylist and a dates arraylist to traverse through the dates array list and find the matching date.
    public static void AllTimeMaxProfit(ArrayList <StockData> stockdatalist){
        double maxProfit = 0;
        ArrayList <Double> maxprofit = new ArrayList <Double> (stockdatalist.size());
        ArrayList <String> dates = new ArrayList <String> (stockdatalist.size());
        for (StockData stockinfo : stockdatalist){
            maxProfit = stockinfo.getHighestPrice() - stockinfo.getLowestPrice();
            maxprofit.add(maxProfit);
            dates.add(stockinfo.getDate());
        }
        double max = 0;
        int maxIndex = 0;
        for (int i = 0; i < maxprofit.size(); i++){
            if (maxprofit.get(i) > max){
                max = maxprofit.get(i);
                maxIndex = i;
            }
        }
        StdOut.println("All time max profit from 1980s to 2020 is " + max + " recorded on the date " + dates.get(maxIndex));
        StdOut.println();
        StdOut.println("--------------------------------------------------------------------------------");
        StdOut.println();
    }
    //test case 8
    //function 8 : retrieving max volume
    //Creating a dates arraylist to traverse through it and find the matching date based on the placement of where max volume is
    public static void MaxVolume(ArrayList <StockData> stockdatalist){
        int max = 0;
        int maxIndex = 0;
        ArrayList <String> dates = new ArrayList <String> (stockdatalist.size());
        for (int i = 0; i < stockdatalist.size(); i++){
            if (stockdatalist.get(i).getVolume() > max){
                max = stockdatalist.get(i).getVolume();
                maxIndex = i;
            }
        }
        for (StockData stockinfo : stockdatalist){
            dates.add(stockinfo.getDate());
        }
        StdOut.println("The largest volume is " + max + " recorded on " + dates.get(maxIndex));
        StdOut.println();
        StdOut.println("--------------------------------------------------------------------------------");
        StdOut.println();
    }

    //test case 9
    //function 9 : retrieving min volume
    //Same idea as above function, but instead for minimum volume
    public static void MinVolume(ArrayList <StockData> stockdatalist){
        int length = stockdatalist.size();
        int min = stockdatalist.get(length-1).getVolume();
        int minIndex = 0;
        ArrayList <String> dates = new ArrayList <String> (stockdatalist.size());
        for (int i = 0; i < stockdatalist.size(); i++){
            if (stockdatalist.get(i).getVolume() < min){
                min = stockdatalist.get(i).getVolume();
                minIndex = i;
            }
        }
        for (StockData stockinfo : stockdatalist){
            dates.add(stockinfo.getDate());
        }
        StdOut.println("The smallest volume is " + min + " recorded on " + dates.get(minIndex));
        StdOut.println();
        StdOut.println("--------------------------------------------------------------------------------");
        StdOut.println();
    }

    //test case 10
    //function 10 : retriving all time maximum adjusted difference
    //This is just the difference between adjusted closing-in price and closing-in price. When the market closes, prices do flunctuate. 
    //Creating a difference arraylist and dates arraylist to also print out the recorded date for maximum
    public static void AllTimeMaxAdjustedDifference(ArrayList <StockData> stockdatalist){
        int length = stockdatalist.size();
        ArrayList <Double> difference = new ArrayList <Double> (length);
        ArrayList <String> dates = new ArrayList <String> (length);
        for (int i = 0; i < length; i++){
            double diff = stockdatalist.get(i).getAdjustedClosingInPrice() - stockdatalist.get(i).getClosingInPrice();
            difference.add(diff);
            dates.add(stockdatalist.get(i).getDate());
        }
        double max = difference.get(length - 1);
        int maxIndex = 0;
        for (int i = 0; i < difference.size(); i++){
            if (difference.get(i) > max){
                max = difference.get(i);
                maxIndex = i;
            }
        }
        String date = dates.get(maxIndex);
        StdOut.println("The maximum adjusted closing-in difference is " + max + " recorded on " + date);
        StdOut.println();
        StdOut.println("--------------------------------------------------------------------------------");
        StdOut.println();
    }

    //test case 11
    //function 11 : retrieving all time minimum adjusted difference
    //Same concept as above, but here it is the minimum or no-difference between adjusted closing-in price and closing-in price.
    public static void AllTimeLowAdjustedDifference(ArrayList <StockData> stockdatalist){
        int length = stockdatalist.size();
        ArrayList <Double> difference = new ArrayList <Double> (length);
        ArrayList <String> dates = new ArrayList <String> (length);
        for (int i = 0; i < length; i++){
            double diff = stockdatalist.get(i).getAdjustedClosingInPrice() - stockdatalist.get(i).getClosingInPrice();
            difference.add(diff);
            dates.add(stockdatalist.get(i).getDate());
        }
        double min = difference.get(length - 1);
        int minIndex = 0;
        for (int i = 0; i < difference.size(); i++){
            if (difference.get(i) < min){
                min = difference.get(i);
                minIndex = i;
            }
        }
        String date = dates.get(minIndex);
        StdOut.println("The minimum adjusted closing-in difference is " + min + " recorded on " + date);
        StdOut.println();
        StdOut.println("--------------------------------------------------------------------------------");
        StdOut.println();
    }
    //function 12 : retrieving all time lowest and highest price
    /*More importantly, also returning the date of the highest recorded or lowest recorded price. This is helpful for analyzing how stocks
    behave at certain times based on in-real-life events */
    public static void AllTimeMaxMinPrice(ArrayList <StockData> stockdatalist){
        double max = 0; String maxDate = ""; 
        double min = stockdatalist.size()-1; String minDate = "";
        //find the highest price to ever exist and at what date
        for (StockData data : stockdatalist){
            if (data.getHighestPrice() > max){
                max = data.getHighestPrice();
                maxDate = data.getDate();
            }
        }
        //find the lowest price to ever exist and at what date
        for (StockData data : stockdatalist){
            if (data.getLowestPrice() < min){
                min = data.getLowestPrice();
                minDate = data.getDate();
            }
        }
        StdOut.println("The highest price is " + max + " recorded on " + maxDate);
        StdOut.println("The lowest price is " + min + " recorded on " + minDate);
        StdOut.println();
        StdOut.println("--------------------------------------------------------------------------------");
        StdOut.println();
    }

    //the main method to execute every test case and creating a user-friendly terminal based interface. 
public static void main(String[] args) {
    ArrayList<StockData> stockDataList = new ArrayList<>();
    StdOut.println("--------------------------------------------------------------------------------");
    StdOut.println();
    StdOut.println("Welcome to my superconductor industry analysis project!");
    StdOut.println();
    StdOut.println("Here are the tickers of major semiconductor industry companies: AMAT, AMD, ASML, ASX, AVGO, INTC, MU, NVDA, QCOM, TSM");
    StdOut.print("Write down the ticker from the list above you want to analyze: ");
    String filePath = StdIn.readString();
    String filePathFixer = filePath.toUpperCase() + ".csv";
    
    try {
        Scanner fileScanner = new Scanner(new File(filePathFixer));

        // Skip the header line in the CSV file
        fileScanner.nextLine();

        // Loop through each line in the CSV file
        while (fileScanner.hasNextLine()) {
            // Read the line and split it into an array of values
            String[] values = fileScanner.nextLine().split(",");

            // Create a StockData object and add it to the ArrayList
            StockData stockData = new StockData(
                    values[0],                      // date
                    Integer.parseInt(values[1]),    // volume
                    Double.parseDouble(values[2]),  // opening_price
                    Double.parseDouble(values[3]),  // closing_price
                    Double.parseDouble(values[4]),  // highest_price
                    Double.parseDouble(values[5]),  // lowest_price
                    Double.parseDouble(values[6])   // adjusted_closing_price
            );
            stockDataList.add(stockData);
        }

        // Close the file scanner
        fileScanner.close();
    } catch (FileNotFoundException e) {
        StdOut.println("File not found: " + e.getMessage());
        return; // Exit the program if file not found
    }
    // Create a Scanner object to read user input
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
        // Display the menu

        StdOut.println("Menu:");
        StdOut.println("1. Retrieve data from specific date");
        StdOut.println("2. Retrieve volume from specific date");
        StdOut.println("3. Retrieve profit from specific date");
        StdOut.println("4. Retrieve profit from opening and closing-in prices from specific date");
        StdOut.println("5. Retrieve difference from adjusted closing-in price and closing-in price from specific date");
        StdOut.println("6. Retrieving volume difference from two different dates");
        StdOut.println("7. Retrieving all-time maximum profit");
        StdOut.println("8. Retrieving all-time maximum volume");
        StdOut.println("9. Retrieving all-time minimum volume");
        StdOut.println("10. Retrieving all-time maximum adjusted closing-in difference");
        StdOut.println("11. Retrieving all-time minimum adjusted closing-in difference");
        StdOut.println("12. Retrieving all time maximum and minimum recorded price");
        StdOut.println("13. Quit");
        StdOut.print("Enter your choice: ");

        // Get user choice
        choice = Integer.parseInt(scanner.nextLine());

        // Process user choice
        switch (choice) {
            case 1:
            boolean validInput1 = false;
            while (!validInput1) {
                StdOut.print("Enter date in YEAR-MONTH-DAY (or type break to quit): ");
                String date1 = scanner.nextLine();

                if ("break".equalsIgnoreCase(date1)) {
                StdOut.println("Quitting the program as per user request.");
                return;
                }

            // Validate the date input
                if (isValidDateInput(date1)) {
                    validInput1 = true;
                    // Process the date
                    SpecificDateInfo(stockDataList, date1);
                } 
                else {
                    StdOut.println("Invalid input. Please enter a valid date.");
                }
            }
                break;
            case 2:
            boolean validInput2 = false;
            while (!validInput2) {
                StdOut.print("Enter date in YEAR-MONTH-DAY (or type break to quit): ");
                String date2 = scanner.nextLine();

            if ("break".equalsIgnoreCase(date2)) {
                StdOut.println("Quitting the program as per user request.");
                return;  // Exit the method if the user wants to quit
            }
            // Validate the date input
            if (isValidDateInput(date2)) {
                validInput2 = true;
                // Process the date
                SpecificVolume(stockDataList, date2);
            } 
            else {
            StdOut.println("Invalid input. Please enter a valid date.");
                }
            }
                break;
            case 3:
            boolean validInput3 = false;
            while (!validInput3) {
                StdOut.print("Enter date in YEAR-MONTH-DAY (or type break to quit): ");
                String date3 = scanner.nextLine();

            if ("break".equalsIgnoreCase(date3)) {
                StdOut.println("Quitting the program as per user request.");
                return;  // Exit the method if the user wants to quit
            }
            // Validate the date input
            if (isValidDateInput(date3)) {
                validInput3 = true;
                // Process the date
                SpecificMaxProfit(stockDataList, date3);
            } 
            else {
            StdOut.println("Invalid input. Please enter a valid date.");
                }
            }
                break;
            case 4:
            boolean validInput4 = false;
            while (!validInput4) {
                StdOut.print("Enter date in YEAR-MONTH-DAY (or type break to quit): ");
                String date4 = scanner.nextLine();

            if ("break".equalsIgnoreCase(date4)) {
                StdOut.println("Quitting the program as per user request.");
                return;  // Exit the method if the user wants to quit
            }
            // Validate the date input
            if (isValidDateInput(date4)) {
                validInput4 = true;
                // Process the date
                SpecificOpenAndCloseProfit(stockDataList, date4);;
            } 
            else {
            StdOut.println("Invalid input. Please enter a valid date.");
                }
            }
                break;
            case 5:
            boolean validInput5 = false;
            while (!validInput5) {
                StdOut.print("Enter date in YEAR-MONTH-DAY (or type break to quit): ");
                String date5 = scanner.nextLine();

            if ("break".equalsIgnoreCase(date5)) {
                StdOut.println("Quitting the program as per user request.");
                return;  // Exit the method if the user wants to quit
            }
            // Validate the date input
            if (isValidDateInput(date5)) {
                validInput5 = true;
                // Process the date
                ClosingInDifference(stockDataList, date5);
            } 
            else {
            StdOut.println("Invalid input. Please enter a valid date.");
                }
            }
            break;
            case 6:
            boolean validInput6 = false;
            String date6_1 = "";
            String date6_2 = "";

            while (!validInput6) {
                StdOut.print("Enter date #1: ");
                date6_1 = scanner.nextLine();

                StdOut.print("Enter date #2: ");
                date6_2 = scanner.nextLine();

            if ("break".equalsIgnoreCase(date6_1) || "break".equalsIgnoreCase(date6_2)) {
            StdOut.println("Quitting the program as per user request.");
            return;  // Exit the method if the user wants to quit
            }

            // Validate the dates input
            if (isValidDateInput(date6_1) && isValidDateInput(date6_2)) {
                validInput6 = true;
            } 
            else{
                StdOut.println("Invalid input. Please enter valid dates.");
                }
            }
                VolumeDifference(stockDataList, date6_1, date6_2);
                break;
            case 7:
                StdOut.println("Retrieving all-time maximum profit...");
                AllTimeMaxProfit(stockDataList);
                break;
            case 8:
                StdOut.println("Retrieving all-time maximum volume...");
                MaxVolume(stockDataList);
                break;
            case 9:
                StdOut.println("Retrieving all-time minimum volume...");
                MinVolume(stockDataList);
                break;
            case 10:
                StdOut.println("Retrieving all-time maximum adjusted closing-in price difference...");
                AllTimeMaxAdjustedDifference(stockDataList);
                break;
            case 11:
                StdOut.println("Retrieving all-time minimum adjusted closing-in price difference...");
                AllTimeLowAdjustedDifference(stockDataList);
                break;
            case 12:
                AllTimeMaxMinPrice(stockDataList);
                break;
            case 13: 
                StdOut.println("Quitting the program. Goodbye!");
                break;
            default:
                StdOut.println("Invalid choice. Please enter a number between 1 and 12.");
                continue;
        }
    } while (choice != 13);

    // Close the scanner
    scanner.close();
    }
}