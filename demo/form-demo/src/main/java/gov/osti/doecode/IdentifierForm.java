/*
 */
package gov.osti.doecode;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import gov.osti.doecode.entity.Identifier;

/**
 *
 * @author ensornl
 */
public class IdentifierForm extends VerticalLayout {
    private NativeSelect identifierType = new NativeSelect("Identifier Type");
    private NativeSelect relationType = new NativeSelect("Relation Type");
    private TextField value = new TextField("Value");
    
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    
    private Identifier identifier;
    
    private RepositoryForm parent;
    
    public IdentifierForm(RepositoryForm form) {
        this.parent = form;
        
        setSizeUndefined();
        setSpacing(true);
        
        setEnabled(false);
        // load the drop-down values
        identifierType.addItems(Identifier.identifierTypes);
        relationType.addItems(Identifier.relationTypes);
        
        // set up a layout for the form buttons
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        buttons.addComponents(save, delete);
        save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        save.addClickListener(e->this.save());
        delete.setStyleName(ValoTheme.BUTTON_DANGER);
        delete.addClickListener(e->this.delete());
        
        // disable functionality until needed
        save.setEnabled(false);
        delete.setEnabled(false);
        
        addComponents(value, identifierType, relationType, buttons);
    }
    
    public void setIdentifier(Identifier id) {
        this.identifier = id;
        
        BeanFieldGroup.bindFieldsUnbuffered(id, this);
        
        save.setEnabled(true);
        delete.setEnabled(id.isPersisted());
        
        setVisible(true);
        setEnabled(true);
        
        value.selectAll();
    }
    
    private boolean save() {
        if ( parent.add(identifier) ) {
            setIdentifier(new Identifier());
            return true;
        }
        return false;
    }
    
    private boolean delete() {
        if ( parent.remove(identifier) ) {
            setIdentifier(new Identifier());
            return true;
        }
        return false;
    }
}
