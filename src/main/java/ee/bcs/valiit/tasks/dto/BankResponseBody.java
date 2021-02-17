package ee.bcs.valiit.tasks.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BankResponseBody {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String message;

    public BankResponseBody(String mx){
        setMessage(mx);

    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
