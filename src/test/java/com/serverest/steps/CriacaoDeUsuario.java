package com.serverest.steps;

import com.github.javafaker.Faker;
import com.serverest.bases.TestBase;
import com.serverest.jsonObjects.UserObject;
import com.serverest.requests.PostUsuariosRequest;
import io.restassured.response.ValidatableResponse;

public class CriacaoDeUsuario extends TestBase {

    public static String idUsuario;
    public static String email;

    public void criarUsuario() {
        //region Arrange

        Faker faker = new Faker();
        String nome = "Teste QA";
        email = faker.random().hex(6) + "@qa.com.br";
        String password = "teste123";
        String administrador = "false";

        //endregion

        //region Act

        UserObject userObject = new UserObject(nome, email, password, administrador);

        PostUsuariosRequest postUsuariosRequest = new PostUsuariosRequest();
        postUsuariosRequest.setJsonBody(userObject);

        ValidatableResponse response = postUsuariosRequest.executeRequest();

        //endregion

        idUsuario = response.extract().jsonPath().getString("_id");
    }
}
