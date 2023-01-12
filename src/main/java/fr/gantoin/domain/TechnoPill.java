package fr.gantoin.domain;

import com.vaadin.flow.component.html.Span;

import lombok.Getter;

@Getter
public class TechnoPill {

    private final Span pill;

    public TechnoPill(String name, TechnoPillColorEnum color) {
        Span pill = new Span(name);
        pill.getElement().getThemeList().add("badge pill");
        pill.getElement().getStyle().set("background-color", color.getColor());
        pill.getElement().getStyle().set("color", "white");
        pill.getElement().getStyle().set("font-weight", "bold");
        pill.getElement().getStyle().set("margin", "0 0.25em");
        this.pill = pill;
    }

}
