package fr.gantoin.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TinyGist {
    private String id;
    private String url;
    private String description;
    private String created_at;
    private String updated_at;
}
