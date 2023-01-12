package fr.gantoin.domain;

public class BoldParagraphWithPills extends BoldParagraph {

    public BoldParagraphWithPills(String text, TechnoPill... pills) {
        super(text);
        // padding left
        super.getStyle().set("padding-right", "1em");
        for (TechnoPill pill : pills) {
            add(pill.getPill());
        }
    }
}
