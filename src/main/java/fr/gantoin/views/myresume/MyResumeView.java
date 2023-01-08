package fr.gantoin.views.myresume;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import fr.gantoin.views.MainLayout;

@PageTitle("My resume")
@Route(value = "resume", layout = MainLayout.class)
public class MyResumeView extends VerticalLayout {

    public MyResumeView() {
        setSpacing(false);
        addEnglishContent();
        setJustifyContentMode(JustifyContentMode.START);
        setDefaultHorizontalComponentAlignment(Alignment.START);
        getStyle().set("text-align", "left");
    }

    private void addLanguagesButton() {
        HorizontalLayout languages = new HorizontalLayout();
        Button en = new Button("🇬🇧");
        en.addClickListener(e -> {
            removeAll();
            addEnglishContent();
        });
        Button fr = new Button("🇫🇷");
        fr.addClickListener(e -> {
            removeAll();
            addFrenchContent();
        });
        languages.add(en, fr);
        add(languages);
    }

    private void addFrenchContent() {
        addLanguagesButton();
        add(new H2("💼 Expériences professionnelles"));
        add(MyFrenchResume.getFrenchExperiences());
    }

    private void addEnglishContent() {
        addLanguagesButton();
        add(new H2("💼 Experiences"));
        add(MyEnglishResume.getEnglishExperiences());
        add(new Button("Download my resume", e -> getUI().ifPresent(ui -> ui.getPage().executeJs("window.open('documents/cv-antoine-compressed.pdf', '_blank')"))));
    }

}
