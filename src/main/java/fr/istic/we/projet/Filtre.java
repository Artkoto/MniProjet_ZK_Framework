package fr.istic.we.projet;

public class Filtre {
    
        private  String artiste="", salle="", even="" , annee = "";

        public   String getArtiste() {
            return artiste;
        }

        public  void setArtiste(String artiste) {
            this.artiste = artiste==null?"":artiste.trim();
        }

        public  String getSalle() {
            return salle;
        }

        public  void setSalle(String salle) {
            this.salle = salle==null?"":salle.trim();
        }

        public  String getEven() {
            return even;
        }

        public  void setEven(String even) {
            this.even = even==null?"":even.trim();
        }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee =  annee==null?"" :annee.trim();
    }
}
