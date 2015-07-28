package com.Tracking;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TrackingNumber{
	@Override
	public String toString() {
		return "TrackingNumber [r=" + r + ", transferCode=" + transferCode + ", statusCode=" + statusCode + "]";
	}
	private Range r;
	private String transferCode;
	private String statusCode;
	
	public TrackingNumber() {
		super();
	}
	public TrackingNumber(Range r, String transferCode, String statusCode) {
		super();
		this.r = r;
		this.transferCode = transferCode;
		this.statusCode = statusCode;
	}
	public Range getRange() {
		return r;
	}
	public void setRange(Range r) {
		this.r = r;
	}
	public String getTransferCode() {
		return transferCode;
	}
	public void setTransferCode(String transferCode) {
		this.transferCode = transferCode;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public List<TrackingNumber> processInput(TrackingNumber input, List<TrackingNumber> outputRange) {
		// TODO Auto-generated method stub
		for (Iterator iterator = outputRange.iterator(); iterator.hasNext();) {
			TrackingNumber output = (TrackingNumber) iterator.next();
			if(input.getRange().classify(output.getRange()).equals(Range.Relation.MOREDISJOINT))
			{
				System.out.println("MOREDISJOINT");
			}
			else if(input.getRange().classify(output.getRange()).equals(Range.Relation.LESSDISJOINT)){
				System.out.println("LESSDISJOINT");	
			}
			else if(input.getRange().classify(output.getRange()) .equals( Range.Relation.LESSOVERLAP)){
				System.out.println("LESSOVERLAP");
			}
			else if(input.getRange().classify(output.getRange()) .equals( Range.Relation.MOREOVERLAP)){
				System.out.println("MOREOVERLAP");
			}
			else if(input.getRange().classify(output.getRange()) .equals( Range.Relation.SAME)){
				System.out.println("SAME");
			}
			else if(input.getRange().classify(output.getRange()) .equals( Range.Relation.SUBSET)){
				System.out.println("SUBSET");
				
			}
			else if(input.getRange().classify(output.getRange()) .equals( Range.Relation.SUPERSET)){
				System.out.println("SUPERSET");
			}	
			System.out.println(input);
			System.out.println(output);
		}
		
		return outputRange;
		
	}
	
}
public class MainClass {
	public static void main(String[] args) throws IOException{
		List<TrackingNumber> inputConstraintRange = new ArrayList<TrackingNumber>();
		inputConstraintRange=readFromFile("C:/Users/test/workspace/TrackingNumber/bin/com/Tracking/input.txt");
		
		List<TrackingNumber> outputRange = new ArrayList<TrackingNumber>();
		TrackingNumber firstRecord=new TrackingNumber(new Range(1,100000),"A","1");
		outputRange.add(firstRecord);
		for (Iterator iterator = inputConstraintRange.iterator(); iterator.hasNext();) {
			TrackingNumber trackingNumber = (TrackingNumber) iterator.next();
		//	System.out.println(trackingNumber);
			outputRange=trackingNumber.processInput(trackingNumber,outputRange);
		}
	
		
	}

	private static List<TrackingNumber> readFromFile(String path) throws IOException {
		BufferedReader reader=new BufferedReader(new FileReader(path));
		String contentFromFile="";
		
		contentFromFile=reader.readLine();
		List<TrackingNumber> allTrackingRange = new ArrayList<TrackingNumber>();
		
		while ((contentFromFile=reader.readLine()) != null) {
			
			System.out.println(contentFromFile);
			if(contentFromFile.equals("0")){
				break;
//				contentFromFile=reader.readLine();
			}
			else{
			String[] splittedValues = contentFromFile.split(" ");
			TrackingNumber number=new TrackingNumber();
			
			number.setRange(
					new Range(
							Integer.parseInt(splittedValues[0]),
							Integer.parseInt(splittedValues[1])));
			
			number.setStatusCode(splittedValues[2]);
			number.setTransferCode(splittedValues[3]);
			
			allTrackingRange.add(number);
			}
			
		}
		return allTrackingRange;
	}
	
}
