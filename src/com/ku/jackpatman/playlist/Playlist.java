package com.ku.jackpatman.playlist;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private final List<Track> tracks;

    public Playlist() 
    {
        tracks = new ArrayList<>();
    }

    public void DeleteTrack(File file)
    {
        for(Track track: tracks)
        {
            if (track.getFile().getPath().equals(file.getPath()))
            {
                tracks.remove(track);
                track.deleteFile();
                break;
            }
        }
    }
    
    public void AddTrack(String path)
    {
         File track = new File(path);
         this.tracks.add(new Track(track));
    }
    
    
    public List<Track> getTracks()
    {
        return tracks;
    }
}
