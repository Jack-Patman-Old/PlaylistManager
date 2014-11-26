package com.ku.jackpatman.playlist.sorts;

import com.ku.jackpatman.playlist.Track;
import java.util.Comparator;

public class TrackPathSort implements Comparator<Track>
{

    @Override
    public int compare(Track o1, Track o2)
    {
        String firstPath = o1.getFile().getPath().toLowerCase();
        String secondPath = o2.getFile().getPath().toLowerCase();

        if (firstPath != null && secondPath != null)
        {
            return (firstPath.compareTo(secondPath));
        } else
        {
            return 0;
        }
    }
}
