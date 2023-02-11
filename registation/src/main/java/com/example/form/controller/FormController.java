package com.example.form.controller;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// import com.example.form.Dto;
import com.example.form.Register;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class FormController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane borderpane;

    @FXML
    private TableView<Register> tableuser;

    @FXML
    private TableColumn<Register, String> collegetable;

    @FXML
    private TableColumn<Register, String> emailtable;

    // @FXML
    // private TableColumn<Register, Integer> idtable;

    @FXML
    private TableColumn<Register, String> nametable;

    @FXML
    private TableColumn<Register, Long> phonetable;

    @FXML
    private TextField txtcollege;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtphone;

    ObservableList<Register> userList = FXCollections.observableArrayList();

    @FXML
    void register(ActionEvent event) throws IOException {

        // Dto user = new Dto();
        // user.setName(txtname.getText());
        // user.setCollege(txtcollege.getText());
        // user.setEmail(txtemail.getText());
        // user.setPhone(txtphone.getText());

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://localhost:8080/register/add");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", txtname.getText());
            jsonObject.put("college", txtcollege.getText());
            jsonObject.put("email", txtemail.getText());
            jsonObject.put("phone", txtphone.getText());

            StringEntity stringEntity = new StringEntity(jsonObject.toString());
            httpPost.setEntity(stringEntity);
            System.out.println("Executing request " + httpPost.getRequestLine());
            System.out.println("Name is " + txtname.getText());
            System.out.println("College name is " + txtcollege.getText());
            System.out.println("Email is " + txtemail.getText());
            System.out.println("Phone number is " + txtphone.getText());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }

    @FXML
    void view(ActionEvent event) {

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            // HTTP GET method
            HttpGet httpget = new HttpGet("http://localhost:8080/register/getall");
            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            // System.out.println(responseBody);

            JSONArray userListJson = new JSONArray(responseBody);

            System.out.println("In Jason Object");
            for (int i = 0; i < userListJson.length(); i++) {
                JSONObject user = userListJson.getJSONObject(i);
                // System.out.println(user.get("id")+"-ph no:"+user.get("phone"));
                Integer id = (int) user.get("id");
                String name = (String) user.get("name");
                String college = (String) user.get("college");
                String email = (String) user.get("email");
                Long phone = (long) user.get("phone");
                // System.out.println("id" + id+" "+phone);
                userList.add(new Register(id, name, college, email, phone));
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        // idtable.setCellValueFactory(newPropertyValueFactory<Register,Integer>("id"));
        nametable.setCellValueFactory(new PropertyValueFactory<Register, String>("name"));
        collegetable.setCellValueFactory(new PropertyValueFactory<Register, String>("College"));
        emailtable.setCellValueFactory(new PropertyValueFactory<Register, String>("Email"));
        phonetable.setCellValueFactory(new PropertyValueFactory<Register, Long>("Phone"));

        tableuser.setItems(userList);

    }

}
