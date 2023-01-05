package fr.gantoin.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.gantoin.domain.CompleteGist;
import fr.gantoin.domain.TinyGist;

@Service
public class ArticleService {

    public void downloadArticles() throws IOException {
        List<TinyGist> tinyGists = GistFetcher.fetchTinyGist();
        tinyGists.forEach(tinyGist -> {
            try {
                CompleteGist completeGist = GistFetcher.fetchCompleteGist(tinyGist.getId());
                Path articlePath = Path.of("/tmp/" + tinyGist.getId());
                if (articlePath.toFile().exists()) {
                    return;
                }
                completeGist.setLocal_yaml_url(download(completeGist.getYaml_url(), articlePath.toFile().getAbsolutePath()));
                completeGist.setHtml_url(MarkdownConverter.convertToHtml(completeGist.getLocal_yaml_url(),
                        Path.of(articlePath.toFile().getAbsolutePath() + ".html")));
            } catch (IOException e) {
                throw new RuntimeException("Error while downloading article " + tinyGist.getId(), e);
            }
        });
    }

    public Path download(String url, String fileName) throws IOException {
        URL website = new URL(url);
        try (InputStream in = new BufferedInputStream(website.openStream());
                OutputStream out = new BufferedOutputStream(new FileOutputStream(fileName))) {
            for (int b; (b = in.read()) != -1;) {
                out.write(b);
            }
        }
        return Path.of(fileName);
    }
}
