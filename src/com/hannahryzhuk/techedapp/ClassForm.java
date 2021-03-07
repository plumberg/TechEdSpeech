package com.hannahryzhuk.techedapp;

import com.codename1.system.NativeLookup;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.hannahryzhuk.techedapp.interfaces.SpeechRecognition;

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
        setLayout(new BorderLayout());

        SpeechRecognition speechRecognition = NativeLookup.create(SpeechRecognition.class);

        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop");
        Button clearButton = new Button("Clear");
        Button save = new Button("Save text");
        Label recording = new Label("Connected to " + subject.getTeacher());
        recording.setHidden(true);

        String speak = "Teacher is speaking...";
        String empty ="";
        Label speech = new Label(empty);
        TextArea speechArea = new TextArea(empty, 13, 80, TextArea.ANY);
        speechArea.setEditable(false);

        startButton.addActionListener(event -> {
            recording.setHidden(false);
            speechArea.setText(speak);
            this.revalidate();
            if (speechRecognition != null && speechRecognition.isSupported()) {
                speechRecognition.startListening();
            }
        });

        stopButton.addActionListener(event -> {
            recording.setHidden(true);
            this.revalidate();
            if (speechRecognition != null && speechRecognition.isSupported()) {
                speech.setText(speechRecognition.getResult());
            }
        });

        clearButton.addActionListener(evt -> {
            speechArea.setText(empty);
            this.revalidate();
        });

        Container recordCnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        recordCnt.addComponent(startButton);
        recordCnt.addComponent(recording);
        recordCnt.addComponent(stopButton);
        recordCnt.addComponent(speechArea);
        recordCnt.addComponent(clearButton);
        recordCnt.addComponent(save);

        add(BorderLayout.CENTER, recordCnt);
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
