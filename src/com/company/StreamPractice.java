package com.company;

import java.io.*;

public class StreamPractice {

    private void contentCopyFile(){


        File file = new File("/home/nikita/IdeaProjects/Server/misha");
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 0; i < 100000; i++) {
                fileWriter.write("Pisos "+ i +"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("/home/nikita/IdeaProjects/Server/misha");
             FileOutputStream out = new FileOutputStream("/home/nikita/IdeaProjects/Server/второй миша")){
            int bytesRead = 0;
            byte[] buffer = new byte[1];
            while ((bytesRead = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            fis.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
