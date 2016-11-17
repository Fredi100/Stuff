
/**
 * Class for every NPC.
 * Contains movement methods and variables
 * 
 * 
 * @author Fredi100
 * @version 2016-10-22
 */
public class NPC {
	
	public enum MoveDirection {
		MOVE_NORTH, MOVE_SOUTH, MOVE_EAST, MOVE_WEST
	}

	private int x;
	private int y;
	private MoveDirection heading;
	private int npcID;
	
	public NPC(int npcID){
		this.x = 0;
		this.y = 0;
		this.heading = MoveDirection.MOVE_NORTH;
		this.npcID = npcID;
	}

	/**
	 * Tells the NPC to move in a certain way. If the direction, is not like the
	 * direction he is currently looking at the NPC will turn to that direction.
	 * If the NPC already looks in that direction, he will move one field that
	 * way.
	 * 
	 * @param direction
	 *            The direction the NPC has to move/rotate
	 */
	public void move(MoveDirection direction) {
		if (heading == direction) {
			if (isPlaceInfrontWalkable()) {
				walk(direction);
			}
		} else {
			heading = direction;
		}
	}

	/**
	 * Checks whether or not the NPC has a walkable field in front of him.
	 * 
	 * @return If the field in front is walkable
	 */
	private boolean isPlaceInfrontWalkable() {
		// TODO Abfrage, ob Feld vor mir frei;
		return true;
	}

	/**
	 * Tells the NPC to directly walk into the direction.
	 * 
	 * @param direction
	 *            The direction the NPC has to walk
	 */
	private void walk(MoveDirection direction) {
		switch (direction) {
		case MOVE_NORTH:
			++y;
			break;
		case MOVE_SOUTH:
			--y;
			break;
		case MOVE_EAST:
			++x;
			break;
		case MOVE_WEST:
			--x;
			break;
		default:
			System.err.println("Invalid direction to walk to!\n" + direction);
		}
	}
}
