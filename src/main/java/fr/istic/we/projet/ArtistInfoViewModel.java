package fr.istic.we.projet;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import java.util.List;

public class ArtistInfoViewModel {

	private static final String artisteInfoMessage = "Un total de %d artistes";
	private final Filtre filtre = new Filtre();
	static List<ArtistesInfos> currentArtisteInfo = ListeArtistesInfos.getArtistesInfos() ;

	public Filtre getFiltre() {
		return filtre;
	}

	public  ListModel<ArtistesInfos> getArtisteInfosModel() {
		return new ListModelList<ArtistesInfos>(currentArtisteInfo);
	}

	public String getArtisteInfoMessage() {
		return String.format(artisteInfoMessage, currentArtisteInfo.size());
	}

	@Command
	@NotifyChange({"artisteInfosModel", "artisteInfoMessage"})
	public void changerFiltre() {
		currentArtisteInfo = ListeArtistesInfos.getFilterArtisteInfos(filtre);
	}

}
