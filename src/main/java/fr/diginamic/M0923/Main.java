package fr.diginamic.M0923;

import fr.diginamic.M0923.bo.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println(emf);
/*//Create new livre
        Livre livreToCreate = new Livre("Recette", "Francis Navarre");
        em.persist(livreToCreate);*/

        //Modifcation d'un livre
        Livre livreAModifier = em.find(Livre.class, 5);
        if (null != livreAModifier) {
            livreAModifier.setTitre("Du plaisir dans la cuisine");
            Livre livreToFind = em.find(Livre.class,5);
            System.out.println("Changement :"+livreToFind);
        }
      //Récupération d'un livre par titre
        TypedQuery<Livre> livreFindTitre = (TypedQuery<Livre>) em.createQuery("SELECT h FROM Livre h WHERE h.titre='Germinal'", Livre.class);
        if(null!=livreFindTitre) {
            Livre resultTitre = livreFindTitre.getSingleResult();
            System.out.println(resultTitre);
        }

  //Récupération d'un livre par Auteur
        TypedQuery<Livre> livreFindAuthor =  em.createQuery("SELECT h FROM Livre h WHERE h.auteur='Francis Navarre'", Livre.class);
        if(null!=livreFindAuthor ) {
            Livre resultAthor = livreFindAuthor.getSingleResult();
            System.out.println(resultAthor);
        }


        //Affichage des livres avec titre et auteur
        TypedQuery<Livre> livreFind = (TypedQuery<Livre>) em.createQuery("SELECT h FROM Livre h ");
        if(null!=livreFind ) {

           List<Livre> resultLivre = livreFind.getResultList();

            for(int i = 0;i<resultLivre.size();i++){
                System.out.println(resultLivre.get(i));
            }
        }
        //Suppression

        Livre LivreRemoved = em.find(Livre.class, 3);
        if (null != LivreRemoved) {
            em.remove(LivreRemoved);
        }

        em.getTransaction().commit();

    }


}

