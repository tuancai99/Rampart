package com.example.m1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private Label topDisplay;
    @FXML private TextField pushInput;
    @FXML private TextField deleteInput;

    private MyStack stack;

    @FXML public void initialize() {
        stack = new MyStack();
    }

    @FXML private void updateTopDisplay() {
        topDisplay.setText(stack.top());
    }

    @FXML protected void onPush() {
        stack.push(pushInput.getText());
        pushInput.clear();
        updateTopDisplay();
    }

    @FXML protected void onPop() {
        stack.pop();
        updateTopDisplay();
    }

    @FXML protected void onDelete() {
        stack.delete(Integer.parseInt(deleteInput.getText()));
        deleteInput.clear();
        updateTopDisplay();
    }
}