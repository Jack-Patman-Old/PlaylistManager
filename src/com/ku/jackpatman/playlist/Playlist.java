package com.ku.jackpatman.playlist;

import com.ku.jackpatman.playlist.sorts.TrackAlbumSort;
import com.ku.jackpatman.playlist.sorts.TrackArtistSort;
import com.ku.jackpatman.playlist.sorts.TrackGenreSort;
import com.ku.jackpatman.playlist.sorts.TrackLengthSort;
import com.ku.jackpatman.playlist.sorts.TrackNameSort;
import com.ku.jackpatman.playlist.sorts.TrackPathSort;
import com.ku.jackpatman.playlist.sorts.TrackYearSort;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

public class Playlist
{

    private final List<Track> tracks;
    private final String playlistPath;
    private final boolean isPlaylistFile; 

    public Playlist(String playlistPath, boolean isPlaylistFile)
    {
        this.playlistPath = playlistPath;
        this.isPlaylistFile = isPlaylistFile;
        
        tracks = new ArrayList<>();
    }

    public void RemoveTrack(int trackNumber)
    {
        tracks.remove(trackNumber);
    }
    
    public void SwapTrackPositions(int trackOne, int trackTwo)
    {
        Track tempTrack = tracks.get(trackOne);
        tracks.set(trackOne, tracks.get(trackTwo));
        tracks.set(trackTwo, tempTrack);
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
    
    public void SaveAllTracks(String[][] data)
    {
       for (int i=0; i < data.length; i ++)
       {
           Map<MetadataType, String> metadata = new HashMap<>(); 
           metadata.put(MetadataType.ALBUM, data[i][0]);
           metadata.put(MetadataType.TITLE, data[i][1]);
           metadata.put(MetadataType.ARTIST, data[i][2]);
           metadata.put(MetadataType.YEAR, data[i][5]);
           
           tracks.get(i).setTrackMetadata(metadata);
           tracks.get(i).SaveChanges();
       } 
    }

    public void GeneratePlaylist(File file)
    {
        PrintWriter pw = null;

        String ext = FilenameUtils.getExtension(file.getPath());
        if (!"m3u".equals(ext.toLowerCase()))
        {
            file = new File(file.getPath() + ".m3u");
        }

        try
        {
            pw = new PrintWriter(file.getPath());
            // Opening line, denotes file header
            pw.println("#EXTM3U");

            for (Track track : tracks)
            {
                Map<MetadataType, String> metadata = track.getTrackMetadata();
                
                StringBuilder comment = new StringBuilder();
                // Comment lead to denote track information
                comment.append("#EXTINF:");
                comment.append(track.getTrackFile().getLengthInSeconds());
                comment.append(",");
                comment.append(metadata.get(MetadataType.ALBUM));
                comment.append(" - ");
                comment.append(metadata.get(MetadataType.TITLE));
                pw.println(comment.toString());
                pw.println(track.getFile().getPath());
            }
        } 
        catch (IOException ex)
        {
            Logger.getLogger(Playlist.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally
        {
            pw.close();
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
    
    public void sortTracks(Comparator c)
    {
        Collections.sort(tracks, c);
    }

    public void reversePlaylistOrder()
    {
        Collections.reverse(tracks);
    }

    public List<Track> searchTracks(String searchTerm)
    {
        String searchValue = searchTerm.toLowerCase();
        List<Track> matches = new ArrayList<>();

        for (Track track : tracks)
        {
            Map<MetadataType, String> metadata = track.getTrackMetadata();

            if (metadata.get(MetadataType.ALBUM) != null && metadata.get(MetadataType.ALBUM).toLowerCase().contains(searchValue))
            {
                matches.add(track);
                continue;
            }
            if (metadata.get(MetadataType.ARTIST) != null && metadata.get(MetadataType.ARTIST).toLowerCase().contains(searchValue))
            {
                matches.add(track);
                continue;
            }
            if (metadata.get(MetadataType.TITLE) != null && metadata.get(MetadataType.TITLE).toLowerCase().contains(searchValue))
            {
                matches.add(track);
                continue;
            }
            if (metadata.get(MetadataType.GENRE) != null && metadata.get(MetadataType.GENRE).toLowerCase().contains(searchValue))
            {
                matches.add(track);
                continue;
            }
            if (metadata.get(MetadataType.YEAR) != null && metadata.get(MetadataType.YEAR).toLowerCase().contains(searchValue))
            {
                matches.add(track);
            }

        }

        return matches;
    }

    public boolean isPlaylistFile()
    {
        return isPlaylistFile; 
    }
    
    public String getPlaylistPath()
    {
        return playlistPath; 
    }
    
    @Override
    public String toString()
    {
        return playlistPath;
    }
}
