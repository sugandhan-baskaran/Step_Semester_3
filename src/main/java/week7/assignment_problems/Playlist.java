package week7.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maximumSize) {
        songs = new String[maximumSize];
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter playlist capacity: ");
            Playlist playlist = new Playlist(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Enter number of songs: ");
            int numberOfSongs = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < numberOfSongs; i++) {
                System.out.print("Enter song " + (i + 1) + ": ");
                playlist.addSong(scanner.nextLine());
            }
            System.out.println("Songs:");
            for (String song : playlist.getSongs()) {
                System.out.println(song);
            }
            System.out.println("Song count: " + playlist.getSongCount());
        }
    }
}
