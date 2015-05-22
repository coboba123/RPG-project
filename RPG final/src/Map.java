import chn.util.*;

/**
 * @author Cody
 */
public class Map
{
	Room current;
	int vert, hori;
	String temp;

	Room[][] map = new Room[6][6];

	public Map(String fileName)
	{
		FileInput input = new FileInput(fileName);

		for (int a = 0; a < 6; a++)
		{
			for (int b = 0; b < 6; b++)
			{
				temp = input.readLine();
				System.out.println(temp);
				if (temp.equals("none"))
				{
					map[a][b] = null;
				} else
				{
					map[a][b] = new Room(temp);
				}
			}
		}
		vert = input.readInt();
		hori = input.readInt();
		current = map[vert][hori];

		for (int a = 0; a < 6; a++)
		{
			for (int b = 0; b < 6; b++)
			{
				if (map[a][b] != null)
				{
					try
					{
						if (map[a][b + 1] != null)
							map[a][b].setEast(map[a][b + 1]);
					} catch (IndexOutOfBoundsException e)
					{
					}
					try
					{
						if (map[a][b - 1] != null)
							map[a][b].setWest(map[a][b - 1]);
					} catch (IndexOutOfBoundsException e)
					{
					}
					try
					{
						if (map[a + 1][b] != null)
							map[a][b].setNorth(map[a - 1][b]);
					} catch (IndexOutOfBoundsException e)
					{
					}
					try
					{
						if (map[a - 1][b] != null)
							map[a][b].setSouth(map[a + 1][b]);
					} catch (IndexOutOfBoundsException e)
					{
					}

				}

			}

		}
	}

	public Room getCurrent()
	{
		return current;
	}
	
	public Room moveNorth()
	{
		current = map[vert-1][hori];
		return current;
	}
	public Room moveSouth()
	{
		current = map[vert+1][hori];
		return current;
	}
	public Room moveEast()
	{
		current = map[vert][hori + 1];
		return current;
	}
	public Room moveWest()
	{
		current = map[vert][hori - 1];
		return current;
	}
	
	
}
