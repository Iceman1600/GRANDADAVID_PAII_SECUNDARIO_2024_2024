package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiConnect {

        private static final String API_KEY = "89GWuTgZ8haoKBd08F5whIPB158xcIZmD6vfGT3l"; // Reemplaza con tu API key
        private static final String MARS_PHOTOS_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=" + API_KEY;
        private List<Photos> photoList = new ArrayList<>();

        public List<Photos> getPhotoList() {
            return photoList;
        }

        public void fetchMarsPhotos() throws Exception {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(MARS_PHOTOS_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            JSONArray photos = jsonResponse.getJSONArray("photos");

            for (int i = 0; i < photos.length(); i++) {
                JSONObject photo = photos.getJSONObject(i);
                Photos marsPhoto = new Photos(
                        photo.getInt("id"),
                        photo.getInt("sol"),
                        photo.getJSONObject("camera").getString("full_name"),
                        photo.getString("img_src"),
                        photo.getString("earth_date"),
                        photo.getJSONObject("rover").getString("name")
                );
                photoList.add(marsPhoto);
            }
        }
    }
