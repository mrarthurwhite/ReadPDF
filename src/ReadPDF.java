
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


import com.snowtide.PDF;
import com.snowtide.pdf.Document;
import com.snowtide.pdf.OutputTarget;
import com.snowtide.pdf.Page;
/**
 * @author SOLON
 * 1. add pdfxstream.jar 
 * 2. add the jar file to the classpath/build path
 * 3. then read the pdf file specifying the file name (here "hello.pdf")
 * 4. then specify an output file name (here hello.txt)
 *
 */
public class ReadPDF {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pdf_filename="hello.pdf";
		File pdfFile= new File(pdf_filename);  // The PDF file from where you would like to extract
		Document pdf = PDF.open(pdfFile);
		File txtFile = new File("hello.txt");
	    Page page = pdf.getPage(0);
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(txtFile)));
		    page.pipe(new OutputTarget(writer));
		    pdf.close();
		    writer.flush();
		    writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
