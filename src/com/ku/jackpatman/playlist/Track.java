package com.ku.jackpatman.playlist;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Track
{
    private File file;
    private Mp3File trackFile;

    public Track(File file)
    {
        this.file = file; 
        
        try
        {
            trackFile = new Mp3File(file.getAbsolutePath());
        } 
        catch (IOException | UnsupportedTagException | InvalidDataException ex)
        {
            Logger.getLogger(Track.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }

    public void renameFile(String newName)
    {
        File newFile = new File(this.file.getParent()+"\\"+newName);
        this.file.renameTo(newFile);
    }

    public void moveFile(String newDirectory)
    {
        File newFile = new File(newDirectory+"\\"+this.file.getName());
        newFile.mkdirs();
        
        this.file.renameTo(newFile);
    }

    public void deleteFile()
    {
       this.file.delete();
    }

    public void SaveChanges()
    {
        try
        {
            getTrackFile().save(this.file.getPath());
        } 
        catch (IOException | NotSupportedException e)
        {
            System.out.println("Exception encountered attempting to save track trackPath " + this.file.getPath()
                    + "exception was " + e.toString());
        }
    }

    public Mp3File getTrackFile()
    {
        return trackFile;
    }

    public void setTrackFile(Mp3File trackFile)
    {
        this.trackFile = trackFile;
    }
    
    public File getFile()
    {
        return file;
    }

    public void setFile(File file)
    {
        this.file = file;
    }
}
