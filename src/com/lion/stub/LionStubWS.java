package com.lion.stub;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lion.dao.PaxDao;
import com.lion.dao.TransactionDao;
import com.lion.model.BookingResponse;
import com.lion.model.Inquiry;
import com.lion.model.InquiryResponse;
import com.lion.model.Pax;
import com.lion.model.PaxDetailResponse;
import com.lion.model.PaymentNotificationResponse;
import com.lion.model.Schedule;
import com.lion.model.Transaction;
import com.lion.util.Constant;
import com.lion.util.UIDGenerator;

public class LionStubWS {

	 	Logger log = LoggerFactory.getLogger(LionStubWS.class);
	    private TransactionDao transactionDao;	    
	    private PaxDao paxDao;	
	    private static SimpleDateFormat sdfLog = new SimpleDateFormat("dd-MM-yyy HH:mm:ss sss");
	    
	    //EXCLUDED
		public void setTransactionDao(TransactionDao transactionDao) {
			this.transactionDao = transactionDao;			
		}
		
		public void setPaxDao(PaxDao paxDao) {
			this.paxDao = paxDao;			
		}
		
		public InquiryResponse createDummySchedule(Inquiry inq){

			
			InquiryResponse res = new InquiryResponse();
			res.setAirlines(inq.getAirlines());
			res.setDepartureDate(inq.getDepartureDate());
			res.setDestination(inq.getDestination());
			res.setFlightClass(inq.getFlightClass());
			res.setFlightType(inq.getFlightType());
			res.setNumOfPax(inq.getNumOfPax());
			res.setOrigin(inq.getOrigin());
			res.setOutboundTimeRange(inq.getOutboundTimeRange());
			res.setReturnDate(inq.getReturnDate());
			res.setReturnTimeRange(inq.getReturnTimeRange());
			res.setMsisdn(inq.getMsisdn());
			
			Map<String, Schedule[]> mapSchedule = Constant.General.scheduleMap;
			
			//System.out.println(" INIT MAP  = " + mapSchedule.size());
			
			if(inq.getFlightType().equalsIgnoreCase(Constant.General.RETURN_FLIGHT_FLAG)){								
				res.setReturnSchedules(mapSchedule.get(inq.getReturnTimeRange()));
				//System.out.println(" PUT RETURN SCHEDULE  = " + res.getReturnSchedules().length);
			}
			
			res.setOutboundSchedules(mapSchedule.get(inq.getOutboundTimeRange()));
			//System.out.println(" PUT OUTBOUND SCHEDULE  = " + res.getOutboundSchedules().length);						
			
			return res;
		}
	
	    //PUBLISHED
		public InquiryResponse flightInquiry(Inquiry inq){	

			StringBuilder sb = new StringBuilder(1024);	        
	        sb.append(" "+inq.getMsisdn()).append("\t").append(inq.toStringMulti("Action", "Inquiry Request", sdfLog.format(new Date())));
	        log.info(sb.toString());				        
	        
	        InquiryResponse res = createDummySchedule(inq);
	        
	        sb = new StringBuilder(1024);	        
	        sb.append(" "+res.getMsisdn()).append("\t").append(res.toStringMulti("Action", "Inquiry Response", sdfLog.format(new Date())));
	        log.info(sb.toString());
	        
			return createDummySchedule(inq);
		}
	    
