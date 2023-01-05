/* You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server... Two servers are said to communicate if they are on the same row or on the same column... Return the number of servers that communicate with any other server... 
 * Eg 1: Grid = [[1, 0], [0, 1]]                                             Output = 0
 * Eg 2: Grid = [[1, 0], [1, 1]]                                             Output = 3
 * Eg 3: Grid = [[1, 1, 0, 0], [0, 0, 1, 0], [0, 0, 1, 0], [0, 0, 0, 1]]     Output = 4
*/
import java.util.*;
public class Severs
{
    public int ConnectedSewers(int grid[][], int m, int n)
    {
        Stack<Integer> stack1 = new Stack<Integer>();    // Using Depth First Search in the Grid...
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                    stack1.push(i+j);    // Adding the coordinates...
                }
        }
        int connected = 0, adjacency = 0;
        while(!stack1.isEmpty())    // While Stack is not empty...
        {
            int element = stack1.pop();
            if(!stack1.isEmpty())         // If the stack does not empties itself after popping...
            {
                if(element - stack1.peek() == 1)    // If the two points are adjacent...
                {
                    while(element - stack1.peek() == 1)
                    {   // While the sewers are adjacent...
                        element = stack1.pop();
                        adjacency++;    // It checks the adjacency of the current sewer...
                        if(stack1.isEmpty())
                            break;
                    }
                    connected++;    // Since the difference was already one, we increment it...
                    connected = connected + adjacency;    // Add the adjacency...
                    adjacency = 0;    // Reduce the adjacency to zero, to initialize for next sewer...
                }
            }
        }
        return connected;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m, n, s, x, y;
        System.out.print("Enter the length of the grid (m) : ");
        m = sc.nextInt();
        System.out.print("Enter the breadth of the grid (n) : ");
        n = sc.nextInt();
        int grid[][] = new int[m][n];
        System.out.print("Enter the number of sewers in the Grid : ");
        s = sc.nextInt();
        System.out.println("NOTE : The leftward coordinate is given by x and downward coordinate is given by y. The Origin is given by (0, 0).");
        for(int i = 0; i < s; i++)
        {
            System.out.print("Enter the x coordinate of "+(i+1)+" th sewer : ");
            x = sc.nextInt();
            System.out.print("Enter the y coordinate of "+(i+1)+" th sewer : ");
            y = sc.nextInt();
            for(int j = 0; j < m; j++)
            {
                for(int k = 0; k < n; k++)
                {
                    if(j == x && k == y)
                        grid[j][k] = 1;
                }
            }
        }
        System.out.println("The Sewer Grid formed !!");
        for(int i = 0; i < m; i++)
        {
            System.out.print("[");
            for(int j = 0; j < n; j++)
                System.out.print(grid[i][j]+",");
            System.out.println("]");
        }
        Severs sever = new Severs();     // Object creation...
        System.out.println("The Number of Sewers connected : "+sever.ConnectedSewers(grid, m, n));
        sc.close();
    }
}

// Time Complexity  - O(n^2) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS :- 
 * 1. The sewers are adjacent only when the difference in their distance is one...
 * 2. A specific sewer can be adjacent to maximum four sewers...
 * 3. Traversal of the grid should be done once and we can use DFS and Stack to check for the adjacency criterion...
*/