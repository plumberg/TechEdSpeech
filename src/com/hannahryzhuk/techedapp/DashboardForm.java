package com.hannahryzhuk.techedapp;

import com.codename1.ui.Button;
import com.codename1.ui.layouts.BoxLayout;


public class DashboardForm extends com.codename1.ui.Form {
    public DashboardForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public DashboardForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

        setTitle("Dashboard");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        Button myClassesBtn = new Button("My Classes");
        Button profileBtn = new Button("Student Profile");
        Button aboutBtn = new Button("About");

        add(myClassesBtn);
        add(profileBtn);
        add(aboutBtn);

    }
    
//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("DashboardForm");
        setName("DashboardForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
