package com.gestionEtudiant.java;

import java.util.List;

public interface Menu {
	
	public void ajoutEtudiant(Etudiant etudiant);
	
	public void supprimerEtudiant(Etudiant etudiant);
	
	public void modifierEtudiant(Etudiant etudiant);
	
	public Etudiant getEtudiantById(int i);
	
	public List<Etudiant> getAllEtudiant();

}