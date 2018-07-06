import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class UIUtils {

    public static TextField createTextField(Pane root,double X,double Y){
        TextField textField = new TextField();
        textField.setTranslateX(X);
        textField.setTranslateY(Y);
        root.getChildren().add(textField);

        return textField;
    }

    public static Button createButton(Pane root, double X, double Y,String text){
        Button button = new Button();
        button.setTranslateX(X);
        button.setTranslateY(Y);
        button.setText(text);
        root.getChildren().add(button);

        return button;
    }

    public static Label createLabel(Pane root, double X, double Y, String text){
        Label label = new Label();
        label.setTranslateX(X);
        label.setTranslateY(Y);
        label.setText(text);
        root.getChildren().add(label);

        return label;
    }

}
