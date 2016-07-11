package com.teamtreehouse;

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

  }
}
