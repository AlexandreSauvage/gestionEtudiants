package com.gestionEtudiant.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Etudiant {
	
	private int id;
	
	private String nom;
	
	private String prenom;
	
	private int age;
	
	private char sexe;
	
	private ArrayList<Float> note;
	
	private float moyenne;
	
	public Etudiant() {
		this(0, "", "",0,'\u0000');
	}
	
	public Etudiant(int id, String nom, String prenom, int age, char sexe) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.sexe = sexe;
		this.note = new ArrayList<Float>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	
	public ArrayList<Float> getNote() {
		return note;
	}
	
	public void setNote(ArrayList<Float> note) {
		this.note = note;
	}
	
	public void addNote (float notes) {
		note.add(notes);
	}
	
	public float getMoyenne() {
		moyenne = 0;
		note.forEach((objet)->moyenne = moyenne + objet);
		moyenne = moyenne/note.size();
		return moyenne;
	}

	public static Etudiant saisieEtudiant(Scanner scanner) {
		return Etudiant.saisieEtudiant(scanner, false);
	}
	
	public static Etudiant saisieEtudiant(Scanner scanner, boolean needNote) {
		Etudiant etudiant = new Etudiant();
		int id = -1;
		String nom = null;
		String prenom = null;
		int age = -1;
		char sexe = 'a';
		float note = -1;
		while (id<1) {
			try {
				System.out.println("Saisir l'id de l'étudiant : ");
				id = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Erreur de la saisie de l'id il doit etre supérieur à 0");
			}
		}
		while (age<1) {
			try {
				System.out.println("Saisir l'age de l'étudiant : ");
				age = scanner.nextInt();
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Erreur de la saisie de l'age il doit etre supérieur à 0");
			}
		}
		while (nom != null) {
			try {
				System.out.println("Saisir le nom de l'étudiant : ");
				nom =  scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Erreur de la saisie du nom");
			}
		}
		while (prenom != null) {
			try {
				System.out.println("Saisir le prenom de l'étudiant : ");
				prenom =  scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Erreur de la saisie du prenom");
			}
		}
		while (sexe != 'M' || sexe != 'F') {
			try {
				System.out.println("Saisir le sexe de l'étudiant (M/F) : ");
				sexe =  scanner.nextLine().charAt(0);
			} catch (Exception e) {
				System.out.println("Erreur de la saisie le sexe de l'étudiant doit etre egale a M ou F");
			}
		}
		if(needNote) {
			//TODO demander la saisie des notes de l'etudiant séparer par un |
			while (note < 0 || note > 20) {
				try {
					System.out.println("Saisir les notes en les séparant par un | :");
					note = scanner.nextFloat();
				} catch (Exception e) {
					System.out.println("Les notes doivent être comprise entre 0 et 20");
				}
			}
		}

		etudiant.setAge(age);
		etudiant.setId(id);
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setSexe(sexe);

		return etudiant;
	}
	
	

	public int afficherMenu(Scanner scanner) {
		System.out.println("*************Menu Étudiant********************");
		System.out.println(Test.CHOIX_ETUDIANT_CHANGER_INFO + ". Changer les information de l'étudiant");
		System.out.println(Test.CHOIX_ETUDIANT_AJOUTER_NOTE + ". Ajouter des notes");
		System.out.println(Test.CHOIX_ETUDIANT_SUPPRIMER_NOTE +". Supprimer des notes");
		System.out.println(Test.CHOIX_ETUDIANT_AFFICHER_MOYENNE +". Afficher la moyenne");
		System.out.println(Test.CHOIX_ETUDIANT_QUITTER +". Quitter");
		System.out.print(">");
		int choix = scanner.nextInt();
		scanner.nextLine();
		System.out.println("***********************************************");
		return choix;
	}

	public void changerInformation(Scanner scanner) {
		Etudiant e = Etudiant.saisieEtudiant(scanner,false);
		this.setNom(e.nom);
		this.setPrenom(e.prenom);
		this.setAge(e.age);
		this.setSexe(e.sexe);
	}

	public void ajouterNote(Scanner scanner) {
		Etudiant e = Etudiant.saisieEtudiant(scanner,false);
		this.note.add(e);
	}

	public void supprimerNote(Scanner scanner) {
		int id = Promotion.saisirId(scanner);
		Etudiant e = Promotion.getEtudiantById(id);
		if(e !=null) {
			this.note.remove(e);
			System.out.println("Note supprimé !");
		} else {
			System.out.println("Note pas trouvé !");
		}
	}
}