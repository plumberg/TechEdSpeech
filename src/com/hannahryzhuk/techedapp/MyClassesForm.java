package com.hannahryzhuk.techedapp;

import com.codename1.components.MultiButton;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

import java.util.ArrayList;

public class MyClassesForm extends com.codename1.ui.Form {
    public MyClassesForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());


    }
    
    public MyClassesForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

        Command back  = new Command("Back") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showBack();
            }
        };

        setTitle("My Classes");
        setLayout(new BorderLayout());

        //For example purposes, it's hardcoded.
        ArrayList<Subject>classes = new ArrayList<>();
        classes.add(new Subject(1,"Precalculus", "Mr. Javier"));
        classes.add(new Subject(2,"World History", "Ms. Pavlova"));
        classes.add(new Subject(3, "Art","Ms. Johnson"));
        classes.add(new Subject(4,"English Composition","Mr. Gold"));

        Container subjectsCnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        MultiButton[] cmps = new MultiButton[classes.size()];
        for(int i = 0 ; i < cmps.length ; i++) {

            cmps[i] = new MultiButton(classes.get(i).getName());
            cmps[i].setTextLine2("Teacher: "+ classes.get(i).getTeacher());

            int idx = i;
            cmps[i].addActionListener(evt->{
                    Form f = new ClassForm(classes.get(idx));
                    f.getToolbar().setBackCommand(back);
                    f.setBackCommand(back);
                    f.show();
            });

            subjectsCnt.add(cmps[i]);
        }

        add(BorderLayout.CENTER, subjectsCnt);


    }
    
//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("MyClassesForm");
        setName("MyClassesForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
