/*
 */
package gov.osti.doecode;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import gov.osti.doecode.entity.Identifier;

/**
 *
 * @author ensornl
 */
public class IdentifierModal extends Window {
    private NativeSelect identifierType = new NativeSelect("Identifier Type");
    private NativeSelect relationType = new NativeSelect("Relation Type");
    private TextField value = new TextField("Value");
    
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    
    private Identifier identifier;
    
    private MyUI ui;
    
    public IdentifierModal(MyUI ui) {
        this.ui = ui;
        
        FormLayout layout = new FormLayout();
        
        setCaption("Identifiers");
        
        layout.setSizeUndefined();
        
        identifierType.addItems(Identifier.identifierTypes);
        relationType.addItems(Identifier.relationTypes);
        
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        buttons.addComponents(save, delete);
        
        layout.addComponents(value, identifierType, relationType, buttons);
        layout.setMargin(true);
        
        setContent(layout);
        
        setModal(true);
        setResizable(false);
    }
    
    public void setIdentifier(Identifier id) {
        identifier = id;
        
        BeanFieldGroup.bindFieldsUnbuffered(id, this);
        
        ui.getCurrent().addWindow(this);
    }
}
