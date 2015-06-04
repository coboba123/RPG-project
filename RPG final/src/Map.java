import chn.util.*;

/**
 * @author Cody
 */
public class Map
{
	Room current, cannot;
	int vert, hori;
	String temp;

	Room[][] map = new Room[8][8];

	public Map(String fileName)
	{
		FileInput input = new FileInput(fileName);

		for (int a = 0; a < 8; a++)
		{
			for (int b = 0; b < 8; b++)
			{
				temp = input.readLine();
				System.out.println(temp);
				if (temp.equals("none"))
				{
					map[a][b] = null;
				} else
				{
					map[a][b] = new Room(temp);
					map[a][b].setRate(input.readInt());
				}
			}
		}
		vert = input.readInt();
		hori = input.readInt();
		current = map[vert][hori];

		for (int a = 0; a < 8; a++)
		{
			for (int b = 0; b < 8; b++)
			{
				if (map[a][b] != null)
					System.out.print(1);
				else
					System.out.print(0);
			}
			System.out.println();
		}
		cannot = new Room("You cant go that way", 0);
		map[2][5].setLocked(true);
		map[5][3].setShop(true);
		map[6][1].setHasKey(true);
		map[2][5].setHasBoss(true);

	}

	public void setMagicItems()
	{
		map[2][1].setItem(new Armor("Cloak of Ages", 5));
		map[2][1].setHasArmor(true);
		map[6][5].setItem(new Weapon("Rod of Ages", 5));
		map[6][5].setHasWeapon(true);
	}

	public void setNonMagicItems()
	{
		map[2][1].setItem(new Armor("Obsidian Armor", 5));
		map[2][1].setHasArmor(true);
		map[6][5].setItem(new Weapon("Sword of Glory", 5));
		map[6][5].setHasWeapon(true);
	}

	public Room getCurrent()
	{
		return current;
	}

	public Room moveNorth()
	{
		if (map[vert - 1][hori] != null)
		{
			if (map[vert - 1][hori].getLocked())
			{
				cannot = new Room(
						"You cant go that way. The door appears to be locked. Maybe there is a key somewhere around here."
								+ "\n" + "\n" + current.getDesc(), 0);
				return cannot;
			} else
			{
				vert--;
				current = map[vert][hori];
				return current;
			}
		} else
		{
			cannot = new Room("You cant go that way" + "\n" + "\n" + current.getDesc(), 0);
			return cannot;
		}

	}

	public Room moveSouth(Character myCharacter)
	{
		if (map[vert + 1][hori] != null)
		{
			if (map[vert + 1][hori].getLocked())
			{
				if (!(myCharacter.hasKey()))
				{
					cannot = new Room(
							"You cant go that way. The door appears to be locked. Maybe there is a key somewhere around here."
									+ "\n" + "\n" + current.getDesc(), 0);
					return cannot;
				} else
				{
					vert++;
					current = map[vert][hori];
					return current;
				}
			} else
			{
				vert++;
				current = map[vert][hori];
				return current;
			}
		} else
		{
			cannot = new Room("You cant go that way" + "\n" + "\n" + current.getDesc(), 0);
			return cannot;
		}
	}

	public Room moveEast(Character myCharacter)
	{
		if (map[vert][hori + 1] != null)
		{
			if (map[vert][hori + 1].getLocked())
			{
				if (!(myCharacter.hasKey()))
				{
					cannot = new Room(
							"You cant go that way. The door appears to be locked. Maybe there is a key somewhere around here."
									+ "\n" + "\n" + current.getDesc(), 0);
					return cannot;
				} else
				{
					hori++;
					current = map[vert][hori];
					return current;
				}
			} else
			{
				hori++;
				current = map[vert][hori];
				return current;
			}
		} else
		{
			cannot = new Room("You cant go that way" + "\n" + "\n" + current.getDesc(), 0);
			return cannot;
		}
	}

	public Room moveWest(Character myCharacter)
	{
		if (map[vert][hori - 1] != null)
		{
			if (map[vert][hori - 1].getLocked())
			{
				if (!(myCharacter.hasKey()))
				{
					cannot = new Room(
							"You cant go that way. The door appears to be locked. Maybe there is a key somewhere around here."
									+ "\n" + "\n" + current.getDesc(), 0);
					return cannot;
				} else
				{
					hori--;
					current = map[vert][hori];
					return current;
				}
			} else
			{
				hori--;
				current = map[vert][hori];
				return current;
			}
		} else
		{
			cannot = new Room("You cant go that way" + "\n" + "\n" + current.getDesc(), 0);
			return cannot;
		}
	}
}
