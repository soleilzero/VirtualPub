package fr.usmb.pub;


/**
 * @author Pierre Le Fameux
 *
 */
public class Boisson {
	public String nom;
	public Boolean alcoolise;
	public Float degre;
	public Float volume; // volume de la bouteille, cennette, fut ...
	public Float prix;
	//public Boolean chaude;

	
	/**
	 * @param nom
	 * 
	 */
	public Boisson(String nom){
		this.nom = nom;
		this.alcoolise = Boolean.FALSE;
		
	}
	
	/**
	 * @param nom
	 * @param degre
	 */
	public Boisson(String nom, Float degre){
		this.nom = nom;
		this.degre = degre;
		this.alcoolise = Boolean.TRUE;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String retour = this.nom;
		if(this.alcoolise){
			return retour + " (l'abus d'alcool est dangereux pour la sante)";
		}else{
			return retour;
		}
	}
}
