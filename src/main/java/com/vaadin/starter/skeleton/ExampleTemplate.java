package com.vaadin.starter.skeleton;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.starter.skeleton.ExampleTemplate.ExampleModel;

/**
 * Simple template example.
 */
@Tag("example-template")
@HtmlImport("src/example-template.html")
public class ExampleTemplate extends PolymerTemplate<ExampleModel> {

    /**
     * Template model which defines the single "value" property.
     */
    public interface ExampleModel extends TemplateModel {

        String getValue();

        void setValue(String value);
    }

    @Id("btn")
    private Button btn;

    public ExampleTemplate(String name) {
        // Set the initial value to the "value" property.
        getModel().setValue(name);

        btn.setText("BTN");
    }

    public void changeBtnNameAndValue() {
        btn.setText(btn.getText() + " 1");
        getModel().setValue(getModel().getValue() + " Changed!");
    }

}
