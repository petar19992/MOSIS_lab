package myplaces.modis.elfak.edu.myplaces;

/**
 * Created by Petar on 3/30/2015.
 */
public class MyPlace {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getLongitude() {
        return longitude;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    long ID;
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    String longitude;
    String latitude;
    String filename;

    public void setDescription(String description) {
        this.description = description;
    }

    String name;
    String description;

    public MyPlace(String n,String d)
    {
        name=n;
        description=d;
    }

    @Override
    public String toString() {
        return name;
    }


}
