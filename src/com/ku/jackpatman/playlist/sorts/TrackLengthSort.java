package com.ku.jackpatman.playlist.sorts;

import com.ku.jackpatman.playlist.Track;
import java.util.Comparator;

public class TrackLengthSort implements Comparator<Track>
{

    @Override
    public int compare(Track o1, Track o2)
    {
        Long firstLength;
        Long secondLength;

        if (o1.getTrackFile().hasId3v1Tag() && o2.getTrackFile().hasId3v2Tag())
        {
            firstLength = o1.getTrackFile().getLengthInMilliseconds();
            secondLength = o2.getTrackFile().getLengthInMilliseconds();
        } else
        {
            firstLength = o1.getTrackFile().getLengthInMilliseconds();
            secondLength = o2.getTrackFile().getLengthInMilliseconds();
        }

        return (firstLength.compareTo(secondLength));

    }
}
