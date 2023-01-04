package fr.gantoin.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.gantoin.domain.CompleteGist;
import fr.gantoin.domain.TinyGist;

public class GistFetcher {

    private static final String GISTS_URL = "https://api.github.com/users/gantoin/gists";

    public static List<TinyGist> fetchTinyGist() throws IOException {
        List<TinyGist> gists = new ArrayList<>();
        URL url = new URL(GISTS_URL);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readValue(url, JsonNode.class);
        jsonNode.forEach(child -> {
            TinyGist tinyGist = new TinyGist();
            tinyGist.setId(child.get("id").asText());
            tinyGist.setUrl(child.get("url").asText());
            tinyGist.setDescription(child.get("description").asText());
            // format date from 2022-08-22T07:40:50Z to 2022/08/22
            String date = child.get("created_at").asText();
            String formattedDate = date.substring(0, 10).replace("-", "/");
            tinyGist.setCreated_at(formattedDate);
            tinyGist.setUpdated_at(child.get("updated_at").asText());
            gists.add(tinyGist);
        });
        return gists;
    }

    public static CompleteGist fetchCompleteGist(String id) throws IOException {
        String url = "https://api.github.com/gists/" + id;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readValue(new URL(url), JsonNode.class);
        JsonNode files = jsonNode.get("files");
        CompleteGist completeGist = new CompleteGist();
        completeGist.setTitle(files.fieldNames().next());
        completeGist.setYaml_url(files.get(completeGist.getTitle()).get("raw_url").asText());
        return completeGist;
    }
}
