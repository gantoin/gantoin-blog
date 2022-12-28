package fr.gantoin.domain;

import com.vaadin.flow.component.html.Paragraph;

public class BoldParagraph extends Paragraph {

    public BoldParagraph(String text) {
        super(text);
        this.getStyle().set("font-weight", "bold");
    }
}
