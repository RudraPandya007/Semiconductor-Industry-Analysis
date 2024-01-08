#importing statements to conduct visual data analysis
import csv
import matplotlib.pyplot as plt
from datetime import datetime

'''
author: Rudra Pandya
LinkedIn: Rudra Pandya, Rutgers University '27

Objective of this file: Python is a programming language extensively applicable for data-driven projects. In this file, there are 
different functions which output or create a graphical visualization of different components of the semiconductor stocks over time 
such as prices vs time, profits vs time, and volumes vs time. Java is not well-known for data science so I decided to create a python file
to do some visual analysis, which in the real world, could be useful for stakeholders in a Data Science/Business Intelligence career. 

Credits: both .java files and .py files belong to me. Please do not copy and claim it as your own work. If you got some ideas, then cite me
or give credits to me. Thanks to Jiun Yen on Kaggle for providing me NASDAQ datasets of top semiconductor companies. 

I hope you like this part of my Semiconductor Industry Analysis Project :)

To compile: python DataAnalysis.py or you can just run the code.

IMPORTANT: please make sure you have anaconda version of base of Python. This way it will work on VSCODE. 
'''
#creating a stockdata class just like the one in the .java file
class StockData:
    #constructor to match with the contents of the file
    def __init__(self, date, volume, opening_price, closing_price, highest_price, lowest_price, adjusted_closing_price):
        self.date = date
        self.volume = volume
        self.opening_price = opening_price
        self.closing_price = closing_price
        self.highest_price = highest_price
        self.lowest_price = lowest_price
        self.adjusted_closing_price = adjusted_closing_price

    #getter methods
    #.getVolume to retrieve volume
    def getVolume(self):
        return self.volume

    #.getOpeningPrice to retrieve opening price
    def getOpeningPrice(self):
        return self.opening_price

    #.getClosingPrice to retrieve closing price
    def getClosingPrice(self):
        return self.closing_price

    #.getHighestPrice to retrieve highest price
    def getHighestPrice(self):
        return self.highest_price

    #.getLowestPrice to retrieve lowest price
    def getLowestPrice(self):
        return self.lowest_price
    
    #.getAdjustedClosingPrice to retrieve adjusted closing price
    def getAdjustedClosingPrice(self):
        return self.adjusted_closing_price

#volume chart. This creates a visualization to display volumes over time. 
def VolumeLineChart(stock_data_list):
    dates = []
    volumes = []
    for stockdata in stock_data_list:
        dates.append(datetime.strptime(stockdata.date, "%Y-%m-%d"))
        volumes.append(stockdata.getVolume())
    plt.plot(dates, volumes, marker='o', linestyle='-', color='r')
    plt.title('Stock Volume Over Time')
    plt.xlabel('Date')
    plt.ylabel('Volume')
    plt.xticks(rotation=45)
    plt.show()

#opening price chart. This creates a visualization to display opening prices over time. 
def OpeningPriceChart(stock_data_list):
    dates = []
    prices = []
    for stockdata in stock_data_list:
        dates.append(datetime.strptime(stockdata.date, "%Y-%m-%d"))
        prices.append(stockdata.getOpeningPrice())
    plt.plot(dates, prices, marker='o', linestyle='-', color='r')
    plt.title('Opening Price Over Time')
    plt.xlabel('Date')
    plt.ylabel('Price')
    plt.xticks(rotation=45)
    plt.show()

#adjusted closing chart. This creates a visualization to display adjusted closing prices over time. 
def AdjustedClosingPriceChart(stock_data_list):
    dates = []
    prices = []
    for stockdata in stock_data_list:
        dates.append(datetime.strptime(stockdata.date, "%Y-%m-%d"))
        prices.append(stockdata.getAdjustedClosingPrice())
    plt.plot(dates, prices, marker='o', linestyle='-', color='r')
    plt.title('Adjusted Closing-in Price Over Time')
    plt.xlabel('Date')
    plt.ylabel('Price')
    plt.xticks(rotation=45)
    plt.show()

#adjusted profit chart. This creates a visualization to display profits over time. 
def ProfitChart(stock_data_list):
    dates = []
    profits = []
    for stockdata in stock_data_list:
        profit = stockdata.getHighestPrice() - stockdata.getLowestPrice()
        dates.append(datetime.strptime(stockdata.date, "%Y-%m-%d"))
        profits.append(profit)
    plt.plot(dates, profits, marker='o', linestyle='-', color='r')
    plt.title('Stock Profits Over Time')
    plt.xlabel('Date')
    plt.ylabel('Price')
    plt.xticks(rotation=45)
    plt.show()

#main method to execute based on menu input. 
def main():
    # Load your stock data from CSV or any other source
    stock_data_list = []
    print("--------------------------------------------------------------------------------")
    print()
    print("Welcome to my superconductor industry analysis project!")
    print()
    print("Here are the tickers of major semiconductor industry companies: AMAT, AMD, ASML, ASX, AVGO, INTC, MU, NVDA, QCOM, TSM")
    ticker = input("Write down the ticker from the list above you want to analyze: ").upper() + ".csv"

    try:
        with open(ticker, 'r') as file:
            csv_reader = csv.reader(file)
            next(csv_reader)  # Skip the header line

            for values in csv_reader:
                stock_data = StockData(
                    values[0],                      # date
                    int(values[1]),                 # volume
                    float(values[2]),               # opening_price
                    float(values[3]),               # closing_price
                    float(values[4]),               # highest_price
                    float(values[5]),               # lowest_price
                    float(values[6])                # adjusted_closing_price
                )
                stock_data_list.append(stock_data)
    except FileNotFoundError as e:
        print(f"File not found: {e}")
        return

    # Display a menu to choose between the functions
    choice = 0
    while choice != 5:
        print("Menu:")
        print("1. Volume Line Chart: ")
        print("2. Opening Price Chart: ")
        print("3. Adjusted Closing Price Chart: ")
        print("4. Profit Chart: ")
        print("5. Quit")

        try:
            choice = int(input("Enter your choice (1-5): "))
        except ValueError:
            print("Invalid input. Please enter a number.")
            continue

        if choice == 1:
            VolumeLineChart(stock_data_list)
        elif choice == 2:
            OpeningPriceChart(stock_data_list)
        elif choice == 3:
            AdjustedClosingPriceChart(stock_data_list)
        elif choice == 4:
            ProfitChart(stock_data_list)
        elif choice == 5:
            print("Quitting the program. Goodbye!")
        else:
            print("Invalid choice. Please enter a number between 1 and 5.")

if __name__ == "__main__":
    main()