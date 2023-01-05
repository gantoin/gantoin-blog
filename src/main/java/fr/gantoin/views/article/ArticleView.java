package fr.gantoin.views.article;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import fr.gantoin.views.MainLayout;


@PageTitle("Test")
@Route(value = "article", layout = MainLayout.class)
public class ArticleView extends VerticalLayout implements HasUrlParameter<String> {

    public ArticleView() {
        setSpacing(false);
        add(new Button("← Back to articles", e -> UI.getCurrent().navigate("")));
        setJustifyContentMode(JustifyContentMode.START);
        setDefaultHorizontalComponentAlignment(Alignment.START);
        getStyle().set("text-align", "left");
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        String htmlFile = String.format("/tmp/%s.html", parameter);
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(htmlFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
        Html html = new Html(inputStream);
        add(html);
    }
}
