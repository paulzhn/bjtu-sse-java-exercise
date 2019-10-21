import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class RecordOutputStream extends DataOutputStream {
    public RecordOutputStream(OutputStream dOut) {
        super(dOut);
    }

    public void writeRecord(Record record) throws IOException {
        String stringField = record.getStringField();
        Integer intField = record.getIntegerField();
        Double doubleField = record.getDoubleField();
        for (int i = 0; i < stringField.length(); i++) {
            out.write(stringField.charAt(i));
        }
        out.write(',');
        for (int i = 0; i < intField.toString().length(); i++) {
            out.write(intField.toString().charAt(i));
        }
        out.write(',');
        for (int i = 0; i < doubleField.toString().length(); i++) {
            out.write(doubleField.toString().charAt(i));
        }
        out.write('\n');
    }
}
