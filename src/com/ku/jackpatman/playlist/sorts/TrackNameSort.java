package com.ku.jackpatman.playlist.sorts;

import com.ku.jackpatman.playlist.Track;
import java.util.Comparator;

public class TrackNameSort implements Comparator<Track>
{

    @Override
    public int compare(Track o1, Track o2)
    {
        String firstTitle;
        String secondTitle;

        if (o1.getTrackFile().hasId3v1Tag() && o2.getTrackFile().hasId3v2Tag())
        {
            firstTitle = o1.getTrackFile().getId3v1Tag().getTitle().toLowerCase();
            secondTitle = o2.getTrackFile().getId3v1Tag().getTitle().toLowerCase();
        } else
        {
            firstTitle = o1.getTrackFile().getId3v2Tag().getTitle().toLowerCase();
            secondTitle = o2.getTrackFile().getId3v2Tag().getTitle().toLowerCase();
        }

        if (firstTitle != null && secondTitle != null)
        {
            return (firstTitle.compareTo(secondTitle));

        } else
        {
            return 0;
        }

    }
}
