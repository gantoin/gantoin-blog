package fr.gantoin.views;


import java.util.Random;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.BoxSizing;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FlexDirection;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Height;
import com.vaadin.flow.theme.lumo.LumoUtility.ListStyleType;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Overflow;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;
import com.vaadin.flow.theme.lumo.LumoUtility.Whitespace;
import com.vaadin.flow.theme.lumo.LumoUtility.Width;

import fr.gantoin.views.blog.BlogView;
import fr.gantoin.views.contactme.ContactMeView;
import fr.gantoin.views.myprojects.MyProjectsView;
import fr.gantoin.views.myresume.MyResumeView;
import fr.gantoin.views.twitter.TwitterView;

public class MainLayout extends AppLayout {

    public static class MenuItemInfo extends ListItem {
        private final Class<? extends Component> view;

        public MenuItemInfo(String menuTitle, String iconClass, Class<? extends Component> view) {
            this.view = view;
            RouterLink link = new RouterLink();
            link.addClassNames(Display.FLEX, Gap.XSMALL, Height.MEDIUM, AlignItems.CENTER, Padding.Horizontal.SMALL, TextColor.BODY);
            link.setRoute(view);
            Span text = new Span(menuTitle);
            text.addClassNames(FontWeight.MEDIUM, FontSize.MEDIUM, Whitespace.NOWRAP);
            link.add(new LineAwesomeIcon(iconClass), text);
            add(link);
        }

        public Class<?> getView() {
            return view;
        }

        @NpmPackage(value = "line-awesome", version = "1.3.0")
        public static class LineAwesomeIcon extends Span {
            public LineAwesomeIcon(String lineAwesomeClassnames) {
                // Use Lumo classnames for suitable font styling
                addClassNames(FontSize.LARGE, TextColor.SECONDARY);
                if (!lineAwesomeClassnames.isEmpty()) {
                    addClassNames(lineAwesomeClassnames);
                }
            }
        }
    }

    public MainLayout() {
        addToNavbar(createHeaderContent());
    }

    private Component createHeaderContent() {
        Header header = new Header();
        header.addClassNames(BoxSizing.BORDER, Display.FLEX, FlexDirection.COLUMN, Width.FULL);
        Div layout = new Div();
        layout.addClassNames(Display.FLEX, AlignItems.CENTER, Padding.Horizontal.LARGE);
        String[] emojis = {"????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????",
                "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????",
                "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????",
                "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????",
                "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????",
                "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????", "????"};
        String randomEmoji = emojis[new Random().nextInt(emojis.length)]
                + emojis[new Random().nextInt(emojis.length)]
                + emojis[new Random().nextInt(emojis.length)]
                + emojis[new Random().nextInt(emojis.length)]
                + emojis[new Random().nextInt(emojis.length)];
        H1 appName = new H1(randomEmoji + " Antoine Gauthier (");
        Span gantoin = new Span("@gantoin");
        gantoin.addClassNames(TextColor.PRIMARY, FontSize.LARGE, FontWeight.BOLD);
        gantoin.addClickListener(e -> getUI().ifPresent(ui -> ui.getPage().executeJs("window.open('https://github.com/gantoin', '_blank')")));
        appName.add(gantoin);
        appName.add(") - Blog");
        appName.addClassNames(Margin.Vertical.MEDIUM, Margin.End.AUTO, FontSize.LARGE);
        layout.add(appName);
        Nav nav = new Nav();
        nav.addClassNames(Display.FLEX, Overflow.AUTO, Padding.Horizontal.MEDIUM, Padding.Vertical.XSMALL);
        UnorderedList list = new UnorderedList();
        list.addClassNames(Display.FLEX, Gap.SMALL, ListStyleType.NONE, Margin.NONE, Padding.NONE);
        nav.add(list);
        for (MenuItemInfo menuItem : createMenuItems()) {
            list.add(menuItem);
        }
        header.add(layout, nav);
        return header;
    }

    private MenuItemInfo[] createMenuItems() {
        return new MenuItemInfo[]{ //
                new MenuItemInfo("Blog", "la la-greater-than", BlogView.class), //
                new MenuItemInfo("Twitter", "lab la-twitter", TwitterView.class), //
                new MenuItemInfo("My resume", "la la-file-download", MyResumeView.class), //
                new MenuItemInfo("My Projects", "la la-drafting-compass", MyProjectsView.class), //
                new MenuItemInfo("Contact me", "la la-mail-bulk", ContactMeView.class), //
        };
    }
}
