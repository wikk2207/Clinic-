package main.start;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

public class Staff {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty type;
    private final SimpleStringProperty spec;
    private Button deleteB;

    public Staff(int id, String fName, String lName, String type, String spec) {
        this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.type = new SimpleStringProperty(type);
        this.spec = new SimpleStringProperty(spec);
        this.deleteB = new Button("Usun");
        this.deleteB.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> deleteB());
    }

    public int getId() {
        return id.get();
    }

    public void setId(int idl) {
        id.set(idl);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String fName) {
        lastName.set(fName);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String typ) {
        type.set(typ);
    }

    public String getSpec() {
        return spec.get();
    }

    public void setSpec(String specS) { spec.set(specS); }

    public Button getDeleteB() { return deleteB; }

    public void setDeleteB(Button button) { deleteB = button; }

    public void deleteB() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Usuwasz pracownika");
        alert.setContentText("Czy jestes tego pewien?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            StaffList.deleteStaff(getId());
            this.deleteB.setText("Usunieto");
            this.deleteB.setDisable(true);
        } else {}
    }
}
