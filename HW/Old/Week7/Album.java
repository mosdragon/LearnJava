public class Album {
    private String title;
    private String artist;
    private String genre;
    private Song[] songs;
    private Song favoriteTrack;

    public Album(String title, Song firstTrack) {
        this.title = title;
        this.favoriteTrack = firstTrack;
        songs = new Song[1];
        songs[0] = favoriteTrack;
        this.artist = favoriteTrack.getArtist();
        setGenre(favoriteTrack.getGenre());
    }
    public String getTitle() {
        return title;
    }
    public Song getFavoriteTrack() {
        return favoriteTrack;
    }
    public void setGenre(String genre) {
        this.genre = genre;
        for (Song s : songs) {
            if (s != null) {
                s.setGenre(genre);
            }
        }
    }
    public void addSong(Song s, boolean isFavorite) {
        int len = songs.length;
        if (songs[len - 1] == null) {
            boolean added = false;
            for (int i = 0; i < len; i++) {
                if (!added && songs[i] == null) {
                    songs[i] = s;
                    added = true;
                }
            }
        } else {
            Song[] temporary = songs;
            songs = new Song[len * 2];
            for (int i = 0; i < len; i++) {
                songs[i] = temporary[i];
            }
            songs[len] = s;
        }
        if (isFavorite) {
            favoriteTrack = s;
            setGenre(s.getGenre());
            this.artist = s.getArtist();
        }
    }
    public String toString() {
        String msg = String.format("Album: %s, by %s (%s):%n",
            title, artist, genre);
        msg += getAllSongs();
        return msg;
    }
    public String getAllSongs() {
        String msg = "";
        for (Song s : songs) {
            if (s != null) {
                msg += s;
            }
        }
        return msg;
    }
}