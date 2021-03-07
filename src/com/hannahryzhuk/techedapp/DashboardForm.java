package com.hannahryzhuk.techedapp;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;


public class DashboardForm extends com.codename1.ui.Form {
    public DashboardForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public DashboardForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

        Command back  = new Command("Back") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                    showBack();
            }
        };

        setTitle("Hearn Dashboard");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        Button myClassesBtn = new Button("My Classes");
        Button profileBtn = new Button("Student Profile");
        Button aboutBtn = new Button("About");

        add(myClassesBtn);
        add(profileBtn);
        add(aboutBtn);


        myClassesBtn.addActionListener(evt->{
            Form myClassesForm = new MyClassesForm();
            myClassesForm.setBackCommand(back);
            myClassesForm.getToolbar().setBackCommand(back);
            myClassesForm.show();
        });

        profileBtn.addActionListener(evt->{
            Form myClassesForm = new ProfileForm();
            myClassesForm.setBackCommand(back);
            myClassesForm.getToolbar().setBackCommand(back);
            myClassesForm.show();
        });

        aboutBtn.addActionListener(evt->{
            Form myClassesForm = new TextToSpeechForm();
            myClassesForm.setBackCommand(back);
            myClassesForm.getToolbar().setBackCommand(back);
            myClassesForm.show();
        });

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
