package com.hannahryzhuk.techedapp;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageButton;
import com.codename1.io.Preferences;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;

import java.io.IOException;

public class ProfileForm extends com.codename1.ui.Form {

    private String photoPath;

    private Container photoCont;


    public ProfileForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public ProfileForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

        setTitle("Student Profile");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));

        Label fnameLbl = new Label("First Name: ");
        Label fname = new Label("Hannah");
        Label lnameLbl = new Label("Last Name: ");
        Label lname = new Label("Finkelstein");
        Label emailLbl = new Label("Email: ");
        Label email = new Label("hfink@student.edu");


        photoCont = new Container(BoxLayout.y());

        Button photoUploadBtn = new Button("Update my Photo");
        Button cameraPhotoBtn = new Button("Take a Photo");
        Button save = new Button("Save");

        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(getWidth()/3, getWidth() / 3, 0xFFE6E6), true);
        String photo_url = Preferences.get("photoPath", "");
        Image originImg;
        if(photo_url == ""){
            originImg = Image.createImage(100, 100, 0xff00ff00);
        }
        URLImage background = URLImage.createToStorage(placeholder, "400px-AGameOfThrones.jpg",
                "https://pngimg.com/uploads/mario/mario_PNG53.png");
       // Image originImg = Image.createImage(100, 100, 0xff00ff00);


        //Image smallImg = originImg.scaled(500,500);
        ScaleImageButton myPhoto = new ScaleImageButton(background);

      /*  myPhoto.addActionListener(evt->{
            Dialog previewForm = new Dialog();
            previewForm.addPointerReleasedListener(e-> previewForm.dispose());
            previewForm.setLayout(new BorderLayout());
            ImageViewer imagePreview = new ImageViewer(originImg);
            previewForm.add(BorderLayout.CENTER, imagePreview);
            previewForm.setDisposeWhenPointerOutOfBounds(true);
            previewForm.show();
        });*/

        photoCont.add(myPhoto);


        add(photoCont);
        add(photoUploadBtn).add(cameraPhotoBtn).
                add(GridLayout.encloseIn(2,fnameLbl,fname)).
                add(GridLayout.encloseIn(2,lnameLbl,lname)).
                add(GridLayout.encloseIn(2,emailLbl,email));


        photoUploadBtn.addActionListener(evt->{
            callFilePicker(photoCont);
        });


    }

    private void callFilePicker(Container cont) {
        ActionListener callback = e -> {
            if (e != null && e.getSource() != null) {
                String filePath = (String) e.getSource();

                //System.out.println("FILEPATH TO THE IMAGE " +filePath);
                cont.removeAll();
                try {
                    Image originImg = Image.createImage(filePath);
                    Image smallImg = originImg.scaled(600,600);

                    ScaleImageButton iv = new ScaleImageButton(smallImg);
                    iv.addActionListener(evt->{
                        Dialog previewForm = new Dialog();
                        previewForm.addPointerReleasedListener(i-> previewForm.dispose());
                        previewForm.setLayout(new BorderLayout());
                        ImageViewer imagePreview = new ImageViewer(originImg);
                        previewForm.add(BorderLayout.CENTER, imagePreview);
                        previewForm.setDisposeWhenPointerOutOfBounds(true);
                        previewForm.show();
                    });

                    cont.add(iv);
                    Preferences.set("photoPath", filePath);
                    //ProfileForm.this.photoPath = filePath;
                    revalidate();
                } catch (IOException ex) {

                }
            }
        };
        Display.getInstance().openGallery(callback, Display.GALLERY_IMAGE);
    }


    private void cameraPhoto(Container cont,String flag) {
        Capture.capturePhoto(evt -> {
            if (evt == null) {
                System.out.println("evt is null in get camera capture");
                return;
            } else {
                String filePath = (String) evt.getSource();
                System.out.println("E path " + filePath);
                if (filePath != null && !filePath.equals("")){
                    cont.removeAll();
                    try {
                        Image originImg = Image.createImage(filePath);
                        Image smallImg = originImg.scaled(600,600);

                        ScaleImageButton iv = new ScaleImageButton(smallImg);
                        iv.addActionListener(e->{
                            Dialog previewForm = new Dialog();
                            previewForm.addPointerReleasedListener(i-> previewForm.dispose());
                            previewForm.setLayout(new BorderLayout());
                            ImageViewer imagePreview = new ImageViewer(originImg);
                            previewForm.add(BorderLayout.CENTER, imagePreview);
                            previewForm.setDisposeWhenPointerOutOfBounds(true);
                            previewForm.show();
                        });

                        cont.add(iv);

                        Preferences.set("photoPath", filePath);
                    //    ProfileForm.this.photoPath = filePath;
                        revalidate();
                    } catch (IOException ex) {

                    }
                }
            }
        });
    }


//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("ProfileForm");
        setName("ProfileForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
