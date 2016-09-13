package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class EffectsController implements Initializable {

	// shadow effect
	public ComboBox<BlurType> blurCombo;
	public Slider offsetXSlider;
	public Slider offsetYSlider;
	public Slider radiusSlider;
	public Slider spreadSlider;
	public ColorPicker colorPicker;
	public Rectangle rect;
	
	// gloom effect
	public Slider threshold;
	public Text text;

	// reflection
	public Slider topOffsetSlider;
	public Slider fractionSlider;
	public Slider topOpacitySlider;
	public Slider bottomOpacitySlider;
	public Text reflectionText;

	// box blur
	public Slider widthSlider;
	public Slider heightSlider;
	public Slider iterationsSlider;
	public Text boxBlurText;

	// color adjust
	public Slider brightnessSlider;
	public Slider hueSlider;
	public Slider saturationSlider;
	public Slider contrastSlider;
	public ImageView imageView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// set the color to red (in shadow effect)
		colorPicker.setValue(Color.RED);
		// efects
		DropShadow shadow = new DropShadow();
		Glow glow = new Glow();
		Reflection reflection = new Reflection();
		BoxBlur boxBlur = new BoxBlur();
		ColorAdjust colorAdjust = new ColorAdjust();

		// set values to combo box (shadow effect)
		blurCombo.setValue(shadow.getBlurType());
		blurCombo.getItems().addAll(BlurType.ONE_PASS_BOX, BlurType.TWO_PASS_BOX, BlurType.THREE_PASS_BOX,
				BlurType.GAUSSIAN);

		// bind the properties and set effects
		// shadow effect
		rect.setEffect(shadow);
		shadow.offsetXProperty().bind(offsetXSlider.valueProperty());
		shadow.offsetYProperty().bind(offsetYSlider.valueProperty());
		shadow.radiusProperty().bind(radiusSlider.valueProperty());
		shadow.spreadProperty().bind(spreadSlider.valueProperty());
		shadow.colorProperty().bind(colorPicker.valueProperty());
		shadow.blurTypeProperty().bind(blurCombo.valueProperty());

		// glow
		text.setEffect(glow);
		glow.levelProperty().bind(threshold.valueProperty());

		// reflection
		reflectionText.setEffect(reflection);
		reflection.topOffsetProperty().bind(topOffsetSlider.valueProperty());
		reflection.fractionProperty().bind(fractionSlider.valueProperty());
		reflection.topOpacityProperty().bind(topOpacitySlider.valueProperty());
		reflection.bottomOpacityProperty().bind(bottomOpacitySlider.valueProperty());

		// box blur
		boxBlurText.setEffect(boxBlur);
		boxBlur.widthProperty().bind(widthSlider.valueProperty());
		boxBlur.heightProperty().bind(heightSlider.valueProperty());
		boxBlur.iterationsProperty().bind(iterationsSlider.valueProperty());

		// color adjust effect
		colorAdjust.brightnessProperty().bind(brightnessSlider.valueProperty());
		colorAdjust.contrastProperty().bind(contrastSlider.valueProperty());
		colorAdjust.hueProperty().bind(hueSlider.valueProperty());
		colorAdjust.saturationProperty().bind(saturationSlider.valueProperty());
		// load and show image
		String fileImage = "file:///e:\\pic.jpg";
		Image image = new Image(fileImage);
		imageView.setImage(image);
		imageView.setEffect(colorAdjust);

	}
}
