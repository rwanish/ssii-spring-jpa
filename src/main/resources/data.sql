-- Initialisation des tables
-- Ce fichier ne peut pas être vide
SELECT 0 as INUTILE;

-- Ajouter des enregistrements pour Personne
INSERT INTO Personne (matricule, nom, prenom, poste) VALUES (1, 'Dupont', 'Jean', 'Développeur');
INSERT INTO Personne (matricule, nom, prenom, poste) VALUES (2, 'Martin', 'Marie', 'Chef de Projet');

-- Ajouter des enregistrements pour Projet
INSERT INTO Projet (code, nom, debut, fin) VALUES (1, 'Projet A', '2023-01-01', '2023-12-31');
INSERT INTO Projet (code, nom, debut, fin) VALUES (2, 'Projet B', '2023-02-01', '2023-11-30');

-- Ajouter des enregistrements pour Participation
INSERT INTO Participation (matricule, code, role, pourcentage) VALUES (1, 1, 'Développeur', 50.0);