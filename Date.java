/* @Jeffrey Zhou
 * Jzhou46
 * CS 342
 * Prof. Buy
 * 1/20/15
 * Homework 1
 * Date Class
 */

package edu.uic.Jzhou46.cs342;

public class Date {
	
	private int day;
	private int month;
	private int year;
	private int[] daysInMonth;//An integer array with the length of the months of the year in days
	private static String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	public Date(int month, int day, int year){//Constructor with arguments
		System.out.println("The initial date entered: " + month + "/" + day + "/" + year);
		if(year < 1582){//If year value is not in range of the Gregorian calender
			dateDefault();
			System.out.println("ERROR: Year value is out of the Gregorian calender range");
			System.out.println("ERROR: Combination is invalid. Date defaulted to 1/1/2001");
			daysInMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
			printDaysInMonth();
			return;
		}
		boolean leap = isLeapYear(year); 
		if(leap == false){
			daysInMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
		}
		else{
			daysInMonth = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 	
		}
	
		if(month == 2){//If February
			if(leap == false){//If common year
				if(day > 28 || day < 1){//If not a leap year, the max number of days can't exceed 28
					System.out.println("ERROR: Combination is invalid. Date defaulted to 1/1/2001");
					dateDefault();
					printDaysInMonth();
					return;
				}
				printDaysInMonth();
			}
			else{//If leap year
				if(day > 29 || day < 1){//Else if it is a leap year, the max number of days can't exceed 29
					System.out.println("ERROR: Combination is invalid. Date defaulted to 1/1/2001");
					dateDefault();
					printDaysInMonth();
					return;
				}
				printDaysInMonth();
			}
		}
		if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
			if(day > 31 || day < 1){//These months can't exceed the max number of days of 31
				System.out.println("ERROR: Combination is invalid. Date defaulted to 1/1/2001");
				dateDefault();
				printDaysInMonth();
				return;
			}
			printDaysInMonth();
		}
		if(month == 4 || month == 6 || month == 9 || month == 11){
			if(day > 30 || day < 1){//These months can't exceed the max number of days of 30
				System.out.println("ERROR: Combination is invalid. Date defaulted to 1/1/2001");
				dateDefault();
				printDaysInMonth();
				return;
			}
			printDaysInMonth();
		}
		if(month > 12 || month < 1){//Not in range
			System.out.println("ERROR: Combination is invalid. Date defaulted to 1/1/2001");
			dateDefault();
			printDaysInMonth();
			return;
		}
		this.month = month;
		this.day = day;
		this.year = year;
	}
	public void printDaysInMonth(){//Method to print out the days in each month
		System.out.print("DAYS IN MONTH: " );
		for(int x : this.daysInMonth){
			System.out.print(x + " ");
		}
		System.out.print("\n");
		int sum = 0;
		for(int i = 0; i < daysInMonth.length; i++){
			sum = sum + daysInMonth[i];
		}
		System.out.println("NUMBER OF DAYS IN THIS YEAR: " + sum);
	}
	public void dateDefault(){//Method to set a default date if the combination is invalid
		this.month = 1;
		this.day = 1;
		this.year = 2001;
		return;
	}
	public int day(){//day getter
		return day;
	}
	public int month(){//month getter
		return month;
	}
	public int year(){//year getter
		return year;
	}
	public void day(int newElem){//day setter
		day = newElem;
	}
	public void month(int newElem){//month setter
		month = newElem;
	}
	public void year(int newElem){//year setter
		year = newElem;
	}
	public static boolean isLeapYear(int year){//Method to check if the year is a leap year
		if(year % 4 == 0 && year % 100 != 0){//If divisible by 4 and not by 100
			System.out.println("NOTE: Year value entered is a leap year");
			return true;
		}
		else if(year % 100 == 0 && year % 400 == 0){//If divisible by 100 and not by 400
			System.out.println("NOTE: Year value entered is a leap year");
			return true;
		}
		System.out.println("NOTE: Year value entered is a common year");
		return false;
	}	
	public String prettyPrint(){//Method to return the full month name
		String month = monthNames[this.month - 1];
		String date = month + " " + this.day + ", " + this.year;
		return date;
	}
	public static void main(String[] args){
		//Case 1
		System.out.println("\n/---CASE 1---/");
		Date case1 = new Date(1,1,2001);
		String date1 = case1.prettyPrint();
		System.out.println("PRETTY PRINT: " + date1);
		
		//Case 2
		System.out.println("\n/---CASE 2---/");
		Date case2 = new Date(2,31,1998);
		String date2 = case2.prettyPrint();
		System.out.println("PRETTY PRINT: " + date2);
		
		//Case 3
		System.out.println("\n/---CASE 3---/");
		Date case3 = new Date(2,29,2016);
		String date3 = case3.prettyPrint();
		System.out.println("PRETTY PRINT: " + date3);
		
		//Case 4
		System.out.println("\n/---CASE 4---/");
		Date case4 = new Date(8,15,1945);
		String date4 = case4.prettyPrint();
		System.out.println("PRETTY PRINT: " + date4);
		
		//Case 5
		System.out.println("\n/---CASE 5---/");
		Date case5 = new Date(12,31,1999);
		String date5 = case5.prettyPrint();
		System.out.println("PRETTY PRINT: " + date5);
		
	}//End of main
}//End of class
