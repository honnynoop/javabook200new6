package kr.co.infopub.chapter.s172;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
public class ExchangeRateFxController {
    @FXML
    private Label lbfrom;
    @FXML
    private TextField tffrom;
    @FXML
    private TextField tfjpy;
    @FXML
    private Label lbto;
    @FXML
    private RadioButton rdother;
    @FXML
    private ComboBox<String> cbfinance;
    @FXML
    private TextField tfusd;
    @FXML
    private Button btncon;
    @FXML
    private TextField tfto;
    @FXML
    private RadioButton rdkrw;
    @FXML
    private TextField tfcny;
    @FXML
    private Label lbboard;
    @FXML
    void initialize() {}
    //�޺��ڽ��� �������� ����
    @FXML
    void cbdistanceOnAction(ActionEvent event) {}
    //����-�ٸ� ������ ȭ��� ȯ��
    @FXML
    void onOtherAction(ActionEvent event) {}
    //����-��ȭ�� ȯ��
    @FXML
    void onKrwAction(ActionEvent event) {}
    //�ֽ� ȯ�� ��������
    @FXML
    void onConvertAction(ActionEvent event) {}
}
