package project;
/**
 * The Class Node.
 */
public class Node
{
	
	/** The name. */
	String name;
	
	/** The population. */
	long population;
	
	/** The area. */
	long area;
	
	/** The next. */
	Node next;
	
	/** The pop dens. */
	double popDens;
	
	/**
	 * Instantiates a new node.
	 *
	 * @param name the name
	 * @param population the population
	 * @param area the area
	 */
	public Node(String name, long population, long area)
	{
		this.name = name;
		this.population = population;
		this.area = area;
		this.popDens = (double) population / area;
	}
	
	/**
	 * Prints the node
	 */
	public void printNode()
	{
		System.out.printf("%-35s %.4f\n",name,popDens);
	}
}

