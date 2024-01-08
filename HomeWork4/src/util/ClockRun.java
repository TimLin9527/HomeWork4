package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

public class ClockRun implements Runnable
{
	private JLabel time;

	public ClockRun(JLabel label) {
		super();
		this.time = label;
	}
	//Format():String方法,數字格式化為2位數,不足2位要補0,Ex: 22:53:08
	private static String format(int number)
	{
		return number<10? "0"+number:""+number;
	}
	//抓取時間與日期
	private static String getTimeDate()
	{	//日期
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		//時間
		Calendar ca=new GregorianCalendar();
		int Hour=ca.get(Calendar.HOUR_OF_DAY);
		int Minute=ca.get(Calendar.MINUTE);
		int Second=ca.get(Calendar.SECOND);
		
		return sdf.format(d)+" "+format(Hour)+":"+format(Minute)+":"+format(Second);
	}
	
	
		public void run() 
		{
			while(true) 
			{
				time.setText(getTimeDate());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}

