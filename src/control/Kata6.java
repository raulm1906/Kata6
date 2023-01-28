package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.joining;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import model.*;

public class Kata6 {

    public static void main(String[] args) throws MalformedURLException, IOException, JAXBException {
        URL url = new URL("https://dummyjson.com/posts");
        
        List<Post> posts = new ArrayList<>();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        JsonArray json = gson.fromJson(read(url), JsonObject.class).get("posts").getAsJsonArray();
                
        for (JsonElement jsonElement : json) {
            Post post = gson.fromJson(jsonElement, Post.class);
            posts.add(post);
        }
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Post.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        for (Post post: posts) jaxbMarshaller.marshal(post, System.out);
    }
    
    private static String read(URL url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(joining());
        }
    }
}