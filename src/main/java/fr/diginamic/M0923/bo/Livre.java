package fr.diginamic.M0923.bo;


import jakarta.persistence.*;

@Entity
@Table (name = "LIVRE")
public class Livre {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    @Column(name ="TITRE")
    private String titre;
    @Column (name ="AUTEUR")
    private String auteur;

    public Livre() {
    }

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public Livre(String titre) {
        this.titre = titre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        return "Livre :" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' ;
    }
}
