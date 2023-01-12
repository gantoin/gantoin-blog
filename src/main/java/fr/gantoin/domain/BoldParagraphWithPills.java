package fr.gantoin.domain;

import com.vaadin.flow.component.html.Div;

public class BoldParagraphWithPills extends BoldParagraph {

    public BoldParagraphWithPills(String text, TechnoPill... pills) {
        super(text);
        Div div = new Div();
        for (TechnoPill pill : pills) {
            div.add(pill.getPill());
        }
        div.getStyle().set("display", "initial");
        div.getStyle().set("margin-left", "1em");
        this.add(div);
    }
}
