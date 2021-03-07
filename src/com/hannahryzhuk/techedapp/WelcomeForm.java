package com.hannahryzhuk.techedapp;

import com.codename1.components.ImageViewer;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;


public class WelcomeForm extends com.codename1.ui.Form {
    public WelcomeForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public WelcomeForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        setTitle("Welcome");
        setLayout(new BorderLayout());
        Button getStartedBtn = new Button("Let's Get Started!");


        FontImage.setMaterialIcon(getStartedBtn, FontImage.MATERIAL_SCHOOL);
        getStartedBtn.setUIID("GetStarted");

        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(getWidth()/3, getWidth() / 3, 0xFFE6E6), true);
        Image img = URLImage.createToStorage(placeholder, "fileNameInStorage", "https://cdn1.iconfinder.com/data/icons/education-309/64/schoolroom-classroom-education-learning-512.png", URLImage.RESIZE_SCALE);
        ImageViewer imagePreview = new ImageViewer(img);

        Container listCont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container picture = new Container(new BorderLayout());
        picture.add(BorderLayout.CENTER,imagePreview);

        listCont.add(picture);
        listCont.add(getStartedBtn);

        add(BorderLayout.CENTER, listCont);

        getStartedBtn.addActionListener((e) -> {
            DashboardForm dash = new DashboardForm();
            dash.show();
        });
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("WelcomeForm");
        setName("WelcomeForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
