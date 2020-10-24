package com.aiimas.util;



	import java.io.FileOutputStream;
	import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.aiimas.dao.PrintView;
import com.aiimas.dao.Verification;
import com.itextpdf.text.Anchor;
	import com.itextpdf.text.BadElementException;
	import com.itextpdf.text.BaseColor;
	import com.itextpdf.text.Chapter;
	import com.itextpdf.text.Document;
	import com.itextpdf.text.DocumentException;
	import com.itextpdf.text.Element;
	import com.itextpdf.text.Font;
	
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
	    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
	            Font.BOLD);
	    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.NORMAL, BaseColor.RED);
	    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
	            Font.BOLD);
	    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
	            Font.BOLD);
	    
	  

	    // for print pdf using itextPDF
	    public String PrintPDF(Map input) {
	    	String genPDFfile ="c:/temp/FirstPdf.pdf";
	        try {
	        	
	        	
	        	Object action = input.get("action");
	        	System.out.println(" RESPONSE  CALLING PDF generration  ----------------  in prindPDF LETTER = "+action.toString());
	            Document document = new Document();
	            PdfWriter.getInstance(document, new FileOutputStream(genPDFfile));
	            document.open();
	            addMetaData(document);
	            addLOGOPage(document); // add the header image
	            
	            
	            // for each Report this has to be changed
	            if (action != null && action.equals("admInit")) {
	            	addAdmInitimationContent(document, input);
	            }else if(action != null && action.equals("ackLetter")) {
	            	addAcknowledgeContent(document, input);
	            }else if(action != null && action.equals("ansSheet")) {
	            	addAnswerSheetAcknowledge(document, input);
	            }else if(action != null && action.equals("hallTck")) {
	            	addHallTicketContent(document, input);
	            }else if(action != null && action.equals("mrkSheet")) {
	            	addMarkSheetContent(document, input);
	            }else if(action != null && action.equals("diplomaCerti")) {
	            	addDiplomaCertiContent(document, input);
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
	    
	    private static void addAdmInitimationContent(Document document, Map input)
	            throws DocumentException, Exception {
    	
	    	// get the required data
	    	PrintView printView = new PrintView();
	    	Map verifyedValues = printView.getAdmInitimationetails(input);
			
			System.out.println(" RESPONSE  LETTER in addAdmInitimationContent  GOT in MAP -- "+verifyedValues);
	    		   
	    	
	        Paragraph preface = new Paragraph();
	        // We add one empty line
	        addEmptyLine(preface, 1);
	        // Lets write a big header
	        preface.add(new Paragraph("Admission Intimation", catFont));

	        addEmptyLine(preface, 1);
	   
	        preface.add(new Paragraph(
	                " TODO letter here,",smallBold));
	        addEmptyLine(preface, 3);
	       // preface.add(new Paragraph(
	       //         "This document describes something which is very important ",
	       //         smallBold));

	        addEmptyLine(preface, 8);

	        document.add(preface);
	        
	    }
	    
	   
	    
	    
	    private static void addAcknowledgeContent(Document document, Map input)
	            throws DocumentException, Exception{
	    	
	    	// get the required data
	    	PrintView printView = new PrintView();
	    	Map verifyedValues = printView.getAcknowledgeContent(input);
	    	
			
			System.out.println(" RESPONSE  LETTER in addAcknowledgeContent  GOT in MAP -- "+verifyedValues);
	    	
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
	    
	    private static void addAnswerSheetAcknowledge(Document document, Map input)
	            throws DocumentException, Exception {
	    	
	    	PrintView printView = new PrintView();
	    	Map verifyedValues = printView.getAnswerSheetAcknowledge(input);
			
			System.out.println(" RESPONSE  LETTER in addAnswerSheetAcknowledge  GOT in MAP -- "+verifyedValues);
	    	
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
	    
	    private static void addHallTicketContent(Document document, Map input)
	            throws DocumentException, Exception {
	    	
	    	PrintView printView = new PrintView();
	    	Map verifyedValues = printView.getHallTicketContent(input);
			
			System.out.println(" RESPONSE  LETTER in addHallTicketContent  GOT in MAP -- "+verifyedValues);
	    	
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
	    
	    private static void addMarkSheetContent(Document document, Map input)
	            throws DocumentException, Exception {
	    	
	    	PrintView printView = new PrintView();
	    	Map verifyedValues = printView.getMarkSheetContent(input);
			
			System.out.println(" RESPONSE  LETTER in addDiplomaCertiContent  GOT in MAP -- "+verifyedValues);
	    	
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
	    
	    private static void addDiplomaCertiContent(Document document, Map input)
	            throws DocumentException, Exception {
	    	
	    	PrintView printView = new PrintView();
	    	Map verifyedValues = printView.getMarkSheetContent(input);
			
			System.out.println(" RESPONSE  LETTER in addDiplomaCertiContent  GOT in MAP -- "+verifyedValues);
	    	
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


