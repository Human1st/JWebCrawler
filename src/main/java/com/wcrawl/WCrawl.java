package com.wcrawl;

import java.io.BufferedReader;

import java.io.*;
import java.net.*;
import java.util.HashMap;

public class WCrawl {
    public static void main(String[] args) throws Exception{
        if (args.length != 2) {
            System.out.println("Usage: java -jar JWebCrawler.jar <wordlist> <url>");
        } else {
            HashMap<String, Integer> crawlResult = crawl(args[1], args[0]);
            for (String key : crawlResult.keySet()) {
                System.out.println(key+":"+crawlResult.get(key));
            }
        }
    }

    public static HashMap<String, Integer> crawl(String host, String wordlist) throws Exception{
        File wordlistFile = new File(wordlist);
        HashMap<String, Integer> result = new HashMap<String, Integer>();
                    
        FileReader fileReaderWordlistFile = new FileReader(wordlistFile);
        BufferedReader bufferedReaderWordlistFile = new BufferedReader(fileReaderWordlistFile);
        String line = "";
        while ((line = bufferedReaderWordlistFile.readLine()) != null) {
            result.put(line, Http.getRequestCode(host+"/"+line));
        }
        return result;
    }
}