package com.ku.jackpatman.playlist;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Track
{
    /* One inherent issue of allowing the track to keep a reference to its file 
     is that we must remember to manually update the reference in line with most 
     operations.    */

    private File file;
    private Mp3File trackFile;

    public Track(File file)
    {
        this.file = file;

        try
        {
            trackFile = new Mp3File(file.getAbsolutePath());
        } catch (IOException | UnsupportedTagException | InvalidDataException ex)
        {
            System.out.println("Exception encountered loading MP3 file, exception was" + ex.toString());
        }
    }

    public void renameFile(String newName)
    {
        try
        {
            String newPath = this.file.getParent() + "\\" + newName;
            Path originalPath = this.file.toPath();
            Path path = Paths.get(newPath);

            Files.move(originalPath, path);
            this.file = new File(newPath);
        } catch (IOException ex)
        {
            System.out.println("Exception encountered renaming MP3 file, exception was " + ex.toString());
        }
    }

    public void moveFile(String newDirectory)
    {
        // Make path before populating it
        File newFile = new File(newDirectory + "\\" + this.file.getName());
        newFile.getParentFile().mkdirs();

        try
        {
            String newPath = newDirectory + "\\" + this.file.getName();
            Path originalPath = this.file.toPath();
            Path path = Paths.get(newPath);

            Files.move(originalPath, path);

            this.file = new File(newPath);

        } catch (IOException ex)
        {
            System.out.println("Exception encountered renaming MP3 file, exception was " + ex.toString());
        }
    }

    public void deleteFile()
    {
        this.file.delete();
    }

    public void SaveChanges()
    {
        try
        {
            String path = this.file.getPath();

            getTrackFile().save(path + ".temp");
            File oldFile = new File(path);
            oldFile.delete();

            File newFile = new File(path + ".temp");
            newFile.renameTo(new File(path));

        } catch (IOException | NotSupportedException e)
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

    public Map<MetadataType, String> getTrackMetadata()
    {
        Map<MetadataType, String> trackMetadata = new HashMap<>();

        if (trackFile != null)
        {
            if (trackFile.hasId3v1Tag())
            {
                ID3v1 tag = trackFile.getId3v1Tag();
                trackMetadata.put(MetadataType.ALBUM, tag.getAlbum());
                trackMetadata.put(MetadataType.ARTIST, tag.getArtist());
                trackMetadata.put(MetadataType.TITLE, tag.getTitle());
                trackMetadata.put(MetadataType.GENRE, tag.getGenreDescription());
                trackMetadata.put(MetadataType.YEAR, tag.getYear());
            } else if (trackFile.hasId3v2Tag())
            {
                ID3v2 tag = trackFile.getId3v2Tag();
                trackMetadata.put(MetadataType.ALBUM, tag.getAlbum());
                trackMetadata.put(MetadataType.ARTIST, tag.getArtist());
                trackMetadata.put(MetadataType.TITLE, tag.getTitle());
                trackMetadata.put(MetadataType.GENRE, tag.getGenreDescription());
                trackMetadata.put(MetadataType.YEAR, tag.getYear());
            }
        }

        return trackMetadata;
    }

    public void setTrackMetadata(Map<MetadataType, String> trackData)
    {
        if (trackFile != null)
        {
            if (trackFile.hasId3v1Tag())
            {
                ID3v1 tag = trackFile.getId3v1Tag();
                tag.setAlbum(trackData.get(MetadataType.ALBUM));
                tag.setArtist(trackData.get(MetadataType.ARTIST));
                tag.setTitle(trackData.get(MetadataType.TITLE));
                tag.setYear(trackData.get(MetadataType.YEAR));
            } 
            else if (trackFile.hasId3v2Tag())
            {
                ID3v2 tag = trackFile.getId3v2Tag();
                tag.setAlbum(trackData.get(MetadataType.ALBUM));
                tag.setArtist(trackData.get(MetadataType.ARTIST));
                tag.setTitle(trackData.get(MetadataType.TITLE));
                tag.setYear(trackData.get(MetadataType.YEAR));
            }
        }
    }
}
