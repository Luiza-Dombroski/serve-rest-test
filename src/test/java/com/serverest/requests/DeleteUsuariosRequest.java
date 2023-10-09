package com.serverest.requests;

import com.serverest.bases.RequestRestBase;
import io.restassured.http.Method;

public class DeleteUsuariosRequest extends RequestRestBase {
    public DeleteUsuariosRequest(String id){
        requestService = "/usuarios/" + id;
        method = Method.DELETE;
    }
    public void setJsonBody(Object object) {
        this.jsonBody = object;
    }
}
