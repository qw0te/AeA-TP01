package algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import adn.Motif;

/**
 * Entree d'un algorithme de recherche de motif.
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class Entree {
	
	///////////////
	// ATTRIBUTS //
	///////////////

	/**
	 * Nom de la sequence d'ADN de l'entree
	 */
	private String name;
	
	/**
	 * Sequence de nucleotides representant un brin d'ADN dans lequel rechercher un motif
	 */
	private String sequence;
	
	/**
	 * Motif a rechercher dans la sequence de nucleotides
	 */
	private Motif motif;
	
	//////////////
	// METHODES //
	//////////////
	
	/**
	 * Constructeur
	 * 
	 * @param name
	 * 			nom de la sequence d'ADN de l'entree 
	 * @param sequence
	 * 			sequence de l'entree dans laquelle chercher le motif
	 * @param motif
	 * 			motif a chercher dans le sequence de l'entree
	 */
	public Entree(String name, String sequence, Motif motif) {
		this.name = name;
		this.sequence = sequence;
		this.motif = motif;
	}
	
	/**
	 * Constructeur
	 * 
     * Récupère depuis un fichier fasta le nom de la sequence et la sequence ADN
     * 
     * @param chemin
     * @throws IOException
     */
    public Entree(String path) throws IOException {

        // br sert à lire le fichier ligne par ligne
        BufferedReader br = new BufferedReader(new  FileReader(path));

        String ligne;

        // on cherche la ligne correspondant au nom de la sequance
        while((ligne = br.readLine()) != null)
            if( ! ligne.startsWith(">"))
                continue;
            else {
                this.name = ligne;
                break;
            }
        //si on a pas trouve le nom, alors le fichier n'est pas valide
        if(ligne == null) {
            br.close();
            throw new IOException("Le fichier fasta ne possède pas le bon format");
        }

        this.sequence = "";
        // on recupere la sequence adn
        while((ligne = br.readLine()) != null) {
            this.sequence += ligne;
        }
        
        // Le motif est positionner a null le temps d'etre reference
        this.motif = null;
        br.close();
    }
    
	/**
	 * Donne le nom de la sequence d'ADN de l'entree
	 * 
	 * @return nom de la sequence d'ADN de l'entree
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Donne la sequence de l'entree
	 * 
	 * @return sequence de l'entree
	 */
	public String getSequence() {
		return this.sequence;
	}
	
	/**
	 * Donne le motif de l'entree
	 * 
	 * @return motif de l'entree
	 */
	public Motif getMotif() {
		return this.motif;
	}
	
	/**
	 * Affiche l'entree
	 */
	public void display() {
        System.out.println("Nom de la séquence : " +
                this.name                          +
                "\n"                               +
                this.sequence                      +
                "\n"                               +
                "Motif a rechercher : "            +
                motif.toString()
                );
    }

}
