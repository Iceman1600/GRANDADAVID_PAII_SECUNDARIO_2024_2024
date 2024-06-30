package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {


        public static List<Photos> filterByRoverName(List<Photos> photoList, String roverName) {
            return photoList.stream()
                    .filter(photo -> photo.getRoverName().toLowerCase().contains(roverName.toLowerCase()))
                    .collect(Collectors.toList());
        }

    public static List<Photos> filterById(List<Photos> photoList, int id) {
        return photoList.stream()
                .filter(photo -> photo.getId() == id)
                .collect(Collectors.toList());
    }

    public static List<Photos> filterBySol(List<Photos> photoList, int sol) {
        return photoList.stream()
                .filter(photo -> photo.getSol() == sol)
                .collect(Collectors.toList());
    }

    public static List<Photos> filterByCameraName(List<Photos> photoList, String cameraName) {
        return photoList.stream()
                .filter(photo -> photo.getCameraName().equalsIgnoreCase(cameraName))
                .collect(Collectors.toList());
    }



    public static List<Photos> filterByImgSrc(List<Photos> photoList, String imgSrc) {
        return photoList.stream()
                .filter(photo -> photo.getImgSrc().equalsIgnoreCase(imgSrc))
                .collect(Collectors.toList());
    }

    public static List<Photos> filterByEarthDate(List<Photos> photoList, String earthDate) {
        return photoList.stream()
                .filter(photo -> photo.getEarthDate().equalsIgnoreCase(earthDate))
                .collect(Collectors.toList());
    }


}


