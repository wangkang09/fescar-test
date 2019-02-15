package com.wangkang.fescarserver;

import com.alibaba.fescar.server.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FescarServerApplication {

    public static void main(String[] args) {
        //SpringApplication.run(FescarServerApplication.class, args);
        try {
            Server.main(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

