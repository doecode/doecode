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
import gov.osti.doecode.entity.Agent;
import gov.osti.doecode.entity.AgentType;
import gov.osti.doecode.entity.AgentTypeSpecific;

/**
 *
 * @author ensornl
 */
public class AgentModal extends Window {
    private TextField firstName = new TextField("First");
    private TextField lastName = new TextField("Last");
    private NativeSelect agentTypeCode = new NativeSelect("Type");
    private NativeSelect agentTypeSpecific = new NativeSelect("Specific Type");
    private TextField email = new TextField("Email");
    private TextField affiliation = new TextField("Affiliation");
    private TextField orcid = new TextField("ORCID");
    
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    
    private Agent agent;
    private MyUI ui;
    
    public AgentModal(MyUI ui) {
        this.ui = ui;
        
        setCaption("Agent");
        
        FormLayout layout = new FormLayout();
        layout.setSizeUndefined();
        layout.setMargin(true);
        
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addComponents(save, delete);
        buttons.setSpacing(true);
        
        agentTypeCode.addItems(AgentType.values());
        agentTypeSpecific.addItems(AgentTypeSpecific.values());
        
        layout.addComponents(firstName, lastName, agentTypeCode, agentTypeSpecific,
                email, affiliation, orcid, buttons);
        
        setContent(layout);
        
        setModal(true);
        setResizable(false);
        
    }
    
    public void setAgent(Agent a) {
        agent = a;
        
        BeanFieldGroup.bindFieldsUnbuffered(a, this);
        
        ui.getCurrent().addWindow(this);
    }
}
