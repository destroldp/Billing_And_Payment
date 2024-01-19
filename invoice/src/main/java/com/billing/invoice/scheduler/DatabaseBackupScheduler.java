package com.billing.invoice.scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DatabaseBackupScheduler {

    @Scheduled(cron = "30 12 * * * ?")
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

