package model;

import java.util.Comparator;

public class TurnComparatorByTime implements Comparator<Turn> {

	@Override
	public int compare(Turn turn1, Turn turn2) {
		if (turn1.getType().getDuration()<turn2.getType().getDuration()) {
			return -1;
		}
		else if (turn1.getType().getDuration()>turn2.getType().getDuration()) {
			return 1;
		}
		return 0;
	}

}
