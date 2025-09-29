import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PDFBox {
	public static void main(String[] args) throws IOException {
		//createPDF();
	}
	
	public static void createPDF() throws IOException {
		
		//create new folder if don't exists
		File folder = new File("C:/PDFBoxTest/"); 
		if(!folder.exists()) folder.mkdir();
		
		PDDocument document = new PDDocument(); //create new pdf
		PDPage newPage = new PDPage(); //create new page
		document.addPage(newPage); //add page to pdf
		
		
		//save pdf in folder created
		File pdfFile = new File(folder, "test.pdf");
		document.save(pdfFile); 
		
		System.out.println("PDF created");
		
		document.close();
		
		if(Desktop.isDesktopSupported()) Desktop.getDesktop().open(pdfFile); //opens pdf file after creation
	}
}


