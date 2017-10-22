package TextEditor.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StartPageController{
@FXML
private TextArea textArea = new TextArea();
@FXML
private Button buttonLoad = new Button();
@FXML
private TextField textfieldFibonacci;
@FXML
private TextField loadSaveMenu = new TextField();
    public void loadFromFile(MouseEvent mouseEvent) throws IOException {
        Thread thread = new Thread(()->{
        File file = new File(loadSaveMenu.getText());
            Scanner scan = null;
            try {
                scan = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            scan.useDelimiter("\\Z");
            String content = scan.next();
            textArea.setText(content);
        });
        thread.start();
    }

    public void saveToFile(MouseEvent mouseEvent) {
        Thread thread = new Thread(()->{
            try {
                String str = textArea.getText();
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/files/info.txt"));
                writer.write(str);
                writer.close();
            } catch (IOException ex){
                ex.printStackTrace();
            }
            textArea.clear();
        });
        thread.start();
    }
    public void calculateFibonacci(MouseEvent mouseEvent) {
        //Thread thread = new Thread(()->{
        int Count = Integer.parseInt(textfieldFibonacci.getText());
        ArrayList<Long> arrayList = new ArrayList<>(Count);
        long fib1 = 1;
        long fib2 = 1;
        long tmpFib;
        arrayList.add(fib1);
        arrayList.add(fib2);
        for (int i = 0; i<Count - 2; i++){
            tmpFib = fib2;
            fib2 = fib1 + fib2;
            arrayList.add(fib2);
            fib1 = tmpFib;
        }
        saveFibonacci(arrayList);
      //  });
    //   thread.start();
    }
    public void saveFibonacci(ArrayList<Long> arrayList){
        clearFile();
        try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(loadSaveMenu.getText(), true));
        for (Long value:arrayList)
        {
            writer.write(value+" ");
        }
        writer.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
    public void clearFile(){
        try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(loadSaveMenu.getText()));
        writer.write("");
        writer.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
