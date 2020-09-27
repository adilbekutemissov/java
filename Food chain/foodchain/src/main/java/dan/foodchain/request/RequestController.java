package dan.foodchain.request;

import com.lowagie.text.DocumentException;
import dan.foodchain.channel.ButterChannel;
import dan.foodchain.channel.CheeseChannel;
import dan.foodchain.channel.EggsChannel;
import dan.foodchain.channel.MeatChannel;
import dan.foodchain.channel.MilkChannel;
import dan.foodchain.configuration.ConfigurationInfo;
import dan.foodchain.error.Error;
import dan.foodchain.party.Grower;

import java.io.FileNotFoundException;

/**
 *
 * @author shukanaz
 */
public class RequestController {

    public static String[] arrayWithPartsOfCommand;

    private static void sendCommandToChannel(String command, String channel) {
        switch(channel.toLowerCase()){
            case "butter":
                ButterChannel.setCommand(command);
                ButterChannel.handleCommand(command);
                break;
            case "cheese":
                CheeseChannel.setCommand(command);
                CheeseChannel.handleCommand(command);
                break;
            case "eggs":
                EggsChannel.setCommand(command);
                EggsChannel.handleCommand(command);
                break;
            case "beef":
            case "chicken":
            case "pork":
                MeatChannel.setCommand(command);
                MeatChannel.handleCommand(command);
                break;
            case "milk":
                MilkChannel.setCommand(command);
                MilkChannel.handleCommand(command);
                break;
        }
    }

    /**
     * Method which validate user's request and handle it depends on it's length
     * in case of length = 2 application will print info of requested party
     * in case of length = 3 application will add requested amount of requested food to Grower
     * in case of length = 7 application will send requested amount of food from party to party
     * in case of other length application will print error message and will wait for another request
     *
     * @param command - request which is sent by user
     */

    public static void validateCommand(String command) {
        arrayWithPartsOfCommand = command.split(" ");
        switch(arrayWithPartsOfCommand.length) {
            case 2:
                if(RequestValidation.checkIfTwoWordRequestIsValid(arrayWithPartsOfCommand))
                    ConfigurationInfo.printInfoAboutParty(arrayWithPartsOfCommand[0]);
                break;
            case 3:
                if(RequestValidation.checkIfThreeWordRequestIsValid(arrayWithPartsOfCommand))
                    Grower.growNewFood(arrayWithPartsOfCommand[1], arrayWithPartsOfCommand[2]);
                break;
            case 7:
                if(RequestValidation.checkIfCommandIsValid(arrayWithPartsOfCommand))
                    sendCommandToChannel(command, arrayWithPartsOfCommand[2]);
                break;
            default:
                Error.requestLengthError();
        }
    }
    
}
