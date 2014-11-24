package com.ku.jackpatman.playlist.sorts;

import com.ku.jackpatman.playlist.Track;
import java.util.Comparator;

public class TrackYearSort implements Comparator<Track>
{

    @Override
    public int compare(Track o1, Track o2)
    {
        String firstYear;
        String secondYear;
        
        if (o1.getTrackFile().getId3v1Tag() != null && o2.getTrackFile().getId3v1Tag() != null)
        {
            firstYear = o1.getTrackFile().getId3v1Tag().getYear();
            secondYear = o2.getTrackFile().getId3v1Tag().getYear();
        }
        else
        {
            firstYear = o1.getTrackFile().getId3v2Tag().getYear();
            secondYear = o2.getTrackFile().getId3v2Tag().getYear();
        }
        
        if (firstYear != null & secondYear != null)
        {
            return (firstYear.compareTo(secondYear));            
        }
        else
        {
            return 0;
        }
 
    }
    
}
