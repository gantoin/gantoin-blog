package fr.gantoin.views.myresume;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;

import fr.gantoin.domain.BoldParagraph;

public class MyEnglishResume {

    public static Paragraph getEnglishExperiences() {
        Paragraph experience0 = new Paragraph();
        experience0.add(new BoldParagraph("JAVA/SQL Developer"));
        experience0.add(new Paragraph("SAP Concur - January 2022 to December 2022"));
        experience0.add(new UnorderedList(
                new ListItem("Java development on a web application for travel management and allowances"),
                new ListItem("PL/SQL functions, procedures and scripts to update data in an Oracle database"),
                new ListItem("Ext JS and SCSS development for front-end rework")
        ));
        Paragraph experience1 = new Paragraph();
        experience1.add(new Hr());
        experience1.add(new BoldParagraph("Back-end developer"));
        experience1.add(new Paragraph("DoubleTrade - July 2019 to January 2022"));
        experience1.add(new UnorderedList(
                new ListItem("Java 11, micro-services architecture, Apache Kafka, Spring Cloud, Docker, continuous integration with GitLab CI"),
                new ListItem("Scrum, code review/pair-programming, Pull/Merge requests"),
                new ListItem("Development of new APIs for a SaaS business intelligence application on public markets in France")
        ));
        Paragraph experience2 = new Paragraph();
        experience2.add(new Hr());
        experience2.add(new BoldParagraph("Full Stack Developer"));
        experience2.add(new Paragraph("Wemoov - April 2019 to June 2019"));
        experience2.add(new UnorderedList(
                new ListItem("Development of a back-office and APIs for video editing with FFmpeg using JHipster with Java, AngularJS, SQL, Jenkins and Git")
        ));
        Paragraph experience3 = new Paragraph();
        experience3.add(new Hr());
        experience3.add(new BoldParagraph("Web Developer"));
        experience3.add(new Paragraph("Ministry of Justice - January 2018 to August 2018"));
        experience3.add(new UnorderedList(
                new ListItem("Development of a Java 8 backend"),
                new ListItem("Training and development of Angular for the frontend of the applications"),
                new ListItem("Docker for the deployment of the applications")
        ));
        Paragraph education = new Paragraph();
        education.add(new Hr());
        education.add(new H2("Education"));
        education.add(new BoldParagraph("Professional degree in computer systems and software"));
        education.add(new Paragraph("Nantes (France) University (2016 - 2017)"));
        education.add(new BoldParagraph("Advanced Technician's Certificate"));
        education.add(new UnorderedList(
                new ListItem("La Colinière High school (2014 - 2016)"),
                new ListItem("IT services for organizations option B software solutions and business applications")
        ));
        return new Paragraph(experience0, experience1, experience2, experience3, education);
    }
}
