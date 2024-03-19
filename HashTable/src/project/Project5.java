package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
* COP 3530: Project 5 – Hash Tables
* <p>
* This program uses a Hash Table to store data about countries that are given in a file
* as well as all the user to find, add, and delete countries
* <p>
* It also allows the table to be printed with the collied cells being shown as well as all
* of the empty cells in the table. It is also able to print out the number of collied and
* empty cells inside of the table
* <p>
* The program will not fail on incorrect input and instead will tell you "invalid input" then
* prompt the user for new input.
* @author Daniel Reinecke
* @version 11/17/2023
*/
public class Project5 
{
	
	/** The table. */
	public static HashTable table = new HashTable(257);
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[])
	{
		System.out.println("COP3530 Project 5\nInstructor: Xudong Liu\n\nHash Tables\n");
		Scanner scnr = new Scanner(System.in);
		while(true)
		{
			try
			{
				createFile(scnr);
				break;
			} 
			catch (FileNotFoundException e)
			{
				System.out.println("File not found please try again");
			}
		}
		boolean choice = false;
		while(!choice)
		{
			choice = options(scnr);
		}
		scnr.close();
	}
	
	/**
	 * Creates the file and the Hash Table
	 *
	 * @param scnr the scnr
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void createFile(Scanner scnr) throws FileNotFoundException
	{
		System.out.print("Please input file name: ");
		String fileName = scnr.nextLine();
		
		File file = new File(fileName);
		Scanner in = new Scanner(file);
		in.useDelimiter("[,\n]");
		in.nextLine();
		while(in.hasNext())
		{
			String country = in.next();
			in.next();
			Long population = Long.parseLong(in.next());
			in.next();
			Long area = Long.parseLong(in.next());
			in.next();
			table.insert(country, population, area);
		}
		
		in.close();
	}
	
	/**
	 * Allows the user to pick through the different options
	 *
	 * @param scnr the scnr
	 * @return true, if successful
	 */
	public static boolean options(Scanner scnr)
	{
		System.out.println("1) Print hash table\r\n"
				+ "2) Delete a country of a given name\r\n"
				+ "3) Insert a country of its name, population, and area\r\n"
				+ "4) Search and print a country and its population density for a given name.\r\n"
				+ "5) Print numbers of empty cells and collided cells\r\n"
				+ "6) Exit");
		System.out.print("Enter your choice: ");
		try
		{
			int choice = scnr.nextInt();
			switch(choice)
			{
			case 1:
				table.display();
				return false;
			case 2:
				scnr.nextLine();
				System.out.print("Enter country name:");
				String country = scnr.nextLine();
				table.delete(country);
				return false;
			case 3:
				scnr.nextLine();
				System.out.print("Enter country name:");
				String count = scnr.nextLine();
				while(true)
				{
					try
					{
						System.out.print("Enter country's population:");
						Long population = scnr.nextLong();
						System.out.print("Enter country area:");
						Long area = scnr.nextLong();
						System.out.println("");
						table.insert(count,population,area);
						System.out.printf("%s is inserted to hash table\n\n",count);
						break;
					}
					catch(InputMismatchException e)
					{
						scnr.nextLine();
						System.out.println("Please enter  number");
					}
				}
				return false;
			case 4:
				scnr.nextLine();
				System.out.print("Enter country name:");
				String name = scnr.nextLine();
				System.out.println("");
				table.find(name);
				return false;
			case 5:
				table.printEmptyAndCollidedCells();
				return false;
			case 6:
				System.out.println("Have a great day!!");
				return true;
			default:
				System.out.println("Please enter  number 1 - 6");
				scnr.nextLine();
				return false;
			}
		}
		catch(InputMismatchException e)
		{
			scnr.nextLine();
			System.out.println("Please enter  number 1 - 6");
			return false;
		}
	}
}
