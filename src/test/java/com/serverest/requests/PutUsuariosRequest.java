package com.serverest.requests;

import com.serverest.bases.RequestRestBase;
import io.restassured.http.Method;

public class PutUsuariosRequest extends RequestRestBase {
    public PutUsuariosRequest(String id){
        requestService = "/usuarios/" + id;
        method = Method.PUT;
    }
    public void setJsonBody(Object object) {
        this.jsonBody = object;
    }
}
