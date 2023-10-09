package com.serverest.tests;

import com.github.javafaker.Faker;
import com.serverest.bases.TestBase;
import com.serverest.jsonObjects.UserObject;
import com.serverest.requests.PostUsuariosRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class PostUsuariosTests extends TestBase {

    @Test
    public void cadastrarUsuarioComSucesso(){
        //region Arrange

        Faker faker = new Faker();
        String nome = "Teste QA";
        String email = faker.random().hex(6)+"@qa.com.br";
        String password = "teste123";
        String administrador = "false";

        String messageEsperado = "Cadastro realizado com sucesso";
        int statusCodeEsperado = HttpStatus.SC_CREATED;

        //endregion

        //region Act

        UserObject  userObject = new UserObject(nome, email, password, administrador);

        PostUsuariosRequest postUsuariosRequest = new PostUsuariosRequest();
        postUsuariosRequest.setJsonBody(userObject);

        ValidatableResponse response = postUsuariosRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("message", equalTo(messageEsperado));

        //endregion
    }

    @Test
    public void cadastrarUsuarioRepetido(){
        //region Arrange

        String nome = "Teste QA";
        String email = "beltrano@qa.com.br";
        String password = "teste123";
        String administrador = "false";

        String messageEsperado = "Este email já está sendo usado";
        int statusCodeEsperado = HttpStatus.SC_BAD_REQUEST;

        //endregion

        //region Act

        UserObject  userObject = new UserObject(nome, email, password, administrador);

        PostUsuariosRequest postUsuariosRequest = new PostUsuariosRequest();
        postUsuariosRequest.setJsonBody(userObject);

        ValidatableResponse response = postUsuariosRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("message", equalTo(messageEsperado));

        //endregion
    }

    @Test
    public void cadastrarUsuarioEmailInvalido(){
        //region Arrange

        String nome = "Teste QA";
        String email = "@qa";
        String password = "teste123";
        String administrador = "false";

        String messageEmailEsperado = "email deve ser um email válido";
        int statusCodeEsperado = HttpStatus.SC_BAD_REQUEST;

        //endregion

        //region Act

        UserObject  userObject = new UserObject(nome, email, password, administrador);

        PostUsuariosRequest postUsuariosRequest = new PostUsuariosRequest();
        postUsuariosRequest.setJsonBody(userObject);

        ValidatableResponse response = postUsuariosRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("email", equalTo(messageEmailEsperado));

        //endregion
    }
}
