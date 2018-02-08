package com.vaadin.starter.skeleton;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * The main view contains a button and a template element.
 */
@BodySize(height = "100vh", width = "100vw")
@HtmlImport("styles/shared-styles.html")
@Route("")
@Theme(Lumo.class)
public class MainView extends VerticalLayout {

    public MainView() {
        Dialog dialog = new Dialog();
        add(dialog);

        Button button = new Button("Open dialog", event -> dialog.open());

        add(button);
        setClassName("main-layout");

        ExampleTemplate template1 = new ExampleTemplate("FIRST");
        ExampleTemplate template2 = new ExampleTemplate("SECOND");
        template2.setVisible(false);
     //   template1.setVisible(false);
        Checkbox check = new Checkbox("Show 2nd template");
        dialog.add(check, template1, template2);
        check.addValueChangeListener(e -> {
            template1.setVisible(!e.getValue());
            template2.setVisible(e.getValue());

            template1.changeBtnNameAndValue();
            template2.changeBtnNameAndValue();
        });

     //   dialog.open();
    }
}
