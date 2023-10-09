package com.serverest.tests;

import com.serverest.steps.CriacaoDeUsuario;
import com.serverest.bases.TestBase;
import com.serverest.jsonObjects.UserObject;
import com.serverest.requests.PutUsuariosRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class PutUsuariosTests extends TestBase {
    @Test
    public void editarUsuarioComSucesso(){

        //massa de dados
        CriacaoDeUsuario criacaoDeUsuario = new CriacaoDeUsuario();
        criacaoDeUsuario.criarUsuario();
        //endregion

        //region Arrange

        String id = criacaoDeUsuario.idUsuario;

        String nome = "Teste QA";
        String email = criacaoDeUsuario.email;
        String password = "teste123";
        String administrador = "false";

        String messageEsperado = "Registro alterado com sucesso";
        int statusCodeEsperado = HttpStatus.SC_OK;

        //endregion

        //region Act

        UserObject userObject = new UserObject(nome, email, password, administrador);

        PutUsuariosRequest putUsuariosRequest = new PutUsuariosRequest(id);
        putUsuariosRequest.setJsonBody(userObject);

        ValidatableResponse response = putUsuariosRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("message", equalTo(messageEsperado));

        //endregion
    }
}
