package fr.istic.we.projet;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.FileReader;
import org.zkoss.json.parser.JSONParser;
import org.zkoss.json.JSONObject;
import org.zkoss.json.JSONArray;

public class ListeArtistesInfos {

    private static final List<ArtistesInfos> artistesInfos =new ArrayList<>();
    private static final List<Salle> salles = new ArrayList<>();
    private static final List<Even> evens = new ArrayList<>();

    //import des données depuis JSON
    static  Path path = Paths.get("../webapps/miniProjetZK_war/WEB-INF/out.json");
    static JSONParser jsonParser = new JSONParser() ;
    static JSONArray jsonArray;

    static  {
        try {
            //JSON de la forme un tablea de plusieurs objet
           jsonArray = (JSONArray) jsonParser.parse(new FileReader(path.toString()));
            for (Object globalObjet : jsonArray) {
                //recupération du filds
                JSONObject fieldsObject = (JSONObject) ((JSONObject) globalObjet).get("fields");
                //recupération de chaque information importante de notre objet
                String artiste = (String) fieldsObject.get("artistes");
                String spotify = (String) fieldsObject.get("spotify");
                String deezer = (String) fieldsObject.get("deezer");
                String anne = (String) fieldsObject.get("annee");
                String pays = (String) fieldsObject.get("origine_pays1");
                String ville =  (String) fieldsObject.get("origine_ville1");
                String even = (String) fieldsObject.get("edition");
                String salle1 = (String) fieldsObject.get("1ere_salle");
                String salle2 = (String) fieldsObject.get("2eme_salle");
                String salle3 = (String) fieldsObject.get("3eme_salle");
                String salle4 = (String) fieldsObject.get("4eme_salle");
                String salle5 = (String) fieldsObject.get("5eme_salle");
                String salle6 = (String) fieldsObject.get("6eme_salle");
                String salle7 = (String) fieldsObject.get("7eme_salle");
                String salle8 = (String) fieldsObject.get("8eme_salle");
                //si l'artiste n'est pas dans la liste , on l'ajoute
                ArtistesInfos artistesInfos1 = new ArtistesInfos(artiste);
                if (!artistesInfos.contains( artistesInfos1)){
                    //on va traiter les informations différentes de null
                    artistesInfos.add(artistesInfos1);
                    artistesInfos1.setAnneeInfo(anne);
                    artistesInfos1.setPaysInfo(pays);
                    artistesInfos1.setDeezerInfo(deezer);
                    artistesInfos1.setVilleInfo(ville);
                    artistesInfos1.setSpotifyInfo(spotify);
                    //ajout des evenements
                    if (even != null){
                        Even even1 = contientEven(even);
                        if (even1 != null)
                        artistesInfos1.add(even1);
                        else{
                            even1 = new Even(even);
                            artistesInfos1.add(even1);
                            evens.add(even1);
                        }
                    }
                    //ajout des salles de spectacles de 1 à 8
                    if (salle1 != null){
                        Salle salle =contientSall(salle1);
                        if (salle != null)
                        artistesInfos1.add(salle);
                        else {
                            salle = new Salle(salle1);
                            artistesInfos1.add(salle);
                            salles.add(salle);
                        }
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                    }
                    //salle2
                    if (salle2 != null){
                        Salle salle =contientSall(salle2);
                        if (salle != null)
                            artistesInfos1.add(salle);
                        else {
                            salle = new Salle(salle2);
                            artistesInfos1.add(salle);
                            salles.add(salle);
                        }
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                    }
                    //sallez3
                    if (salle3 != null){
                        Salle salle =contientSall(salle3);
                        if (salle != null)
                            artistesInfos1.add(salle);
                        else {
                            salle = new Salle(salle3);
                            artistesInfos1.add(salle);
                            salles.add(salle);
                        }
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                    }
                    //salle4
                    if (salle4 != null){
                        Salle salle =contientSall(salle4);
                        if (salle != null)
                            artistesInfos1.add(salle);
                        else {
                            salle = new Salle(salle4);
                            artistesInfos1.add(salle);
                            salles.add(salle);
                        }
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                    }
                    //salle5
                    if (salle5 != null){
                        Salle salle =contientSall(salle5);
                        if (salle != null)
                            artistesInfos1.add(salle);
                        else {
                            salle = new Salle(salle5);
                            artistesInfos1.add(salle);
                            salles.add(salle);
                        }
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                    }
                    //salle6
                    if (salle6 != null){
                        Salle salle =contientSall(salle6);
                        if (salle != null)
                            artistesInfos1.add(salle);
                        else {
                            salle = new Salle(salle6);
                            artistesInfos1.add(salle);
                            salles.add(salle);
                        }
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                    }
                    //salle7
                    if (salle7 != null){
                        Salle salle =contientSall(salle7);
                        if (salle != null)
                            artistesInfos1.add(salle);
                        else {
                            salle = new Salle(salle7);
                            artistesInfos1.add(salle);
                            salles.add(salle);
                        }
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                    }
                    //salle8
                    if (salle8 != null){
                        Salle salle =contientSall(salle8);
                        if (salle != null)
                            artistesInfos1.add(salle);
                        else {
                            salle = new Salle(salle8);
                            artistesInfos1.add(salle);
                            salles.add(salle);
                        }
                        if (even != null) {
                            Even evenCurrent = artistesInfos1.contientEven(even);
                            if (evenCurrent != null) {
                                salle.add(evenCurrent);
                            }
                        }
                    }

                }
                //veriffication du comportement correcte des artistes
               /* String EvenParDefaut = "Aucun Evenement";
                System.out.println(artistesInfos1.getNameInfo()+" "
                        +artistesInfos1.getAnneeInfo()+" "
                +artistesInfos1.getPaysInfo()+" "
                +artistesInfos1.getDeezerInfo()+" "
                +artistesInfos1.getVilleInfo()+" "
                +((!artistesInfos1.getEvens().isEmpty())?artistesInfos1.getEvens().get(0).getName():EvenParDefaut));
*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //verification du comportement correcte des Salles
        /*for (Salle s : salles){
            System.out.println(s.getName()+"  " +s.getArtistes().get(0).getNameInfo()+  " "+s.getEvens().get(0).getName());
        }*/
        //verification du comportement correcte des evens
        /*for (Even e : evens){
            System.out.println(e.getName()+"  " +e.getArtistes().get(0).getNameInfo()+  " "+e.getSalles().get(0).getName());
        }*/

        /*for (ArtistesInfos a : artistesInfos){
            System.out.println(a.getNameInfo());
        }*/
    }


    public static List<ArtistesInfos> getArtistesInfos() {
        return artistesInfos;
    }

    public void add(ArtistesInfos artiste){
        artistesInfos.add(artiste);
    }

    //Ajout de filtres

    public static List<ArtistesInfos> getFilterArtisteInfos(Filtre filtre) {
        List<ArtistesInfos> someArtistes = new ArrayList<ArtistesInfos>();
       // ArtistesInfos artist = new ArtistesInfos();
        String artiste = filtre.getArtiste().toLowerCase();
        String pays = filtre.getPays().toLowerCase();
        String ville = filtre.getVille().toLowerCase();
        String date = filtre.getAnnee().toLowerCase();

        for (ArtistesInfos tmp : artistesInfos) {
            if ((tmp.getNameInfo()!=null && tmp.getNameInfo().toLowerCase().contains(artiste)) &&
                    ((tmp.getVilleInfo() != null && tmp.getVilleInfo().toLowerCase().contains(ville)) || ville.equals("") )&&
                   ((tmp.getPaysInfo()!=null && tmp.getPaysInfo().toLowerCase().contains(pays)) || pays.equals("")) &&
                    ((tmp.getAnneeInfo()!=null && tmp.getAnneeInfo().toLowerCase().contains(date))|| date.equals("")))
                    {
                someArtistes.add(tmp);
            }
        }
        return someArtistes;
    }

    public static List<ArtistesInfos> getArtistesInfosByName() {
        return artistesInfos;
    }

    public static ArtistesInfos contientArtist(String nom) {
        String nomMiniscule = nom.toLowerCase();
        for (ArtistesInfos a : artistesInfos){
            if(a.getNameInfo().toLowerCase().equalsIgnoreCase(nomMiniscule))
                return a;
        }
        return null;

    }

    /**
     *
     * @param salle
     * @return retourne la salle ou null
     */
    public static Salle contientSall(String salle) {
        String salleMiniscule = salle.toLowerCase();
        for (Salle s : salles){
            if(s.getName().toLowerCase().equals(salleMiniscule))
                return s;
        }
        return null;

    }

    /**
     *
     * @param even
     * @return retouren l'even sinon null
     */
    public static Even contientEven(String even) {
        String evenMiniscule = even.toLowerCase();
        for (Even e : evens){
            if(e.getName().toLowerCase().equals(evenMiniscule))
                return e;
        }
        return null;

    }

/*    public static void main(String[] args) {
        System.out.println(path);
        JSONObject object = (JSONObject) jsonArray.get(0);
        JSONObject ob2 = (JSONObject) object.get("fields");
        System.out.println(object);
        System.out.println( ob2.get("artistes") );
    }*/

}
