package fr.istic.we.projet;

public class Filtre {
    
        private  String artiste="", salle="", even="" , annee = "";

        public   String getArtiste() {
            return artiste;
        }

        public  void setArtiste(String artiste) {
            artiste = artiste==null?"":artiste.trim();
        }

        public  String getSalle() {
            return salle;
        }

        public  void setSalle(String salle) {
            salle = salle==null?"":salle.trim();
        }

        public  String getEven() {
            return even;
        }

        public  void setEven(String even) {
            even = even==null?"":even.trim();
        }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
}
