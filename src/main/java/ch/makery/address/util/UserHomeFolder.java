package ch.makery.address.util;


import java.io.*;
import java.util.stream.Collectors;

public class UserHomeFolder {

    public static void writeFile(String applicationName, String folderName, String fileName, String fileContent) throws IOException {

        String fileSeparator = System.getProperty("file.separator");
        String userHomeAppDirectoryName = getAndCreateFolder(applicationName, folderName) + fileSeparator + fileName;

        File file = new File(userHomeAppDirectoryName);
        try (
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            bw.write(fileContent);
        }
    }

    public static String getAndCreateFolder (String applicationName, String folderName) {
        String homePath = System.getProperty("user.home");
        String fileSeparator = System.getProperty("file.separator");
        String userHomeAppDirectoryName = homePath + fileSeparator + applicationName + fileSeparator + folderName;


        File directory = new File(userHomeAppDirectoryName);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        return userHomeAppDirectoryName;
    }

    public static String readFile(String applicationName, String folderName, String fileName) throws IOException {
        String fileSeparator = System.getProperty("file.separator");
        String userHomeAppDirectoryName = getAndCreateFolder(applicationName, folderName) + fileSeparator + fileName;

        File file = new File(userHomeAppDirectoryName);
        try (BufferedReader buffer = new BufferedReader(new FileReader(file.getAbsoluteFile())) ){
            return buffer.lines().collect(Collectors.joining());
        }
    }
}
