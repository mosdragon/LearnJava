import java.util.Scanner;

public class MusicCollectionDriver {
        //Scanner object for user input
        private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        //Very odd choice of Music for Song objects
        Song  shiny = new Song("My Shiny Teeth and Me", "Fairly Odd Parents",
            "Pop");
        Song  noise = new Song("Adding to the Noise", "Switchfoot", "Rock");
        Song  best = new Song("Best Day Ever", "Spongebob Squarepants");
        Song  call = new Song("Call Me Maybe", "Carly Rae Jepson", "Pop");
        //Instantiates Album objects for songs
        Album fairly = new Album("Random Songs I Chose", shiny);
        fairly.addSong(call, false);
        Album sFoot = new Album("Switchfoot", noise);
        Album sponge = new Album("Spongebob Studios", best);
        //Adds all Album objects to Album array for simplicity
        Album[] myMusic = {fairly, sFoot, sponge};
        //Represents user's selection
        int choice = 0;
        while (choice != -1) {
            //Parses integer value from a line from the Scanner
            System.out.println("\nMusic Collection:");
            for (int i = 0; i < myMusic.length; i++) {
                System.out.printf("[%d]: %s%n", i, myMusic[i].getTitle());
            }
            System.out.print("Select an album (or -1 to quit): ");
            choice = Integer.parseInt(keyboard.nextLine());
            System.out.println();
            for (int i = 0; i < myMusic.length; i++) {
                if (choice == i) {
                    albumOptions(myMusic[i]);
                }
            }
        }
    }
    public static void albumOptions(Album albumName) {
        /* Directions
        (a) Get Favorite Track: Print out the information of the Album’s
        favorite track.
        (b) Change genre: Allow the user to change the genre of the Album.
        (c) Exit: Allow the user to return to the main loop.
        */
        int choice = 0;
        while (choice != -1) {
            System.out.printf("%s, Tracks:%n%s", albumName.getTitle(),
                albumName.getAllSongs());
            System.out.print("[0]: Get favorite track\n[1]: Change genre"
                + "\n[2]: Add song\nYour choice (or -1 to quit): ");
            choice = Integer.parseInt(keyboard.nextLine());

            if (choice == 0) {
                System.out.println("\nFavorite Song on " + albumName.getTitle()
                    + ":\n" + albumName.getFavoriteTrack());
            } else if (choice == 1) {
                System.out.println("\nNew genre:");
                albumName.setGenre(keyboard.nextLine());
                System.out.println();
            } else if (choice == 2) {
                System.out.println("\nSong name?");
                String name = keyboard.nextLine();
                String artist = albumName.getFavoriteTrack().getArtist();
                String genre = albumName.getFavoriteTrack().getGenre();
                Song adding = new Song(name, artist, genre);
                System.out.println("\nIs this your favorite song on the album?"
                    + " (true/false)");
                boolean isFav = Boolean.parseBoolean(keyboard.nextLine());
                System.out.println();
                albumName.addSong(adding, isFav);
            }
        }
    }
}