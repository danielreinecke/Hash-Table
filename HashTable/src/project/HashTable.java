package project;
/**
 * The Class HashTable.
 */
public class HashTable {

	/** The array size. */
	private int arraySize;
	
	/** The data base. */
	private LinkedList[] dataBase;
	
	/**
	 * Instantiates a new hash table.
	 *
	 * @param size the size
	 */
	public HashTable(int size)
	{
		arraySize = size;
		dataBase = new LinkedList[arraySize];
	}
	
	/**
	 * Displays the hash table
	 */
	public void display()
	{
		System.out.println("Node  Name                                Population Density");
		System.out.println("------------------------------------------------------------");
		for(int i = 0; i < dataBase.length; i++)
		{
			if(dataBase[i] != null)
			{
				System.out.printf("%-6s",i + ".");
				dataBase[i].displayList();
			}
			else if(dataBase[i] == null)
			{
				System.out.printf("%-6sEmpty\n",i + ".");
			}
		}
	}
	
	/**
	 * Inserts a country into the hash table
	 *
	 * @param country the country
	 * @param population the population
	 * @param area the area
	 */
	public void insert(String country, long population, long area)
	{
		int hashValue = hashFunc(country);
		if(dataBase[hashValue] == null)
		{
			dataBase[hashValue] = new LinkedList();
		}
		dataBase[hashValue].insert(country, population, area);
	}
	
	/**
	 * Finds a country in the hash table
	 *
	 * @param country the country
	 * @return the int
	 */
	public int find(String country)
	{
		int hashValue = hashFunc(country);
		if(dataBase[hashValue] == null)
		{
			System.out.println("country was not found\n");
			return -1;
		}
		Node node = dataBase[hashValue].find(country);
		if(node == null)
		{
			System.out.println("country was not found\n");
			return -1;
		}
		System.out.printf("%s is found at index %d with population density of %.4f\n\n",country,hashValue,node.popDens);
		return (int) node.popDens;
	}
	
	/**
	 * Deletes a country in the hash table
	 *
	 * @param country the country
	 */
	public void delete(String country)
	{
		int hashValue = hashFunc(country);
		if(dataBase[hashValue] == null)
		{
			System.out.println("\ncountry was not found\n");
		}
		else
		{
			Node node = dataBase[hashValue].remove(country);
			if(dataBase[hashValue].isEmpty())
			{
				dataBase[hashValue] = null;
			}
			
			if(node == null)
			{
				System.out.println("\ncountry was not found\n");
			}
			else
			{
				System.out.println("\n" + country + " was deleted from the table\n");
		
			} 
		}				
	}
	
	/**
	 * Find the hash value for the hash table
	 *
	 * @param country the country
	 * @return the int
	 */
	public int hashFunc(String country)
	{
		int hash = 0;
		for(int i = 0; i < country.length(); i++)
		{
			hash += country.charAt(i);
		}
		hash%= 257;
		return hash;
	}
	
	/**
	 * Prints the empty and collided cells.
	 */
	public void printEmptyAndCollidedCells()
	{
		int empty = 0;
		int collided = 0;
		for(int i = 0; i < dataBase.length; i++)
		{
			if(dataBase[i] == null)
			{
				empty++;
			}
			else if(dataBase[i].colliedCell())
			{
				collided++;
			}
		}
		
		System.out.printf("\nThere are %d empty cells and %d collisions in the hash table\n\n",empty,collided);
	}
	
}
