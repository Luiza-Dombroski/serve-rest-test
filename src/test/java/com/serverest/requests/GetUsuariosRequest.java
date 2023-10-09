package com.serverest.requests;

import com.serverest.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetUsuariosRequest extends RequestRestBase {
    public GetUsuariosRequest() {
        requestService = "/usuarios/";
        method = Method.GET;
    }
}
