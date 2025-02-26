package fr.usmb.pub;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Pierre Le Fameux
 *
 */
public class Bar {
	public List<Boisson> boissonChaude;
    public List<Boisson> boissonFroide;
    public List<Boisson> boissonAlcoolisee;
    public List<Cocktail> cocktailSansAlcoole;
    public List<Cocktail> cocktailAvecAlcoole;
	

	/**
	 * 
	 */
	public Bar(){
		this.boissonChaude = new ArrayList<>();
		this.boissonFroide = new ArrayList<>();
		this.boissonAlcoolisee = new ArrayList<>();
		this.cocktailAvecAlcoole = new ArrayList<>();
		this.cocktailSansAlcoole = new ArrayList<>();
	}
	
	/**
	 * @param boisson
	 */
	public void add(Boisson boisson) {
        if (boisson.alcoolise) {
            this.boissonAlcoolisee.add(boisson);
        }
		  else {
            this.boissonFroide.add(boisson);  /*doesnt add the hot one */
        }
    }
	
	/**
	 * @param cocktail
	 */
	public void add(Cocktail cocktail){
		if(cocktail.alcoolFree()){
			this.cocktailSansAlcoole.add(cocktail);
		}else{
			this.cocktailAvecAlcoole.add(cocktail);
		}
	}
	
	
	/**
	 * @param coca
	 * @return
	 */
	public Object serv(Boisson boisson){
        Iterator<Boisson> itBoisson;

        itBoisson = this.boissonFroide.iterator();
    	while (itBoisson.hasNext()) {
			Boisson b = itBoisson.next();
			if (b.nom.equalsIgnoreCase(boisson.nom)) {
				itBoisson.remove();
				return b;
			}
    }

		itBoisson = this.boissonAlcoolisee.iterator();
		while (itBoisson.hasNext()) {
			Boisson b = itBoisson.next();
			if (b.nom.equalsIgnoreCase(boisson.nom)) {
				itBoisson.remove();
				return b;
			}
		}

        itBoisson = this.boissonChaude.iterator();
    	while (itBoisson.hasNext()) {
			Boisson b = itBoisson.next();
			if (b.nom.equalsIgnoreCase(boisson.nom)) {
				itBoisson.remove();
				return b;
			}
    	}

        Iterator<Cocktail> itCocktail;
		itCocktail = this.cocktailSansAlcoole.iterator();
    	while (itCocktail.hasNext()) {
        Cocktail c = itCocktail.next();
			if (c.nom.equalsIgnoreCase(boisson.nom)) {
				itCocktail.remove();
				return c;
			}
    	}


		itCocktail = this.cocktailAvecAlcoole.iterator();
		while (itCocktail.hasNext()) {
			Cocktail c = itCocktail.next();
			if (c.nom.equalsIgnoreCase(boisson.nom)) {
				itCocktail.remove();
				return c;
			}
		}

    return null;
}

@Override
public String toString(){
	StringBuilder retorno = new StringBuilder();
	String eol = System.getProperty("line.separator");

	retorno.append("Bar : ").append(eol);

	retorno.append("\t Sans alcool").append(eol);
	for (Boisson boisson : this.boissonFroide) {
		retorno.append("\t\t").append(boisson.toString()).append(eol);
	}

	retorno.append("\t Avec alcool").append(eol);
	for (Boisson boisson : this.boissonAlcoolisee) {
		retorno.append("\t\t").append(boisson.toString()).append(eol);
	}

	retorno.append("\t Cocktail sans alcool").append(eol);
	for (Cocktail cocktail : this.cocktailSansAlcoole) {
		retorno.append("\t\t").append(cocktail.toString()).append(eol);
	}

	retorno.append("\t Cocktail avec alcool").append(eol);
	for (Cocktail cocktail : this.cocktailAvecAlcoole) {
		retorno.append("\t\t").append(cocktail.toString()).append(eol);
	}

	retorno.append("\t Boisson chaude").append(eol);
	for (Boisson boisson : this.boissonChaude) {
		retorno.append("\t\t").append(boisson.toString()).append(eol);
	}

	return retorno.toString();
}


}