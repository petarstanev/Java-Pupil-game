package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Cow {
	private ImageView graphics = new ImageView();
	private Image image;
	private int frameCounter = 0;
	public boolean jumping = false;
	Ellipse bounds;

	public ImageView getGraphics() {
		return graphics;
	}

	public Ellipse getBounds() {
		return bounds;
	}

	public Cow() {
		image = new Image("file:logo.png, 200, 200, false, true);");
		this.bounds = new Ellipse(image.getWidth() / 2.0, 11.5);
		graphics.setImage(image);
		bounds.setFill(Color.TRANSPARENT);
		bounds.setStroke(Color.BLACK);
		bounds.centerXProperty().bind(
		graphics.translateXProperty().add(image.getWidth() / 2.0));
		bounds.centerYProperty().bind(graphics.translateYProperty().add(12.0));
		bounds.rotateProperty().bind(graphics.rotateProperty());
	}

	public void refresh() {
		graphics.setImage(image);
		if (frameCounter == 3) {
			frameCounter = 0;
		}
	}
}
