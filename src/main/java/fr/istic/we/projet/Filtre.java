package fr.istic.we.projet;

public class Filtre {

    //ajout de filtres pour la recherche
        private  String artiste="", pays="", ville="" , annee = "";

        public   String getArtiste() {
            return artiste;
        }

        public  void setArtiste(String artiste) {
            this.artiste = artiste==null?"":artiste.trim();
        }

        public  String getPays() {
            return pays;
        }

        public  void setPays(String salle) {
            this.pays = salle==null?"":salle.trim();
        }

        public  String getVille() {
            return ville;
        }

        public  void setVille(String even) {
            this.ville = even==null?"":even.trim();
        }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee =  annee==null?"" :annee.trim();
    }
}
