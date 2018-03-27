package com.gestionEtudiant.java;

import java.util.Scanner;

public class Test {
	public static final int CHOIX_AJOUTER_ETUDIANT=1;
	public static final int CHOIX_SUPPRIMER_ETUDIANT=2;
	public static final int CHOIX_MODIFIER_ETUDIANT=3;
	public static final int CHOIX_AFFICHER_ETUDIANT=4;
	public static final int CHOIX_MOYENNE_GLOBAL=5;
	public static final int CHOIX_QUITTER=6;
	
	public static final int CHOIX_ETUDIANT_CHANGER_INFO= 1;
	public static final int CHOIX_ETUDIANT_AJOUTER_NOTE = 2;
	public static final int CHOIX_ETUDIANT_SUPPRIMER_NOTE = 3;
	public static final int CHOIX_ETUDIANT_AFFICHER_MOYENNE = 4;
	public static final int CHOIX_ETUDIANT_QUITTER = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("********Gestion Promo********");
		Promotion promotion = Promotion.creePromotion(scanner);
		System.out.println(String.format("********Gestion de la Promotion %s de l'année %s********", promotion.getNom(), promotion.getAnnee()));
		int choixMenuPromotion = -1;
		while (choixMenuPromotion != CHOIX_QUITTER) {
			choixMenuPromotion = promotion.afficherMenu(scanner);
			switch (choixMenuPromotion) {
			case CHOIX_AJOUTER_ETUDIANT:
				promotion.ajouterEtudiant(scanner);
				break;

			case CHOIX_SUPPRIMER_ETUDIANT:
				promotion.supprimerEtudiant(scanner);
				break;

			case CHOIX_MODIFIER_ETUDIANT:
				promotion.modifierEtudiant(scanner);
				break;

			case CHOIX_AFFICHER_ETUDIANT:
				promotion.afficherEtudiant(scanner);
				break;


			case CHOIX_MOYENNE_GLOBAL:
				promotion.moyenneGlobal(scanner);
				break;


			case CHOIX_QUITTER:
				promotion.quitter(scanner);
				break;

			default:
				System.out.println("Choix invalide");
				break;
			}
		}
	}
}