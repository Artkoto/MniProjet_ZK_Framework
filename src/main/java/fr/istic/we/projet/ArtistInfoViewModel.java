package fr.istic.we.projet;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import java.util.List;

public class ArtistInfoViewModel {

	private static final String artisteInfoMessage = "A Total of %d ArtisteInfo Items";
	private Filtre filtre;
	List<ArtistesInfos> currentArtisteInfo ;

	public Filtre getFiltre() {
		return filtre;
	}

	public ListModel<ArtistesInfos> getArtisteInfoModel() {
		return new ListModelList<ArtistesInfos>(currentArtisteInfo);
	}

	public String getArtisteInfoMessage() {
		return String.format(artisteInfoMessage, currentArtisteInfo.size());
	}

	@Init
	public void init() {
		filtre = new Filtre();
		currentArtisteInfo = ListeArtistesInfos.getArtistesInfos();

	}

	@Command
	@NotifyChange({"artisteInfoModel", "artistInfo"})
	public void changeFilter() {
		currentArtisteInfo = ListeArtistesInfos.getFilterArtisteInfos(filtre);
	}

}
