/*
 */
package gov.osti.doecode;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.UserError;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;
import com.vaadin.ui.themes.ValoTheme;
import gov.osti.doecode.connectors.github.Reader;
import gov.osti.doecode.entity.Agent;
import gov.osti.doecode.entity.Identifier;
import gov.osti.doecode.entity.SoftwareRepository;
import java.io.IOException;
import java.util.List;

/**
 * the basic UI/Form for editing software metadata.
 * 
 * Extends and implements FormLayout for styling.  Attributes should be named
 * the same as corresponding values in the underlying Bean object (SoftwareRepository).
 * 
 * @author ensornl
 */
public class RepositoryForm extends FormLayout {
    private TextField siteOwnershipCode = new TextField("Site");
    private CheckBox openSource = new CheckBox("Open Source?");
    private TextField name = new TextField("Title/Name");
    private TextField acronym = new TextField("Acronym");
    private TextField url = new TextField("URL");
    private TextField doi = new TextField("DOI");
    private NativeSelect countryCode = new NativeSelect("Country");
    private TextField keywords = new TextField("Keywords");
    private TextField rights = new TextField("Rights/Disclaimers");
    private TextField license = new TextField("License");
    private TextField operatingSystem = new TextField("Operating System");
    private TextField siteAccessionNumber = new TextField("Site Accession Number");
    private TextArea otherRequirements = new TextArea("Other Requirements");
    private TextArea description = new TextArea("Description");
    // display items for child tables
    private Grid agentGrid = new Grid("");
    private Grid idGrid = new Grid("");
    
    private Button loadButton = new Button("Load");
    
    private Button save = new Button("Save");
    private MyUI ui;
    
    private SoftwareRepository repository = new SoftwareRepository();
    
    private AgentForm agentForm;
    private IdentifierForm idForm;
    
    // a static listing of Country Codes for drop down
    public static final String[] countryCodes = {
        "US", "FR", "GB", "DE", "ES"
    };
    
    /**
     * Pass through to add Identifier Objects to the software metadata.
     * @param id the Identifier to add
     * @return true if something was added, false if not
     */
    public boolean add(Identifier id) {
        if (repository.add(id)) {
            updateIdentifierList();
            return true;
        }
        return false;
    }
    
    /**
     * Remove a given Identifier from the list.
     * @param id the Identifier to remove
     * @return true if something changed, false if not
     */
    public boolean remove(Identifier id) {
        if (repository.remove(id)) {
            updateIdentifierList();
            return true;
        }
        return false;
    }
    
    /**
     * Add an Agent to the software list.
     * 
     * @param a the Agent to add
     * @return true if changes took place, false if not
     */
    public boolean add(Agent a) {
        if (repository.add(a)) {
            updateAgentList();
            return true;
        }
        return false;
    }
    
    /**
     * Remove an Agent from the list
     * @param a the Agent to remove
     * @return true if something changed, false if not
     */
    public boolean remove(Agent a) {
        if (repository.remove(a)) {
            updateAgentList();
            return true;
        }
        return false;
    }
    
    /**
     * Update/paint the agent Grid.
     */
    private void updateAgentList() {
        List<Agent> agents = repository.getAgents();
        agentGrid.setContainerDataSource(new BeanItemContainer<>(Agent.class, agents));
        agentGrid.markAsDirty();
    }
    
    /**
     * Reset the identifier list/grid.
     */
    private void updateIdentifierList() {
        List<Identifier> identifiers = repository.getIdentifiers();
        idGrid.setContainerDataSource(new BeanItemContainer<>(Identifier.class, identifiers));
        idGrid.markAsDirty();
    }
    
    /**
     * Create a basic form UI for editing software metadata information.
     * 
     * @param ui link to the MyUI parent UI
     */
    public RepositoryForm(MyUI ui) {
        this.ui = ui;
        
        setSizeUndefined();
        
        agentGrid.setColumns("firstName", "lastName", "email");
        agentGrid.setHeightMode( HeightMode.ROW );
        agentGrid.setHeightByRows(8);
        
        idGrid.setColumns("relationType", "identifierType", "value");
        idGrid.setHeightMode( HeightMode.ROW );
        idGrid.setHeightByRows(8);
        
        idForm = new IdentifierForm(this);
        agentForm = new AgentForm(this);
        
        TabSheet tabs = new TabSheet();
        tabs.addStyleName(ValoTheme.TABSHEET_FRAMED);
        tabs.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
        
        addComponent(tabs);
        
        HorizontalLayout main = new HorizontalLayout();
        main.setSpacing(true);
        main.setMargin(true);
        
        FormLayout left = new FormLayout();
        FormLayout right = new FormLayout();
        
        countryCode.addItems(countryCodes);
        
        left.addComponents(url, loadButton, name, openSource, siteOwnershipCode,
                acronym, doi, countryCode);
        right.addComponents(keywords, rights, license, operatingSystem,
                siteAccessionNumber, otherRequirements);
        
        loadButton.addClickListener(e->{
            try {
                SoftwareRepository repo = Reader.loadRepository("doecode");
                
                setSoftwareRepository(repo);
                
            } catch ( IOException ex ) {
                setComponentError(new UserError("Unable to load: " + ex.getMessage()));
            }
        });
        
        main.addComponents(left, right);
        
        tabs.addTab(main, "Metadata");
        
        Button agentAddButton = new Button("New");
        agentAddButton.setStyleName(BaseTheme.BUTTON_LINK);
        agentAddButton.setIcon(FontAwesome.PLUS);
        
        agentAddButton.addClickListener(e-> {
            agentForm.setAgent(new Agent());
        });
        
        VerticalLayout innerAgent = new VerticalLayout(agentAddButton, agentGrid);
        innerAgent.setSizeUndefined();
        HorizontalLayout agentLayout = new HorizontalLayout(innerAgent, agentForm);
        agentLayout.setSpacing(true);
        agentLayout.setMargin(true);
        
        tabs.addTab(agentLayout, "Agents");
        
        Button idAddButton = new Button("New");
        idAddButton.setIcon(FontAwesome.PLUS);
        idAddButton.setStyleName(BaseTheme.BUTTON_LINK);
        idAddButton.setSizeUndefined();
        
        idAddButton.addClickListener(e->{
            idForm.setIdentifier(new Identifier());
        });
        
        VerticalLayout innerId = new VerticalLayout(idAddButton, idGrid);
        HorizontalLayout idTab = new HorizontalLayout(innerId, idForm);
        idTab.setSpacing(true);
        idTab.setMargin(true);
        
        tabs.addTab(idTab, "Identifiers");
        
        agentGrid.addSelectionListener(e->{
            if (!e.getSelected().isEmpty()) {
                Agent agent = (Agent) e.getSelected().iterator().next();
                agentForm.setAgent(agent);
                System.out.println("Selected " + agent.getFirstName());
            }
        });
        idGrid.addSelectionListener(e->{
            if (!e.getSelected().isEmpty()) {
                Identifier identifier = (Identifier)e.getSelected().iterator().next();
                idForm.setIdentifier(identifier);
            }
        });
        
    }
    
    public void setSoftwareRepository(SoftwareRepository r) {
        repository = r;
        
        BeanFieldGroup.bindFieldsUnbuffered(r, this);
        
        updateAgentList();
        updateIdentifierList();
        setVisible(true);
        
        name.selectAll();
    }
}
