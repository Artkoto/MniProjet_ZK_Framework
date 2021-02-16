package fr.istic.we.projet;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import java.util.List;

public class ArtistInfoViewModel {

	private static final String artisteInfoMessage = "Un total de %d artistes";
	private final Filtre filtre = new Filtre();
	static List<ArtistesInfos> currentArtisteInfo = ListeArtistesInfos.getArtistesInfos() ;
	//variable pour l'affichage des détails
	private static String nomArtiste ="";
	private static ArtististeDetailViewModel detailArtiste =new ArtististeDetailViewModel() ;

	public Filtre getFiltre() {
		return filtre;
	}

	public  ListModel<ArtistesInfos> getArtisteInfosModel() {
		return new ListModelList<ArtistesInfos>(currentArtisteInfo);
	}

	public String getArtisteInfoMessage() {
		return String.format(artisteInfoMessage, currentArtisteInfo.size());
	}


	@Init
	public void init(){
		nomArtiste = "";
	}

	public static void setNomArtiste(String nomArtiste) {
		ArtistInfoViewModel.nomArtiste = nomArtiste;
	}

	public static void setDetailArtiste(ArtististeDetailViewModel detailArtiste) {
		ArtistInfoViewModel.detailArtiste = detailArtiste;
	}

	public static String getNomArtiste() {
		return nomArtiste;
	}

	public  ArtististeDetailViewModel getDetailArtiste() {
		return detailArtiste;
	}


	@Command
	@NotifyChange("*")
	public void goToDetail(@BindingParam("artiste") ArtistesInfos arttiste) {
		detailArtiste.setArtiste(arttiste);
		//detailArtiste.setArtiste(currentArtisteInfo.get(0));
	}

	@Command
	@NotifyChange("*")
	public void changerFiltre() {
		currentArtisteInfo = ListeArtistesInfos.getFilterArtisteInfos(filtre);
	}

}
