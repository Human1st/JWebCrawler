package com.jwebcrawler;

import java.io.BufferedReader;

import java.io.*;
import java.net.*;

public class JWebCrawler {
    public static void main(String[] args) throws Exception{
        if (args.length != 2) {
            System.out.println("Usage: java -jar JWebCrawler.jar <wordlist> <url>");
        } else {
            File wordlistFile = new File(args[0]);
            
            
            FileReader fileReaderWordlistFile = new FileReader(wordlistFile);
            BufferedReader bufferedReaderWordlistFile = new BufferedReader(fileReaderWordlistFile);
            String line = "";
            while ((line = bufferedReaderWordlistFile.readLine()) != null) {
                System.out.println(line+":"+Http.getRequestCode(args[1]+"/"+line));
            }
        }
    }
}