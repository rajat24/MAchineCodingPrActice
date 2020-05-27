package miniSocialNetwork;
import java.sql.Timestamp;
import java.util.Date;

public class getTimestamp {

	public Timestamp getCurrentTimestamp() {
	Date date = new Date();
	Timestamp ts=new Timestamp(date.getTime());
	//System.out.println(ts);
	return ts;
	}
}
