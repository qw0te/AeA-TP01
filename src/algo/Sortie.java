package algo;

import java.util.Set;
import java.util.TreeSet;

/**
 * Sortie d'un algorithme de recherche de motif.
 * 
 * @author Quentin Baert & Alexandre Verkyndt
 */
public class Sortie {
	
	///////////////
	// ATTRIBUTS //
	///////////////
	
	/**
	 * Entree a partir de laquelle a ete generee la sortie
	 */
	private Entree entree;
	
	/**
	 * Liste des position auxquelles le motif a ete trouve par l'algorithme
	 */
	private Set<Integer> positions;
	
	//////////////
	// METHODES //
	//////////////
	
	/**
	 * Constructeur
	 * 
	 * @param entree
	 * 			entree a laquelle est asssociee la sortie 
	 */
	public Sortie(Entree entree) {
		this.entree = entree;
		this.positions = new TreeSet<Integer>();
	}

	/**
	 * Donne les positions du motif dans la sequence
	 * 
	 * @return positions du motif dans la sequence
	 */
	public Set<Integer> getPositions() {
		return this.positions;
	}
	
	/**
	 * Ajoute une position a la liste des positions du motif
	 * 
	 * @param position
	 * 			position a ajouter a la liste des positions du motif
	 */
	public void addPosition(int position) {
		this.positions.add(position);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(this.entree + "\n");
		sb.append("Position du motif : \n");
        
        for (Integer position : this.positions) {
        	sb.append(position + "\n");
        }
        
        return sb.toString();
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entree == null) ? 0 : entree.hashCode());
		result = prime * result
				+ ((positions == null) ? 0 : positions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sortie other = (Sortie) obj;
		if (entree == null) {
			if (other.entree != null)
				return false;
		} else if (!entree.equals(other.entree))
			return false;
		if (positions == null) {
			if (other.positions != null)
				return false;
		} else if (!positions.equals(other.positions))
			return false;
		return true;
	}

}
