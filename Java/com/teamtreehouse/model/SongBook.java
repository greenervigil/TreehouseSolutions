package com.teamtreehouse.model;
import java.util.*;

public class SongBook{
  private List<Song> mSongs;

  public SongBook(){
   mSongs = new ArrayList<Song>();

  }

  public void addSong (Song song) {
    mSongs.add(song);
  }

  public int getSongCount(){
   return mSongs.size();
  }


  //FIXME:  THis should be cached
  private Map<String, List<Song>> byArtist () {
    Map<String, List<Song>> byArtist = new HashMap<>();
    for (Song song : mSongs) {
      List<Song> artistSongs = byArtist.get(song.getArtist());
      if (artistSongs == null){
        artistSongs = new ArrayList<>();
        byArtist.put(song.getArtist(), artistSongs );
      }
      artistSongs.add(song);
    }
    return byArtist;
  }

  public Set<String> getArtist() {
    return byArtist().keySet();
  }

  public List<Song> getSongsForArtist (String artistName) {
    return byArtist().get(artistName);
  }

}
