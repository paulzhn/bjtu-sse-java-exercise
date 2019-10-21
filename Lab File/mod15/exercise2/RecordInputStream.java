import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

public class RecordInputStream extends FilterInputStream {
    private DataInputStream dIn;
    public RecordInputStream(DataInputStream dIn) {
        super(dIn);
        this.dIn = dIn;
    }

    public Record readRecord() throws IOException {
        StringBuffer stringField = new StringBuffer();
        int integerField;
        double doubleField;

        char tmp;
        while((tmp = dIn.readChar()) != ',') {
            stringField.append(tmp);
        }
        integerField = dIn.readInt();
        doubleField = dIn.readDouble();

        return new Record(stringField.toString(), integerField, doubleField);

    }
}
