package src;
class UIWeekEnd {    
    public static void main(String[] args) {
		WeekEnd leWeekEnd = new WeekEnd();
		AppWeekEnd app = new AppWeekEnd(leWeekEnd);
		app.run();
    }
}

class AppWeekEnd {
    WeekEnd we;
    boolean quitter;

    AppWeekEnd(WeekEnd we) {
		this.we = we;
		this.quitter = false;
    }

    public void run() {
		bienvenue();
		boolean continuer = true;
		while(!quitter) {
			menu();
		}
		au_revoir();
    }

	public void afficherPersonnes() {
		System.out.println("Voici les personnes présentes pendant le weekend:");
		for (Personne personne : this.we.getAmis()) {
			System.out.println("-" + personne.toString());
		}
	}

    public void menu() {
		boolean commande_faite = false;
		while(!commande_faite) {
			System.out.println("Que voulez vous faire?");
			System.out.println("P: afficher les personnes du week-end");
			System.out.println("D: afficher les dépences du week-end");
			System.out.println("M: afficher la dépense moyenne par personne du week-end");
			System.out.println("Q: quitter");
			
			String commande_brute = System.console().readLine();
			String commande = commande_brute.strip().toLowerCase();
			
			switch (commande) {
				case "q":
					quitter = true;
					commande_faite = true;
					break;
				
				case "p":
					commande_faite = true;
					this.afficherPersonnes();

				case "d":
					commande_faite = true;
					break;

				case "m":
					commande_faite = true;
					break;

				default:
				System.out.println("Commande '" + commande_brute + "' invalide.");
					break;
			}
		}
    }

    /// Affiche un message de bienvenue
    public void bienvenue() {
	System.out.println("╭────────────────────────────────────────────────────────────────────────────────────╮");
	System.out.println("│ Bienvenue! En week-end comme dans la semaine, les bons comptes font les bons amis. │");
	System.out.println("╰────────────────────────────────────────────────────────────────────────────────────╯");
    }

    /// Affiche un message d'au revoir
    public void au_revoir() {
		System.out.println("N'arrête jamais d'apprendre");
    }
}
