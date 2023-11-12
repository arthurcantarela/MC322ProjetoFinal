package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    // Método para formatar uma data para o formato "dd/MM/yyyy"
    public static String formatarData(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(data);
    }

}
