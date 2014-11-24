package com.ku.jackpatman.playlist;

import com.ku.jackpatman.playlist.sorts.TrackGenreSort;
import com.ku.jackpatman.playlist.sorts.TrackNameSort;
import com.ku.jackpatman.playlist.sorts.TrackPathSort;
import com.ku.jackpatman.playlist.sorts.TrackYearSort;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist 
{

    private final List<Track> tracks;
    private final String playlistPath;
    
    public Playlist(String playlistPath)
    {
        this.playlistPath = playlistPath;
        tracks = new ArrayList<>();
    }

    public void DeleteTrack(File file)
    {
        for (Track track : tracks)
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

    public void sortTracksByName()
    {
        Collections.sort(tracks, new TrackNameSort());
    }

    public void sortTracksByGenre()
    {
        Collections.sort(tracks, new TrackGenreSort());
    }

    public void sortTracksByAlbum()
    {
        Collections.sort(tracks, new TrackGenreSort());
    }

    public void sortTracksByYear()
    {
        Collections.sort(tracks, new TrackYearSort());
    }

    public void sortTracksByPath()
    {
        Collections.sort(tracks, new TrackPathSort());
    }

    public void reversePlaylistOrder()
    {
        Collections.reverse(tracks);
    }
    
    public String toString() 
    {
        return playlistPath; 
    }
}
