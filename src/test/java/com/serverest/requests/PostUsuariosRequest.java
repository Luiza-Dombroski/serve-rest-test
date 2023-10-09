package com.serverest.requests;

import com.serverest.bases.RequestRestBase;
import io.restassured.http.Method;

public class PostUsuariosRequest extends RequestRestBase {
    public PostUsuariosRequest(){
        requestService = "/usuarios";
        method = Method.POST;
    }
    public void setJsonBody(Object object) {
        this.jsonBody = object;
    }
}

