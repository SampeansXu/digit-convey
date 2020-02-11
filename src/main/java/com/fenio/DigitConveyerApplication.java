package com.fenio;

import com.fenio.consist.ResultCode;
import com.fenio.entity.ConveyerResult;
import com.fenio.entity.ConveyerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

/**
 * convey digits to letters application
 */
@SpringBootApplication
public class DigitConveyerApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(DigitConveyerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //1.transfer factory initialize
        if (!ConveyerFactory.getInstance().initialize()) {
            System.out.println("ConveyerFactory initialize failed");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("");
            System.out.println("************************************************************");
            System.out.println("* Choose which you want to do:");
            System.out.println("* 1.Please input array or digits. For example 2,3 or 0-99");
            System.out.println("* 2.Do you want to exit? (Y/N)");
            System.out.println("************************************************************");
            System.out.print("Input:  ");

            //2. wait input
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("y")) {
                //if input "Y" or "y" then exit
                return;
            }

            //3.convey input string
            ConveyerResult conveyResult = ConveyerFactory.getInstance().doConvey(ConveyerFactory.ConveyerType.Digit2Letter, input);
            if (conveyResult.resultCode == ResultCode.Success) {
                //convey succeed, the digits has changed to letters
                System.out.println("Output: " + conveyResult.toString());
            } else {
                //convey failed, print message
                System.out.println("Convey failed. Message:" + conveyResult.resultCode.getMessage());
            }
        }
    }
}
