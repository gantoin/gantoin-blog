package fr.gantoin.views.contactme;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import fr.gantoin.views.MainLayout;

@PageTitle("Contact me")
@Route(value = "contact", layout = MainLayout.class)
public class ContactMeView extends VerticalLayout {
    @Email
    @NotEmpty
    private String email = "";

    @NotEmpty
    private String name = "";

    @NotEmpty
    private String message = "";

    public ContactMeView() {
        FormLayout form = new FormLayout();
        form.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("31em", 1));

        TextField nameField = new TextField();
        nameField.setValueChangeMode(ValueChangeMode.EAGER);
        nameField.setRequired(true);
        nameField.setInvalid(false);
        nameField.setErrorMessage("Please enter your name");
        nameField.addValueChangeListener(e -> name = e.getValue());
        form.addFormItem(nameField, "Name");

        TextField emailField = new TextField();
        emailField.setValueChangeMode(ValueChangeMode.EAGER);
        emailField.setRequired(true);
        emailField.setInvalid(false);
        emailField.setErrorMessage("Please enter a valid email address");
        emailField.addValueChangeListener(e -> email = e.getValue());
        form.addFormItem(emailField, "Email");

        TextArea messageField = new TextArea();
        messageField.setValueChangeMode(ValueChangeMode.EAGER);
        messageField.setRequired(true);
        messageField.setInvalid(false);
        messageField.setErrorMessage("Please enter your message");
        messageField.addValueChangeListener(e -> message = e.getValue());
        form.addFormItem(messageField, "Message");

        Button submit = new Button("Send message");
        submit.addClickListener(e -> System.out.println("Sending message to " + email + " from " + name + " with message: " + message));
        form.addFormItem(submit, "");

        add(form);
    }
}
