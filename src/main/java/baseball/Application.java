package baseball;

import baseball.common.Constant;
import baseball.controller.BaseBallController;
import baseball.view.BaseBallView;
import nextstep.utils.Console;

public class Application {
    public static void main(String[] args) {
        function();
    }

    public static void function() {
        BaseBallView baseBallView = new BaseBallView();
        BaseBallController baseBallController = new BaseBallController(baseBallView);

        int[] randomNum = baseBallController.getGenerateRandomNum();
        baseBallController.getStart(randomNum);
        getRetry();
    }

    public static void getRetry() {
        String input = Console.readLine();
        if( Constant.STR_ONE.equals(input) ) {
            Application.function();
        }
    }
}
