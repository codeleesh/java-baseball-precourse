package baseball.controller;

import baseball.common.Constant;
import baseball.common.Message;
import baseball.domain.BaseBall;
import baseball.dto.BaseBallDto;
import baseball.util.BaseBallUtil;
import baseball.view.BaseBallView;
import nextstep.utils.Console;

public class BaseBallController {
    private final BaseBallView baseBallView;

    public BaseBallController(BaseBallView baseBallView) {
        this.baseBallView = baseBallView;
    }

    public void getStart(int[] randomNum) {
        int strike;
        do {
            baseBallView.printMessageNoLine(Message.INPUT.getMessage());
            int[] inputNum = this.getInputNum();
            strike = getValidateNum(randomNum, inputNum);
        } while(strike != 3);
        baseBallView.printMessage(Message.END.getMessage());
        baseBallView.printMessage(Message.RETRY.getMessage());
    }

    public int getValidateNum(int[] randomNum, int[] inputNum) {
        int strike = Constant.INT_ZERO;
        if( validateNum(inputNum)) {
            BaseBallDto baseBallDto = BaseBallUtil.checkNum(randomNum, inputNum);
            String message = BaseBallUtil.updateMessage(baseBallDto.getStrike(), baseBallDto.getBall());
            baseBallView.printMessage(message);
            strike = baseBallDto.getStrike();
        }
        return strike;
    }

    public int[] getInputNum() {
        String input = Console.readLine();
        BaseBall baseBall = new BaseBall(BaseBallUtil.getInputStrToNums(input));
        return baseBall.getInputNums();
    }

    public int[] getGenerateRandomNum() {
        return BaseBallUtil.getRandomGenerateNum();
    }

    public boolean validateNum(int[] inputNum) {
        return !(!sizeCheckNum(inputNum) || !duplicateNum(inputNum)
                || !charactersCheckNum(inputNum));
    }

    public boolean sizeCheckNum(int[] inputNum) {
        boolean result = true;
        if( !BaseBallUtil.sizeCheckNum(inputNum) ) {
            baseBallView.printMessage(Message.SIZE.getMessage(Constant.STR_ERROR));
            result = false;
        }
        return result;
    }

    public boolean duplicateNum(int[] inputNum) {
        boolean result = true;
        if( !BaseBallUtil.duplicateNum(inputNum) ) {
            baseBallView.printMessage(Message.DUPLICATE.getMessage(Constant.STR_ERROR));
            result = false;
        }
        return result;
    }

    public boolean charactersCheckNum(int[] inputNum) {
        boolean result = true;
        if( !BaseBallUtil.charactersCheckNum(inputNum) ) {
            baseBallView.printMessage(Message.CHARACTER.getMessage(Constant.STR_ERROR));
            result = false;
        }
        return result;
    }

}
