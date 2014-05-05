package com.lion.util;

import java.util.Random;
import java.util.UUID;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

public class UIDGenerator {
	
	public synchronized static String generateUniqueId() {
	
		  // need to pass Ethernet address; can either use real one (shown here)
		  //EthernetAddress nic = EthernetAddress.fromInterface();
		  EthernetAddress nic = EthernetAddress.constructMulticastAddress();
		  // or bogus which would be gotten with: EthernetAddress.constructMulticastAddress()
		  TimeBasedGenerator uuidGenerator = Generators.timeBasedGenerator(nic);
		  
		  // also: we don't specify synchronizer, getting an intra-JVM syncer; there is
		  // also external file-locking-based synchronizer if multiple JVMs run JUG
		  UUID uuid = uuidGenerator.generate();	

	  return uuid.toString().replaceAll("-", "").toUpperCase();
	}

	public synchronized static long generateRandomNumbers(int length) {
	    Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}
	
	public static void main(String args[]){
		
		for (int i = 0; i < 20; i++) {
			System.out.println(generateRandomNumbers(12));
		}
		
		
	}
	
}
