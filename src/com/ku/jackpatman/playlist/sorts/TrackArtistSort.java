package com.ku.jackpatman.playlist.sorts;

import com.ku.jackpatman.playlist.Track;
import java.util.Comparator;

public class TrackArtistSort implements Comparator<Track>
{
    @Override
    public int compare(Track o1, Track o2)
    {
        String firstArtist;
        String secondArtist;

        if (o1.getTrackFile().hasId3v1Tag() && o2.getTrackFile().hasId3v2Tag())
        {
            firstArtist = o1.getTrackFile().getId3v1Tag().getArtist();
            secondArtist = o2.getTrackFile().getId3v1Tag().getArtist();
        } else
        {
            firstArtist = o1.getTrackFile().getId3v2Tag().getArtist();
            secondArtist = o2.getTrackFile().getId3v2Tag().getArtist();
        }

      if (firstArtist != null && secondArtist != null)
        {
            return (firstArtist.toLowerCase().compareTo(secondArtist.toLowerCase()));
        }
        else
        {
            return 0;
        }  

    }
}
