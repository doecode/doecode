/*
 */
package gov.osti.doecode;

import com.vaadin.data.Validator;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import gov.osti.doecode.entity.Agent;

/**
 *
 * @author ensornl
 */
public class AgentForm extends FormLayout {
    private TextField firstName = new TextField("First");
    private TextField lastName = new TextField("Last");
    private TextField phoneNumber = new TextField("Phone");
    private NativeSelect agentTypeCode = new NativeSelect("Type");
    private NativeSelect agentTypeSpecific = new NativeSelect("Specific Type");
    private TextField email = new TextField("Email");
    private TextField affiliation = new TextField("Affiliation");
    private TextField orcid = new TextField("ORCID");
    
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    
    private Agent agent;
    private RepositoryForm parent;
    
    public AgentForm(RepositoryForm form) {
        this.parent = form;
        
        setSizeUndefined();
        
        GridLayout formContainer = new GridLayout(2,5);
        formContainer.setSpacing(true);
        
        agentTypeCode.addItems(Agent.agentTypes);
        agentTypeSpecific.addItems(Agent.specificTypes);
        
        Validator phoneValidator = new RegexpValidator("^((\\d{3}-|\\(\\d{3}\\)\\s?)?\\d{3}-|^\\d{3}(\\.)?\\d{3}\\3)\\d{4}$", "Please enter a valid phone number.");
        phoneNumber.addValidator(phoneValidator);
                
        formContainer.addComponent(firstName);
        formContainer.addComponent(lastName);
        formContainer.addComponent(agentTypeCode,0,1);
        formContainer.addComponent(agentTypeSpecific,1,1);
        formContainer.addComponent(email,0,2);
        formContainer.addComponent(affiliation,1,2);
        formContainer.addComponent(orcid,0,3);
        formContainer.addComponent(phoneNumber,1,3);
        
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        buttons.addComponents(save, delete);
        
        save.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        delete.setStyleName(ValoTheme.BUTTON_DANGER);
        
        save.setEnabled(false);
        delete.setEnabled(false);
        
        save.addClickListener(e->this.save());
        delete.addClickListener(e->this.delete());
        
        formContainer.addComponent(buttons, 0,4,1,4);
        
        addComponent(formContainer);
    }
    
    public void setAgent(Agent a) {
        this.agent = a;
        
        BeanFieldGroup.bindFieldsUnbuffered(a, this);
        
        if (a.isPersisted())
            delete.setEnabled(true);
        else
            delete.setEnabled(false);
        save.setEnabled(true);
    }
    
    public boolean save() {
        if (parent.add(agent)) {
            setAgent(new Agent());
            return true;
        }
        return false;
    }
    
    public boolean delete() {
        return parent.remove(agent);
    }
}
