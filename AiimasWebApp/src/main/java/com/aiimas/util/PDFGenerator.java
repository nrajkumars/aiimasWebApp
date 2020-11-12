package com.aiimas.util;



	import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.aiimas.dao.MasterTableValues;
import com.aiimas.dao.PrintView;
import com.aiimas.dao.Verification;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Anchor;
	import com.itextpdf.text.BadElementException;
	import com.itextpdf.text.BaseColor;
	import com.itextpdf.text.Chapter;
	import com.itextpdf.text.Document;
	import com.itextpdf.text.DocumentException;
	import com.itextpdf.text.Element;
	import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

//	import com.itextpdf.io.image.ImageData; 
//	import com.itextpdf.io.image.ImageDataFactory; 
//	import com.itextpdf.layout.element.Image;  
	
import com.itextpdf.text.Image;
	import com.itextpdf.text.List;
	import com.itextpdf.text.ListItem;
	import com.itextpdf.text.Paragraph;
	import com.itextpdf.text.Phrase;
	import com.itextpdf.text.Section;
	import com.itextpdf.text.pdf.PdfPCell;
	import com.itextpdf.text.pdf.PdfPTable;
	import com.itextpdf.text.pdf.PdfWriter;

	public class PDFGenerator {
	    //private static String FILE = "c:/temp/FirstPdf.pdf";
	    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.BOLD);
	    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.NORMAL, BaseColor.RED);
	    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
	            Font.BOLD);
	    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 9,
	            Font.BOLD);
	    private static Font smallfont = new Font(Font.FontFamily.TIMES_ROMAN, 9,
	            Font.NORMAL);
	    
	    
	    
	    
	    // for print pdf using itextPDF
	    public String PrintLetterPDF(Map input, Map data) {
	    	String genPDFfile ="c:/temp/FirstPdf.pdf";
	        try {
	        	
	        	
	        	Object action = input.get("action");
	        	System.out.println(" RESPONSE  CALLING PDF generration  ----------------  in prindPDF LETTER = "+action.toString());
	            Document document = new Document();
	            PdfWriter.getInstance(document, new FileOutputStream(genPDFfile));
	            document.open();
	            addMetaData(document);
	         //   addLOGOPage(document); // add the header image
	            
	            
				
			
	            
	            
	            // for each Report this has to be changed
	            if(action != null && action.equals("QPaperList")) {  // Question paper list 
	            	addQuestionPaperList(document, input,data);
	            }else if(action != null && action.equals("applicantList")) { // RAJKUMAR  applicant List
	            	addApplicantList(document, input, data);
	            }else if(action != null && action.equals("AttendChart")) {  // attendance Chart
	            	addAttendanceChart(document, input, data);
	            }
	           	           
	          //  addTitlePage(document); // refer for sample
	          //  addContent(document); // refer for sample
	            
	            document.close();
	            return genPDFfile;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

//RAJKUMAR
//	public Map saveAccountDetails(Map data) {
//		Iterator iter = data.keySet().iterator();
//		Map dataToSave = new HashMap();
//		while (iter.hasNext()) {
//			String key = (String) iter.next();
//			String val[] = (String[]) data.get(key);
//			if (val != null && val.length > 0 && val[0].trim().length() > 0) {
//				dataToSave.put(key, val[0]);
//				System.out.println(key + ":" + val[0]);
//			}
//		}
	    
	    
	    
	    
	    
	    
	    //Question paper list
	    private static void addQuestionPaperList(Document document, Map input,  Map data)
	            throws DocumentException, Exception {
	    	
	    	//PrintView printView = new PrintView();
	    	//Map verifyedValues = printView.getMarkSheetContent(input);
			
			System.out.println(" RESPONSE  LETTER in Question PaperList   GOT in DATA MAP -- "+data);
			System.out.println(" RESPONSE  LETTER in Question PaperList list  GOT in INPUT MAP -- "+input);
			
			
			//rajkumar todo read map

			ObjectMapper oMapper = new ObjectMapper();
			Iterator<String> iter = data.keySet().iterator();
	  
	        Paragraph preface = new Paragraph();
	   
	        //addEmptyLine(preface, 1);
	    
        preface.add(new Paragraph("QUESTION PAPER LIST", catFont));

	        //addEmptyLine(preface, 1);
	        
	  	        
	        //TODo
	        String sesMonth = new String ("AUG");
			String sesYear = new String("2020");
	        
	        preface.add(new Paragraph(
	                " Question paper pick list for the "+sesMonth+" "+sesYear+" Examination.", smallBold));
	        
	        addEmptyLine(preface, 1);
	 
	        preface.add(new Paragraph(
	                " CENTRE: ", smallBold));
	        preface.add(new Paragraph(
	                " SESSION: ", smallBold));
	       // addEmptyLine(preface, 1);
	        
	

	        //addEmptyLine(preface, 1);
	        
	  	        
	        
	        
//	        preface.add(new Paragraph(
//	                " Question Paper List ---------------------------------------------------------------------------------------------", smallBold));
//	        
	        addEmptyLine(preface, 1);
	        
	     //   document.add(preface);   // to move to next page
	        
	     //   document.newPage();
	        
	        
	        
	        
	        PdfPTable table = new PdfPTable(3);
	        
	        table.setTotalWidth(new float[]{ 30, 200, 72 });
	        table.setLockedWidth(true);
	        
	        PdfPCell c1 = new PdfPCell(new Phrase("SNo",smallBold));
	    
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);

	        c1 = new PdfPCell(new Phrase("Question Paper Name", smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);

	        c1 = new PdfPCell(new Phrase("Paper Count",smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        
	       
	        
	        table.setHeaderRows(1);
	         PdfPCell r1 = new PdfPCell(new Phrase("1.0",smallfont));
	        int sno = 0;
	        String strNo = new String("");
	        String qPaperName = new String("");
	        String paperCount = new String("");
	        
	        
	        while (iter.hasNext()) {
				String key = iter.next();
				Object val = data.get(key);
				 Map<String, Object> map1 = oMapper.convertValue(val, Map.class);
			
				 
				 sno = sno+1;
				 strNo = String.valueOf(sno);
				 r1 = new PdfPCell(new Phrase(strNo,smallfont));
			     table.addCell(r1);
			     
			     
			     
			    Object dipCodeobj = map1.get("ea_dipcode");
			    if(dipCodeobj!=null) {
			    	qPaperName = dipCodeobj.toString();
			    }
			    r1 = new PdfPCell(new Phrase(qPaperName,smallfont));
			    table.addCell(r1);
			     
			  
			    //3
			    Object ea_nameobj = map1.get("count");
			    if(ea_nameobj!=null) {
			    	paperCount = ea_nameobj.toString();
			    }
			    r1 = new PdfPCell(new Phrase(paperCount,smallfont));
			    table.addCell(r1);
			    

			}
	        
	        preface.add(table);
	        
	        
	        
	        addEmptyLine(preface, 1);


	        document.add(preface);
	 
	         
	    }
	    
	    
	    //Attendance CHART
	  //LETTER applicated
	    private static void addAttendanceChart(Document document, Map input,  Map data)
	            throws DocumentException, Exception {
	    	
	    	
//	    	Object ALsemMonthName =  input.get("ALsemMonthName");
//			Object ALsemYearName =  input.get("ALsemYearName");
//			Object ALexamCenterCode =  input.get("ALexamCenterCode");
//	    	
	 			
			System.out.println(" RESPONSE  LETTER in  AttendanceChart   GOT in DATA MAP -- "+data);
			System.out.println(" RESPONSE  LETTER in  AttendanceChart   GOT in INPUT MAP -- "+input);
			
			
			//rajkumar todo read map

			ObjectMapper oMapper = new ObjectMapper();
			
	   
    	
	        Paragraph preface = new Paragraph();
	   
	        //addEmptyLine(preface, 1);
	        //TODo
	        String sesMonth = new String ("FEB");
			String sesYear = new String("2006");
			//String durationString = new String("SIX MONTHS");
			String durationString = new String("ONE YEAR-PG");
		
	    
	        preface.add(new Paragraph("ATTENDANCE CHART - "+sesMonth+" "+sesYear , catFont));

	        //addEmptyLine(preface, 1);
	        
	  	        
	        preface.add(new Paragraph(
	                " COURSE: ", smallBold));
	        preface.add(new Paragraph(
	                " CENTRE: ", smallBold));
	        preface.add(new Paragraph(
	                " DURATION: ", smallBold));
	       // addEmptyLine(preface, 1);
	        
	        preface.add(new Paragraph(
	                " Paper information ---------------------------------------------------------------------------------------------", smallBold));
	        
	        addEmptyLine(preface, 1);
	        
	        String paperName = new String("");
	        String paperno = new String("");
	        
	        Iterator<String> iter1 = data.keySet().iterator();
	        while (iter1.hasNext()) {
				String key = iter1.next();
				if(key.contains("Paper")) {
					//System.out.println(key);
				Object val = data.get(key);
				 Map<String, Object> map1 = oMapper.convertValue(val, Map.class);
				 
				// dp_paperno
				 
				 Object dp_papernoobj = map1.get("dp_paperno");
				    if(dp_papernoobj!=null) {
				    	paperno = dp_papernoobj.toString();
				    }
	
				 
				 Object dp_paprnamobj = map1.get("dp_paprnam");
				    if(dp_paprnamobj!=null) {
				    	paperName = dp_paprnamobj.toString();
				    }
				    preface.add(new Paragraph(paperno+". "+paperName, smallBold));
				}
			}
	        
	        addEmptyLine(preface, 1);
	        
	        PdfPTable table = null;
	        
	        // If six month
	        
	        if(durationString.equals("SIX MONTHS")) { 
	        	table = new PdfPTable(8);
	        	table.setTotalWidth(new float[]{ 25,72,100,63,63,63,63,63 });
	        	
	        }else {
	        	//System.out.println("Elese column size");
	        	table = new PdfPTable(12);
	        	table.setTotalWidth(new float[]{ 25,72,100,60,30,30,30,30,30,30,30,30 });
	        }
	        table.setLockedWidth(true);
	        
	        PdfPCell c1 = new PdfPCell(new Phrase("SNo",smallBold));
	    
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);

	        c1 = new PdfPCell(new Phrase("P.R.No",smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        
	        c1 = new PdfPCell(new Phrase("Name",smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        
	        c1 = new PdfPCell(new Phrase("Appearing",smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        
	        c1 = new PdfPCell(new Phrase("Paper 1",smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        c1 = new PdfPCell(new Phrase("Paper 2",smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        c1 = new PdfPCell(new Phrase("Paper 3",smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        c1 = new PdfPCell(new Phrase("Paper 4",smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        
	        if(durationString.equals("SIX MONTHS")) {
	        	//System.out.println("if paper head");
		    }else {
		    	 //8
		    	//System.out.println("Elese paper head");
		    	 c1 = new PdfPCell(new Phrase("Paper 5",smallBold));
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(c1);
			    
			    //8
			        c1 = new PdfPCell(new Phrase("Paper 6",smallBold));
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(c1);
			    
			    //9
			        c1 = new PdfPCell(new Phrase("Paper 7",smallBold));
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(c1);
 
			    //10
			        c1 = new PdfPCell(new Phrase("Paper 8",smallBold));
			        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
			        table.addCell(c1);
		    	
		    }
	        
	        table.setHeaderRows(1);
	         PdfPCell r1 = new PdfPCell(new Phrase("1.0",smallfont));
	        int sno = 0;
	        String strNo = new String("");
	        String prCode = new String("");
	        String prNo = new String("");
	        String name = new String("");
	        String paprstring = new String(""); 
	        
	  
	        
	        Iterator<String> iter2 = data.keySet().iterator();
	        while (iter2.hasNext()) {
				String key = iter2.next();
				if(key.contains("appList")) {
					//System.out.println(key);
				Object val = data.get(key);
				 Map<String, Object> map1 = oMapper.convertValue(val, Map.class);
			
				 
				 sno = sno+1;
				 strNo = String.valueOf(sno);
				 r1 = new PdfPCell(new Phrase(strNo,smallfont));
			     table.addCell(r1);
			     
			//2			     
			     Object ea_prcodeobj = map1.get("ea_prcode");
				    if(ea_prcodeobj!=null) {
				    	prCode = ea_prcodeobj.toString();
				    }
				 Object ea_prnoeobj = map1.get("ea_prno");
				   if(ea_prnoeobj!=null) {
					   prNo = ea_prnoeobj.toString();
				   }   
				 
				   prCode = prCode+"\\"+prNo;
				   
			    r1 = new PdfPCell(new Phrase(prCode,smallfont));
			    table.addCell(r1);
			     
			  
			    //3
			    Object ea_nameobj = map1.get("ea_name");
			    if(ea_nameobj!=null) {
			    	name = ea_nameobj.toString();
			    }
			    r1 = new PdfPCell(new Phrase(name,smallfont));
			    table.addCell(r1);
			    
			  //3
			    Object ea_paprstrobj = map1.get("ea_paprstr");
			    if(ea_paprstrobj!=null) {
			    	paprstring = ea_paprstrobj.toString();
			    }
			    r1 = new PdfPCell(new Phrase(paprstring,smallfont));
			    table.addCell(r1);
			    
			    
			  //4
			     r1 = new PdfPCell(new Phrase("",smallfont));
			    table.addCell(r1);
			    
			    //5
			    r1 = new PdfPCell(new Phrase("",smallfont));
			    table.addCell(r1);
			    
			    //6
			    r1 = new PdfPCell(new Phrase("",smallfont));
			    table.addCell(r1);
 
			    //7
			    r1 = new PdfPCell(new Phrase("",smallfont));
			    table.addCell(r1);
			    
			    //if se or more
			    
			    if(durationString.equals("SIX MONTHS")) {
			    	//System.out.println("if paper row");
			    }else {
			    	 //8
			    	//System.out.println("Elese rows");
				     r1 = new PdfPCell(new Phrase("",smallfont));
				    table.addCell(r1);
				    
				    //8
				    r1 = new PdfPCell(new Phrase("",smallfont));
				    table.addCell(r1);
				    
				    //9
				    r1 = new PdfPCell(new Phrase("",smallfont));
				    table.addCell(r1);
	 
				    //10
				    r1 = new PdfPCell(new Phrase("",smallfont));
				    table.addCell(r1);
			    	
			    }
			  
	        }
			}
	        
	        preface.add(table);
	        
	        addEmptyLine(preface, 1);

	        document.add(preface);
	       
	         
	    }


	    
	    //LETTER applicated
	    private static void addApplicantList(Document document, Map input,  Map data)
	            throws DocumentException, Exception {
	
			
			System.out.println(" RESPONSE  LETTER in Applicant list  GOT in DATA MAP -- "+data);
			System.out.println(" RESPONSE  LETTER in Applicant list  GOT in INPUT MAP -- "+input);
			
			
			
			Object ALsemMonthName =  input.get("ALsemMonthName");
			Object ALsemYearName =  input.get("ALsemYearName");
			Object ALexamCenterCode =  input.get("ALexamCenterCode");
			

			ObjectMapper oMapper = new ObjectMapper();
			Iterator<String> iter = data.keySet().iterator();
	   
	        Paragraph preface = new Paragraph();
	   
	    
	        preface.add(new Paragraph("APPLICANTS LIST", catFont));
        
	    	 String sesMonth = new String ("");
	     	 String sesYear = new String("");
	     	 
	        if (ALsemMonthName!=null) {
	        	sesMonth = ALsemMonthName.toString();
	        }
	        
	        if(ALsemYearName!=null) {
	        	 sesYear = ALsemYearName.toString();;
	         }  
	        
	        
	        preface.add(new Paragraph(
	                " List  of applicants for the "+sesMonth+" "+sesYear+" Examination.", smallBold));
	        
	        addEmptyLine(preface, 1);
	        
	        
	        PdfPTable table = new PdfPTable(7);
	        
	        table.setTotalWidth(new float[]{ 25, 72, 72,100,72,72,100 });
	        table.setLockedWidth(true);
	        
	        PdfPCell c1 = new PdfPCell(new Phrase("SNo",smallBold));
	    
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);

	        c1 = new PdfPCell(new Phrase("Dip Code", smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);

	        c1 = new PdfPCell(new Phrase("P.R.No",smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        
	        c1 = new PdfPCell(new Phrase("Name",smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        
	        c1 = new PdfPCell(new Phrase("Centre",smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        c1 = new PdfPCell(new Phrase("Duration",smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        c1 = new PdfPCell(new Phrase("Appearing Papers",smallBold));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        
	        table.setHeaderRows(1);
	         PdfPCell r1 = new PdfPCell(new Phrase("1.0",smallfont));
	        int sno = 0;
	        String strNo = new String("");
	        String dipCode = new String("");
	        String prCode = new String("");
	        String prNo = new String("");
	        String name = new String("");
	        String centername = new String("");
	        String duratin = new String("");
	        String paprstring = new String("");
	        
	        
	        while (iter.hasNext()) {
				String key = iter.next();
				Object val = data.get(key);
				 Map<String, Object> map1 = oMapper.convertValue(val, Map.class);
			
				 
				 sno = sno+1;
				 strNo = String.valueOf(sno);
				 r1 = new PdfPCell(new Phrase(strNo,smallfont));
			     table.addCell(r1);
			     
			     
			     
			    Object dipCodeobj = map1.get("ea_dipcode");
			    if(dipCodeobj!=null) {
			    	dipCode = dipCodeobj.toString();
			    }
			    r1 = new PdfPCell(new Phrase(dipCode,smallfont));
			    table.addCell(r1);
			     
			     
			     
			     Object ea_prcodeobj = map1.get("ea_prcode");
				    if(ea_prcodeobj!=null) {
				    	prCode = ea_prcodeobj.toString();
				    }
				 Object ea_prnoeobj = map1.get("ea_prno");
				   if(ea_prnoeobj!=null) {
					   prNo = ea_prnoeobj.toString();
				   }   
				 
				   prCode = prCode+"\\"+prNo;
				   
			    r1 = new PdfPCell(new Phrase(prCode,smallfont));
			    table.addCell(r1);
			     
			  
			    //4
			    Object ea_nameobj = map1.get("ea_name");
			    if(ea_nameobj!=null) {
			    	name = ea_nameobj.toString();
			    }
			    r1 = new PdfPCell(new Phrase(name,smallfont));
			    table.addCell(r1);
			    
			    
			  //5
			    Object ea_stnameobj = map1.get("ea_stname");
			    if(ea_stnameobj!=null) {
			    	centername = ea_stnameobj.toString();
			    }
			    r1 = new PdfPCell(new Phrase(centername,smallfont));
			    table.addCell(r1);
			    
			    //6
			    Object ea_durtnobj = map1.get("ea_durtn");
			    if(ea_durtnobj!=null) {
			    	duratin = ea_durtnobj.toString();
			    }
			    r1 = new PdfPCell(new Phrase(duratin,smallfont));
			    table.addCell(r1);
			    
			  //7
			    Object ea_paprstrobj = map1.get("ea_paprstr");
			    if(ea_paprstrobj!=null) {
			    	paprstring = ea_paprstrobj.toString();
			    }
			    r1 = new PdfPCell(new Phrase(paprstring,smallfont));
			    table.addCell(r1);
			  

			}
	        
	        preface.add(table);
	        
	        addEmptyLine(preface, 1);

	        document.add(preface);
	         
	    }
	    
	    // for print pdf using itextPDF
	    public String PrintPDF(Map input, Map data) {
	    	String genPDFfile ="c:/temp/FirstPdf.pdf";
	        try {
	        	
	        	
	        	Object action = input.get("action");
	        	System.out.println(" RESPONSE  CALLING PDF generration  ----------------  in prindPDF LETTER = "+action.toString());
	        	System.out.println(" RESPONSE  CALLING PDF generration  -------input---------  in prindPDF LETTER = "+input.toString());
	        	System.out.println(" RESPONSE  CALLING PDF generration  -------data--------  in prindPDF LETTER = "+data.toString());
	            Document document = new Document();
	            PdfWriter.getInstance(document, new FileOutputStream(genPDFfile));
	            document.open();
	            addMetaData(document);
	            addLOGOPage(document); // add the header image
	            
	        
	            
	            
	            // for each Report this has to be changed
	            if (action != null && action.equals("admInit")) {
	            	addAdmInitimationContent(document, input,data);
	            }else if(action != null && action.equals("ackLetter")) {
	            	addAcknowledgeContent(document, input, data);
	            }else if(action != null && action.equals("ansSheet")) {
	            	addAnswerSheetAcknowledge(document, input,data);
	            }else if(action != null && action.equals("hallTck")) {
	            	addHallTicketContent(document, input,data);
	            }else if(action != null && action.equals("mrkSheet")) {
	            	addMarkSheetContent(document, input,data);
	            }else if(action != null && action.equals("diplomaCerti")) {
	            	addDiplomaCertiContent(document, input,data);
	            }
	           	           
	           // addTitlePage(document); // refer for sample
	           // addContent(document); // refer for sample
	            
	            document.close();
	            return genPDFfile;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    // iText allows to add metadata to the PDF which can be viewed in your Adobe
	    // Reader
	    // under File -> Properties
	    private static void addMetaData(Document document) {
	    	
	    	   	    	
	        document.addTitle("AIIMAS");
	        document.addSubject("Aiimas");
	        document.addKeywords("Java, PDF, iText");
	        document.addAuthor("aiimas");
	        document.addCreator("aiimas");
	    }
	    
	    private static void addLOGOPage(Document document)
	            throws DocumentException {
	    try {
	    	
//	    	String imFile = "c:/temp/HEADER1.jpg"; 
//	    	ImageData data = ImageDataFactory.create(imFile); 
//	    	Image image = new Image(data); 
//	    	image.setFixedPosition(100,250); 
//	    	 document.add(image);
//	    	// document.close();
//	         System.out.println("Image Scaled"); 
	        
	        Image img = Image.getInstance("c:/temp/HEADER1.jpg");
	        img.scaleToFit(400,400);
	       // img.setFixedPosition(100,250)
	        //(100,250); 
//	        Image watermark_image = Image.getInstance("abstract(0307).bmp"); 
//	        int i = 0; 
//	        watermark_image.setAbsolutePosition(0, 0);
//	        watermark_image.scaleToFit(826, 1100);
//	        
	        
	        document.add(img);
	      } catch (Exception x) {
	        x.printStackTrace();
	      }
	    }
	    
	    	    	    
	    
	    /// KEEP adding method for each report
	    
	    private static void addAdmInitimationContent(Document document, Map input, Map data)
	            throws DocumentException, Exception {
    	
  
			
			System.out.println(" RESPONSE  LETTER in addAdmInitimationContent input  GOT in MAP -- "+input.toString());
			System.out.println(" RESPONSE  LETTER in addAdmInitimationContent data  GOT in MAP -- "+data.toString());
		//	System.out.println(" RESPONSE  LETTER in addAdmInitimationContent  GOT in MAP -- "+verifyedValues);
			
			
			//kevin
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
			   LocalDateTime now = LocalDateTime.now();  
			   String currentDate= dtf.format(now);
			
			String prCode = new String("");
	        String prNo = new String("");
	        String name = new String("");
	        String duration = new String("");
	        String dipcode = new String("");
	        String dipName = new String("");  // ?
	        String semExamMonth = new String(""); //?
	        String semExamYear = new String(""); //?
	        String examFee = new String("700");
	        String dueDate = new String(""); // admn date
	        String totFee = new String("");
	        String paidAmt = new String("");
	        String balAmt = new String(""); //?
	        String phone = new String("");
	        String email = new String("");
	        String state = new String("");
	        String pincode = new String("");
	        String address1 = new String("");
	        String address2 = new String("");
	        String address3 = new String("");
	        String address4 = new String("");
	        String mobile = new String("");
	        
	        int paintAmtint = 0;
	        int totFeeint =0;
	        int balAmtint= 0;
	        
	        ObjectMapper oMapper = new ObjectMapper();
	        Iterator<String> iter1 = data.keySet().iterator();
	        while (iter1.hasNext()) {
				String key = iter1.next();
				System.out.println(" RAJKUMAR  1" +key);
				if(key.contains("Admin")) {
					
					//System.out.println(key);
					Object val = data.get(key);
					Map<String, Object> map1 = oMapper.convertValue(val, Map.class);
					System.out.println(" RAJKUMAR  2");
				// dp_paperno
				 
				 Object ad_nameoobj = map1.get("ad_name");
				    if(ad_nameoobj!=null) {
				    	name = ad_nameoobj.toString();
				    }
	
				 
				 Object sa_prcodeoobj = map1.get("ad_prcode");
				    if(sa_prcodeoobj!=null) {
				    	prCode = sa_prcodeoobj.toString();
				    }
				    
				 Object sa_prnooobj = map1.get("ad_prno");
				    if(sa_prnooobj!=null) {
				    	prNo = sa_prnooobj.toString();
				    }
				    
				    Object ad_prnoobj = map1.get("ad_feedate");
				    if(ad_prnoobj!=null) {
				    	dueDate = ad_prnoobj.toString();
				    }
				    
				    Object ad_durtn = map1.get("ad_durtn");
				    if(ad_durtn!=null) {
				    	duration = ad_durtn.toString();
				    }
				    Object ad_dipcode = map1.get("ad_dipcode");
				    if(ad_dipcode!=null) {
				    	dipcode = ad_dipcode.toString();
				    }
				    
				    //EXAM or ADMN todo ???
				    Object ad_sesmon = map1.get("ad_sesmon");
				    if(ad_sesmon!=null) {
				    	semExamMonth = ad_sesmon.toString();
				    }
				    Object ad_sesyr = map1.get("ad_sesyr");
				    if(ad_sesyr!=null) {
				    	semExamYear = ad_sesyr.toString();
				    }
				    Object ad_paidamt = map1.get("ad_paidamt");
				    if(ad_paidamt!=null) {
				    	paidAmt = ad_paidamt.toString();
				    	paintAmtint = Integer.parseInt(paidAmt);
				    }
				    Object ad_feeamt = map1.get("ad_feeamt");
				    if(ad_feeamt!=null) {
				    	totFee = ad_feeamt.toString();
				    	totFeeint = Integer.parseInt(totFee);
				    	balAmtint = totFeeint -paintAmtint;
				    	System.out.println(" bal amnt "+balAmtint);
				    }
				    				    
				}else if(key.contains("Address")) {
					
					//System.out.println(key);
					Object val = data.get(key);
					Map<String, Object> map1 = oMapper.convertValue(val, Map.class);
					System.out.println(" RAJKUMAR  Address 2");
				 
					Object sa_phone = map1.get("sa_phone");
				    	if(sa_phone!=null) {
				    	phone = sa_phone.toString();
				    }
	
				 
				    Object sa_email = map1.get("sa_email");
				    if(sa_email!=null) {
				    	email = sa_email.toString();
				    }
				    Object sa_state = map1.get("sa_state");
				    if(sa_state!=null) {
				    	state = sa_state.toString();
				    }
				    Object sa_pincode = map1.get("sa_pincode");
				    if(sa_pincode!=null) {
				    	pincode = sa_pincode.toString();
				    }
				    Object sa_add3 = map1.get("sa_add3");
				    if(sa_add3!=null) {
				    	address3 = sa_add3.toString();
				    }
				    Object sa_add2 = map1.get("sa_add2");
				    if(sa_add2!=null) {
				    	address2 = sa_add2.toString();
				    }
				    Object sa_mobile = map1.get("sa_mobile");
				    if(sa_mobile!=null) {
				    	mobile = sa_mobile.toString();
				    }
				    Object sa_add1 = map1.get("sa_add1");
				    if(sa_add1!=null) {
				    	address1 = sa_add1.toString();
				    }
				    Object sa_add4 = map1.get("sa_add4");
				    if(sa_add4!=null) {
				    	address4 = sa_add4.toString();
				    }
				}// end of address key if
				  
			} // end of date iter
		
	        
	   // GET the DIPMO NAME
	    	
	        MasterTableValues mastable = new MasterTableValues();
	        java.util.List dipdatil = mastable.getDiplomName(dipcode);
	        if(dipdatil !=null && dipdatil.size()>0) {
	        	 Map map1 = (Map)dipdatil.get(0);	
	        	 Object dipname = map1.get("dipname");
			    	if(dipname!=null) {
			    	dipName = dipname.toString();
			    }
	        }
	        
	        
// GET the EXAM SES Month and YEAR    semExamMonth , semExamYear  from exam table public.EAPPL
	    	
	        java.util.List examdatil = mastable.getExamSemDetails(prCode, prNo);
	        if(examdatil !=null && examdatil.size()>0) {
	        	 Map map1 = (Map)examdatil.get(0);	
	        	 Object ea_sesmon = map1.get("ea_sesmon");
			    	if(ea_sesmon!=null) {
			    		semExamMonth = ea_sesmon.toString();
			    }
		    	 Object ea_sesyr = map1.get("ea_sesyr");
			    	if(ea_sesyr!=null) {
			    		semExamYear = ea_sesyr.toString();
			    }
	        }
	        
	        
	        
	        Paragraph preface = new Paragraph();
	        
	        addEmptyLine(preface, 1);
	        // Lets write a big header
	        preface.add(new Paragraph("Admission Intimation", catFont));

	        addEmptyLine(preface, 1);
	   
	        preface.add(new Paragraph(
	                " Date:"+currentDate,smallBold));
	        preface.add(new Paragraph(
	                " Regn.No: "+prCode+"\\"+prNo,smallBold));
	        addEmptyLine(preface, 1);
	        preface.add(new Paragraph(
	                " Dear  "+name,smallBold));
	        preface.add(new Paragraph(
	                "           We are pleased to inform you that you are found eligible for admission in our institute for "+duration+" Diploma course in   ",smallBold));
	        preface.add(new Paragraph(
	                "                                "+dipcode+" - "+dipName,smallBold));
	        addEmptyLine(preface, 1);
	        preface.add(new Paragraph(
	                "           Your Registration number is : "+prCode+" \\ "+prNo,smallBold));
	        addEmptyLine(preface, 1);
	        preface.add(new Paragraph(
	                "            You are advised to quote this number in all your future correspondence with the Institute. ",smallBold));
	        
	        addEmptyLine(preface, 1);
	        preface.add(new Paragraph(
	                "           The course will commence from  "+semExamMonth+" "+semExamYear,smallBold));
	        addEmptyLine(preface, 1);
	   
	        preface.add(new Paragraph(
	                " The Study Materials, Examination Application and Identification certification is sent herewith. Your are advised to fill up the Examination application and affix a passport size photograph in the Identification Certification and return them along with the prescribed examination fee of Rs " +examFee+" in favour of  ALL INDIA INSTITUTE OF MANAGEMENT STUDIES (payble at Chennai ) on or before "+dueDate+" to our office  ",smallBold));
	        preface.add(new Paragraph(
	                " Assuring you our individual attention  ",smallBold));
	        addEmptyLine(preface, 1);
	        preface.add(new Paragraph(
	                " Sincerely yours,  ",smallBold));
	        addEmptyLine(preface, 1);
	        preface.add(new Paragraph(
	                " ASSISTANT DIRECTOR (Administration)  ",smallBold));
	        preface.add(new Paragraph(
	                " Total Fees Rs:"+totFee,smallBold));
	        preface.add(new Paragraph(
	                " Received now Rs: "+paidAmt,smallBold));
	        preface.add(new Paragraph(
	                " Bal.Due  Rs: "+balAmtint,smallBold));
	        addEmptyLine(preface, 1);
	        preface.add(new Paragraph(
	                " "+name,smallBold));
	        preface.add(new Paragraph(
	                " P.R.No: "+prCode+"\\"+prNo,smallBold));
	        preface.add(new Paragraph(
	                " "+address1,smallBold));
	        preface.add(new Paragraph(
	                " "+address2,smallBold));
	        preface.add(new Paragraph(
	                " "+address3,smallBold));
	        preface.add(new Paragraph(
	                " "+address4,smallBold));
	        preface.add(new Paragraph(
	                " "+state,smallBold));
	        preface.add(new Paragraph(
	                " "+pincode,smallBold));
	        preface.add(new Paragraph(
	                " "+mobile,smallBold));
	        preface.add(new Paragraph(
	                " "+phone,smallBold));
	        preface.add(new Paragraph(
	                " "+email,smallBold));
	        
	   
	        document.add(preface);
	        
	    }
	    
	   
	    
	    
	    private static void addAcknowledgeContent(Document document, Map input, Map data)
	            throws DocumentException, Exception{
	    	
			System.out.println(" RESPONSE  LETTER in addAcknowledgeContent input  GOT in MAP -- "+input.toString());
			System.out.println(" RESPONSE  LETTER in addAcknowledgeContent data  GOT in MAP -- "+data.toString());
	    	
	        Paragraph preface = new Paragraph();
	        // We add one empty line
	        addEmptyLine(preface, 1);
	        // Lets write a big header
	        preface.add(new Paragraph("Acknowledgement /Intimation Letter", catFont));

	        addEmptyLine(preface, 1);
	 	   
	        preface.add(new Paragraph(
	                " TODO letter here",smallBold));
	        addEmptyLine(preface, 3);
	       // preface.add(new Paragraph(
	       //         "This document describes something which is very important ",
	       //         smallBold));

	        addEmptyLine(preface, 8);

	        document.add(preface);
	         
	    }
	    
	    
	    //addAnswerSheetAcknowledge(document, input);
	    
	    private static void addAnswerSheetAcknowledge(Document document, Map input, Map data)
	            throws DocumentException, Exception {
	    	
	    	System.out.println(" RESPONSE  LETTER in addAnswerSheetAcknowledge input  GOT in MAP -- "+input.toString());
			System.out.println(" RESPONSE  LETTER in addAnswerSheetAcknowledge data  GOT in MAP -- "+data.toString());
	    	
	    	
	        Paragraph preface = new Paragraph();
	        // We add one empty line
	        addEmptyLine(preface, 1);
	        // Lets write a big header
	        preface.add(new Paragraph("Answer Sheet Acknowledgement Letter", catFont));

	        addEmptyLine(preface, 1);
	 	   
	        preface.add(new Paragraph(
	                " TODO letter here, ", smallBold));
	        addEmptyLine(preface, 3);
	       // preface.add(new Paragraph(
	       //         "This document describes something which is very important ",
	       //         smallBold));

	        addEmptyLine(preface, 8);

	        document.add(preface);
	         
	    }

    	//addHallTicketContent(document, input);  todo
	    
	    private static void addHallTicketContent(Document document, Map input, Map data)
	            throws DocumentException, Exception {
	    	
	    
			
	    	System.out.println(" RESPONSE  LETTER in addHallTicketContent input  GOT in MAP -- "+input.toString());
				System.out.println(" RESPONSE  LETTER in addHallTicketContent data  GOT in MAP -- "+data.toString());
	    	
	        Paragraph preface = new Paragraph();
	        // We add one empty line
	        addEmptyLine(preface, 1);
	        // Lets write a big header
	        preface.add(new Paragraph("Hall Ticket", catFont));

	        addEmptyLine(preface, 1);
	 	   
	        preface.add(new Paragraph(
	                " TODO letter here, ", smallBold));
	        addEmptyLine(preface, 3);
	       // preface.add(new Paragraph(
	       //         "This document describes something which is very important ",
	       //         smallBold));

	        addEmptyLine(preface, 8);

	        document.add(preface);
	         
	    }

    	//addMarkSheetContent(document, input);   TODO
	    
	    private static void addMarkSheetContent(Document document, Map input, Map data)
	            throws DocumentException, Exception {
	    	
			
	    	System.out.println(" RESPONSE  LETTER in addMarkSheetContent input  GOT in MAP -- "+input.toString());
				System.out.println(" RESPONSE  LETTER in addMarkSheetContent data  GOT in MAP -- "+data.toString());
	    	
	    	
	        Paragraph preface = new Paragraph();
	        // We add one empty line
	        addEmptyLine(preface, 1);
	        // Lets write a big header
	        preface.add(new Paragraph("Mark Sheet", catFont));

	        addEmptyLine(preface, 1);
	 	   
	        preface.add(new Paragraph(
	                " TODO letter here, ", smallBold));
	        addEmptyLine(preface, 3);
	       // preface.add(new Paragraph(
	       //         "This document describes something which is very important ",
	       //         smallBold));

	        addEmptyLine(preface, 8);

	        document.add(preface);
	         
	    }
	    
//addDiplomaCertiContent(document, input);   TODO
	    
	    private static void addDiplomaCertiContent(Document document, Map input, Map data)
	            throws DocumentException, Exception {
	    	
	    	System.out.println(" RESPONSE  LETTER in addDiplomaCertiContent input  GOT in MAP -- "+input.toString());
			System.out.println(" RESPONSE  LETTER in addDiplomaCertiContent data  GOT in MAP -- "+data.toString());
	    	
	        Paragraph preface = new Paragraph();
	        // We add one empty line
	        addEmptyLine(preface, 1);
	        // Lets write a big header
	        preface.add(new Paragraph("Mark Sheet", catFont));

	        addEmptyLine(preface, 1);
	 	   
	        preface.add(new Paragraph(
	                " TODO letter here, ", smallBold));
	        addEmptyLine(preface, 3);
	       // preface.add(new Paragraph(
	       //         "This document describes something which is very important ",
	       //         smallBold));

	        addEmptyLine(preface, 8);

	        document.add(preface);
	         
	    }
	    
	    
	    

	    private static void addTitlePage(Document document)
	            throws DocumentException, Exception {
	        Paragraph preface = new Paragraph();
	        // We add one empty line
	        addEmptyLine(preface, 1);
	        // Lets write a big header
	        preface.add(new Paragraph("AIIMAS document", catFont));

	        addEmptyLine(preface, 1);
	        // Will create: Report generated by: _name, _date
	        preface.add(new Paragraph(
	                "Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	                smallBold));
	        addEmptyLine(preface, 3);
	       // preface.add(new Paragraph(
	       //         "This document describes something which is very important ",
	       //         smallBold));

	        addEmptyLine(preface, 8);

	        preface.add(new Paragraph(
	                "This document is a computer generated  no signature required - AIIMAS",
	                redFont));

	        document.add(preface);
	        // Start a new page
	        document.newPage();
	    }

	    private static void addContent(Document document) throws DocumentException {
	        Anchor anchor = new Anchor("First Chapter", catFont);
	        anchor.setName("First Chapter");

	        // Second parameter is the number of the chapter
	        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

	        Paragraph subPara = new Paragraph("Subcategory 1", subFont);
	        Section subCatPart = catPart.addSection(subPara);
	        subCatPart.add(new Paragraph("Hello"));

	        subPara = new Paragraph("Subcategory 2", subFont);
	        subCatPart = catPart.addSection(subPara);
	        subCatPart.add(new Paragraph("Paragraph 1"));
	        subCatPart.add(new Paragraph("Paragraph 2"));
	        subCatPart.add(new Paragraph("Paragraph 3"));

	        // add a list
	        createList(subCatPart);
	        Paragraph paragraph = new Paragraph();
	        addEmptyLine(paragraph, 5);
	        subCatPart.add(paragraph);

	        // add a table
	        createTable(subCatPart);

	        // now add all this to the document
	        document.add(catPart);

	        // Next section
	        anchor = new Anchor("Second Chapter", catFont);
	        anchor.setName("Second Chapter");

	        // Second parameter is the number of the chapter
	        catPart = new Chapter(new Paragraph(anchor), 1);

	        subPara = new Paragraph("Subcategory", subFont);
	        subCatPart = catPart.addSection(subPara);
	        subCatPart.add(new Paragraph("This is a very important message"));

	        // now add all this to the document
	        document.add(catPart);

	    }

	    private static void createTable(Section subCatPart)
	            throws BadElementException {
	        PdfPTable table = new PdfPTable(3);

	        // t.setBorderColor(BaseColor.GRAY);
	        // t.setPadding(4);
	        // t.setSpacing(4);
	        // t.setBorderWidth(1);

	        PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);

	        c1 = new PdfPCell(new Phrase("Table Header 2"));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);

	        c1 = new PdfPCell(new Phrase("Table Header 3"));
	        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        table.addCell(c1);
	        table.setHeaderRows(1);

	        table.addCell("1.0");
	        table.addCell("1.1");
	        table.addCell("1.2");
	        table.addCell("2.1");
	        table.addCell("2.2");
	        table.addCell("2.3");

	        subCatPart.add(table);

	    }

	    private static void createList(Section subCatPart) {
	        List list = new List(true, false, 10);
	        list.add(new ListItem("First point"));
	        list.add(new ListItem("Second point"));
	        list.add(new ListItem("Third point"));
	        subCatPart.add(list);
	    }

	    private static void addEmptyLine(Paragraph paragraph, int number) {
	        for (int i = 0; i < number; i++) {
	            paragraph.add(new Paragraph(" "));
	        }
	    }
	}


