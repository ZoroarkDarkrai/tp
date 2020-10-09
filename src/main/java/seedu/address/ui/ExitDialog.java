package seedu.address.ui;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class ExitDialog extends UiPart<DialogPane> {

    private static final String FXML = "ExitDialog.fxml";

    @FXML
    private DialogPane dialogPane;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    private Dialog<Boolean> dialog;
    private WindowEvent event;
    private HelpWindow helpWindow;

    /**
     * Creates a new Exit dialog.
     *
     * @param event event that triggers the creation of exit dialog.
     */
    public ExitDialog(WindowEvent event, HelpWindow helpWindow) {
        super(FXML);
        dialog = new Dialog<>();
        dialog.setDialogPane(dialogPane);

        Window window = dialog.getDialogPane().getScene().getWindow();
        window.setOnCloseRequest((e) -> {
            dialog.hide();
            event.consume();
        });
        this.event = event;
        this.helpWindow = helpWindow;
    }

    public void show() {
        dialog.showAndWait();
    }

    @FXML
    private boolean confirmExit() {
        dialog.setResult(Boolean.TRUE);
        dialog.hide();
        helpWindow.hide();
        return true;
    }

    @FXML
    private boolean cancelExit() {
        dialog.setResult(Boolean.TRUE);
        dialog.hide();
        event.consume();
        return false;
    }
}