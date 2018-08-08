package com.example.groovydemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by rollean.
 */
@Component
public class TestImplCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        System.out.println("<<<<<<<<<<<<这个是测试CommandLineRunn接口>>>>>>>>>>>>>>" + Arrays.asList(args));
    }
}
