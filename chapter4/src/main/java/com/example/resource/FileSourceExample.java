package com.example.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by heyao on 2017/3/13.
 */
public class FileSourceExample {

    public static void main(String[] args) {
        String filePath = "/Users/heyao/JavaProjects/chapter4/src/main/resources/file1.txt";
        //1、使用系统文件路径方式加载文件
        WritableResource res1 = new PathResource(filePath);

        //2、使用类路径方式加载文件
        ClassPathResource res2 = new ClassPathResource("file1.txt");
        try {
            OutputStream outStream1 = res1.getOutputStream();
            outStream1.write("我说了所有的谎\n你全都相信\n".getBytes());
            outStream1.close();

            InputStream stream1 = res1.getInputStream();
            InputStream stream2 = res2.getInputStream();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int i;
            while ((i = stream2.read()) != -1) {
                baos.write(i);
            }
            System.out.println(baos.toString());
            System.out.println("fileName:" + res1.getFilename());
            System.out.println("fileName:" + res2.getFilename());


            ClassPathResource pathResource = new ClassPathResource("file2.txt");
            EncodedResource resource = new EncodedResource(pathResource, "UTF-8");

            String content = FileCopyUtils.copyToString(resource.getReader());
            System.out.print("content: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
