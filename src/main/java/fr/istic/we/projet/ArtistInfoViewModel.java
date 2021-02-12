package fr.istic.we.projet;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class ArtistInfoViewModel {

	private int count;

	@Init
	public void init() {
		count = 10;
	}

	@Command
	@NotifyChange("count")
	public void cmd() {
		++count;
	}

	public int getCount() {
		return count;
	}
}
