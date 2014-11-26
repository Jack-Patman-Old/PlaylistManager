package com.ku.jackpatman.playlist.sorts;

import com.ku.jackpatman.playlist.Track;
import java.util.Comparator;

public class TrackGenreSort implements Comparator<Track>
{

    @Override
    public int compare(Track o1, Track o2)
    {
        String firstGenre;
        String secondGenre;

        if (o1.getTrackFile().hasId3v1Tag() && o2.getTrackFile().hasId3v2Tag())
        {
            firstGenre = o1.getTrackFile().getId3v1Tag().getGenreDescription();
            secondGenre = o2.getTrackFile().getId3v1Tag().getGenreDescription();
        } else
        {
            firstGenre = o1.getTrackFile().getId3v2Tag().getGenreDescription();
            secondGenre = o2.getTrackFile().getId3v2Tag().getGenreDescription();
        }

      if (firstGenre != null && secondGenre != null)
        {
            return (firstGenre.toLowerCase().compareTo(secondGenre.toLowerCase()));
        }
        else
        {
            return 0;
        }  

    }
}
