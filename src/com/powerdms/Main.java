package com.powerdms;


import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.wordperfect.WordPerfectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ContentHandler;

public class Main {

    public static void main(String[] args) throws IOException, TikaException, SAXException {
        //https://lucidworks.com/post/content-extraction-with-tika/
        String path = "C:\\Users\\james.faix\\Desktop\\ES supported file types - sample files-20190917T180139Z-001\\Files2\\test.wpd";
        InputStream input = new FileInputStream(new File(path));
        BodyContentHandler textHandler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        WordPerfectParser parser = new WordPerfectParser();
        parser.parse(input, textHandler, metadata);
        input.close();
        String text = textHandler.toString();
        System.out.println(text);
        System.in.read();
    }
}
