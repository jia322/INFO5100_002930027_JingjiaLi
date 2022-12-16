package com.example.final_project;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Shear;
import javafx.scene.transform.Translate;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class ImageController implements Initializable {
    @FXML
    private Button btn_upload;

    @FXML
    private ImageView img;

    @FXML
    private static Image upload_image;

    private static Image reset_image;

    @FXML
    private Button btn_dwload;

    @FXML
    private Button rotate;

    @FXML
    private Slider resize;

    @FXML
    private Slider visible;

    @FXML
    private Slider glow;

    @FXML
    private Slider bloom;

    @FXML
    private Slider sepia;

    @FXML
    private Button close;

    @FXML
    private Button reset;

    @FXML
    private Pane image_pane;

    @FXML
    private StackPane stackPane;

    @FXML
    private VBox vbox;

    @FXML
    private Button flip;

    @FXML
    private Button clear;

    private static int resize_value = 100;
    private static double visibility;
    private static double glowness;
    private static double bloomness;

    private static double sepiaNess;
    private Stage stage;
    private Scene scene;

    @FXML
    private Text property_text;
    @FXML
    private Text width_text;

    @FXML
    private Text height_text;
    @FXML
    private Text date_text;
    @FXML
    private Text visibility_text;
    @FXML
    private Text glow_text;
    @FXML
    private Text bloom_text;
    @FXML
    private Text sepia_text;


    public static Image getUpload_image(Image upload_image) {
        return upload_image;
    }

    public void onClick_btn_up(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        File fileUpload = fileChooser.showOpenDialog(null);

        try {
            BufferedImage bufferedImage = ImageIO.read(fileUpload);
            upload_image = SwingFXUtils.toFXImage(bufferedImage, null);
            reset_image = upload_image;
            img.setImage(upload_image);
            img.setFitHeight(resize_value);
            img.setFitWidth(resize_value);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();

            //Images.setImage(img);
            width_text.setText("Width: " + resize_value);
            height_text.setText("Height: " + resize_value);
            visibility_text.setText("Visibility: " + (int)(100 * visible.getValue()) + "%");
            glow_text.setText("Glow: " + (int)(100 * glow.getValue()) + "%");
            bloom_text.setText("Bloom: " + (int)(100 * bloom.getValue()) + "%");
            sepia_text.setText("SepiaTone: " + (int)(100 * sepia.getValue()) + "%");
            date_text.setText("Date: " + formatter.format(now));


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void onClick_btn_down(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        File fileSave = fileChooser.showSaveDialog(null);
        if (fileSave != null) {
            try {
                BufferedImage bImage = SwingFXUtils.fromFXImage(img.snapshot(null, null), null);
                ImageIO.write(bImage, "png", fileSave);
            } catch (IOException ex) {
            }
        }
    }

    public void onClick_clear(ActionEvent e){
        img.setImage(null);
        img.setFitHeight(100);
        img.setFitWidth(100);
        resize.setValue(100);
        visible.setValue(1.0);
        glow.setValue(0.0);
        bloom.setValue(1.0);
        sepia.setValue(0.0);
        property_text.setVisible(false);
        width_text.setVisible(false);
        height_text.setVisible(false);
        visibility_text.setVisible(false);
        glow_text.setVisible(false);
        date_text.setVisible(false);
        bloom_text.setVisible(false);
        sepia_text.setVisible(false);

    }

    /*
    public void onImage_click(javafx.scene.input.MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        File fileSave = fileChooser.showSaveDialog(null);
        if (fileSave != null) {
            try {
                BufferedImage bImage = SwingFXUtils.fromFXImage(img.snapshot(null, null), null);
                ImageIO.write(bImage, "png", fileSave);
            } catch (IOException ex) {
            }
        }
    }
     */
    public void onClick_close(ActionEvent e) {
        System.exit(0);
    }

    public void onClick_rotateX(ActionEvent e) {
        img.setRotationAxis(Rotate.Z_AXIS);
        img.setRotate(img.getRotate() + 90);
//        VBox.setVgrow(stackPane,Priority.ALWAYS);
    }

    public void onClick_rotateY(ActionEvent e) {
        img.setRotationAxis(Rotate.Z_AXIS);
        img.setRotate(img.getRotate() - 90);
//        VBox.setVgrow(stackPane,Priority.ALWAYS);
    }

    public void onClick_flipY(ActionEvent e) {
        img.setRotationAxis(Rotate.Y_AXIS);
        img.setRotate(img.getRotate() + 180);
        VBox.setVgrow(stackPane, Priority.ALWAYS);
    }

    public void onClick_flipX(ActionEvent e) {
        img.setRotationAxis(Rotate.X_AXIS);
        img.setRotate(img.getRotate() + 180);
        VBox.setVgrow(stackPane, Priority.ALWAYS);
    }

    public void onClick_show(ActionEvent e){
        property_text.setVisible(true);
        width_text.setVisible(true);
        height_text.setVisible(true);
        visibility_text.setVisible(true);
        glow_text.setVisible(true);
        date_text.setVisible(true);
        bloom_text.setVisible(true);
        sepia_text.setVisible(true);
    }

    public void onClick_filter1(ActionEvent e) {
        upload_image = SampleFilter1.filter(upload_image, 0, 0, 0);
        img.setPreserveRatio(true);
        img.setImage(upload_image);
    }

    public void onClick_filter2(ActionEvent e) {
        upload_image = SampleFilter2.filter(upload_image);
        img.setPreserveRatio(true);
        img.setImage(upload_image);
    }

    public void onClick_filter3(ActionEvent e) {
        upload_image = SampleFilter3.filter(upload_image);
        img.setPreserveRatio(true);
        img.setImage(upload_image);
    }

    public void onClick_reset(ActionEvent e) {
        Image cur_image = reset_image;
        img.setImage(cur_image);
        upload_image = cur_image;
        visible.setValue(1.0);
        glow.setValue(0.0);
        bloom.setValue(1.0);
        sepia.setValue(0.0);
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        //add on action section to link a method with slider
        resize.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                resize_value = (int)resize.getValue();
                img.setFitWidth(resize_value);
                img.setFitHeight(resize_value);
                img.setPreserveRatio(true);
                VBox.setVgrow(stackPane, Priority.ALWAYS);
                width_text.setText("Width: " + resize_value);
                height_text.setText("Height: " + resize_value);
            }
        });
        visible.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                visibility = visible.getValue();
                img.setPreserveRatio(true);
                img.setOpacity(visibility);
                visibility_text.setText("Visibility: " + (int)(100 * visible.getValue()) + "%");
            }
        });
        glow.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                glowness = glow.getValue();
                img.setPreserveRatio(true);
                img.setEffect(new Glow(glowness));
                glow_text.setText("Glow: " + (int)(100 * glow.getValue()) + "%");
            }
        });
        bloom.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                bloomness = bloom.getValue();
                img.setPreserveRatio(true);
                img.setEffect(new Bloom(bloomness));
                bloom_text.setText("Bloom: " + (int)(100 * bloom.getValue()) + "%");
            }
        });
        sepia.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                sepiaNess = sepia.getValue();
                img.setPreserveRatio(true);
                img.setEffect(new SepiaTone(sepiaNess));
                sepia_text.setText("SepiaTone: " + (int)(100 * sepia.getValue()) + "%");
            }
        });
    }
}
class SampleFilter1 {

