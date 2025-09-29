import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PDFBox {
	public static void main(String[] args) throws IOException {
		splitPDF();
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
	
	public static void loadPDF() throws IOException {
		File original = new File("C:/PDFBoxTest/sample.pdf");
		File updated = new File("C:/PDFBoxTest/sample_updated.pdf");
		
		PDDocument document = Loader.loadPDF(original); //loads original pdf file
		document.addPage(new PDPage()); //add new page
		
		document.save(updated); //save in a new pdf file
		
		document.close();
		
		if(Desktop.isDesktopSupported()) Desktop.getDesktop().open(updated);
	}
	
	public static void splitPDF() throws IOException {
		File original = new File("C:/PDFBoxTest/sample.pdf");
		PDDocument document = Loader.loadPDF(original); //load pdf for splitting
		Splitter splitter = new Splitter();
		
		List<PDDocument> pages = splitter.split(document); //List of pages(after splitting)
		
		int i = 1;
		for (PDDocument page : pages) {
			String filePath = "C:/PDFBoxTest/page" + (i++) + ".pdf";
			File pdfFile = new File(filePath);
			page.save(pdfFile);
			page.close();
		}
		document.close();
		
	}
	
	
}


