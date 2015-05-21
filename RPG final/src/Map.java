import chn.util.*;

/**
 * @author Cody
 *
 */
public class Map
{
	public Map()
	{
		Room current;
		FileInput input = new FileInput("dungeon");
		Room[][] map = new Room[6][6];
		for (int a = 0; a < 6; a++)
		{
			for (int b = 0; b < 6; b++)
			{
				if (input.readToken() == "null")
				{
					map[a][b] = null;
				}
				else
				{
					map[a][b] = new Room(input.readLine(), input.readInt());
				}
			}
		}
		
		current = map[input.readInt()][input.readInt()];
		
		for (int a = 0; a < 6; a++)
		{
			for (int b = 0; b < 6; b++)
			{
				if (map[a][b] != null)
				{
					
				}
				
			}
		}
		
		
	}
}