    private final Image image;

    SampleFilter1(Image image) {
        this.image = image;
    }

    public static Image filter(Image image, double redLimit, double greenLimit, double blueLimit) {
        if (redLimit == 0) {
            redLimit = 0.2162;
            greenLimit = 0.7152;
            blueLimit = 0.0722;
        }
        PixelReader pixelReader = image.getPixelReader();
        int height = (int) image.getHeight();
        int width = (int) image.getWidth();
        WritableImage filteredImage = new WritableImage(pixelReader, width, height);
        PixelWriter pixelWriter = filteredImage.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = pixelReader.getArgb(x, y);

                int alpha = ((pixel >> 24) & 0xff);
                int red = ((pixel >> 16) & 0xff);
                int green = ((pixel >> 8) & 0xff);
                int blue = (pixel & 0xff);

                int grayLevel = (int) (redLimit * red + greenLimit * green + blueLimit * blue);
                int gray = (alpha << 24) + (grayLevel << 16) + (grayLevel << 8) + grayLevel;

                pixelWriter.setArgb(x, y, gray);
            }
        }
        return filteredImage;
    }
}

class SampleFilter2 {

    private final Image image;

    SampleFilter2(Image image) {
        this.image = image;
    }

    public static Image filter(Image image) {
        PixelReader pixelReader = image.getPixelReader();
        int height = (int) image.getHeight();
        int width = (int) image.getWidth();
        PixelReader reader = image.getPixelReader();
        WritableImage filteredImage = new WritableImage(pixelReader, width, height);
        PixelWriter writer = filteredImage.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                //Retrieving the color of the pixel of the loaded image
                Color color = reader.getColor(x, y);
                //Setting the color to the writable image
                writer.setColor(x, y, color.invert());
            }
        }
        return filteredImage;
    }
}

class SampleFilter3 {

    private final Image image;

    SampleFilter3(Image image) {
        this.image = image;
    }

    public static Image filter(Image image) {
        PixelReader pixelReader = image.getPixelReader();
        int height = (int) image.getHeight();
        int width = (int) image.getWidth();
        PixelReader reader = image.getPixelReader();
        WritableImage filteredImage = new WritableImage(pixelReader, width, height);
        PixelWriter writer = filteredImage.getPixelWriter();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                //Retrieving the color of the pixel of the loaded image
                Color color = reader.getColor(x, y);
                //Setting the color to the writable image
                writer.setColor(x, y, color.saturate());
            }
        }
        return filteredImage;
    }
}

