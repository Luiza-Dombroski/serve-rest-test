package com.serverest.tests;

import com.serverest.bases.TestBase;
import com.serverest.requests.GetUsuariosRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.notNullValue;

public class GetUsuariosTests extends TestBase {
    @Test
    public void buscaUsuariosSucesso(){
        //region Arrange

        int statusCodeEsperado = HttpStatus.SC_OK;

        //endregion

        //region Act

        GetUsuariosRequest getUsuariosRequest = new GetUsuariosRequest();
        ValidatableResponse response = getUsuariosRequest.executeRequest();

        //endregion

        //region Assert
    
        response.statusCode(statusCodeEsperado);
        response.body("usuarios", notNullValue());

        //endregion
    }
}
