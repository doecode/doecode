/*
 */
package gov.osti.doecode;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.UserError;
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
import com.vaadin.ui.themes.ValoTheme;
import gov.osti.doecode.connectors.github.Reader;
import gov.osti.doecode.entity.Agent;
import gov.osti.doecode.entity.Identifier;
import gov.osti.doecode.entity.SoftwareRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
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
    private List<Agent> agents = new ArrayList<>();
    private List<Identifier> identifiers = new ArrayList<>();
    private Grid agent_grid = new Grid("");
    private Grid id_grid = new Grid("");
    
    private Button loadButton = new Button("Load");
    
    private Button save = new Button("Save");
    private MyUI ui;
    
    private SoftwareRepository repository;
    
    private IdentifierModal id_modal;
    private AgentModal agent_modal;
    
    public static final String[] countryCodes = {
        "US", "FR", "GB", "DE", "ES"
    };
    
    public RepositoryForm(MyUI ui) {
        this.ui = ui;
        
        setSizeUndefined();
        
        agent_grid.setColumns("firstName", "lastName", "email");
        id_grid.setColumns("relationType", "identifierType", "value");
        
        id_modal = new IdentifierModal(ui);
        agent_modal = new AgentModal(ui);
        
        TabSheet tabs = new TabSheet();
        tabs.addStyleName(ValoTheme.TABSHEET_FRAMED);
        tabs.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
        
        addComponent(tabs);
        
        HorizontalLayout main = new HorizontalLayout();
        main.setSpacing(true);
        main.setMargin(true);
        
        FormLayout left = new FormLayout();
        FormLayout right = new FormLayout();
        
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
        
        VerticalLayout agentTab = new VerticalLayout();
        agentTab.addComponent(agent_grid);
        
        tabs.addTab(agentTab, "Agents");
        
        VerticalLayout idTab = new VerticalLayout();
        Button idAddButton = new Button("+");
        idAddButton.addClickListener(e->{
            id_modal.setIdentifier(new Identifier());
            System.out.println("Add a new ID.");
        });
        idTab.addComponents(id_grid, idAddButton);
        tabs.addTab(idTab, "Identifiers");
        
        agent_grid.addSelectionListener(e->{
            if (!e.getSelected().isEmpty()) {
                Agent agent = (Agent) e.getSelected().iterator().next();
                agent_modal.setAgent(agent);
                System.out.println("Agent: " + agent.getFirstName() + " selected");
                agent_grid.markAsDirty();
            }
        });
        
    }
    
//    public RepositoryForm(MyUI ui) {
//        this.ui = ui;
//        
//        setSizeUndefined();
//        agent_grid.setColumns("firstName", "lastName", "email");
//        id_grid.setColumns("relationType", "identifierType", "value");
//        
//        id_modal = new IdentifierModal(ui);
//        agent_modal = new AgentModal(ui);
//        
//        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
//        
//        description.setSizeFull();
//        otherRequirements.setSizeFull();
//        
//        loadButton.addClickListener(e->{
//            try {
//                SoftwareRepository repo = Reader.loadRepository("doecode");
//                
//                setSoftwareRepository(repo);
//                
//            } catch ( IOException ex ) {
//                setComponentError(new UserError("Unable to load: " + ex.getMessage()));
//            }
//        });
//        
//        Button idAddButton = new Button("+");
//        idAddButton.addClickListener(e->{
//            id_modal.setIdentifier(new Identifier());
//            System.out.println("Add a new ID.");
//        });
//        
//        HorizontalLayout main = new HorizontalLayout();
//        main.setSpacing(true);
//        main.setMargin(true);
//        
//        FormLayout left_side = new FormLayout();
//        left_side.setSizeUndefined();
//        
//        FormLayout right_side = new FormLayout();
//        right_side.setSizeUndefined();
//        
//        countryCode.addItems(countryCodes);
//        
//        left_side.addComponents(url, loadButton, name, openSource, siteOwnershipCode,
//                acronym, doi, countryCode);
//        right_side.addComponents(keywords, rights, license, operatingSystem, 
//                siteAccessionNumber, otherRequirements);
//        
//        main.setSpacing(true);
//        main.setMargin(true);
//        main.addComponents(left_side, right_side);
//        
//        main.setComponentAlignment(right_side, Alignment.TOP_LEFT);
//        
//        addComponents(main, agent_grid, id_grid, idAddButton, save);
//
//        setComponentAlignment(agent_grid, Alignment.MIDDLE_CENTER);
//        
////        addComponents(url, loadButton, name, openSource, siteOwnershipCode, acronym, doi,
////                description,
////                countryCode, agent_grid, keywords, rights, license, operatingSystem,
////                siteAccessionNumber, otherRequirements, id_grid, idAddButton,
////                save);
//        
//        agent_grid.addSelectionListener(e->{
//            if (!e.getSelected().isEmpty()) {
//                Agent agent = (Agent) e.getSelected().iterator().next();
//                agent_modal.setAgent(agent);
//                System.out.println("Agent: " + agent.getFirstName() + " selected");
//                agent_grid.markAsDirty();
//            }
//        });
//        id_grid.addSelectionListener(e->{
//            if (!e.getSelected().isEmpty()) {
//                Identifier id = (Identifier) e.getSelected().iterator().next();
//                id_modal.setIdentifier(id);
//                System.out.println("Picked ID: " + id.getValue());
//            }
//        });
//    }
    
    
    public void setSoftwareRepository(SoftwareRepository r) {
        repository = r;
        
        BeanFieldGroup.bindFieldsUnbuffered(r, this);
        agents.clear();
        agents.addAll(r.getAgents());
        agent_grid.setContainerDataSource(new BeanItemContainer<>(Agent.class, agents));
        System.out.println("There's " + agents.size() + " agents on record.");
        setVisible(true);
        
        name.selectAll();
    }
}
