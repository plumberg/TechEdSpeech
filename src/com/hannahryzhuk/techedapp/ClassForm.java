package com.hannahryzhuk.techedapp;
public class ClassForm extends com.codename1.ui.Form {

    private Subject subject;
    public ClassForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public ClassForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

    public ClassForm(Subject subject) {
        setTitle(subject.getName());


    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("ClassForm");
        setName("ClassForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
