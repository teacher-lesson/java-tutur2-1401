package org.example.service.input;

import java.util.Date;

public interface InputService {

    String readWord();
    String readEnglishWord();
    int readNumber();
    long readBigNumber();
//    double readDouble(); //TODO
    Date readDate();
}
