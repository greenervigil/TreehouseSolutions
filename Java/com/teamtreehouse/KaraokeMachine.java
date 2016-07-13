package com.teamtreehouse;

import com.teamtreehouse.model.Song;
import com.teamtreehouse.model.SongBook;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class KaraokeMachine {
 private SongBook mSongBook;
 private BufferedReader mReader;
 private Map<String, String> mMenu;

 public KaraokeMachine(SongBook songbook) {
   mSongBook = songbook;
   mReader = new BufferedReader(new InputStreamReader(System.in));
   mMenu = new HashMap<String, String>();

   mMenu.put("Add", "Add a new song to the song book.");
   mMenu.put("Quit", "Exit the program.");
 }

  private String promptAction(){
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
}
