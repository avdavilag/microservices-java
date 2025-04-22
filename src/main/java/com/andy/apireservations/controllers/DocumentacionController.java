package com.andy.apireservations.controllers;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import reactor.netty.http.server.HttpServerResponse;
import org.springframework.web.bind.annotation.GetMapping;


@Hidden
@Controller
@RequestMapping("documentation")
public class DocumentacionController {

    @ResponseBody
    @GetMapping
    public void readToDocumentation(HttpServletResponse  response) {
        try {
            response.sendRedirect("swagger-ui.html");
        } catch (IOException e) {
            StringBuilder sb = new StringBuilder("UNEXPECTED ERROR: ");
            if (e.getMessage() != null) {
                sb.append(e.getMessage());
            }
        }

    }

}
