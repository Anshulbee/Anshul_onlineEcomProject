package org.example.scr;

import org.example.utils.postAPI;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginAPI extends postAPI {

    public LoginAPI() throws IOException {
        super("loginAPI","loginJsonPath");
    }

}
