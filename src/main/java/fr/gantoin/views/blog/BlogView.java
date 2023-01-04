package fr.gantoin.views.blog;

import java.io.IOException;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import fr.gantoin.service.GistFetcher;
import fr.gantoin.views.MainLayout;

@PageTitle("Blog")
@Route(value = "", layout = MainLayout.class)
public class BlogView extends VerticalLayout {

    public BlogView() throws IOException {
        add(new H2("Articles"));
        GistFetcher.fetchTinyGist().forEach(
                gist -> {
                    // Articles
                    add(new Html("<hr>"));
                    Span title = new Span(gist.getDescription());
                    title.getStyle().set("font-weight", "bold");
                    title.getStyle().set("font-size", "1.2em");
                    title.getStyle().set("cursor", "pointer");
                    title.addClickListener(e -> {
                        // replace content of the page
                        UI.getCurrent().navigate("article/" + gist.getId());
                    });
                    add(title);
                    add(new Text(gist.getCreated_at()));
                });

        setJustifyContentMode(JustifyContentMode.START);
        setDefaultHorizontalComponentAlignment(Alignment.START);
        getStyle().set("text-align", "left");
    }
}
