package com.teamtreehouse;

import com.teamtreehouse.model.Song;
import com.teamtreehouse.model.SongBook;
import java.io.*;
import java.util.*;

public class KaraokeMachine {
 private SongBook mSongBook;
 private BufferedReader mReader;
 private Map<String, String> mMenu;

 public KaraokeMachine(SongBook songbook) {
   mSongBook = songbook;
   mReader = new BufferedReader(new InputStreamReader(System.in));
   mMenu = new HashMap<String, String>();

   mMenu.put("Add", "Add a new song to the song book.");
   mMenu.put("Choose", "Choose a song to sing.");
   mMenu.put("Quit", "Exit the program.");
 }

  private String promptAction()throws IOException{
    System.out.printf("There are %d songs available.  Your options are: %n", mSongBook.getSongCount());

    for (Map.Entry<String, String> option : mMenu.entrySet()) {
      System.out.printf("%s - %s %n", option.getKey(), option.getValue());
    }
    System.out.print("What do you want to do: ");
    String choice = mReader.readLine();
    return choice.trim().toLowerCase();
  }

  public void run() {
    String choice = "";
    do {
      try {
        choice = promptAction();
        switch(choice) {
          case "add":
            Song song = promptNewSong();
            mSongBook.addSong(song);
            System.out.printf("%s added.  %n%n%n, song");
            break;
          case "chose":
            String artist = promptArtist();
            Song artistSong = promptSongForArtist(artist);
            //TODO: add to a song queue
            System.out.printf("You chose %s %n" , artistSong);
            break;
          case "quit":
            System.out.println("Thanks for playing!");
            break;
          default:
            System.out.printf("Unknown choice: %s. Try Again. %n%n%n", choice);

        }
      }catch (IOException ioe) {
        System.out.println("Problem with input.");
        ioe.printStackTrace();
      }

    }while (!choice.equals("quit"));
  }

  private Song promptNewSong() throws IOException {
    System.out.print("Enter the artist's name:  ");
    String artist = mReader.readLine();
    System.out.print("Enter the title:  ");
    String title = mReader.readLine();
    System.out.print("Enter the video URL:  ");
    String videoUrl = mReader.readLine();
    return new Song(artist, title, videoUrl);

  }

  private String promptArtist() throws IOException {
    System.out.println("Available Artists:  ");
    List<String> artists = new ArrayList<>(mSongBook.getArtist());
    int index = promptForIndex(artists);
    return artists.get(index);
  }

  private Song promptSongForArtist(String artist) throws IOException {
    List<Song> songs = mSongBook.getSongsForArtist(artist);
    List<String> songTitles = new ArrayList<>();
    for (Song song : songs) {
      songTitles.add(song.getTitle());
    }
    int index = promptForIndex(songTitles);
    return songs.get(index);
  }

  private int promptForIndex(List<String> options) throws IOException {
    int counter = 0;
    for (String s : options) {
      System.out.printf("%d.)  %s %n", counter, s);
      counter++;
    }
    String optionAsString = mReader.readLine();
    int choice = Integer.parseInt(optionAsString.trim());
    System.out.print("Your choice:  ");
    return choice -1;
  }
}