package com.lion.util;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.lion.model.Schedule;

public class Constant {

	public static class Pax{		
		public static final String TRX_ID = "TRX_ID";
		public static final String TITLE = "TITLE";
		public static final String PAX_NAME = "PAX_NAME";
		public static final String PAX_SSN = "PAX_SSN";
		
		public static final String PAX_FIELDS_QUERY = TRX_ID + ", " + TITLE + ", " + PAX_NAME + ", " +PAX_SSN;
	}
	
	public static class Transaction {
								
		public static final String FLAG_BOOKED = "B";
		public static final String FLAG_PAID = "P";
		public static final String FLAG_CANCELED = "C";
		
		//fields
		public static final String TRX_ID = "TRX_ID";
		public static final String BOOKING_CODE = "BOOKING_CODE";
		public static final String OUTBOUND_FLIGHT_NUMBER = "OUTBOUND_FLIGHT_NUMBER";
		public static final String RETURN_FLIGHT_NUMBER = "RETURN_FLIGHT_NUMBER";
		public static final String FLIGHT_CLASS = "FLIGHT_CLASS";
		public static final String DEPARTURE_DATE = "DEPARTURE_DATE";
		public static final String OUTBOUND_DEPARTURE_TIME = "OUTBOUND_DEPARTURE_TIME";
		public static final String RETURN_DEPARTURE_TIME = "RETURN_DEPARTURE_TIME";
		public static final String RETURN_DATE = "RETURN_DATE";
		public static final String RETURN_ARRIVAL_TIME = "RETURN_ARRIVAL_TIME";
		public static final String OUTBOUND_ARRIVAL_TIME = "OUTBOUND_ARRIVAL_TIME";
		public static final String FLIGHT_TYPE = "FLIGHT_TYPE";
		public static final String NUM_OF_PAX = "NUM_OF_PAX";
		public static final String TOTAL_FARES = "TOTAL_FARES";
		public static final String ORIGIN = "ORIGIN";
		public static final String DESTINATION = "DESTINATION";
		public static final String MSISDN = "MSISDN";
		public static final String AIRLINES = "AIRLINES";
		public static final String BOOKING_DATE = "BOOKING_DATE";
		public static final String FLAG = "FLAG";
		public static final String PAYMENT_CODE = "PAYMENT_CODE";
		
		public static final String TRX_FIELDS_QUERY = TRX_ID + ", " + BOOKING_CODE + ", " + OUTBOUND_FLIGHT_NUMBER+ ", " +DEPARTURE_DATE+ ", " +OUTBOUND_DEPARTURE_TIME+ ", " +RETURN_DATE+ ", " +RETURN_DEPARTURE_TIME+ ", " +FLIGHT_TYPE
													  + ", " + NUM_OF_PAX + ", " + TOTAL_FARES + ", " + ORIGIN + ", " + DESTINATION + ", " + MSISDN+ ", " +AIRLINES+ ", " +BOOKING_DATE+ ", " +FLAG+ ", " +PAYMENT_CODE
													  + ", " +RETURN_FLIGHT_NUMBER+ ", " +FLIGHT_CLASS+ ", " +OUTBOUND_ARRIVAL_TIME+ ", " +RETURN_ARRIVAL_TIME;
	}
	
	public static class General{
		public static final String RETURN_FLIGHT_FLAG = "R";
		public static final String SINGLE_FLIGHT_FLAG = "S";
		public static final String MORNING = "MORNING";
		public static final String AFTERNOON = "AFTERNOON";
		public static final String NIGHT = "NIGHT";
		public static final String OUTBOUND_FLIGHT = "OUTBOUND";
		public static final String RETURN_FLIGHT = "RETURN";
		public static final int ADDITIONAL_FEES = 366000;
				
		public static final String DATE_WILDCARD = "dd MMM, yyyy, HH:mm";
		public static final String PAYMENT_CODE_WILDCARD = "XXX";
		public static final String BOOKING_CODE_WILDCARD = "ZZZ";
		public static final String FINAL_MESSAGE = "Silahkan melakukan pembayaran sebelum " + DATE_WILDCARD + " dengan kode pembayaran " + PAYMENT_CODE_WILDCARD + " . Booking code akan dikirimkan melalui sms setelah pembayaran dilakukan.";
		public static final String NOTIF_MESSAGE = "Terima kasih atas pembayaran tiket Lion Air dengan kode pembayaran " + PAYMENT_CODE_WILDCARD + " . Gunakan booking code "+ BOOKING_CODE_WILDCARD +" untuk ditukarkan dengan tiket penerbangan.";
		
		public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_WILDCARD);
		
		@SuppressWarnings("serial")
		public static final Map<String, Schedule[]> scheduleMap = Collections.unmodifiableMap(
			    new HashMap<String, Schedule[]>() {{			    				    				    	
			        put(MORNING, new Schedule[]{new Schedule("#1", "JT535", "05.00", "07.00", "530000"), new Schedule("#2", "JT530", "07.00", "09.00", "516000"), new Schedule("#3", "JT350", "09.00", "11.00", "550000")});
			        put(AFTERNOON, new Schedule[]{new Schedule("#1", "JT555", "11.00", "13.00", "660000"), new Schedule("#2", "JT330", "13.00", "15.00", "700000"), new Schedule("#3", "JT550", "15.00", "17.00", "550000"), new Schedule("#4", "JT355", "17.00", "19.00", "800.000")});
			        put(NIGHT, new Schedule[]{new Schedule("#1", "JT333", "19.00", "21.00", "540000"), new Schedule("#2", "JT503", "21.00", "23.00", "516000"), new Schedule("#3", "JT305", "23.00", "01.00", "450000")});			        			
			    }});
		
		@SuppressWarnings("serial")
		public static final Map<String, String> priceMap = Collections.unmodifiableMap(
			    new HashMap<String, String>() {{			    				    				    	
			        put("JT535","530000");put("JT530","516000");put("JT350","550000");
			        put("JT555","660000");put("JT330","700000");put("JT550","550000");put("JT355","800.000");
			        put("JT333","540000");put("JT503","516000");put("JT305","450000");			        			
			    }});
	}
	
}
