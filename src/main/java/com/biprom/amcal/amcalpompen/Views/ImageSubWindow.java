package com.biprom.amcal.amcalpompen.Views;

import com.vaadin.server.Resource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import com.vaadin.ui.Window;
import org.tepi.imageviewer.ImageViewer;

import java.util.ArrayList;
import java.util.List;


    public class ImageSubWindow extends Window {

    private ImageViewer imageViewer;
    private VerticalLayout mainLayout;
    private TextField selectedImage = new TextField();
    private List<Resource> imgageResources = new ArrayList<Resource>();

    public ImageSubWindow() {

        mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        Label info = new Label(
                "<b>Amcal ImageViewer Application</b>&nbsp;&nbsp;&nbsp;"
                        , ContentMode.HTML);

        imageViewer = new ImageViewer();
        imageViewer.setSizeFull();
        //imageViewer.setImages(imgageResources);
        imageViewer.setAnimationEnabled(false);
        imageViewer.setSideImageRelativeWidth(0.7f);

        imageViewer.addListener((ImageViewer.ImageSelectionListener) e -> {
            selectedImage.setValue(e.getSelectedImageIndex() >= 0 ? String.valueOf(e.getSelectedImageIndex()) : "-");
        });
        HorizontalLayout hl = new HorizontalLayout();
        hl.setSizeUndefined();
        hl.setMargin(false);
        hl.setSpacing(true);
        hl.addComponent(info);
        mainLayout.addComponent(hl);
        mainLayout.addComponent(imageViewer);
        mainLayout.setExpandRatio(imageViewer, 1);

        Layout ctrls = createControls();
        mainLayout.addComponent(ctrls);
        mainLayout.setComponentAlignment(ctrls, Alignment.BOTTOM_CENTER);

        com.vaadin.ui.Label images = new Label("powered by Biprom");
        images.setSizeUndefined();
        images.setStyleName("Amcal Picture");
        mainLayout.addComponent(images);
        mainLayout.setComponentAlignment(images, Alignment.BOTTOM_RIGHT);

        setContent(mainLayout);

        imageViewer.focus();

    }

    private Layout createControls() {
        HorizontalLayout hl = new HorizontalLayout();
        hl.setSizeUndefined();
        hl.setMargin(false);
        hl.setSpacing(true);

        CheckBox c = new CheckBox("HiLite");
        c.addValueChangeListener(e -> {
            imageViewer.setHiLiteEnabled(e.getValue());
            imageViewer.focus();
        });

        c.setValue(true);
        hl.addComponent(c);
        hl.setComponentAlignment(c, Alignment.BOTTOM_CENTER);

        c = new CheckBox("Animate");
        c.addValueChangeListener(e -> {
            imageViewer.setAnimationEnabled(e.getValue());
            imageViewer.focus();
        });
        c.setValue(true);
        hl.addComponent(c);
        hl.setComponentAlignment(c, Alignment.BOTTOM_CENTER);

        Slider s = new Slider("Animation duration (ms)");
        s.setMax(2000);
        s.setMin(200);
        s.setWidth("120px");
        s.addValueChangeListener(e -> {
            imageViewer.setAnimationDuration((int) Math.round(e.getValue()));
            imageViewer.focus();
        });
        s.setValue(350d);
        hl.addComponent(s);
        hl.setComponentAlignment(s, Alignment.BOTTOM_CENTER);

        s = new Slider("Center image width");
        s.setResolution(2);
        s.setMax(1);
        s.setMin(0.1);
        s.setWidth("120px");
        s.addValueChangeListener(e -> {
            imageViewer.setCenterImageRelativeWidth(e.getValue().floatValue());
            imageViewer.focus();
        });
        s.setValue(0.55);
        hl.addComponent(s);
        hl.setComponentAlignment(s, Alignment.BOTTOM_CENTER);

        s = new Slider("Side image count");
        s.setMax(5);
        s.setMin(1);
        s.setWidth("120px");

        s.addValueChangeListener(e -> {
            imageViewer.setSideImageCount((int) Math.round(e.getValue()));
            imageViewer.focus();
        });
        s.setValue(2d);
        hl.addComponent(s);
        hl.setComponentAlignment(s, Alignment.BOTTOM_CENTER);

        s = new Slider("Side image width");
        s.setResolution(2);
        s.setMax(0.8);
        s.setMin(0.5);
        s.setWidth("120px");

        s.addValueChangeListener(e -> {
            imageViewer.setSideImageRelativeWidth(e.getValue().floatValue());
            imageViewer.focus();
        });

        s.setValue(0.65);
        hl.addComponent(s);
        hl.setComponentAlignment(s, Alignment.BOTTOM_CENTER);

        s = new Slider("Horizontal padding");
        s.setMax(10);
        s.setMin(0);
        s.setWidth("120px");

        s.addValueChangeListener(e -> {
            imageViewer.setImageHorizontalPadding((int) Math.round(e.getValue()));
            imageViewer.focus();
        });
        s.setValue(1d);
        hl.addComponent(s);
        hl.setComponentAlignment(s, Alignment.BOTTOM_CENTER);

        s = new Slider("Vertical padding");
        s.setMax(10);
        s.setMin(0);
        s.setWidth("120px");
        s.addValueChangeListener(e -> {
            imageViewer.setImageVerticalPadding((int) Math.round(e.getValue()));
            imageViewer.focus();
        });
        s.setValue(5d);
        hl.addComponent(s);
        hl.setComponentAlignment(s, Alignment.BOTTOM_CENTER);

        selectedImage.setWidth("50px");
        hl.addComponent(selectedImage);
        hl.setComponentAlignment(selectedImage, Alignment.BOTTOM_CENTER);

        return hl;
    }

    public void setImageResources(List<Resource>resources){
        this.imgageResources = resources;
        imageViewer.setImages(imgageResources);
        imageViewer.setCenterImageIndex(0);
    }


}
