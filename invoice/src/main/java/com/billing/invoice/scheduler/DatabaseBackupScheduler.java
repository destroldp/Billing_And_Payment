package com.billing.invoice.scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DatabaseBackupScheduler {

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${backup.file.path}")
    private String backupFilePath;

    @Value("${pgdump.path}")
    private String pgDumpPath;


    @Scheduled(cron = "0 * * * * ?")
    public void backupDatabase() {
        try {
            // Replace "your-batch-file.bat" with the actual name of your batch file
            String batchFilePath = "C:\\Users\\LENOVO\\Documents\\bacup_script.bat";

            // Create a ProcessBuilder with the batch file as the command
            ProcessBuilder processBuilder = new ProcessBuilder(batchFilePath);

            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to complete (optional)
            int exitCode = process.waitFor();

            // Print the exit code (optional)
            System.out.println("Batch file exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}

