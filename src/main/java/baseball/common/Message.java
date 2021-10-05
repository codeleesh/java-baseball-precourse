package baseball.common;

public enum Message {
    INPUT("", "숫자를 입력해주세요 : "),
    END("", "3개의 숫자를 모두 맞히셨습니다! 게임 끝"),
    RETRY("", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    SIZE(Constant.STR_ERROR, "3자리를 입력하셔야 합니다."),
    DUPLICATE(Constant.STR_ERROR,"중복된 값이 존재합니다."),
    CHARACTER(Constant.STR_ERROR,"1~9 사이의 숫자를 입력해야 합니다.");

    private String code;
    private String detail;

    Message(String code, String detail) {
        this.detail = detail;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return getMessage(Constant.STR_EMPTY);
    }

    public String getMessage(String code) {
        String str = Constant.STR_EMPTY;
        if( Constant.STR_EMPTY.equals(code) ) str = detail;
        if( Constant.STR_ERROR.equals(code) ) str = "[ERROR] " + detail;
        return str;
    }
}
