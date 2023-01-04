package fr.gantoin.domain;

import java.nio.file.Path;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CompleteGist extends TinyGist {
    private String title;
    private Path html_url;
    private String yaml_url;
    private Path local_yaml_url;
}
