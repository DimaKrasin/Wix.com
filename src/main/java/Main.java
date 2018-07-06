import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Map;

public class Main extends Application {

    //Название файла с алфавитом
    //Можно редактировать файл (Соблюдая текущие правила)
    private String  name = "Alphabet.txt";

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Wix.com");
        Pane root = new Pane();
        primaryStage.setScene(new Scene(root, 400, 400));

        TextField inputTextField = UIUtils.createTextField(root, 100, 100);
        Label labelDecimalResult = UIUtils.createLabel(root,100,200,String.valueOf(""));
        Button inputButton = UIUtils.createButton(root, 300, 100, "Input");

        // При нажатии на кнопку считываем из inputTextField
        // и преобразований результат записываем в labelDecimalResult
        inputButton.setOnAction(event -> {
            String textFromTextField = inputTextField.getText();
            if (textFromTextField.length() >= 1) {
                Integer decimal = convertTralfamadorianToDecimal(textFromTextField);
                labelDecimalResult.setText(String.valueOf(decimal));
            }
        });

        //Кнопка для закрытия программи
        Button exitButton = UIUtils.createButton(root, 300, 130, "Exit");
        exitButton.setPrefSize(43,7);
        exitButton.setOnAction(event -> {Platform.exit();});

        primaryStage.show();
    }

    //Преобразование tralfamadorian число в десятичное
    public Integer convertTralfamadorianToDecimal(String tralfamadorianNumber) {

        FileUtils fileUtils =  new FileUtils();

        //Считываем алфавит из Alphabet.txt в Map
        Map<String, String> alphabet = fileUtils.readAlphabetAsMap(name);

        StringBuilder decimalAnswerInStringBuilder = new StringBuilder();

        //Нужно для расстановки чисел на правильное месте
        int lastUsedPlaceNumber = 0;
        int currentlyPlaceNumber = 0;

        if(tralfamadorianNumber.charAt(tralfamadorianNumber.length()-1) != '|'){
           currentlyPlaceNumber = 1;
        }

        //Проходим по всей строке ( Tralfamadorian Number )
        for (int i = tralfamadorianNumber.length() - 1; i >= 0; i--) {

            //Берем текуший символ
            char letter = tralfamadorianNumber.charAt(i);

            //Записываем на нужном месте
            if (alphabet.containsKey(String.valueOf(letter))) {

                if (currentlyPlaceNumber - lastUsedPlaceNumber >= 1) {
                    for (int j = 1; j < currentlyPlaceNumber - lastUsedPlaceNumber; j++) {
                        decimalAnswerInStringBuilder.append("0");
                    }

                }

                decimalAnswerInStringBuilder.append(alphabet.get(String.valueOf(letter)));
                lastUsedPlaceNumber = currentlyPlaceNumber;

                if(tralfamadorianNumber.charAt(tralfamadorianNumber.length()-1)!='|'){
                    currentlyPlaceNumber = 1;
                }else {
                    currentlyPlaceNumber = 0;
                }
            } else {
                if (letter == 'x') {
                    currentlyPlaceNumber = currentlyPlaceNumber + 2;
                }
                if (letter == '+') {
                    currentlyPlaceNumber = currentlyPlaceNumber + 1;
                }
            }
        }

        try {
            Integer.valueOf(decimalAnswerInStringBuilder.toString());
        }catch (NumberFormatException ex){
            return null;
        }

        return Integer.valueOf(decimalAnswerInStringBuilder.reverse().toString());
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
