package com.teamtreehouse.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class SongBook {
    private List<Song> mSongs;

    public SongBook() {
        mSongs = new ArrayList<>();
    }

    public void exportTo(String filename) {
        try (
                FileOutputStream fos = new FileOutputStream(filename);
                PrintWriter pw = new PrintWriter(fos)
        ) {
            for (Song song : mSongs) {
                pw.printf("%s|%s|%s%n", song.getArtist(), song.getTitle(), song.getVideoUrl());
            }
        } catch (IOException ioe) {
            System.out.printf("Problem saving %s%n", filename);
            ioe.printStackTrace();
        }
    }

    public void importFrom(String filename) {
        try (
                FileInputStream fis = new FileInputStream(filename);
                BufferedReader pw = new BufferedReader(new InputStreamReader(fis))
        ) {
            String line;
            while ((line = pw.readLine()) != null) {
                String[] arg = line.split("\\|");
                addSong(new Song(arg[0], arg[1], arg[2]));
            }
        } catch (IOException ioe) {
            System.out.printf("Problem loading %s%n", filename);
            ioe.printStackTrace();
        }
    }

    public void addSong(Song song) {
        mSongs.add(song);
    }

    public int getSongCount() {
        return mSongs.size();
    }


    //FIXME:  This should be cached
    private Map<String, List<Song>> byArtist() {
        Map<String, List<Song>> byArtist = new HashMap<>();
        for (Song song : mSongs) {
            List<Song> artistSongs = byArtist.get(song.getArtist());
            if (artistSongs == null) {
                artistSongs = new ArrayList<>();
                byArtist.put(song.getArtist(), artistSongs);
            }
            artistSongs.add(song);
        }
        return byArtist;
    }

    public Set<String> getArtists() {
        return byArtist().keySet();
    }

    public List<Song> getSongsForArtist(String artistName) {
        List<Song> songs = byArtist().get(artistName);
        songs.sort((song1, song2) -> {
            if (song1.equals(song2)) {
                return 0;
            } else {
                return song1.mTitle.compareTo(song2.mTitle);
            }
        });
        return songs;
    }

}
