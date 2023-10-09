package com.serverest.tests;

import com.serverest.bases.TestBase;
import com.serverest.requests.DeleteUsuariosRequest;
import com.serverest.steps.CriacaoDeUsuario;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class DeleteUsuariosTests extends TestBase {
    @Test
    public void deletarUsuarioComSucesso() {
        //massa de dados
        CriacaoDeUsuario criacaoDeUsuario = new CriacaoDeUsuario();
        criacaoDeUsuario.criarUsuario();
        //endregion

        //region Arrange

        String id = criacaoDeUsuario.idUsuario;

        String messageEsperadoo = "Registro excluído com sucesso";
        int statusCodeEsperadoo = HttpStatus.SC_OK;

        //endregion

        //region Act

        DeleteUsuariosRequest deleteUsuariosRequest = new DeleteUsuariosRequest(id);

        ValidatableResponse responsee = deleteUsuariosRequest.executeRequest();

        //endregion

        //region Assert

        responsee.statusCode(statusCodeEsperadoo);
        responsee.body("message", equalTo(messageEsperadoo));

        //endregion
    }

    @Test
    public void deletarUsuarioIdInexistente() {
        //region Arrange

        String id = "23445312354342";

        String messageEsperado = "Nenhum registro excluído";
        int statusCodeEsperado = HttpStatus.SC_OK;

        //endregion

        //region Act

        DeleteUsuariosRequest deleteUsuariosRequest = new DeleteUsuariosRequest(id);

        ValidatableResponse response = deleteUsuariosRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("message", equalTo(messageEsperado));

        //endregion
    }
}
