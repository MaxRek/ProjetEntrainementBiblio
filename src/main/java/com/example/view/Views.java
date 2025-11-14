package com.example.view;

public class Views {

<<<<<<< Updated upstream
	public class Common{}

	public class Auteur extends Common{}
=======
	public class Common {} //Toutes les types primitifs + String 
	
	public class Livre extends Common {} //Tous les objets toOne de la classe Livre + de Common
	
	public class Auteur extends Common {} //Tous les objets toOne de la classe Auteur + de Common
	
	public class AuteurWithLivre extends Livre{} // Tout le contenu de la view Auteur + la liste des livres

	public class Editeur extends Common{} //Tous les objets toOne de la classe Editeur + de Common
	
	public class EditeurWithLivre extends Livre{} // Tout le contenu de la view Editeur + la liste des livres

	public class Collection extends Common{} //Tous les objets toOne de la classe Collection + de Common
	
	public class CollectionWithLivre extends Livre{}  // Tout le contenu de la view Collection + la liste des livres
	
>>>>>>> Stashed changes
}
