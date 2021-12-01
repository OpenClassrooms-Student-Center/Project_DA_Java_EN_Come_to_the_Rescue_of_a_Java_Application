package com.hemebiotech.analytics;

import com.hemebiotech.analytics.reader.FileSymptomReader;
import com.hemebiotech.analytics.writer.FileSymptomWriter;

public class AnalyticsCounterCommand {

    public static void main(String[] args) {

        CheckArguments(args);

        new AnalyticsCounter(
                new FileSymptomReader(args[0]),
                new FileSymptomWriter(args[1])
        ).Execute();

    }

    private static void CheckArguments(String[] args) {
        if (args.length != 2) {
            System.out.println("You need 2 argument, " + args.length + " provided");
            System.exit(1);
        }
    }
}
