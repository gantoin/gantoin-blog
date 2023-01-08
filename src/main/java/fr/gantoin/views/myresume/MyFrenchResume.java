package fr.gantoin.views.myresume;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;

import fr.gantoin.domain.BoldParagraph;

public class MyFrenchResume {

    public static Paragraph getFrenchExperiences() {
        Paragraph experience = new Paragraph();
        experience.add(new BoldParagraph("Développeur Java/SQL"));
        experience.add(new Paragraph("SAP Concur - Janvier 2022 à Décembre 2022"));
        experience.add(new BoldParagraph("Projet :"), new ListItem("Développement d’une application de gestion de déménagements et d'indemnités"));
        experience.add(new BoldParagraph("Missions :"),
                new ListItem("Évolutions d'un backend Java 11 monolithique sous Spring Boot"),
                new ListItem("Tests unitaires, pipelines et déploiement continue de jobs Jenkins via le GitHub interne de SAP"),
                new ListItem("Modifications mineures sur un Front-End Sencha Ext JS et SCSS"),
                new ListItem("Développement de procédures stockées et déclencheurs en PL/SQL sur des bases de données Oracle"),
                new ListItem("Revue de code, refactoring de code historique, upgrade de version de librairies Java, SonarQube"),
                new ListItem("Modification d'un outil Python interne qui interagit avec les APIs GitHub et Jira Confluence"),
                new ListItem("Méthodologie agile : daily meeting sur Slack, gestion de tickets sous Jira, sprint de 2 semaines avec release et mise en recette"),
                new ListItem("Environnement technique : Java 11, Git, Framework Spring, Spring Boot, SonarQube, Python 3.9, GitHub, Jenkins, PL/SQL, BDD Oracle, Sencha Ext JS")
        );
        Paragraph experience2 = new Paragraph();
        experience2.add(new Hr());
        experience2.add(new BoldParagraph("Développeur Backend"));
        experience2.add(new Paragraph("Doubletrade - Juillet 2019 à Janvier 2022"));
        experience2.add(new BoldParagraph("Projet :"), new ListItem("SaaS de veille et étude de marchés publics"));
        experience2.add(new BoldParagraph("Missions :"),
                new ListItem("Création de nouvelles features sur un backend Java 11 en architecture micro-services :"),
                new UnorderedList(
                        new ListItem("+40 micro-services Spring Boot orchestrés par un cluster Kubernetes"),
                        new ListItem("Création d’APIs RESTFul pour l’équipe frontend (documentation Swagger)"),
                        new ListItem("Appels synchrones entre micro-services avec Spring Cloud OpenFeign")),
                new ListItem("Utilisation d’Apache Kafka pour la consommation et production de messages asynchrones (imports de données de plusieurs sources différentes)"),
                new ListItem("Optimisation et gestion de BDD PostgreSQL : création d’indexes, nettoyage de données avec Spring Batch, gestion de structure de BDD avec liquibase"),
                new ListItem("Découverte et utilisation d'outils comme : AWS, Spring Cloud, Hibernate, Docker et les outils d’intégration continue de GitLab"),
                new ListItem("Tests unitaires avec JUnit, Mocks et AssertJ"),
                new ListItem("Test d’intégration avec @SpringBootTest et base de données en mémoire H2"),
                new ListItem("Méthodologie Scrum avec cérémonies : Sprint Planning Meeting, Melee, Demo, Retro, Backlog Review"),
                new ListItem("Attention particulière à la qualité du code produit avec : SonarQube, review de code/pair-programming, workflow de Pull/Merge requests inspiré de l’Open Source"),
                new ListItem("Environnement technique : Amazon Web Services, Representational State Transfer (REST), Spring framework (Spring Cloud, Spring Boot), ElasticSearch, liquibase, Swagger")
        );
        Paragraph experience3 = new Paragraph();
        experience3.add(new Hr());
        experience3.add(new BoldParagraph("Développeur Full Stack"));
        experience3.add(new Paragraph("Wemoov - Avril 2019 à Juillet 2019"));
        experience3.add(new BoldParagraph("Projet :"), new ListItem("Développements et conception d'une application mobile au sein du pôle recherche et développement"));
        experience3.add(new BoldParagraph("Missions :"),
                new ListItem("Modification d'un back-office sous JHipser (Java/Angular)"),
                new ListItem("Développement d'APIs pour du montage vidéo avec ffmpeg"),
                new ListItem("Consommation d’APIs Rest par une application Flutter"),
                new ListItem("Environnement technique : JHipster, Java 11, Angular, Spring Boot, Git, Jenkins, ffmpeg, Flutter")
        );
        Paragraph experience4 = new Paragraph();
        experience4.add(new Hr());
        experience4.add(new BoldParagraph("Développeur Web"));
        experience4.add(new Paragraph("Ministère de la Justice - Janvier 2018 à Août 2018"));
        experience4.add(new BoldParagraph("Projet :"), new ListItem("Refonte d’applications internes, collecte de données des administrations pour produire des statistiques"));
        experience4.add(new BoldParagraph("Missions :"),
                new ListItem("Développement d'un backend Java 8"),
                new ListItem("Formation et développement Angular pour le frontend des applications"),
                new ListItem("Formation Docker"),
                new ListItem("Environnement technique : Java 8, Hibernate, JPA, Angular, Docker, MySQL")
        );
        Paragraph education = new Paragraph();
        education.add(new Hr());
        education.add(new H2("Diplômes"));
        education.add(new BoldParagraph("Licence professionnelle Développement Web et Mobile"));
        education.add(new Paragraph("UIT de Nantes (2016 - 2017)"));
        education.add(new BoldParagraph("BTS SIO option SLAM"));
        education.add(new Paragraph("Lycée La Colinière (2014 - 2016)"));
        return new Paragraph(experience, experience2, experience3, experience4, education);
    }
}
