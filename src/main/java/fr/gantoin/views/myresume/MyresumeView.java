package fr.gantoin.views.myresume;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import fr.gantoin.domain.BoldParagraph;
import fr.gantoin.views.MainLayout;

@PageTitle("My resume")
@Route(value = "resume", layout = MainLayout.class)
public class MyresumeView extends VerticalLayout {

    public MyresumeView() {
        setSpacing(false);

        add(new H2("Experiences"));

        add(new BoldParagraph("JAVA/SQL Developer"));
        add(new Paragraph("SAP Concur - Since January 2022"));

        add(new UnorderedList(
                new ListItem("Java development on a web application for travel management and allowances"),
                new ListItem("PL/SQL functions, procedures and scripts to update data in an Oracle database"),
                new ListItem("Ext JS and SCSS development for front-end rework")
        ));

        add(new BoldParagraph("Back-end developer"));
        add(new Paragraph("DoubleTrade - July 2019 to January 2022"));
        add(new UnorderedList(
                new ListItem("Java 11, micro-services architecture, Apache Kafka, Spring Cloud, Docker, continuous integration with GitLab CI"),
                new ListItem("Scrum, code review/pair-programming, Pull/Merge requests"),
                new ListItem("Development of new APIs for a SaaS business intelligence application on public markets in France")
        ));

        add(new BoldParagraph("Full Stack Developer"));
        add(new Paragraph("Wemoov - April 2019 to June 2019"));
        add(new UnorderedList(
                new ListItem("Development of a back-office and APIs for video editing with FFmpeg using JHipster with Java, AngularJS, SQL, Jenkins and Git")
        ));

        add(new H2("Education"));
        add(new BoldParagraph("Professional degree in computer systems and software"));
        add(new Paragraph("Nantes (France) University (2016 - 2017)"));
        add(new BoldParagraph("Advanced Technician's Certificate"));
        add(new UnorderedList(
                new ListItem("La Colinière High school (2014 - 2016)"),
                new ListItem("IT services for organizations option B software solutions and business applications")
        ));

        add(new Button("Download my resume", e -> {
            getUI().ifPresent(ui -> ui.getPage().executeJavaScript("window.open('documents/cv-antoine-compressed.pdf', '_blank')"));
        }));

        setJustifyContentMode(JustifyContentMode.START);
        setDefaultHorizontalComponentAlignment(Alignment.START);
        getStyle().set("text-align", "left");
    }

}
