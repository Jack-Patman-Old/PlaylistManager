package com.ku.jackpatman.playlist;

import com.ku.jackpatman.playlist.sorts.TrackAlbumSort;
import com.ku.jackpatman.playlist.sorts.TrackArtistSort;
import com.ku.jackpatman.playlist.sorts.TrackGenreSort;
import com.ku.jackpatman.playlist.sorts.TrackLengthSort;
import com.ku.jackpatman.playlist.sorts.TrackNameSort;
import com.ku.jackpatman.playlist.sorts.TrackPathSort;
import com.ku.jackpatman.playlist.sorts.TrackYearSort;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
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
            if (track.getTrackFile().hasId3v1Tag())
            {
                ID3v1 trackData = track.getTrackFile().getId3v1Tag();
                if (trackData.getAlbum() != null && trackData.getAlbum().contains(searchValue))
                {
                    matches.add(track);
                    continue;
                }
                if (trackData.getArtist() != null && trackData.getArtist().toLowerCase().contains(searchValue))
                {
                    matches.add(track);
                    continue;
                }
                if (trackData.getTitle() != null && trackData.getTitle().toLowerCase().contains(searchValue))
                {
                    matches.add(track);
                    continue;
                }
                if (trackData.getGenreDescription() != null && trackData.getGenreDescription().toLowerCase().contains(searchValue))
                {
                    matches.add(track);
                    continue;
                }
                if (trackData.getYear() != null && trackData.getYear().toLowerCase().contains(searchValue))
                {
                    matches.add(track);
                }
            } else if (track.getTrackFile().hasId3v2Tag())
            {
                ID3v2 trackData = track.getTrackFile().getId3v2Tag();
                if (trackData.getAlbum() != null && trackData.getAlbum().toLowerCase().contains(searchValue))
                {
                    matches.add(track);
                    continue;
                }
                if (trackData.getArtist() != null && trackData.getArtist().toLowerCase().contains(searchValue))
                {
                    matches.add(track);
                    continue;
                }
                if (trackData.getTitle() != null && trackData.getTitle().toLowerCase().contains(searchValue))
                {
                    matches.add(track);
                    continue;
                }
                if (trackData.getGenreDescription() != null && trackData.getGenreDescription().toLowerCase().contains(searchValue))
                {
                    matches.add(track);
                    continue;
                }
                if (trackData.getYear() != null && trackData.getYear().toLowerCase().contains(searchValue))
                {
                    matches.add(track);
                }
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
