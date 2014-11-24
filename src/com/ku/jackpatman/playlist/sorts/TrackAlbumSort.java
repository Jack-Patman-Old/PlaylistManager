package com.ku.jackpatman.playlist.sorts;

import com.ku.jackpatman.playlist.Track;
import java.util.Comparator;

public class TrackAlbumSort implements Comparator<Track>
{
    @Override
    public int compare(Track o1, Track o2)
    {
        String firstAlbum;
        String secondAlbum;
        
        if (o1.getTrackFile().getId3v1Tag() != null && o2.getTrackFile().getId3v1Tag() != null)
        {
            firstAlbum = o1.getTrackFile().getId3v1Tag().getAlbum();
            secondAlbum = o2.getTrackFile().getId3v1Tag().getAlbum();
            
            return (firstAlbum.compareTo(secondAlbum));
        }
        else
        {
            firstAlbum = o1.getTrackFile().getId3v2Tag().getAlbum();
            secondAlbum = o2.getTrackFile().getId3v2Tag().getAlbum();
            
            return (firstAlbum.compareTo(secondAlbum));            
        }
 
    }
}