		public BookingResponse flightReservation(Transaction trx){
			
			StringBuilder sb = new StringBuilder(1024);	        
	        sb.append(" "+trx.getMsisdn()).append("\t").append(trx.toStringMulti("Action", "Booking Request", sdfLog.format(new Date())));
	        log.info(sb.toString());
			
			Map<String,String> mapfares = Constant.General.priceMap;
			
			BookingResponse resp = new BookingResponse();
			resp.setAdditionalFees(String.valueOf(Constant.General.ADDITIONAL_FEES));
			
			int numOfPax = Integer.parseInt(trx.getNumOfPax());
			int baseFare = 0;
			
			if(trx.getFlightType().equalsIgnoreCase(Constant.General.RETURN_FLIGHT_FLAG)){								
				baseFare = (numOfPax * Integer.parseInt(mapfares.get(trx.getOutboundFlightNumber()))) + (numOfPax * Integer.parseInt(mapfares.get(trx.getReturnFlightNumber())));				
			} else {				
				baseFare = (numOfPax * Integer.parseInt(mapfares.get(trx.getOutboundFlightNumber())));				
			}
			
			int totalFare = baseFare + Constant.General.ADDITIONAL_FEES;
			
			
			
			trx.setTotalFare(String.valueOf(totalFare));
			//resp.setTotalFare(trx.getTotalFare());
			
			resp.setBaseFare(String.valueOf(baseFare));
			String trxId = UIDGenerator.generateUniqueId();
			
			trx.setTransactionId(trxId);
			trx.setFlag(Constant.Transaction.FLAG_BOOKED);
			
			try{
	        	transactionDao.saveTransaction(trx);
	        	trx = transactionDao.getTransaction(trxId);
	        } catch(Exception ex){
	        	ex.printStackTrace();
	        }
			
			resp.setAirlines(trx.getAirlines());
			resp.setBookingCode(trx.getBookingCode());
			resp.setBookingDate(trx.getBookingDate());
			resp.setDepartureDate(trx.getDepartureDate());
			resp.setOutboundDepartureTime(trx.getOutboundDepartureTime());
			resp.setDestination(trx.getDestination());
			resp.setFlag(trx.getFlag());
			resp.setOutboundFlightNumber(trx.getOutboundFlightNumber());
			resp.setReturnFlightNumber(trx.getReturnFlightNumber());
			resp.setFlightType(trx.getFlightType());
			resp.setMsisdn(trx.getMsisdn());
			resp.setNumOfPax(trx.getNumOfPax());
			resp.setOrigin(trx.getOrigin());
			resp.setPaymentCode(trx.getPaymentCode());
			resp.setReturnDate(trx.getReturnDate());
			resp.setReturnDepartureTime(trx.getReturnDepartureTime());
			resp.setTotalFare(trx.getTotalFare());
			resp.setTransactionId(trx.getTransactionId());
			resp.setFlightClass(trx.getFlightClass());
			resp.setOutboundArrivalTime(trx.getOutboundArrivalTime());
			resp.setReturnArrivalTime(trx.getReturnArrivalTime());
			
			sb = new StringBuilder(1024);	        
	        sb.append(" "+trx.getMsisdn()).append("\t").append(resp.toStringMulti("Action", "Booking Response", sdfLog.format(new Date())));
	        log.info(sb.toString());
			
			return resp;
			
		}
		
		public PaxDetailResponse paxInfoReservationDetails(Pax[] listPax){
			String finalMessage = Constant.General.FINAL_MESSAGE;
			String trxId = listPax[0].getTransactionId();
			String paymentCode = String.valueOf(UIDGenerator.generateRandomNumbers(12));
			
			StringBuilder sb = new StringBuilder(1024);
			for(int i =0; i< listPax.length; i++){
				sb.append(" "+listPax[i].getTransactionId()).append("\t").append(listPax[i].toStringMulti("Action", "PaxInfo Request", sdfLog.format(new Date())));
		        log.info(sb.toString());
			}
			
			
			try {
				paxDao.savePax(listPax);
				transactionDao.updateTransactionPaymentCode(paymentCode, trxId);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.HOUR, 6);
			
			finalMessage = finalMessage.replace(Constant.General.DATE_WILDCARD, Constant.General.DATE_FORMATTER.format(cal.getTime()));			
			finalMessage = finalMessage.replace(Constant.General.PAYMENT_CODE_WILDCARD, paymentCode);
			
			PaxDetailResponse res = new PaxDetailResponse();
			res.setMessage(finalMessage);
			res.setPaymentCode(paymentCode);
			res.setTransactionId(trxId);
			
			sb = new StringBuilder(1024);	        
	        sb.append(" "+res.getTransactionId()).append("\t").append(res.toStringMulti("Action", "PaxInfo Response", sdfLog.format(new Date())));
	        log.info(sb.toString());
			
			return res;
		}
		
		public PaymentNotificationResponse paymentReceivedNotification(String transactionId){
			String notif = Constant.General.NOTIF_MESSAGE;
			String bookingCode = String.valueOf(UIDGenerator.generateRandomNumbers(12));
			Transaction trx = null;
			try{
				transactionDao.updateTransactionFlag(Constant.Transaction.FLAG_PAID, transactionId);
				transactionDao.updateTransactionBookingCode(bookingCode, transactionId);
				trx = transactionDao.getTransaction(transactionId);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			notif = notif.replace(Constant.General.PAYMENT_CODE_WILDCARD, trx.getPaymentCode());
			notif = notif.replace(Constant.General.BOOKING_CODE_WILDCARD, trx.getBookingCode());
			
			PaymentNotificationResponse res = new PaymentNotificationResponse();
			res.setBookingCode(bookingCode);
			res.setMessage(notif);
			res.setTransactionId(transactionId);
			
			StringBuilder sb = new StringBuilder(1024);	        
	        sb.append(" "+res.getTransactionId()).append("\t").append(res.toStringMulti("Action", "Payment Notification", sdfLog.format(new Date())));
	        log.info(sb.toString());
			
			return res;
		}
		
}
