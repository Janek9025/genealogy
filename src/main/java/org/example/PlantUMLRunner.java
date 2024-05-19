package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PlantUMLRunner {


    private static String plantUMLPath;

    public static void setPlantUMLPath(String plantUMLPath) {
        PlantUMLRunner.plantUMLPath = plantUMLPath;
    }

    public static void generateDiagram(String UMLData, String outputDirPath, String outputFileName) {
        File file = new File(outputDirPath + outputFileName + ".txt");
        try {
            FileWriter fileWriter = new FileWriter(file, StandardCharsets.UTF_8);
            fileWriter.write(UMLData);
            fileWriter.close();
            String command = "java " + "-jar " + plantUMLPath + " -charset UTF-8 " + file.getPath() + " -o" + outputDirPath + outputFileName;
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
