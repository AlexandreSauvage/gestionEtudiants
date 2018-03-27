package com.gestionEtudiant.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Promotion {

	private String nom;
	private String annee;
	private static ArrayList<Etudiant> etudiants;
	public static float moyenne;
	
	public Promotion() {
		this("","");
	}

	public Promotion(String nom, String annee) {
		this.nom = nom;
		this.annee = annee;
		Promotion.etudiants = new ArrayList<>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public ArrayList<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(ArrayList<Etudiant> etudiants) {
		Promotion.etudiants = etudiants;
	}

	public static Etudiant getEtudiantById(int i) {
		for(Etudiant etudiant:etudiants) {
			if(etudiant.getId()==i) {
				return etudiant;
			}
		}
		return null;
	}

	
	public static Promotion creePromotion(Scanner scanner) {
		System.out.println("Merci de saisir le nom de la Promotion : ");
		String nom = scanner.nextLine();
		System.out.println("Merci de saisir l'année de la Promotion : ");
		String annee = scanner.nextLine();
		return  new Promotion(nom, annee);
	}

	public int afficherMenu(Scanner scanner) {
		System.out.println("*************Menu Principal*************");
		System.out.println(Test.CHOIX_AJOUTER_ETUDIANT + ". Ajouter Etudiant");
		System.out.println(Test.CHOIX_SUPPRIMER_ETUDIANT + ". Supprimer Etudiant");
		System.out.println(Test.CHOIX_MODIFIER_ETUDIANT+". Modifier Etudiant");
		System.out.println(Test.CHOIX_AFFICHER_ETUDIANT+". Afficher Etudiant");
		System.out.println(Test.CHOIX_MOYENNE_GLOBAL+". Moyenne global");
		System.out.println(Test.CHOIX_QUITTER+". Quitter");
		System.out.print(">");
		int choix = scanner.nextInt();
		scanner.nextLine();
		System.out.println("*****************************************");
		return choix;
	}

	public void ajouterEtudiant(Scanner scanner) {
		Etudiant etudiant = Etudiant.saisieEtudiant(scanner);
		Promotion.etudiants.add(etudiant);
	}
	
	public static int saisirId(Scanner scanner) {
		System.out.println("ID :");
		int id = scanner.nextInt();
		scanner.nextLine();
		return id;
	}

	public void supprimerEtudiant(Scanner scanner) {
		int id = saisirId(scanner);
		Etudiant etudiant2= Promotion.getEtudiantById(id);
		if(etudiant2 !=null) {
			Promotion.etudiants.remove(etudiant2);
			System.out.println("Etudiant supprimer !");
		}else{
			System.out.println("Etudiant pas trouver!");
		}
	}

	public void modifierEtudiant(Scanner scanner) {
		int id = saisirId(scanner);
		Etudiant etudiant= Promotion.getEtudiantById(id);
		int choixEtudiant = -1;
		while (choixEtudiant!= Test.CHOIX_ETUDIANT_QUITTER) {
			choixEtudiant = etudiant.afficherMenu(scanner);
			switch (choixEtudiant) {
			case Test.CHOIX_ETUDIANT_CHANGER_INFO:
				etudiant.changerInformation(scanner);
			}
		}
	}

	public void afficherEtudiant(Scanner scanner) {
		ArrayList<Etudiant> etudiants = this.getEtudiants();
		for(Etudiant etudiant1 : etudiants) {
			System.out.println(etudiant1.getNom());
		}
	}
			
	public float moyenneGlobal(Scanner scanner) {
		moyenne = 0;
		for (Etudiant etudiant : Promotion.etudiants) {
			moyenne += etudiant.getMoyenne();
		}
		moyenne = moyenne/etudiants.size();
		return moyenne;
	}
	
	public void quitter(Scanner scanner) {
		System.out.println("Vous avez quitté !");
		System.exit(Test.CHOIX_QUITTER);
	}
}