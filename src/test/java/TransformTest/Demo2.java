package TransformTest;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

/**
 * @author vector
 * @date: 2018/10/15 0015 13:55
 */
public class Demo2 {
    public static boolean validDateTime(Date date, Date start, Date end) {
        if (Objects.isNull(date) || Objects.isNull(start) ||Objects.isNull(end) ) {
            return false;
        }
        if (date.after(start) && date.before(end)  ) {
            return true;
        }
        return false;
    }
    public static boolean validDateTime2(Date date, Date start, Date end) {
        if (Objects.isNull(date)) {
            return false;
        }
        if (Objects.isNull(start) || date.before(start)) {
            return false;
        }
        if (Objects.isNull(end) || date.after(end)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws ParseException {
        Date currentDate = new Date();
        Date start = DateFormatUtils.ISO_DATE_FORMAT.parse("2018-10-15");
        Date end = DateFormatUtils.ISO_DATE_FORMAT.parse("2070-01-01");

        System.out.println(validDateTime(currentDate,start,end));
        System.out.println(validDateTime2(currentDate,start,end));
    }

}
