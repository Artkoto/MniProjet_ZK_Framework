package fr.istic.we.projet;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;


import java.util.List;

public class ArtistInfoViewModel {

	private static final String artisteInfoMessage = "Un total de %d artistes";
	private  Filtre filtre ;
	static List<ArtistesInfos> currentArtisteInfo ;
	//variable pour l'affichage des détails
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
		filtre = new Filtre();
		currentArtisteInfo = ListeArtistesInfos.getArtistesInfos() ;
	}

	public static void setDetailArtiste(ArtististeDetailViewModel detailArtiste) {
		ArtistInfoViewModel.detailArtiste = detailArtiste;
	}

	public  ArtististeDetailViewModel getDetailArtiste() {
		return detailArtiste;
	}


	@Command
	@NotifyChange("*")
	public void goToDetail(@BindingParam("artiste") ArtistesInfos arttiste) {
		detailArtiste.setArtiste(arttiste);
		detailArtiste.getArtiste().recupImg();
		Executions.sendRedirect("artisteDetail.zul");
	}

	@Command
	@NotifyChange("*")
	public void goToSalles(@BindingParam("salle") Salle salle1) {
		detailArtiste.setSalle(salle1) ;
		Executions.sendRedirect("salle.zul");
	}
	@Command
	@NotifyChange("*")
	public void goToEvens(@BindingParam("even") Even even1) {
		detailArtiste.setEven(even1);
		Executions.sendRedirect("even.zul");
	}

	@Command
	@NotifyChange("*")
	public void changerFiltre() {
		currentArtisteInfo = ListeArtistesInfos.getFilterArtisteInfos(filtre);
	}

}
