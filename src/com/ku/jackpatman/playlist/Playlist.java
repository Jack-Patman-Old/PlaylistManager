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
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

public class Playlist
{

    private final List<Track> tracks;
    private final String playlistPath;

    public Playlist(String playlistPath)
    {
        this.playlistPath = playlistPath;
        tracks = new ArrayList<>();
    }

    public void RemoveTrack(int trackNumber)
    {
        tracks.remove(trackNumber);
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
        Collections.sort(tracks, new TrackAlbumSort());
    }

    public void sortTracksByYear()
    {
        Collections.sort(tracks, new TrackYearSort());
    }

    public void sortTracksByPath()
    {
        Collections.sort(tracks, new TrackPathSort());
    }

    public void sortTracksByArtist()
    {
        Collections.sort(tracks, new TrackArtistSort());
    }

    public void sortTracksByLength()
    {
        Collections.sort(tracks, new TrackLengthSort());
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

            if (metadata.get(MetadataType.ALBUM) != null && metadata.get(MetadataType.ALBUM).contains(searchValue))
            {
                matches.add(track);
                continue;
            }
            if (metadata.get(MetadataType.ARTIST) != null && metadata.get(MetadataType.ARTIST).contains(searchValue))
            {
                matches.add(track);
                continue;
            }
            if (metadata.get(MetadataType.TITLE) != null && metadata.get(MetadataType.TITLE).contains(searchValue))
            {
                matches.add(track);
                continue;
            }
            if (metadata.get(MetadataType.GENRE) != null && metadata.get(MetadataType.GENRE).contains(searchValue))
            {
                matches.add(track);
                continue;
            }
            if (metadata.get(MetadataType.YEAR) != null && metadata.get(MetadataType.YEAR).contains(searchValue))
            {
                matches.add(track);
            }

        }

        return matches;
    }

    @Override
    public String toString()
    {
        return playlistPath;
    }
}
