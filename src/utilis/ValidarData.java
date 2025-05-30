package utilis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidarData {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    static {
        SDF.setLenient(false);
    }

    public static Date parse(String data) throws ParseException {
        return SDF.parse(data);
    }

    public static String format(Date data) {
        return SDF.format(data);
    }

    public static boolean isValid(String data) {
        try {
            parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}