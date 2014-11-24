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
        
        if (o1.getTrackFile().getId3v1Tag() != null && o2.getTrackFile().getId3v1Tag() != null)
        {
            firstTitle = o1.getTrackFile().getId3v1Tag().getTitle();
            secondTitle = o2.getTrackFile().getId3v1Tag().getTitle();
            
            return (firstTitle.compareTo(secondTitle));
        }
        else
        {
            firstTitle = o1.getTrackFile().getId3v2Tag().getTitle();
            secondTitle = o2.getTrackFile().getId3v2Tag().getTitle();
            
            return (firstTitle.compareTo(secondTitle));            
        }
 
    }
    
}
