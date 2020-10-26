package bmdb.ui;

import java.time.LocalDate;
import java.util.List;
import bmdb.business.Actor;
import bmdb.business.Movie;
import bmdb.db.ActorDb;
import bmdb.db.MovieDb;

public class BmdbApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Bootcamp Movie Database!");
		System.out.println();
		System.out.println("COMMANDS");
		System.out.println("la - List actors");
		System.out.println("lm - List Movies");
		System.out.println("aa - Add Actor");
		System.out.println("am - Add Movie");
		System.out.println("da - Delete Actor by ID");
		System.out.println("dm - Delete Movie by ID");
		System.out.println("ua - Update Actor");
		System.out.println("um - Update Movie");
		System.out.println("gabn - Get an Actor by Last Name");
		System.out.println("gabi - Get actor by ID");
		System.out.println("movie - Get a Movie");
		System.out.println("exit - Exit the Application");

		ActorDb actorDb = new ActorDb();
		MovieDb movieDb = new MovieDb();

		String command = Console.getString("Enter Command: ");
		while (!command.equalsIgnoreCase("Exit")) {

			switch (command) {
			case "la":
				List<Actor> actors = actorDb.getAll();
				System.out.println("Actors: ");
				for (Actor actor : actors) {
					System.out.println(actor);
				}
				break;

			case "lm":
				List<Movie> movies = movieDb.getAll();
				System.out.println("Movies: ");
				for (Movie movie : movies) {
					System.out.println(movie);
				}
				break;

			case "aa":
				String newFirstName = Console.getString("First name: ");
				String newLastName = Console.getString("Last name: ");
				String newGender = Console.getString("Gender: ");
				String newBirthDateStr = Console.getString("Birth Date (YYYY-MM-DD): ");
				LocalDate newBirthDate = LocalDate.parse(newBirthDateStr);

				Actor newActor = new Actor(0, newFirstName, newLastName, newGender, newBirthDate);

				if (actorDb.add(newActor)) {
					System.out.println("Actor Added Successfully");
				} else {
					System.out.println("Error Adding Actor");
				}
				break;

			case "am":
				String newTitle = Console.getString("Title: ");
				String newYear = Console.getString("Year: ");
				String newRating = Console.getString("Rating: ");
				String newDirector = Console.getString("BDirector: ");

				Movie newMovie = new Movie(0, newTitle, newYear, newRating, newDirector);

				if (movieDb.add(newMovie)) {
					System.out.println("Movie Added Successfully");
				} else {
					System.out.println("Error Adding Movie");
				}
				break;

			case "da":
				long idToDel = Console.getInt("Actor ID to Delete: ");
				if (actorDb.delete(idToDel)) {
					System.out.println("Actor Deleted");
				} else {
					System.out.println("Error Deleting Actor");
				}
				break;

			case "dm":
				long idDel = Console.getInt("Movie ID to Delete: ");
				if (movieDb.delete(idDel)) {
					System.out.println("Movie Deleted");
				} else {
					System.out.println("Error Deleting Movie");
				}
				break;

			case "ua":
				long upId = Console.getInt("ID: ");
				String upFirstName = Console.getString("First name: ");
				String upLastName = Console.getString("Last name: ");
				String upGender = Console.getString("Gender: ");
				String upBirthDateStr = Console.getString("Birth Date (YYYY-MM-DD): ");
				LocalDate upBirthDate = LocalDate.parse(upBirthDateStr);

				Actor upActor = new Actor(upId, upFirstName, upLastName, upGender, upBirthDate);

				if (actorDb.update(upActor)) {
					System.out.println("Actor Updated Successfully");
				} else {
					System.out.println("Error Updating Actor");
				}
				break;

			case "um":
				long updateId = Console.getInt("ID: ");
				String upTitle = Console.getString("Title: ");
				String upYear = Console.getString("Year: ");
				String upRating = Console.getString("Rating: ");
				String upDirector = Console.getString("Director: ");

				Movie upMovie = new Movie(updateId, upTitle, upYear, upRating, upDirector);

				if (movieDb.update(upMovie)) {
					System.out.println("Movie Updated Successfully");
				} else {
					System.out.println("Error Updating Movie");
				}
				break;

			case "gabn":
				String lastName = Console.getString("Actor's last name: ");
				Actor actor = actorDb.getActorByLastName(lastName);
				if (actor == null) {
					System.out.println("No Actor Found");
				} else {
					System.out.println(actor);
				}
				break;

			case "movie":
				MovieDb movieDatab = new MovieDb();
				List<Movie> movies2 = movieDatab.getAll();
				System.out.println("Movies: ");
				for (Movie movie : movies2) {
					System.out.println(movie);
				}
				break;

			case "gabi":
				long id = Console.getInt("Actor's ID: ");
				Actor actorByID = actorDb.get(id);
				if (actorByID == null) {
					System.out.println("No ID Found");
				} else {
					System.out.println(id);
				}
				break;

			}

			command = Console.getString("Enter Command: ");

		}

	}

}
