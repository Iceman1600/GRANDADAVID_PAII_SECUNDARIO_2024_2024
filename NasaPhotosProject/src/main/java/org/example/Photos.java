package org.example;

public class Photos {
    private int id;
    private int sol;
    private String cameraName;
    private String imgSrc;
    private String earthDate;
    private String roverName;

    public Photos(int id, int sol, String cameraName, String imgSrc, String earthDate, String roverName) {
        this.id = id;
        this.sol = sol;
        this.cameraName = cameraName;
        this.imgSrc = imgSrc;
        this.earthDate = earthDate;
        this.roverName = roverName;
    }

    public int getId() {
        return id;
    }

    public int getSol() {
        return sol;
    }

    public String getCameraName() {
        return cameraName;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public String getRoverName() {
        return roverName;
    }


    @Override
    public String toString() {
        return "ID: " + id + "\nSol: " + sol + "\nCamera: " + cameraName + "\nImg Src: " + imgSrc + "\nEarth Date: " + earthDate + "\nRover: " + roverName + "\n";
    }
}
